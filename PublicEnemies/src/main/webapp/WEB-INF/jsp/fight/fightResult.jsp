<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fight Resault</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function()
	{
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
	/* 	outline: 2px solid blue; */
}

#createJoinWrapper { /* 	outline: 10px solid red; */
	margin-left: auto;
	margin-right: auto;
	width: auto;
}
</style>
</head>

<body>
	<div id="color1"></div>
	<div id="color2"></div>
	<div id="color3">
		<c:choose>
			<c:when test="${gameRole=='creator'}">
				<div id="imageWrapper">
					<img alt="" src="img/fight/you-win.png">
				</div>
			</c:when>
			<c:otherwise>
				<div id="imageWrapper">
					<img alt="" src="img/fight/you-lose.png">
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>