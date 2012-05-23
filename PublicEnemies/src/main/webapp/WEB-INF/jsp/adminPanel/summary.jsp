<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../css/adminpanel/commonstyle.css" rel="stylesheet"
	type="text/css">

<title>Admin Panel</title>

</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>

	<div id="summary_div">
		SUMMARY:
		<p id="amount_of_users">Amount of registered users:
			${amountOfUsers}</p>
			
		<p id="last_registered">
			<table class="users_table">
			<caption> The 5 Latest Registered Users </caption>
				<thead>
					<tr>
						<th>Nickname</th>
						<th>Email</th>
						<th>Password</th>
						<th>Registration Date</th>
					</tr>
				</thead>
				<c:forEach var="registeredOne" items="${lastRegistered}">
					<tr>
						<td><a href="user/info/${registeredOne.getUserId()}.html">${registeredOne.getNickName()} </a></td>
						<td>${registeredOne.getEmail()} </td>
						<td>${registeredOne.getPassword()} </td>
						<td> regDate </td>
						<td> <a href="user/edit/${registeredOne.getUserId()}.html"> edit</a> </td>
						<td> <a href="user/delete/${registeredOne.getUserId()}.html"> delete</a></td>
						
					</tr>
				</c:forEach>
			</table>


		</div>



	</p>
</body>

</html>