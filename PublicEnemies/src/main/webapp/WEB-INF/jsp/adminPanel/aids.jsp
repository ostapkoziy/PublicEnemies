<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/PublicEnemies/css/adminpanel/commonstyle.css"
	rel="stylesheet" type="text/css">

<title>Aids</title>

</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>

	<div class="aids_div">
		<a class="new_entry" style="float:right" href="/PublicEnemies/adminPanel/aid/add.html"><span
			class="create_new_entry"> Create New Aid </span> </a>
		<p>
		<table class="aids_table">
			<caption>AIDS:</caption>
			<thead>
				<tr>
					<th>Name</th>
					<th>Type</th>
					<th>Effect</th>
					<th>Picture (path)</th>
					<th>Price</th>
					<th>Actions</th>
				</tr>
			</thead>
			<c:forEach var="aid" items="${aids}">
				<tr>
					<td><a href="aid/info/${aid.getAidId()}.html">${aid.getAidName()}
					</a></td>
					<td>${aid.getAidType()}</td>
					<td>${aid.getAidEffect()}</td>
					<td>${aid.getAidPicture()}</td>
					<td>${aid.getAidPrice()}</td>
					<td><a href="aid/edit/${aid.getAidId()}.html"> edit</a></td>
					<!-- td><a href="aid/delete/${aid.getAidId()}.html"> delete</a></td>  -->
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>