<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/adminpanel/commonstyle.css" type="text/css">
<title>Admin Login Page</title>
</head>
<body>
	<table align="center" style="margin-top: 300px" id="superSecretTable">
		<tr>
			<td>
				<div class="admin_header">
					<img class="admin_logo" src="/PublicEnemies/img/adminpanel/ap_logo.png" alt="AdminPanel logo" title="AdminPanel"/>
					<span id="adm_panel_words">Admin panel </span>
				</div>
			</td>
		</tr>
		<tr>
			<td height="150">
				<form action="" method="post">
					<input type="text" name="adminEmail"> <br /> <input
						type="password" name="adminPass"> <br /> <input
						type="submit" value="Login">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>