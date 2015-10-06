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
<strong>主持人列表</strong>
<c:if  test="${!empty hostList}">
	<table border="1">
		<tr>
		    <th align="left"><s:text name="user.nickname"/></th>
		    <th align="left"><s:text name="user.email"/></th>
		    <th align="left"><s:text name="user.phone"/></th>
		    <th align="left"><s:text name="user.qq"/></th>
		    <th align="left"><s:text name="user.wechat"/></th>
		    <th align="left"></th>
		</tr>
		<c:forEach items="${hostList}" var="user" >
		    <tr>
		        <td>${user.nickname}</td>
		        <td>${user.email}</td>
		        <td>${user.phone}</td>
		        <td>${user.qq}</td>
		        <td>${user.wechat}</td>
		        <td>
		        	<a href="delete/${user.uid}"><s:text name="admin.editHost.delete"/></a>
		        </td>
		    </tr>
		</c:forEach>
		<s:form method="post" action="editHost/add">
		    <table>
			    <tr>
			        <td><s:textfield key="regist.username" name="user.username"/></td>
			    </tr>
			    <tr>
			        <td>
			        	<s:submit key="admin.editHost.add"></s:submit>
			        </td>
			    </tr>
			</table> 
		</s:form>
	</table>
</c:if>

</body>
</html>