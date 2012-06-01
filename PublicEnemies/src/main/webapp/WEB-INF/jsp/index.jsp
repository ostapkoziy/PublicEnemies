<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Public Enemies</title>
</head>
<body>
	<c:choose>
		<c:when test="${userId==null}">
			<c:redirect url="userLogin.html"></c:redirect>
		</c:when>
		<c:otherwise>
			<c:redirect url="userStartPage.html"></c:redirect>
		</c:otherwise>
	</c:choose>
	<c:if test="${admin!=null}">
		<c:redirect url="adminPanel.html"></c:redirect>
	</c:if>
</body>
</html>