<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>You Win</title>
<style type="text/css">
#win { /* 	outline: 2px solid red; */
	width: 400px;
	height: 400px;
	margin-left: auto;
	margin-right: auto;
	background: url("img/you-win.jpg") no-repeat;
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
	<div id="win"></div>
</body>
</html>