	var bets = new Object();
		bets.betsOnNumbers = [];

	var currentBet;
	var clearBetToggle = new Boolean(false);
	var faded = "0.6";
$(document).ready(function(){
	

	$("#clearBet").toggle(function(){
		$(this).css("opacity", faded);
		clearBetToggle = true;
	}, function(){
		$(this).css("opacity", "1");
		clearBetToggle = false;
	});
	
	$(".RouletteTable").click(function() {
		if (clearBetToggle == false){
			$(this).css("opacity", faded);
			if (isNaN(bets.betsOnNumbers[$(this).attr("alt")])) bets.betsOnNumbers[$(this).attr("alt")] = 0;
			bets.betsOnNumbers[$(this).attr("alt")] += parseInt($("input[@name=betVal]:checked").val());
			
//			alert(arr[$(this).attr("alt")]);
		}else 
			{$(this).css("opacity", "1");
			bets.betsOnNumbers[$(this).attr("alt")] = 0;
		}
	});

	// ====================================================
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

	$(".RouletteTable").hover(function(){
			$(this).fadeOut(100);
			$(this).fadeIn(300);
		}, function(){}
	);
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
