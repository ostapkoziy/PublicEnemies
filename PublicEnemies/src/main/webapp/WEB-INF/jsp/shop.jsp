<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="css/shop/shopstyle.css" rel="stylesheet"
	type="text/css">
	
	
	
	
<title>Shop</title>



<script type="text/javascript" src="js/shop/shopmanager.js"></script>

</head>

<body>
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

	<div id="center_div">
		<c:set var="countAidsIT" value="0" scope="page" />
		<c:set var="countWIT" value="0" scope="page" />
		<c:set var="countArIT" value="0" scope="page" />
		<c:set var="countAids" value="0" scope="page" />
		<c:set var="countW" value="0" scope="page" />
		<c:set var="countAr" value="0" scope="page" />


		<table width="100%">
			<tr valign="top">
				<td>				
					<div id="user_div">
						<div>
							<div>INTO TRUNK:</div>
							<div class="margin_div_vertical"></div>
							<div> <span class="weapon_name"> WEAPONS </span> </div>
							<div class="margin_div_vertical"></div>
							
							<!-- <h2>${profile.getListOfWeapons().size()}</h2> -->
							
														
							<c:choose>
							<c:when test="${profile.getUndresedWeapons().size() != 0}">								 
								<c:set var="weaponsIntoTrunk"
									value="${profile.getListOfWeapons()}" />								
								<c:forEach items="${weaponsIntoTrunk}" var="weaponIT">
									<c:if test="${!weaponIT.isWearing()}">
										
										<c:set var="countWIT" value="${countWIT + 1}" scope="page" />
										
										<div class="mutual_item">
		     			<a onclick="sell(this.id, ${weaponIT.getItem().getItemPrice() * 0.6})"
							id="rweapon_id_${countWIT}|${weaponIT.getItem().getItemId()}"
							info="${weaponIT.getItem().getItemName()}"> 
										<img src="${weaponIT.getItem().getItemPicture()}"
											title="${weaponIT.getItem().getItemId()}, ${weaponIT.getItem().getItemName()}, ${weaponIT.getItem().getItemPrice() * 0.6}" />
						</a>
										</div>	
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
						<div class="magrin_div_vertical"></div>

						<div>
							<div class="margin_div_vertical"></div>
							<div> <span class="armor_name"> ARMORS </span> </div>
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
																		
									<a onclick="sell(this.id, ${armorIT.getItem().getItemPrice() * 0.6})"
							id="rarmor_id_${countArIT}|${armorIT.getItem().getItemId()}"
							info="${armorIT.getItem().getItemName()}"> 
										<img src="${armorIT.getItem().getItemPicture()}"
											title="${armorIT.getItem().getItemId()}, ${armorIT.getItem().getItemName()}, ${armorIT.getItem().getItemPrice() * 0.6}" />
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

						<div>
						<div> <span class="aid_name"> AIDS </span> </div>
							<div class="margin_div_vertical"></div>
								<c:choose>
								<c:when test="${profile.getUndressedAids().size() != 0}">
									<c:set var="aidsIntoTrunk" value="${profile.getListOfAids()}" />
							
								<c:forEach items="${aidsIntoTrunk}" var="aidIT">
									<c:if test="${!aidIT.isWearing()}">										
										<c:set var="countAidsIT" value="${countAidsIT + 1}"
											scope="page" />										
										<div class="mutual_item">
									
										
										<a onclick="sell(this.id, ${aidIT.getItem().getItemPrice() * 0.6})"
											id="raid_id_${countAidsIT}|${aidIT.getItem().getItemId()}"
											info="${aidIT.getItem().getItemName()}"> 
										<img src="${aidIT.getItem().getItemPicture()}"
											title="${aidIT.getItem().getItemId()}, ${aidIT.getItem().getItemName()}, ${aidIT.getItem().getItemPrice() * 0.6}" />
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
					</div>
					
					<div id="user_div">
						<h3>${profile.getNickName()}, YOU HAVE:</h3>
						<div>						
																									
									<c:choose>
											<c:when test="${profile.getDressedWeapon1().getItemId() != 0}">
											<div class="mutual_item">
												<img src="${profile.getDressedWeapon1().getItemPicture()}"
													title="${profile.getDressedWeapon1().getItemId()},
								${profile.getDressedWeapon1().getItemName()},
								${profile.getDressedWeapon1().isWeaponType()},
								${profile.getDressedWeapon1().getHitPoints()},
								${profile.getDressedWeapon1().getItemPrice()}" />
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
												<img src="${profile.getDressedWeapon2().getItemPicture()}"
													title="${profile.getDressedWeapon2().getItemId()},
								${profile.getDressedWeapon2().getItemName()},
								${profile.getDressedWeapon2().isWeaponType()},
								${profile.getDressedWeapon2().getHitPoints()},
								${profile.getDressedWeapon2().getItemPrice()}" />
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
												<img src="${profile.getDressedArmor().getItemPicture()}"
													title="${profile.getDressedArmor().getItemId()}
								${profile.getDressedArmor().getItemName()}
								${profile.getDressedArmor().getArmorProtection()}
								${profile.getDressedArmor().getItemPicture()}
								${profile.getDressedArmor().getItemPrice()}" />
								</div>
											</c:when>
											<c:otherwise>
								
								<div class="item"> </div>								
							</c:otherwise>
										</c:choose>				
										<div class="margin_div_vertical"></div>		
									<c:choose>
											<c:when test="${profile.getDressedAid().getItemId() != 0}">
											<div class="item">
												<img src="${profile.getDressedAid().getItemPicture()}"
													title="${profile.getDressedAid().getItemId()}
								${profile.getDressedAid().getItemName()}
								${profile.getDressedAid().getAidType()}
								${profile.getDressedAid().getAidEffect()}
								${profile.getDressedAid().getItemPrice()}" />
								</div>
											</c:when>
											<c:otherwise>
								<div class="item"></div>
							</c:otherwise>
										</c:choose>						
						</div>
					</div>				
					</td>
				<td>
					<div id="basket_div">
						<div id="balance_inscription">BALANCE AFTER APPROVING:</div>
						<div id="balance_after">
							<span id="money_value">$ ${profile.getMoney()}</span>
						</div>						
						<div id="cart_inscription">CART: </div>
						<div id="cart_items">
						<div id="selected_items"></div>						
						</div>	
						<a onclick="doBuy()"><button class="button">APPROVE</button></a>
						
						<form action="" method="post" name="dobuy"></form>
											

					</div>

				</td>
				<td>
					<div id="shop_div">							
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
									info="${weapon.getItemName()}"> 
									<img src="${weapon.getItemPicture()}"
										title="${weapon.getItemId()}, ${weapon.getItemName()}, ${weapon.getItemPrice()}" />
								</a></div>
								<c:if test="${(countW % 4) == 0 }">
									<div class="margin_div_vertical"></div>
								</c:if>
							</c:forEach>
						</div>
						<div class="margin_div_vertical"></div>
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
										<img src="${armor.getItemPicture()}"
										title="${armor.getItemId()}, ${armor.getItemName()}, ${armor.getItemPrice()}" />
								</a>
								</div>
								<c:if test="${(countAr % 4) == 0 }">
									<div class="margin_div_vertical"></div>
								</c:if>
							</c:forEach>
							</div>
							
							<div class="margin_div_vertical"> </div>

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
										id="aid|${aid.getItemId()}" info="${aid.getItemName()}">
											<img src="${aid.getItemPicture()}"
											title="ID:     ${aid.getItemId()}
NAME: ${aid.getItemName()}
TYPE: ${aid.getAidType()}
EFFECT: ${aid.getAidEffect()}
PRICE: ${aid.getItemPrice()}" />
									</a></div>
									<c:if test="${(countAids % 4) == 0 }">
							 <div class="margin_div_vertical"></div>
							</c:if>
							</c:forEach>						
							</div>
							
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>