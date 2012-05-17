var timerIntervalID = 0;
var nowTime = Math.ceil(new Date().getTime() / 1000);
var limit = 60;

function timer(timerBeginTime)
{
	if ((nowTime - timerBeginTime) < limit)
	{
		nowTime = Math.ceil(new Date().getTime() / 1000);
		sub = limit - (nowTime - timerBeginTime);
		if (sub < 10)
		{
			sub = "0" + sub;
		}
		if (sub < 10)
		{
			$("#timer").css("color", "red");
		}
		$("#timer").html("00:" + sub);
	}
	else
	{
		stopTimer();
		$("#timer").fadeTo(0, 0);
	}

}
function timerStart(timerBeginTime)
{
	timerIntervalID = setInterval(function(timerBeginTime)
	{
		timer(timerBeginTime);
	}, 1000);
}
function stopTimer()
{
	clearInterval(timerIntervalID);
}
