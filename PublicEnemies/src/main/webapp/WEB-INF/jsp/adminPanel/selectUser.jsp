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
	<jsp:include page="leftMenuDiv.jsp"></jsp:include>

	<div class="users_div">
		<!-- Button 		<a class="new_entry" style="float: right"
			href="/PublicEnemies/adminPanel/user/add.html"><span
			class="create_new_entry"> Create New User </span> </a>
		<!-- End of Button -->
		<p id="all_users">
		<h3>SELECT USER</h3>
		<form method="post">
			<select name="selected_user">
				<c:forEach var="registeredOne" items="${allUsers}">
					<option value="${registeredOne.getUserId()}">${registeredOne.getNickName()}</option>
				</c:forEach>
			</select>
			<p>
			<input type="submit" value="select" />
			</p>
		</form>
	</div>
</body>
</html>