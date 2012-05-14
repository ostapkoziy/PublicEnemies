<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save profile</title>
<style type="text/css">
body {
	background-image: url(img/bg_city.jpg);
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
	width: 140px;
	height: 64px;
}

table.sample {
	margin-top: 100px;
	background-color: #444D48;
	opacity: .6;
	filter: alpha(opacity = 60);
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
</head>
<body>
	<table align="center">
		<tr>
			<td align="center"><img src="img/gamelogo.jpg"></img></td>
		</tr>
		<tr>
			<td align="center">
				<table class="sample" width="400px">
					<tr>
						<td align="center">
							<form action="profileSave.html" method="post">
								<spring:bind path="profileToSave.nickName">
									<p>Nickname:</p>
									<input type="text" name="nickName" value="${status.value}"><br />
									<font color="red">${status.errorMessage}</font>
									<br />
								</spring:bind>
								<spring:bind path="profileToSave.avatar">
									<p>Avatar:</p>
									<input type="text" name="avatar" value="${status.value}"><br />
									<font color="red">${status.errorMessage}</font>
									<br />
								</spring:bind>
								<spring:bind path="profileToSave.gender">
									<p>Gender:</p>
									<input type="text" name="gender" value="${status.value}"><br />
									<font color="red">${status.errorMessage}</font>
									<br />
								</spring:bind>
								<spring:bind path="profileToSave.proffesion">
									<p>Proffesion:</p>
									<input type="text" name="proffesion" value="${status.value}"><br />
									<font color="red">${status.errorMessage}</font>
									<br />
								</spring:bind>
								<button type="submit" class="button">Save profile!</button>
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>