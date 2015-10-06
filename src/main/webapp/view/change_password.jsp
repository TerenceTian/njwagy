<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="UTF-8" ?>
<jsp:directive.page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>南京微爱公益</title>
</head>
<body>
<strong>修改密码</strong>
<s:form method="post" action="doChangePassword">
    <table>
	    <tr>
	        <td><s:textfield key="user.password.old" name="oldPassword"/></td> 
	    </tr>
	    <tr>
	        <td><s:textfield key="user.password.new" name="newPassword"/></td>
	    </tr>
	    <tr>
	        <td><s:textfield key="user.password.new2" name="newPassword2"/></td>
	    </tr>
	    <tr>
	        <td>
	        	<s:submit key="user.password.change"></s:submit>
	        </td>
	    </tr>
	</table>
</s:form>

</body>
</html>