$(document).ready(function(){
	$("#deal").click(function(){
		alert("уси");
		var bet = $("#bet").val();
		var block = null;
		sendAjax(bet, block);
	});

	function sendAjax(bet, block){
		$.ajax{
			$.ajax({
				url : "StartBlackJackController.html",
				data : ({
					userBet : bet,
					userBlock : block }),
				success : function(data)
				{
					alert("SUCCESS " + data);
				},
				error : function(e, ajaxOptions, thrownError)
				{
					alert(e.status);
					alert(thrownError);
					alert("Error in hitSend()");
				}

			});
		}
		
	}
	
});