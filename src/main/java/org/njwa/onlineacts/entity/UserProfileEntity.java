/**   
* @Title: UserProfileEntity.java 
* @Package org.njwa.onlineacts.entity 
* @Description: TODO
* @author Tian
* @date 2015年9月23日 上午9:33:01 
* @version 
*/
package org.njwa.onlineacts.entity;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
* @ClassName: UserProfileEntity 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月23日 上午9:33:01 
*  
*/
@Entity
@Table(name = "user_profile")
public class UserProfileEntity implements Serializable, Closeable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -5110955492714230266L;

	public static final int ROLE_USER = 0;
	public static final int ROLE_HOST = 1;
	public static final int ROLE_ADMIN = 2;
	
	@Id
	@Column(name = "uid")
	Long uid;

	@Column(name="nickname")
	String nickname ;

	@Column(name="email")
	String email ;

	@Column(name="phone")
	String phone ;
	
	@Column(name="qq")
	String qq ;
	
	@Column(name="wechat")
	String wechat ;
	
	@Column(name="headimg")
	String headimg ;
	
	@Column(name="point")
	int point = 0;
	
	@Column(name="role")
	int role = 0;
	

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
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}




	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}




	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}




	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}




	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}




	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}




	/**
	 * @return the qq
	 */
	public String getQq() {
		return qq;
	}




	/**
	 * @param qq the qq to set
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}




	/**
	 * @return the wechat
	 */
	public String getWechat() {
		return wechat;
	}




	/**
	 * @param wechat the wechat to set
	 */
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}




	/**
	 * @return the headimg
	 */
	public String getHeadimg() {
		return headimg;
	}




	/**
	 * @param headimg the headimg to set
	 */
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}




	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}




	/**
	 * @param point the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}




	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}




	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
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
