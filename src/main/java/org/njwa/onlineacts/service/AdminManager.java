/**   
* @Title: AdminManager.java 
* @Package org.njwa.onlineacts.service 
* @Description: TODO
* @author Tian
* @date 2015年9月26日 下午9:04:40 
* @version 
*/
package org.njwa.onlineacts.service;

import java.util.List;

import org.njwa.onlineacts.entity.UserProfileEntity;

/** 
* @ClassName: AdminManager 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月26日 下午9:04:40 
*  
*/
public interface AdminManager {

	/** 
	* @Title: getHostList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<UserProfileEntity>    返回类型 
	* @throws 
	*/
	List<UserProfileEntity> getHostList();

	/** 
	* @Title: addHost 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param username
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	boolean addHost(String username);

	/** 
	* @Title: deleteHost 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param uid
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws 
	*/
	boolean deleteHost(Long uid);

}
