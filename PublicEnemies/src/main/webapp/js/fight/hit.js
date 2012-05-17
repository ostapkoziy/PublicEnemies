var interval;
/**
 * Send USER HIT and BLOCK if <br/><b>Success:</b> coockie.hit=true and hide
 * attack button;
 * 
 */
function hitSend(hit, block)
{

	$.ajax({
		url : "HitServlet.html",
		data : ({
			userHit : hit,
			userBlock : block }),
		success : function(data)
		{

		},
		error : function(e, ajaxOptions, thrownError)
		{
			alert(e.status);
			alert(thrownError);
			alert("Error in hitSend()");
		}

	});
}
/**
 * Wait for new round
 */
function waitingNewRound()
{
	$.ajax({
		url : "WaitingNewRound.html",
		success : function(data)
		{

			var game = jQuery.parseJSON(data);
			if (game.gameEnd != true)
			{
				allDataUpdate(game);
				// alert(game.whoIAm);
			}
			if (game.gameEnd == true)
			{

				clearInterval(interval);
				allDataUpdate(game);
				// ****** Redirect to gameResault page after 3 sec*************
				setTimeout(function()
				{

					window.location.replace("resault.html");
				}, 3000);
				// ********************************************************
			}
		},
		error : function(e, ajaxOptions, thrownError)
		{
			alert(e.status);
			alert(thrownError);
			alert("Error in waitingNewRound()");
		}

	});
}
/*******************************************************************************
 * UPDATE ALL DATA ON PAGE
 ******************************************************************************/
function allDataUpdate(game)
{
	$("#U1HP").html(game.user1profile.HP);
	$("#U2HP").html(game.user2profile.HP);
	$("#innerLeftProgressHP").css("width", game.user1profile.HP / game.user1profile.allHP * 100 + "%");
	$("#innerRightProgressHP").css("width", game.user2profile.HP / game.user2profile.allHP * 100 + "%");
	HPColor();
}
/**
 * Setup timer for new round waiting
 */
function wait()
{
	interval = setInterval(waitingNewRound, 1000);
}
/**
 * Hide attack button
 */
function hideAttackButton()
{
	$("#atackButton").hide();
}
/**
 * Show attack button
 */
function showAttackButton()
{
	$("#atackButton").show();
}
/**
 * Update data when window load.
 */
$(window).load(function()
{
	waitingNewRound();
});
// DOM READY
$(function()
{
	$("#atackButton").click(function()
	{
		// var hit = $("#hit input[name=hit]:checked").val();
		// var block = $("#block input[name=block]:checked").val();

		var hit = $("#hitInput").val();
		var block = $("#blockInput").val();

		if (hit != undefined & block != undefined)
		{
			hitSend(hit, block);
		}
	});

});
