<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create New Aid</title>
</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	<div class="summary_div">
		<h2>Create New Weapon</h2>
		<form method="post">
			<table>
				<tr>
					<td>Name:</td>
					<td><input name="wName" type="text" /></td>
				</tr>
				<tr>
					<td>Hit points:</td>
					<td><input name="wHP" type="text" /></td>
				</tr>
				<tr>
					<td>Type:</td>
					<td><input name="wType" type="text" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input name="wPrice" type="text" /></td>
				</tr>
				<tr>
					<td>Picture(Path):</td>
					<td><input name="wPicturePath" type="text" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input name="wDescription" type="text" /></td>
				</tr>
			</table>
			<input type="submit" value="Add" />
		</form>
	</div>
</body>
</html>