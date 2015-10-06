/**   
* @Title: AccessToken.java 
* @Package person.tianye.wechat.entity 
* @Description: TODO
* @author Tian
* @date 2015年10月1日 下午9:40:29 
* @version 
*/
package person.tianye.wechat.entity;

import java.sql.Timestamp;

/** 
* @ClassName: AccessToken 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年10月1日 下午9:40:29 
*  
*/
public class AccessToken {
	public static String RESULT_INDEX_ACCESSTOKEN = "access_token";
	public static String RESULT_INDEX_ERRORCODE = "errcode";
	public static String RESULT_INDEX_EXPRIREIN = "expires_in";
	public static String RESULT_INDEX_TICKET = "ticket";
	
	private String accessToken ="";
	private String jsApiTicket = "";
	private long expire;
	private long generateTime;
	
	
	
	
	
	/**
	 * @return the jsApiTicket
	 */
	public String getJsApiTicket() {
		return jsApiTicket;
	}
	/**
	 * @param jsApiTicket the jsApiTicket to set
	 */
	public void setJsApiTicket(String jsApiTicket) {
		this.jsApiTicket = jsApiTicket;
	}
	/**
	 * @return the generateTime
	 */
	public long getGenerateTime() {
		return generateTime;
	}
	/**
	 * @param generateTime the generateTime to set
	 */
	public void setGenerateTime(long generateTime) {
		this.generateTime = generateTime;
	}
	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	/**
	 * @return the expire
	 */
	public long getExpire() {
		return expire;
	}
	/**
	 * @param expire the expire to set
	 */
	public void setExpire(long expire) {
		this.expire = expire;
	}
	
}
