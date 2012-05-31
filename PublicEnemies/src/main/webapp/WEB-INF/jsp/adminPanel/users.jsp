<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">

<title>Users</title>
</head>
<body>

	<jsp:include page="adminHeader.jsp"></jsp:include>

	<div class="users_div">
		<!-- Button -->
	<a class="new_entry" style="float:right" href="/PublicEnemies/adminPanel/user/add.html"><span
			class="create_new_entry"> Create New User </span> </a>
	<!-- End of Button -->
		<p id="all_users">
		<table class="users_table">
			<caption>USERS:</caption>
			<thead>
				<tr>
					<th><a href="usersOrderByNickName.html"> Nickname</a></th>
					<th>Email</th>
					<th>Password</th>
					<th><a href="usersOrderByRegDate.html"> Registration Date
					</a></th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<c:forEach var="registeredOne" items="${allUsers}">
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