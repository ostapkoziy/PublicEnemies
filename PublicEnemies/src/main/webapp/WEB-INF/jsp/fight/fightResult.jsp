<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fight Result</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<link href="css/fight/result.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="result">
		<div id="color"></div>
		<div id="color1"></div>
		<div id="color2"></div>
		<div id="color3">
			<div id="imageWrapper">
				<c:choose>
					<c:when test="${win==true}">
						<link href="css/fight/winnerB.css" rel="stylesheet" type="text/css">
					</c:when>
					<c:otherwise>
						<link href="css/fight/loserB.css" rel="stylesheet" type="text/css">
					</c:otherwise>
				</c:choose>
				<div id="expirience"></div>
			</div>
		</div>
	</div>

</body>
</html>