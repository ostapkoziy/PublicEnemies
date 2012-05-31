	var bets = new Object();
		bets.betsOnNumbers = [];

	var clearBetToggle = new Boolean(false);
	var faded = "0.6";
$(document).ready(function(){
	var currentBet=0;
	
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
		currenBet += parseInt($(this).attr("alt"));
		alert(parseInt($(this).attr("alt")));
 		$(this).addClass("highlighted");
	},function(){
		$(this).removeClass("highlighted");
		currenBet -= parseInt($(this).attr("alt"));
		alert(currenBet);
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
