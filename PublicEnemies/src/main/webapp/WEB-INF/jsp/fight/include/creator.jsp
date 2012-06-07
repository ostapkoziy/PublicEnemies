<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 	+++++++++++++++LEFT CREATOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
<div id="leftRightWrapper">
	<div id="left">
		<div id="leftName">
			<div id="leftLvl">LVL: ${game.creatorProfile.getLevel().getCurrentLevel()}</div>
			<div id="leftNickName">${game.creatorProfile.getNickName()}</div>
		</div>
		<div id="leftHP">
			<div id="leftProgressHP">
				<div id="innerLeftProgressHP" class="green"></div>
				<div id="leftHPPercent">${game.creatorProfile.getHP()}/${game.creatorProfile.getAllHP()}</div>
			</div>
		</div>
		<div id="leftStats">
			<div id="leftStatsWrapper">
				<div id="leftStrength">
					<img src="img/stats/strength.png">
					${game.creatorProfile.getStrength()}
				</div>
				<div id="leftAgility">
					<img src="img/stats/agility.png">
					${game.creatorProfile.getAgility()}
				</div>
				<div id="leftInteligence">
					<img src="img/stats/inteligence.png">
					${game.creatorProfile.getIntellect()}
				</div>
			</div>
		</div>
		<div id="leftAvatar">
			<img alt="avatar" src="${game.creatorProfile.getCharacterProfession().getProfessionAvatar()}">
		</div>
		<div id="leftInventory">
			<div class="item">
				<img src="${game.creatorProfile.getDressedWeapon1().getItemPicture()}" alt="">
			</div>
			<div class="item">
				<img src="${game.creatorProfile.getDressedWeapon2().getItemPicture()}" alt="">
			</div>
			<div class="item">
				<img src="${game.creatorProfile.getDressedArmor().getItemPicture()}" alt="">
			</div>
			<div id="leftAid" class="item">
				<img src="${game.creatorProfile.getDressedAid().getItemPicture()}" alt="">
			</div>
		</div>
		<!-- ***************************EXPIRIENCE****************************************** -->
		<div id="expAndSkillsWrapper">
			<div id="damage">DAMAGE: ${game.creatorProfile.getDamage()}</div>
			<div id="defence">DEFENCE: ${game.creatorProfile.getDefence()}%</div>
			<div id="dodge">DODGE: ${game.creatorProfile.getMissRate()}%</div>
			<div id="expWrapper">
				<div id="fullExp">
					<div id="innerExp" style="width: ${game.creatorProfile.getLevel().getNextLevelInPercent()}%;"></div>
					<div id="expPercent">${game.creatorProfile.getLevel().getNextLevelInPercent()}%</div>
				</div>
			</div>
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
				waitingNewRound();
			</script>
			<div id="right">
				<div id="rightName">
					<div id="rightLvl">LVL: ${game.connectorProfile.getLevel().getCurrentLevel()}</div>
					<div id="rightNickName">${game.connectorProfile.getNickName()}</div>
				</div>
				<div id="rightHP">
					<div id="rightProgressHP">
						<div id="innerRightProgressHP" class="green"></div>
						<div id="rightHPPercent">${game.connectorProfile.getHP()}/${game.connectorProfile.getAllHP()}</div>
					</div>
				</div>
				<div id="rightStats">
					<div id="rightStatsWrapper">
						<div id="rightStrength">
							${game.connectorProfile.getStrength()}
							<img src="img/stats/strength.png">
						</div>
						<div id="rightAgility">
							${game.connectorProfile.getAgility()}
							<img src="img/stats/agility.png">
						</div>
						<div id="rightInteligence">
							${game.connectorProfile.getIntellect()}
							<img src="img/stats/inteligence.png">
						</div>
					</div>
				</div>
				<div id="rightAvatar">
					<img alt="avatar" src="${game.connectorProfile.getCharacterProfession().getProfessionAvatar()}">
				</div>
				<div id="rightInventory">
					<div class="item">
						<img src="${game.connectorProfile.getDressedWeapon1().getItemPicture()}" alt="">
					</div>
					<div class="item">
						<img src="${game.connectorProfile.getDressedWeapon2().getItemPicture()}" alt="">
					</div>
					<div class="item">
						<img src="${game.connectorProfile.getDressedArmor().getItemPicture()}" alt="">
					</div>
					<div class="item" id="rightAid">
						<img src="${game.connectorProfile.getDressedAid().getItemPicture()}" alt="">
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	<!-- 	+++++++++++++++END RIGHT CREATOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</div>