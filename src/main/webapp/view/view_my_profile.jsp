<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="UTF-8" ?>
<jsp:directive.page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>南京微爱公益</title>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="../js/wxbutton-0.1.js"></script>
<link rel="stylesheet" href="http://demo.open.weixin.qq.com/jssdk/css/style.css?ts=1420774989" />
<SCRIPT type="text/javascript">
wx.config({
	debug : true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	appId : "${jsSdkSignatureMap['appId']}", // 必填，公众号的唯一标识
	timestamp : "${jsSdkSignatureMap['timestamp']}", // 必填，生成签名的时间戳
	nonceStr : "${jsSdkSignatureMap['nonceStr']}", // 必填，生成签名的随机串
	signature : "${jsSdkSignatureMap['signature']}",// 必填，签名，见附录1
	jsApiList : [ 'checkJsApi', 'scanQRCode' ]
// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
});
</SCRIPT>
</head>
<body>

	<h3>我的首页，个人资料</h3>
	<a href="../logout"><s:text name="login.logout" /></a>
	<c:if test="${!empty userProfile}">
		<img src="${userProfile.headimg}" alt="<s:text name="user.headimg"/>" />

		<table  border="1">
			<tr>
				<td align="center"><s:text name="user.nickname" /></td>
				<td align="center">${userProfile.nickname}</td>
			</tr>
			<tr>
				<td align="center"><s:text name="user.email" /></td>
				<td align="center">${userProfile.email}</td>
			</tr>
			<tr>
				<td align="center"><s:text name="user.phone" /></td>
				<td align="center">${userProfile.phone}</td>
			</tr>
			<tr>
				<td align="center"><s:text name="user.qq" /></td>
				<td align="center">${userProfile.qq}</td>
			</tr>
			<tr>
				<td align="center"><s:text name="user.wechat" /></td>
				<td align="center">${userProfile.wechat}</td>
			</tr>
			<tr>
				<td align="center"><s:text name="user.point" /></td>
				<td align="center">${userProfile.point}</td>
			</tr>
			<tr>
				<td align="center"><s:text name="user.role" /></td>
				<td align="center">${userProfile.role}</td>
			</tr>
			<tr>
				<td align="center"><a href="changePassword">修改密码</a></td>
				<td align="center"><a href="editProfile">修改个人资料</a></td>
			</tr>
			<tr>
				<td align="center"><a href="../activity/">查看活动</a></td>
				<td align="center"><a href="activity">查看已报名活动</a></td>
			</tr>
			<tr>
				<td align="center"></td>
				<td align="center">
					<button class="btn btn_primary" id="checkJsApi">checkJsApi</button>
					<button class="btn btn_primary" id="scanQRCode0">活动签到扫描二维码(微信处理结果)</button>
					
				</td><!-- <button class="btn btn_primary" id="scanQRCode1">scanQRCode(直接返回结果)</button>
					../activity/scanQRCode/scanResult -->
			</tr>
			<tr>

			</tr>
					
			


			<c:if test="${userProfile.role >= 1}">
				<tr>
					<td><a href="../admin/releaseActivity"><s:text name="activity.release" /></a></td>
					<c:if test="${userProfile.role >= 2}">
						<td><a href="../admin/editHost/"><s:text name="admin.editHost" /></a></td>
					</c:if>
				</tr>
				
			</c:if>
		</table>

	</c:if>


</body>
</html>