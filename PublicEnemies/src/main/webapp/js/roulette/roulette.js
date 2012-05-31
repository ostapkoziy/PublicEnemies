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
			$("#userBetNumbers").val("");
			for ( var i = 0; i < (parseInt(bets.betsOnNumbers.length.toString())); i++) {
				if (bets.betsOnNumbers[i] > 0) {
					$("#userBetNumbers").val($("#userBetNumbers").val() + i + ":" + bets.betsOnNumbers[i] + ';');
				}
			}
	});
	
	
	
	$(".RouletteTable").mousemove(function(){
		if (isNaN(bets.betsOnNumbers[$(this).attr("alt")])) bets.betsOnNumbers[$(this).attr("alt")]=0;
		$("#showBet").html(bets.betsOnNumbers[$(this).attr("alt")]);
	});

});

//function arr_init(){for (var i = 0; i < 48; i++) bets.betsOnNumbers[i] = 0;}

function form_send() { //MAKE UP!!!!!!!!!!!!
//	$("#userBetNumbers").val(JSON.stringify(bets));
	
	$("#userBetNumbers").val("");
	for ( var i = 0; i < (parseInt(bets.betsOnNumbers.length.toString())); i++) {
		if (bets.betsOnNumbers[i] > 0) {
			$("#userBetNumbers").val($("#userBetNumbers").val() + i + ":" + bets.betsOnNumbers[i] + ';');
		}
	}
}
