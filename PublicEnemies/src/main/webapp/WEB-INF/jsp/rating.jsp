<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/ranking/rankingstyle.css" rel="stylesheet"
	type="text/css">
<title>Rating</title>
</head>
<body>
	<h3>Rating</h3>
	<c:choose>
		<c:when test="${sortLabel == 0 }">
			<h4>Sort by Experience</h4>
		</c:when>
		<c:when test="${sortLabel == 1 }">
			<h4>Sort by Money</h4>
		</c:when>
	</c:choose>
	<div class="main_ranking_div">
		<c:choose>
			<c:when test="${usersList.size() == 0 }">
				<h4>There is no user</h4>
			</c:when>
			<c:otherwise>
				<h4>List of users</h4>
				<c:forEach items="${usersList}" var="weaponIT">
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>