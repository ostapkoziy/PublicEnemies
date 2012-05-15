<%@ page import="com.epam.publicenemies.domain.fight.Game"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resault</title>
</head>
<body>
	<c:if test="${gameRole=='creator'}">
		<%
			// response.sendRedirect(((Game) session.getAttribute("game")).getUser1().getPage());
				//session.removeAttribute("game");
		%>
	</c:if>
	<c:if test="${gameRole=='connector'}">
		<%
			// 			response.sendRedirect(((Game) session.getAttribute("game")).getUser2().getPage());
				//	session.removeAttribute("game");
		%>
	</c:if>
</body>
</html>