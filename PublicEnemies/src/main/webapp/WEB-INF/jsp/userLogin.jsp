<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/userLogin.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<!-- <script language="javascript" src="js/regular.js"></script> -->
<title>Public Enemies login</title>
</head>
<body>
	<table align="center">
		<tr>
			<td align="center"><img src="img/gamelogo.png"></img></td>
		</tr>
		<tr>
			<td>
				<div id="tableContainer">
					<table class="sample" align="center" width="300">
						<tr>
							<td align="center"></td>
						</tr>
						<tr align="center" height="200">
							<td><form:form action="userLogin.html" method="post"
									commandName="user">
									<h2 align="center">Login</h2>
									<form:input type="text" path="email" />
									<div id="email_error"></div>
									<font color="red"><br /><form:errors path="email" /><br /></font>
									<h2 align="center">Password</h2>
									<form:input type="password" path="password" />
									<div id="password_error"></div>
									<font color="red"><br /> <form:errors path="password" />
										<br /></font>
									<br />
									<button type="submit" id="button">Log in</button>
								</form:form></td>
						</tr>
						<tr>
							<td align="center"><a href="userRegistration.html">Register</a></td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
