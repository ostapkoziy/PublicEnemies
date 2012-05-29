<%@ page import="com.epam.publicenemies.domain.fight.Fight"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EDIT USER</title>
</head>
<body>
	<h2> Edit user </h2>
	<form method="post">
	<table>
	<tr>
	<td> Email: </td> <td> <input name="email" type="text" value="${profile.getEmail()}" /></td> 
	</tr>
	<tr>
	<td> Password: </td> <td> <input name="pass" type="text" value="TODO" /> </td> 
	</tr>
	<tr> 
	<td> Money </td> <td> <input name="money" type="text" value="${profile.getMoney()}" /> </td>
	</tr>
	<tr> 
	<td> Avatar: </td> <td> <input name="avatar" type="text" value="${profile.getAvatar()}"/> </td>
	</tr>
	<tr> 
	<td> NickName</td> <td> <input name="nickname" type="text" value="${profile.getNickName()}"/> </td>
	</tr>
	</table>
	<input name="userId" type="hidden" value="${profile.getUserId()}">
	<input name="profileId" type="hidden" value="${profile.getProfileId()}">
	<input type="submit" value="Edit" />
	</form>
</body>
</html>