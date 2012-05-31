<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fight Result</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<link href="css/fight/result.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="resultWrapper">
		<div id="result"></div>
		<div id="result1"></div>
		<div id="result2" class="result2"></div>
		<div id="result3" class="result3">
			<div id="imageWrapper">
				Creator: ${game.getCreatorProfile().getLevel().getCurrentLevel()} <br />Connector:
				${game.getConnectorProfile().getLevel().getCurrentLevel()}
				<c:choose>
					<c:when test="${win==true}">
						<link href="css/fight/winnerB.css" rel="stylesheet" type="text/css">
						All Exp: ${myProfile.getLevel().getAllExpirience()};
					</c:when>
					<c:otherwise>
						<link href="css/fight/loserB.css" rel="stylesheet" type="text/css">
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<div id="expirience2" class="result2"></div>
	<div id="expirience3" class="result3"></div>
	<div id="bulletHole1"></div>
	<div id="bulletHole2"></div>

</body>
</html>