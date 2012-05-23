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
<script type="text/javascript" src="js/blackjack/deal.js"></script>
</head>
<body>
	<table id="blackjack_table" height="800" width="1200" align="center">
		<tr>
			<td>Your balance - ${chips} <br>Your bet - ${bet}
			</td>
		</tr>
		<tr align="center">
			<td><c:forEach items="${dealer_cards}" var="dealer_card">
					<img src="${dealer_card.image()}"></img>
				</c:forEach>
		</tr>
		<tr align="center">
			<td>${result}</td>
			<td>Your points - ${your_points} <c:forEach
					items="${player_cards}" var="player_card">
					<img src="${player_card.image()}"></img>
				</c:forEach>
				<div id="cards">
				</div>
				</td>
		</tr>
		<tr>
			<td><img id="10_button" src="img/chips/10.png"
				style="position: relative; top: -90px; left: 300px;"> <img
				id="25_button" src="img/chips/25.png"
				style="position: relative; top: -90px; left: 300px;"> <img
				id="50_button" src="img/chips/50.png"
				style="position: relative; top: -90px; left: 300px;"> <img
				id="100_button" src="img/chips/100.png"
				style="position: relative; top: -90px; left: 300px;"></img></td>
		</tr>
		<tr align="center">
			<td><input id="bet" type="text" name="bet"> <img
				id="deal_button" src="img/layout/deal.png"
				style="position: relative; top: -90px; left: 300px;"></img></td>
			<td><img id="stand_button" src="img/layout/stand.png"
				style="position: relative; top: -90px; left: 300px;"></img></td>
			<td><img id="hit_button" src="img/layout/hit.png"
				style="position: relative; top: -90px; left: 300px;"></img></td>
			<td><img id="split_button" src="img/layout/split.png"
				style="position: relative; top: -90px; left: 300px;"></img></td>
			<td><img id="double_button" src="img/layout/double.png"
				style="position: relative; top: -90px; left: 300px;"></img></td>
	</table>
</body>
</html>