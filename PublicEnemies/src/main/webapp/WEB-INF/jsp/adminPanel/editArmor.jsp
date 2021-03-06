<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Armor</title>
</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	<jsp:include page="leftMenuDiv.jsp"></jsp:include>
	<div class="summary_div">
	<!-- Button -->
		<a class="new_entry" style="float: right"
			href="/PublicEnemies/adminPanel/armor/add.html"><span
			class="create_new_entry"> Create New Armor </span> </a>
		<!-- !Button -->
		<h2>Edit Armor</h2>
		<form method="post">
			<table>
				<tr>
					<td>Name:</td>
					<td><input name="aName" type="text"
						value="${armor.getArmorName()}" /></td>
				</tr>
				<tr>
					<td>Protection:</td>
					<td><input name="aProtection" type="text"
						value="${armor.getArmorProtection()}" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input name="aPrice" type="text"
						value="${armor.getArmorPrice()}" /></td>
				</tr>
				<tr>
					<td>Picture(Path):</td>
					<td><input name="aPicturePath" type="text"
						value="${armor.getArmorPicture()}" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input name="aDescription" type="text"
						value="${armor.getItemDescription()}" /></td>
				</tr>
			</table>
			<input name="armorId" type="hidden" value="${armor.getArmorId()}">
			<input type="submit" value="Edit" />
		</form>
	</div>
</body>
</html>