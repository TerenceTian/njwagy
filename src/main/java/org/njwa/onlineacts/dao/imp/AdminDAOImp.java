/**   
* @Title: AdminDAOImp.java 
* @Package org.njwa.onlineacts.dao.imp 
* @Description: TODO
* @author Tian
* @date 2015年9月26日 下午9:07:12 
* @version 
*/
package org.njwa.onlineacts.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.njwa.onlineacts.dao.AdminDAO;
import org.njwa.onlineacts.entity.UserEntity;
import org.njwa.onlineacts.entity.UserProfileEntity;

/** 
* @ClassName: AdminDAOImp 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月26日 下午9:07:12 
*  
*/
public class AdminDAOImp implements AdminDAO {
	private SessionFactory sessionFactory;
	

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.AdminDAO#getUserListByRole(int)
	*/
	@Override
	public List<UserProfileEntity> getUserListByRole(int role) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("from UserProfileEntity where role = :role");
		query.setLong("role", role);
		@SuppressWarnings("unchecked")
		List<UserProfileEntity> userProfileList = query.list();
		if (userProfileList.size() > 0)
			return userProfileList;
		return null;
	}

	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.AdminDAO#updateUserProfileRole(java.lang.Long, int)
	*/
	@Override
	public boolean updateUserProfileRole(Long uid, int role) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("update UserProfileEntity up set up.role=:role where up.uid=:uid");
		query.setLong("role", role);
		query.setLong("uid", uid);
		
		if(query.executeUpdate() > 0)
			return true;
		return false;
	}
	
	
}
