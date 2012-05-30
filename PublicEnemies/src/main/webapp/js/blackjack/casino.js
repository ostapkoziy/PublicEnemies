$(document)
		.ready(
				function() {
					$("#blackjack").click(function() {
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
											if (game != null) {
												window.location.replace("/PublicEnemies/emptyBlackJack.html");
											}
										},
										error : function(e, ajaxOptions,
												thrownError) {
											alert(e.status);
											alert(thrownError);
											alert("Error in dealSend()");
										}

									});
						}

					}
				});