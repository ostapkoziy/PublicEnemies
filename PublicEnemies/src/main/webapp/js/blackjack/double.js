$(document).ready(
		function() {
			$("img#double_button").click(function() {
				var nothing1 = null;
				var nothing2 = null;
				var attr = $("#double_button").attr("src");
				if (attr != "img/layout/doubleg.png")
					sendAjax(nothing1, nothing2);
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
							"<img src=" + game.round.playerCards[i].image
									+ "></img>");
				}
				if (game.round.playerCardsSplit != null) {
					i = 0;
					$("#player_cardsSplit").empty();
					for (i = 0; i < game.round.playerCardsSplit.length; i = i + 1) {
						$("#player_cardsSplit").append(
								"<img src=" + game.round.playerCardsSplit[i].image
										+ "></img>");
					}
				}
				$("#player_points").empty().append(game.round.playerPoints);
				$("#dealer_cards").empty();
				for (i = 0; i < game.round.dealerCards.length; i = i + 1) {
					$("#dealer_cards").append(
							"<img src=" + game.round.dealerCards[i].image
									+ "></img>");
				}
				// Chips
				$("#playerChips").empty().append(game.chips);
				$("#playerBet").empty().append(game.round.playerBet);

				if (game.round.playerCardsSplit == null) {
					$("#result").empty().append(game.round.playerResult);
					$("#deal_button").attr("src", "img/layout/rebeat.png");
					$("#stand_button").attr("src", "img/layout/standg.png");
					$("#hit_button").attr("src", "img/layout/hitg.png");
					$("#double_button").attr("src", "img/layout/doubleg.png");
				}
			}

		});