<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/smoothness/jquery-ui-1.8.18.custom.css"
	rel="stylesheet" />
<style type="text/css">
body {
	background-image: url(img/bg_city.png);
	color: white;
	font-family: 'impact';
	font-size: 14pt;
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
	filter: alpha(opacity =                 60);
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
</style>
<title>Public Enemies login</title>
</head>
<body>
	<table align="center">
		<tr>
			<td align="center"><img src="img/gamelogo.png"></img></td>
		</tr>
		<tr>
			<table class="sample" align="center" width="300">
				<tr>
					<td align="center"></td>
				</tr>
				<tr align="center" height="200">
					<td><form:form action="userLogin.html" method="post"
							commandName="userDto">
							<h2 align="center">Login</h2>
							<form:input path="email" />

							<font color="red"><br /> <form:errors path="email" /> <br /></font>
							<h2 align="center">Password</h2>
							<form:input type="password" path="password"  />

							<font color="red"><br /> <form:errors path="password" />
								<br /></font>
							<br />
							<br />
							<button type="submit" id="button">Log in</button>
						</form:form></td>
				</tr>
				<tr>
					<td align="center"><a href="userRegistration.html">Register</a></td>
				</tr>
			</table>
		</tr>
	</table>
</body>
</html>
