/**   
* @Title: UserManager.java 
* @Package org.njwa.onlineacts.service 
* @Description: TODO
* @author Tian
* @date 2015年9月22日 下午6:48:20 
* @version 
*/
package org.njwa.onlineacts.service;

import org.njwa.onlineacts.entity.UserEntity;
import org.njwa.onlineacts.entity.UserProfileEntity;

/** 
* @ClassName: UserManager 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月22日 下午6:48:20 
*  
*/
public interface UserManager {
	public boolean addUser(UserEntity user) ;
	
	public UserEntity getUser(Long uid);

	/** 
	* @Title: login 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param user
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	public UserEntity login(UserEntity user);

	/** 
	* @Title: getUserProfile 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param uid
	* @param @return    设定文件 
	* @return UserProfileEntity    返回类型 
	* @throws 
	*/
	public UserProfileEntity getUserProfile(Long uid);

	/** 
	* @Title: updateUserProfile 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userProfile
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws 
	*/
	public boolean updateUserProfile(UserProfileEntity userProfile);

	/** 
	* @Title: changePassword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param uid
	* @param @param newPassword
	* @param @param oldPassword
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	public boolean changePassword(Long uid, String newPassword, String oldPassword);
}
