var redOnes = new Array(1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36);
var blackOnes = new Array(2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35);

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
	
	$(".RouletteTableAdd").click(function() {
		try{
		if (clearBetToggle == false){
			$(this).css("opacity", faded);
			if (isNaN(arr[$(this).attr("alt")])) arr[$(this).attr("alt")] = 0;
			arr[$(this).attr("alt")] += parseInt($("input[@name=betVal]:checked").val());
			if ($(this).attr("alt")=="red1") red1();
			if ($(this).attr("alt")=="red2") red2();
			if ($(this).attr("alt")=="red3") red3();
			if ($(this).attr("alt")=="black1") black1();
			if ($(this).attr("alt")=="black2") black2();
			if ($(this).attr("alt")=="black3") black3();
		}else 
			{$(this).css("opacity", "1");
			arr[$(this).attr("alt")] = 0;
		}
		}catch(e){e.message;};
	});
	
	$(".RouletteTable").click(function() {
		try{
		if (clearBetToggle == false){
			$(this).css("opacity", faded);
			if (isNaN(arr[$(this).attr("alt")])) arr[$(this).attr("alt")] = 0;
			arr[$(this).attr("alt")] += parseInt($("input[@name=betVal]:checked").val());
			
//			alert(arr[$(this).attr("alt")]);
		}else 
			{$(this).css("opacity", "1");
			arr[$(this).attr("alt")] = 0;
		}
		}catch(e){e.message;};
		
	});

	// ====================================================
	function red1(){
		for (var i=1; i<=12 ; i++){
			for (var k=0;k<=17;k++){
			if (isNaN(arr[i])) arr[i] = 0;
			if (i==parseInt(redOnes[k])) arr[i] += parseInt($("input[@name=betVal]:checked").val());
			}
		}
	}

	function red2(){
		for (var i=12; i<=24 ; i++){
			for (var k=0;k<=17;k++){
				if (isNaN(arr[i])) arr[i] = 0;
				if (i==parseInt(redOnes[k])) arr[i] += parseInt($("input[@name=betVal]:checked").val());
			}
		}
	}

	function red3(){
		for (var i=24; i<=36 ; i++){
			for (var k=0;k<=17;k++){
				if (isNaN(arr[i])) arr[i] = 0;
				if (i==parseInt(redOnes[k])) arr[i] += parseInt($("input[@name=betVal]:checked").val());
			}
		}
	}

	function black1(){
		for (var i=1; i<=12 ; i++){
			for (var k=0;k<=17;k++){
				if (isNaN(arr[i])) arr[i] = 0;
				if (i==parseInt(blackOnes[k])) arr[i] += parseInt($("input[@name=betVal]:checked").val());
			}
		}
	}
	
	function black2(){
		for (var i=12; i<=24 ; i++){
			for (var k=0;k<=17;k++){
				if (isNaN(arr[i])) arr[i] = 0;
				if (i==parseInt(blackOnes[k])) arr[i] += parseInt($("input[@name=betVal]:checked").val());
			}
		}
	}
	
	function black3(){
		for (var i=24; i<=36 ; i++){
			for (var k=0;k<=17;k++){
				if (isNaN(arr[i])) arr[i] = 0;
				if (i==parseInt(blackOnes[k])) arr[i] += parseInt($("input[@name=betVal]:checked").val());
			}
		}
	}
	
	$("#btn_test").click(
		function() {
			$("#userBetNumbers").val("");
			for ( var i = 0; i < (parseInt(arr.length.toString())); i++) {
				if (arr[i] > 0) {
					$("#userBetNumbers").val($("#userBetNumbers").val() + i + ":" + arr[i] + ';');
				}
			}
	});
	
	$(".RouletteTable.RouletteTable").mousemove(function(){
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
