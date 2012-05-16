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
}

h2 {
	color: black;
	font-family: 'impact';
	font-size: 20pt;
}

button {
	font-family: 'impact';
	font-size: 20px;
	width: 100px;
	height: 44px;
}

table.sample {
	margin-top: 100px;
	background-color: #444D48;
	opacity: .6;
	filter: alpha(opacity =     60);
	-moz-opacity: .6;
	border-width: 3px;
	border-spacing: 5px;
	border-style: outset;
	border-color: white;
	border-collapse: separate;
}

table.sample th {
	border-width: 0px;
	padding: 3px;
	border-style: none;
	border-color: gray;
	-moz-border-radius:;
}

table.sample td {
	border-width: 0px;
	padding: 3px;
	border-style: none;
	border-color: gray;
	-moz-border-radius:;
}

A:link {
	text-decoration: underline;
	color: white;
	font-size: 20pt;
}

A:visited {
	text-decoration: underline;
	color: white;
	font-size: 20pt;
}

A:active {
	text-decoration: underline;
	color: white;
	font-size: 20pt;
}

A:hover {
	text-decoration: underline;
	color: white;
	font-size: 20pt;
}

a {
	color: black;
	font-family: 'impact';
	font-size: 20pt;
}

body {
	background-image: url(img/bg_city.png);
	color: white;
}

h1 {
	font-family: 'impact';
	font-size: 20pt;
	color: red;
}
div.shop_header {
	text-align: center; 
	padding: 10px;
	border-radius: 15px;
	background: url(img/opacity_background.png); 
	magrin: 0 auto;	  
}
span#money {
	font-size:50px;
	font-family: Geneva, Arial, Helvetica, sans-serif;
}
div#main_page {
	float:left; 
	padding: 15px;
	font-family: Geneva, Arial, Helvetica, sans-serif; 
}
div.left_header_items {
	padding: 15px;
	float:right; 
}
</style>

</head>


<body>
<div class="shop_header">
<div id="main_page"> <a href="userStartPage.html">MAIN PAGE </a></div>
<img src="./img/dollar_sign.png"> 
<span id="money" >${money}</span>
<div class="left_header_items">
<a href="logout.html">Logout</a> <br />
</div>
<div class="left_header_items">
<a href="editProfile.html">
	<img src="${profile.getAvatar()}" title="${profile.getNickName()}'s profile" border="0" width="40px"></img>
</a>
</div>


</div>
 
[log with janukovych@mail.ru to see full functionality]
	<h2 style="color: white">USER ID = ${uid}</h2>
	<div style="float: right">
	
	<table border='2' align='center'>
			<c:set var="weapons" value="${weaponsList}" />
			<caption>WEAPONS</caption>
			<c:set var="countW" value="0" scope="page" />
			<c:forEach items="${weapons}" var="weapon">
			<c:if test="${(countW % 4) == 0 }">
				<tr>
				</c:if>			
				<c:set var="countW" value="${countW + 1}" scope="page"/>
				<td>				
				 <img src="${weapon.getItemPicture()}"				 
				title = "${weapon.getItemId()}, ${weapon.getItemName()}, ${weapon.getItemPrice()}"				
				/> </td>
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
					<td><img src="${aid.getItemPicture()}" 
					title="ID:     ${aid.getItemId()}
NAME: ${aid.getItemName()}
TYPE: ${aid.getAidType()}
EFFECT: ${aid.getAidEffect()}
PRICE: ${aid.getItemPrice()}"/> 
					</td>				
			</c:forEach>
			</tr>	
		</table>

		<table border='2' align='center'>
			<c:set var="armors" value="${armorsList}" />
			<caption>ARMORS</caption>
			
			<c:set var="countAr" value="0" scope="page" />
			<c:forEach items="${armors}" var="armor">				
				<!-- <c:out value="${count}" /> -->				
				<c:if test="${(countAr % 4) == 0 }">
				<tr>
				</c:if>			
				<c:set var="countAr" value="${countAr + 1}" scope="page"/>
				<td>				
				 <img src="${armor.getItemPicture()}"				 
				title = "${armor.getItemId()}, ${armor.getItemName()}, ${armor.getItemPrice()}"				
				/> </td>
				<c:if test="${(countAr % 4) == 0 }">
				</tr>
				</c:if>						
			</c:forEach>
			
		</table>

		
	</div>
	<div style="color: white">
	Nickname = ${profile.getNickName()}
	<h3> Dressed Items: </h3>
	<table border='1'>
	<caption> Weapon 1</caption>
	<tr> <td> ID </td> <td> Name </td> <td> Type </td> <td> HitPoints </td> <td> Picture </td> <td> Price </td></tr>
	<tr> 
	<td> ${profile.getDressedWeapon1().getItemId()} </td> 
	<td> ${profile.getDressedWeapon1().getItemName()} </td> 
	<td> ${profile.getDressedWeapon1().isWeaponType()} </td> 
	<td> ${profile.getDressedWeapon1().getHitPoints()} </td> 
	<td> ${profile.getDressedWeapon1().getItemPicture()} </td> 
	<td> ${profile.getDressedWeapon1().getItemPrice()} </td>
	</tr>
	</table>
	<br />
	<table border='1'>
	<caption> Weapon 2</caption>
	<tr> <td> ID </td> <td> Name </td> <td> Type </td> <td> HitPoints </td> <td> Picture </td> <td> Price </td></tr>
	<tr> 
	<td> ${profile.getDressedWeapon2().getItemId()} </td> 
	<td> ${profile.getDressedWeapon2().getItemName()} </td> 
	<td> ${profile.getDressedWeapon2().isWeaponType()} </td> 
	<td> ${profile.getDressedWeapon2().getHitPoints()} </td> 
	<td> ${profile.getDressedWeapon2().getItemPicture()} </td> 
	<td> ${profile.getDressedWeapon2().getItemPrice()} </td>
	</tr>
	</table>
	<br />
	
	<table border='1'>
	<caption> Aid </caption>
	<tr> <td> ID </td> <td> Name </td> <td> Type </td> <td> Effect </td> <td> Picture </td> <td> Price </td></tr>
	<tr> 
	<td> ${profile.getDressedAid().getItemId()} </td> 
	<td> ${profile.getDressedAid().getItemName()} </td> 
	<td> ${profile.getDressedAid().getAidType()} </td> 
	<td> ${profile.getDressedAid().getAidEffect()} </td> 
	<td> <img src ="${profile.getDressedAid().getItemPicture()}" title="asdf sdfs"/> </td> 
	<td> ${profile.getDressedAid().getItemPrice()} </td>
	</tr>
	</table>
	<br />
	
	<table border='1'>
	<caption> Armor </caption>
	<tr> <td> ID </td> <td> Name </td> <td> Protection </td> <td> Picture </td> <td> Price </td></tr>
	<tr> 
	<td> ${profile.getDressedArmor().getItemId()} </td> 
	<td> ${profile.getDressedArmor().getItemName()} </td> 
	<td> ${profile.getDressedArmor().getArmorProtection()} </td> 
	<td> ${profile.getDressedArmor().getItemPicture()} </td> 
	<td> ${profile.getDressedArmor().getItemPrice()} </td>
	</tr>
	</table>
	<br />
	<br />
	TODO: TRUNK ITEMS
	</div>



</body>
</html>