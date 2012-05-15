<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shop</title>
<style type="text/css">
body {
	background-image: url('img/bg_city.png');
}

h2 {
	color: black;
	font-family: 'impact';
	font-size: 20pt;
}

button {
	font-family: 'impact';
	font-size: 20px;
	width: 100px;
	height: 44px;
}

table.sample {
	margin-top: 100px;
	background-color: #444D48;
	opacity: .6;
	filter: alpha(opacity =   60);
	-moz-opacity: .6;
	border-width: 3px;
	border-spacing: 5px;
	border-style: outset;
	border-color: white;
	border-collapse: separate;
}

table.sample th {
	border-width: 0px;
	padding: 3px;
	border-style: none;
	border-color: gray;
	-moz-border-radius:;
}

table.sample td {
	border-width: 0px;
	padding: 3px;
	border-style: none;
	border-color: gray;
	-moz-border-radius:;
}

A:link {
	text-decoration: underline;
	color: white;
	font-size: 20pt;
}

A:visited {
	text-decoration: underline;
	color: white;
	font-size: 20pt;
}

A:active {
	text-decoration: underline;
	color: white;
	font-size: 20pt;
}

A:hover {
	text-decoration: underline;
	color: white;
	font-size: 20pt;
}

a {
	color: black;
	font-family: 'impact';
	font-size: 20pt;
}

body {
	background-image: url(img/bg_city.png);
	color: white;
}

h1 {
	font-family: 'impact';
	font-size: 20pt;
	color: red;
}
</style>

</head>


<body>
<h2> USER ID = ${uid} </h2>

<table>
<c:set var="aids" value="${aidsList}" />
<caption> AIDS </caption>
<tr>
<td>ID</td>
<td>NAME</td>
<td>TYPE</td>
<td>EFFECT</td>
<td>PICTURE</td>
<td>PRICE</td>
</tr>
 <c:forEach items="${aids}" var="aid">
      <tr>
         <td><c:out value="${aid.getItemId()}"/> </td>
         <td><c:out value="${aid.getItemName()}"/> </td>
         <td><c:out value="${aid.getAidType()}"/> </td>
         <td><c:out value="${aid.getAidEffect()}"/> </td>
         <td><c:out value="${aid.getItemPicture()}"/> </td>
         <td><c:out value="${aid.getItemPrice()}"/> </td>
      </tr>
  </c:forEach>
</table>

<br />


	<table>
		<tr>
			<td> Hello form shop</td>
		</tr>
	</table>
</body>
</html>