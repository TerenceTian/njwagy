/**   
* @Title: UserEntity.java 
* @Package org.njwa.onlineacts.entity 
* @Description: TODO
* @author Tian
* @date 2015年9月22日 下午6:35:35 
* @version 
*/
package org.njwa.onlineacts.entity;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
* @ClassName: UserEntity 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月22日 下午6:35:35 
*  
*/

@Entity
@Table(name = "users")
public class UserEntity implements Serializable, Closeable {

	

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -3978742091200949590L;

	@Id
	@Column(name = "uid")
	@GeneratedValue
	Long uid;

	@Column(name="username")
	String username ;

	@Column(name="password")
	String password ;

	@Column(name="wechat_id")
	String wechatId ;
	
	
	
	
	
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}





	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}





	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}





	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}





	/**
	 * @return the wechatId
	 */
	public String getWechatId() {
		return wechatId;
	}





	/**
	 * @param wechatId the wechatId to set
	 */
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
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
