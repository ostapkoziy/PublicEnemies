$(document).ready(function(){
	var count = 0;
	betSend(0,0);
	//deal cards
	$("img#deck").click(function(){
		count ++;
		if(count == 1){
			$("img#flop1").attr("src", "img/cards/Ts.png");
			$("img#flop2").attr("src", "img/cards/Js.png");
			$("img#flop3").attr("src", "img/cards/Qs.png");
		}
		else if (count == 2){
			$("img#turn").attr("src", "img/cards/Ks.png");
		}
		else if (count == 3){
			$("img#river").attr("src", "img/cards/As.png");
		}
	});

	/**
	 * Send USER HIT and BLOCK if <br/><b>Success:</b> coockie.hit=true and hide
	 * attack button;
	 * 
	 */
	function betSend(userBet, botBet)
	{
		$.ajax({
			url : "PokerServlet.html",
			data : ({
				userBet : userBet,
				botBet : botBet }),
			success : function(data)
			{
				var game = jQuery.parseJSON(data);
				allDataUpdate(game);
			},
			error : function(e, ajaxOptions, thrownError)
			{
				alert(e.status);
				alert(thrownError);
				alert("Error in hitSend()");
			}

		});
	}

	/*******************************************************************************
	 * UPDATE ALL DATA ON PAGE
	 ******************************************************************************/
	function allDataUpdate(pokerGame)
	{
		var image_prefix = "img/cards/";
		var image_suffix = ".png";
		$("img#player_avatar").attr("src", pokerGame.user1Profile.avatar);
		$("#player_name").empty().append(pokerGame.user1Profile.nickName);
		$("#player_chips").empty().append(pokerGame.user1Profile.money);
		var p1c1 = pokerGame.pokerGameEngine.player1Hand.card1.value.name + "" + pokerGame.pokerGameEngine.player1Hand.card1.suit.name;
		var p1c2 = pokerGame.pokerGameEngine.player1Hand.card2.value.name + "" + pokerGame.pokerGameEngine.player1Hand.card2.suit.name;
		var p2c1 = pokerGame.pokerGameEngine.player2Hand.card1.value.name + "" + pokerGame.pokerGameEngine.player2Hand.card1.suit.name;
		var p2c2 = pokerGame.pokerGameEngine.player2Hand.card2.value.name + "" + pokerGame.pokerGameEngine.player2Hand.card2.suit.name;
		//$("#bot_card1").attr("src",image_prefix + p2c1 + image_suffix);
		//$("#bot_card2").attr("src",image_prefix + p2c2 + image_suffix);
		$("#player_card1").attr("src",image_prefix + p1c1 + image_suffix);
		$("#player_card2").attr("src",image_prefix + p1c2 + image_suffix);
		
		alert("BLINDS - " + pokerGame.pokerGameEngine.table.player1Bet + " and " + pokerGame.pokerGameEngine.table.player2Bet);
	}
	
	$(function()
	{
		$("#raise_button").click(function()
		{
			var userBet = $("#userBetInput").val();
			$("#player_bet").empty().append(userBet);
			var botBet = $("#botBetInput").val();

			if (userBet != undefined & botBet != undefined)
			{
				betSend(userBet, botBet);
			}
		});

	});

});

