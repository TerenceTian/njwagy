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
public class LoginInterceptor extends AbstractInterceptor {

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
		UserEntity user = (UserEntity) session.get(BaseAction.loginUserSessionKey);
		
		// 如果没有登陆，都返回重新登陆
		if (user != null) {
			return invocation.invoke();
		}
		// 没有登陆，将服务器提示设置成一个HttpServletRequest属性
		ctx.put("tip", "您还没有登录，请登陆系统");

		return Action.LOGIN;
	}

}
