<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">
<title>Detail Armor Info</title>
</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	<div class="summary_div">
		<h2>Detail Armor Info</h2>
		<table>
			<tr>
				<td>Name:</td>
				<td>${armor.getArmorName()}</td>
			</tr>
			<tr>
				<td>Protection:</td>
				<td>${armor.getArmorProtection()}</td>
			</tr>
			<tr>
				<td>Price:</td>
				<td>${armor.getArmorPrice()}</td>
			</tr>
			<tr>
				<td>Picture(Path):</td>
				<td>${armor.getArmorPicture()}</td>
			</tr>
			<tr>
				<td>Description:</td>
				<td>${armor.getItemDescription()}</td>
			</tr>
		</table>
	</div>
</body>
</html>