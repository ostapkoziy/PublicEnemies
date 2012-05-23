$(function()
{
	/**
	 * Chat ON
	 */
	autoUpdate();
	/**
	 * Scroll chat to bottom
	 */
	function chatScroll()
	{
		$("#allMesseges").prop({

			scrollTop : $("#allMesseges").prop("scrollHeight") });
	}
	/**
	 * Sending messege to server
	 */
	$("#submit").click(function()
	{
		mess = $("#myMessege").val();
		$("#myMessege").val("");
		$.post("MessageServlet", {
			mess : mess }, function(data)
		{
			$("#allMesseges").html(data);
			chatScroll();
		});
	});
	/**
	 * Update chat every 2 sec.
	 */
	function autoUpdate()
	{
		$.post("ViewServlet", {}, function(data)
		{
			$("#allMesseges").html(data);
			setTimeout(autoUpdate, 2000);
		});

	}

	/**
	 * Show messeges when window load
	 */
	$(window).load(function()
	{
		$.post("ViewServlet", {}, function(data)
		{
			$("#allMesseges").html(data);
			chatScroll();

		});
	});
	/**
	 * BOXSHADOW_TO_TEXTAREA
	 */
	$("#myMessege").focus(function()
	{
		$(this).addClass("boxshadow");
	});
	$("#myMessege").blur(function()
	{
		$(this).removeClass("boxshadow");
	});

});