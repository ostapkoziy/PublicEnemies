<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../../../css/adminpanel/commonstyle.css" rel="stylesheet"
	type="text/css">
<title>Detail Weapon Info</title>
</head>
<body>
	<h2>Detail Weapon Info</h2>

	<table>
		<tr>
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
</body>
</html>