/**
 * Sends USER HIT and BLOCK
 */
function hitSend(hit, block, aid)
{
	$.ajax({
		url : "HitController.html",
		async : false,
		data : ({
			userHit : hit,
			userBlock : block,
			aidUse : aid }),
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
		async : false,
		success : function(data)
		{
			var game = jQuery.parseJSON(data);
			if (game.gameEnd != true)
			{
				attackButtonController(game);
				allDataUpdate(game);
				setTimeout(waitingNewRound, 1000);
			}
			if (game.gameEnd == true)
			{
				window.location.replace("fightResult.html");
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
	$("#U1HP").html(game.creatorProfile.HP);
	$("#U2HP").html(game.connectorProfile.HP);
	$("#innerLeftProgressHP").css("width", game.creatorProfile.HP / game.creatorProfile.allHP * 100 + "%");
	$("#innerRightProgressHP").css("width", game.connectorProfile.HP / game.connectorProfile.allHP * 100 + "%");
	$("#leftHPPercent").html(game.creatorProfile.HP + "/" + game.creatorProfile.allHP);
	$("#rightHPPercent").html(game.connectorProfile.HP + "/" + game.connectorProfile.allHP);
	HPColor();
}
/**
 * Calls timer function if user doesn't hit. If user hits - hides timer and
 * atackButton.
 * 
 */
function attackButtonController(game)
{

	if (game.whoIAm == "creator")
	{
		if (game.round.creatorAction.usedAid == true)
		{
			$("#leftAid").hide();
		}
		if (game.round.creatorAction.didHit == false)
		{
			showAttackButton();
		}
		else
		{
			hideAttackButton();
		}

	}
	else
	{
		if (game.round.connectorAction.usedAid == true)
		{
			$("#leftAid").hide();
		}
		if (game.round.connectorAction.didHit == false)
		{
			showAttackButton();
		}
		else
		{
			hideAttackButton();
		}
	}
}
/**
 * Hide attack button
 */
function hideAttackButton()
{
	$("#atackButton").attr("hidden", "");
}
/**
 * Show attack button
 */
function showAttackButton()
{
	$("#atackButton").removeAttr("hidden");
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
	// ------------------AID----------------------
	$("#leftAid").toggle(function()
	{
		$("#aidInput").val("true");
		$(this).css("opacity", "0.4");
	}, function()
	{
		$("#aidInput").val("false");
		$(this).css("opacity", "1");
	});

});
