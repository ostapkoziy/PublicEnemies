<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center">
		<tr>
			<td align="center"><img src="${dealer_card0}"></img></td>
		</tr>
		<tr>
			<table class="sample" align="center" width="300">
				<tr align="center" height="200">
					Your balance - ${chips}  Your points - ${your_points} Your bet -
					${bet}
					<form action="startBlackJack.html" method="post">
						<input type="text" name="bet">
						<button type="submit" class="button">Start</button>
					</form>
					<form action="standBlackJack.html" method="post">
						<button type="submit" class="button">Stand</button>
					</form>
					<form action="hitBlackJack.html" method="post">
						<button type="submit" class="button">Hit</button>
					</form>
					<form action="splitBlackJack.html" method="post">
						<button type="submit" class="button">Split</button>
					</form>
					<form action="doubleDownBlackJack.html" method="post">
						<button type="submit" class="button">Double Down</button>
					</form>
				</tr>
				<tr align="center">
					<td><img src="${player_card0}"></img> <img
						src="${player_card1}"></img> <img src="${player_card2}"></img> <img
						src="${player_card3}"></img> <img src="${player_card4}"></img> <img
						src="${player_card5}"></img></td>
				</tr>
			</table>
		</tr>
	</table>

</body>
</html>