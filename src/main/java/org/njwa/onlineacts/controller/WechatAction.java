/**   
* @Title: WechatAction.java 
* @Package org.njwa.onlineacts.controller 
* @Description: TODO
* @author Tian
* @date 2015年9月22日 下午4:41:03 
* @version 
*/
package org.njwa.onlineacts.controller;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import person.tianye.wechat.service.WechatManager;

/** 
* @ClassName: WechatAction 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年9月22日 下午4:41:03 
*  
*/
public class WechatAction extends BaseAction implements Preparable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -6403296481131701506L;
	
	private static final Logger logger = Logger.getLogger(WechatAction.class);

	private WechatManager wechatManager;
	
	public String Test(){
		System.out.println(wechatManager.getAccessToken());
		System.out.println(wechatManager.getJsApiTicket());
		System.out.println(request.getRequestURL());
		Map<String, String> ret = wechatManager.getJsSignature(request.getRequestURL().toString());
		for (Map.Entry entry : ret.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
		return null;
	}
	
	public String getJsSignature(){
		
		return null;
		
	}
	
	@Override
	public String execute() throws Exception {
		// 获取请求和响应
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String result = "";
		OutputStream os = response.getOutputStream();
		BufferedWriter resBr = new BufferedWriter(new OutputStreamWriter(os));
		resBr.write(result);
		resBr.flush();
		resBr.close();
		return null;
	}
	
	
	
	/**
	 * @param wechatManager the wechatManager to set
	 */
	public void setWechatManager(WechatManager wechatManager) {
		this.wechatManager = wechatManager;
	}

	/**
	* (non-Javadoc)
	* @see com.opensymphony.xwork2.Preparable#prepare()
	*/
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		super.prepare();
	}

}
