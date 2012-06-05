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
				<div class="sample" style="width: 500px; height: 500px; margin-left: auto; margin-right: auto; margin-top: 50px;">
					<div>
						<form action="createGame.html" method="post">
							<button id="create" type="submit" style="width: 200px; height: 50px; display: block; margin: 0 auto; cursor: pointer;">Create game</button>
						</form>
					</div>
					<div>
						<form action="connect.html" method="post">
							<div id="fights" style="height: 400px; width: 500px; overflow: auto;">
								<c:forEach items="${list}" var="game">
									<div id="${game.id}" class="fight" style="text-align: center; width: 250px; margin: 0 auto; margin-bottom: 5px;">
										<img alt="" src="${game.getCreatorProfile().getAvatar()}" width="30">
										${game.getCreatorProfile().getNickName()} LVL: ${game.getCreatorProfile().getLevel().getCurrentLevel()}
									</div>
								</c:forEach>
							</div>
							<div style="position: relative;">
								<input id="gameId" name="gameId" type="text" value="" hidden="">
								<button id="connect" type="submit" style="width: 200px; height: 50px; display: block; margin: 0 auto; cursor: pointer;">Connect</button>
							</div>
						</form>
					</div>
				</div>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		$(function()
		{
			$(".fight").click(function()
			{
				$(".fight").css("background", "");
				$(".fight").css("opacity", "1");
				$(this).css("background", "url(img/fight/overlay.png)");
				$(this).css("opacity", "0.5");
				var fightId = $(this).attr("id");
				$("#gameId").val(fightId);

			});
		})
	</script>
</body>
</html>