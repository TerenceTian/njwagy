/**   
* @Title: UserDAOImp.java 
* @Package org.njwa.onlineacts.dao.imp 
* @Description: TODO
* @author Tian
* @date 2015年9月22日 下午7:03:34 
* @version 
*/
package org.njwa.onlineacts.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.njwa.onlineacts.dao.UserDAO;
import org.njwa.onlineacts.entity.UserEntity;
import org.njwa.onlineacts.entity.UserProfileEntity;
import org.springframework.stereotype.Repository;


/** 
* @ClassName: UserDAOImp 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月22日 下午7:03:34 
*  
*/
@Repository
public class UserDAOImp implements UserDAO {

	private SessionFactory sessionFactory;
	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.UserDAO#addUser(org.njwa.onlineacts.entity.UserEntity)
	*/
	@Override
	public boolean addUser(UserEntity user) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(user);

		return true;
	}
	
	
	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.UserDAO#getUserByUid(java.lang.Long)
	*/
	@Override
	public UserEntity getUserByUid(Long uid) {
		// TODO Auto-generated method stub
		UserEntity user = (UserEntity) sessionFactory.getCurrentSession().get(UserEntity.class, uid);
		return user;
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.UserDAO#getUserByUsername(java.lang.String)
	*/
	@Override
	public UserEntity getUserByUsername(String username) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("from UserEntity where username = :username");
		query.setString("username", username);
		List<UserEntity> userList = query.list();
		if (userList.size() == 1)
			return userList.get(0);
		return null;
	}
	
	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.UserDAO#getUserProfileByUid(java.lang.Long)
	*/
	@Override
	public UserProfileEntity getUserProfileByUid(Long uid) {
		// TODO Auto-generated method stub
		return  (UserProfileEntity) sessionFactory.getCurrentSession().get(UserProfileEntity.class, uid);
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.UserDAO#addUserProfile(org.njwa.onlineacts.entity.UserProfileEntity)
	*/
	@Override
	public boolean addUserProfile(UserProfileEntity userProfile) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(userProfile);
		return true;
	}
	

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.UserDAO#updateUserProfile(org.njwa.onlineacts.entity.UserProfileEntity)
	*/
	@Override
	public boolean updateUserProfile(UserProfileEntity userProfile) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(userProfile);
		return false;
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.UserDAO#updateUser(org.njwa.onlineacts.entity.UserEntity)
	*/
	@Override
	public boolean updateUser(UserEntity user) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(user);
		return false;
	}



}
