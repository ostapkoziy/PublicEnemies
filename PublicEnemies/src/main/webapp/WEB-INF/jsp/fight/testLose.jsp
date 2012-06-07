<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TestLose</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/fight/shootBlood.js"></script>

<link href="css/fight/result.css" rel="stylesheet" type="text/css">
<link href="css/fight/loserB.css" rel="stylesheet" type="text/css">

</head>
<body>
	<audio id="audio">
		<source src="img/fight/shoot.mp3"></source>
	</audio>

	<div id="shadow">
		<div id="result"></div>
		<div id="result1"></div>
		<div id="result2" class="result2"></div>
		<div id="result3" class="result3">
			<div id="imageWrapper"></div>
		</div>
		<div id="expirience2" class="result2"></div>
		<div id="expirience3" class="result3">
			<div id="level">
				Level: <span> 1</span>
			</div>
			<div id="allExp">
				All Exp:<span> 245</span>
			</div>
			<div id="expInPercent">
				%: <span> 12%</span>
			</div>
			<div id="expAfterFight">
				Exp After Fight: <span> 0</span>
			</div>
			<div id="expOnCLVL">
				Exp on Current Lvl:<span> 245</span>
			</div>
			<div id="money">
				Money:<span> 0</span>
			</div>
		</div>


		<div id="bulletHole1" hidden=""></div>
		<div id="blood" hidden=""></div>


	</div>


	<!-- 	********New JOIN -->
	<div id="newJoin">
		<button id="main" type="button" class="buttons"
			onclick="window.location.replace('userStartPage.html')">MAIN</button>
		<button id="create" type="button" class="buttons"
			onclick="window.location.replace('createGame.html')">CREATE</button>
		<button id="join" type="button" class="buttons" onclick="window.location.replace('fights.html')">JOIN</button>
		<button id="statistic" type="button" class="buttons"
			onclick="window.location.replace('profile.html#statistics_place')">STATISTIC</button>
	</div>


</body>
</html>