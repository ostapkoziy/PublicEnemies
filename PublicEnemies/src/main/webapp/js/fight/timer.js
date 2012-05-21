var timerIntervalID = 0;
var nowTime = Math.ceil(new Date().getTime() / 1000);
var limit = 60;
function timer(timerBeginTime)
{
	$("#timer").fadeTo(0, 1);
	$("#timer").css("color", "black");
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
		// stopTimer();
		$("#timer").fadeTo(0, 0);
//		$("#atackButton").hide();
	}

}
function timerStart(timerBeginTime)
{
	timerIntervalID = setInterval(function()
	{
		timer(timerBeginTime);
	}, 1000);
}
function stopTimer()
{
	clearInterval(timerIntervalID);
}
