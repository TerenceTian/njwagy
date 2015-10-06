/**   
* @Title: QRCodeEntity.java 
* @Package org.njwa.onlineacts.entity 
* @Description: TODO
* @author Tian
* @date 2015年9月26日 下午8:46:07 
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
import javax.persistence.Table;

/** 
* @ClassName: QRCodeEntity 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月26日 下午8:46:07 
*  
*/
@Entity
@Table(name = "qrcodes")
public class QRCodeEntity implements Serializable, Closeable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 4261548669974143610L;

	@Id
	@Column(name = "qid")
	@GeneratedValue
	Long qid;

	@Column(name="is_permanent")
	int isPermanent ;
	
	@Column(name="aid")
	Long aid ;
	
	@Column(name="generate_time")
	Timestamp generateTime ;
	
	@Column(name="failure_time")
	Timestamp failureTime ;
	
	@Column(name="scene_id")
	long sceneId ;
	
	@Column(name="ticket")
	String ticket ;
	
	@Column(name="url")
	String url ;
	
	
	/**
	 * @return the qid
	 */
	public Long getQid() {
		return qid;
	}


	/**
	 * @param qid the qid to set
	 */
	public void setQid(Long qid) {
		this.qid = qid;
	}


	/**
	 * @return the isPermanent
	 */
	public int getIsPermanent() {
		return isPermanent;
	}


	/**
	 * @param isPermanent the isPermanent to set
	 */
	public void setIsPermanent(int isPermanent) {
		this.isPermanent = isPermanent;
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
	 * @return the generateTime
	 */
	public Timestamp getGenerateTime() {
		return generateTime;
	}


	/**
	 * @param generateTime the generateTime to set
	 */
	public void setGenerateTime(Timestamp generateTime) {
		this.generateTime = generateTime;
	}


	/**
	 * @return the failureTime
	 */
	public Timestamp getFailureTime() {
		return failureTime;
	}


	/**
	 * @param failureTime the failureTime to set
	 */
	public void setFailureTime(Timestamp failureTime) {
		this.failureTime = failureTime;
	}


	/**
	 * @return the sceneId
	 */
	public long getSceneId() {
		return sceneId;
	}


	/**
	 * @param sceneId the sceneId to set
	 */
	public void setSceneId(long sceneId) {
		this.sceneId = sceneId;
	}


	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}


	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
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
	* (non-Javadoc)
	* @see java.io.Closeable#close()
	*/
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
