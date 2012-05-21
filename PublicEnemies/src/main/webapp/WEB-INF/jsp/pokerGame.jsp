<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/poker.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<!-- <script language="javascript" src="js/regular.js"></script> -->
<title>Poker</title>
<script type="text/javascript">
$(document).ready(function(){
	var count = 0;
	//deal cards
	$("img#deck").click(function(){
		count ++;
		if(count == 1){
			$("img#flop1").attr("src", "img/cards/Ts.png");
			$("img#flop2").attr("src", "img/cards/Js.png");
			$("img#flop3").attr("src", "img/cards/Qs.png");
		}
		else if (count == 2){
			$("img#turn").attr("src", "img/cards/Ks.png");
		}
		else if (count == 3){
			$("img#river").attr("src", "img/cards/As.png");
		}
		
	});

	
});

</script>
<title>Poker</title>
</head>
<body>
	<table align="center">
		<tr>
			<td align="center"><img src="img/gamelogo.png"></img></td>
		</tr>
		<tr>
			<table id="poker_table" class="sample" align="center"  width="1000">
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
									<img style="position:relative; top:40px; left:10px; width: 35px"  border="2" SRC="img/cards/back_image.png">
									<img style="position:relative; top:40px; left:15px; width: 35px"  border="2" SRC="img/cards/back_image.png">
								</td>
								<td>
									<h4 style="position:relative; left:-35px; top: 40px" src="img/chips/chips.png">1000</h4>
								</td>
							</tr>
							<tr height="120">
								<td colspan="3">	
									<!--++++++++++++++++++++++++++++++++++DECK++++++++++++++++++++++++++++++++++++ -->
									<img id="deck" style="position:relative; top:30px; left:40px; width: 40px" src="img/cards/deck.png"></img>
									<!--++++++++++++++++++++++++++++++++++FLOP++++++++++++++++++++++++++++++++++++ -->
									<img id="flop1" style="position:relative; top:30px; left:93px; width: 35px" src=""></img>
									<img id="flop2" style="position:relative; top:30px; left:98px; width: 35px" src=""></img>
									<img id="flop3" style="position:relative; top:30px; left:103px; width: 35px" src=""></img>
									<!--++++++++++++++++++++++++++++++++++TURN++++++++++++++++++++++++++++++++++++ -->
									<img id="turn" style="position:relative; top:30px; left:108px; width: 35px" src=""></img>
									<!--++++++++++++++++++++++++++++++++++RIVER+++++++++++++++++++++++++++++++++++ -->
									<img id="river" style="position:relative; top:30px; left:113px; width: 35px" src=""></img>
									<!--++++++++++++++++++++++++++++++++++POT++++++++++++++++++++++++++++++++++++ -->
									<img id="pot_chips" style="position:relative; top:30px; left:130px; width: 35px" src="img/chips/chips.png"></img>
									<font id="pot_size" style="position:relative; top:20px; left:140px;">0</font>
								</td>
							</tr>
							<tr height="50">
								<td width="100">
									<img style="position:relative; top:40px; left:35px; width: 35px"src="img/chips/chips.png"></img>
								</td>
								<td>
									<img style="position:relative; top:20px; left:10px; width: 35px"  border="2" SRC="img/cards/Ac.png">
									<img style="position:relative; top:20px; left:15px; width: 35px"  border="2" SRC="img/cards/Kc.png">
								</td>
								<td>
								</td>
							</tr>
						</table>
					</td>

				</tr>
				<tr align="center" height="70">
					<td>
						<h4 style="position:relative; top:-35px; left:-65px; width:80px; height:80px">${chips}</h4>
					</td>
					<td>
						<img style="position:relative; top:-20px; left:-250px; width:80px; height:80px"  border="2" SRC="${profile.getAvatar()}">
					</td>
				</tr>
 				<tr>
 					<td>
 						<img id="fold_button" src="img/layout/fold.png" style="position:relative; top:-30px; left:300px;"></img>
 						<img id="call_button" src="img/layout/call.png" style="position:relative; top:-30px; left:340px;"></img>
 						<img id="raise_button" src="img/layout/raise.png" style="position:relative; top:-30px; left:390px;"></img>
 					</td>
 				</tr>
 				<tr height="67">
 					<td>
						<form action="pokerGame.html" method="post" style="position:relative; top:-30px; left:450px; width:80px; height:80px; border: 2px">
							<input id="betInput" type="text" name="bet">
 							<button id="buttonSend" type="submit" class="button" style="position:relative; top: 5px; left:40px;">Send</button>
						</form>
 					</td>			
				</tr>
			</table>
		</tr>
	</table>
</body>
</html>