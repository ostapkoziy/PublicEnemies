var arr = new Array();
$(function() {

	// $("#userBetNumbers").val("");

	$(".RouletteTable").toggle(function() {// onCheck
		$(this).css("opacity", ".5");
		arr[$(this).attr("id")] = '+';

	}, function() {// onUncheck
		$(this).css("opacity", "1");
		arr[$(this).attr("id")] = '-';
	});
	// ====================================================

	$("#btn_test")
			.click(
					function() {
						try {
							$("#userBetNumbers").val("");
							for ( var i = 0; i < (parseInt(arr.length
									.toString())); i++) {
								if (arr[i] == '+') {
									$("#userBetNumbers").val(
											$("#userBetNumbers").val() + i
													+ ',');
								}
							}
						} catch (e) {
							alert(e.message);
						}
					});
});

function betChanged(bet) {
	// alert(bet.value);
}

function form_send() {
	//alert("sending...");
	$("#userBetNumbers").val("");
	for ( var i = 0; i < (parseInt(arr.length.toString())); i++) {
		if (arr[i] == '+') {
			$("#userBetNumbers").val($("#userBetNumbers").val() + i + ',');
		}
	}
}
