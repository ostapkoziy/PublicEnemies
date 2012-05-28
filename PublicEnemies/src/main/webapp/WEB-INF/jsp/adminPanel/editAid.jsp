<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Aid</title>
</head>
<body>
	<h2>Edit Aid</h2>

	<form method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input name="aName" type="text" value="${aid.getAidName()}"/></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><input name="aType" type="text" value="${aid.getAidType()}" /></td>
			</tr>
			<tr>
				<td>Effect:</td>
				<td><input name="aEffect" type="text" value="${aid.getAidEffect()}" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input name="aPrice" type="text" value="${aid.getAidPrice()}"/></td>
			</tr>
			<tr>
				<td>Picture(Path):</td>
				<td><input name="aPicturePath" type="text" value="${aid.getAidPicture()}" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input name="aDescription" type="text" value="${aid.getItemDescription()}"/></td>
			</tr>
		</table>
		<input name="aidId" type="hidden" value="${aid.getAidId()}">
		<input type="submit" value="Edit" />
	</form>
</body>
</html>