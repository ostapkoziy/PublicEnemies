<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../../../css/adminpanel/commonstyle.css" rel="stylesheet"
	type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail Aid Info</title>
</head>
<body>
	<h2>Detail Aid Info</h2>

	<table>
		<tr>
			<td>Name:</td>
			<td>${aid.getAidName()}</td>
		</tr>
		<tr>
			<td>Type:</td>
			<td>${aid.getAidType()}</td>
		</tr>
		<tr>
			<td>Effect:</td>
			<td>${aid.getAidEffect()}</td>
		</tr>
		<tr>
			<td>Price:</td>
			<td>${aid.getAidPrice()}</td>
		</tr>
		<tr>
			<td>Picture(Path):</td>
			<td>${aid.getAidPicture()}</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>${aid.getItemDescription()}</td>
		</tr>
	</table>
</body>
</html>