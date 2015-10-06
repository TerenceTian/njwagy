<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml version="1.0" encoding="UTF-8" ?>
<jsp:directive.page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>南京微爱公益</title>
</head>
<body>


<c:if  test="${!empty activity}">

<table border="1">
  <tr>
    <td align="center"><s:text name="activity.name"/></td>
    <td align="center">${activity.name}</td>
  </tr>
  <tr>
    <td align="center"><s:text name="activity.description"/></td>
    <td align="center">${activity.description}</td>
  </tr>
  <tr>
    <td align="center"><s:text name="activity.url"/></td>
    <td align="center">${activity.url}</td>
  </tr>
  <tr>
    <td align="center"><s:text name="activity.hostplace"/></td>
    <td align="center">${activity.hostplace}</td>
  </tr>
  <tr>
    <td align="center"><s:text name="activity.maxNumber"/></td>
    <td align="center">${activity.maxNumber}</td>
  </tr>
  <tr>
    <td align="center"><s:text name="activity.remainingPlace"/></td>
    <td align="center">${activity.maxNumber - activity.currentNumber}</td>
  </tr>
  <tr>
    <td align="center"><s:text name="activity.bonusPoint"/></td>
    <td align="center">${activity.bonusPoint}</td>
  </tr>
  <tr>
  	<td>
  	</td>
  	<td>
	  	<c:if test="${!empty user}">
		  	<c:choose>
		    <c:when test="${joinStatus==-1}">
		    	<s:text name="user.activity.status.absent"/>
		    </c:when>
		    <c:when test="${joinStatus==0}">
		    	<a href="../regist/${activity.aid}"><s:text name="user.activity.status.regist"/></a>
		    </c:when>
		    <c:when test="${joinStatus==1}">
		    	<a href="../cancel/${activity.aid}"><s:text name="user.activity.status.cancel"/></a>
		    </c:when>
		    <c:when test="${joinStatus==2}">
		    	<s:text name="user.activity.status.complete"/>
		    </c:when>
		    <c:otherwise>
		    	<s:text name="user.activity.status.error"/>
		    </c:otherwise>
		    </c:choose>
	    </c:if>
	    <c:if test="${empty user}">请<a href="../../regist">注册</a>或<a href="../../login">登录</a>来完成报名
	    </c:if>
  	</td>
  </tr>
  <c:if test="${(!empty user) && (!empty userProfile)}">
  	<c:if test="${userProfile.role > 0}">
	  <tr>
	  <td></td>
	  <td>
			<a href="#"><s:text name="admin.cancelActivity"/></a>
			<a href="../../admin/viewActivityParticipant/${activity.aid}"><s:text name="admin.viewParticipant"/></a>
			<a href="../../admin/viewActivityQRCode/${activity.aid}"><s:text name="admin.viewActivityQRCode"/></a>
	  </td>
	  </tr>
	 </c:if>
  </c:if>
</table>

</c:if>
</body>
</html>