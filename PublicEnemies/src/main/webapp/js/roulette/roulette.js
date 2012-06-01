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
//			$("#betOnTable").html(parseInt($("#betOnTable").html()) + parseInt($("input[@name=betVal]:checked").val()));
			$("#betOnTable").html(parseInt($("#betOnTable").html()) + currentBet);
			if (isNaN(bets.betsOnNumbers[$(this).attr("alt")])) bets.betsOnNumbers[$(this).attr("alt")] = 0;
//			bets.betsOnNumbers[$(this).attr("alt")] += parseInt($("input[@name=betVal]:checked").val());
			bets.betsOnNumbers[$(this).attr("alt")] += currentBet;
			
//			alert(arr[$(this).attr("alt")]);
		}else 
			{$(this).css("opacity", "1");
			bets.betsOnNumbers[$(this).attr("alt")] = 0;
		}
	});

	// ====================================================
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

//	$("#submit").click(function(){
//try{		
//		$("#img_roulette").attr("src","img/roulette/roulette.gif");
//		setTimeout(function(){$("#img_roulette").attr("src","img/roulette/roulette_static.png");},3000);
//	
//		$("#userBetNumbers").val("");
//		for ( var i = 0; i < (parseInt(bets.betsOnNumbers.length.toString())); i++) {
//			if (bets.betsOnNumbers[i] > 0) {
//				$("#userBetNumbers").val($("#userBetNumbers").val() + i + ":" + bets.betsOnNumbers[i] + ';');
//			}
//		}
//		document.forms["submitForm"].submit();
////		$("form#submitForm").submit();
//}catch(e){e.message;};
//	});
	
	$("#DEAL").click(function(){
			$.ajax({
				
				type: "POST",
				url: "rouletteGame.html",
				data : ({
					userBetNumbers : $("#userBetNumbers").val(),
				}),
				success: function(data){
					alert(data);
//					$('form#submit').hide(function(){$('div.success').fadeIn();});
				}
			});
		return false;
	});

});

