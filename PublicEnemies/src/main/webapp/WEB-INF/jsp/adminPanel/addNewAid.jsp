<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create New Aid</title>
</head>
<body>
	<h2> Create New Aid </h2>
	<form method="post">
	<table>
	<tr>
	<td> Name: </td> <td> <input name="aName" type="text" /></td> 
	</tr>
	<tr>
	<td> Type: </td> <td> <input name="aType" type="text" /> </td> 
	</tr>	
	<tr>	
	<td> Effect: </td> <td> <input name="aEffect" type="text" /> </td> 
	</tr>	
	<tr>	
	<td> Price: </td> <td> <input name="aPrice" type="text" /> </td>
	</tr>
	<tr> 
	<td> Picture(Path): </td> <td> <input name="aPicturePath" type="text" /> </td>
	</tr>
	<tr> 
	<td> Description: </td> <td> <input name="aDescription" type="text" /> </td>
	</tr>
	</table>
	<input type="submit" value="Add" />
	</form>
</body>
</html>