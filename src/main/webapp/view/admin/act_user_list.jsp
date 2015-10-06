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
     
<h3>已报名用户列表</h3>
<c:if  test="${!empty userProfileList}">
	<table border="1">
		<tr>
		    <th align="left"><s:text name="user.nickname"/></th>
		    <th align="left"><s:text name="user.email"/></th>
		    <th align="left"><s:text name="user.phone"/></th>
		    <th align="left"><s:text name="user.qq"/></th>
		    <th align="left"><s:text name="user.wechat"/></th>
		    <th align="left"><s:text name="activity.status"/></th>
		</tr>
		<c:forEach items="${userProfileList}" var="user" varStatus="status">
		    <tr>
		        <td>${user.nickname}</td>
		        <td>${user.email}</td>
		        <td>${user.phone}</td>
		        <td>${user.qq}</td>
		        <td>${user.wechat}</td>
		        <td>
		        	<c:choose>
				    <c:when test="${userActivityList.get(status.index).flag==-1}">
				    	<s:text name="user.activity.status.absent"/>
				    </c:when>
				    <c:when test="${userActivityList.get(status.index).flag==1}">
				    	<s:text name="user.activity.status.regist"/>
				    </c:when>
				    <c:when test="${userActivityList.get(status.index).flag==2}">
				    	<s:text name="user.activity.status.complete"/>
				    </c:when>
				    <c:otherwise>
				    	<s:text name="user.activity.status.error"/>
				    </c:otherwise>
				    </c:choose>
		        </td>
		    </tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>
