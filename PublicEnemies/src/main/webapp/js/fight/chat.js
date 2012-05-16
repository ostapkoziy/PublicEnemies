$(function()
{
	/**
	 * Chat ON
	 */
	chatUserChoise();
	/**
	 * Scroll chat to bottom
	 */
	function chatScroll()
	{
		$("#allMesseges").prop({

			scrollTop : $("#allMesseges").prop("scrollHeight") });
	}
	/**
	 * If user choise autoUpdate chat in first round, in second round this
	 * option will be enable
	 */
	function chatUserChoise()
	{
		autoUpdate();
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
	 * Refresh by click
	 */
	$("#button").click(function()
	{
		$.post("ViewServlet", {}, function(data)
		{
			$("#allMesseges").html(data);
		});
	});
	/**
	 * Update chat
	 */
	function update()
	{
		$.post("ViewServlet", {}, function(data)
		{
			$("#allMesseges").html(data);
		});

	}
	/**
	 * Refresh chat each 2 second
	 */
	function autoUpdate()
	{
		interval = setInterval(update, 2000);
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