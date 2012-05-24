$(document).ready(
		function() {
			$("img#deal_button").click(function() {
				var bet = $("#playerBet").val();
				var nothing = null;
				var chips = $("#playerChips").val();
				var attr = $("#deal_button").attr("src");
				if (attr != "img/layout/dealg.png")
					sendAjax(bet, nothing);
			});

			function sendAjax(bet, nothing) {
				$.ajax
				{
					$.ajax({
						url : "DealBlackJackController.html",
						data : ({
							playerBet : bet,
							playerNothing : nothing
						}),
						success : function(data) {
							var round = jQuery.parseJSON(data);
							allDataUpdate(round);
						},
						error : function(e, ajaxOptions, thrownError) {
							alert("Choose bet");
						}

					});
				}

			}

			function allDataUpdate(round) {
				var i = 0;
				$("#player_cards").empty();
				for (i = 0; i < round.playerCards.length; i = i + 1) {
					$("#player_cards").append(
							"<img src=" + round.playerCards[i].image
									+ "></img>");
				}
				$("#dealer_cards").empty();
				for (i = 0; i < round.dealerCards.length; i = i + 1) {
					$("#dealer_cards").append(
							"<img src=" + round.dealerCards[i].image
									+ "></img>");
				}
				$("#player_points").empty().append(round.playerPoints);
				$("#result").empty().append(round.playerResult);

				// Chips
				$("#playerChips").empty().val();
				$("#playerBet").empty().append("10");

				// Buttons
				if (round.playerResult == null) {
					if (round.playerCards[0].rank == round.playerCards[1].rank)
						$("#split_button").attr("src", "img/layout/split.png");
					$("#deal_button").attr("src", "img/layout/dealg.png");
					$("#stand_button").attr("src", "img/layout/stand.png");
					$("#hit_button").attr("src", "img/layout/hit.png");
					$("#double_button").attr("src", "img/layout/double.png");
				} else
					$("#deal_button").attr("src", "img/layout/rebeat.png")
			}

		});