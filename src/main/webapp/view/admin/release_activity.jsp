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

<s:form method="post" action="doReleaseActivity">
    <table border="1">
	    <tr>
	        <td><s:textfield key="activity.name" name="activity.name"/></td> 
	    </tr>
	    <tr>
	        <td><s:textfield key="activity.description" name="activity.description"/></td>
	    </tr>
	     <tr>
	        <td><s:textfield key="activity.url" name="activity.url"/></td>
	    </tr>
	     <tr>
	        <td><s:textfield key="activity.hostplace" name="activity.hostplace"/></td>
	    </tr>
	     <tr>
	        <td><s:textfield key="activity.startTime" name="activity.startTime"/></td>
	    </tr>
	     <tr>
	        <td><s:textfield key="activity.endTime" name="activity.endTime"/></td>
	    </tr>
	     <tr>
	        <td><s:textfield key="activity.maxNumber" name="activity.maxNumber"/></td>
	    </tr>
	    <tr>
	        <td><s:textfield key="activity.bonusPoint" name="activity.bonusPoint"/></td>
	    </tr>
	    <tr>
	        <td>
	        	<s:submit key="activity.release"></s:submit>
	        </td>
	    </tr>
	</table>
</s:form>
</body>
</html>