/**   
* @Title: ActivityAction.java 
* @Package org.njwa.onlineacts.controller 
* @Description: TODO
* @author Tian
* @date 2015年9月22日 下午6:46:10 
* @version 
*/
package org.njwa.onlineacts.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.njwa.onlineacts.entity.ActivityEntity;
import org.njwa.onlineacts.entity.QRCodeEntity;
import org.njwa.onlineacts.entity.UserActivityEntity;
import org.njwa.onlineacts.entity.UserEntity;
import org.njwa.onlineacts.entity.UserProfileEntity;
import org.njwa.onlineacts.service.ActivityManager;

import com.opensymphony.xwork2.Preparable;

import person.tianye.wechat.service.WechatManager;

/** 
* @ClassName: ActivityAction 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月22日 下午6:46:10 
*  
*/
public class ActivityAction extends BaseAction implements Preparable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	
	private static final long serialVersionUID = -8718584800217696244L;
	
	private static final Logger logger = Logger.getLogger(ActivityAction.class);
	
	private ActivityEntity activity;
	
	private QRCodeEntity qrCode;
	
	private List<ActivityEntity> activityList;
	
	private List<UserActivityEntity> userActivityList;
	
	private List<UserProfileEntity> userProfileList;
	
	private ActivityManager activityManager;
	
	private WechatManager wechatManager;
	
	private int joinStatus = 0;
	
	private String scanResult;
	/**
	* (non-Javadoc)
	* @see com.opensymphony.xwork2.Preparable#prepare()
	*/
	public String addActivity(){
		logger.info("addActivity method called");
		UserEntity user = (UserEntity) request.getSession().getAttribute(loginUserSessionKey);
		activity.setHostId(user.getUid());
		boolean isAdd = activityManager.addActivity(activity);
		return SUCCESS;
	}
	
	public String viewActivityList(){
		logger.info("getActivityList method called");
		activityList = activityManager.getAllActivities();
		return SUCCESS;
	}
	
	public String getActivityDetail(){
		logger.info("getActivityDetail method called");
		activity = activityManager.getActivityDetailById(activity.getAid());
		
		if(user != null){
			joinStatus = activityManager.checkUserJoinStatus(activity.getAid(), user.getUid());
			userProfile = (UserProfileEntity) request.getSession().getAttribute(loginUserProfileKey);
		}
		joinStatus = activityManager.combineActivityUserStatus(activity, joinStatus);
		
		return SUCCESS;
	}
	
	public String userJoinActivity(){
		logger.info("userJoinActivity method called");
		if(user != null){
			boolean isSucess = activityManager.userActivityStatusChange(activity.getAid(), user.getUid(), UserActivityEntity.FLAG_JOINED);
		}
		return SUCCESS;
	}
	
	public String userCancelActivity(){
		logger.info("userCancelActivity method called");
		if(user != null){
			boolean isSucess = activityManager.userActivityStatusChange(activity.getAid(), user.getUid(), UserActivityEntity.FLAG_NOTJOIN);
		}
		return SUCCESS;
	}
	
	public String viewUserActivityList(){
		logger.info("viewUserActivityList method called");
		if(user != null){
			List<Object[]> actUserActSets = activityManager.getUserActivityListByUid(user.getUid());
			activityList = new ArrayList<ActivityEntity>();
			userActivityList = new ArrayList<UserActivityEntity>();
			for(int i =0; i < actUserActSets.size(); i++){
				activityList.add(i, (ActivityEntity) actUserActSets.get(i)[0]);
				userActivityList.add(i, (UserActivityEntity) actUserActSets.get(i)[1]);
			}
		}
		return SUCCESS;
	}
	
	public String viewActivityParticipant(){
		logger.info("viewActivityParticipant method called");
		List<Object[]> userProfileStatusSets = activityManager.getActivityParticipant(activity.getAid());
		
		userProfileList = new ArrayList<UserProfileEntity>();
		userActivityList = new ArrayList<UserActivityEntity>();
		for(int i =0; i < userProfileStatusSets.size(); i++){
			userProfileList.add(i, (UserProfileEntity) userProfileStatusSets.get(i)[0]);
			userActivityList.add(i, (UserActivityEntity) userProfileStatusSets.get(i)[1]);
		}
		return SUCCESS;
	}
	
	public String viewActivityQRCode(){
		qrCode = activityManager.getActivityQRCodeByAid(activity.getAid());
		if(qrCode !=null)
			qrCode.setUrl(wechatManager.getQRCodePicUrl(qrCode.getTicket()));
		return SUCCESS;
	}
	
	public String scanQRCode(){
		scanResult = "";
		boolean isSigned = activityManager.userScanSign(user, scanResult);
		return SUCCESS;
	}
	

	
	
	
	
	

	/**
	 * @param scanResult the scanResult to set
	 */
	public void setScanResult(String scanResult) {
		this.scanResult = scanResult;
	}

	/**
	 * @return the qrCode
	 */
	public QRCodeEntity getQrCode() {
		return qrCode;
	}

	/**
	 * @return the userProfileList
	 */
	public List<UserProfileEntity> getUserProfileList() {
		return userProfileList;
	}

	/**
	 * @return the userActivityList
	 */
	public List<UserActivityEntity> getUserActivityList() {
		return userActivityList;
	}

	/**
	 * @return the joinStatus
	 */
	public int getJoinStatus() {
		return joinStatus;
	}

	/**
	 * @return the activity
	 */
	public ActivityEntity getActivity() {
		return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(ActivityEntity activity) {
		this.activity = activity;
	}

	/**
	 * @param activityList the activityList to set
	 */
	public void setActivityList(List<ActivityEntity> activityList) {
		this.activityList = activityList;
	}

	/**
	 * @return the activityList
	 */
	public List<ActivityEntity> getActivityList() {
		return activityList;
	}

	/**
	 * @param activityManager the activityManager to set
	 */
	public void setActivityManager(ActivityManager activityManager) {
		this.activityManager = activityManager;
	}
	
	

	/**
	 * @param wechatManager the wechatManager to set
	 */
	public void setWechatManager(WechatManager wechatManager) {
		this.wechatManager = wechatManager;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		activity = null;
		activityList = null;
		userActivityList = null;
		qrCode = null;
		scanResult = "";
		super.prepare();
		user = (UserEntity) request.getSession().getAttribute(loginUserSessionKey);
	}
}
