<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fight Result</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/fight/newLevel.js"></script>
<script type="text/javascript" src="js/fight/shootBlood.js"></script>
<link href="css/fight/result.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="resultWrapper">
		<div id="result"></div>
		<div id="result1"></div>
		<div id="result2" class="result2"></div>
		<div id="result3" class="result3">
			<div id="imageWrapper">
				<audio controls="controls" autoplay="autoplay">
					<source src="/img/fight/shoot.mp3" type="audio/mpeg"></source>
					<!-- 		<source src="song.ogg" type="audio/ogg"></source> -->
					<!-- 		<embed height="50px" width="100px" src="song.mp3"></embed> -->
				</audio>
				<c:choose>
					<c:when test="${win==true}">
						<link href="css/fight/winnerB.css" rel="stylesheet" type="text/css">

					</c:when>
					<c:otherwise>
						<link href="css/fight/loserB.css" rel="stylesheet" type="text/css">
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<div id="expirience2" class="result2"></div>
	<div id="expirience3" class="result3">
		<div>Level: ${myProfile.getLevel().getCurrentLevel()}</div>
		<div>All Exp: ${myProfile.getLevel().getAllExpirience()}</div>
		<div>%: ${myProfile.getLevel().getNextLevelInPercent()}%</div>
		<div>Exp AfterFight:${myProfile.getLevel().getExpirienceAfterFight()}</div>
		<div>Exp on Current Lvl: ${myProfile.getLevel().getExpOnCurrentLevel()}</div>
	</div>
	<div id="bulletHole1" hidden=""></div>
	<div id="bulletHole2" hidden=""></div>
	<!-- 	<audio style="z-index: 90000;" controls="controls" src="img/fight/shoot.mp3" autoplay="autoplay"></audio> -->

	<c:if test="${myProfile.getLevel().isNewLevel()}">
		<div id="newLevel"></div>
		<div id="statsWrapper">
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

</body>
</html>