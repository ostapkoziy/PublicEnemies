$(document)
		.ready(
				function() {
					var image_prefix = "img/cards/";
					var image_suffix = ".png";
					sendAjax(0, 0);
					$("#newRound").click(function() {
							var bet = $("#userBetInput").val();
							var botBet = $("#botBetInput").val();
							sendAjax(bet, botBet);
					});

					function sendAjax(bet, botBet) {
						$.ajax
						{
							$.ajax({
								url : "dealPokerController.html",
								data : ({
									playerBet : bet,
									botBet : botBet
								}),
								success : function(data) {
									var game = jQuery.parseJSON(data);
									allDataUpdate(game);
								},
								error : function(e, ajaxOptions, thrownError) {
									alert("Sending failed");
								}

							});
						}

					}

					function allDataUpdate(pokerGame) {
						$("div#botBet").empty().append(pokerGame.pokerGameRound.player2Bet);
						$("div#playerBet").empty().append(pokerGame.pokerGameRound.player1Bet);
						$("img#flop1").replaceWith('<img id="flop1" class="none" style="position:relative; top:15px; left:90px; width: 35px" src=""></img>');
						$("img#flop2").replaceWith('<img id="flop2" class="none" style="position:relative; top:15px; left:95px; width: 35px" src=""></img>');
						$("img#flop3").replaceWith('<img id="flop3" class="none" style="position:relative; top:15px; left:100px; width: 35px" src=""></img>');
						$("img#turn").replaceWith('<img id="turn" class="none" style="position:relative; top:15px; left:105px; width: 35px" src=""></img>');
						$("img#river").replaceWith('<img id="river" class="none" style="position:relative; top:15px; left:110px; width: 35px" src=""></img>');
						$("#bot_card1").replaceWith('<img id="bot_card1" class="none" style="position:relative; top:40px; left:15px; width: 35px"  border="2" SRC="img/cards/back_image.png">');
						$("#bot_card2").replaceWith('<img id="bot_card2" class="none" style="position:relative; top:40px; left:15px; width: 35px"  border="2" SRC="img/cards/back_image.png">');
						$("#pot_size").empty().append("0");
						if($("#botMove").attr("src") ==  "img/layout/big_blind.png"){
							$("#botMove").attr("src", "img/layout/small_blind.png");
							$("#playerMove").attr("src", "img/layout/big_blind.png");
						}
						$("#player_card1").attr("class", "none");
						$("#player_card2").attr("class", "none");
						$("img#player_avatar").attr("src", pokerGame.user1Profile.avatar);
						$("#player_name").empty().append(pokerGame.pokerGameRound.player1.name);
						$("#player_chips").empty().append(pokerGame.pokerGameRound.player1.cash);
						$("#bot_chips").empty().append(pokerGame.pokerGameRound.player2.cash);
						var p1c1 = pokerGame.pokerGameRound.player1Hand.card1.value.name + "" + pokerGame.pokerGameRound.player1Hand.card1.suit.name;
						var p1c2 = pokerGame.pokerGameRound.player1Hand.card2.value.name + "" + pokerGame.pokerGameRound.player1Hand.card2.suit.name;
						$("#player_card1").attr("src", image_prefix + p1c1 + image_suffix);
						$("#player_card2").attr("src", image_prefix + p1c2 + image_suffix);
						if(pokerGame.pokerGameRound.dealer == true){
							//player move
							$("#botMove").attr("src", "img/layout/small_blind.png");
							$("#playerMove").attr("src", "img/layout/big_blind.png");
						}else{
							//bot move
							$("#botMove").attr("src", "img/layout/big_blind.png");
							$("#playerMove").attr("src", "img/layout/small_blind.png");
						}
						
						$("td#1").attr("class", "no");
						$("td#2").attr("class", "no");
						$("td#3").attr("class", "no");
						$("td#4").attr("class", "no");
						$("td#5").attr("class", "no");
						$("td#6").attr("class", "no");
						$("td#7").attr("class", "no");
						$("td#8").attr("class", "no");
					}

				});