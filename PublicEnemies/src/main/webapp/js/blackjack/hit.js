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
						url : "HitBlackJackController.html",
						data : ({
							playerNothing1 : nothing1,
							playerNothing2 : nothing2
						}),
						success : function(data) {
							var round = jQuery.parseJSON(data);
							allDataUpdate(round);
						},
						error : function(e, ajaxOptions, thrownError) {
							alert(e.status);
							alert(thrownError);
							alert("Error in dealSend()");
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
				$("#player_points").empty().append(round.playerPoints);
				$("#result").empty().append(round.playerResult);
				// Buttons
				$("#split_button").attr("src", "img/layout/splitg.png");
				if (round.playerResult != null) {
					$("#stand_button").attr("src", "img/layout/standg.png");
					$("#hit_button").attr("src", "img/layout/hitg.png");
					$("#double_button").attr("src", "img/layout/doubleg.png");
					$("#deal_button").attr("src", "img/layout/rebeat.png");
				}
			}

		});