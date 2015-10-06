/**   
* @Title: WechatManager.java 
* @Package person.tianye.wechat.service 
* @Description: TODO
* @author Tian
* @date 2015年10月1日 下午9:22:03 
* @version 
*/
package person.tianye.wechat.service;

import java.util.Map;

/** 
* @ClassName: WechatManager 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年10月1日 下午9:22:03 
*  
*/
public interface WechatManager {
	public String getAccessToken();
	public String getJsApiTicket();
	public String[] generateQRcode(long sceneId, long seconds);
	public String getQRCodePicUrl(String ticket);
	public Map<String, String> getJsSignature(String currentUrl);
}
