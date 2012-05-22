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
					userBet : bet,
					userNothing : nothing
				}),
				success : function(data) {
				},
				error : function(e, ajaxOptions, thrownError) {
					alert(e.status);
					alert(thrownError);
					alert("Error in dealSend()");
				}

			});
		}

	}

});