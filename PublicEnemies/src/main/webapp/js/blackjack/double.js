$(document)
		.ready(
				function() {
					$("img#double_button").click(function() {
						var nothing1 = null;
						var nothing2 = null;
						var attr = $("#double_button").attr("class");
						if (attr == "active")
							sendAjax(nothing1, nothing2);
					});

					$("#double_button").mousedown(function() {
						var attr = $("#double_button").attr("class");
						if (attr == "active")
							$(this).attr("src", "img/layout/doubleg.png");
					});

					$("#double_button").mouseup(function() {
						var attr = $("#double_button").attr("class");
						if (attr == "active")
							$(this).attr("src", "img/layout/double.png");
					});

					function sendAjax(nothing1, nothing2) {
						$.ajax
						{
							$.ajax({
								url : "doubleBlackJackController.html",
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

					function allDataUpdate(game) {
						var i = 0;
						$("#player_cards").empty();
						for (i = 0; i < game.round.playerCards.length; i = i + 1) {
							$("#player_cards").append(
									"<img src="
											+ game.round.playerCards[i].image
											+ "></img>");
						}
						if (game.round.playerCardsSplit != null) {
							i = 0;
							$("#player_cardsSplit").empty();
							for (i = 0; i < game.round.playerCardsSplit.length; i = i + 1) {
								$("#player_cardsSplit")
										.append(
												"<img src="
														+ game.round.playerCardsSplit[i].image
														+ "></img>");
							}
						}
						$("#player_points").empty().append(
								game.round.playerPoints);

						if (game.round.playerCardsSplit == null) {
							var i = 0;
							$("#dealer_cards").empty();
							for (i = 0; i < game.round.dealerCards.length; i = i + 1) {
								$("#dealer_cards").append(
										"<img src=" + game.round.dealerCards[i].image
												+ "></img>");
							}
							// Chips
							$("#playerChips").empty().append(game.chips);

							$("#result").empty().append(game.round.playerResult);
							$("#resultSplit").empty().append(
									game.round.playerResultSplit);
							$("#deal_button").attr("src", "img/layout/rebeat.png");
							$("#deal_button").attr("class", "active");

							$("#stand_button").attr("src", "img/layout/standg.png");
							$("#stand_button").attr("class", "notactive");

							$("#hit_button").attr("src", "img/layout/hitg.png");
							$("#hit_button").attr("class", "notactive");

							$("#double_button").attr("src", "img/layout/doubleg.png");
							$("#double_button").attr("class", "notactive");

							$("#10_button").attr("class", "active");
							$("#25_button").attr("class", "active");
							$("#50_button").attr("class", "active");
							$("#100_button").attr("class", "active");
						}
					}

				});