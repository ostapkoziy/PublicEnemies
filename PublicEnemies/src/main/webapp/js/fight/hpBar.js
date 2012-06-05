function HPColor()
{
	var right = $("#innerRightProgressHP");
	var left = $("#innerLeftProgressHP");
	if (parseInt(right.css("width")) > 256)
	{
		right.removeClass("orange");
		right.removeClass("red");
		right.addClass("green");
	}
	if (parseInt(right.css("width")) < 256 && parseInt(right.css("width")) > 128)
	{
		right.removeClass("red");
		right.removeClass("green");
		right.addClass("orange");
	}
	if (parseInt(right.css("width")) < 128)
	{
		right.removeClass("green");
		right.removeClass("orange");
		right.addClass("red");
	}

	// ////////////////////LEFT
	if (parseInt(left.css("width")) > 256)
	{
		left.removeClass("orange");
		left.removeClass("red");
		left.addClass("green");
	}
	if (parseInt(left.css("width")) < 256 && parseInt(left.css("width")) > 128)
	{
		left.removeClass("red");
		left.removeClass("green");
		left.addClass("orange");
	}
	if (parseInt(left.css("width")) < 128)
	{
		left.removeClass("green");
		left.removeClass("orange");
		left.addClass("red");
	}

}
