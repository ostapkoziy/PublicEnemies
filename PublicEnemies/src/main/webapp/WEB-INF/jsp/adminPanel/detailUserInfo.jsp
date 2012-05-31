<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../../../css/adminpanel/commonstyle.css" rel="stylesheet"
	type="text/css">
<title>Detail User Info</title>
</head>
<body>	
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
			<td>${profile.isSex()}</td>
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
			<td>${profile.getCharacterProfession().getProfessionName()}</td>
		</tr>
		<tr>
			<td>Profession avatar (path):</td>
			<td>${profile.getCharacterPrfession().getProfessionAvatar()}</td>
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
		<c:if test="${profile.getDresedWeapons().size() != 0}">
			<c:forEach items="${profile.getDresedWeapons()}" var="dressedWeapon" >
				<tr>
					<td rowspan="5"> <img src="../../../${dressedWeapon.getWeaponPicture()}" alt="Weapon picture"
											title="Weapon picture"/> 
					</td>
					<td> Weapon ID: </td> <td> <c:out value="${dressedWeapon.getWeaponId()}"/></td>
				</tr>				
				<tr>
					<td> Weapon Name: </td> <td> <c:out value="${dressedWeapon.getWeaponName()}"/></td>
				</tr>
				<tr>
					<td> Hit Points: </td> <td> <c:out value="${dressedWeapon.getHitPoints()}"/></td>
				</tr>
				<tr>
					<td> Firearm: </td> <td> <c:out value="${dressedWeapon.isWeaponType()}"/></td>
				</tr>
				<tr>
					<td> Dressed: </td> <td> Yes </td>
				</tr>				
			</c:forEach>		
		</c:if>
		
		<c:if test="${profile.getUndresedWeapons().size() != 0}">
			<c:forEach items="${profile.getUndresedWeapons()}" var="undressedWeapon" >
				<tr>
					<td rowspan="5"> <img src="../../../${undressedWeapon.getWeaponPicture()}" alt="Weapon picture"
											title="Weapon picture"/> 
					</td>
					<td> Weapon ID: </td> <td> <c:out value="${undressedWeapon.getWeaponId()}"/></td>
				</tr>				
				<tr>
					<td> Weapon Name: </td> <td> <c:out value="${undressedWeapon.getWeaponName()}"/></td>
				</tr>
				<tr>
					<td> Hit Points: </td> <td> <c:out value="${undressedWeapon.getHitPoints()}"/></td>
				</tr>
				<tr>
					<td> Firearm: </td> <td> <c:out value="${undressedWeapon.isWeaponType()}"/></td>
				</tr>
				<tr>
					<td> Dressed: </td> <td> No </td>
				</tr>									
			</c:forEach>
		</c:if>
		
		<tr>
			<td colspan="3"><em>Armors</em></td>
		</tr>
		
		<c:if test="${profile.getDressedArmors().size() != 0}">
			<c:forEach items="${profile.getDressedArmors()}" var="dressedArmor" >
				<tr>
					<td rowspan="3"> <img src="../../../${dressedArmor.getArmorPicture()}" alt="Armor picture"
											title="Armor picture"/> 
					</td>
					<td> Armor ID: </td> <td> <c:out value="${dressedArmor.getArmorId()}"/></td>
				</tr>				
				<tr>
					<td> Armor Name: </td> <td> <c:out value="${dressedArmor.getArmorName()}"/></td>
				</tr>
				
				<tr>
					<td> Dressed: </td> <td> Yes </td>
				</tr>				
			</c:forEach>		
		</c:if>
		
		<c:if test="${profile.getUndressedArmors().size() != 0}">
			<c:forEach items="${profile.getUndressedArmors()}" var="undressedArmor" >
				<tr>
					<td rowspan="3"> <img src="../../../${undressedArmor.getArmorPicture()}" alt="Armor picture"
											title="Armor picture"/> 
					</td>
					<td> Armor ID: </td> <td> <c:out value="${undressedArmor.getArmorId()}"/></td>
				</tr>				
				<tr>
					<td> Armor Name: </td> <td> <c:out value="${undressedArmor.getArmorName()}"/></td>
				</tr>
				
				<tr>
					<td> Dressed: </td> <td> No </td>
				</tr>									
			</c:forEach>
		</c:if>
		
		
		<tr>
			<td colspan="3"><em>Aids</em></td>
		</tr>
		
		<c:if test="${profile.getDressedAids().size() != 0}">
			<c:forEach items="${profile.getDressedAids()}" var="dressedAid" >
				<tr>
					<td rowspan="3"> <img src="../../../${dressedAid.getAidPicture()}" alt="Aid picture"
											title="Aid picture"/> 
					</td>
					<td> Aid ID: </td> <td> <c:out value="${dressedAid.getAidId()}"/></td>
				</tr>				
				<tr>
					<td> Aid Name: </td> <td> <c:out value="${dressedArmor.getAidName()}"/></td>
				</tr>
				
				<tr>
					<td> Dressed: </td> <td> Yes </td>
				</tr>				
			</c:forEach>		
		</c:if>
		
		<c:if test="${profile.getUndressedAids().size() != 0}">
			<c:forEach items="${profile.getUndressedAids()}" var="undressedAid" >
				<tr>
					<td rowspan="3"> <img src="../../../${undressedAid.getAidPicture()}" alt="Aid picture"
											title="Aid picture"/> 
					</td>
					<td> Aid ID: </td> <td> <c:out value="${undressedAid.getAidId()}"/></td>
				</tr>				
				<tr>
					<td> Aid Name: </td> <td> <c:out value="${undressedAid.getAidName()}"/></td>
				</tr>
				
				<tr>
					<td> Dressed: </td> <td> No </td>
				</tr>									
			</c:forEach>
		</c:if>
				
	</table>
</body>
</html>