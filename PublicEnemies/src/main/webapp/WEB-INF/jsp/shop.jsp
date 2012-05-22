<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shop</title>
<style type="text/css">
body {
	background-image: url('./img/bg_city.png');
	font-family: Geneva, Arial, Helvetica, sans-serif;
	color: white;
}

button {
	font-family: 'impact';
	border-radius: 10px;
	font-size: 20px;
	width: 100px;
	height: 40px;
}

A:hover,A:active,A:visited,A:link {
	text-decoration: underline;
	color: white;
	font-size: 20pt;
}

A {
	color: black;
	font-family: 'impact';
	font-size: 20pt;
}

div.shop_header {
	text-align: center;
	padding: 10px;
	border-radius: 15px;
	background: url(./img/opacity_background.png);
	magrin: 0 auto;
}

span#money {
	font-size: 50px;
	font-family: Geneva, Arial, Helvetica, sans-serif;
}

div#main_page {
	float: left;
	padding: 15px;
	font-family: Geneva, Arial, Helvetica, sans-serif;
}

div.left_header_items {
	padding: 15px;
	float: right;
}

div#center_div {
	text-align: center;
	magrin: 0 auto;
}

div#user_div {
	background: url(./img/opacity_background.png);
	text-align: center;
	padding: 10px;
	border-radius: 15px;
	margin: 20px;
	vertical-align: top;
	width: 330px; 
}

div#shop_div {
	background: url(./img/opacity_background.png);
	text-align: center;
	padding: 10px;
	border-radius: 15px;
	margin: 20px;
	vertical-align: top;
	width: 430; 
}

div#basket_div {
	background: url(./img/opacity_background.png);
	text-align: center;
	padding: 10px;
	border-radius: 15px;
	margin: 20px;
	width: 320px;
}
div#weapon_shop, div#armor_shop, div#aid_shop {
	border-style: solid; 
	border-color: black; 
	border-radius: 10px
}
div.item, div.mutual_item, div.shop_item {
	width: 100px;
	height: 100px;
	margin: 0 auto;
	border-radius: 15px;
	/*padding: 5px;*/
	 
}

div.mutual_item, div.shop_item {
	display:inline-block;
}
div.item, div.mutual_item {
	background: url(./img/no_item.png);
}
div.item:hover, div.mutual_item:hover, div.shop_item:hover {
	background: grey; 
}

div.margin_div_vertical {
	height: 10px; 
	width: 5px;	
}
span.weapon_name, span.armor_name, span.aid_name {	 
	padding: 5px; 
	magrin:5px;
	border: 5px; 
	border-radius: 10px;  
	background: black;
	
	font-family: Geneva, Arial, Helvetica, sans-serif;
	font-size: 20px;
	font-weight: bold;  
}
span.weapon_name {
	color: #BB0000; 
}
span.armor_name {
	color: #0b4950; 
}
p.sel_items {
	background: black;
	border-radius: 20px; 
	padding: 5px; 
}
div#cart_items {
	/*background: blue; */
	margin-bottom: 10px; 
	margin-top: 10px;
	
	border-radius: 20px; 
	padding-top 10px;
	padding-left: 10px; 
	padding-bottom: 5px; 
	padding-right: 10px;	 
	  
	border-color: black; 
	border-width: 3px; 
	border-style: solid; 
	
}

div#balance_inscription  {
	padding: 10px;
	font-size: 20;
	font-family: impact;
	font-size: 20pt;
}
div#balance_after {
	margin-bottom: 10px; 	
}
span#money_value {
	background: black;
	padding: 5px; 
	border-radius: 10px; 
	font-size: 20pt; 
	 
}
div#cart_inscription {
	padding: 1px;
	font-size: 20;
	font-family: impact;
	font-size: 20pt;
}
</style>

<script type="text/javascript">
<!-- //

toBuy = new Array();
toSell = new Array();

Count = new Array();

//shows how many items selected to buy/sell
buyCount = 0;
sellCount = 0; 

bSumm = new Array();

//increase_money = 0; 
decrease_money = 0;
function sell(item, price) {
	var curr_money = document.getElementById("money").innerHTML - decrease_money + price;
	decrease_money -= parseInt(price);
	document.getElementById("money_value").innerHTML = "$ " + curr_money;
	
	document.getElementById("selected_items").innerHTML 
	+= "<p class='sel_items' id='r" + item + "'></p>";
	toSell[toSell.length] = item;
	document.getElementById("r"+item).innerHTML = " - " +
		document.getElementById(item).getAttribute("info")
		+ " <a style=\"cursor:pointer;\" onclick=\"unSell('"
		+ item + "', '" + price + "')\"><img src='./img/cancel_buying.png'/></a>";
	document.getElementById(item).style.display = "none";
	sellCount++;	
}

