/**   
* @Title: UserDAO.java 
* @Package org.njwa.onlineacts.dao 
* @Description: TODO
* @author Tian
* @date 2015年9月22日 下午7:01:00 
* @version 
*/
package org.njwa.onlineacts.dao;

import org.njwa.onlineacts.entity.UserEntity;
import org.njwa.onlineacts.entity.UserProfileEntity;

/** 
* @ClassName: UserDAO 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月22日 下午7:01:00 
*  
*/
public interface UserDAO {

	/** 
	* @Title: addUser 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param user    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public boolean addUser(UserEntity user);

	/** 
	* @Title: getUserByUid 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param uid
	* @param @return    设定文件 
	* @return UserEntity    返回类型 
	* @throws 
	*/
	public UserEntity getUserByUid(Long uid);

	/** 
	* @Title: getUserByUsername 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param username
	* @param @return    设定文件 
	* @return UserEntity    返回类型 
	* @throws 
	*/
	public UserEntity getUserByUsername(String username);

	/** 
	* @Title: getUserProfileByUid 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param uid
	* @param @return    设定文件 
	* @return UserProfileEntity    返回类型 
	* @throws 
	*/
	public UserProfileEntity getUserProfileByUid(Long uid);

	/** 
	* @Title: addUserProfile 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userProfile
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	public boolean addUserProfile(UserProfileEntity userProfile);

	/** 
	* @Title: updateUserProfile 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userProfile    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	public boolean updateUserProfile(UserProfileEntity userProfile);

	/** 
	* @Title: updateUser 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param user
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	public boolean updateUser(UserEntity user);

	/** 
	* @Title: changePassword 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param uid
	* @param @param newPassword
	* @param @param oldPassword    设定文件 
	* @return void    返回类型 
	* @throws 
	*/

}
