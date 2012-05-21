<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/poker.css" type="text/css">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
</head>
<body>
	<table align="center">
		<tr>
			<td align="center"><img src="img/gamelogo.png"></img></td>
		</tr>
		<tr>
			<td><c:forEach items="${dealer_cards}" var="dealer_card">
					<img src="${dealer_card.image()}"></img>
				</c:forEach>
		</tr>
		<tr>
			<table class="sample" align="center" width="300">
				<tr align="center" height="200">
					<br>Your balance - ${chips}
					<br>Your points - ${your_points}
					<br>Your bet - ${bet}
					<form action="startBlackJack.html" method="post">
						<input type="text" name="bet">
						<button type="submit" class="button" ${start_state}>Start</button>
					</form>
					<form action="standBlackJack.html" method="post">
						<button type="submit" class="button" ${stand_state}>Stand</button>
					</form>
					<form action="hitBlackJack.html" method="post">
						<button type="submit" class="button" ${hit_state}>Hit</button>
					</form>
					<form action="splitBlackJack.html" method="post">
						<button type="submit" class="button" ${split_state}>Split</button>
					</form>
					<form action="doubleDownBlackJack.html" method="post">
						<button type="submit" class="button" ${doubledown_state}>Double Down</button>
					</form>
				</tr>
				<tr align="center">
					<td>${result}
					<td><c:forEach items="${player_cards}" var="player_card">
							<img src="${player_card.image()}"></img>
						</c:forEach>
				</tr>
			</table>
		</tr>
	</table>

</body>
</html>