var arr = new Array();
var currentBet;
var clearBetToggle = new Boolean(false);
var faded = "0.6";
$(function() {

	// $("#userBetNumbers").val("");
	$("#clearBet").toggle(function(){
		$(this).css("opacity", faded);
		clearBetToggle = true;
	}, function(){
		$(this).css("opacity", "1");
		clearBetToggle = false;
	});
	
	$(".RouletteTable").click(function() {
		try{
		if (clearBetToggle == false){
			$(this).css("opacity", faded);
			if (isNaN(arr[$(this).attr("alt")])) arr[$(this).attr("alt")] = 0;
			arr[$(this).attr("alt")] = arr[$(this).attr("alt")] + parseInt($("input[@name=betVal]:checked").val());
//			alert(arr[$(this).attr("alt")]);
		}else 
			{$(this).css("opacity", "1");
			arr[$(this).attr("alt")] = 0;
		}
		}catch(e){e.message;};
	});
	// ====================================================
	$("#btn_test").click(
		function() {
			$("#userBetNumbers").val("");
			for ( var i = 0; i < (parseInt(arr.length.toString())); i++) {
				if (arr[i] > 0) {
					$("#userBetNumbers").val($("#userBetNumbers").val() + i + ":" + arr[i] + ';');
				}
			}
	});
	
	$(".RouletteTable").mousemove(function(){
		if (isNaN(arr[$(this).attr("alt")])) arr[$(this).attr("alt")]=0;
		$("#showBet").html(arr[$(this).attr("alt")]);
	});

	$(".RouletteTable").hover(function(){
			$(this).fadeOut(100);
			$(this).fadeIn(300);
		}, function(){}
	);
});

function form_send() { //MAKE UP!!!!!!!!!!!!
	$("#userBetNumbers").val("");
	for ( var i = 0; i < (parseInt(arr.length.toString())); i++) {
		if (arr[i] > 0) {
			$("#userBetNumbers").val($("#userBetNumbers").val() + i + ":" + arr[i] + ';');
		}
	}
}
