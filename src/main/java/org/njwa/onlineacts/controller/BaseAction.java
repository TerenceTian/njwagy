/**   
* @Title: BaseAction.java 
* @Package org.njwa.onlineacts.controller 
* @Description: TODO
* @author Tian
* @date 2015年9月24日 下午10:30:34 
* @version 
*/
package org.njwa.onlineacts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.njwa.onlineacts.entity.UserEntity;
import org.njwa.onlineacts.entity.UserProfileEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/** 
* @ClassName: BaseAction 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月24日 下午10:30:34 
*  
*/
public class BaseAction extends ActionSupport implements Preparable {

	/**
	* (non-Javadoc)
	* @see com.opensymphony.xwork2.Preparable#prepare()
	*/
	public static final String loginUserSessionKey = "loginUser";
	
	public static final String loginUserProfileKey = "loginUserProfile";
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	protected UserEntity user;
	
	protected UserProfileEntity userProfile;
	
	/**
	 * @return the user
	 */
	public UserEntity getUser() {
		return user;
	}
	
	/**
	 * @param user
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	/**
	 * @return the userProfile
	 */
	public UserProfileEntity getUserProfile() {
		return userProfile;
	}
	/**
	 * @param userProfile the userProfile to set
	 */
	public void setUserProfile(UserProfileEntity userProfile) {
		this.userProfile = userProfile;
	}

	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		response = (HttpServletResponse) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		request = (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	}

}
