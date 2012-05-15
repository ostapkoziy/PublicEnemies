function hello()
{
	alert("hello");
}
function redirect()
{
	window.location = "allGames.html";
}

function ajaxSpring()
{
	$.ajax({
		url : "ajax.html",
		data : ({
			name : "Alex",
			time : 13111414 }),

		success : function(data)
		{
			alert("It works");
			alert(data);
		},
		error : function(e, ajaxOptions, thrownError)
		{
			alert(e.status);
			alert(thrownError);
		} });
}