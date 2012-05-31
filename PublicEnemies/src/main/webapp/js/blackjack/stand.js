$(document).ready(
		function() {
			$("img#stand_button").click(function() {
				var nothing1 = null;
				var nothing2 = null;
				var attr = $("#stand_button").attr("class");
				if (attr == "active")
					sendAjax(nothing1, nothing2);
			});

			$("#stand_button").mousedown(function() {
				var attr = $("#stand_button").attr("class");
				if (attr == "active")
					$(this).attr("src", "img/layout/standg.png");
			});

			$("#stand_button").mouseup(function() {
				var attr = $("#stand_button").attr("class");
				if (attr == "active")
					$(this).attr("src", "img/layout/stand.png");
			});

			function sendAjax(nothing1, nothing2) {
				$.ajax
				{
					$.ajax({
						url : "standBlackJackController.html",
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
				$("#dealer_cards").empty();
				for (i = 0; i < game.round.dealerCards.length; i = i + 1) {
					$("#dealer_cards").append(
							"<img src=" + game.round.dealerCards[i].image
									+ "></img>");
				}
				// Chips
				$("#playerChips").empty().append(game.chips);
				if (game.round.playerCardsSplit == null) {
					$("#result").empty().append(game.round.playerResult);
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