<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="leftRightWrapper">
	<script type="text/javascript">
		waitingNewRound();
	</script>
	<div id="left">
		<div id="leftHP">
			<div id="leftHPWrapper">
				<img alt="HP" src="img/hp.png">
				<span id="U2HP">${game.connectorProfile.getHP()}</span>
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
					${game.connectorProfile.getAgility()}
				</div>
				<div id="leftStrength">
					<img src="img/stats/strength.png">
					${game.connectorProfile.getStrength()}
				</div>
				<div id="leftInteligence">
					<img src="img/stats/inteligence.png">
					${game.connectorProfile.getIntellect()}
				</div>
				<div id="leftDamage">
					<img src="img/stats/inteligence.png">
					${game.connectorProfile.getDamage()}
				</div>
			</div>
		</div>
		<div id="leftAvatar">
			<img alt="avatar" src="img/fight/4.jpg" width="200">
		</div>
		<div id="leftInventory">
			<div class="item">
				<img src="${game.connectorProfile.getDressedWeapon1().getItemPicture()}">
			</div>
			<div class="item">
				<img src="${game.connectorProfile.getDressedWeapon2().getItemPicture()}">
			</div>
			<div class="item">
				<img src="${game.connectorProfile.getDressedArmor().getItemPicture()}">
			</div>
			<div id="leftAid" class="item">
				<img src="${game.connectorProfile.getDressedAid().getItemPicture()}">
			</div>
		</div>
	</div>
	<!-- 	++++++++++++++++++++++++END LEFT CONNECTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<!-- 	++++++++++++++++++++++RIGHTT CONNECTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	<div id="right">
		<div id="rightHP">
			<div id="rightHPWrapper">
				<span id="U1HP">${game.creatorProfile.getHP()}</span>
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
					${game.creatorProfile.getAgility()}
					<img src="img/stats/agility.png">
				</div>
				<div id="rightStrength">
					${game.creatorProfile.getStrength()}
					<img src="img/stats/strength.png">
				</div>
				<div id="rightInteligence">
					${game.creatorProfile.getIntellect()}
					<img src="img/stats/inteligence.png">
				</div>
				<div id="rightDamage">
					${game.creatorProfile.getDamage()}
					<img src="img/stats/inteligence.png">
				</div>
			</div>
		</div>
		<div id="rightAvatar">
			<img alt="avatar" src="img/fight/3.jpg" width="200">
		</div>
		<div id="rightInventory">
			<div class="item">
				<img src="${game.creatorProfile.getDressedWeapon1().getItemPicture()}">
			</div>
			<div class="item">
				<img src="${game.creatorProfile.getDressedWeapon2().getItemPicture()}">
			</div>
			<div class="item">
				<img src="${game.creatorProfile.getDressedArmor().getItemPicture()}">
			</div>
			<div class="item">
				<img src="${game.creatorProfile.getDressedAid().getItemPicture()}">
			</div>
		</div>
	</div>
</div>