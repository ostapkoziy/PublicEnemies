$(function()
{
	$("#newJoin").css("opacity", 0);
	var ap = 1;
	var audio = document.getElementById("audio");
	var interv;
	var interv2;
	setTimeout(function()
	{
		audio.play();

		$("#bulletHole1").removeAttr("hidden");
		setTimeout(function()
		{
			$("#blood").removeAttr("hidden");
		}, 150);

		interv = setInterval(function()
		{
			$("#shadow").css("opacity", ap);
			ap = ap - 0.02;
			if (ap < 0)
			{
				clearInterval(interv);
				interv2 = setInterval(function()
				{

					$("#newJoin").css("opacity", ap);
					ap = ap + 0.01;
					if (ap > 1)
					{
						clearInterval(interv2);
					}
				}, 50);
			}
		}, 50);
	}, 1000);
});