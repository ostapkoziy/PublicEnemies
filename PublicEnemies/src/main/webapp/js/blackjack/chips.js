$(document).ready(function() {
	$("#10_button").click(function() {
		var attr = $("#10_button").attr("class");
		if (attr == "active") {
			var src = $("#10_button").attr("src");
			var width = $("#10_button").attr("width");
			$("#bet").attr("src", src);
			$("#bet").attr("width", width);
			$("#playerBet").empty().append("10");
			$("#deal_button").attr("src", "img/layout/deal.png");
			$("#deal_button").attr("class", "active");
		}
	});

	$("#25_button").click(function() {
		var attr = $("#25_button").attr("class");
		if (attr == "active") {
			var src = $("#10_button").attr("src");
			var width = $("#10_button").attr("width");
			$("#bet").attr("src", src);
			$("#bet").attr("width", width);
			$("#playerBet").empty().append("25");
			$("#deal_button").attr("src", "img/layout/deal.png");
			$("#deal_button").attr("class", "active");
		}
	});
	$("#50_button").click(function() {
		var attr = $("#50_button").attr("class");
		if (attr == "active") {
			var src = $("#10_button").attr("src");
			var width = $("#10_button").attr("width");
			$("#bet").attr("src", src);
			$("#bet").attr("width", width);
			$("#playerBet").empty().append("50");
			$("#deal_button").attr("src", "img/layout/deal.png");
			$("#deal_button").attr("class", "active");
		}
	});

});