var redOnes = 	new Array(1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36);
var blackOnes = new Array(2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35);
var bets = new Object();
	bets.betsOnNumbers = [];


//var arr = new Array();
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
			alert(JSON.stringify(bets));
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

function form_send() { //MAKE UP!!!!!!!!!!!!
//	$("#userBetNumbers").val(JSON.stringify(bets));
	
	$("#userBetNumbers").val("");
	for ( var i = 0; i < (parseInt(bets.betsOnNumbers.length.toString())); i++) {
		if (bets.betsOnNumbers[i] > 0) {
			$("#userBetNumbers").val($("#userBetNumbers").val() + i + ":" + bets.betsOnNumbers[i] + ';');
		}
	}
}
