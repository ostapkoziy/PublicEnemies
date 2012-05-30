$(document)
		.ready(
				function() {
					$("img#deal_button").click(function() {
						var bet = $("#playerBet").html();
						var chips = $("#playerChips").html();
						var attr = $("#deal_button").attr("src");
						if (attr != "img/layout/dealg.png")
							sendAjax(bet, chips);
					});

					function sendAjax(bet, chips) {
						$.ajax
						{
							$.ajax({
								url : "dealBlackJackController.html",
								data : ({
									playerBet : bet,
									playerChips : chips
								}),
								success : function(data) {
									var game = jQuery.parseJSON(data);
									allDataUpdate(game);
								},
								error : function(e, ajaxOptions, thrownError) {
									alert("Choose bet");
								}

							});
						}

					}

					function allDataUpdate(game) {
						if (game.enoughChips == true) {
							alert(game.enoughChips);
							var i = 0;
							$("#player_cards").empty();
							for (i = 0; i < game.round.playerCards.length; i = i + 1) {
								$("#player_cards")
										.append(
												"<img src="
														+ game.round.playerCards[i].image
														+ "></img>");
							}
							$("#player_cardsSplit").empty();
							$("#dealer_cards").empty();
							for (i = 0; i < game.round.dealerCards.length; i = i + 1) {
								$("#dealer_cards")
										.append(
												"<img src="
														+ game.round.dealerCards[i].image
														+ "></img>");
							}
							$("#player_points").empty().append(
									game.round.playerPoints);
							$("#result").empty()
									.append(game.round.playerResult);

							// Chips
							$("#playerChips").empty().append(game.chips);

							// Buttons
							if (game.round.playerResult == null) {
								if (game.round.playerCards[0].rank == game.round.playerCards[1].rank)
									$("#split_button").attr("src",
											"img/layout/split.png");
								$("#deal_button").attr("src",
										"img/layout/dealg.png");
								$("#stand_button").attr("src",
										"img/layout/stand.png");
								$("#hit_button").attr("src",
										"img/layout/hit.png");
								$("#double_button").attr("src",
										"img/layout/double.png");
							} else {
								$("#deal_button").attr("src",
										"img/layout/rebeat.png");
							}
						} else{
							alert("Not enough chips! Start new game!");
							window.location.replace("/PublicEnemies/casino.html");
						}
					}

				});