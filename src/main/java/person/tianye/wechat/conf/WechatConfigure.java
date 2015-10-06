/**   
* @Title: WechatConfigure.java 
* @Package person.tianye.wechat.conf 
* @Description: TODO
* @author Tian
* @date 2015年10月1日 下午9:24:37 
* @version 
*/
package person.tianye.wechat.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 
* @ClassName: WechatConfigure 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年10月1日 下午9:24:37 
*  
*/
@Component("configInfo")
public class WechatConfigure {

		@Value("${wechat.validDebug}")
		private String wechatValidDebug;
		@Value("${wechat.token}")
		private String wechatToken;
		@Value("${wechat.appid}")
		private String wechatAppid;
		@Value("${wechat.appsecret}")
		private String wechatAppsecret;
		@Value("${wechat.encodingaeskey}")
		private String wechatEncodingaeskey;
		@Value("${wechat.accesstokenexpires}")
		private String wechatAccesstokenexpires;
		@Value("${wechat.accesstokenurl}")
		private String wechatAccesstokenurl;
		@Value("${wechat.jsapiticketurl}")
		private String wechatJsApiTicket;
		@Value("${wechat.createmenu}")
		private String wechatCreatemenu;
		@Value("${wechat.generateqrcode}")
		private String wechatGenerateqrcod;
		@Value("${wechat.qrcodepicurl}")
		private String wechatQrcodepicurl;
		/**
		 * @return the wechatValidDebug
		 */
		public String getWechatValidDebug() {
			return wechatValidDebug;
		}
		/**
		 * @param wechatValidDebug the wechatValidDebug to set
		 */
		public void setWechatValidDebug(String wechatValidDebug) {
			this.wechatValidDebug = wechatValidDebug;
		}
		/**
		 * @return the wechatToken
		 */
		public String getWechatToken() {
			return wechatToken;
		}
		/**
		 * @param wechatToken the wechatToken to set
		 */
		public void setWechatToken(String wechatToken) {
			this.wechatToken = wechatToken;
		}
		/**
		 * @return the wechatAppid
		 */
		public String getWechatAppid() {
			return wechatAppid;
		}
		/**
		 * @param wechatAppid the wechatAppid to set
		 */
		public void setWechatAppid(String wechatAppid) {
			this.wechatAppid = wechatAppid;
		}
		/**
		 * @return the wechatAppsecret
		 */
		public String getWechatAppsecret() {
			return wechatAppsecret;
		}
		/**
		 * @param wechatAppsecret the wechatAppsecret to set
		 */
		public void setWechatAppsecret(String wechatAppsecret) {
			this.wechatAppsecret = wechatAppsecret;
		}
		/**
		 * @return the wechatEncodingaeskey
		 */
		public String getWechatEncodingaeskey() {
			return wechatEncodingaeskey;
		}
		/**
		 * @param wechatEncodingaeskey the wechatEncodingaeskey to set
		 */
		public void setWechatEncodingaeskey(String wechatEncodingaeskey) {
			this.wechatEncodingaeskey = wechatEncodingaeskey;
		}
		/**
		 * @return the wechatAccesstokenexpires
		 */
		public String getWechatAccesstokenexpires() {
			return wechatAccesstokenexpires;
		}
		/**
		 * @param wechatAccesstokenexpires the wechatAccesstokenexpires to set
		 */
		public void setWechatAccesstokenexpires(String wechatAccesstokenexpires) {
			this.wechatAccesstokenexpires = wechatAccesstokenexpires;
		}
		/**
		 * @return the wechatAccesstokenurl
		 */
		public String getWechatAccesstokenurl() {
			return wechatAccesstokenurl;
		}
		/**
		 * @param wechatAccesstokenurl the wechatAccesstokenurl to set
		 */
		public void setWechatAccesstokenurl(String wechatAccesstokenurl) {
			this.wechatAccesstokenurl = wechatAccesstokenurl;
		}
		/**
		 * @return the wechatCreatemenu
		 */
		public String getWechatCreatemenu() {
			return wechatCreatemenu;
		}
		/**
		 * @param wechatCreatemenu the wechatCreatemenu to set
		 */
		public void setWechatCreatemenu(String wechatCreatemenu) {
			this.wechatCreatemenu = wechatCreatemenu;
		}
		
		
		
		
		/**
		 * @return the wechatGenerateqrcod
		 */
		public String getWechatGenerateqrcod() {
			return wechatGenerateqrcod;
		}
		/**
		 * @param wechatGenerateqrcod the wechatGenerateqrcod to set
		 */
		public void setWechatGenerateqrcod(String wechatGenerateqrcod) {
			this.wechatGenerateqrcod = wechatGenerateqrcod;
		}
		/**
		 * @return the wechatJsApiTicket
		 */
		public String getWechatJsApiTicket() {
			return wechatJsApiTicket;
		}
		/**
		 * @param wechatJsApiTicket the wechatJsApiTicket to set
		 */
		public void setWechatJsApiTicket(String wechatJsApiTicket) {
			this.wechatJsApiTicket = wechatJsApiTicket;
		}
		/**
		 * @return the wechatQrcodepicurl
		 */
		public String getWechatQrcodepicurl() {
			return wechatQrcodepicurl;
		}
		/**
		 * @param wechatQrcodepicurl the wechatQrcodepicurl to set
		 */
		public void setWechatQrcodepicurl(String wechatQrcodepicurl) {
			this.wechatQrcodepicurl = wechatQrcodepicurl;
		}
		
		

}
