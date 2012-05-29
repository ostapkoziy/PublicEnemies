/**
 * Sends USER HIT and BLOCK
 */
function hitSend(hit, block, aid)
{
	$.ajax({
		url : "HitController.html",
		data : ({
			userHit : hit,
			userBlock : block,
			aidUse : aid }),
		success : function(data)
		{
		},
		error : function(e, ajaxOptions, thrownError)
		{
			// TODO if error redirect to userStartPage.html
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
				timerController(game);
				allDataUpdate(game);
				setTimeout(waitingNewRound, 1000);
			}
			if (game.gameEnd == true)
			{
				allDataUpdate(game);
				hideAttackButton();
				// ****** Redirect to gameResault page after 1 sec*************
				// setTimeout(function()
				// {
				window.location.replace("fightResult.html");
				// }, 1000);
				// ********************************************************
			}
		},
		error : function(e, ajaxOptions, thrownError)
		{
			// TODO if error redirect to userStartPage.html
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
	$("#U1HP").html(game.creatorProfile.HP);
	$("#U2HP").html(game.connectorProfile.HP);
	$("#innerLeftProgressHP").css("width", game.creatorProfile.HP / game.creatorProfile.allHP * 100 + "%");
	$("#innerRightProgressHP").css("width", game.connectorProfile.HP / game.connectorProfile.allHP * 100 + "%");
	HPColor();
}
/**
 * Calls timer function if user doesn't hit. If user hits - hides timer and
 * atackButton.
 * 
 */
function timerController(game)
{

	if (game.whoIAm == "creator")
	{
		if (game.round.creatorDoHit == true)
		{
			hideAttackButton();
		}
		else
		{
			$("#timer").fadeTo(0, 1);
			timer(game.round.roundBeginTime);
		}
	}
	else
	{
		if (game.round.connectorDoHit == true)
		{
			hideAttackButton();
		}
		else
		{
			$("#timer").fadeTo(0, 1);
			timer(game.round.roundBeginTime);
		}
	}
}
/**
 * Hide attack button
 */
function hideAttackButton()
{
	$("#atackButton").hide();
	$("#timer").fadeTo(0, 0);
}
/**
 * Show attack button
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
		var hit = $("#hitInput").val();
		var block = $("#blockInput").val();
		var aid = $("#aidInput").val();
		if (hit != undefined & block != undefined)
		{
			hitSend(hit, block, aid);
			hideAttackButton();

		}
	});
	// **************Redirect to profile on click*****************
	$("#color1").click(function()
	{
		window.location.replace("profile.html");
	});
	$("#leftAid").toggle(function()
	{
		$("#aidInput").val("true");
		$(this).css("outline", "3px solid red");
	}, function()
	{
		$("#aidInput").val("false");
		$(this).css("outline", "");
	});

});
