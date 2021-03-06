<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">
<title>Detail Weapon Info</title>
</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	<jsp:include page="leftMenuDiv.jsp"></jsp:include>
	<div class="summary_div">
		<!-- Button -->
		<a class="new_entry" style="float: right"
			href="/PublicEnemies/adminPanel/weapon/add.html"><span
			class="create_new_entry"> Create New Weapon </span> </a>
		<!-- !Button -->
		<h3> [ <a href="/PublicEnemies/adminPanel/weapon/edit/${weapon.getWeaponId()}.html">Edit</a> ]</h3>
		<table>
			<tr>
				<td rowspan="6"><img
					src="../../../${weapon.getWeaponPicture()}" /></td>
				<td>Name:</td>
				<td>${weapon.getWeaponName()}</td>
			</tr>
			<tr>
				<td>Hit points:</td>
				<td>${weapon.getHitPoints()}</td>
			</tr>
			<tr>
				<td>Type(firearm):</td>
				<td>${weapon.isWeaponType()}</td>
			</tr>
			<tr>
				<td>Price:</td>
				<td>${weapon.getWeaponPrice()}</td>
			</tr>
			<tr>
				<td>Picture(Path):</td>
				<td>${weapon.getWeaponPicture()}</td>
			</tr>
			<tr>
				<td>Description:</td>
				<td>${weapon.getItemDescription()}</td>
			</tr>
		</table>
	</div>
</body>
</html>