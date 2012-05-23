<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- For internal items -->
<link href="css/shop/shopstyle.css" rel="stylesheet" type="text/css">
<!-- For popup mini-windows -->
<link href="css/popup.css" rel="stylesheet" type="text/css">

<!-- ------------------------------ TITLE HERE ------------------------------  -->
<title>Shop</title>
<!-- ------------------------------ END OF "TITLE HERE" ------------------------------  -->

<!-- For internal service (buy, sell, dobuy etc.) -->
<script type="text/javascript" src="js/shop/shopmanager.js"></script>
<!-- For external (popup) -->
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.betterTooltip.js"></script>

<!-- For popup. Binds class and action -->
<script type="text/javascript">
		$(document).ready(function(){
			$('.tTip').betterTooltip({speed: 150, delay: 300});
		});
function showNoMoney() {
	alert('To get money, send appropriate amount of money for 09675787** phone number and send SMS to this number with your nickname. 1grn = $100. Min sum = 5grn');
}

</script>

</head>

<body>
	<!-- HEADER (TODO: need to refactor) -->
	<div class="shop_header">
		<div id="main_page">
			<a href="userStartPage.html">MAIN PAGE </a>
		</div>
		<img src="./img/dollar_sign.png"> <span id="money">${money}</span>
		<div class="left_header_items">
			<a href="logout.html">LOGOUT</a> <br />
		</div>
		<div class="left_header_items">
			<a href="editProfile.html"> <img src="${profile.getAvatar()}"
				title="${profile.getNickName()}'s profile" border="0" width="40px"></img>
			</a>
		</div>
	</div>

	<!-- ------------------------------ CONTENT AREA ------------------------------ -->
	<div id="center_div">
		<!-- COUNTERS -->
		<c:set var="countAidsIT" value="0" scope="page" />
		<c:set var="countWIT" value="0" scope="page" />
		<c:set var="countArIT" value="0" scope="page" />
		<c:set var="countAids" value="0" scope="page" />
		<c:set var="countW" value="0" scope="page" />
		<c:set var="countAr" value="0" scope="page" />

		<!-- TABLE FOR 3 DIVS (WHAT USER HAVE, USER'S CART AND WHAT USER CAN BUY -->
		<table width="100%">
			<tr valign="top">
				<!-- DISPLAYS WHAT USER HAVE -->
				<td>
					<!-- USER'S TRUNK -->
					<div id="user_div">
						<div>
							<div>INTO TRUNK:</div>
							<div class="margin_div_vertical"></div>
							<div>
								<span class="weapon_name"> WEAPONS </span>
							</div>
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
												<a
													onclick="sell(this.id, ${weaponIT.getItem().getItemPrice() * 0.6})"
													id="rweapon_id_${countWIT}|${weaponIT.getItem().getItemId()}"
													info="${weaponIT.getItem().getItemName()}"> <img
													class="tTip" src="${weaponIT.getItem().getItemPicture()}"
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
						</div>
						<!-- END OF "DISPLAYS ALL WEAPONS INTO TRUNK" -->
						<div class="magrin_div_vertical"></div>
						<!-- DISPLAYS ALL ARMORS INTO TRUNK -->
						<div>
							<div class="margin_div_vertical"></div>
							<div>
								<span class="armor_name"> ARMORS </span>
							</div>
							<div class="margin_div_vertical"></div>

							<!-- <h2>${profile.getUndressedArmors().size()}</h2> -->
							<c:choose>
								<c:when test="${profile.getUndressedArmors().size() != 0}">
									<c:set var="armorsIntoTrunk"
										value="${profile.getListOfArmors()}" />

									<c:forEach items="${armorsIntoTrunk}" var="armorIT">
										<c:if test="${!armorIT.isWearing()}">

											<c:set var="countArIT" value="${countArIT + 1}" scope="page" />

											<div class="mutual_item">

												<a
													onclick="sell(this.id, ${armorIT.getItem().getItemPrice() * 0.6})"
													id="rarmor_id_${countArIT}|${armorIT.getItem().getItemId()}"
													info="${armorIT.getItem().getItemName()}"> <img
													class="tTip" src="${armorIT.getItem().getItemPicture()}"
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
						</div>
						<!-- DISPLAYS ALL AIDS INTO TRUNK -->
						<div>
							<div>
								<span class="aid_name"> AIDS </span>
							</div>
							<div class="margin_div_vertical"></div>
							<c:choose>
								<c:when test="${profile.getUndressedAids().size() != 0}">
									<c:set var="aidsIntoTrunk" value="${profile.getListOfAids()}" />

									<c:forEach items="${aidsIntoTrunk}" var="aidIT">
										<c:if test="${!aidIT.isWearing()}">
											<c:set var="countAidsIT" value="${countAidsIT + 1}"
												scope="page" />
											<div class="mutual_item">


												<a
													onclick="sell(this.id, ${aidIT.getItem().getItemPrice() * 0.6})"
													id="raid_id_${countAidsIT}|${aidIT.getItem().getItemId()}"
													info="${aidIT.getItem().getItemName()}"> <img
													class="tTip" src="${aidIT.getItem().getItemPicture()}"
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
					</div> <!-- END OF "USER'S TRUNK" --> <!-- DISPLAYS WHAT USER WEARED IN -->
					<div id="user_div">
						<h3>${profile.getNickName()}, YOU HAVE:</h3>
						<div>

							<c:choose>
								<c:when test="${profile.getDressedWeapon1().getItemId() != 0}">
									<div class="mutual_item">
										<img class="tTip"
											src="${profile.getDressedWeapon1().getItemPicture()}"
											title="<strong>NAME: </strong> ${profile.getDressedWeapon1().getItemName()} <br />
													<strong>TYPE: </strong> ${profile.getDressedWeapon1().isWeaponType()} <br />
													<strong>HIT POINTS: </strong> ${profile.getDressedWeapon1().getHitPoints()} <br />
													<strong>PRICE: </strong> ${profile.getDressedWeapon1().getItemPrice()} <br />
													<strong>SELL PRICE: </strong> ${profile.getDressedWeapon1().getItemPrice() * 0.6} <br />
													<strong>Description: </strong> TODO" />
									</div>
								</c:when>
								<c:otherwise>
									<div class="mutual_item"></div>
								</c:otherwise>
							</c:choose>
							<!--  <div class="margin_div_vertical"></div>-->
							<c:choose>
								<c:when test="${profile.getDressedWeapon2().getItemId() != 0}">
									<div class="mutual_item">
										<img class="tTip"
											src="${profile.getDressedWeapon2().getItemPicture()}"
											title="<strong>NAME: </strong> ${profile.getDressedWeapon2().getItemName()} <br />
													<strong>TYPE: </strong> ${profile.getDressedWeapon2().isWeaponType()} <br />
													<strong>HIT POINTS: </strong> ${profile.getDressedWeapon2().getHitPoints()} <br />
													<strong>PRICE: </strong> ${profile.getDressedWeapon2().getItemPrice()} <br />
													<strong>SELL PRICE: </strong> ${profile.getDressedWeapon2().getItemPrice() * 0.6} <br />
													<strong>Description: </strong> TODO" />
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
										<img class="tTip"
											src="${profile.getDressedArmor().getItemPicture()}"
											title="<strong>NAME: </strong> ${profile.getDressedArmor().getItemName()} <br />
													<strong>PROTECTION: </strong> ${profile.getDressedArmor().getArmorProtection()} <br />
													<strong>PRICE: </strong> ${profile.getDressedArmor().getItemPrice()} <br />
													<strong>SELL PRICE: </strong> ${profile.getDressedArmor().getItemPrice() * 0.6} <br />
													<strong>Description: </strong> TODO" />
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
										<img class="tTip"
											src="${profile.getDressedAid().getItemPicture()}"
											title="<strong>NAME: </strong> ${profile.getDressedAid().getItemName()} <br />
													<strong>TYPE: </strong> ${profile.getDressedAid().getAidType()} <br />
													<strong>EFFECT: </strong> ${profile.getDressedAid().getAidEffect()} <br />
													<strong>PRICE: </strong> ${profile.getDressedAid().getItemPrice()} <br />
													<strong>Description: </strong> TODO" />
									</div>
								</c:when>
								<c:otherwise>
									<div class="item"></div>
								</c:otherwise>
							</c:choose>
						</div>
					</div> <!-- END OF "DISPLAYS WHAT USER WEARED IN" -->
				</td>
				<!-- END OF "DISPLAYS WHAT USER HAVE" -->
				<td>
					<!-- USER'S CART -->
					<div id="basket_div">
						<div id="balance_inscription">BALANCE AFTER APPROVING:</div>
						<div id="balance_after">
							<span id="money_value">$ ${profile.getMoney()}</span>
						</div>
						<div id="cart_inscription">CART:</div>
						<div id="cart_items">
							<div id="selected_items"></div>
						</div>
						<a onclick="doBuy()"><button class="button">APPROVE</button></a>

						<form action="" method="post" name="dobuy"></form>


					</div> <!-- END OF "USER'S CART" -->
					<div id="nomoney_div"> 
					<span id="nomoney" onClick="showNoMoney();">NO MONEY? </span>
					 </div>
				</td>
				<td>
					<!-- DISPLAYS WHAT USER CAN BUY -->
					<div id="shop_div">
						<!-- WEAPONS -->
						<div>
							<span class="weapon_name">WEAPONS </span>
							<div class="margin_div_vertical"></div>
						</div>
						<div id="weapon_shop">
							<c:set var="weapons" value="${weaponsList}" />
							<c:forEach items="${weapons}" var="weapon">
								<c:set var="countW" value="${countW + 1}" scope="page" />
								<div class="shop_item">
									<a onclick="buy(this.id, ${weapon.getItemPrice()})"
										id="weapon|${weapon.getItemId()}"
										info="${weapon.getItemName()}"> <img class="tTip"
										src="${weapon.getItemPicture()}"
										title="<strong>NAME: </strong> ${weapon.getItemName()} <br />
									<strong>TYPE: </strong> ${weapon.isWeaponType()} <br />
									<strong>HIT POINTS: </strong> ${weapon.getHitPoints()} <br />
									<strong>PRICE: </strong> ${weapon.getItemPrice()} <br />
									<strong>Description: </strong> TODO" />

									</a>
								</div>
								<c:if test="${(countW % 4) == 0 }">
									<div class="margin_div_vertical"></div>
								</c:if>
							</c:forEach>
						</div>
						<!-- END OF "WEAPONS" -->
						<div class="margin_div_vertical"></div>
						<!-- ARMORS -->
						<div>
							<span class="armor_name">ARMORS </span>
							<div class="margin_div_vertical"></div>
						</div>
						<div id="armor_shop">
							<c:set var="armors" value="${armorsList}" />
							<c:forEach items="${armors}" var="armor">

								<c:set var="countAr" value="${countAr + 1}" scope="page" />
								<div class="shop_item">
									<a onclick="buy(this.id, ${armor.getItemPrice()})"
										id="armor|${armor.getItemId()}" info="${armor.getItemName()}">
										<img class="tTip" src="${armor.getItemPicture()}"
										title="<strong>NAME: </strong> ${armor.getItemName()} <br />
											<strong>PROTECTION: </strong> ${armor.getArmorProtection()} <br />
											<strong>PRICE: </strong> ${armor.getItemPrice()} <br />
											<strong>Description: </strong> TODO" />
									</a>
								</div>
								<c:if test="${(countAr % 4) == 0 }">
									<div class="margin_div_vertical"></div>
								</c:if>
							</c:forEach>
						</div>
						<!-- END OF ARMORS -->
						<div class="margin_div_vertical"></div>
						<!-- AIDS -->
						<div>
							<span class="aid_name">AIDS </span>
							<div class="margin_div_vertical"></div>
						</div>
						<div id="aid_shop">
							<c:set var="aids" value="${aidsList}" />
							<c:forEach items="${aids}" var="aid">
								<c:set var="countAids" value="${countAids + 1}" scope="page" />
								<div class="shop_item">
									<a onclick="buy(this.id, ${aid.getItemPrice()})"
										id="aid|${aid.getItemId()}" info="${aid.getItemName()}"> <img
										class="tTip" src="${aid.getItemPicture()}"
										title="<strong>NAME: </strong> ${aid.getItemName()} <br />
										<strong>TYPE: </strong> ${aid.getAidType()} <br />
										<strong>EFFECT: </strong> ${aid.getAidEffect()} <br />
										<strong>PRICE: </strong> ${aid.getItemPrice()} <br />
										<strong>Description: </strong> TODO" />
									</a>
								</div>
								<c:if test="${(countAids % 4) == 0 }">
									<div class="margin_div_vertical"></div>
								</c:if>
							</c:forEach>
						</div>
					</div> <!-- END OF "AIDS" --> <!-- END OF "DISPLAYS WHAT USER CAN BUY" -->
				</td>
			</tr>
		</table>
		<!-- END OF "TABLE FOR 3 DIVS (WHAT USER HAVE, USER'S CART AND WHAT USER CAN BUY" -->
	</div>
</body>
</html>