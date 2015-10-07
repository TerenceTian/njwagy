/**   
* @Title: ActivityManagerImp.java 
* @Package org.njwa.onlineacts.service.imp 
* @Description: TODO
* @author Tian
* @date 2015年9月23日 下午4:40:00 
* @version 
*/
package org.njwa.onlineacts.service.imp;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.njwa.onlineacts.dao.ActivityDAO;
import org.njwa.onlineacts.dao.UserDAO;
import org.njwa.onlineacts.entity.ActivityEntity;
import org.njwa.onlineacts.entity.QRCodeEntity;
import org.njwa.onlineacts.entity.UserActivityEntity;
import org.njwa.onlineacts.entity.UserEntity;
import org.njwa.onlineacts.entity.UserProfileEntity;
import org.njwa.onlineacts.service.ActivityManager;
import org.springframework.transaction.annotation.Transactional;

import person.tianye.wechat.service.WechatManager;

/**
 * @ClassName: ActivityManagerImp
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Tian
 * @date 2015年9月23日 下午4:40:00
 * 
 */
public class ActivityManagerImp implements ActivityManager {

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.njwa.onlineacts.service.ActivityManager#addActivity(org.njwa.onlineacts.entity.ActivityEntity)
	 */
	private ActivityDAO activityDAO;
	
	private UserDAO userDAO;

	private WechatManager wechatManager;
	
