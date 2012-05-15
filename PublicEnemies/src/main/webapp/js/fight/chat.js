$(function()
{
	var interval = 0;
	var eventsReverse = false;
	chatUserChoise();
	/**
	 * Scroll chat to bottom
	 */
	function chatScroll()
	{
		$("#t1").prop({

			scrollTop : $("#t1").prop("scrollHeight") });
	}
	/**
	 * If user choise autoUpdate chat in first round, in second round this
	 * option will be enable
	 */
	function chatUserChoise()
	{
		if ($.cookie("chatAuto") == "true")
		{
			$("#autoRefresh").css("background-color", "green");
			eventsReverse = true;
			autoUpdate();
		}
	}
	/**
	 * Sending messege to server
	 */
	$("#submit").click(function()
	{
		mess = $("#t2").val();
		$("#t2").val("");
		$.post("MessageServlet", {
			mess : mess }, function(data)
		{
			$("#t1").html(data);
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
			$("#t1").html(data);
		});
	});
	/**
	 * Update chat
	 */
	function update()
	{
		$.post("ViewServlet", {}, function(data)
		{
			$("#t1").html(data);
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
	 * Enable/disable autoUpdate
	 */
	$("#autoRefresh").toggle(autoON, autoOFF);
	/**
	 * ON
	 */
	function autoON()
	{
		if (!eventsReverse)
		{
			$("#autoRefresh").css("background-color", "green");
			$.cookie("chatAuto", "true");
			autoUpdate();
		}
		else
		{
			$("#autoRefresh").css("background-color", "red");
			$.cookie("chatAuto", null);
			clearInterval(interval);
		}

	}
	/**
	 * OFF
	 */
	function autoOFF()
	{
		if (!eventsReverse)
		{
			$("#autoRefresh").css("background-color", "red");
			$.cookie("chatAuto", null);
			clearInterval(interval);
		}
		else
		{
			$("#autoRefresh").css("background-color", "green");
			$.cookie("chatAuto", "true");
			autoUpdate();
		}
	}
	/**
	 * Show messeges when window load
	 */
	$(window).load(function()
	{
		$.post("ViewServlet", {}, function(data)
		{
			$("#t1").html(data);
			chatScroll();

		});
	});
	/**
	 * BOXSHADOW_TO_TEXTAREA
	 */
	$("#t2").focus(function()
	{
		$(this).addClass("boxshadow");
	});
	$("#t2").blur(function()
	{
		$(this).removeClass("boxshadow");
	});

});