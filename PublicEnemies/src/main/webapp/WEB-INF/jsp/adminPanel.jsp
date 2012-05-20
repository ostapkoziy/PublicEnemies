<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Panel</title>

<style type="text/css">
span#users_area, 
span#weapons_area, 
span#armors_area, 
span#aids_area {
	display: inline-block;
	border-width: 2px; 
	border-style: solid;
	border-radius: 15px;
	padding: 5px;	 
}
span#users_area:hover, 
span#weapons_area:hover, 
span#armors_area:hover, 
span#aids_area:hover {
	background:#DDDDDD 
}
a.div_link {
	text-decoration: none;
	color:black; 	
}
</style>

</head>
<body>
	<a class="div_link" href=""> 
	<h1>Admin panel</h1>
	</a>
<a class="div_link" href="#">
	<span id="users_area"> USERS </span>
</a>
<a class="div_link" href="#">
<span id="weapons_area"> WEAPONS </span>
</a>
<a class="div_link" href="#">
<span id="armors_area"> ARMORS </span>
</a>
<a class="div_link" href="#">
<span id="aids_area"> AIDS </span>
</a>
<div> Value is ${passedValue}</div>
</body>
</html>