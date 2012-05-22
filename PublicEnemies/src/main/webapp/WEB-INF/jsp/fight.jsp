<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/fight/content.css" rel="stylesheet" type="text/css">
<title>FIGHT</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.imagemapster.js"></script>
<script type="text/javascript" src="js/fight/imageMap.js"></script>
<script type="text/javascript" src="js/fight/hit.js"></script>
<script type="text/javascript" src="js/fight/waitForConnect.js"></script>
<script type="text/javascript" src="js/fight/chat.js"></script>
<script type="text/javascript" src="js/fight/hpBar.js"></script>
<script type="text/javascript" src="js/fight/timer.js"></script>
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
	height: 430px;
	/* 	outline: 4px solid purple; */
}

#right {
	float: right;
	width: 400px;
	height: 430px;
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
	outline: 2px solid red;
}
/* ***************Inventory***User1***************** */
#user1Inventory {
	width: 300px;
	height: 100px;
	clear: both;
	/*outline: 5px solid blue; */
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
/* #user2Inventory { */
/* 	width: 300px; */
/* 	height: 100px; */
/* 	clear: both; */
/* 	/* 	outline: 5px solid blue; */
* /
	/* 	margin-left: auto; */
	/* 	margin-right: auto; */
	/* } */
	/* #user2Item1 { */
	/* 	width: 100px; */
	/* 	height: 100px; */
	/* 	float: left; */
	/* 	background-image: url("img/fight/item1.png"); */
	/* } */
	/* #user2Item2 { */
	/* 	width: 100px; */
	/* 	height: 100px; */
	/* 	float: left; */
	/* 	background-image: url("img/fight/item2.png"); */
	/* } */
	/* #user2Item3 { */
	/* 	width: 100px; */
	/* 	height: 100px; */
	/* 	float: left; */
	/* 	background-image: url("img/fight/item3.png"); */
	/* } */
	/* **************DOLL********************* */                     
#attackBlockDoll {
	width: 200px;
	/* 	height: 100px;; */
	/* 	outline: 5px solid green; */
	margin-left: 400px;
	margin-right: 400px;
}

/* *********************************************************** */
#rightInventory {
	float: right;
	height: 100px;
	width: 400px;
	/* 	outline: 3px solid red; */
}

#leftInventory {
	height: 100px;
	width: 400px;
	/* 	outline: 7px solid blue; */
}

