<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fight Result</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/fight/newLevel.js"></script>

<link href="css/fight/result.css" rel="stylesheet" type="text/css">
<link href="css/fight/bulletShtorm.css" rel="stylesheet" type="text/css">

</head>
<body>
	<audio id="audio">
		<source src="img/fight/shoot.mp3"></source>
	</audio>
	<div id="resultWrapper">

		<div id="result"></div>
		<div id="result1"></div>
		<div id="result2" class="result2"></div>
		<div id="result3" class="result3">
			<div id="imageWrapper">
				<c:choose>
					<c:when test="${win==true}">
						<link href="css/fight/winnerB.css" rel="stylesheet" type="text/css">
						<script type="text/javascript" src="js/fight/bulletShtorm.js"></script>
					</c:when>
					<c:otherwise>
						<link href="css/fight/loserB.css" rel="stylesheet" type="text/css">
						<script type="text/javascript" src="js/fight/shootBlood.js"></script>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<div id="expirience2" class="result2"></div>
	<div id="expirience3" class="result3">
		<div id="level">
			Level: <span> ${myProfile.getLevel().getCurrentLevel()}</span>
		</div>
		<div id="allExp">
			All Exp:<span> ${myProfile.getLevel().getAllExpirience()}</span>
		</div>
		<div id="expInPercent">
			%: <span> ${myProfile.getLevel().getNextLevelInPercent()}%</span>
		</div>
		<div id="expAfterFight">
			Exp After Fight: <span> ${myProfile.getLevel().getExpirienceAfterFight()}</span>
		</div>
		<div id="expOnCLVL">
			Exp on Current Lvl:<span> ${myProfile.getLevel().getExpOnCurrentLevel()}</span>
		</div>
	</div>
	<div id="bulletHole1" hidden=""></div>
	<div id="bulletHole2" hidden=""></div>
	<div id="blood" hidden=""></div>

	<c:if test="${myProfile.getLevel().isNewLevel()}">
		<div id="newLevel"></div>
		<div id="statsWrapper" hidden="">
			<form action="statsUpdate.html">
				<input id="pointsInput" type="text" value="5" class="statsInput">
				<div id="wrapper">
					<div id="strWrapper">
						<div id="strImg"></div>
						<div id="strPlus" class="greenPlus"></div>
						<input id="strInput" type="text" value="${myProfile.getStrength()}" class="statsInput" name="strength">
						<div id="strMinus" class="redMinus"></div>
					</div>
					<div id="aglWrapper">
						<div id="aglImg"></div>
						<div id="aglPlus" class="greenPlus"></div>
						<input id="aglInput" type="text" value="${myProfile.getAgility()}" class="statsInput" name="agility">
						<div id="aglMinus" class="redMinus"></div>
					</div>
					<div id="intWrapper">
						<div id="intImg"></div>
						<div id="intPlus" class="greenPlus"></div>
						<input id="intInput" type="text" value="${myProfile.getIntellect()}" class="statsInput" name="inteligance">
						<div id="intMinus" class="redMinus"></div>
					</div>
				</div>
				<button id="statsSubmit" type="submit">Ok</button>
			</form>
		</div>
	</c:if>





	<!-- 	*************HOLES -->
	<audio id="audio1">
		<source src="img/fight/shoot1.mp3"></source>
	</audio>
	<div id="bulletShtorm">
		<div id="hole1" class="hole"></div>
		<div id="hole2" class="hole"></div>
		<div id="hole3" class="hole"></div>
		<div id="hole4" class="hole"></div>
		<div id="hole5" class="hole"></div>
		<div id="hole6" class="hole"></div>
		<div id="hole7" class="hole"></div>
		<div id="hole8" class="hole"></div>
		<div id="hole9" class="hole"></div>
		<div id="hole10" class="hole"></div>
		<div id="hole11" class="hole"></div>
		<div id="hole12" class="hole"></div>
		<div id="hole13" class="hole"></div>
		<div id="hole14" class="hole"></div>
		<div id="hole15" class="hole"></div>
		<div id="hole16" class="hole"></div>
		<div id="hole17" class="hole"></div>
		<div id="hole18" class="hole"></div>
	</div>
</body>
</html>