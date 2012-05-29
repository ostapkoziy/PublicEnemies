$(document)
		.ready(
				function() {
					$("#blackjack").click(function(){
						var nothing1 = null;
						var nothing2 = null;
						var attr = $("#hit_button").attr("src");
						if (attr != "img/layout/hitg.png")
							sendAjax(nothing1, nothing2);
					});

					function sendAjax(nothing1, nothing2) {
						$.ajax
						{
							$.ajax({
								url : "checkForBlackJackGame.html",
								data : ({
									playerNothing1 : nothing1,
									playerNothing2 : nothing2
								}),
								success : function(data) {
									var game = jQuery.parseJSON(data);
									if(game != null){
									window.location.replace("blaBlaBlackJackController.html");
									allDataUpdate(game);}
								},
								error : function(e, ajaxOptions, thrownError) {
									alert(e.status);
									alert(thrownError);
									alert("Error in dealSend()");
								}

							});
						}

					}

					function allDataUpdate(game) {
						var i = 0;
						for (i = 0; i < game.round.playerCards.length; i = i + 1) {
							$("#player_cards").append(
									"<img src="
											+ game.round.playerCards[i].image
											+ "></img>");
						}
						$("#player_cardsSplit").empty();
						for (i = 0; i < game.round.playerCardsSplit.length; i = i + 1) {
							$("#player_cardsSplit").append(
									"<img src="
											+ game.round.playerCardsSplit[i].image
											+ "></img>");
						}
						$("#dealer_cards").empty();
						for (i = 0; i < game.round.dealerCards.length; i = i + 1) {
							$("#dealer_cards").append(
									"<img src="
											+ game.round.dealerCards[i].image
											+ "></img>");
						}
						$("#player_points").empty().append(
								game.round.playerPoints);
						$("#result").empty().append(game.round.playerResult);

						// Chips
						$("#playerChips").empty().append(game.chips);
						$("#playerBet").empty().append(game.round.playerBet);

						// Buttons
						if (game.round.playerResult == null) {
							if (game.round.playerCards[0].rank == game.round.playerCards[1].rank)
								$("#split_button").attr("src",
										"img/layout/split.png");
							$("#deal_button").attr("src",
									"img/layout/dealg.png");
							$("#stand_button").attr("src",
									"img/layout/stand.png");
							$("#hit_button").attr("src", "img/layout/hit.png");
							$("#double_button").attr("src",
									"img/layout/double.png");
						} else {
							$("#deal_button").attr("src",
									"img/layout/rebeat.png");
						}
					}



				});