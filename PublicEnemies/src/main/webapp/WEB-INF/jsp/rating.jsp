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
	
	<div class="main_ranking_div">
	<div><a href="ratingByExp.html">Experience Rating</a></div>
	<div><a href="ratingByMoney.html">Money Rating</a></div>
		<c:choose>
			<c:when test="${usersList.size() == 0 }">
				<h4>There is no user</h4>
			</c:when>
			<c:otherwise>				
				<table align="center">
				<caption>Rating</caption>
				<thead> <tr>  
				<th> Nickname </th>
				<th>
				
				<c:choose>
					<c:when test="${sortLabel == 0 }">
						<h4>Experience</h4>
					</c:when>
					<c:when test="${sortLabel == 1 }">
						<h4>Money</h4>
					</c:when>
				</c:choose>
				
				</th>
				</tr></thead>
					<c:forEach items="${usersList}" var="user">
						<tr>
							<td>${user.get("nickname")}</td>
							<td>${user.get("value")}</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>