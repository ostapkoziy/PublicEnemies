<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/fight/hit.js"></script>
<script type="text/javascript" src="js/fight/waitForConnect.js"></script>
<script type="text/javascript" src="js/fight/chat.js"></script>
<script type="text/javascript" src="js/fight/hpBar.js"></script>
<script type="text/javascript" src="js/fight/timer.js"></script>

<link href="css/fight/content.css" rel="stylesheet" type="text/css">
<title>FIGHT</title>
<style type="text/css">
div { /* 	outline: 1px solid red; */
	
}

#content {
	width: 800px;
	margin-left: auto;
	margin-right: auto;
	height: 800px;
	/* 	outline: 5px solid red; */
}

#insideRight { /* 	outline: 2px solid black; */
	width: 150px;
	height: 150px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 175px;
	background: url("img/fight/wait.gif") no-repeat;
}
/* ++++++++++++++++++++++++++++++++++++++++ */
#left {
	float: left;
	width: 400px;
	height: 420px;
}

#right {
	float: right;
	width: 400px;
	height: 420px;
}
/* +++++++++++++++++++++++++++++++++++++++ */
#leftHP {
	height: 70px;
}

#rightHP {
	height: 70px;
}

#rightHPWrapper {
	float: right;
}

#leftHPWrapper {
	float: left;
}
/* **************STATS****************** */
#leftStats {
	width: 100px;
	height: 250px;
	float: left;
}

#rightStats {
	width: 100px;
	height: 250px;
	float: right;
}

#leftStatsWrapper {
	float: left;
}

#rightStatsWrapper {
	float: right;
}
/* *************AVATAR*********************** */
#leftAvatar {
	margin-left: 100px;
	outline: 2px solid green;
	width: 200px;
	height: 250px;
}

#rightAvatar {
	margin-left: 100px;
	outline: 2px solid green;
	width: 200px;
	height: 250px;
}
/* +++++++++++++++++++HP++++++++++++++++++++++ */
#leftProgressHP {
	height: 15px;
	width: 96%;
	background-color: gray;
	float: left;
	border-radius: 25px;
}

#innerLeftProgressHP {
	height: 15px;
	width: 100%;
	border-radius: 25px;
}

#rightProgressHP {
	height: 15px;
	width: 96%;
	background-color: gray;
	float: right;
	border-radius: 25px;
}

#innerRightProgressHP {
	height: 15px;
	width: 100%;
	float: left;
	border-radius: 25px;
}
/* ************************************** */
#rightAgility,#rightStrength,#rightInteligence {
	float: right;
}
/* ******************************************* */
#attackBlock {
	margin-left: auto;
	margin-right: auto;
	width: 75px;
	clear: both;
}

#atackButtonWrapper {
	width: 72px;
	height: 75px;
}

#hitInput {
	width: 30px;
}

#blockInput {
	width: 30px;
}
/* ****************COLOR HP*********************** */
.orange {
	background: url("img/fight/orange.png");
}

.red {
	background: url("img/fight/red.png");
}

.green {
	background: url("img/fight/green.png");
}
/* ****************TIMER***************************** */
#timer {
	width: 100%;
	height: 20px;
	/* 	outline: 2px solid red; */
}
/* *********************************** */
#leftInventory {
	width: 300px;
	height: 100px;
	float: left;
}

#rightInventory {
	width: 300px;
	height: 100px;
	float: right;
}

#leftItem1 {
	width: 100px;
	height: 100px;
	float: left;
	/* 	outline: 5px solid blue; */
	background-image: url("img/fight/item1.png");
}

#leftItem2 {
	width: 100px;
	height: 100px;
	float: left;
	/* 	outline: 2px solid green; */
	background-image: url("img/fight/item2.png");
}

#leftItem3 {
	width: 100px;
	height: 100px;
	float: left;
	background-image: url("img/fight/item3.png");
}

#rightItem1 {
	width: 100px;
	height: 100px;
	float: right;
	/* 	outline: 5px solid blue; */
	background-image: url("img/fight/item1.png");
}

#rightItem2 {
	width: 100px;
	height: 100px;
	float: right;
	/* 	outline: 2px solid green; */
	background-image: url("img/fight/item2.png");
}

