<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="style/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<script type="text/javascript" src="js/roulette.js"></script>



</head>
<body>
	
	<b><c:out value="${user.name}, you have ${user.money}$. Make your bet!" /></b>
	<p><b><c:out value="${gameInfo.msg}" /></b>

	<form method="post" action="RouletteController" onsubmit="form_send()">
	
		<b>Your BET:</b>
		<input class="bet" type="radio" name="betVal" value="10" onclick="betChanged(this)" checked="checked"><b>10</b>
		<input class="bet" type="radio" name="betVal" value="25" onclick="betChanged(this)"><b>25</b>
		<input class="bet" type="radio" name="betVal" value="50" onclick="betChanged(this)"><b>50</b><p>
		<b>(to send):</b> <input id="userBetNumbers" type="text" name="userBetNumbers" readonly="readonly">
		<input id ="btn_test" type="button" value="test">
		<input id ="submit" type="submit" value="DEAL">
	</form>

	<img id="0" class="RouletteTable" src="img/0.bmp"/>
	<img id="1" class="RouletteTable" src="img/1.bmp"/>
	<img id="2" class="RouletteTable" src="img/2.bmp"/>
	<img id="3" class="RouletteTable" src="img/3.bmp"/><p>
	<img id="4" class="RouletteTable" src="img/4.bmp"/>
	<img id="5" class="RouletteTable" src="img/5.bmp"/>
	<img id="6" class="RouletteTable" src="img/6.bmp"/>
	<img id="7" class="RouletteTable" src="img/7.bmp"/>

</body>
</html>