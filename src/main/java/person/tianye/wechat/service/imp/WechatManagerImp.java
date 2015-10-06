/**   
* @Title: WechatManagerImp.java 
* @Package person.tianye.wechat.service.imp 
* @Description: TODO
* @author Tian
* @date 2015年10月1日 下午9:22:25 
* @version 
*/
package person.tianye.wechat.service.imp;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.njwa.onlineacts.controller.ActivityAction;
import org.springframework.beans.factory.annotation.Autowired;

import flexjson.JSONDeserializer;
import person.tianye.wechat.entity.AccessToken;
import person.tianye.wechat.service.WechatManager;
import person.tianye.wechat.util.WechatAPI;

/** 
* @ClassName: WechatManagerImp 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年10月1日 下午9:22:25 
*  
*/
public class WechatManagerImp implements WechatManager {

	private static final Logger logger = Logger.getLogger(WechatManagerImp.class);
	private AccessToken accessTokenEntity;
	private WechatAPI wechatAPI;
	
	
	
	/**
	* (non-Javadoc)
	* @see person.tianye.wechat.service.WechatManager#getJsApiTicket()
	*/
	@Override
	public String getJsApiTicket() {
		if("".equals(accessTokenEntity.getAccessToken()) || isAccessTokenExpired())
			updateAccessToken(wechatAPI.getAccessTokenStr());
		return accessTokenEntity.getJsApiTicket();
	}
	
	/**
	* (non-Javadoc)
	* @see person.tianye.wechat.service.WechatManager#getAccessToken()
	*/
	@Override
	public String getAccessToken() {
		// TODO Auto-generated method stub
		if("".equals(accessTokenEntity.getAccessToken()) || isAccessTokenExpired())
			updateAccessToken(wechatAPI.getAccessTokenStr());
		return accessTokenEntity.getAccessToken();
	}

	private void updateAccessToken(String accessTokenStr) {
		// TODO Auto-generated method stub
		Map<String, String> resultMap = new JSONDeserializer<Map<String, String>>().deserialize(accessTokenStr);
		if(resultMap.containsKey(AccessToken.RESULT_INDEX_ACCESSTOKEN)){
			accessTokenEntity.setAccessToken(resultMap.get(AccessToken.RESULT_INDEX_ACCESSTOKEN));
			accessTokenEntity.setExpire(Long.parseLong(String.valueOf(resultMap.get(AccessToken.RESULT_INDEX_EXPRIREIN))));
			accessTokenEntity.setGenerateTime(System.currentTimeMillis());
			logger.info("##### Get a new access token, expires in " + String.valueOf(accessTokenEntity.getExpire()));
			String jsApiTicketStr = wechatAPI.getJsApiTicketStr(accessTokenEntity.getAccessToken());
			Map<String, String> resultMap2 = new JSONDeserializer<Map<String, String>>().deserialize(jsApiTicketStr);
			if(resultMap2.containsKey(AccessToken.RESULT_INDEX_TICKET)){
				accessTokenEntity.setJsApiTicket(resultMap2.get(AccessToken.RESULT_INDEX_TICKET));
				logger.info("##### Get a new JsApiTicket"); 
			}else{
				logger.info("!!!!! Get JsApiTicket error, code: " + String.valueOf(resultMap2.get(AccessToken.RESULT_INDEX_ERRORCODE)));
			}
		}else if(resultMap.containsKey(AccessToken.RESULT_INDEX_ERRORCODE))
			logger.info("!!!!! Get access token error, code: " + String.valueOf(resultMap.get(AccessToken.RESULT_INDEX_ERRORCODE)));
	}
	private boolean isAccessTokenExpired(){
		if(System.currentTimeMillis() - accessTokenEntity.getGenerateTime() > ((accessTokenEntity.getExpire() - 200)*1000))
			return true;
		return false;
	}


	
	/**
	 * @param accessTokenEntity the accessTokenEntity to set
	 */
	public void setAccessTokenEntity(AccessToken accessTokenEntity) {
		this.accessTokenEntity = accessTokenEntity;
	}

	/**
	 * @param wechatAPI the wechatAPI to set
	 */
	public void setWechatAPI(WechatAPI wechatAPI) {
		this.wechatAPI = wechatAPI;
	}

	/**
	* (non-Javadoc)
	* @see person.tianye.wechat.service.WechatManager#getJsSignature()
	*/
	@Override
	public Map<String, String> getJsSignature(String currentUrl) {
		// TODO Auto-generated method stub
		String nonceStr = UUID.randomUUID().toString();
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        String string1 = "jsapi_ticket=" + this.getJsApiTicket() +
                "&noncestr=" + nonceStr +
                "&timestamp=" + timestamp +
                "&url=" + currentUrl;
        String signature = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            Formatter formatter = new Formatter();
            for (byte b : crypt.digest())
            {
                formatter.format("%02x", b);
            }
            signature = formatter.toString();
            formatter.close();            
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        Map<String, String> ret = new HashMap<String, String>();
        ret.put("appId", wechatAPI.getAppId());
        ret.put("nonceStr", nonceStr);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        
		return ret;
	}

	/**
	* (non-Javadoc)
	* @see person.tianye.wechat.service.WechatManager#generateQRcode(java.lang.String, long)
	*/
	@Override
	public String[] generateQRcode(long sceneId, long seconds) {
		// TODO Auto-generated method stub
		String result[] = new String[2] ;
		String resultStr;
		if(seconds <= 0 || seconds > 604800){
			//QR_LIMIT_STR_SCENE >7days
			resultStr = wechatAPI.getTemporaryQRCode(accessTokenEntity.getAccessToken(), sceneId, seconds);
		}else{
			resultStr = wechatAPI.getPermanentQRCode(accessTokenEntity.getAccessToken(), sceneId);
		}
		System.out.println(resultStr);
		Map<String, String> resultMap = new JSONDeserializer<Map<String, String>>().deserialize(resultStr);
		result[0] = resultMap.get("ticket");
		result[1] = resultMap.get("url");
		return result;
	}

	/**
	* (non-Javadoc)
	* @see person.tianye.wechat.service.WechatManager#getQRCodePicUrl(java.lang.String)
	*/
	@Override
	public String getQRCodePicUrl(String ticket) {
		// TODO Auto-generated method stub
		return wechatAPI.getQRCodeUrlByTicket(ticket);
	}
	

}
