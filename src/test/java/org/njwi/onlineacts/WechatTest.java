/**   
* @Title: WechatTest.java 
* @Package org.njwi.onlineacts 
* @Description: TODO
* @author Tian
* @date 2015年10月1日 下午10:55:22 
* @version 
*/
package org.njwi.onlineacts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import person.tianye.wechat.service.WechatManager;
import person.tianye.wechat.service.imp.WechatManagerImp;

/** 
* @ClassName: WechatTest 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Tian
* @date 2015年10月1日 下午10:55:22 
*  
*/
@RunWith(SpringJUnit4ClassRunner.class) // 整合 
@ContextConfiguration(locations="classpath:beans.xml") // 加载配置
public class WechatTest {
	@Autowired // 注入
	private WechatManager wechatManager;
	@Test
	public void getAT(){
		wechatManager.getAccessToken();
	}

}
