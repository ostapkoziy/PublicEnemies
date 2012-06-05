<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<link rel="stylesheet" href="css/fights.css" type="text/css">
</head>
<body>
	<table align="center" width="100%" style="background-color: transparent;">
		<tr style="margin-top: 2px;">
			<td style="background-color: black; width: 100%;">
				<!--  up bar with stats, gamelogo, avatar -->
				<div style="border-radius: 15px;">
					<jsp:include page="../simple_header.jsp"></jsp:include>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<table class="sample" align="center" width="500" height="500" style="margin-top: 50px; outline: 13px solid red;">
					<tr>
						<td>
							<div>
								<form action="createGame.html" method="post">
									<button id="create" type="submit">Create game</button>
								</form>
							</div>
							<div>
								<!-- <a href="allGames.html">ALL GAMES</a> -->
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