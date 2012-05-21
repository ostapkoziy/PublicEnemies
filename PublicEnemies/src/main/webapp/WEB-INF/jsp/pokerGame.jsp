<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/poker.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<title>Poker</title>
<script type="text/javascript" src="js/poker/bet.js"></script>

<title>Poker</title>
</head>
<body>
	<button id="nextmove">next move</button>
	<table align="center">
		<tr>
			<td align="center"><img src="img/gamelogo.png"></img></td>
		</tr>
		<tr>
			<table id="poker_table" class="sample" align="center" width="1000">
				<tr align="center">
					<td>
						<img style="position:relative; top:90px; left:-40px; width:80px; height:80px"  border="2" SRC="img/avatars/default.png">
					</td>
					<td>
						<img style="position:relative; top:135px; left:-305px; width: 35px"src="img/chips/chips.png"></img>
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
												<font style="position:relative; left:25px; top: 30px">bet</font>
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
									<img id="deck" style="position:relative; top:0px; left:40px; width: 40px" src="img/cards/deck.png"></img>
									<!--++++++++++++++++++++++++++++++++++FLOP++++++++++++++++++++++++++++++++++++ -->
									<img id="flop1" style="position:relative; top:0px; left:93px; width: 35px" src=""></img>
									<img id="flop2" style="position:relative; top:0px; left:98px; width: 35px" src=""></img>
									<img id="flop3" style="position:relative; top:0px; left:103px; width: 35px" src=""></img>
									<!--++++++++++++++++++++++++++++++++++TURN++++++++++++++++++++++++++++++++++++ -->
									<img id="turn" style="position:relative; top:0px; left:108px; width: 35px" src=""></img>
									<!--++++++++++++++++++++++++++++++++++RIVER+++++++++++++++++++++++++++++++++++ -->
									<img id="river" style="position:relative; top:0px; left:113px; width: 35px" src=""></img>
									<!--++++++++++++++++++++++++++++++++++POT++++++++++++++++++++++++++++++++++++ -->
									<img id="pot_chips" style="position:relative; top:0px; left:130px; width: 35px" src="img/chips/chips.png"></img>
									<font id="pot_size" style="position:relative; top:-10px; left:140px;">pot</font>
								</td>
							</tr>
							<tr height="50">
								<td width="100">
									<img style="position:relative; top:-10px; left:35px; width: 35px"src="img/chips/chips.png"></img>
								</td>
								<td>
									<table>
										<tr>
											<td>
												<img style="position:relative; top:-30px; left:20px; width: 35px"src="img/chips/chips.png"></img>
												<font id="player_bet" style="position:relative; top:-40px; left:25px">bet</font>
											</td>
										</tr>
										<tr>
											<td>
												<img id="player_card1" style="position:relative; top:-30px; left:10px; width: 35px"  border="2" SRC="img/cards/Ac.png">
												<img id="player_card2" style="position:relative; top:-30px; left:15px; width: 35px"  border="2" SRC="img/cards/Kc.png">
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
						<div id="player_chips" style="position:relative; top:-129px; left:-30px; width:80px; height:80px">
							
						</div>
					</td>
					<td>
						<img id="player_avatar" style="position:relative; top:-70px; left:-250px; width:80px; height:80px"  border="2" src="">
						<div id="player_name" style="position:relative; top:-70px; left:-250px; width:80px; height:80px"></div>
					</td>
				</tr>
 				<tr>
 					<td>
 						<img id="fold_button" src="img/layout/fold.png" style="position:relative; top:-90px; left:300px;"></img>
 						<img id="call_button" src="img/layout/call.png" style="position:relative; top:-90px; left:340px;"></img>
 						<img id="raise_button" src="img/layout/raise.png" style="position:relative; top:-90px; left:390px;"></img>
 					</td>
 				</tr>
 				<tr height="30">
 					<td>
						<form action="pokerGame.html" method="post" style="position:relative; top:-90px; left:450px; width:80px; height:80px; border: 2px">
							<input id="userBetInput" type="text" value="userbet">
						</form>
						<div id="attackBlock"style="position:relative; top:-150px; left:0px; width:80px; border: 2px">
							<input id="botBetInput" type="text" value="bot bet">
						</div>
 					</td>			
				</tr>
			</table>
		</tr>
	</table>
</body>
</html>