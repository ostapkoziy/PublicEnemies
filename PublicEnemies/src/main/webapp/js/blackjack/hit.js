$(document).ready(
		function() {
			$("img#hit_button").click(function() {
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
						url : "hitBlackJackController.html",
						data : ({
							playerNothing1 : nothing1,
							playerNothing2 : nothing2
						}),
						success : function(data) {
							var game = jQuery.parseJSON(data);
							allDataUpdate(game);
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
				$("#result").empty().append(game.round.playerResult);

				// Chips
				$("#playerChips").empty().append(game.chips);

				// Buttons
				$("#split_button").attr("src", "img/layout/splitg.png");
				if (game.round.playerResult != null && game.round.playerCardsSplit == null) {
					$("#stand_button").attr("src", "img/layout/standg.png");
					$("#hit_button").attr("src", "img/layout/hitg.png");
					$("#double_button").attr("src", "img/layout/doubleg.png");
					$("#deal_button").attr("src", "img/layout/rebeat.png");
				}
			}

		});