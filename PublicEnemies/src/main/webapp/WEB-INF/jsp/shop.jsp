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
	background-image: url('img/bg_city.png');
	font-family: Geneva, Arial, Helvetica, sans-serif;
	color: white;
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
	background: url(img/opacity_background.png);
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
	background: url(img/opacity_background.png);
	text-align: center;
	padding: 10px;
	border-radius: 15px;
	margin: 20px;
	vertical-align: top;
}

div#shop_div {
	background: url(img/opacity_background.png);
	text-align: center;
	padding: 10px;
	border-radius: 15px;
	margin: 20px;
	vertical-align: top;
}

div#basket_div {
	background: url(img/opacity_background.png);
	text-align: center;
	padding: 10px;
	border-radius: 15px;
	margin: 20px;
}
</style>

<script type="text/javascript">
<!-- //
toBuy = new Array();
Count = new Array(); 
bSumm = new Array();
function buy(item){
	var tb = false;
	for(i=0;i<toBuy.length;i++){
		if(toBuy[i]==item){
			tb = true;
			break;
		}
	}
	if(!tb){
		toBuy[toBuy.length] = item;
		Count[Count.length] = 1;}
	else{
		Count[i]++;
	}
	if(!bSumm[item] && bSumm[item]!=0){
		bSumm[item]=0;
		document.getElementById("selected_items").innerHTML += "<p class='sel_items' id='s"+item+"'>"+document.getElementById(item).getAttribute("info")+" Quantity: "+bSumm[item]+", <a style=\"cursor:pointer;\" onclick=\"unBuy('"+item+"')\">Delete</a></p>";
	}
	bSumm[item]++;
	document.getElementById("s"+item).innerHTML = document.getElementById(item).getAttribute("info")+" Quantity: "+bSumm[item]+", <a style=\"cursor:pointer;\" onclick=\"unBuy('"+item+"')\"><img src='./img/cancel_buying.png'/></a>";
	document.getElementById("s"+item).style.display="";
}

function unBuy(item){
	bSumm[item]--;
	if(bSumm[item]==0){
		document.getElementById("s"+item).style.display = "none";}
	else{
		document.getElementById("s"+item).innerHTML = document.getElementById(item).getAttribute("info")+" Quantity: "+bSumm[item]+", <a style=\"cursor:pointer;\" onclick=\"unBuy('"+item+"')\"><img src='./img/cancel_buying.png'/></a>";
	}
	for(i=0;i<toBuy.length;i++){
		if(toBuy[i]==item){
			Count[i]--;
		break;
		}
	}
}

function doBuy(){
	if(Count.length>0){
		for(i=0;i<toBuy.length;i++){
			child = document.createElement("input");
			child.type = "hidden";
			child.name = "buyItem"+toBuy[i];
			child.value = Count[i];
			document.forms.dobuy.appendChild(child);
		}
		document.forms.dobuy.submit();
	} else {
		alert("You haven't selected anything!");
	}
}

