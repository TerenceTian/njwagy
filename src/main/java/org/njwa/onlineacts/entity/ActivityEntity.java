/**   
* @Title: ActivityEntity.java 
* @Package org.njwa.onlineacts.entity 
* @Description: TODO
* @author Tian
* @date 2015年9月23日 下午3:57:58 
* @version 
*/
package org.njwa.onlineacts.entity;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/** 
* @ClassName: ActivityEntity 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月23日 下午3:57:58 
*  
*/
@Entity
@Table(name = "activities")
public class ActivityEntity implements Serializable, Closeable  {
	
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -1541426377631828825L;
	
	public static final int STATUS_CANCELLED = -1;
	public static final int STATUS_UNDERWAY = 0;
	public static final int STATUS_COMPLETED = 1;
	
	@Id
	@Column(name = "aid")
	@GeneratedValue
	Long aid;

	@Column(name="host_id")
	Long hostId ;
	
	@Column(name="name")
	String name;
	
	@Column(name="description")
	String description ;
	
	@Column(name="url")
	String  url;
	
	@Column(name="hostplace")
	String hostplace ;
	
	@Column(name="add_time")
	Timestamp addTime ;
	
	@Column(name="start_time")
	Timestamp startTime ;
	
	@Column(name="end_time")
	Timestamp endTime ;
	
	@Column(name="bonus_point")
	int bonusPoint ;
	
	@Column(name="max_number")
	int  maxNumber ;
	
	@Column(name="current_number")
	int currentNumber ;
	
	@Column(name="qrcode_id")
	Long qrcodeId ;
	
	@Column(name="status")
	int status ;
	/*
	@OneToMany(targetEntity=UserActivityEntity.class, cascade=CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	//updatable=false很关键，如果没有它，在级联删除的时候就会报错(反转的问题)
	@JoinColumn(name="aid",updatable=false)
	private Set<UserActivityEntity> userActivityEntitySets = new HashSet<UserActivityEntity>();

	public Set<UserActivityEntity> getUserActivityEntitySets() {
		return userActivityEntitySets;
	}

	public void setUserActivityEntitySets(Set<UserActivityEntity> userActivityEntitySets) {
		this.userActivityEntitySets = userActivityEntitySets;
	}*/


	/**
	* (non-Javadoc)
	* @see java.io.Closeable#close()
	*/
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
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
	 * @return the hostId
	 */
	public Long getHostId() {
		return hostId;
	}


	/**
	 * @param hostId the hostId to set
	 */
	public void setHostId(Long hostId) {
		this.hostId = hostId;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}


	/**
	 * @return the hostplace
	 */
	public String getHostplace() {
		return hostplace;
	}


	/**
	 * @param hostplace the hostplace to set
	 */
	public void setHostplace(String hostplace) {
		this.hostplace = hostplace;
	}


	/**
	 * @return the addTime
	 */
	public Timestamp getAddTime() {
		return addTime;
	}


	/**
	 * @param addTime the addTime to set
	 */
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}


	/**
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}


	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}


	/**
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}


	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}


	/**
	 * @return the bonusPoint
	 */
	public int getBonusPoint() {
		return bonusPoint;
	}


	/**
	 * @param bonusPoint the bonusPoint to set
	 */
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}


	/**
	 * @return the maxNumber
	 */
	public int getMaxNumber() {
		return maxNumber;
	}


	/**
	 * @param maxNumber the maxNumber to set
	 */
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}


	/**
	 * @return the currentNumber
	 */
	public int getCurrentNumber() {
		return currentNumber;
	}


	/**
	 * @param currentNumber the currentNumber to set
	 */
	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}


	/**
	 * @return the qrcodeId
	 */
	public Long getQrcodeId() {
		return qrcodeId;
	}


	/**
	 * @param qrcodeId the qrcodeId to set
	 */
	public void setQrcodeId(Long qrcodeId) {
		this.qrcodeId = qrcodeId;
	}


	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

}
