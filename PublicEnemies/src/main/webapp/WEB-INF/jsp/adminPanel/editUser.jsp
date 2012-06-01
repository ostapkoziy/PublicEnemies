<%@ page import="com.epam.publicenemies.domain.fight.Fight"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EDIT USER</title>
<script type="text/javascript" src="/PublicEnemies/js/adminpanel/validator.js"></script>

<script type='text/javascript'>
	function formValidator() {
		// Make quick references to our fields
		var nickname = document.getElementById('nickname');
		var email = document.getElementById('email');
		var password = document.getElementById('password');
		var avatar = document.getElementById('avatar');
		var money = document.getElementById('money');
		
		// Check each input in the order that it appears in the form!
		if (isAlphanumeric(nickname,
				"Please enter only letters for your nickname")) {
			if (lengthRestriction(nickname, 6, 20)) {
				if (emailValidator(email, "Please enter a valid email address")) {
					if (isNumeric(money, "Please enter a valid money value")) {
						if (isPath(avatar,
								"Please enter valid path to avatar")) {
							document.forms["uform"].submit();
							return true;
						}
					}
				}
			}
		}
		return false;
	}	
</script>

</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	<div class="summary_div">
		<!-- Button -->
		<a class="new_entry" style="float: right"
			href="/PublicEnemies/adminPanel/user/add.html"><span
			class="create_new_entry"> Create New User </span> </a>
		<!-- End of Button -->
		<h2>Edit user</h2>
		<form action="" method="post" id="uform" name="uform">
			<table>
				<tr>
					<td>NickName</td>
					<td><input name="nickname" type="text" id="nickname"
						value="${profile.getNickName()}" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input name="email" type="text" id="email"
						value="${profile.getEmail()}" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input name="pass" type="text" value="TODO" id="password" /></td>
				</tr>
				<tr>
					<td>Money</td>
					<td><input name="money" type="text" id="money"
						value="${profile.getMoney()}" /></td>
				</tr>
				<tr>
					<td>Avatar:</td>
					<td><input name="avatar" type="text" id="avatar"
						value="${profile.getAvatar()}" /></td>
				</tr>
			</table>
			<input name="userId" type="hidden" value="${profile.getUserId()}">
			<input name="profileId" type="hidden"
				value="${profile.getProfileId()}"> 			 			
		</form>		
		<input class="left" type="button" name="submit" value="Show" 
    			onClick="formValidator()">
	</div>
</body>
</html>