function page(url){
	document.forms.other_page.action=url;
	for(i=0;i<toBuy.length;i++){
		child = document.createElement("input");
		child.type = "hidden";
		child.name = "buyItem"+toBuy[i];
		child.value = Count[i];
		document.forms.other_page.appendChild(child);
	}
	document.forms.other_page.submit();
}
// -->
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
	<c:set var="countAids" value="0" scope="page" />
	<c:set var="countW" value="0" scope="page" />
	<c:set var="countAr" value="0" scope="page" />
	
		<table width="100%">
			<tr valign="top">
				<td>
					<div id="user_div">
						[log with janukovych@mail.ru to see full functionality]
						<h4 style="color: white">USER ID = ${uid}</h4>
						<h3>${profile.getNickName()}, YOU HAVE:</h3>

						<div>
							Weapon 1: <img
								src="${profile.getDressedWeapon1().getItemPicture()}"
								title="${profile.getDressedWeapon1().getItemId()},
								${profile.getDressedWeapon1().getItemName()},
								${profile.getDressedWeapon1().isWeaponType()},
								${profile.getDressedWeapon1().getHitPoints()},
								${profile.getDressedWeapon1().getItemPrice()}" />
						</div>

						<div>
							Weapon 2: <img
								src="${profile.getDressedWeapon2().getItemPicture()}"
								title="${profile.getDressedWeapon2().getItemId()},
								${profile.getDressedWeapon2().getItemName()},
								${profile.getDressedWeapon2().isWeaponType()},
								${profile.getDressedWeapon2().getHitPoints()},
								${profile.getDressedWeapon2().getItemPrice()}" />
						</div>

						<div>
							Aid: <img src="${profile.getDressedAid().getItemPicture()}"
								title="${profile.getDressedAid().getItemId()}
								${profile.getDressedAid().getItemName()}
								${profile.getDressedAid().getAidType()}
								${profile.getDressedAid().getAidEffect()}
								${profile.getDressedAid().getItemPrice()}" />
						</div>

						<div>
							Armor: <img src="${profile.getDressedArmor().getItemPicture()}"
								title="${profile.getDressedArmor().getItemId()}
								${profile.getDressedArmor().getItemName()}
								${profile.getDressedArmor().getArmorProtection()}
								${profile.getDressedArmor().getItemPicture()}
								${profile.getDressedArmor().getItemPrice()}" />
						</div>
						<br /> <br /> TODO: TRUNK ITEMS
					</div>
				</td>
				<td>
					<div id="basket_div">
					<p>YOUR BALANCE AFTER BUYING:</p>
						Your goods:
						<div id="selected_items"></div>
						Goods for buying:<br> 
						<!--   <a onclick="buy(this.id)" id="i1" info="+Good #1">Good #1</a><br>  
						<a onclick="buy(this.id)" id="i2" info="+Good #1">Good #2</a><br> 
						<a onclick="buy(this.id)" id="i3" info="+Good #1">Good #3</a><br>
						<a onclick="buy(this.id)" id="i4" info="+Good #1">Good #4</a><br>
						<a onclick="buy(this.id)" id="i5" info="+Good #1">Good #5</a><br> -->
						<hr>
						<a onclick="doBuy()"> AGREE </a>
						<form action="buing_script.php" method="post" name="dobuy"
							style="display: none;"></form>
						<form method="post" name="other_page"></form>
						
					</div>

				</td>
				<td>
					<div id="shop_div">
						<h3>YOU CAN BUY:</h3>
						<table border='2' align='center'>
							<c:set var="weapons" value="${weaponsList}" />
							<caption>WEAPONS</caption>
							
							<c:forEach items="${weapons}" var="weapon">
								<c:if test="${(countW % 4) == 0 }">
									<tr>
								</c:if>
								<c:set var="countW" value="${countW + 1}" scope="page" />
								<td>
								<a onclick="buy(this.id)" id="${countW}" info="+ ${weapon.getItemName()}">
								<img src="${weapon.getItemPicture()}"
									title="${weapon.getItemId()}, ${weapon.getItemName()}, ${weapon.getItemPrice()}" />
									</a>
								</td>
								<c:if test="${(countW % 4) == 0 }">
									</tr>
								</c:if>
							</c:forEach>
						</table>
						
						<table border='2'>
							<c:set var="aids" value="${aidsList}" />
							<caption>AIDS</caption>
							<tr>
								
								<c:forEach items="${aids}" var="aid">
								    <c:if test="${(countAids % 4) == 0 }">
									<tr>
									</c:if>
									<c:set var="countAids" value="${countAids + 1}" scope="page" />
									<td> <a onclick="buy(this.id)" id="${countW + countAids}" info="+ ${aid.getItemName()}"> 
									<img src="${aid.getItemPicture()}"
										title="ID:     ${aid.getItemId()}
NAME: ${aid.getItemName()}
TYPE: ${aid.getAidType()}
EFFECT: ${aid.getAidEffect()}
PRICE: ${aid.getItemPrice()}" /> </a>
									</td>
									<c:if test="${(countAids % 4) == 0 }">
									</tr>
								</c:if>
								</c:forEach>
							</tr>
						</table>

						<table border='2' align='center'>
							<c:set var="armors" value="${armorsList}" />
							<caption>ARMORS</caption>

							<c:forEach items="${armors}" var="armor">
								<!-- <c:out value="${count}" /> -->
								<c:if test="${(countAr % 4) == 0 }">
									<tr>
								</c:if>
								<c:set var="countAr" value="${countAr + 1}" scope="page" />
								<td>
								<a onclick="buy(this.id)" id="${countW + countAids + countAr}" info="+ ${armor.getItemName()}">
								<img src="${armor.getItemPicture()}"
									title="${armor.getItemId()}, ${armor.getItemName()}, ${armor.getItemPrice()}" />
								</td>
								</a>
								<c:if test="${(countAr % 4) == 0 }">
									</tr>
								</c:if>
							</c:forEach>
						</table>
					</div>
				</td>
			</tr>
		</table>

	</div>

</body>
</html>