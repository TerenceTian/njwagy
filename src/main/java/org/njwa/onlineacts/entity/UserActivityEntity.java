/**   
* @Title: UserActivityEntity.java 
* @Package org.njwa.onlineacts.entity 
* @Description: TODO
* @author Tian
* @date 2015年9月24日 下午11:12:43 
* @version 
*/
package org.njwa.onlineacts.entity;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** 
* @ClassName: UserActivityEntity 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月24日 下午11:12:43 
*  
*/
@Entity
@Table(name = "user_activity")
public class UserActivityEntity implements Serializable, Closeable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 7707972368852070913L;
	
	public static final int FLAG_ERROR = -2;
	public static final int FLAG_ABSENT = -1;
	public static final int FLAG_NOTJOIN = 0;
	public static final int FLAG_JOINED = 1;
	public static final int FLAG_COMPLETE = 2;

	@Id
	@Column(name = "ua_id")
	@GeneratedValue
	Long userActivityId;

	@Column(name="uid")
	Long uid ;
	
	@Column(name="aid")
	Long aid ;
	
	@Column(name="registration_time")
	Timestamp registrationTime ;
	
	@Column(name="scan_time")
	Timestamp scanTime;
	
	@Column(name="flag")
	int flag = 0;
	/*
	//多对一，@JoinColumn与@column类似，指定映射的数据库字段
	@ManyToOne(targetEntity = ActivityEntity.class)
	@JoinColumn(name="aid",updatable=false)
	private ActivityEntity activity;

	public ActivityEntity getActivity() {
		return activity;
	}

	public void setActivity(ActivityEntity activity) {
		this.activity = activity;
	}*/

	/**
	 * @return the userActivityId
	 */
	public Long getUserActivityId() {
		return userActivityId;
	}






	/**
	 * @param userActivityId the userActivityId to set
	 */
	public void setUserActivityId(Long userActivityId) {
		this.userActivityId = userActivityId;
	}






	/**
	 * @return the uid
	 */
	public Long getUid() {
		return uid;
	}






	/**
	 * @param uid the uid to set
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}






	/**
	 * @return the aid
	 */
	public Long getAid() {
		return aid;
	}






	/**
	 * @param aid the aid to set
	 */
	public void setAid(Long aid) {
		this.aid = aid;
	}






	/**
	 * @return the registrationTime
	 */
	public Timestamp getRegistrationTime() {
		return registrationTime;
	}






	/**
	 * @param registrationTime the registrationTime to set
	 */
	public void setRegistrationTime(Timestamp registrationTime) {
		this.registrationTime = registrationTime;
	}






	/**
	 * @return the scanTime
	 */
	public Timestamp getScanTime() {
		return scanTime;
	}






	/**
	 * @param scanTime the scanTime to set
	 */
	public void setScanTime(Timestamp scanTime) {
		this.scanTime = scanTime;
	}






	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}






	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}






	/**
	* (non-Javadoc)
	* @see java.io.Closeable#close()
	*/
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
