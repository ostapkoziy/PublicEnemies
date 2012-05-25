<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../css/adminpanel/commonstyle.css" rel="stylesheet"
	type="text/css">

<title> Users </title>
</head>
<body>

<jsp:include page="adminHeader.jsp"></jsp:include>

	<div class="users_div">
		<a class="new_entry" href="user/add.html"><span class="create_new_entry"> Create New User </span> </a>
		<p id="all_users">
		<table>
		<tr>
		<td> <a href="usersOrderByNickName.html"><span> Sort by nickname </span></a></td> 
		<td> <a href="usersOrderByRegDate.html"> <span> Sort by regdate </span></a> </td>
		</tr>
		</table>
			<table class="users_table">
			<caption> USERS: </caption>
				<thead>
					<tr>
						<th>Nickname</th>
						<th>Email</th>
						<th>Password</th>
						<th>Registration Date</th>
					</tr>
				</thead>
				<c:forEach var="registeredOne" items="${allUsers}">
					<tr>
						<td><a href="user/info/${registeredOne.getUserId()}.html">${registeredOne.getNickName()} </a></td>
						<td>${registeredOne.getEmail()} </td>
						<td>${registeredOne.getPassword()} </td>
						<td>${registeredOne.getRegDate()} </td>
						<td> <a href="user/edit/${registeredOne.getUserId()}.html"> edit</a> </td>
						<td> <a href="user/delete/${registeredOne.getUserId()}.html"> delete</a></td>						
					</tr>
				</c:forEach>
			</table>


		</div>	

</body>
</html>