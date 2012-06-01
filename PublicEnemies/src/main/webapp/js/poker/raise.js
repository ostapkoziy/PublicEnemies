$(document)
		.ready(
				function() {
					var game;
					var image_prefix = "img/cards/";
					var image_suffix = ".png";
					$("#botBetInput").hide();
					$("#newRound").hide();

					$("#call_button").click(function() {
						var toCall = $("#botBet").html();
						var userBet = $("#playerBet").html();
						toCall = toCall - userBet;
						$("#userBetInput").val(toCall);
						sendAjax(toCall, 0);
						
					});

					$("#raise_button").click(function() {
						var bet = $("#userBetInput").val();
						var botBet = $("#botBetInput").val();
						sendAjax(bet, botBet);
						
					});
					$("#fold_button").click(function() {
						if (confirm('Do you really want to fold?')) {
							sendAjax(-1, 0);
						}
					});

					$("#call_button").mousedown(function() {
						$(this).attr("src", "img/layout/callg.png");
					});

					$("#call_button").mouseup(function() {
						$(this).attr("src", "img/layout/call.png");
					});

					$("#raise_button").mousedown(function() {
						$(this).attr("src", "img/layout/raiseg.png");
					});

					$("#raise_button").mouseup(function() {
						$(this).attr("src", "img/layout/raise.png");
					});

					$("#fold_button").mousedown(function() {
						$(this).attr("src", "img/layout/foldg.png");
					});

					$("#fold_button").mouseup(function() {
						$(this).attr("src", "img/layout/fold.png");
					});

					function sendAjax(bet, botBet) {
						$.ajax
						{
							$.ajax({
								url : "raisePokerController.html",
								data : ({
									playerBet : bet,
									botBet : botBet
								}),
								success : function(data) {
									var game = jQuery.parseJSON(data);
									allDataUpdate(game);
								},
								error : function(e, ajaxOptions, thrownError) {
									alert("Fail in raise");
								}

							});
						}

					}

					function allDataUpdate(pokerGame) {
						game = pokerGame;
						if (pokerGame.pokerGameRound.result == "Bot folded") {
							alert("Bot folded, you Win");
							setTimeout(function() {
								$("#newRound").click();
							}, 1000);
							return;
						}
						if (pokerGame.pokerGameRound.result == "Player folded") {
							setTimeout(function() {
								$("#newRound").click();
							}, 100);
							return;
						}
						if (pokerGame.pokerGameRound.result != "none") {
							showResult(pokerGame);
						}
						var userBet = pokerGame.pokerGameRound.player1Bet;
						var botBet = pokerGame.pokerGameRound.player2Bet;
						$("div#playerBet").empty().append(userBet);
						$("div#botBet").empty().append(botBet);
						$("#bot_chips").empty().append(
								pokerGame.pokerGameRound.player2.cash);
						$("#player_chips").empty().append(
								pokerGame.pokerGameRound.player1.cash);

						if (userBet == botBet) {
							showBoard(pokerGame);
						}
						updateCombo(pokerGame);
					}

					function showBoard(pokerGame) {
						if (pokerGame.pokerGameRound.table.turn == null) {
							var card1 = pokerGame.pokerGameRound.table.flop1.value.name
									+ pokerGame.pokerGameRound.table.flop1.suit.name;
							var card2 = pokerGame.pokerGameRound.table.flop2.value.name
									+ pokerGame.pokerGameRound.table.flop2.suit.name;
							var card3 = pokerGame.pokerGameRound.table.flop3.value.name
									+ pokerGame.pokerGameRound.table.flop3.suit.name;
							dealFlop(card1, card2, card3);
							$("#pot_size").empty().append(
									pokerGame.pokerGameRound.pot);

						} else if (pokerGame.pokerGameRound.table.river == null) {
							var card1 = pokerGame.pokerGameRound.table.turn.value.name
									+ pokerGame.pokerGameRound.table.turn.suit.name;
							dealTurn(card1);
							$("#pot_size").empty().append(
									pokerGame.pokerGameRound.pot);
						} else if (pokerGame.pokerGameRound.table.river != null) {
							var card1 = pokerGame.pokerGameRound.table.river.value.name
									+ pokerGame.pokerGameRound.table.river.suit.name;
							dealRiver(card1);
							$("#pot_size").empty().append(
									pokerGame.pokerGameRound.pot);
						}
					}

					function dealFlop(card1, card2, card3) {
						$("img#flop1").attr("src",
								image_prefix + card1 + image_suffix);
						$("img#flop2").attr("src",
								image_prefix + card2 + image_suffix);
						$("img#flop3").attr("src",
								image_prefix + card3 + image_suffix);
					}
					function dealTurn(card1) {
						$("img#turn").attr("src",
								image_prefix + card1 + image_suffix);

					}
					function dealRiver(card1) {
						$("img#river").attr("src",
								image_prefix + card1 + image_suffix);
					}

					function showResult(pokerGame) {
						showdown(pokerGame);
						if (pokerGame.pokerGameRound.result != "Split pot") {
							var my_str = pokerGame.pokerGameRound.result;
							var str = pokerGame.pokerGameRound.player1.name;
							if (my_str.search(str) == -1) {
								highlightCards(pokerGame.pokerGameRound.player2Combination);
							} else {
								highlightCards(pokerGame.pokerGameRound.player1Combination);
							}
						} else {
							alert("Split pot");
						}
						setTimeout(function() {
							$("#newRound").click();
						}, 1500);
					}

					function highlightCards(combo) {
						var card1 = combo.card1.value.name
								+ combo.card1.suit.name;
						var card2 = combo.card2.value.name
								+ combo.card2.suit.name;
						var card3 = combo.card3.value.name
								+ combo.card3.suit.name;
						var card4 = combo.card4.value.name
								+ combo.card4.suit.name;
						var card5 = combo.card5.value.name
								+ combo.card5.suit.name;

						$("[src='" + image_prefix + card1 + image_suffix + "']")
								.attr("class", "highlight");
						$("[src='" + image_prefix + card2 + image_suffix + "']")
								.attr("class", "highlight");
						$("[src='" + image_prefix + card3 + image_suffix + "']")
								.attr("class", "highlight");
						$("[src='" + image_prefix + card4 + image_suffix + "']")
								.attr("class", "highlight");
						$("[src='" + image_prefix + card5 + image_suffix + "']")
								.attr("class", "highlight");

					}

					function showdown(pokerGame) {
						var p2c1 = pokerGame.pokerGameRound.player2Hand.card1.value.name
								+ ""
								+ pokerGame.pokerGameRound.player2Hand.card1.suit.name;
						var p2c2 = pokerGame.pokerGameRound.player2Hand.card2.value.name
								+ ""
								+ pokerGame.pokerGameRound.player2Hand.card2.suit.name;
						$("#bot_card1").attr("src",
								image_prefix + p2c1 + image_suffix);
						$("#bot_card2").attr("src",
								image_prefix + p2c2 + image_suffix);
					}

					function updateCombo(pokerGame) {
						var combo = pokerGame.pokerGameRound.player1Combination;
						// alert("combo - " + combo.name + " and rank - " +
						// combo.rank);
						clearCombo();
						$("td#" + (combo.rank - 1)).attr("class", "container");
						$("td#" + (combo.rank - 1)).attr("title", "You have " + combo.name);
					}

					function clearCombo() {
						$("td#1").attr("class", "no").attr("title", "");
						$("td#2").attr("class", "no").attr("title", "");
						$("td#3").attr("class", "no").attr("title", "");
						$("td#4").attr("class", "no").attr("title", "");
						$("td#5").attr("class", "no").attr("title", "");
						$("td#6").attr("class", "no").attr("title", "");
						$("td#7").attr("class", "no").attr("title", "");
						$("td#8").attr("class", "no").attr("title", "");
					}
					
				});