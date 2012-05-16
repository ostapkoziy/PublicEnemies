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
				$("#hpU1").html(game.user1profile.strength);
				$("#hpU2").html(game.user2profile.strength);
			}
			if (game.gameEnd == true)
			{
				clearInterval(interval);
				$("#hpU1").html(game.user1profile.strength);
				$("#hpU2").html(game.user2profile.strength);
				$("#atackButton").hide();
				setTimeout(function()
				{
					// Redirect to gameResault page after 3 sec
					window.location.replace("resault.html");
				}, 3000);
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
/**
 * Setup timer for new round waiting
 */
function wait()
{
	interval = setInterval(waitingNewRound, 3000);
}
/**
 * If coockie.hit==true hide attack button
 */
function hideAttackButton()
{
	$("#atackButton").hide();
}
/**
 * If coockie.hit==false show attack button
 */
function showAttackButton()
{
	$("#atackButton").show();
}
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