function buy(item, price){
	var tb = false;
	var i = 0;
	var curr_money = document.getElementById("money").innerHTML - decrease_money - price;
	// check for below zero
	if (curr_money >= 0) {	 
		decrease_money += price;
		document.getElementById("money_value").innerHTML = "$ " + curr_money;
		
		// looking for matching id
		for(i = 0; i < toBuy.length; i++){
			if(toBuy[i] == item){
				tb = true;
				break;
			}
		}
		// if there is no match - put 1, else - increase
		if(!tb){
			toBuy[toBuy.length] = item;
			Count[Count.length] = 1;
		} else { Count[i]++; }
		
		if(!bSumm[item]) { // && bSumm[item]!=0){
			bSumm[item]=0;
			document.getElementById("selected_items").innerHTML 
				+= "<p class='sel_items' id='s" 
				+ item + "'></p>";			
		}
		bSumm[item]++;
		document.getElementById("s"+item).innerHTML = 
			" + " + document.getElementById(item).getAttribute("info")
			+ " ["+bSumm[item]+ "] <a style=\"cursor:pointer;\" onclick=\"unBuy('"
			+ item + "', '" + price+"')\"><img src='./img/cancel_buying.png'/></a>";		
	} else {		
		alert("NO MONEY!");
	}
	buyCount++;
}
	
function unSell(item, price){
	var i = 0;
	var curr_money = document.getElementById("money").innerHTML;
	
	decrease_money += parseInt(price);
	
	document.getElementById("money_value").innerHTML = "$ " + (curr_money - decrease_money);
	document.getElementById("r"+item).parentNode.removeChild(document.getElementById("r"+item));
	for (i = 0; i < toSell.length; i++) {
		if (toSell[i] == item) {
			toSell[i] = 0;
		}
	}	 
	document.getElementById(item).style.display = "block";
	sellCount--;
}
	
// back money and delete from list elements
function unBuy(item, price){
	var curr_money = document.getElementById("money").innerHTML;
	// back money if delete from cart	 
	decrease_money -= price;
	document.getElementById("money_value").innerHTML = "$ " + (curr_money - decrease_money);
	bSumm[item]--;
	// deleting <p> tag
	if(bSumm[item]==0){
		document.getElementById("s"+item).parentNode.removeChild(document.getElementById("s"+item));	
		//toBuy[item] = null;
	}
	else {
		document.getElementById("s"+item).innerHTML = 
			" + " + document.getElementById(item).getAttribute("info")
			+ " ["+bSumm[item] + "] <a style=\"cursor:pointer;\" onclick=\"unBuy('" 
					+ item + "', '" + price + "')\"><img src='./img/cancel_buying.png'/></a>";
	}
	var i = 0; 
	for(i=0;i<toBuy.length;i++){
		if(toBuy[i]==item){
			Count[i]--;
		break;
		}
	}
	buyCount--;
}
// creates hidden fields into form and commits (go to controller)
function doBuy(){
	if(buyCount > 0 || sellCount > 0){
		var i = 0; 
				
		for(i = 0; i < toBuy.length; i++){
			if (Count[i] == 0) {
				continue;
			}
			child = document.createElement("input");
			child.type = "hidden";
			child.name = "buy_" + toBuy[i];
			child.value = Count[i];
			document.forms.dobuy.appendChild(child);			
		}	
		for(i = 0;i<toSell.length;i++){
			if (toSell[i] == 0) {
				continue;
			}
			child = document.createElement("input");
			child.type = "hidden";
			child.name = "sell_" + toSell[i];
			child.value = "1";
			document.forms.dobuy.appendChild(child);			
		}
		// do submit (goes into controller through post)
		document.forms.dobuy.submit();
	} else {
		alert("You haven't selected anything!");
	}
}
</script>
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
							
							<h2>${profile.getListOfWeapons().size()}</h2>
							
														
							<c:choose>
							<c:when test="${profile.getListOfWeapons().size() != 0}">								 
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
												
								<h2>${profile.getListOfArmors().size()}</h2>
								<c:choose>
								<c:when test="${profile.getListOfArmors().size() != 0}">
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
								<c:when test="${profile.getListOfAids().size() != 0}">
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