<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 	+++++++++++++++LEFT CREATOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

<%-- ${game.getProfile("${gameRole}").getDressedWeapon1().getItemPicture()} --%>
<div id="leftRightWrapper">
	<div id="left">
		<div id="leftHP">
			<div id="leftHPWrapper">
				<img alt="HP" src="img/hp.png">
				<span id="U1HP">${game.creatorProfile.getHP()}</span>
			</div>
			<div id="leftProgressHP">
				<div id="innerLeftProgressHP" class="green" style="text-align: center;"></div>
			</div>
		</div>
		<div id="leftStats">
			<div id="leftStatsWrapper">
				<div id="leftAgility">
					<img src="img/stats/agility.png">
					${game.creatorProfile.getAgility()}
				</div>
				<div id="leftStrength">
					<img src="img/stats/strength.png">
					${game.creatorProfile.getStrength()}
				</div>
				<div id="leftInteligence">
					<img src="img/stats/inteligence.png">
					${game.creatorProfile.getIntellect()}
				</div>
			</div>
		</div>
		<div id="leftAvatar">
			<img alt="avatar" src="img/fight/3.jpg" width="200">
			<%-- 			<img alt="avatar" src="${game.creatorProfile.getCharacterProfession().getProfessionAvatar()}" width="200"> --%>
		</div>
		<div id="leftInventory">
			<div class="item">
				<img src="${game.creatorProfile.getDressedWeapon1().getItemPicture()}">
			</div>
			<div class="item">
				<img src="${game.creatorProfile.getDressedWeapon2().getItemPicture()}">
			</div>
			<div class="item">
				<img src="${game.creatorProfile.getDressedArmor().getItemPicture()}">
			</div>
			<div id="leftAid" class="item">
				<img src="${game.creatorProfile.getDressedAid().getItemPicture()}">
			</div>
		</div>
		<div id="expAndSkillsWrapper">
			<div id="exp">
				<div id="innerExp" style="width: ${game.creatorProfile.getLevel().getNextLevelInPercent()}%;"></div>
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
			<script type="text/javascript">
				$(function()
				{
					$("#atackButton").hide();
				});
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
				<div id="rightHP">
					<div id="rightHPWrapper">
						<span id="U2HP">${game.connectorProfile.getHP()}</span>
						<img alt="HP" src="img/hp.png">
					</div>
					<div id="rightProgressHP">
						<div id="innerRightProgressHP" class="green"></div>
					</div>
				</div>
				<div id="rightStats">
					<div id="rightStatsWrapper">
						<div id="rightAgility">
							${game.connectorProfile.getAgility()}
							<img src="img/stats/agility.png">
						</div>
						<div id="rightStrength">
							${game.connectorProfile.getStrength()}
							<img src="img/stats/strength.png">
						</div>
						<div id="rightInteligence">
							${game.connectorProfile.getIntellect()}
							<img src="img/stats/inteligence.png">
						</div>
					</div>
				</div>
				<div id="rightAvatar">
					<img alt="avatar" src="img/fight/4.jpg" width="200">
				</div>
				<div id="rightInventory">
					<div class="item">
						<img src="${game.connectorProfile.getDressedWeapon1().getItemPicture()}">
					</div>
					<div class="item">
						<img src="${game.connectorProfile.getDressedWeapon2().getItemPicture()}">
					</div>
					<div class="item">
						<img src="${game.connectorProfile.getDressedArmor().getItemPicture()}">
					</div>
					<div class="item">
						<img src="${game.connectorProfile.getDressedAid().getItemPicture()}">
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	<!-- 	+++++++++++++++END RIGHT CREATOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</div>