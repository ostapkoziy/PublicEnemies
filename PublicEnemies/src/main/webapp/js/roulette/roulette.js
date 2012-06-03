var bets = new Object();
bets.betsOnNumbers = [];

var clearBetToggle = new Boolean(false);
var faded = "0.6";
$(document).ready(function() {
	var currentBet = 0;

	$("#clearBet").click(function() {
		for ( var i = 0; i < (parseInt(bets.betsOnNumbers.length.toString())); i++) {
			bets.betsOnNumbers[i] = 0;
		}
		$("#betOnTable").html(0);
	});

	$(".RouletteTable").click(function() {
		if (clearBetToggle == false) {
			$(this).css("opacity", faded);
			$("#betOnTable").html(parseInt($("#betOnTable").html()) + currentBet);
			if (isNaN(bets.betsOnNumbers[$(this).attr("alt")]))
				bets.betsOnNumbers[$(this).attr("alt")] = 0;
			bets.betsOnNumbers[$(this).attr("alt")] += currentBet;
		} else {
			$(this).css("opacity", "1");
			bets.betsOnNumbers[$(this).attr("alt")] = 0;
		}
	});

	$(".chips").toggle(function() {
		currentBet += parseInt($(this).attr("alt"));
		$(this).css("opacity",1);
	}, function() {
		currentBet -= parseInt($(this).attr("alt"));
		$(this).css("opacity",faded);
	});

	$("#btn_test").click(function() {
		$("#img_roulette").attr("src", "img/roulette/roulette.gif");
		setTimeout(function() {
			$("#img_roulette").attr("src", "img/roulette/roulette_static.png");
		}, 3000);
	});

	$(".RouletteTable").mousemove(function() {
		if (isNaN(bets.betsOnNumbers[$(this).attr("alt")]))
			bets.betsOnNumbers[$(this).attr("alt")] = 0;
		$("#showBet").html(bets.betsOnNumbers[$(this).attr("alt")]);
	});

	$("#DEAL").click(function() {
		betStr = "";
		for ( var i = 0; i < (parseInt(bets.betsOnNumbers.length.toString())); i++) {
			if (bets.betsOnNumbers[i] > 0) {
				betStr += i + ":" + bets.betsOnNumbers[i] + ';';
			}
		}
		if (betStr!=""){
		$("#img_roulette").attr("src", "img/roulette/roulette.gif");
		setTimeout(function() {
			$("#img_roulette").attr("src", "img/roulette/roulette_static.png");
			$.ajax({
			type : "POST",
			url : "rouletteLogic.html",
			data : ({
				userBetNumbers : betStr
			}),
			success : function(data) {
				var rouletteGameInfo = jQuery.parseJSON(data);
				// alert(data);
				$("#chipsAmount").html(rouletteGameInfo.chips + " chips");
				$("#message").html(rouletteGameInfo.msg);
			}
			});
		}, 1500);// Roulette spinning time
		}else alert("Make your BET on a roulette table!");

	});

});
