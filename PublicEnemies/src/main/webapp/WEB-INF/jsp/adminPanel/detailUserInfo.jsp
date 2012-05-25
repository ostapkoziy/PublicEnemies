<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../../../css/adminpanel/commonstyle.css" rel="stylesheet"
	type="text/css">
<title>Detail User Info</title>
</head>
<body>
	<h2>${profile.getNickName()}(id = ${profile.getUserId()})</h2>

	<table>
		<tr>
			<td colspan="3"><strong>User</strong></td>			
		</tr>
		<tr>
			<td rowspan="6"> <img style="clear: left;" class="item_picture" src="../../../${profile.getAvatar() }" alt="User's avatar" title="User's avatar" /> </td>
			<td>ID:</td>
			<td>${profile.getUserId()}</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td>${profile.getEmail()}</td>
		</tr>
		<tr>
			<td>Password:</td>
			<td>no way</td>
		</tr>
		<tr>
			<td>Nickname:</td>
			<td>${profile.getNickName()}</td>
		</tr>
		<tr>
			<td>Avatar (path):</td>
			<td>${profile.getAvatar()}</td>
		</tr>
		<tr>
			<td>Money:</td>
			<td>${profile.getMoney()}</td>
		</tr>
		<tr>
			<td colspan="3"><strong>PublicEmemies</strong></td>			
		</tr>
		<tr>
			<td rowspan="10"><img class="item_picture" src="../../../${profile.getAvatar() }" alt="User's avatar" title="User's avatar" />
			<td>Character ID:</td>
			<td>${profile.getProfileId()}</td>
		</tr>
		<tr>
			<td>Sex (true==male):</td>
			<td>${profile.getProfileId()}</td>
		</tr>
		<tr>
			<td>Experience:</td>
			<td>${profile.getExperience()}</td>
		</tr>
		<tr>
			<td>Strength:</td>
			<td>${profile.getStrength()}</td>
		</tr>
		<tr>
			<td>Agility:</td>
			<td>${profile.getAgility()}</td>
		</tr>
		<tr>
			<td>Intellect:</td>
			<td>${profile.getIntellect()}</td>
		</tr>
		<tr>
			<td>Profession:</td>
			<td>${profile.getProfession()}</td>
		</tr>
		<tr>
			<td>Profession avatar (path):</td>
			<td>TODO: path to profession avatar</td>
		</tr>
		<tr>
			<td>Total fights:</td>
			<td>${profile.getFightsTotal()}</td>
		</tr>
		<tr>
			<td>Won fights:</td>
			<td>${profile.getFightsWon()}</td>
		</tr>
		<tr>
			<td colspan="3">Inventory</td>
		</tr>
		<tr>
			<td colspan="3"><em>Weapons</em></td>
		</tr>
		
		<tr>
			<td colspan="3"><em>Armors</em></td>
		</tr>
		
		<tr>
			<td colspan="3"><em>Aids</em></td>
		</tr>
				
	</table>

	TODO: Dressed items, undressed items
</body>
</html>