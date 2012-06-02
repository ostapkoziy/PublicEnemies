$(function()
{
	var ap = 1;
	setTimeout(function()
	{
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
//				$("body").css("opacity", ap);
				ap = ap - 0.01;

			}, 100);
		}, 500);
	}, 1000);
});