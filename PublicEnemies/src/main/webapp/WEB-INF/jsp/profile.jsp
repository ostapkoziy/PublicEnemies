<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/profile/profilestyle.css" rel="stylesheet"
	type="text/css">
<link href="css/popup.css" rel="stylesheet" type="text/css">

<title>${profile.getNickName()}'s Profile</title>

<script type="text/javascript" src="js/profile/raphael.js"></script>
<script type="text/javascript" src="js/profile/profilemanager.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/profile/pie.js"></script>
<script type="text/javascript" src="js/jquery.betterTooltip.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$('.tTip').betterTooltip({speed: 150, delay: 300});
});
</script>

</head>

<body>
	<div class="profile_header">
		<a href="userStartPage.html" ><span class="header_element">MAIN PAGE</span></a>
		<a href="newJoinGame.html" ><span class="header_element">FIGHT</span></a>
		<a href="casino.html" ><span class="header_element">CASINO</span></a>
		<a href="shop.html" ><span class="header_element">SHOP</span></a>
		<a href="editProfile.html" ><span class="header_element">EDIT PROFILE</span></a>
		<a href="logout.html" ><span class="header_element">LOGOUT</span></a>
	</div>
	<div class="profile_statistics_inventory">
		<div style="text-align: center">
			<div class="profile_info">
				<h3>Profile Info</h3>
				<img class="avatar" src="${profile.getAvatar()}" title="Avatar"
					alt="Your profile here" />
				<div class="statistics_list">
					<h3>Basic info:</h3>
					<p>
						<strong> Genger: </strong>
						<c:choose>
							<c:when test="${profile.isSex() == true}">
						male
					</c:when>
							<c:otherwise>
						female
					</c:otherwise>
						</c:choose>
					</p>
					<p>
						<strong> Email: </strong> ${profile.getEmail()}
					</p>
					<p>
						<strong> Money: </strong> ${profile.getMoney()}
					</p>
					<p>
						<strong> RegDate: </strong> ${profile.getRegDate()}
					</p>
					<p>
						<strong> Profession: </strong> ${profile.getProfession()}
					</p>
					<br />
					<h3>Basic stats:</h3>
					<p>
						<strong> Experience: </strong> ${profile.getExperience()}
					</p>
					<p>
						<strong> Strength: </strong> ${profile.getStrength()}
					</p>
					<p>
						<strong> Agility: </strong> ${profile.getAgility()}
					</p>
					<p>
						<strong> Intellect: </strong> ${profile.getIntellect()}
					</p>
					<br />
					<h3>Actual stats:</h3>
					<p>
						<strong> Strength: </strong> need to calculate
					</p>
					<p>
						<strong> Agility: </strong> need to calculate
					</p>
					<p>
						<strong> Intellect: </strong> need to calculate
					</p>

				</div>
			</div>

			<div class="vertical_space"></div>

			<!--  <div class="horizontal_space"></div> -->
			<div class="inventory">
				<h3>Inventory</h3>
				<div class="set_of_items">
					<h3>DRESSED:</h3>


					<div class="margin_div_vertical"></div>
					<div>
						<c:choose>
							<c:when test="${profile.getDressedWeapon1().getItemId() != 0}">
								<div class="mutual_item">
									<a
										onclick="undressWeapon1(${profile.getDressedWeapon1().getItemId()})">
										<img class="tTip"
										src="${profile.getDressedWeapon1().getItemPicture()}"
										title="<strong>NAME: </strong> ${profile.getDressedWeapon1().getItemName()} <br />
													<strong>TYPE: </strong> ${profile.getDressedWeapon1().isWeaponType()} <br />
													<strong>HIT POINTS: </strong> ${profile.getDressedWeapon1().getHitPoints()} <br />
													<strong>PRICE: </strong> ${profile.getDressedWeapon1().getItemPrice()} <br />
													<strong>SELL PRICE: </strong> ${profile.getDressedWeapon1().getItemPrice() * 0.6} <br />
													<strong>Description: </strong> TODO" />
									</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="mutual_item"></div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${profile.getDressedWeapon2().getItemId() != 0}">
								<div class="mutual_item">
									<a
										onclick="undressWeapon2(${profile.getDressedWeapon2().getItemId()})">
										<img class="tTip"
										src="${profile.getDressedWeapon2().getItemPicture()}"
										title="<strong>NAME: </strong> ${profile.getDressedWeapon2().getItemName()} <br />
													<strong>TYPE: </strong> ${profile.getDressedWeapon2().isWeaponType()} <br />
													<strong>HIT POINTS: </strong> ${profile.getDressedWeapon2().getHitPoints()} <br />
													<strong>PRICE: </strong> ${profile.getDressedWeapon2().getItemPrice()} <br />
													<strong>SELL PRICE: </strong> ${profile.getDressedWeapon2().getItemPrice() * 0.6} <br />
													<strong>Description: </strong> TODO" />
									</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="mutual_item"></div>
							</c:otherwise>
						</c:choose>
						<div class="margin_div_vertical"></div>
						<c:choose>
							<c:when test="${profile.getDressedArmor().getItemId() != 0}">
								<div class="item">
									<a
										onclick="undressArmor(${profile.getDressedArmor().getItemId()})">
										<img class="tTip"
										src="${profile.getDressedArmor().getItemPicture()}"
										title="<strong>NAME: </strong> ${profile.getDressedArmor().getItemName()} <br />
													<strong>PROTECTION: </strong> ${profile.getDressedArmor().getArmorProtection()} <br />
													<strong>PRICE: </strong> ${profile.getDressedArmor().getItemPrice()} <br />
													<strong>SELL PRICE: </strong> ${profile.getDressedArmor().getItemPrice() * 0.6} <br />
													<strong>Description: </strong> TODO" />
									</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="item"></div>
							</c:otherwise>
						</c:choose>
						<div class="margin_div_vertical"></div>
						<c:choose>
							<c:when test="${profile.getDressedAid().getItemId() != 0}">
								<div class="item">
									<a onclick="undressAid(${profile.getDressedAid().getItemId()})">
										<img class="tTip"
										src="${profile.getDressedAid().getItemPicture()}"
										title="<strong>NAME: </strong> ${profile.getDressedAid().getItemName()} <br />
													<strong>TYPE: </strong> ${profile.getDressedAid().getAidType()} <br />
													<strong>EFFECT: </strong> ${profile.getDressedAid().getAidEffect()} <br />
													<strong>PRICE: </strong> ${profile.getDressedAid().getItemPrice()} <br />
													<strong>Description: </strong> TODO" />
									</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="item"></div>
							</c:otherwise>
						</c:choose>
						<div class="margin_div_vertical"></div>
					</div>
				</div>

				<div class="vertical_space"></div>

				<div class="set_of_items">

					<h3>TRUNK:</h3>

					<div class="margin_div_vertical"></div>
					<!-- DISPLAYS ALL WEAPONS INTO TRUNK -->
					<!-- IF THERE IS WEAPONS INTO TRUNK -->
					<c:choose>

						<c:when test="${profile.getUndresedWeapons().size() != 0}">
							<c:set var="weaponsIntoTrunk"
								value="${profile.getListOfWeapons()}" />
							<c:forEach items="${weaponsIntoTrunk}" var="weaponIT">
								<c:if test="${!weaponIT.isWearing()}">

									<c:set var="countWIT" value="${countWIT + 1}" scope="page" />

									<div class="mutual_item">
										<a onclick="dressWeapon(${weaponIT.getItem().getItemId()})"
											id="trunk_weapon_id_${countWIT}|${weaponIT.getItem().getItemId()}">
											<img class="tTip"
											src="${weaponIT.getItem().getItemPicture()}"
											title="<strong>NAME: </strong> ${weaponIT.getItem().getItemName()} <br />
												<strong>TYPE: </strong> ${weaponIT.getItem().isWeaponType()} <br />
												<strong>HIT POINTS: </strong> ${weaponIT.getItem().getHitPoints()} <br />
												<strong>SELL PRICE: </strong> ${weaponIT.getItem().getItemPrice() * 0.6} <br />
												<strong>Description: </strong> TODO" />
										</a>
									</div>
									<!-- MAX - 3 ELEMETS  -->
									<c:if test="${(countWIT % 3) == 0 }">
										<div class="margin_div_vertical"></div>
									</c:if>
								</c:if>
							</c:forEach>
						</c:when>

						<c:otherwise>
							<div class="item"></div>
						</c:otherwise>
					</c:choose>
					<div class="margin_div_vertical"></div>


					<!-- END OF "DISPLAYS ALL WEAPONS INTO TRUNK" -->
					<!-- <div class="horizontal_space"> </div>  -->

					<!-- DISPLAYS ALL ARMORS INTO TRUNK -->

					<!-- <h2>${profile.getUndressedArmors().size()}</h2> -->
					<c:choose>
						<c:when test="${profile.getUndressedArmors().size() != 0}">
							<c:set var="armorsIntoTrunk" value="${profile.getListOfArmors()}" />

							<c:forEach items="${armorsIntoTrunk}" var="armorIT">
								<c:if test="${!armorIT.isWearing()}">

									<c:set var="countArIT" value="${countArIT + 1}" scope="page" />

									<div class="mutual_item">

										<a onclick="dressArmor(${armorIT.getItem().getItemId()})"
											id="rarmor_id_${countArIT}|${armorIT.getItem().getItemId()}">
											<img class="tTip" src="${armorIT.getItem().getItemPicture()}"
											title="<strong>NAME: </strong> ${armorIT.getItem().getItemName()} <br />
												<strong>PROTECTION: </strong> ${armorIT.getItem().getArmorProtection()} <br />
												<strong>SELL PRICE: </strong>${armorIT.getItem().getItemPrice() * 0.6} <br />
												<strong>Description: </strong> TODO" />
										</a>
									</div>
									<c:if test="${(countArIT % 3) == 0 }">
										<div class="margin_div_vertical"></div>
									</c:if>
								</c:if>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="item"></div>
						</c:otherwise>
					</c:choose>
					<div class="margin_div_vertical"></div>

					<!-- DISPLAYS ALL AIDS INTO TRUNK -->

					<c:choose>
						<c:when test="${profile.getUndressedAids().size() != 0}">
							<c:set var="aidsIntoTrunk" value="${profile.getListOfAids()}" />

							<c:forEach items="${aidsIntoTrunk}" var="aidIT">
								<c:if test="${!aidIT.isWearing()}">
									<c:set var="countAidsIT" value="${countAidsIT + 1}"
										scope="page" />
									<div class="mutual_item">

										<a onclick="dressAid(${aidIT.getItem().getItemId()})"
											id="raid_id_${countAidsIT}|${aidIT.getItem().getItemId()}">
											<img class="tTip" src="${aidIT.getItem().getItemPicture()}"
											title="<strong>NAME: </strong> ${aidIT.getItem().getItemName()} <br />
												<strong>TYPE: </strong> ${aidIT.getItem().getAidType()} <br />
												<strong>EFFECT: </strong> ${aidIT.getItem().getAidEffect()} <br />
												<strong>SELL PRICE: </strong>${aidIT.getItem().getItemPrice() * 0.6} <br />
												<strong>Description: </strong> TODO" />
										</a>
									</div>
									<c:if test="${(countAidsIT % 3) == 0 }">
										<div class="margin_div_vertical"></div>
									</c:if>
								</c:if>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="item"></div>
						</c:otherwise>
					</c:choose>
					<div class="margin_div_vertical"></div>

				</div>
				<!-- END OF "USER'S TRUNK" -->
				<!-- DISPLAYS WHAT USER WEARED IN -->

			</div>
		</div>

		<form action="" method="post" name="changeForm"></form>
		<div class="horizontal_space "></div>

		<div class="statistics">
			<h3>Statistics</h3>
			<br />
			<p>
				<strong> Total Fights: </strong> ${profile.getFightsTotal()}
			</p>
			<p>
				<strong> Won Fights: </strong> ${profile.getFightsWon()}
			</p>
			<div id="holder"></div>
			<table>
				<tbody>
					<tr>
						<th scope="row">Won (${profile.getFightsWon()})</th>
						<td>${profile.getFightsWon()}</td>
					</tr>
					<tr>
						<th scope="row">Loose (${profile.getFightsTotal() -
							profile.getFightsWon()})</th>
						<td>${profile.getFightsTotal() - profile.getFightsWon()}</td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>

</body>
</html>