/**   
* @Title: AdminAction.java 
* @Package org.njwa.onlineacts.controller 
* @Description: TODO
* @author Tian
* @date 2015年9月25日 上午11:43:15 
* @version 
*/
package org.njwa.onlineacts.controller;

import java.util.List;

import org.njwa.onlineacts.entity.UserProfileEntity;
import org.njwa.onlineacts.service.AdminManager;

import com.opensymphony.xwork2.Preparable;

/** 
* @ClassName: AdminAction 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月25日 上午11:43:15 
*  
*/
public class AdminAction extends BaseAction implements Preparable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -5239394811730375618L;
	
	private List<UserProfileEntity> hostList;
	
	private AdminManager adminManager;

	/**
	* (non-Javadoc)
	* @see com.opensymphony.xwork2.Preparable#prepare()
	*/
	
	public String viewHostList(){
		hostList = adminManager.getHostList();
		return SUCCESS;
	}
	
	public String addHost(){
		boolean isAdd = adminManager.addHost(user.getUsername());
		return SUCCESS;
	}
	
	public String deleteHost(){
		boolean isDel = adminManager.deleteHost(user.getUid());
		return SUCCESS;
	}
	
	/**
	 * @return the hostList
	 */
	public List<UserProfileEntity> getHostList() {
		return hostList;
	}


	/**
	 * @param adminManager the adminManager to set
	 */
	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}


	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		hostList = null;
		super.prepare();
	}

}
