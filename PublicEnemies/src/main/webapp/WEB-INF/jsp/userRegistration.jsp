<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/smoothness/jquery-ui-1.8.18.custom.css"
	rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.imagemapster.js"></script>
<script language="javascript" src="js/regular.js"></script>
<title>Registration</title>
<link rel="stylesheet" href="css/userRegistration.css" type="text/css">
</head>
<body>
	<table align="center">
		<tr>
			<td><img src="img/gamelogo.png"></img></td>
		</tr>
		<tr>
			<td>
				<table class="sample" align="center" width="300">

					<tr align="center" height="200">
						<td><form:form action="userRegistration.html" method="post"
								commandName="userDto">
								<h1 align="center">REGISTER</h1>
								<h2 align="center">Login</h2>
								<form:input type="text" name="email" path="email" />
								<div id="email_error">
								</div>
								<br />
								<font color="red"><form:errors path="email" /> </font>
								<br />
								<h2 align="center">Password</h2>
								<form:input type="password" name="password" path="password" />
								<div id="password_error">
								</div>
								<br />
								<font color="red"> <form:errors path="password" />
								</font>
								<br />
								<br />
								<button type="submit" class="button" id="button">Register</button>
							</form:form></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>