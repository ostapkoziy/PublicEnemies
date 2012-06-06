<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Weapon</title>
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
		<h2>Edit weapon</h2>
		<form method="post">
			<table>
				<tr>
					<td>Name:</td>
					<td><input name="wName" type="text"
						value="${weapon.getWeaponName()}" /></td>
				</tr>
				<tr>
					<td>Hit points:</td>
					<td><input name="wHP" type="text"
						value="${weapon.getHitPoints()}" /></td>
				</tr>
				<tr>
					<td>Type(firearm):</td>
					<td><input name="wType" type="text"
						value="${weapon.isWeaponType()}" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input name="wPrice" type="text"
						value="${weapon.getWeaponPrice()}" /></td>
				</tr>
				<tr>
					<td>Picture(Path):</td>
					<td><input name="wPicturePath" type="text"
						value="${weapon.getWeaponPicture()}" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input name="wDescription" type="text"
						value="${weapon.getItemDescription()}" /></td>
				</tr>
			</table>
			<input name="weaponId" type="hidden" value="${weapon.getWeaponId()}">
			<input type="submit" value="Edit" />
		</form>
	</div>
</body>
</html>