.item {
	float: left;
	height: 100px;
	width: 100px;
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
					<div id="leftInventory">
						<div class="item">
							<img src="${game.user1profile.getDressedWeapon1().getItemPicture()}">
						</div>
						<div class="item">
							<img src="${game.user1profile.getDressedWeapon2().getItemPicture()}">
						</div>
						<div class="item">
							<img src="${game.user1profile.getDressedArmor().getItemPicture()}">
						</div>
						<div class="item">
							<img src="${game.user1profile.getDressedAid().getItemPicture()}">
						</div>
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
							<div id="rightInventory">
								<div class="item">
									<img src="${game.user2profile.getDressedWeapon1().getItemPicture()}">
								</div>
								<div class="item">
									<img src="${game.user2profile.getDressedWeapon2().getItemPicture()}">
								</div>
								<div class="item">
									<img src="${game.user2profile.getDressedArmor().getItemPicture()}">
								</div>
								<div class="item">
									<img src="${game.user2profile.getDressedAid().getItemPicture()}">
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
				<div id="attackBlockDoll">
					<img class="map" id="doll_block" src="img/fight/doll_block.png" usemap="#table1"/>
					<img class="map" id="doll_hit" src="img/fight/doll_hit.png" usemap="#table2"/>
				</div>
				<map name="table1" id="map_block">
					<area href="#" group="head" class="block" title="head" 	shape="poly" coords=" 74,4, 70,5, 66,7, 61,10, 57,15, 55,22, 55,30, 56,37, 57,43, 59,48, 62,52, 66,55, 71,55, 74,54, 74,8">
					<area href="#" group="hand" class="block" title="hand" 	shape="poly"  coords=" 39,125, 35,135, 35,141, 35,152, 34,161, 32,168, 30,174, 26,182, 24,187, 24,191, 26,195, 29,201, 30,208, 31,214, 28,214, 25,211, 24,208, 24,205, 22,212, 25,217, 28,219, 31,223, 29,227, 27,228, 25,228, 22,226, 16,222, 14,217, 13,212, 11,204, 9,178, 10,172, 11,158, 12,149, 13,139, 17,134, 19,111, 19,104, 19,97, 18,86, 21,82, 27,77, 32,74, 36,72, 42,75, 46,78, 49,88, 49,102, 48,109, 47,115, 43,123, 41,124">
					<area href="#" group="leg" class="block" title="leg" 		shape="poly" coords=" 42,167, 38,175, 36,185, 34,193, 34,201, 34,208, 33,219, 33,229, 34,238, 37,249, 38,259, 40,268, 41,277, 40,282, 36,288, 35,303, 35,312, 36,324, 39,334, 41,344, 44,352, 43,360, 41,367, 35,375, 36,380, 40,382, 44,383, 49,383, 57,381, 58,376, 58,372, 60,368, 60,364, 60,360, 59,358, 58,353, 59,345, 58,331, 61,323, 63,319, 64,313, 64,305, 63,300, 61,294, 61,288, 64,277, 66,265, 67,255, 68,246, 73,208">
					<area href="#" group="torso" class="block" title="torso" 	shape="poly" coords=" 43,128, 42,135, 42,142, 43,150, 41,155, 41,161, 44,166, 49,171, 53,178, 55,184, 56,190, 60,194, 64,198, 67,202, 72,204, 75,78, 75,56, 75,54, 73,56, 71,57, 66,57, 63,55, 59,51, 57,55, 52,59, 47,64, 39,70, 43,73, 47,76, 51,82, 52,86, 52,95, 52,102, 51,108, 50,116, 48,120, 45,126">
					
				</map>
				<map name="table2" id="map_hit">
					<area href="#" group='head' class="hit" title="head" shape="poly" coords=" 0,5, 0,4, 7,5, 13,8, 17,13, 19,19, 19,26, 18,32, 16,40, 15,46, 11,50, 9,52, 6,55, 3,55, 0,55, 0,8, 0,5">
					<area href="#" group='torso' class="hit" title="torso" shape="poly" coords=" 16,49, 16,53, 19,57, 23,60, 27,64, 33,68, 31,73, 27,76, 25,81, 23,86, 22,90, 22,94, 24,100, 26,106, 27,112, 30,117, 32,122, 34,127, 34,131, 33,138, 33,144, 33,149, 33,155, 34,159, 28,167, 24,171, 20,174, 19,182, 18,187, 16,190, 14,193, 10,196, 7,199, 5,201, 2,203, 0,203, 0,56, 5,56, 10,55, 13,51" >
					<area href="#" group='leg' class="hit" title="leg" shape="poly" coords=" 36,69, 38,71, 42,73, 47,76, 51,80, 55,84, 56,89, 56,99, 56,108, 56,116, 57,127, 59,133, 63,143, 63,151, 64,163, 64,174, 64,184, 63,195, 63,207, 61,215, 57,220, 52,226, 47,228, 44,224, 42,220, 44,218, 49,217, 52,213, 52,208, 51,206, 51,204, 49,207, 47,212, 43,213, 40,211, 44,204, 46,199, 48,193, 50,188, 50,185, 48,181, 44,172, 43,168, 42,162, 42,155, 40,144, 40,137, 39,132, 36,125, 35,123, 32,118, 30,111, 28,106, 26,100, 25,96, 25,91, 27,86, 29,81, 30,79, 33,77, 35,73">
					<area href="#" group='hand' class="hit" title="hand" shape="poly" coords=" 2,207, 3,225, 7,240, 8,255, 9,263, 12,274, 14,288, 12,299, 11,309, 12,319, 15,324, 17,334, 16,346, 16,354, 14,361, 14,369, 16,378, 24,381, 29,380, 35,379, 38,374, 37,370, 35,365, 31,359, 31,352, 31,347, 33,340, 36,330, 37,318, 39,307, 40,300, 38,292, 36,280, 33,276, 34,270, 36,255, 39,240, 40,228, 42,214, 41,204, 41,195, 39,189, 38,181, 37,174, 34,169, 33,168, 33,167, 28,173, 23,177, 22,182, 22,186, 21,189, 18,194, 15,198, 12,200, 9,203, 6,206, 3,208" >
				</map>
				<!-- 				<div id="user1Inventory"> -->
				<!-- 					<div id="user1Item1"></div> -->
				<!-- 					<div id="user1Item2"></div> -->
				<!-- 					<div id="user1Item3"></div> -->
				<!-- 				</div> -->

			</div>
		</c:if>
		<!-- 	+++++++++++++++++++++++++END RIGHT CREATOR+++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!-- 	+++++++++++++++++++++++++++++++++++++END_CREATOR+++++++++++++++++++++++++++++++++++++++++ -->
		<!--    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!--    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!--    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!--    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!--    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<!--    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
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
					<div id="leftInventory">
						<div class="item">
							<img src="${game.user2profile.getDressedWeapon1().getItemPicture()}">
						</div>
						<div class="item">
							<img src="${game.user2profile.getDressedWeapon2().getItemPicture()}">
						</div>
						<div class="item">
							<img src="${game.user2profile.getDressedArmor().getItemPicture()}">
						</div>
						<div class="item">
							<img src="${game.user2profile.getDressedAid().getItemPicture()}">
						</div>
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
						<div class="item">
							<img src="${game.user1profile.getDressedWeapon1().getItemPicture()}">
						</div>
						<div class="item">
							<img src="${game.user1profile.getDressedWeapon2().getItemPicture()}">
						</div>
						<div class="item">
							<img src="${game.user1profile.getDressedArmor().getItemPicture()}">
						</div>
						<div class="item">
							<img src="${game.user1profile.getDressedAid().getItemPicture()}">
						</div>
					</div>
				</div>
				<div id="attackBlockDoll">
					<div id="doll"></div>
				</div>
				<!-- 				<div id="user2Inventory"> -->
				<!-- 					<div id="user2Item1"></div> -->
				<!-- 					<div id="user2Item2"></div> -->
				<!-- 					<div id="user2Item3"></div> -->
				<!-- 				</div> -->
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
			<div id="allMesseges"></div>
			<textarea id="myMessege"></textarea>
			<div id="chatSubmit">
				<input id="submit" type="button" name="submit" value="Ok">
			</div>
		</div>

	</div>
</body>
</html>