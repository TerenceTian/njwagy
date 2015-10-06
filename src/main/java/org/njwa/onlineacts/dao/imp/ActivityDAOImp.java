/**   
* @Title: ActivityDAOImp.java 
* @Package org.njwa.onlineacts.dao.imp 
* @Description: TODO
* @author Tian
* @date 2015年9月23日 下午4:43:54 
* @version 
*/
package org.njwa.onlineacts.dao.imp;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.njwa.onlineacts.dao.ActivityDAO;
import org.njwa.onlineacts.entity.ActivityEntity;
import org.njwa.onlineacts.entity.QRCodeEntity;
import org.njwa.onlineacts.entity.UserActivityEntity;
import org.njwa.onlineacts.entity.UserEntity;
import org.njwa.onlineacts.entity.UserProfileEntity;
import org.springframework.stereotype.Repository;

/** 
* @ClassName: ActivityDAOImp 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月23日 下午4:43:54 
*  
*/
@Repository
public class ActivityDAOImp implements ActivityDAO {
	
	private SessionFactory sessionFactory;
	

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#addActivity(org.njwa.onlineacts.entity.ActivityEntity)
	*/
	@Override
	public long addActivity(ActivityEntity activity) {
		// TODO Auto-generated method stub
		
		return (long) this.sessionFactory.getCurrentSession().save(activity);
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#getAllActivities()
	*/
	@SuppressWarnings("unchecked")
	@Override
	public List<ActivityEntity> getAllActivities() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from ActivityEntity").list();
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#getActivityDetailById(java.lang.Long)
	*/
	@Override
	public ActivityEntity getActivityDetailById(Long aid) {
		// TODO Auto-generated method stub
		return (ActivityEntity)this.sessionFactory.getCurrentSession().get(ActivityEntity.class, aid);
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#getActivityJoinedUsersByAid(java.lang.Long)
	*/
	@Override
	public List<UserActivityEntity> getActivityJoinedUsersByAid(Long aid) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("from UserActivityEntity where aid = :aid");
		query.setLong("aid", aid);
		@SuppressWarnings("unchecked")
		List<UserActivityEntity> userActivitylist = query.list();
		if (userActivitylist.size() > 0)
			return userActivitylist;
		return null;
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#addUserActivity(org.njwa.onlineacts.entity.UserActivityEntity)
	*/
	@Override
	public boolean addUserActivity(UserActivityEntity userActivity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(userActivity);
		return true;
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#deleteUserActivity(java.lang.Long, java.lang.Long)
	*/
	@Override
	public boolean deleteUserActivity(Long aid, Long uid) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("delete UserActivityEntity where aid = :aid and uid = :uid");
		query.setLong("aid", aid);
		query.setLong("uid", uid);
		query.executeUpdate();
		return true;
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#getUserActivities(java.lang.Long)
	*/
	@Override
	public List<Object[]> getUserActivities(Long uid) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("select a,ua from ActivityEntity a,UserActivityEntity ua where ua.uid=:uid and ua.aid=a.aid");
		query.setLong("uid", uid);
		@SuppressWarnings("unchecked")
		List<Object[]> objectSets = query.list();
		return objectSets;
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#getActivityParticipant(java.lang.Long)
	*/
	@Override
	public List<Object[]> getActivityParticipant(Long aid) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("select up,ua from UserProfileEntity up, UserActivityEntity ua where ua.aid = :aid and up.uid = ua.uid");
		query.setLong("aid", aid);
		@SuppressWarnings("unchecked")
		List<Object[]> objectSets = query.list();
		return objectSets;
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#getActivityQRCodeByAid(java.lang.Long)
	*/
	@Override
	public QRCodeEntity getActivityQRCodeByAid(Long aid) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("from QRCodeEntity where aid = :aid");
		query.setLong("aid", aid);
		@SuppressWarnings("unchecked")
		List<QRCodeEntity> activityQRCodelist = query.list();
		if (activityQRCodelist.size() > 0)
			return activityQRCodelist.get(0);
		return null;
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#updateActivity(org.njwa.onlineacts.entity.ActivityEntity)
	*/
	@Override
	public boolean updateActivity(ActivityEntity activity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(activity);
		return true;
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#getActivityDetailByTicketId(java.lang.String)
	*/
	@Override
	public QRCodeEntity getActivityDetailByTicketId(String scanResult) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from QRCodeEntity where ticket = :ticket_id");
		query.setString("ticket_id", scanResult);
		@SuppressWarnings("unchecked")
		List<QRCodeEntity> activityQRCodelist = query.list();
		if (activityQRCodelist.size() > 0)
			return activityQRCodelist.get(0);
		return null;
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#getUserActivityByAidUid(java.lang.Long, java.lang.Long)
	*/
	@Override
	public UserActivityEntity getUserActivityByAidUid(Long aid, Long uid) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("from UserActivityEntity where aid = :aid and uid = :uid");
		query.setLong("aid", aid);
		query.setLong("uid", uid);
		@SuppressWarnings("unchecked")
		List<UserActivityEntity> userActivitylist = query.list();
		if (userActivitylist.size() > 0)
			return userActivitylist.get(0);
		return null;
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#updateUserActivity(org.njwa.onlineacts.entity.UserActivityEntity)
	*/
	@Override
	public boolean updateUserActivity(UserActivityEntity existUserActivity) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(existUserActivity);
		return true;
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#getAllQRCodes()
	*/
	@SuppressWarnings("unchecked")
	@Override
	public List<QRCodeEntity> getAllQRCodes() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from QRCodeEntity").list();
	}


	/**
	* (non-Javadoc)
	* @see org.njwa.onlineacts.dao.ActivityDAO#addActivityQRCode(org.njwa.onlineacts.entity.QRCodeEntity)
	*/
	@Override
	public boolean addActivityQRCode(QRCodeEntity newQRCode) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(newQRCode);
		return false;
	}


}
