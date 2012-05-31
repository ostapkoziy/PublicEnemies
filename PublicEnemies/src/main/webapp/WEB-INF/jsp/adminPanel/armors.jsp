<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">

<title>Armors</title>

</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>

	<div class="armors_div">
		<!-- Button -->
		<a class="new_entry" style="float: right"
			href="/PublicEnemies/adminPanel/armor/add.html"><span
			class="create_new_entry"> Create New Armor </span> </a>
		<!-- !Button -->
		<p>
		<table class="armors_table">
			<caption>ARMORS:</caption>
			<thead>
				<tr>
					<th>Name</th>
					<th>Protection</th>
					<th>Picture (path)</th>
					<th>Price</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<c:forEach var="armor" items="${armors}">
				<tr>
					<td><a href="armor/info/${armor.getArmorId()}.html">${armor.getArmorName()}
					</a></td>
					<td>${armor.getArmorProtection()}</td>
					<td>${armor.getArmorPicture()}</td>
					<td>${armor.getArmorPrice()}</td>
					<td><a href="armor/edit/${armor.getArmorId()}.html"> edit</a>
					</td>
					<td><a href="armor/delete/${armor.getArmorId()}.html">
							delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>