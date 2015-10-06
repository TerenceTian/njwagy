/**   
* @Title: ActivityManager.java 
* @Package org.njwa.onlineacts.service 
* @Description: TODO
* @author Tian
* @date 2015年9月22日 下午6:48:33 
* @version 
*/
package org.njwa.onlineacts.service;

import java.util.List;

import org.njwa.onlineacts.entity.ActivityEntity;
import org.njwa.onlineacts.entity.QRCodeEntity;
import org.njwa.onlineacts.entity.UserActivityEntity;
import org.njwa.onlineacts.entity.UserEntity;

/** 
* @ClassName: ActivityManager 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月22日 下午6:48:33 
*  
*/
public interface ActivityManager {

	/** 
	* @Title: addActivity 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param activity
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	boolean addActivity(ActivityEntity activity);

	/** 
	* @Title: getAllActivities 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<ActivityEntity>    返回类型 
	* @throws 
	*/
	List<ActivityEntity> getAllActivities();

	/** 
	* @Title: getActivityDetailById 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param aid
	* @param @return    设定文件 
	* @return ActivityEntity    返回类型 
	* @throws 
	*/
	ActivityEntity getActivityDetailById(Long aid);

	/** 
	* @Title: getActivityJoinedUsersByAid 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param aid
	* @param @return    设定文件 
	* @return List<UserActivityEntity>    返回类型 
	* @throws 
	*/
	List<UserActivityEntity> getActivityJoinedUsersByAid(Long aid);

	/** 
	* @Title: checkUserJoinStatus 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param aid
	* @param @param uid
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws 
	*/
	int checkUserJoinStatus(Long aid, Long uid);

	/** 
	* @Title: userActivityStatusChange 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param aid
	* @param @param uid
	* @param @param flagJoined
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	boolean userActivityStatusChange(Long aid, Long uid, int aimFlag);

	/** 
	* @Title: combineActivityUserStatus 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param activity
	* @param @param joinStatus
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws 
	*/
	int combineActivityUserStatus(ActivityEntity activity, int joinStatus);

	/** 
	* @Title: getUserActivityListByUid 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param uid
	* @param @return    设定文件 
	* @return List<ActivityEntity>    返回类型 
	* @throws 
	*/
	List<Object[]> getUserActivityListByUid(Long uid);

	/** 
	* @Title: getActivityParticipant 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param aid
	* @param @return    设定文件 
	* @return List<Object []>    返回类型 
	* @throws 
	*/
	List<Object[]> getActivityParticipant(Long aid);

	/** 
	* @Title: getActivityQRCodeByAid 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param aid
	* @param @return    设定文件 
	* @return QRCodeEntity    返回类型 
	* @throws 
	*/
	QRCodeEntity getActivityQRCodeByAid(Long aid);

	/** 
	* @Title: userScanSign 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param user
	* @param @param scanResult
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	boolean userScanSign(UserEntity user, String scanResult);
	
	boolean allocateQRCode(ActivityEntity activity);

}
