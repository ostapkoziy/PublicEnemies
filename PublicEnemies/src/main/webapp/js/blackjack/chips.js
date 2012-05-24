$(document).ready(function() {
	$("#10_button").click(function() {
		var src = $("#10_button").attr("src");
		$("#bet").attr("src", src);
		$("#playerBet").empty().val("10");
		$("#playerBet").empty().append("10");
		$("#deal_button").attr("src", "img/layout/deal.png");
	});

	$("#25_button").click(function() {
		var src = $("#25_button").attr("src");
		$("#bet").attr("src", src);
		$("#playerBet").empty().val("25");
		$("#playerBet").empty().append("25");
		$("#deal_button").attr("src", "img/layout/deal.png");
	});
	$("#50_button").click(function() {
		var src = $("#50_button").attr("src");
		$("#bet").attr("src", src);
		$("#playerBet").empty().val("50");
		$("#playerBet").empty().append("50");
		$("#deal_button").attr("src", "img/layout/deal.png");
	});
	$("#100_button").click(function() {
		var src = $("#100_button").attr("src");
		$("#bet").attr("src", src);
		$("#playerBet").empty().val("100");
		$("#playerBet").empty().append("100");
		$("#deal_button").attr("src", "img/layout/deal.png");
	});

});