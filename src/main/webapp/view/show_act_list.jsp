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
     
<h3>活动列表</h3>
<c:if  test="${!empty activityList}">
	<table >
		<tr>
		    <th align="left"><s:text name="activity.name"/></th>
		    <th align="left"><s:text name="activity.startTime"/></th>
		    <th align="left"><s:text name="activity.hostplace"/></th>
		    <th align="left"><s:text name="activity.remainingPlace"/></th>
		    <th align="left"><s:text name="activity.bonusPoint"/></th>
		    <th align="left"><s:text name="activity.getDetail"/></th>
		    		    
		</tr>
		<c:forEach items="${activityList}" var="act">
		    <tr>
		        <td>${act.name}</td>
		        <td>${act.startTime}</td>
		        <td>${act.hostplace}</td>
		        <td>${act.maxNumber - act.currentNumber}</td>
		        <td>${act.bonusPoint}</td>
		        <td><a href="view/${act.aid}"><s:text name="activity.getDetail"/></a></td>
		        	
		    </tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>
