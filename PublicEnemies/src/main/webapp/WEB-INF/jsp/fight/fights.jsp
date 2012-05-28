<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<style type="text/css">
body {
	background-image: url('img/bg_city.png');
	color: white;
	font-family: 'impact';
	font-size: 14pt;
}

table {
	background-color: black
}

A:link {
	text-decoration: underline;
	color: white
}

A:visited {
	text-decoration: none;
	color: white;
}

A:hover {
	text-decoration: underline;
	color: red;
}

table#main {
	background-color: #444D48;
	opacity: .6;
	filter: alpha(opacity =        60);
	-moz-opacity: .6;
	border-width: 3px;
	border-spacing: 5px;
	border-style: outset;
	border-color: white;
	border-collapse: separate;
}
</style>
</head>
<body>
	<table align="center" width="100%" style="background-color: transparent">
		<tr>
			<td style="background-color: black; width: 100%;">
				<!--  up bar with stats, gamelogo, avatar -->
				<jsp:include page="../simple_header.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td>
				<table id="main" align="center" width="500" height="500" style="margin-top: 50px">
					<tr>
						<td>
							<div>
								<form action="createGame.html" method="post">
									<button id="create" type="submit">Create</button>
								</form>
								<!-- 								<a href="allGames.html">ALL GAMES</a> -->
								<div id="games">
									<c:forEach items="${list}" var="game">
										<form action="connect.html" method="post">
											<button id="connect" type="submit">Connect</button>
											<label>GameId: </label>
											<input name="gameId" type="text" value="${game.id}">
										</form>
									</c:forEach>
								</div>
							</div>
						</td>
					</tr>
				</table>

			</td>
		</tr>
	</table>


</body>
</html>