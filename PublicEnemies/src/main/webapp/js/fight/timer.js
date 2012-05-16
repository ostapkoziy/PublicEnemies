var timerIntervalID = 0;
var timerBeginTime = $.cookie("roundBegin");
var nowTime = Math.ceil(new Date().getTime() / 1000);
var limit = 5;
function time()
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
		hitSend("", "");
		$.cookie("hit", "true");
		$("#timer").fadeTo(0, 0);
	}

}
function timerStart()
{
	timerIntervalID = setInterval(time, 1000);
}
function stopTimer()
{
	$.cookie("timer", "off");
	clearInterval(timerIntervalID);
}

$(function()
{
	if ($.cookie("timer") == "on")
	{
//		timerStart();
	}
});
