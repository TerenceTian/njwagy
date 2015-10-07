/**   
* @Title: ActivityDAO.java 
* @Package org.njwa.onlineacts.dao 
* @Description: TODO
* @author Tian
* @date 2015年9月23日 下午4:42:46 
* @version 
*/
package org.njwa.onlineacts.dao;

import java.util.List;

import org.njwa.onlineacts.entity.ActivityEntity;
import org.njwa.onlineacts.entity.QRCodeEntity;
import org.njwa.onlineacts.entity.UserActivityEntity;

/** 
* @ClassName: ActivityDAO 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月23日 下午4:42:46 
*  
*/
public interface ActivityDAO {

	/** 
	* @Title: addActivity 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param activity
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	long addActivity(ActivityEntity activity);

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
	* @Title: addUserActivity 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userActivity
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	boolean addUserActivity(UserActivityEntity userActivity);

	/** 
	* @Title: deleteUserActivity 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param aid
	* @param @param uid
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	boolean deleteUserActivity(Long aid, Long uid);

	/** 
	* @Title: getUserActivities 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param uid
	* @param @return    Activity, UserActivity 
	* @return List<ActivityEntity>    返回类型 
	* @throws 
	*/
	List<Object[]> getUserActivities(Long uid);

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
	* @Title: updateActivity 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param activity
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	boolean updateActivity(ActivityEntity activity);

	/** 
	* @Title: getActivityDetailByTicketId 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param scanResult
	* @param @return    设定文件 
	* @return QRCodeEntity    返回类型 
	* @throws 
	*/
	QRCodeEntity getActivityDetailByTicketId(String scanResult);

	/** 
	* @Title: getUserActivityByAidUid 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param aid
	* @param @param uid
	* @param @return    设定文件 
	* @return UserActivityEntity    返回类型 
	* @throws 
	*/
	UserActivityEntity getUserActivityByAidUid(Long aid, Long uid);

	/** 
	* @Title: updateUserActivity 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param existUserActivity
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	boolean updateUserActivity(UserActivityEntity existUserActivity);

	/** 
	* @Title: getAllQRCodes 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<QRCodeEntity>    返回类型 
	* @throws 
	*/
	List<QRCodeEntity> getAllQRCodes();

	/** 
	* @Title: addActivityQRCode 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param newQRCode
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	boolean addActivityQRCode(QRCodeEntity newQRCode);

	/** 
	* @Title: addUserActivity 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param aid
	* @param @param uid
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/

}
