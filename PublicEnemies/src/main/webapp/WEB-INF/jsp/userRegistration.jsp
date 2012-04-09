<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/smoothness/jquery-ui-1.8.18.custom.css"
	rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Public Enemies login</title>
<script type="text/javascript">
	$(function() {
		// Button
		$("#button").button();
		$("#radioset").buttonset();
	});
</script>

<style type="text/css">
button {
	height: 20px;
	width: 40px;
}

p {
	margin-left: 120px;
	margin-bottom: 50px
}

tr {
	color: black;
}

#ex5 {
	width: 700px;
	margin: 0 auto;
	min-height: 300px;
}

.shine {
	margin-bottom: 10px;
	opacity: 0.8;
	/*transition*/
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	/
	*ⴤ娥𪠫殭
	??
	-webkit-box-reflect
	:
	below
	0px
	-webkit-gradient(
	linear
	,
	left
	top
	,
	left
	bottom
	,
	from(
	transparent
	)
	,
	color-stop(
	.7
	,
	transparent
	)
	,
	to(
	rgba(
	0
	,
	0
	,
	0
	,
	0.1
	)
	)
	);
}

.shine:hover {
	opacity: 1; / *ⴤ娥𪠫殭 ?? -webkit-box-reflect : below 0px
	-webkit-gradient( linear, left top, left bottom, from( transparent),
	color-stop( .7, transparent), to( rgba( 0, 0, 0, 0.4))); / *񢳲ԭ /
	-webkit-box-shadow : 0px 0px 20px rgba( 255, 255, 255, 0.8);
	-moz-box-shadow: 0px 0px 20px rgba(255, 255, 255, 0.8);
	box-shadow: 0px 0px 20px rgba(255, 255, 255, 0.8);
}
</style>
</head>
<body>
	<table>
		<tr>
			<td><img src="img/up_bar.png"></img></td>
		</tr>
		<tr>
			<td align="center">
				<form action="userRegistration.html" method="post">
					<spring:bind path="userToRegister.email">
						<p>Login</p>
						<input type="text" name="email" value="${status.value}">
						<font color="red">${status.errorMessage}</font>
						<br />
					</spring:bind>
					<spring:bind path="userToRegister.password">

						<p>Password</p>
						<input type="password" name="password" ${status.value}>

						<font color="red">${status.errorMessage}</font>
						<br />
					</spring:bind>
					<button type="submit" class="button">Login</button>
				</form>
			</td>
		</tr>
	</table>

</body>
</html>