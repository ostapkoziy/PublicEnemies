var toServer = 3000;
var intervalID;
/**
 * Відсилає Ajax запит на сервер <br/> <b>Відсилає:</b> ID гри <br/><b>Приймає:</b>
 * true/false чи стартувала гра(чи хтось законектився)<br/> Цей срипт для
 * CREATORA
 */
function isGameStarted()
{
	$.ajax({
		url : "WaitForOpponent.html",
		success : function(isGameStarted)
		{
			if (isGameStarted != "false")
			{
				clearInterval(intervalID);
				window.location.reload();
			}
		},
		error : function(e, ajaxOptions, thrownError)
		{
			alert(e.status);
			alert(thrownError);
			alert("Error in isGameStarted()");
		} });
}
/**
 * Перевіряє чи стартувала гра кожні 3 секунди
 */
function waitForOpponent()
{
	intervalID = setInterval(isGameStarted, toServer);
}
