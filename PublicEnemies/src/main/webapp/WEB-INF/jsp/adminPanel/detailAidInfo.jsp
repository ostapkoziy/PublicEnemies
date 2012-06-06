<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail Aid Info</title>
</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	<jsp:include page="leftMenuDiv.jsp"></jsp:include>
	<div class="summary_div">
		<!-- Button -->
		<a class="new_entry" style="float: right"
			href="/PublicEnemies/adminPanel/aid/add.html"><span
			class="create_new_entry"> Create New Aid </span> </a>
		<!-- Button -->
		<h3> [ <a href="/PublicEnemies/adminPanel/aid/edit/${aid.getAidId()}.html">Edit</a> ]</h3>


		<table>
			<tr>
				<td rowspan="6"><img src="../../../${aid.getAidPicture()}" /></td>
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
	</div>
</body>
</html>