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
</head>
<body>
	<div id="resultWrapper">
		<div id="result"></div>
		<div id="result1"></div>
		<div id="result2" class="result2"></div>
		<div id="result3" class="result3">
			<div id="imageWrapper">

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
		Level: ${myProfile.getLevel().getCurrentLevel()} <br /> All Exp: ${myProfile.getLevel().getAllExpirience()} <br /> %:
		${myProfile.getLevel().getNextLevelInPercent()}%<br /> Exp AfterFight:${myProfile.getLevel().getExpirienceAfterFight()}<br /> Exp on Current Lvl:
		${myProfile.getLevel().getExpOnCurrentLevel()}
	</div>
	<div id="bulletHole1"></div>
	<div id="bulletHole2"></div>

	<c:if test="${myProfile.getLevel().isNewLevel()}">

		<div id="newLevel"></div>

	</c:if>

</body>
</html>