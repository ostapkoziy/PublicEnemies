<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create New Armor</title>
</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	<jsp:include page="leftMenuDiv.jsp"></jsp:include>
	<div class="summary_div">
		<h2>Create New Armor</h2>
		<form method="post">
			<table>
				<tr>
					<td>Name:</td>
					<td><input name="aName" type="text" /></td>
				</tr>
				<tr>
					<td>Protection:</td>
					<td><input name="aProtection" type="text" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input name="aPrice" type="text" /></td>
				</tr>
				<tr>
					<td>Picture(Path):</td>
					<td><input name="aPicturePath" type="text" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input name="aDescription" type="text" /></td>
				</tr>
			</table>
			<input type="submit" value="Add" />
		</form>
	</div>
</body>
</html>