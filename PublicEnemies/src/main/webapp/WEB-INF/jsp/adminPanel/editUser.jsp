<%@ page import="com.epam.publicenemies.domain.fight.Fight"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EDIT USER</title>
</head>
<body>
	<h2> Edit user </h2>
	TODO: change/create update method in dao
	!EXCEPTION!
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