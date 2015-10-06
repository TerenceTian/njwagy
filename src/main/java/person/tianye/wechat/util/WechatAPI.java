/**   
* @Title: WechatAPI.java 
* @Package person.tianye.wechat.util 
* @Description: TODO
* @author Tian
* @date 2015年10月1日 下午9:43:09 
* @version 
*/
package person.tianye.wechat.util;

import org.springframework.beans.factory.annotation.Autowired;

import person.tianye.wechat.conf.WechatConfigure;

/** 
* @ClassName: WechatAPI 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年10月1日 下午9:43:09 
*  
*/
public class WechatAPI {
	@Autowired
	private WechatConfigure wechatConf;
	
	public String getAccessTokenStr(){
		String httpResult = "";
		try {
			httpResult = HttpRequestor.doGet(wechatConf.getWechatAccesstokenurl()+"appid="+wechatConf.getWechatAppid()+"&secret="+wechatConf.getWechatAppsecret());			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return httpResult;
	}
	/**
	 * @param wechatConf the wechatConf to set
	 */
	public void setWechatConf(WechatConfigure wechatConf) {
		this.wechatConf = wechatConf;
	}
	/** 
	* @Title: getJsApiTicketStr 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param accessToken
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public String getJsApiTicketStr(String accessToken) {
		String httpResult = "";
		try {
			httpResult = HttpRequestor.doGet(wechatConf.getWechatJsApiTicket()+accessToken);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return httpResult;
	}
	
	public String getAppId(){
		return wechatConf.getWechatAppid();
	}
	/** 
	* @Title: getTemporaryQRCode 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param accessToken
	* @param @param sceneId
	* @param @param seconds
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public String getTemporaryQRCode(String accessToken, long sceneId, long seconds) {
		String httpResult = "";
		String data = "{\"expire_seconds\": "+ seconds +", \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+ sceneId +"}}}";
		try {
			httpResult = HttpRequestor.doPost(wechatConf.getWechatGenerateqrcod()+accessToken, null, data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return httpResult;
	}
	/** 
	* @Title: getPermanentQRCode 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param accessToken
	* @param @param sceneId
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public String getPermanentQRCode(String accessToken, long sceneId) {
		String httpResult = "";
		String data = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+sceneId+"}}}";
		try {
			httpResult = HttpRequestor.doPost(wechatConf.getWechatGenerateqrcod()+accessToken, null, data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return httpResult;
	}
	/** 
	* @Title: getQRCodeUrlByTicket 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ticket
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public String getQRCodeUrlByTicket(String ticket) {
		// TODO Auto-generated method stub
		return (wechatConf.getWechatQrcodepicurl()+ticket);
	}
}