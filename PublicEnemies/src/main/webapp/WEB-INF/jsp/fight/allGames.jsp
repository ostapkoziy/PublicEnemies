<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Games</title>
</head>
<body>
	<a href="index.html">index</a>
	<div id="games">
		<c:forEach items="${list}" var="game">
			<c:out value="User1:${game.creatorProfile.getNickName()}"></c:out>
			<br />
			<c:out value="User2:${game.connectorProfile.getNickName()}"></c:out>
			<form action="connect.html" method="post">
				<button id="connect" type="submit">Connect</button>
				<label>GameId: </label>
				<input name="gameId" type="text" value="${game.id}">
			</form>
			-----------------------------------------------------------<br />
		</c:forEach>
	</div>
</body>
</html>