$(function()
{
	var currentHole = 0;
	var holes = [ 14, 9, 4, 7, 13, 3, 15, 18, 10, 5, 12, 1, 11, 8, 6, 2, 17, 16 ];
	var audio = document.getElementById("audio1");
	var intervalShoot;
	function startShtorm()
	{
		$("#hole" + holes[currentHole]).css("display", "block");
		audio.play();
		currentHole++;
		if (currentHole == 18)
		{
			clearInterval(intervalShoot);
		}
	}
	intervalShoot = setInterval(startShtorm, 200);
});