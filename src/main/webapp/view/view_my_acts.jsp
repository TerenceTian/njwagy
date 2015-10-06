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
<strong>已报名活动</strong>

<c:if  test="${(!empty activityList) && (!empty userActivityList)}">

	<table border="1">
		<tr>
		    <th align="left"><s:text name="activity.name"/></th>
		    <th align="left"><s:text name="activity.startTime"/></th>
		    <th align="left"><s:text name="activity.hostplace"/></th>
		    <th align="left"><s:text name="activity.remainingPlace"/></th>
		    <th align="left"><s:text name="activity.bonusPoint"/></th>
		    <th align="left"><s:text name="activity.status"/></th>
		    <th align="left"><s:text name="activity.getDetail"/></th>
		    <th align="left"></th>
		</tr>
		
		<c:forEach items="${activityList}" var="activity" varStatus="status">
		    <tr>
		        <td>${activity.name}</td>
		        <td>${activity.startTime}</td>
		        <td>${activity.hostplace}</td>
		        <td>${activity.maxNumber - activity.currentNumber}</td>
		        <td>${activity.bonusPoint}</td>
		        <td>
		        	<c:choose>
				    <c:when test="${activity.status==-1}">
				    	<s:text name="activity.status.cancelled"/>
				    </c:when>
				    <c:when test="${activity.status==0}">
				    	<s:text name="activity.status.underway"/>
				    </c:when>
				    <c:when test="${activity.status==1}">
				    	<s:text name="activity.status.completed"/>
				    </c:when>
				    <c:otherwise>
				    	<s:text name="user.activity.status.error"/>
				    </c:otherwise>
				    </c:choose>
		        </td>
		        <td><a href="../activity/view/${activity.aid}"><s:text name="activity.getDetail"/></a></td>
		        <td>
		        	<c:choose>
				    <c:when test="${userActivityList.get(status.index).flag==-1}">
				    	<s:text name="user.activity.status.absent"/>
				    </c:when>
				    <c:when test="${userActivityList.get(status.index).flag==1}">
				    	<a href="../activity/cancel/${activity.aid}"><s:text name="user.activity.status.cancel"/></a>
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