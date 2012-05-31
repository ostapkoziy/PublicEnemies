$(function()
{
	$("#newLevel").toggle(function()
	{
		$("#statsWrapper").removeAttr("hidden");

	}, function()
	{
		$("#statsWrapper").attr("hidden", true);
	});

	function hideShow()
	{
		$("#newLevel").fadeTo(1000, 0);
		$("#newLevel").fadeTo(1000, 1);
		setTimeout(hideShow, 2000);
	}
	hideShow();
});