#rightItem3 {
	width: 100px;
	height: 100px;
	float: right;
	background-image: url("img/fight/item3.png");
}
</style>
</head>
<body>
	<div id="content">
		<!-- 	++++++++++++++++++++++++++++++++++++++++++CREATOR++++++++++++++++++++++++++++++++++++++ -->
		<!-- 	+++++++++++++++LEFT CREATOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<c:if test="${gameRole=='creator'}">
			<div id="left">
				<div id="leftHP">
					<div id="leftHPWrapper">
						<img alt="HP" src="img/hp.png">
						<span id="U1HP">${game.user1profile.getHP()}</span>
					</div>
					<div id="leftProgressHP">
						<div id="innerLeftProgressHP" class="green"></div>
					</div>
				</div>
				<div id="leftStats">
					<div id="leftStatsWrapper">
						<div id="leftAgility">
							<img src="img/stats/agility.png">
							${game.user1profile.getAgility()}
						</div>
						<div id="leftStrength">
							<img src="img/stats/strength.png">
							${game.user1profile.getStrength()}
						</div>
						<div id="leftInteligence">
							<img src="img/stats/inteligence.png">
							${game.user1profile.getIntellect()}
						</div>
					</div>
				</div>
				<div id="leftAvatar">
					<img alt="avatar" src="img/fight/3.jpg" width="200">
				</div>
				<div id="leftInventory">
					<div id="leftItem1"></div>
					<div id="leftItem2"></div>
					<div id="leftItem3"></div>
				</div>
			</div>
			<!-- 	+++++++++++++++END LEFT CREATOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<!-- 	+++++++++++++++RIGHT CREATOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
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
						<div id="rightHP">
							<div id="rightHPWrapper">
								<span id="U2HP">${game.user2profile.getHP()}</span>
								<img alt="HP" src="img/hp.png">
							</div>
							<div id="rightProgressHP">
								<div id="innerRightProgressHP" class="green"></div>
							</div>
						</div>
						<div id="rightStats">
							<div id="rightStatsWrapper">
								<div id="rightAgility">
									${game.user2profile.getAgility()}
									<img src="img/stats/agility.png">
								</div>
								<div id="rightStrength">
									${game.user2profile.getStrength()}
									<img src="img/stats/strength.png">
								</div>
								<div id="rightInteligence">
									${game.user2profile.getIntellect()}
									<img src="img/stats/inteligence.png">
								</div>
							</div>
						</div>
						<div id="rightAvatar">
							<img alt="avatar" src="img/fight/4.jpg" width="200">
						</div>
						<div id="rightInventory">
							<div id="rightItem1"></div>
							<div id="rightItem2"></div>
							<div id="rightItem3"></div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</c:if>
		<!-- 	+++++++++++++++++++++++++END RIGHT CREATOR+++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!-- 	+++++++++++++++++++++++++++++++++++++END_CREATOR+++++++++++++++++++++++++++++++++++++++++ -->





		<!-- +++++++++++++++++++++++++++++++++++++++++CONNECTOR++++++++++++++++++++++++++++++++++++++++++++ -->
		<!-- 	+++++++++++++++LEFT CONNECTOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<c:if test="${gameRole=='connector'}">
			<script type="text/javascript">
				wait();
			</script>
			<div id="left">
				<div id="leftHP">
					<div id="leftHPWrapper">
						<img alt="HP" src="img/hp.png">
						<span id="U2HP">${game.user2profile.getHP()}</span>
					</div>
					<div id="leftProgressHP">
						<!-- *********************Inversion************** -->
						<div id="innerRightProgressHP" class="green"></div>
					</div>
				</div>
				<div id="leftStats">
					<div id="leftStatsWrapper">
						<div id="leftAgility">
							<img src="img/stats/agility.png">
							${game.user2profile.getAgility()}
						</div>
						<div id="leftStrength">
							<img src="img/stats/strength.png">
							${game.user2profile.getStrength()}
						</div>
						<div id="leftInteligence">
							<img src="img/stats/inteligence.png">
							${game.user2profile.getIntellect()}
						</div>
					</div>
				</div>
				<div id="leftAvatar">
					<img alt="avatar" src="img/fight/4.jpg" width="200">
				</div>
				<div id="leftInventory">
					<div id="leftItem1"></div>
					<div id="leftItem2"></div>
					<div id="leftItem3"></div>
				</div>
			</div>
			<!-- 	++++++++++++++++++++++++END LEFT CONNECTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<!-- 	++++++++++++++++++++++RIGHTT CONNECTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<div id="right">
				<div id="rightHP">
					<div id="rightHPWrapper">
						<span id="U1HP">${game.user1profile.getHP()}</span>
						<img alt="HP" src="img/hp.png">
					</div>
					<div id="rightProgressHP">
						<!-- *********************Inversion************** -->
						<div id="innerLeftProgressHP" class="green"></div>
					</div>
				</div>
				<div id="rightStats">
					<div id="rightStatsWrapper">
						<div id="rightAgility">
							${game.user1profile.getAgility()}
							<img src="img/stats/agility.png">
						</div>
						<div id="rightStrength">
							${game.user1profile.getStrength()}
							<img src="img/stats/strength.png">
						</div>
						<div id="rightInteligence">
							${game.user1profile.getIntellect()}
							<img src="img/stats/inteligence.png">
						</div>
					</div>
				</div>
				<div id="rightAvatar">
					<img alt="avatar" src="img/fight/3.jpg" width="200">
				</div>
				<div id="rightInventory">
					<div id="rightItem1"></div>
					<div id="rightItem2"></div>
					<div id="rightItem3"></div>
				</div>
			</div>
		</c:if>
		<!-- 	+++++++++++++++++++++END RIGHT CONNECTOR++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!-- +++++++++++++++++++++++++++++++++++++++END CONNECTOR+++++++++++++++++++++++++++++++++++++++++ -->



		<div id="attackBlock">
			<div id="timer"></div>
			<input id="hitInput" type="text" value="Head">
			<input id="blockInput" type="text" value="Head">
			<div id="atackButtonWrapper">
				<img id="atackButton" src="img/fight/attack.jpg">
			</div>
		</div>





		<div id="box">
			<form action="MessageServlet">
				<div id="allMesseges"></div>
				<textarea id="myMessege"></textarea>
				<div id="chatSubmit">
					<input id="submit" type="button" name="submit" value="Ok">
				</div>
			</form>
		</div>

	</div>
</body>
</html>