$(document).ready(function() {
	$("#10_button").click(function() {
		var attr = $("#10_button").attr("class");
		if (attr == "active") {
			var src = $("#10_button").attr("src");
			$("#bet").attr("src", src);
			$("#playerBet").empty().append("10");
			$("#deal_button").attr("src", "img/layout/deal.png");
			$("#deal_button").attr("class", "active");
		}
	});

	$("#25_button").click(function() {
		var attr = $("#25_button").attr("class");
		if (attr == "active") {
			var src = $("#25_button").attr("src");
			$("#bet").attr("src", src);
			$("#playerBet").empty().append("25");
			$("#deal_button").attr("src", "img/layout/deal.png");
			$("#deal_button").attr("class", "active");
		}
	});
	$("#50_button").click(function() {
		var attr = $("#50_button").attr("class");
		if (attr == "active") {
			var src = $("#50_button").attr("src");
			$("#bet").attr("src", src);
			$("#playerBet").empty().append("50");
			$("#deal_button").attr("src", "img/layout/deal.png");
			$("#deal_button").attr("class", "active");
		}
	});
	$("#100_button").click(function() {
		var attr = $("#100_button").attr("class");
		if (attr == "active") {
			var src = $("#100_button").attr("src");
			$("#bet").attr("src", src);
			$("#playerBet").empty().append("100");
			$("#deal_button").attr("src", "img/layout/deal.png");
			$("#deal_button").attr("class", "active");
		}
	});

});