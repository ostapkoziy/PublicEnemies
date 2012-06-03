$(function()
{
	$("#profession_select").change(function()
	{
		var prof = $("#profession_select").val();
		if (prof == "Butcher")
		{
			$("#profImg").css("background", "url(img/avatars/butcher.png)");

		}
		if (prof == "Gangster")
		{
			$("#profImg").css("background", "url(img/avatars/gangsterPr.png)");
		}
		if (prof == "Criminal")
		{
			$("#profImg").css("background", "url(img/avatars/criminal.png)");
		}
	});
});
