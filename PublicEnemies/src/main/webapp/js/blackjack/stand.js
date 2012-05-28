$(document).ready(function() {
	$("img#stand_button").click(function() {
		var nothing1 =null;
		var nothing2 = null;
		var attr = $("#stand_button").attr("src");
		if(attr != "img/layout/standg.png")
		sendAjax(nothing1, nothing2);
	});

	function sendAjax(nothing1, nothing2) {
		$.ajax
		{
			$.ajax({
				url : "StandBlackJackController.html",
				data : ({
					playerNothing1 : nothing1,
					playerNothing2 : nothing2
				}),
				success : function(data) {
					var game = jQuery.parseJSON(data);
					allDataUpdate(game);
				},
				error : function(e, ajaxOptions, thrownError) {
					alert("Make a bet!");
				}

			});
		}

	}
	
	function allDataUpdate(game)
	{
		var i = 0;
		$("#dealer_cards").empty();
		for(i = 0; i < game.round.dealerCards.length ; i = i + 1){
			$("#dealer_cards").append("<img src="+game.round.dealerCards[i].image+"></img>");			
		}
		// Chips
		$("#playerChips").empty().append(game.chips);

		$("#result").empty().append(game.round.playerResult);
		$("#deal_button").attr("src", "img/layout/rebeat.png");
		$("#stand_button").attr("src", "img/layout/standg.png");
		$("#hit_button").attr("src", "img/layout/hitg.png");
		$("#double_button").attr("src", "img/layout/doubleg.png");
	}

});