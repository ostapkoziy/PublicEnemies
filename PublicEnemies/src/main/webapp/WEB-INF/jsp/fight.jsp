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
					<area href="#" group="head" title="head" 	shape="poly" coords=" 74,4, 70,5, 66,7, 61,10, 57,15, 55,22, 55,30, 56,37, 57,43, 59,48, 62,52, 66,55, 71,55, 74,54, 74,8">
					<area href="#" group="hand" title="hand" 	shape="poly"  coords=" 39,125, 35,135, 35,141, 35,152, 34,161, 32,168, 30,174, 26,182, 24,187, 24,191, 26,195, 29,201, 30,208, 31,214, 28,214, 25,211, 24,208, 24,205, 22,212, 25,217, 28,219, 31,223, 29,227, 27,228, 25,228, 22,226, 16,222, 14,217, 13,212, 11,204, 9,178, 10,172, 11,158, 12,149, 13,139, 17,134, 19,111, 19,104, 19,97, 18,86, 21,82, 27,77, 32,74, 36,72, 42,75, 46,78, 49,88, 49,102, 48,109, 47,115, 43,123, 41,124">
					<area href="#" group="leg" title="leg" 		shape="poly" coords=" 42,167, 38,175, 36,185, 34,193, 34,201, 34,208, 33,219, 33,229, 34,238, 37,249, 38,259, 40,268, 41,277, 40,282, 36,288, 35,303, 35,312, 36,324, 39,334, 41,344, 44,352, 43,360, 41,367, 35,375, 36,380, 40,382, 44,383, 49,383, 57,381, 58,376, 58,372, 60,368, 60,364, 60,360, 59,358, 58,353, 59,345, 58,331, 61,323, 63,319, 64,313, 64,305, 63,300, 61,294, 61,288, 64,277, 66,265, 67,255, 68,246, 73,208">
					<area href="#" group="torso" title="torso" 	shape="poly" coords=" 43,128, 42,135, 42,142, 43,150, 41,155, 41,161, 44,166, 49,171, 53,178, 55,184, 56,190, 60,194, 64,198, 67,202, 72,204, 75,78, 75,56, 75,54, 73,56, 71,57, 66,57, 63,55, 59,51, 57,55, 52,59, 47,64, 39,70, 43,73, 47,76, 51,82, 52,86, 52,95, 52,102, 51,108, 50,116, 48,120, 45,126">
					
				</map>
				<map name="table2" id="map_hit">
					<area href="#" group='head' title="head" shape="poly" coords=" 0,56, 4,54, 7,52, 10,47, 12,44, 14,36, 15,30, 14,25, 13,18, 11,14, 9,11, 5,9, 2,8, 0,7, 0,55">
					<area href="#" group='torso' title="torso" shape="poly" coords=" 31,169, 27,172, 25,173, 21,177, 18,181, 14,186, 11,193, 5,199, 0,203, 0,57, 4,56, 8,52, 10,49, 11,47, 12,53, 15,56, 20,60, 25,66, 30,70, 25,76, 23,78, 20,85, 18,90, 18,97, 20,104, 22,110, 25,117, 28,122, 30,130, 29,143, 28,152, 30,159, 30,165, 32,168" >
					<area href="#" group='hand' title="hand" shape="poly" coords=" 45,228, 43,224, 42,221, 44,219, 47,217, 50,214, 51,210, 49,207, 47,204, 47,208, 46,211, 43,213, 42,213, 41,207, 42,203, 43,199, 45,194, 46,190, 48,188, 47,185, 43,178, 40,170, 39,165, 38,156, 38,150, 38,142, 38,136, 33,125, 31,122, 29,120, 27,115, 25,111, 23,105, 21,99, 21,93, 21,91, 23,86, 26,81, 28,78, 31,75, 34,72, 38,73, 45,77, 49,83, 53,89, 53,97, 52,100, 52,106, 53,120, 54,130, 55,135, 59,141, 60,152, 61,167, 61,179, 59,199, 59,209, 57,218, 55,223, 47,227">
					<area href="#" group='leg' title="leg" shape="poly" coords=" 0,206, 5,200, 10,196, 13,191, 16,184, 20,179, 25,174, 30,171, 36,187, 38,197, 38,205, 39,215, 37,230, 35,242, 33,254, 32,264, 30,278, 31,283, 36,303, 34,321, 32,331, 29,344, 28,351, 27,359, 28,367, 31,372, 35,377, 33,380, 30,382, 22,383, 17,382, 16,381, 14,376, 14,369, 12,364, 12,359, 13,355, 14,343, 13,331, 11,322, 9,316, 9,311, 9,303, 10,298, 11,293, 11,290, 7,273, 6,262, 6,252, 6,245, 1,233, 1,223, 0,209" >
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