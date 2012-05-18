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
/* *********************Content****************** */
div { /* 	outline: 1px solid red; */
	
}

#content {
	width: 1000px;
	margin-left: auto;
	margin-right: auto;
	height: 800px;
	/* 	outline: 5px solid red; */
}

#insideRight {
	width: 150px;
	height: 150px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 175px;
	background: url("img/fight/wait.gif") no-repeat;
}

#left {
	float: left;
	width: 400px;
	height: 420px;
	/* 	outline: 4px solid purple; */
}

#right {
	float: right;
	width: 400px;
	height: 420px;
	/* 	outline: 4px solid black; */
}
/* +++++++++++++HP++++++++++++++++++++++++++ */
#leftHP {
	height: 80px;
}

#rightHP {
	height: 80px;
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
	height: 25px;
	width: 96%;
	background-color: gray;
	float: left;
	border-radius: 25px;
}

#innerLeftProgressHP {
	height: 25px;
	width: 100%;
	border-radius: 25px;
}

#rightProgressHP {
	height: 25px;
	width: 96%;
	background-color: gray;
	float: right;
	border-radius: 25px;
}

#innerRightProgressHP {
	height: 25px;
	width: 100%;
	float: left;
	border-radius: 25px;
}
/* ************************************** */
#rightAgility,#rightStrength,#rightInteligence {
	float: right;
}
/* ***************Attack Block**************************** */
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
/* ***************Inventory***User1***************** */
#user1Inventory {
	width: 300px;
	height: 100px;
	clear: both;
	/* 	outline: 5px solid blue; */
	margin-left: auto;
	margin-right: auto;
}

#user1Item1 {
	width: 100px;
	height: 100px;
	float: left;
	background-image: url("img/fight/item1.png");
}

#user1Item2 {
	width: 100px;
	height: 100px;
	float: left;
	background-image: url("img/fight/item2.png");
}

#user1Item3 {
	width: 100px;
	height: 100px;
	float: left;
	background-image: url("img/fight/item3.png");
}
/* ***************Inventory***User2***************** */
#user2Inventory {
	width: 300px;
	height: 100px;
	clear: both;
	/* 	outline: 5px solid blue; */
	margin-left: auto;
	margin-right: auto;
}

#user2Item1 {
	width: 100px;
	height: 100px;
	float: right;
	background-image: url("img/fight/item1.png");
}

#user2Item2 {
	width: 100px;
	height: 100px;
	float: right;
	background-image: url("img/fight/item2.png");
}

#user2Item3 {
	width: 100px;
	height: 100px;
	float: right;
	background-image: url("img/fight/item3.png");
}

#attackBlockDoll {
	width: 200px;
	/* 	height: 100px;; */
	/* 	outline: 5px solid green; */
	margin-left: 400px;
	margin-right: 400px;
}

#doll {
	width: 150px;
	height: 400px;
	margin: 0 auto;
	background: url("img/fight/doll.png") no-repeat;
}
</style>
</head>
<body>
	<div id="content">
		<!-- 	++++++++++++++++++++++++++++++++++++++++++CREATOR++++++++++++++++++++++++++++++++++++++ -->
		<!-- 	+++++++++++++++LEFT CREATOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<c:if test="${gameRole=='creator'}">
			<div id="leftRightWrapper">

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

				</div>


				<!-- 	+++++++++++++++END LEFT CREATOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
				<!-- 	+++++++++++++++RIGHT CREATOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
				<!-- ++++++++++++++++++GAME NOT STARTED+++++++++++++++++++++++++++++++ -->
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
						</div>
					</c:otherwise>
				</c:choose>
				<div id="attackBlockDoll">
					<div id="doll"></div>
				</div>
				<div id="user1Inventory">
					<div id="user1Item1"></div>
					<div id="user1Item2"></div>
					<div id="user1Item3"></div>
				</div>

			</div>
		</c:if>
		<!-- 	+++++++++++++++++++++++++END RIGHT CREATOR+++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!-- 	+++++++++++++++++++++++++++++++++++++END_CREATOR+++++++++++++++++++++++++++++++++++++++++ -->





		<!-- +++++++++++++++++++++++++++++++++++++++++CONNECTOR++++++++++++++++++++++++++++++++++++++++++++ -->
		<!-- 	+++++++++++++++LEFT CONNECTOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<c:if test="${gameRole=='connector'}">
			<div id="leftRightWrapper">
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
				</div>
				<div id="attackBlockDoll">
					<div id="doll"></div>
				</div>
				<div id="user2Inventory">
					<div id="user2Item1"></div>
					<div id="user2Item2"></div>
					<div id="user2Item3"></div>
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