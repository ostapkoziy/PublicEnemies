$(document).ready(function(){
	var image_prefix = "img/cards/";
	var image_suffix = ".png";
	
	betSend(0,0);
	$("#botBetInput").hide();

	function dealFlop (card1, card2, card3){
		$("img#flop1").attr("src", image_prefix + card1 + image_suffix);
		$("img#flop2").attr("src", image_prefix + card2 + image_suffix);
		$("img#flop3").attr("src", image_prefix + card3 + image_suffix);
	}
	function dealTurn (card1){
		$("img#turn").attr("src", image_prefix + card1 + image_suffix);

	}
	function dealRiver (card1){
		$("img#river").attr("src", image_prefix + card1 + image_suffix);
	}
	
	
	$("#newRound").click(function(){
		betSend(0, -1);
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

		$("div#botBet").empty().append(pokerGame.pokerGameRound.player2Bet);
		$("div#playerBet").empty().append(pokerGame.pokerGameRound.player1Bet);
		if(pokerGame.pokerGameRound.player1Bet == pokerGame.pokerGameRound.player2Bet){
			evenBets(pokerGame);
		}
		if(pokerGame.pokerGameRound.result == "Player Folded"){
			alert("player Folded");
			roundEnded();
		}
		if(pokerGame.pokerGameRound.result == "New Round"){
			dropTable();
		}
		if(pokerGame.pokerGameRound.result == "Bot folded"){
			alert("Bot Folded");
			roundEnded();
		}
		if(pokerGame.comment == "Showdown"){
			showdown(pokerGame);
		}
		if(pokerGame.pokerGameRound.result != null){
			showResult(pokerGame);
		}
		
		$("img#player_avatar").attr("src", pokerGame.user1Profile.avatar);
		$("#player_name").empty().append(pokerGame.user1Profile.nickName);
		$("#player_chips").empty().append(pokerGame.user1Profile.money);
		$("#bot_chips").empty().append(pokerGame.pokerGameRound.player2.cash);
		var p1c1 = pokerGame.pokerGameRound.player1Hand.card1.value.name + "" + pokerGame.pokerGameRound.player1Hand.card1.suit.name;
		var p1c2 = pokerGame.pokerGameRound.player1Hand.card2.value.name + "" + pokerGame.pokerGameRound.player1Hand.card2.suit.name;
		$("#player_card1").attr("src",image_prefix + p1c1 + image_suffix);
		$("#player_card2").attr("src",image_prefix + p1c2 + image_suffix);
		if(pokerGame.pokerGameRound.dealer == true){
			//player move
			$("#botMove").attr("src", "img/layout/small_blind.png");
			$("#playerMove").attr("src", "img/layout/big_blind.png");
		}else{
			//bot move
			$("#botMove").attr("src", "img/layout/big_blind.png");
			$("#playerMove").attr("src", "img/layout/small_blind.png");
		}
	}
	
	function evenBets(pokerGame){
		if(pokerGame.pokerGameRound.table.turn == null){
			var card1 = pokerGame.pokerGameRound.table.flop1.value.name + pokerGame.pokerGameRound.table.flop1.suit.name;
			var card2 = pokerGame.pokerGameRound.table.flop2.value.name + pokerGame.pokerGameRound.table.flop2.suit.name;
			var card3 = pokerGame.pokerGameRound.table.flop3.value.name + pokerGame.pokerGameRound.table.flop3.suit.name;
			dealFlop(card1, card2, card3);
			$("#pot_size").empty().append(pokerGame.pokerGameRound.pot);
			$("#bot_chips").val("");
			$("#player_chips").val("");
			
		}
		else if(pokerGame.pokerGameRound.table.river == null){
			var card1 = pokerGame.pokerGameRound.table.turn.value.name + pokerGame.pokerGameRound.table.turn.suit.name;
			dealTurn(card1);
			$("#pot_size").empty().append(pokerGame.pokerGameRound.pot);
			$("#player_name").empty();
			$("#player_chips").empty();
		}
		else if(pokerGame.pokerGameRound.table.river != null){
			var card1 = pokerGame.pokerGameRound.table.river.value.name + pokerGame.pokerGameRound.table.river.suit.name;
			dealRiver(card1);
			$("#pot_size").empty().append(pokerGame.pokerGameRound.pot);
			$("#player_name").empty();
			$("#player_chips").empty();
		}
		
	}
	function showResult(pokerGame){
		if(pokerGame.pokerGameRound.result != "Split pot"){
			var my_str = pokerGame.pokerGameRound.result;
			var str=pokerGame.pokerGameRound.player1.name;
			if(my_str.search(str)==-1){
				highlightCards(pokerGame.pokerGameRound.player2Combination);
			}else{
				highlightCards(pokerGame.pokerGameRound.player1Combination);
			}
		}
		else{
			alert("Split pot");
		}
		roundEnded();
	}
	
	function highlightCards(combo){
		var card1 = combo.card1.value.name + combo.card1.suit.name;
		var card2 = combo.card2.value.name + combo.card2.suit.name;
		var card3 = combo.card3.value.name + combo.card3.suit.name;
		var card4 = combo.card4.value.name + combo.card4.suit.name;
		var card5 = combo.card5.value.name + combo.card5.suit.name;
		
		$("[src='"+image_prefix + card1 + image_suffix+"']").attr("class", "highlight");
		$("[src='"+image_prefix + card2 + image_suffix+"']").attr("class", "highlight");
		$("[src='"+image_prefix + card3 + image_suffix+"']").attr("class", "highlight");
		$("[src='"+image_prefix + card4 + image_suffix+"']").attr("class", "highlight");
		$("[src='"+image_prefix + card5 + image_suffix+"']").attr("class", "highlight");
	}

	function roundEnded(){
		$("body").click(function(){
			$("img.highlight").each().attr("class", "none");
			alert("TABLE WILL BE DROPPED");
			dropTable();
			alert("MESSAGE WILL BE SENT");
			betSend(0, 0);
		});
		
		
		
	}
	
	function dropTable(){
		$("img#flop1").replaceWith('<img id="flop1" class="none" style="position:relative; top:-20px; left:93px; width: 35px" src=""></img>');
		$("img#flop2").replaceWith('<img id="flop2" class="none" style="position:relative; top:-20px; left:93px; width: 35px" src=""></img>');
		$("img#flop3").replaceWith('<img id="flop3" class="none" style="position:relative; top:-20px; left:93px; width: 35px" src=""></img>');
		$("img#turn").replaceWith('<img id="turn" class="none" style="position:relative; top:-20px; left:93px; width: 35px" src=""></img>');
		$("img#river").replaceWith('<img id="river" class="none" style="position:relative; top:-20px; left:93px; width: 35px" src=""></img>');
		$("#playerBet").replaceWith('<div id="playerBet" style="position:relative; top:-85px; left:65px">0</div>');
		$("#botBet").replaceWith('<div id="botBet" style="position:relative; left:60px; top: 2px">0</div>');
		$("#bot_card1").replaceWith('<img id="bot_card1" class="none" style="position:relative; top:40px; left:15px; width: 35px"  border="2" SRC="img/cards/back_image.png">');
		$("#bot_card2").replaceWith('<img id="bot_card2" class="none" style="position:relative; top:40px; left:15px; width: 35px"  border="2" SRC="img/cards/back_image.png">');
		
		if($("#botMove").attr("src") ==  "img/layout/big_blind.png"){
			$("#botMove").attr("src", "img/layout/small_blind.png");
			$("#playerMove").attr("src", "img/layout/big_blind.png");
		}
		/*else if($("#botMove").attr("src") ==  "img/layout/small_blind.png"){
			$("#botMove").attr("src", "img/layout/big_blind.png");
			$("#playerMove").attr("src", "img/layout/small_blind.png");
		}*/
			
	}
	
	function showdown(pokerGame){
		var p2c1 = pokerGame.pokerGameRound.player2Hand.card1.value.name + "" + pokerGame.pokerGameRound.player2Hand.card1.suit.name;
		var p2c2 = pokerGame.pokerGameRound.player2Hand.card2.value.name + "" + pokerGame.pokerGameRound.player2Hand.card2.suit.name;
		$("#bot_card1").attr("src",image_prefix + p2c1 + image_suffix);
		$("#bot_card2").attr("src",image_prefix + p2c2 + image_suffix);
	}
	
	$(function()
	{
		$("#fold_button").click(function(){
			var userBet = -1;
			var botBet = $("#botBetInput").val();
			
			if (userBet != undefined & botBet != undefined)
			{
				betSend(userBet, botBet);
			}
		});
		$("#raise_button").click(function()
		{
			var userBet = $("#userBetInput").val();
			var botBet = $("#botBetInput").val();

			if (userBet != undefined & botBet != undefined)
			{
				betSend(userBet, botBet);
			}
		});

	});

});

