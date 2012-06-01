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

</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>

	<div class="summary_div">
		<div style="float: right; text-align: right;">
			<p style="margin-top: 20px; margin-bottom: 20px">
				<a class="new_entry" href="/PublicEnemies/adminPanel/user/add.html">Create New
					User </a>
			</p>
			<p style="margin-top: 20px; margin-bottom: 20px">
				<a class="new_entry" href="/PublicEnemies/adminPanel/weapon/add.html"> Create New
					Weapon</a>
			</p>
			<p style="margin-top: 20px; margin-bottom: 20px">
				<a class="new_entry"
					href="/PublicEnemies/adminPanel/armor/add.html"> Create New
					Armor </a>
			</p>
			<p style="margin-top: 20px; margin-bottom: 20px">
				<a class="new_entry" href="/PublicEnemies/adminPanel/aid/add.html"> Create New Aid</a>
			</p>
		</div>

		<table>
			<thead>
				<tr>
					<th>Entity</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tr>
				<td><a href="users.html">Users:</a></td>
				<td>${amountOfUsers}</td>
			</tr>
			<tr>
				<td><a href="weapons.html"> Weapons: </a></td>
				<td>${amountOfWeapons}</td>
			</tr>
			<tr>
				<td><a href="armors.html">Armors:</a></td>
				<td>${amountOfArmors}</td>
			</tr>
			<tr>
				<td><a href="aids.html">Aids:</a></td>
				<td>${amountOfAids}</td>
			</tr>
		</table>
		<p id="last_registered">
		<table class="users_table">
			<caption>The 5 Latest Registered Users</caption>
			<thead>
				<tr>
					<th>Nickname</th>
					<th>Email</th>
					<th>Password</th>
					<th>Registration Date</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<c:forEach var="registeredOne" items="${lastRegistered}">
				<tr>
					<td><a href="user/info/${registeredOne.getUserId()}.html">${registeredOne.getNickName()}
					</a></td>
					<td>${registeredOne.getEmail()}</td>
					<td>${registeredOne.getPassword()}</td>
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