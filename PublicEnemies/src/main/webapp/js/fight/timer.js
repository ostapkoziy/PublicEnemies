var nowTime = Math.ceil(new Date().getTime() / 1000);
var limit = 30;
function timer(timerBeginTime)
{
	$("#timer").css("color", "black");
	showAttackButton();
	if ((nowTime - timerBeginTime) < limit)
	{
		nowTime = Math.ceil(new Date().getTime() / 1000);
		sub = limit - (nowTime - timerBeginTime);
		if (sub < 10)
		{
			sub = "0" + sub;
			$("#timer").css("color", "red");
		}

		$("#timer").html("00:" + sub);
	}
	else
	{
		$("#timer").fadeTo(0, 0);
	}

}
