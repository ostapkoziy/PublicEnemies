<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create New User</title>
<script type="text/javascript"
	src="/PublicEnemies/js/adminpanel/validator.js"></script>
<!--  !add to others edit pagers! -->
<script type='text/javascript'>
	function formValidator() {
		// Make quick references to our fields
		var nickname = document.getElementById('nickname');
		var email = document.getElementById('email');
		var password = document.getElementById('pass');
		var avatar = document.getElementById('avatar');
		var money = document.getElementById('money');
		
		// Check each input in the order that it appears in the form!
		if (emailValidator(email, "Please enter a valid email address")) {
			if (isNumeric(money, "Please enter a valid money value")) {
				if (isPath(avatar,
				"Please enter valid path to avatar")) {
					if (isAlphanumeric(nickname,
						"Please enter only letters for your nickname")) {
						if (lengthRestriction(nickname, 6, 20)) {
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
	<jsp:include page="leftMenuDiv.jsp"></jsp:include>
	<div class="summary_div">
		<h2>Create new user</h2>
		<form method="post" action="" id="uform" name="uform">
			<table>
				<tr>
					<td>Email:</td>
					<td><input name="email" type="text" id="email" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input name="pass" type="text" id="pass" /></td>
				</tr>
				<tr>
					<td>Role:</td>
					<td><select name="role">
							<option value="user">user</option>
							<option value="admin">admin</option>
					</select></td>
				</tr>
				<tr>
					<td>Money</td>
					<td><input name="money" type="text" id="money" /></td>
				</tr>
				<tr>
					<td>Avatar:</td>
					<td><input name="avatar" type="text" id="avatar" /></td>
				</tr>
				<tr>
					<td>NickName</td>
					<td><input name="nickname" type="text" id="nickname" /></td>
				</tr>
			</table>
		</form>
		<input type="button" name="submit" value="Create"
			onClick="formValidator()" />
	</div>
</body>
</html>