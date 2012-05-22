<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/blackjack.css" type="text/css">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/blackjack/hit.js"></script>
</head>
<body>
	<table id="blackjack_table" height="800" width="1200" align="center">
		<tr align="center">
			<td><c:forEach items="${dealer_cards}" var="dealer_card">
					<img src="${dealer_card.image()}"></img>
				</c:forEach>
		</tr>
		<tr align="center">
			<td>${result}
			<td><c:forEach items="${player_cards}" var="player_card">
					<img src="${player_card.image()}"></img>
				</c:forEach>
		</tr>
		<tr align="center">
			<td>Your balance - ${chips} <br>Your points -
				${your_points} <br>Your bet - ${bet}
			</td>
			<td>
				<form action="startBlackJack.html" method="post">
					<input id="bet" type="text" name="bet">
					<input id="deal" type="image" src="img/layout/deal.png" alt="Submit button">
				</form>
			</td>
			<td>
				<form action="standBlackJack.html" method="post">
					<input type="image" src="img/layout/stand.png" alt="Submit button">
				</form>
			</td>
			<td>
				<form action="hitBlackJack.html" method="post">
					<input type="image" src="img/layout/hit.png" alt="Submit button">
				</form>
			</td>
			<td>
				<form action="splitBlackJack.html" method="post">
					<input type="image" src="img/layout/split.png" alt="Submit button">
				</form>
			</td>
			<td>
				<form action="doubleDownBlackJack.html" method="post">
					<input type="image" src="img/layout/double.png" alt="Submit button">
				</form>
			</td>
	</table>
</body>
</html>