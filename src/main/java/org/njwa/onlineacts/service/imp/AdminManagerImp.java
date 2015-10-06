/**   
* @Title: AdminManagerImp.java 
* @Package org.njwa.onlineacts.service.imp 
* @Description: TODO
* @author Tian
* @date 2015年9月26日 下午9:05:13 
* @version 
*/
package org.njwa.onlineacts.service.imp;

import java.util.List;

import org.njwa.onlineacts.dao.AdminDAO;
import org.njwa.onlineacts.dao.UserDAO;
import org.njwa.onlineacts.entity.UserEntity;
import org.njwa.onlineacts.entity.UserProfileEntity;
import org.njwa.onlineacts.service.AdminManager;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: AdminManagerImp
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Tian
 * @date 2015年9月26日 下午9:05:13
 * 
 */
public class AdminManagerImp implements AdminManager {
	
	private AdminDAO adminDAO;
	
	private UserDAO userDAO;
	
	
	
	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	/**
	 * @param adminDAO
	 *            the adminDAO to set
	 */
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	/**
	 * (non-Javadoc)
	 * 
	 * @see org.njwa.onlineacts.service.AdminManager#getHostList()
	 */
	@Override
	@Transactional
	public List<UserProfileEntity> getHostList() {
		// TODO Auto-generated method stub
		return adminDAO.getUserListByRole(UserProfileEntity.ROLE_HOST);
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.service.AdminManager#addHost(java.lang.String)
	*/
	@Override
	@Transactional
	public boolean addHost(String username) {
		// TODO Auto-generated method stub
		UserEntity user = userDAO.getUserByUsername(username);
		boolean isUpdate = false;
		if(user != null){
			UserProfileEntity userProfile = userDAO.getUserProfileByUid(user.getUid());
			if(userProfile.getRole() == 0)
				isUpdate = this.updateUserRole(user.getUid(), UserProfileEntity.ROLE_HOST);
		}
		return isUpdate;
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.service.AdminManager#deleteHost(java.lang.Long)
	*/
	@Override
	@Transactional
	public boolean deleteHost(Long uid) {
		// TODO Auto-generated method stub
		boolean isUpdate = this.updateUserRole(uid, UserProfileEntity.ROLE_USER);
		return isUpdate;
	}
	
	@Transactional
	private boolean updateUserRole(Long uid, int role){
		boolean isUpdate = adminDAO.updateUserProfileRole(uid,role);
		return false;
		
	}

}
