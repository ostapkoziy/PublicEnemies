<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function()
	{
		// 		$("#color1,#color2,color3").hide();
		$("#color1").click(function()
		{
			$("#color1,#color2,color3").hide();
		});
	});
</script>
<style type="text/css">
body {
	padding: 0px;
	margin: 0px;
	height: 1200px;
}

#color1 {
	width: 100%;
	height: 100%;
	opacity: 0.9;
	position: fixed;
	left: 0;
	top: 0;
	background: url("img/fight/overlay.png");
	z-index: 1000;
}

#color2 {
	position: fixed;
	width: 600px;
	height: 480px;
	z-index: 2000;
	background: black;
	top: 100px;
	left: 0;
	right: 0;
	margin-left: auto;
	margin-right: auto;
	opacity: 0.6;
	border-radius: 15px;
}

#color3 {
	position: fixed;
	width: 560px;
	height: 440px;
	top: 120px;
	left: 0;
	right: 0;
	margin-left: auto;
	margin-right: auto;
	z-index: 3000;
	background: white;
	border-radius: 15px;
	/* 	outline: 2px solid blue; */
}

#imageWrapper {
	margin-left: auto;
	margin-right: auto;
	margin-top: 20px;
	width: 334px;
	margin-left: auto;
	outline: 2px solid blue;
}

#createJoin {
	outline: 10px solid red;
}
</style>
</head>

<body>
	<div id="color1"></div>
	<div id="color2"></div>
	<div id="color3">
		<div id="imageWrapper">
			<img alt="" src="img/fight/you-win.png">
			<!--<img alt="asfasf" src="img/fight/you-lose.png"> -->
		</div>
		<div id="createJoinWrapper">
			<form action="createGame.html" method="post">
				<button id="create" type="submit">Create</button>
			</form>
			<a href="allGames.html">ALL GAMES</a>
		</div>
	</div>
</body>
</html>