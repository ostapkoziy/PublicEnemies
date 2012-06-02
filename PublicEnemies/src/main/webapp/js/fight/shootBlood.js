$(function()
{
	var ap = 1;
	var audio = document.getElementById("audio");
	setTimeout(function()
	{
		audio.play();

		$("#bulletHole1").removeAttr("hidden");
		setTimeout(function()
		{
			// $("#blood").removeAttr("hidden");
		}, 300);

		setInterval(function()
		{
			// $("#bulletHole2").removeAttr("hidden");
			interv = setInterval(function()
			{
				// $("body").css("opacity", ap);
				ap = ap - 0.01;

			}, 100);
		}, 500);
	}, 1000);
});