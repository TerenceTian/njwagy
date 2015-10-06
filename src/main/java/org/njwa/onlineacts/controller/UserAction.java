/**   
* @Title: UserAction.java 
* @Package org.njwa.onlineacts.controller 
* @Description: TODO
* @author Tian
* @date 2015年9月22日 下午5:56:46 
* @version 
*/
package org.njwa.onlineacts.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.njwa.onlineacts.entity.UserEntity;
import org.njwa.onlineacts.service.UserManager;
import com.opensymphony.xwork2.Preparable;

import person.tianye.wechat.service.WechatManager;

/**
 * @ClassName: UserAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Tian
 * @date 2015年9月22日 下午5:56:46
 * 
 */
public class UserAction extends BaseAction implements Preparable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = 7947102020801469387L;

	private static final Logger logger = Logger.getLogger(UserAction.class);

	private UserManager userManager;
	
	private WechatManager wechatManager;
	
	private Map<String, String> jsSdkSignatureMap;
	
	private String oldPassword;
	private String newPassword;
	private String newPassword2;
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */

	public String userRegist() {
		logger.info("userRegist method called");
		boolean isRegist = userManager.addUser(user);
		if (isRegist)
			return SUCCESS;
		return ERROR;
	}

	public String userLogin() {
		logger.info("userLogin method called");
		
		user = userManager.login(user);
		if (user != null) {
			request.getSession().setAttribute(loginUserSessionKey, user);
			request.getSession().setAttribute(loginUserProfileKey, userManager.getUserProfile(user.getUid()));
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String userLogout(){
		logger.info("userLogout method called");
		user  = (UserEntity) request.getSession().getAttribute(loginUserSessionKey);
		if (user != null) {
			request.getSession().setAttribute(loginUserSessionKey, null);
			request.getSession().setAttribute(loginUserProfileKey, null);
			return SUCCESS;
		}
		return SUCCESS;
	}
	
	public String isUserLogged(){
		logger.info("userLogin method called");
		user  = (UserEntity) request.getSession().getAttribute(loginUserSessionKey);
		if(user != null){
			userProfile = userManager.getUserProfile(user.getUid());
			return SUCCESS;
		}
		return ERROR;
	}

	public String viewUserProfile() {
		logger.info("viewUserProfile method called");
		user = (UserEntity) request.getSession().getAttribute(loginUserSessionKey);
		if(user != null){
			userProfile = userManager.getUserProfile(user.getUid());
			request.getSession().setAttribute(loginUserProfileKey, userProfile);
			jsSdkSignatureMap = wechatManager.getJsSignature(request.getRequestURL().toString());
		}
		return SUCCESS;
	}

	public String editUserProfile() {
		logger.info("editUserProfile method called");
		if(userProfile != null){
			userProfile.setUid(((UserEntity) request.getSession().getAttribute(loginUserSessionKey)).getUid());
			userManager.updateUserProfile(userProfile);
		}
		return SUCCESS;
	}

	public String changePassword() {
		logger.info("changePassword method called");
		if(newPassword.equals(newPassword2)){
			user = (UserEntity) request.getSession().getAttribute(loginUserSessionKey);
			boolean isChange = userManager.changePassword(user.getUid(), newPassword, oldPassword);
		}
		
		return SUCCESS;
	}

	
	
	
	
	
	
	
	
	/**
	 * @param userManager
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}



	/**
	 * @return the jsSdkSignatureMap
	 */
	public Map<String, String> getJsSdkSignatureMap() {
		return jsSdkSignatureMap;
	}

	/**
	 * @param wechatManager the wechatManager to set
	 */
	public void setWechatManager(WechatManager wechatManager) {
		this.wechatManager = wechatManager;
	}

	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @param newPassword2 the newPassword2 to set
	 */
	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		user = null;
		userProfile= null;
		super.prepare();
	}

}
