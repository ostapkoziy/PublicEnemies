<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/poker.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/poker/pokerGame.js"></script>
<script type="text/javascript" src="js/poker/raise.js"></script>

<title>Public Enemies Poker</title>
<!-- <script type="text/javascript" src="js/poker/bet.js"></script> -->


<title>Poker</title>
</head>
<body>
	<table align="center" height="120">
		<tr>
			<td align="center"><a href="userStartPage.html"><img src="img/gamelogo.png"></img></a></td>
		</tr>
		<tr>
			<button id="newRound">New Round</button>
			<table id="poker_table" class="sample" align="center" width="1000">
				<tr align="center">
					<td>
						<img style="position:relative; top:90px; left:-40px; width:80px; height:80px"  border="2" SRC="img/avatars/default.png">
						<img id="botMove" style="position:relative; top:90px; left:-40px;" src="">
					</td>
					<td>
						<img style="position:relative; top:135px; left:-305px; width: 35px"src="img/chips/chips.png"></img>
						<div id="bot_chips"style="position:relative; top:105px; left: -270px">1488</div>
					</td>
				</tr>
				<tr align="center" height="270">
					<td colspan="2">
						<table width="500">
							<tr height="80">
								<td width="200">
								</td>
								<td>
									<table>
										<tr>
											<td>
												<img id="bot_card1" style="position:relative; top:40px; left:10px; width: 35px"  border="2" SRC="img/cards/back_image.png">
												<img id="bot_card2" style="position:relative; top:40px; left:15px; width: 35px"  border="2" SRC="img/cards/back_image.png">
											</td>
										</tr>
										<tr>
											<td>
												<img style="position:relative; top:40px; left:20px; width: 35px"src="img/chips/chips.png"></img>
												<div id="botBet" style="position:relative; left:60px; top: 2px"></div>
											</td>
										</tr>
									</table>
								</td>
								<td>
									<h4 id="bot_chips" style="position:relative; left:-35px; top: 40px"></h4>
								</td>
							</tr>
							<tr height="120">
								<td colspan="3">	
									<!--++++++++++++++++++++++++++++++++++DECK++++++++++++++++++++++++++++++++++++ -->
									<img id="deck" style="position:relative; top:-20px; left:40px; width: 40px" src="img/cards/deck.png"></img>
									<!--++++++++++++++++++++++++++++++++++FLOP++++++++++++++++++++++++++++++++++++ -->
									<img id="flop1" class="none" style="position:relative; top:-20px; left:93px; width: 35px" src=""></img>
									<img id="flop2" class="none"  style="position:relative; top:-20px; left:98px; width: 35px" src=""></img>
									<img id="flop3" class="none" style="position:relative; top:-20px; left:103px; width: 35px" src=""></img>
									<!--++++++++++++++++++++++++++++++++++TURN++++++++++++++++++++++++++++++++++++ -->
									<img id="turn" class="none" style="position:relative; top:-20px; left:108px; width: 35px" src=""></img>
									<!--++++++++++++++++++++++++++++++++++RIVER+++++++++++++++++++++++++++++++++++ -->
									<img id="river" class="none" style="position:relative; top:-20px; left:113px; width: 35px" src=""></img>
									<!--++++++++++++++++++++++++++++++++++POT++++++++++++++++++++++++++++++++++++ -->
									<img id="pot_chips" style="position:relative; top:-30px; left:130px; width: 35px" src="img/chips/chips.png"></img>
									<a id="pot_size" style="position:relative; top:-40px; left:130px">0</a>
								</td>
							</tr>
							<tr height="50">
								<td width="100">
									<img style="position:relative; top:-35px; left:35px; width: 35px"src="img/chips/chips.png"></img>
								</td>
								<td>
									<table>
										<tr>
											<td>
												<img style="position:relative; top:-55px; left:20px; width: 35px"src="img/chips/chips.png"></img>
												<div id="playerBet" style="position:relative; top:-85px; left:65px"></div>
											</td>
										</tr>
										<tr>
											<td>
												<img id="player_card1" style="position:relative; top:-55px; left:10px; width: 35px"  border="2" SRC="img/cards/Ac.png">
												<img id="player_card2" style="position:relative; top:-55px; left:15px; width: 35px"  border="2" SRC="img/cards/Kc.png">
											</td>
										</tr>
									</table>
									
								</td>
								<td>
								</td>
							</tr>
						</table>
					</td>

				</tr>
				<tr align="center" height="70">
					<td>
						<div id="player_chips" style="position:relative; top:-165px; left:-30px; width:80px; height:80px"></div>
					</td>
					<td>
						<img id="playerMove" style="position:relative; top:-170px; left:-250px;" src="">
						<img id="player_avatar" style="position:relative; top:-115px; left:-250px; width:80px; height:80px"  border="2" src="">
						<div id="player_name" style="position:relative; top:-115px; left:-250px; width:80px; height:80px"></div>
					</td>
				</tr>
 				<tr>
 					<td>
 						<img id="fold_button" name="active" src="img/layout/fold.png" style="position:relative; top:-150px; left:300px;"></img>
 						<img id="call_button" name="active" src="img/layout/call.png" style="position:relative; top:-150px; left:340px;"></img>
 						<img id="raise_button" name="active" src="img/layout/raise.png" style="position:relative; top:-150px; left:390px;"></img>
 					</td>
 				</tr>
 				<tr height="30">
 					<td>
						<form action="pokerGame.html" method="post" style="position:relative; top:-150px; left:450px; width:80px; height:80px; border: 2px">
							<input id="userBetInput" type="text" value="0">
						</form>
						<div id="attackBlock"style="position:relative; top:-150px; left:0px; width:80px; border: 2px">
				<input id="botBetInput" type="text" value="0">
			</div>
 					</td>			
				</tr>
			</table>
		</tr>
	</table>
</body>
</html>