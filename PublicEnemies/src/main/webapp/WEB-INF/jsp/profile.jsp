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

<title>${profile.getNickName()}'s profile</title>

<script type="text/javascript" src="js/profile/raphael.js"></script>
<script type="text/javascript" src="js/profile/profilemanager.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/profile/pie.js"></script>
<script type="text/javascript" src="js/jquery.betterTooltip.js"></script>
<link rel="stylesheet" href="css/hideout.css" type="text/css">
<script type="text/javascript">
$(document).ready(function(){
	$('img.tTip').betterTooltip({speed: 150, delay: 300});
	
});
</script>

</head>

<body>
<div style="float: left; margin-left: 150px; border-radius: 10px; margin-top: 50px; padding: 5px 15px; background: url(/PublicEnemies/img/dark_opacity.png);">
		<a class="main_and_profile" href="/PublicEnemies/fights.html">FIGHT</a>
	</div>
	<div style="float: right; margin-top: 50px; margin-right: 150px; padding: 5px 15px; background: url(/PublicEnemies/img/dark_opacity.png); border-radius: 10px;">
		<a class="main_and_profile" href="/PublicEnemies/casino.html"> CASINO </a>
	</div>
	
	<div style="text-align: center; margin: 10px;">
		<a href="/PublicEnemies/userStartPage.html"><img
			src="/PublicEnemies/img/gamelogo.png" width="50%" height="50%" /></a>
	</div>
	<div class="profile_statistics_inventory">
		<div class="centered_psi">
			<div class="profile_info">
				<h2 class="inventory_and_pi">
					${profile.getNickName()}'S PROFILE [ <a class="edit_and_buy"
						href="/PublicEnemies/editProfile.html">EDIT</a> ]
				</h2>
				<div>
					<img class="avatar" src="${profile.getCharacterProfession().getProfessionAvatar()}" title="Avatar"
						alt="Your profile here" border="2" />
					<div class="statistics_list" style="padding-left: 30px; padding-right: 30px; "align="left">
						<h3>Basic info:</h3>
						<p>
							<strong> <abbr>NickName:</abbr>
							</strong> ${profile.getNickName()}
						</p>
						<p>
							<strong> <abbr>Genger:</abbr>
							</strong>
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
							<strong> <abbr>Email:</abbr>
							</strong> ${profile.getEmail()}
						</p>
						<p>
							<strong> <abbr>Money:</abbr>
							</strong> ${profile.getMoney()}
						</p>
						<!-- <p>
							<strong> <abbr>RegDate:</abbr>
							</strong> ${profile.getRegDate()}
						</p>  -->
						<p>
							<strong> <abbr>Profession:</abbr>
							</strong> ${profile.getCharacterProfession().getProfessionName()}
						</p>
						<br />
						<h3>Basic stats:</h3>
						<p>
							<strong> <abbr>Experience:</abbr>
							</strong> ${profile.getExperience()}
						</p>
						<p>
							<strong> <abbr>Strength:</abbr>
							</strong> ${profile.getStrength()}
						</p>
						<p>
							<strong> <abbr>Agility:</abbr>
							</strong> ${profile.getAgility()}
						</p>
						<p>
							<strong> <abbr>Intelligence:</abbr>
							</strong> ${profile.getIntellect()}
						</p>
						<br />
						<h3>Actual stats:</h3>
						<p>
							<strong> <abbr>HP:</abbr>
							</strong> ${profile.getAllHP()}
						</p>
						<p>
							<strong> <abbr>Damage:</abbr>
							</strong> ${profile.getDamage()}
						</p>
						<p>
							<strong> <abbr>Defence:</abbr>
							</strong> ${profile.getDefence()}
						</p>

					</div>

				</div>
			</div>

			<div class="vertical_space"></div>

			<div class="inventory">
				<h2 class="inventory_and_pi">
					INVENTORY [ <a class="edit_and_buy" href="/PublicEnemies/shop.html">BUY</a>
					]
				</h2>
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
													<strong>HIT POINTS: </strong> ${profile.getDressedWeapon1().getHitPoints()} <br />													
													<strong>Description: </strong>  ${profile.getDressedWeapon1().getItemDescription()}" />
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
													<strong>HIT POINTS: </strong> ${profile.getDressedWeapon2().getHitPoints()} <br />
													<strong>Description: </strong> ${profile.getDressedWeapon2().getItemDescription()}" />
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
								<div class="mutual_item">
									<a
										onclick="undressArmor(${profile.getDressedArmor().getItemId()})">
										<img class="tTip"
										src="${profile.getDressedArmor().getItemPicture()}"
										title="<strong>NAME: </strong> ${profile.getDressedArmor().getItemName()} <br />
													<strong>PROTECTION: </strong> ${profile.getDressedArmor().getArmorProtection()} <br />
													<strong>Description: </strong> ${profile.getDressedArmor().getItemDescription()}" />
									</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="mutual_item"></div>
							</c:otherwise>
						</c:choose>

						<div style="height: 10px;"></div>

						<c:choose>
							<c:when test="${profile.getDressedAid().getItemId() != 0}">
								<div class="mutual_item">
									<a onclick="undressAid(${profile.getDressedAid().getItemId()})">
										<img class="tTip"
										src="${profile.getDressedAid().getItemPicture()}"
										title="<strong>NAME: </strong> ${profile.getDressedAid().getItemName()} <br />
													<strong>EFFECT: </strong> ${profile.getDressedAid().getAidEffect()} <br />
													<strong>DESCRIPTION: </strong> ${profile.getDressedAid().getItemDescription()}" />
									</a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="mutual_item"></div>
							</c:otherwise>
						</c:choose>
						<div class="margin_div_vertical"></div>
					</div>
				</div>

				<div class="vertical_space"></div>

				<div class="set_of_items">

					<h3 id="T">AVAILABLE:</h3>

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
												<strong>HIT POINTS: </strong> ${weaponIT.getItem().getHitPoints()} <br />
												<strong>ORIGIN PRICE: </strong> ${weaponIT.getItem().getItemPrice() * 1.0} <br />
												<strong>SELL PRICE: </strong> ${weaponIT.getItem().getItemPrice() * 0.6} <br />
												<strong>Description: </strong> ${weaponIT.getItem().getItemDescription()}" />
										</a>
									</div>
									<!-- MAX - 3 ELEMETS  -->
									<c:if test="${(countWIT % 3) == 0 }">
										<div></div>
									</c:if>
								</c:if>
							</c:forEach>
						</c:when>

						<c:otherwise>
							<div class="item"></div>
						</c:otherwise>
					</c:choose>
					<div class="margin_div_vertical"></div>


					<!-- END OF DISPLAYS ALL WEAPONS INTO TRUNK -->
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
												<strong>ORIGIN PRICE: </strong>${armorIT.getItem().getItemPrice() * 1.0} <br />
												<strong>SELL PRICE: </strong>${armorIT.getItem().getItemPrice() * 0.6} <br />
												<strong>Description: </strong> ${armorIT.getItem().getItemDescription()}" />
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
												<strong>EFFECT: </strong> ${aidIT.getItem().getAidEffect()} <br />
												<strong>ORIGIN PRICE: </strong>${aidIT.getItem().getItemPrice() * 1.0} <br />
												<strong>SELL PRICE: </strong>${aidIT.getItem().getItemPrice() * 0.6} <br />
												<strong>Description: </strong> ${aidIT.getItem().getItemDescription()}" />
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
				<!-- END OF USER'S TRUNK -->
				<!-- DISPLAYS WHAT USER WEARED IN -->
			</div>
		</div>

		<form action="" method="post" name="changeForm"></form>
		<div class="horizontal_space "></div>

		<div class="statistics" align="center">

			<div class="ranking_by_exp">
				Ranking by Experience (top 10)
				<c:choose>
					<c:when test="${usersListSortedByExp.size() == 0 }">
						<h4>There is no user</h4>
					</c:when>
					<c:otherwise>
						<c:forEach items="${usersListSortedByExp}" var="user">
							<div
								style="padding-top: 10px; padding-left: 25px; color: white; font-size: 12pt; text-align: left; font-family: Arial;">
								<span style="display: inline-block; width: 160px;">${user.get("nickname")}</span>
								<span>${user.get("value")}</span>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>

			<div class="ranking_by_money">
				Ranking by Money (top 10)

				<c:choose>
					<c:when test="${usersListSortedByMoney.size() == 0 }">
						<h4>There is no user</h4>
					</c:when>
					<c:otherwise>
						<c:forEach items="${usersListSortedByMoney}" var="userM">
							<div
								style="padding-top: 10px; padding-left: 25px; color: white; font-size: 12pt; text-align: left; font-family: Arial;">
								<span style="display: inline-block; width: 160px;">${userM.get("nickname")}</span>
								<span>${userM.get("value")}</span>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>

			<h2>
				<a name="statistics_place" class="statistics_link">STATISTICS</a>
			</h2>
			<br />
			<p>
				<strong> <abbr style="color: white">Total Fights:</abbr>
				</strong> ${profile.getFightsTotal()}
			</p>
			<p>
				<strong> <abbr style="color: white">Won Fights:</abbr>
				</strong> ${profile.getFightsWon()}
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
			<h3>
				<a id="main_page" style="color: white;" href="userStartPage.html">HOME
					PAGE</a>
			</h3>
		</div>
	</div>

</body>
</html>