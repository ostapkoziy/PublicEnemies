<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/blackjack.css" type="text/css">
<title>PublicEnemies - BlackJack</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/blackjack/chips.js"></script>
<script type="text/javascript" src="js/blackjack/deal.js"></script>
<script type="text/javascript" src="js/blackjack/hit.js"></script>
<script type="text/javascript" src="js/blackjack/stand.js"></script>
<script type="text/javascript" src="js/blackjack/double.js"></script>
<script type="text/javascript" src="js/blackjack/split.js"></script>
<script type="text/javascript" src="js/blackjack/recovery.js"></script>
</head>
<body>
	<table align="center">
		<tr>
			<td align="center"><a href="userStartPage.html"><img
					src="img/gamelogo.png"></img></a></td>
		</tr>
		<tr>
			<td>
				<table id="blackjack_table" height="800" width="1000" align="center">
					<tr>
						<td><img id="10_button" src="img/roulette/Chip_10.png" width="80" class="active"> 
							<img id="25_button" src="img/roulette/Chip_25.png" width="80" class="active"> 
							<img id="50_button" src="img/roulette/Chip_50.png" width="80" class="active"> 
						</td>
						<td>
					<div>
						<img id="bet" width="80" style="position: relative; top: -20px; left: 330px;">
					</div>
					</tr>
					
					<tr align="center">
						<td>
							<div id="dealer_cards"></div>
						</td>
					</tr>
					<tr align="center">
						<td>
							<div id="result"></div>
						</td>
						<td>
							<div id="player_cards"></div>
						</td>
						<td>
							<div id="player_cardsSplit"></div>
						</td>
						<td>
							<div id="resultSplit"></div>
						</td>
						<td>
							<div id="player_points"></div>
						</td>
					</tr>
					<tr>
						<td><img src="${player_avatar}"></img></td>
						<td><div>${player_nickname}</div></td>
						<td>Your balance -
							<div id="playerChips"
								style="position: relative; top: -23px; left: 120px;">${chips}</div>
							<br>Your bet -
							<div id="playerBet"
								style="position: relative; top: -23px; left: 80px;"></div>
						</td>
					</tr>
					<tr align="center">
						<td><img id="deal_button" src="img/layout/dealg.png"
							style="position: relative; top: -20px;" class="notactive"></img></td>
						<td><img id="stand_button" src="img/layout/standg.png"
							style="position: relative; top: -20px;" class="notactive"></img></td>
						<td><img id="hit_button" src="img/layout/hitg.png"
							style="position: relative; top: -20px;" class="notactive"></img></td>
						<td><img id="split_button" src="img/layout/splitg.png"
							style="position: relative; top: -20px;" class="notactive"></img></td>
						<td><img id="double_button" src="img/layout/doubleg.png"
							style="position: relative; top: -20px;" class="notactive"></img></td>
						<td><form action="exitBlackJackController.html">
								<input type="image" src="img/layout/exit.png"
									alt="Submit button" style="position: relative; top: -20px;">
							</form></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>