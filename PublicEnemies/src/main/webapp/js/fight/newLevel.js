$(function()
{
	$("#newLevel").toggle(function()
	{
		$("#statsWrapper").removeAttr("hidden");

	}, function()
	{
		$("#statsWrapper").attr("hidden", true);
	});
	var points = $("#pointsInput").val();
	var curStr = $("#strInput").val();
	var curAgl = $("#aglInput").val();
	var curInt = $("#intInput").val();
	var newStr = curStr;
	var newAgl = curAgl;
	var newInt = curInt;

	$(".greenPlus").click(function()
	{
		var elem = $(this).next();
		if (points > 0)
		{
			$("#pointsInput").val(--points);
			elem.val(parseInt(elem.val()) + 1);
			if (elem.attr("name") == 'strength')
			{
				newStr++;
			}
			if (elem.attr("name") == 'agility')
			{
				newAgl++;
			}
			if (elem.attr("name") == 'inteligance')
			{
				newInt++;
			}
		}

	});
	$(".redMinus").click(function()
	{
		var elem = $(this).prev();
		if (points < 5)
		{
			if (elem.attr("name") == 'strength' && newStr > curStr)
			{
				$("#pointsInput").val(++points);
				elem.val(parseInt(elem.val()) - 1);
				--newStr;
			}
			if (elem.attr("name") == 'agility' && newAgl > curAgl)
			{
				$("#pointsInput").val(++points);
				elem.val(parseInt(elem.val()) - 1);
				--newAgl;
			}
			if (elem.attr("name") == 'inteligance' && newInt > curInt)
			{
				$("#pointsInput").val(++points);
				elem.val(parseInt(elem.val()) - 1);
				--newInt;
			}
		}
	});
	function hideShow()
	{
		$("#newLevel").fadeTo(1000, 0);
		$("#newLevel").fadeTo(1000, 1);
		setTimeout(hideShow, 2000);
	}
	hideShow();
});