/**
 * Відсилає Ajax запит на сервер <br/> <b>Відсилає:</b> ID гри <br/><b>Приймає:</b>
 * true/false чи стартувала гра(чи хтось законектився)<br/> Цей срипт для
 * CREATORA
 */
function waitForOpponent()
{
	$.ajax({
		url : "WaitForOpponent.html",
		success : function(isStarted)
		{
			if (isStarted != "false")
			{
				window.location.reload();
			}
			else
			{
				setTimeout(waitForOpponent, 1000);
			}
		},
		error : function(e, ajaxOptions, thrownError)
		{
			alert(e.status);
			alert(thrownError);
			alert("Error in isGameStarted()");
		} });
}
