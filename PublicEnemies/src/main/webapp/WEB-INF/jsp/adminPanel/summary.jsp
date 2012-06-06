<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">

<title>Admin Panel</title>
<style>
img.pictures {
	padding: 0px;
}

div.pic_wrapper { /*border: 1px solid black;*/
	width: 128px;
	height: 128px;
	border-radius: 15px;
	margin: 10px 30px; 
}

div.pic_wrapper:HOVER {
	background: grey;
}
span.section_headline {
	font-size: 30px; 
}
a.section_liks {
	text-decoration: none;
}
table.category_table, .category_table th, .category_table td {
	border: 0px solid black;
	padding: 0px 0px; 
	text-align: center; 
}
</style>

</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	<jsp:include page="leftMenuDiv.jsp"></jsp:include>	
	<div class="summary_div">
		<div
			style="border: 0px solid black; text-align: center; padding: 5px; border-radius: 10px;">
			<table align="center" class="category_table">
				<tr>
					<td><span class="section_headline"><a class="section_liks" href="/PublicEnemies/adminPanel/users.html">Users (${amountOfUsers})</a></span></td>
					<td><span class="section_headline"><a class="section_liks" href="/PublicEnemies/adminPanel/weapons.html">Weapons (${amountOfWeapons})</a></span></td>
					<td><span class="section_headline"><a class="section_liks" href="/PublicEnemies/adminPanel/armors.html">Armors (${amountOfArmors})</a></span></td>
					<td><span class="section_headline"><a class="section_liks" href="/PublicEnemies/adminPanel/aids.html">Aids (${amountOfAids})</a></span></td>
				</tr>
				<tr align="center">
					<td>
						<div class="pic_wrapper">
							<a class="imgs_links"
								href="/PublicEnemies/adminPanel/user/add.html"> <img
								class="pictures"
								src="/PublicEnemies/img/adminpanel/add_user.png"
								alt="Add new user picture" title="Add new user" />
							</a>
						</div>
					</td>
					<td>
						<div class="pic_wrapper">
							<a href="/PublicEnemies/adminPanel/weapon/add.html"> <img
								class="pictures"
								src="/PublicEnemies/img/adminpanel/add_weapon.png"
								alt="Add new user picture" title="Add new weapon" />
							</a>
						</div>
					</td>
					<td>
						<div class="pic_wrapper">
							<a href="/PublicEnemies/adminPanel/armor/add.html"> <img
								class="pictures"
								src="/PublicEnemies/img/adminpanel/add_armor.png"
								alt="Add new user picture" title="Add new armor" /></a>
						</div>
					</td>

					<td>
						<div class="pic_wrapper">
							<a href="/PublicEnemies/adminPanel/aid/add.html"> <img
								class="pictures" src="/PublicEnemies/img/adminpanel/add_aid.png"
								alt="Add new user picture" title="Add new aid" />
							</a>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<!-- 
		-->
		<p id="last_registered">
		<table class="users_table" align="center">
			<caption>The 5 Latest Registered Users</caption>
			<thead>
				<tr>
					<th>Avatar</th>
					<th>Nickname</th>
					<th>Email</th>
					
					<th>Registration Date</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<c:forEach var="registeredOne" items="${lastRegistered}">
				<tr>
					<td><img src="/PublicEnemies/${registeredOne.getAvatar()}" width="50px" height="50px" />
					</td>
					<td><a href="user/info/${registeredOne.getUserId()}.html">${registeredOne.getNickName()}
					</a></td>
					<td>${registeredOne.getEmail()}</td>
					
					<td>${registeredOne.getRegDate()}</td>
					<td><a href="user/edit/${registeredOne.getUserId()}.html">
							edit</a></td>
					<td><a href="user/delete/${registeredOne.getUserId()}.html">
							delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>