<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">

<title>Weapons</title>
</head>

<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>

	<div class="weapons_div">
		<!-- Button -->
		<a class="new_entry" style="float: right"
			href="/PublicEnemies/adminPanel/weapon/add.html"><span
			class="create_new_entry"> Create New Weapon </span> </a>
		<!-- !Button -->
		<p>
		<table class="weapons_table">
			<caption>WEAPONS:</caption>
			<thead>
				<tr>
					<th>Name</th>
					<th>Hit Points</th>
					<th>Firearm</th>
					<th>Picture (path)</th>
					<th>Price</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<c:forEach var="weapon" items="${weapons}">
				<tr>
					<td><a href="weapon/info/${weapon.getWeaponId()}.html">${weapon.getWeaponName()}
					</a></td>
					<td>${weapon.getHitPoints()}</td>
					<td>${weapon.isWeaponType()}</td>
					<td>${weapon.getWeaponPicture()}</td>
					<td>${weapon.getWeaponPrice()}</td>
					<td><a href="weapon/edit/${weapon.getWeaponId()}.html">
							edit</a></td>
					<td><a href="weapon/delete/${weapon.getWeaponId()}.html">
							delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>