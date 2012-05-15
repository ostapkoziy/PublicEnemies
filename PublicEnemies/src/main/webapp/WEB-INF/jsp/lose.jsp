<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>You Lose</title>
<style type="text/css">
#lose { /* 	outline: 2px solid red; */
	width: 484px;
	height: 331px;
	margin-left: auto;
	margin-right: auto;
	background: url("img/lose.jpg") no-repeat;
}
</style>
</head>

<body>
	Game:${game}
	<br />${gameRole}
	<br />User1: ${game.user1.page}
	<br />User2: ${game.user2.page}
	<br />
	<a href="index.html">Index</a>
	<div id="lose"></div>
</body>
</html>