$(document).ready(function(){
	var count = 0;
	var image_prefix = "img/cards/";
	var image_suffix = ".png";
	
	betSend(0,0);
	//deal cards
	$("img#deck").click(function(){
		count ++;
		if(count == 1){
			dealFlop("Ts","Js","Qs");
		}
		else if (count == 2){
			dealTurn("Ks");
		}
		else if (count == 3){
			dealRiver("As");
		}
		
	});
	$("#botBetInput").hide();

	function dealFlop (card1, card2, card3){
		$("img#flop1").attr("src", image_prefix + card1 + image_suffix);
		$("img#flop2").attr("src", image_prefix + card2 + image_suffix);
		$("img#flop3").attr("src", image_prefix + card3 + image_suffix);
	}
	function dealTurn (card1){
		$("img#turn1").attr("src", image_prefix + card1 + image_suffix);

	}
	function dealRiver (card1){
		$("img#river1").attr("src", image_prefix + card1 + image_suffix);
	}
	
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

		
		$("div#botBet").empty().append(pokerGame.pokerGameRound.player2Bet);
		$("div#playerBet").empty().append(pokerGame.pokerGameRound.player1Bet);
		$("img#player_avatar").attr("src", pokerGame.user1Profile.avatar);
		$("#player_name").empty().append(pokerGame.user1Profile.nickName);
		$("#player_chips").empty().append(pokerGame.user1Profile.money);
		var p1c1 = pokerGame.pokerGameRound.player1Hand.card1.value.name + "" + pokerGame.pokerGameRound.player1Hand.card1.suit.name;
		var p1c2 = pokerGame.pokerGameRound.player1Hand.card2.value.name + "" + pokerGame.pokerGameRound.player1Hand.card2.suit.name;
		var p2c1 = pokerGame.pokerGameRound.player2Hand.card1.value.name + "" + pokerGame.pokerGameRound.player2Hand.card1.suit.name;
		var p2c2 = pokerGame.pokerGameRound.player2Hand.card2.value.name + "" + pokerGame.pokerGameRound.player2Hand.card2.suit.name;
		//$("#bot_card1").attr("src",image_prefix + p2c1 + image_suffix);
		//$("#bot_card2").attr("src",image_prefix + p2c2 + image_suffix);
		$("#player_card1").attr("src",image_prefix + p1c1 + image_suffix);
		$("#player_card2").attr("src",image_prefix + p1c2 + image_suffix);
	}
	
	$(function()
	{
		$("#raise_button").click(function()
		{
			var userBet = $("#userBetInput").val();
			$("#playerBet").empty().append(userBet);
			var botBet = $("#botBetInput").val();

			if (userBet != undefined & botBet != undefined)
			{
				betSend(userBet, botBet);
			}
		});

	});

});

