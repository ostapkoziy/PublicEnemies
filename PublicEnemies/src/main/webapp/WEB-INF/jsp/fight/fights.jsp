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
				<table width="100%">
					<tr>
						<td width="100" align="left"><img src="img/gamelogo_small.png" width="100px"></img></td>
						<td width="40" valign="middle" align="right"><img src="img/coin.png" width="40px" title="Money"></img></td>
						<td width="20" valign="middle" align="left">904</td>
						<td width="80" valign="middle" align="right"><img src="img/hp.png" width="40px" title="Hit Points"></img></td>
						<td width="20" valign="middle" align="left">80</td>
						<td width="80" valign="middle" align="right"><img src="img/strength.png" width="40px" title="Strength"></img></td>
						<td width="20" valign="middle" align="left">21</td>
						<td width="80" valign="middle" align="right"><img src="img/agility.png" width="40px" title="Agility"></img></td>
						<td width="20" valign="middle" align="left">34</td>
						<td width="80" valign="middle" align="right"><img src="img/inteligence.png" width="40px" title="Inteligence"></img></td>
						<td width="20" valign="middle" align="left">8</td>
						<td width="100" align="right"><img src="img/avatars/gangster.png" title="${user_email}'s profile" border="1" width="40px"></img></td>
						<td width="30" align="center"><a href="logout.html">Logout</a> <br /></td>
					</tr>
				</table>
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