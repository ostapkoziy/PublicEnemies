$(document)
		.ready(
				function() {
					var gameType = "";
					var game = "";
					$("#blackjack, #poker, #roulette").click(function() {
						gameType = $(this).attr("id");
						$("#inputDiv").slideDown(1000).delay(7000).slideUp(1000);
						game = gameType;
						gameType += "Input";
						
					});
					$("#submitButton").click(function() {
						var chips = $("#chipInput").val();
						var nothing = null;
						sendAjax(chips, nothing);
					});

					function sendAjax(chips, nothing) {
						$.ajax
						{
							$
									.ajax({
										url : "validateCasino.html",
										data : ({
											playerChips : chips,
											playerNothing : nothing
										}),
										success : function(data) {
											var error = jQuery.parseJSON(data);
											if (error == null) {
												$("#" + gameType).val(chips);
												game += "Submit";
												$("#" + game).click();
											} else{
												$("#chips_error").empty().append(error);
											}
										},
										error : function(e, ajaxOptions,
												thrownError) {
										}

									});
						}

					}
				});