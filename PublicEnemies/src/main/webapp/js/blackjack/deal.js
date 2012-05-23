$(document).ready(function() {
	$("img#deal_button").click(function() {
		var bet = $("#bet").val();
		var nothing = null;
		sendAjax(bet, nothing);
	});

	function sendAjax(bet, nothing) {
		$.ajax
		{
			$.ajax({
				url : "DealBlackJackController.html",
				data : ({
					playerBet : bet,
					playerNothing : nothing
				}),
				success : function(data) {
					var round = jQuery.parseJSON(data);
					allDataUpdate(round);
				},
				error : function(e, ajaxOptions, thrownError) {
					alert(e.status);
					alert(thrownError);
					alert("Error in dealSend()");
				}

			});
		}

	}
	
	function allDataUpdate(round)
	{
		var i = 0;
		for(i = 0; i < round.playerCards.length ; i = i + 1){
			$("#cards").append("<img src="+round.playerCards[i].image+"></img>");			
		}
	}

});