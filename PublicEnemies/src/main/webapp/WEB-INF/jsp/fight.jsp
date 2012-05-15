<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fight</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/fight/jquery.cookie.js"></script>
<script type="text/javascript" src="js/fight/hit.js"></script>
<script type="text/javascript" src="js/fight/waitForConnect.js"></script>
<script type="text/javascript" src="js/fight/chat.js"></script>
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="css/content.css" rel="stylesheet" type="text/css">
<style type="text/css">
#left {
	outline: solid red 3px;
	float: left;
	height: 500px;
	width: 400px;
}

#right {
	outline: solid blue 3px;
	float: right;
	height: 500px;
	width: 400px;
}

#insideRight { /* 	outline: 2px solid black; */
	width: 150px;
	height: 150px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 175px;
	background: url("img/fight/wait.gif") no-repeat;
}

#center { /* 	outline: solid green 3px; */
	height: 250px;
	margin-left: 400px;
	margin-right: 400px;
	/* 	margin-top: 50px; */
}

#hit { /* 	outline: solid red 1px; */
	position: relative;
	margin: auto;
	width: 20px;
	float: left;
}

#block { /* 	outline: solid green 1px; */
	position: relative;
	margin: auto;
	width: 20px;
	float: right;
}

#attackButton {
	position: relative;
	margin: auto;
}

#radio { /* 	outline: solid black 1px; */
	position: relative;
	margin: auto;
	width: 80px;
	height: 205px;
}

.radioB {
	margin: 10px 0px 10px 0px;
	/* 	outline: 1px solid yellow; */
}

#timer { /* 	outline: 1px solid yellow; */
	text-align: center;
	font-size: 20px;
	font-weight: 800;
	/* 	margin-bottom: 20px; */
	height: 24px;
}

#statsUser1 { /* 	outline: 2px solid olive; */
	width: 100%;
	position: relative;
}

#statsUser2 { /* 	outline: 2px solid olive; */
	position: relative;
	width: 100%;
}

#autoRefresh {
	width: 20px;
	height: 20px;
	background-color: red;
	position: relative;
	margin: auto;
}

#buttons {
	position: relative;
	margin: 0 auto;
	width: 80px;
}

.hp {
	font-size: 32px;
}
</style>
</head>
<body>





	<!-- 	++++++++++++++++++++++++++++++++++++++++++CREATOR++++++++++++++++++++++++++++++++++++++ -->
	<c:if test="${gameRole=='creator'}">
		<div id="left">
			<div id="statsUser1">
				<div id="healthUser1" class="hp">
					<img alt="img/fight/crest.jpg" src="img/fight/crest.jpg">
					<span id="hpU1">${game.user1profile.getStrength()}</span>
				</div>
			</div>
			<%-- 			<div>ID: ${game.user1.id}</div> --%>
			<div style="color: blue; font-size: 3em;">${game.user1profile.getNickName()}</div>
			<%-- 			<img alt="user1" src="${game.user1.avatar}"> --%>
		</div>
		<c:choose>
			<c:when test="${game.gameStarted=='false'}">
				<script type="text/javascript">
					waitForOpponent();
				</script>
				<div id="right">
					<div id="insideRight"></div>
				</div>
			</c:when>
			<c:otherwise>
				<script type="text/javascript">
					wait();
				</script>
				<div id="right">
					<div id="statsUser2">
						<div id="healthUser2" class="hp">
							<img alt="img/fight/crest.jpg" src="img/fight/crest.jpg">
							<span id="hpU2">${game.user2profile.getStrength()}</span>
						</div>
					</div>
					<%-- 					<div>ID: ${game.user2.id}</div> --%>
					<div style="color: red; font-size: 3em;">${game.user2profile.getNickName()}</div>
					<%-- 					<img alt="user1" src="${game.user2.avatar}"> --%>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
	<!-- 	+++++++++++++++++++++++++++++++++++++END_CREATOR++++++++++++++++++++++++++++++++++++++++++++++ -->





	<!-- +++++++++++++++++++++++++++++++++++++++++CONNECTOR++++++++++++++++++++++++++++++++++++++++++++ -->
	<c:if test="${gameRole=='connector'}">
		<script type="text/javascript">
			wait();
		</script>
		<div id="left">
			<div id="statsUser2">
				<div id="healthUser2" class="hp">
					<img alt="img/fight/crest.jpg" src="img/fight/crest.jpg">
					<span id="hpU2">${game.user2profile.getStrength()}</span>
				</div>
			</div>
			<%-- 			<div>ID: ${game.user2.id}</div> --%>
			<div style="color: blue; font-size: 3em;">${game.user2profile.getNickName()}</div>
			<%-- 			<img alt="user1" src="${game.user2.avatar}"> --%>
		</div>
		<div id="right">
			<div id="statsUser1">
				<div class="hp" class="statsLeft">

					<div id="healthUser1">
						<img alt="img/fight/crest.jpg" src="img/fight/crest.jpg">
						<span id="hpU1">${game.user1profile.getStrength()}</span>
					</div>
				</div>
			</div>
			<%-- 			<div>ID: ${game.user1.id}</div> --%>
			<div style="color: red; font-size: 3em;">${game.user1profile.getNickName()}</div>
			<%-- 			<img alt="user1" src="${game.user1.avatar}"> --%>
		</div>
	</c:if>
	<!-- +++++++++++++++++++++++++++++++++++++++END_CONNECTOR+++++++++++++++++++++++++++++++++ -->



	<div id="center">
		<div id="radio">
			<div id="hit">
				<input type="radio" class="radioB" name="hit" value="HEAD" title="HEAD">
				<input type="radio" class="radioB" name="hit" value="HANDS" title="HANDS">
				<input type="radio" class="radioB" name="hit" value="BODY" title="BODY">
				<input type="radio" class="radioB" name="hit" value="LEGS" title="LEGS" checked="checked">
			</div>
			<div id="block">
				<input type="radio" class="radioB" name="block" value="HEAD" title="HEAD">
				<input type="radio" class="radioB" name="block" value="HANDS" title="HANDS">
				<input type="radio" class="radioB" name="block" value="BODY" title="BODY">
				<input type="radio" class="radioB" name="block" value="LEGS" title="LEGS" checked="checked">
			</div>
			<img id="atackButton" src="img/fight/attack.jpg">
		</div>
		<div id="timer"></div>
		<div class="box" id="rightbox2">
			<div class="boxContent">
				<form action="MessageServlet">
					<div id="t1"></div>
					<textarea id="t2"></textarea>
					<div id="buttons">
						<input id="submit" type="button" name="submit" value="Ok">
						<br />
						<img id="button" src="img/fight/r.jpg" alt="Refresh Chat" />
					</div>
					<div id="autoRefresh"></div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>