	/**
	 * @param wechatManager the wechatManager to set
	 */
	public void setWechatManager(WechatManager wechatManager) {
		this.wechatManager = wechatManager;
	}
	
	

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}



	/**
	 * @param activityDAO
	 *            the activityDAO to set
	 */
	public void setActivityDAO(ActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

	@Override
	@Transactional
	public boolean addActivity(ActivityEntity activity) {
		// TODO Auto-generated method stub
		long aid = activityDAO.addActivity(activity);
		activity.setAid(aid);
		this.allocateQRCode(activity);
		return true;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.njwa.onlineacts.service.ActivityManager#getAllActivities()
	 */
	@Override
	@Transactional
	public List<ActivityEntity> getAllActivities() {
		// TODO Auto-generated method stub
		return activityDAO.getAllActivities();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.njwa.onlineacts.service.ActivityManager#getActivityDetailById(java.lang.Long)
	 */
	@Override
	@Transactional
	public ActivityEntity getActivityDetailById(Long aid) {
		// TODO Auto-generated method stub
		return activityDAO.getActivityDetailById(aid);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.njwa.onlineacts.service.ActivityManager#getActivityJoinedUsersByAid(java.lang.Long)
	 */
	@Override
	@Transactional
	public List<UserActivityEntity> getActivityJoinedUsersByAid(Long aid) {
		// TODO Auto-generated method stub
		return activityDAO.getActivityJoinedUsersByAid(aid);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.njwa.onlineacts.service.ActivityManager#checkUserJoinStatus(java.lang.Long,
	 *      java.lang.Long)
	 */
	@Override
	@Transactional
	public int checkUserJoinStatus(Long aid, Long uid) {
		// TODO Auto-generated method stub
		List<UserActivityEntity> userActivityList = this.getActivityJoinedUsersByAid(aid);
		
		if (userActivityList != null) {
			Iterator<UserActivityEntity> userActivityIto = userActivityList.iterator();
			while (userActivityIto.hasNext()) {
				UserActivityEntity userActivity = userActivityIto.next();
				if (userActivity.getUid() == uid)
					return userActivity.getFlag();
			}
		}
		return 0;
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.service.ActivityManager#userActivityStatusChange(java.lang.Long, java.lang.Long, int)
	*/
	@Override
	@Transactional
	public boolean userActivityStatusChange(Long aid, Long uid, int aimFlag) {
		// TODO Auto-generated method stub
		boolean isSucess = true;
		switch(aimFlag){
		case UserActivityEntity.FLAG_ABSENT:
			UserActivityEntity existUserActivity2 = activityDAO.getUserActivityByAidUid(aid, uid);
			existUserActivity2.setFlag(UserActivityEntity.FLAG_ABSENT);
			isSucess = activityDAO.updateUserActivity(existUserActivity2);
			break;
		case UserActivityEntity.FLAG_COMPLETE:
			UserActivityEntity existUserActivity = activityDAO.getUserActivityByAidUid(aid, uid);
			existUserActivity.setScanTime(new Timestamp(System.currentTimeMillis()));
			existUserActivity.setFlag(UserActivityEntity.FLAG_COMPLETE);
			isSucess = activityDAO.updateUserActivity(existUserActivity);
			//add bonus point for this user
			if(isSucess){
				recalculateUserPoint(uid);
			}else{
				isSucess = false;
			}
			break;
		case UserActivityEntity.FLAG_JOINED:
			if (this.checkRemainQuota(aid)) {
				UserActivityEntity userActivity = new UserActivityEntity();
				userActivity.setAid(aid);
				userActivity.setUid(uid);
				userActivity.setFlag(aimFlag);
				userActivity.setRegistrationTime(new Timestamp(System.currentTimeMillis()));
				isSucess = activityDAO.addUserActivity(userActivity);
				this.recalculateQuota(aid);
			}
			break;
		case UserActivityEntity.FLAG_NOTJOIN:
			isSucess = activityDAO.deleteUserActivity(aid, uid);
			this.recalculateQuota(aid);
			break;
		}
		return isSucess;
	}

	/** 
	* @Title: recalculateUserPoint 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param uid    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	@Transactional
	private void recalculateUserPoint(Long uid) {
		// TODO Auto-generated method stub
		List<Object[]> activityList = activityDAO.getUserActivities(uid);
		int totalPoint = 0;
		for(int i = 0; i <activityList.size(); i++){
			ActivityEntity activity = (ActivityEntity)(activityList.get(i)[0]);
			UserActivityEntity userActivity = (UserActivityEntity)(activityList.get(i)[1]);
			if(userActivity.getFlag() == UserActivityEntity.FLAG_COMPLETE)
				totalPoint += activity.getBonusPoint();
		}
		UserProfileEntity userProfile  = userDAO.getUserProfileByUid(uid);
		userProfile.setPoint(totalPoint);
		userDAO.updateUserProfile(userProfile);
	
	}

	/** 
	* @Title: recalculateQuota 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param aid    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	@Transactional
	private void recalculateQuota(Long aid) {
		// TODO Auto-generated method stub
		List<UserActivityEntity> joinedUserList = this.getActivityJoinedUsersByAid(aid);
		ActivityEntity activity = this.getActivityDetailById(aid);
		if(joinedUserList != null)
			activity.setCurrentNumber(joinedUserList.size());
		activity.setCurrentNumber(0);
		boolean isUpdate = activityDAO.updateActivity(activity);
	}

	/** 
	* @Title: checkRemainQuota 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param aid
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	private synchronized boolean checkRemainQuota(Long aid) {
		// TODO Auto-generated method stub
		ActivityEntity activity = this.getActivityDetailById(aid);
		if(activity.getMaxNumber() -activity.getCurrentNumber() > 0)		
			return true;
		return false;
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.service.ActivityManager#combineActivityUserStatus(org.njwa.onlineacts.entity.ActivityEntity, int)
	*/
	@Override
	public int combineActivityUserStatus(ActivityEntity activity, int joinStatus) {
		// TODO Auto-generated method stub
		switch(activity.getStatus()){
		case ActivityEntity.STATUS_CANCELLED:
			if(joinStatus != UserActivityEntity.FLAG_JOINED)
				joinStatus = UserActivityEntity.FLAG_ERROR;
			break;
		case ActivityEntity.STATUS_COMPLETED:
			if(joinStatus == UserActivityEntity.FLAG_NOTJOIN)
				joinStatus = UserActivityEntity.FLAG_ERROR;
			break;
		case ActivityEntity.STATUS_UNDERWAY:
			break;
		}
		return joinStatus;
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.service.ActivityManager#getUserActivityListByUid(java.lang.Long)
	*/
	@Override
	@Transactional
	public List<Object[]> getUserActivityListByUid(Long uid) {
		// TODO Auto-generated method stub
		return activityDAO.getUserActivities(uid);
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.service.ActivityManager#getActivityParticipant(java.lang.Long)
	*/
	@Override
	@Transactional
	public List<Object[]> getActivityParticipant(Long aid) {
		// TODO Auto-generated method stub
		return activityDAO.getActivityParticipant(aid);
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.service.ActivityManager#getActivityQRCodeByAid(java.lang.Long)
	*/
	@Override
	@Transactional
	public QRCodeEntity getActivityQRCodeByAid(Long aid) {
		// TODO Auto-generated method stub
		return activityDAO.getActivityQRCodeByAid(aid);
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.service.ActivityManager#userScanSign(org.njwa.onlineacts.entity.UserEntity, java.lang.String)
	*/
	@Override
	@Transactional
	public boolean userScanSign(UserEntity user, String scanResult) {
		// TODO Auto-generated method stub
		QRCodeEntity qrCode = activityDAO.getActivityDetailByTicketId(scanResult);
		if(qrCode != null){
			if(qrCode.getGenerateTime().getTime()<= System.currentTimeMillis() && System.currentTimeMillis() <= qrCode.getFailureTime().getTime()){
				List<UserActivityEntity> joinList = getActivityJoinedUsersByAid(qrCode.getAid());
				if(joinList != null){
					Iterator<UserActivityEntity> joinListIto = joinList.iterator();
					while(joinListIto.hasNext()){
						UserActivityEntity userActivity = joinListIto.next();
						if(userActivity.getUid() == user.getUid() && userActivity.getFlag() != UserActivityEntity.FLAG_JOINED){
							userActivityStatusChange(qrCode.getAid(),user.getUid(),UserActivityEntity.FLAG_COMPLETE);
							return true;
						}
					}
				}
				userActivityStatusChange(qrCode.getAid(),user.getUid(),UserActivityEntity.FLAG_JOINED);
				userActivityStatusChange(qrCode.getAid(),user.getUid(),UserActivityEntity.FLAG_COMPLETE);
				return true;
			}			
		}
		return false;
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.service.ActivityManager#allocateQRCode(org.njwa.onlineacts.entity.QRCodeEntity)
	*/
	@Override
	@Transactional
	public boolean allocateQRCode(ActivityEntity activity) {
		// TODO Auto-generated method stub
		QRCodeEntity newQRCode = new QRCodeEntity();
		newQRCode.setAid(activity.getAid());
		newQRCode.setGenerateTime(new Timestamp(activity.getStartTime().getTime() - 1000*60*60*6));//提前6小时生效
		newQRCode.setFailureTime(activity.getEndTime());
		if(activity.getEndTime().getTime() - activity.getStartTime().getTime() >= 1000*60*60*24*7){
			newQRCode.setIsPermanent(1);
		}else{
			newQRCode.setIsPermanent(0);
		}
		List<QRCodeEntity> qrCodeList = activityDAO.getAllQRCodes();
		if(qrCodeList.size() == 0){
			newQRCode.setSceneId(1);
		}else{
			long maxSceneId = 1l;
			Iterator<QRCodeEntity> qrCodeIto = qrCodeList.iterator();
			while(qrCodeIto.hasNext()){
				QRCodeEntity qrCode = qrCodeIto.next();
				if(qrCode.getSceneId() > maxSceneId)
					maxSceneId = qrCode.getSceneId();
			}
			newQRCode.setSceneId(maxSceneId+1);
		}
		
		String[] ticketUrl ;
		if(newQRCode.getIsPermanent() == 1){
			ticketUrl = wechatManager.generateQRcode(newQRCode.getSceneId(), 0);
		}else{
			ticketUrl = wechatManager.generateQRcode(newQRCode.getSceneId(), (newQRCode.getFailureTime().getTime() - newQRCode.getGenerateTime().getTime() +1000*60*60*6)/1000 );
		}
		newQRCode.setTicket(ticketUrl[0]);
		newQRCode.setUrl(ticketUrl[1]);
		boolean isAdd = activityDAO.addActivityQRCode(newQRCode);
		return true;
	}

}
