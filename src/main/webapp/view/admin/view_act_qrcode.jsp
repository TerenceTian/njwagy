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

<strong>介绍</strong>
<c:if test="${empty qrCode}">
<LABEL><s:text name="activity.qrcode.notGenerated" />或<s:text name="activity.qrcode.expired" /></LABEL>
</c:if>
<c:if test="${!empty qrCode}">
<img src="${qrCode.url}" />
</c:if>
</body>
</html>