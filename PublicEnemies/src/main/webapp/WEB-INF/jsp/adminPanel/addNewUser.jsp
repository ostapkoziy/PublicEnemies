<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create new user</title>
</head>
<body>
	<h2> Create new user </h2>
	<form method="post">
	<table>
	<tr>
	<td> Email: </td> <td> <input name="email" type="text" /></td> 
	</tr>
	<tr>
	<td> Password: </td> <td> <input name="pass" type="text" /> </td> 
	</tr>
	<tr> 
	<td> Money </td> <td> <input name="money" type="text" /> </td>
	</tr>
	<tr> 
	<td> Avatar: </td> <td> <input name="avatar" type="text" /> </td>
	</tr>
	<tr> 
	<td> NickName</td> <td> <input name="nickname" type="text" /> </td>
	</tr>
	</table>
	<input type="submit" value="Add" />
	</form>
</body>
</html>