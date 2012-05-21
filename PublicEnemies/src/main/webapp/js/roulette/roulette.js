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
			if (isNaN(arr[$(this).attr("id")])) arr[$(this).attr("id")] = 0;
			arr[$(this).attr("id")] = arr[$(this).attr("id")] + parseInt($("input[@name=betVal]:checked").val());
//			alert(arr[$(this).attr("id")]);
		}else 
			{$(this).css("opacity", "1");
			arr[$(this).attr("id")] = 0;
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
		if (isNaN(arr[$(this).attr("id")])) arr[$(this).attr("id")]=0;
		$("#showBet").html(arr[$(this).attr("id")]);
	});

	$(".RouletteTable").hover(function(){
		$(this).fadeOut(100);
		$(this).fadeIn(200);
	});
});

function form_send() { //MAKE UP!!!!!!!!!!!!
	$("#userBetNumbers").val("");
	for ( var i = 0; i < (parseInt(arr.length.toString())); i++) {
		if (arr[i] > 0) {
			$("#userBetNumbers").val($("#userBetNumbers").val() + i + ":" + arr[i] + ';');
		}
	}
}
