/**   
* @Title: UserManagerImp.java 
* @Package org.njwa.onlineacts.service.imp 
* @Description: TODO
* @author Tian
* @date 2015年9月22日 下午6:54:41 
* @version 
*/
package org.njwa.onlineacts.service.imp;

import org.njwa.onlineacts.dao.UserDAO;
import org.njwa.onlineacts.entity.UserEntity;
import org.njwa.onlineacts.entity.UserProfileEntity;
import org.njwa.onlineacts.service.UserManager;
import org.springframework.transaction.annotation.Transactional;

/** 
* @ClassName: UserManagerImp 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月22日 下午6:54:41 
*  
*/
public class UserManagerImp implements UserManager {

	private UserDAO userDAO;
	
	private UserProfileEntity userProfile;
	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.service.UserManager#addUser(org.njwa.onlineacts.entity.UserEntity)
	*/
	@Override
	@Transactional
	public boolean addUser(UserEntity user) {
		// TODO Auto-generated method stub
		if(userDAO.addUser(user)){
			userProfile = new UserProfileEntity();
			userProfile.setUid(user.getUid());
			if(userDAO.addUserProfile(userProfile))
				return true;
		}
		return false;
	}

	@Override
	@Transactional
	public UserEntity getUser(Long uid) {
		// TODO Auto-generated method stub
		UserEntity user = userDAO.getUserByUid(uid);
		return user;
	}

	@Override
	@Transactional
	public  UserEntity login(UserEntity user) {
		// TODO Auto-generated method stub
		String password = user.getPassword();
		user = userDAO.getUserByUsername(user.getUsername());
		if(user != null && user.getPassword().equals(password))
			return user;
		return null;
	}
		/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.service.UserManager#getUserProfile(java.lang.Long)
	*/
	@Override
	@Transactional
	public UserProfileEntity getUserProfile(Long uid) {
		// TODO Auto-generated method stub
		userProfile = userDAO.getUserProfileByUid(uid);
		return userProfile;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.service.UserManager#updateUserProfile(org.njwa.onlineacts.entity.UserProfileEntity)
	*/
	@Override
	@Transactional
	public boolean updateUserProfile(UserProfileEntity newUserProfile) {
		// TODO Auto-generated method stub
		UserProfileEntity userOldProfile = getUserProfile(newUserProfile.getUid());
		userOldProfile.setEmail(newUserProfile.getEmail());
		userOldProfile.setHeadimg(newUserProfile.getHeadimg());
		userOldProfile.setNickname(newUserProfile.getNickname());
		userOldProfile.setPhone(newUserProfile.getPhone());
		userOldProfile.setQq(newUserProfile.getQq());
		userOldProfile.setWechat(newUserProfile.getWechat());
		userDAO.updateUserProfile(userOldProfile);
		return false;
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.service.UserManager#changePassword(java.lang.Long, java.lang.String, java.lang.String)
	*/
	@Override
	@Transactional
	public boolean changePassword(Long uid, String newPassword, String oldPassword) {
		// TODO Auto-generated method stub
		UserEntity user = this.getUser(uid);
		if(user.getPassword().equals(oldPassword)){
			user.setPassword(newPassword);
			boolean isUpdate = userDAO.updateUser(user);
		}
		return false;
	}
}
