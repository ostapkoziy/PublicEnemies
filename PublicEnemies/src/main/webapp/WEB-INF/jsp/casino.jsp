<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/blackjack/casino.js"></script>
<link rel="stylesheet" href="css/casino.css" type="text/css">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	$("#blackjackInput").hide();
	$("#blackjackSubmit").hide();
	
	$("#pokerInput").hide();
	$("#pokerSubmit").hide();
	
	$("#rouletteInput").hide();
	$("#rouletteSubmit").hide();
	
	$("#inputDiv").hide();
	var gameType = "";
	var game = "";
	$("#blackjack, #poker, #roulette").click(function(){
		gameType = $(this).attr("id");
		 $("#inputDiv").slideDown(1000).delay(5000).slideUp(1000);
		 game = gameType;
		 gameType+="Input";
	});
	
	$("#submitButton").click(function(){
		var chips = $("#chipInput").val();
		$("#" + gameType).val(chips);
		game += "Submit";
		$("#" + game).click();
	});
});


</script>
</head>
<body>
	<table align="center">
		<tr>
			<td align="center"><a href="userStartPage.html"><img src="img/gamelogo.png"></img></a></td>
		</tr>
		<tr>
			<table id="main_table" class="sample" align="center" width="500" height="600">
				<tr>
					<td>
						<img id="blackjack" class="highlight" style="position: relative; left:-200px" src="img/casino-blackjack.png" alt="Submit button"></img>
					</td>
					<td>
						<img id="poker" class="highlight" style="position: relative; left:0px" src="img/casino-poker.png" alt="Submit button"></img>					
					</td>
					<td>
						<img id="roulette" class="highlight" style="position: relative; left:200px" src="img/casino-roulette.png" alt="Submit button"></img>
					</td>
				</tr>
				<tr>
					<td>
						<form id="blackJackForm" action="blackJackGame.html" method="post">
							<input id="blackjackInput" type="text" name="chips">
							<button id="blackjackSubmit" type="submit" class="button">BlackJack</button>
						</form>

						<form id="pokerForm" action="createPokerGame.html" method="post">
							<input id="pokerInput" type="text" name="chips">
							<button id="pokerSubmit" type="submit" class="button">Poker</button>
							
						</form>

						<form id="rouletteForm" action="rouletteGame.html" method="post">
							<input id="rouletteInput" type="text" name="chips">
							<button id="rouletteSubmit" type="submit" class="button">Roulette</button>
							
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<div align="center" id="inputDiv">
							<h4>Enter the amount of chips</h4>
							<input id="chipInput">
							<button id="submitButton">Start</button>
						</div>
					</td>
				</tr>
			</table>
		</tr>
	</table>
</body>
</html>