<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="UTF-8" ?>
<jsp:directive.page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>南京微爱公益</title>
</head>
<body>
	<strong>修改个人资料</strong>
	<s:form method="post" action="doEditProfile">
		<c:if test="${!empty userProfile}">
			<img src="${userProfile.headimg}" alt="<s:text name="user.headimg"/>" />

			<table border="1">
				<tr>
					<td align="center"><s:text name="user.nickname" /></td>
					<td align="center"><input name="userProfile.nickname" value="${userProfile.nickname}" type="text"/></td>
				</tr>
				<tr>
					<td align="center"><s:text name="user.email" /></td>
					<td align="center"><input name="userProfile.email" value="${userProfile.email}" type="text"/></td>
				</tr>
				<tr>
					<td align="center"><s:text name="user.phone" /></td>
					<td align="center"><input name="userProfile.phone" value="${userProfile.phone}" type="text"/></td>
				</tr>
				<tr>
					<td align="center"><s:text name="user.qq" /></td>
					<td align="center"><input name="userProfile.qq" value="${userProfile.qq}" type="text"/></td>
				</tr>
				<tr>
					<td align="center"><s:text name="user.wechat" /></td>
					<td align="center"><input name="userProfile.wechat" value="${userProfile.wechat}" type="text"/></td>
				</tr>
				
					<s:submit key="user.profile.edit"></s:submit>
				
			</table>
		</c:if>
	</s:form>

</body>
</html>