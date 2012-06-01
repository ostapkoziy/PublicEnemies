	var bets = new Object();
		bets.betsOnNumbers = [];

	var clearBetToggle = new Boolean(false);
	var faded = "0.6";
$(document).ready(function(){
	var currentBet=0;
	
	$("#clearBet").click(function(){
		for ( var i = 0; i < (parseInt(bets.betsOnNumbers.length.toString())); i++) {
			bets.betsOnNumbers[i] = 0;
		}
		$("#betOnTable").html(0);
	});
	
	$(".RouletteTable").click(function() {
		if (clearBetToggle == false){
			$(this).css("opacity", faded);
			$("#betOnTable").html(parseInt($("#betOnTable").html()) + currentBet);
			if (isNaN(bets.betsOnNumbers[$(this).attr("alt")])) bets.betsOnNumbers[$(this).attr("alt")] = 0;
			bets.betsOnNumbers[$(this).attr("alt")] += currentBet;
		}else 
			{$(this).css("opacity", "1");
			bets.betsOnNumbers[$(this).attr("alt")] = 0;
		}
	});

	$(".chips").toggle(function(){
		currentBet += parseInt($(this).attr("alt"));
 		$(this).addClass("highlighted");
	},function(){
		currentBet -= parseInt($(this).attr("alt"));
		$(this).removeClass("highlighted");
	});
	
	$("#btn_test").click(
		function() {
			$("#img_roulette").attr("src","img/roulette/roulette.gif");
			setTimeout(function(){$("#img_roulette").attr("src","img/roulette/roulette_static.png");},3000);
	});
	
	$(".RouletteTable").mousemove(function(){
		if (isNaN(bets.betsOnNumbers[$(this).attr("alt")])) bets.betsOnNumbers[$(this).attr("alt")]=0;
		$("#showBet").html(bets.betsOnNumbers[$(this).attr("alt")]);
	});


	$("#DEAL").click(function(){
		$("#userBetNumbers").val("");
		for ( var i = 0; i < (parseInt(bets.betsOnNumbers.length.toString())); i++) {
			if (bets.betsOnNumbers[i] > 0) {
				$("#userBetNumbers").val($("#userBetNumbers").val() + i + ":" + bets.betsOnNumbers[i] + ';');
			}
		}
		
		$("#img_roulette").attr("src","img/roulette/roulette.gif");
		setTimeout(function(){
			$("#img_roulette").attr("src","img/roulette/roulette_static.png");
			$.ajax({
				type: "POST",
				url: "rouletteLogic.html",
				data : ({
					userBetNumbers : $("#userBetNumbers").val(),
				}),
				success: function(data){
					$("#chipsAmount").html(data);
				}
			});
		},1000);//Roulette spinning time
	});

});

