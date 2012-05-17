<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/poker.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<!-- <script language="javascript" src="js/regular.js"></script> -->
<title>Poker</title>
</head>
<body>
	<table align="center">
		<tr>
			<td align="center"><img src="img/gamelogo.png"></img></td>
		</tr>
		<tr>
			<table id="poker_table" class="sample" align="center" width="1000" height="667">
				<tr align="center" height="90">
					<td>
						<img style="position:relative; top:90px; left:140px; width:80px; height:80px"  border="2" SRC="img/avatars/default.png">
					</td>
					<td>
						<h4 style="position:relative; top:140px; left:-130px; width:80px; height:80px">1000</h4>
					</td>
				</tr>
				<tr align="center" height="300">
					<td colspan="2">
						DICK
					</td>

				</tr>
				<tr align="center" height="200">
					<td>
						<h4 style="position:relative; top:-130px; left:90px; width:80px; height:80px">${chips}</h4>
					</td>
					<td>
						<img style="position:relative; top:-130px; left:-140px; width:80px; height:80px"  border="2" SRC="${profile.getAvatar()}">
					</td>
				</tr>
			</table>
		</tr>
	</table>
</body>
</html>
