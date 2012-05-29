<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.imagemapster.js"></script>
<script type="text/javascript" src="js/fight/imageMap.js"></script>
<script type="text/javascript" src="js/fight/hit.js"></script>
<script type="text/javascript" src="js/fight/waitForConnect.js"></script>
<script type="text/javascript" src="js/fight/chat.js"></script>
<script type="text/javascript" src="js/fight/hpBar.js"></script>
<script type="text/javascript" src="js/fight/timer.js"></script>

<link href="css/fight/content.css" rel="stylesheet" type="text/css">
<link href="css/fight/fight.css" rel="stylesheet" type="text/css">
<style type="text/css">
div { /* 	outline: 2px solid green; */
	
}
</style>
<c:choose>
	<c:when test="${gameRole=='creator'}">
		<title>${game.creatorProfile.getNickName()} vs. ${game.connectorProfile.getNickName()}</title>
	</c:when>
	<c:otherwise>
		<title>${game.connectorProfile.getNickName()} vs. ${game.creatorProfile.getNickName()}</title>
	</c:otherwise>
</c:choose>
</head>
<body>
	<div id="content">
		<c:if test="${gameRole=='creator'}">
			<jsp:include page="include/creator.jsp"></jsp:include>
		</c:if>
		<c:if test="${gameRole=='connector'}">
			<jsp:include page="include/connector.jsp"></jsp:include>
		</c:if>
		<!-- ******************************************************* -->
		<!-- ********************ATACK DOLL**************************** -->
		<!-- ******************************************************* -->
		<div id="attackBlockDoll">
			<div id="doll">
				<div style="float: left;">
					<img class="map" id="doll_block" src="img/fight/doll_block.png" usemap="#table1" />
				</div>
				<div style="float: left;">
					<img class="map" id="doll_hit" src="img/fight/doll_hit.png" usemap="#table2" />
				</div>
				<jsp:include page="include/map.jsp"></jsp:include>
			</div>
		</div>
		<!-- ******************************************************* -->
		<!-- ********************ATACK Block**************************** -->
		<!-- ******************************************************* -->
		<div id="attackBlock">
			<div id="timer"></div>
			<input id="blockInput" type="text" value="head">
			<input id="hitInput" type="text" value="head">
			<input id="aidInput" type="text" value="false">
			<div id="atackButtonWrapper">
				<img id="atackButton" src="img/fight/attack.jpg">
			</div>
		</div>
		<!-- ******************************************************* -->
		<!-- ********************CHAT**************************** -->
		<!-- ******************************************************* -->



		<div id="box">
			<div id="allMesseges"></div>
			<textarea id="myMessege"></textarea>
			<div id="chatSubmit">
				<input id="submit" type="button" name="submit" value="Ok">
			</div>
		</div>




	</div>
</body>
</html>
