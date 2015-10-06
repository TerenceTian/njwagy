/**   
* @Title: AdminDAO.java 
* @Package org.njwa.onlineacts.dao 
* @Description: TODO
* @author Tian
* @date 2015年9月26日 下午9:06:30 
* @version 
*/
package org.njwa.onlineacts.dao;

import java.util.List;

import org.njwa.onlineacts.entity.UserProfileEntity;

/** 
* @ClassName: AdminDAO 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月26日 下午9:06:30 
*  
*/
public interface AdminDAO {

	/** 
	* @Title: getUserListByRole 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param roleHost
	* @param @return    设定文件 
	* @return List<UserProfileEntity>    返回类型 
	* @throws 
	*/
	List<UserProfileEntity> getUserListByRole(int role);

	/** 
	* @Title: updateUserProfileRole 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param uid
	* @param @param role
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	boolean updateUserProfileRole(Long uid, int role);

}
