/**   
* @Title: AuthorityInterceptor.java 
* @Package org.njwa.onlineacts.controller 
* @Description: TODO
* @author Tian
* @date 2015年10月3日 下午12:11:21 
* @version 
*/
package org.njwa.onlineacts.interceptor;

import java.util.Map;

import org.njwa.onlineacts.controller.BaseAction;
import org.njwa.onlineacts.entity.UserEntity;
import org.njwa.onlineacts.entity.UserProfileEntity;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @ClassName: AuthorityInterceptor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Tian
 * @date 2015年10月3日 下午12:11:21
 * 
 */
public class AuthorityInterceptor extends AbstractInterceptor {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 7832598154372889469L;

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		// 取出名为user的session属性
		UserProfileEntity userProfile = (UserProfileEntity) session.get(BaseAction.loginUserProfileKey);
		Map application = invocation.getInvocationContext().getApplication();
		String actionName = invocation.getProxy().getActionName();
		// 如果没有登陆，都返回重新登陆
		switch(userProfile.getRole()){
		case 1:
			break;
		case 2:
			break;
		}

		return Action.SUCCESS;
	}

}
