<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/profile/profilestyle.css" rel="stylesheet"
	type="text/css">

<title>${profile.getNickName()}'s Profile</title>

<script type="text/javascript" src="js/profile/accordian.pack.js"></script>
<script type="text/javascript" src="js/profile/raphael.js"></script>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/profile/pie.js"></script>
<style media="screen">

#holder {   
    margin: 0 0 0 0px;    
}    
</style>

</head>

<body>

	<div class="profile_info">
		<h3>Profile Info</h3>
		<img class="avatar" src="${profile.getAvatar()}" title="Avatar"
			alt="Your profile here" />
		<div class="statistics_list">
			<h3>Basic info:</h3>
			<p>
				<strong> Genger: </strong>				
				<c:choose>
					<c:when test="${profile.isSex() == true}">
						male
					</c:when>
					<c:otherwise>
						female
					</c:otherwise>
				</c:choose>
			</p>
			<p>
				<strong> Email: </strong> ${profile.getEmail()}
			</p>
			<p>
				<strong> Money: </strong> ${profile.getMoney()}
			</p>
			<p>
				<strong> RegDate: </strong> ${profile.getRegDate()}
			</p>
			<p>
				<strong> Profession: </strong> ${profile.getProfession()}
			</p>
			<br />
			<h3>Basic stats:</h3>
			<p>
				<strong> Experience: </strong> ${profile.getExperience()}
			</p>
			<p>
				<strong> Strength: </strong> ${profile.getStrength()}
			</p>
			<p>
				<strong> Agility: </strong> ${profile.getAgility()}
			</p>
			<p>
				<strong> Intellect: </strong> ${profile.getIntellect()}
			</p>
			<br />
			<h3>Actual stats:</h3>
			<p>
				<strong> Strength: </strong> need to calculate
			</p>
			<p>
				<strong> Agility: </strong> need to calculate
			</p>
			<p>
				<strong> Intellect: </strong> need to calculate
			</p>

		</div>
	</div>
	<div class="statistics">
		<h3>Statistics</h3> 
		<br />
		<p>
			<strong> Total Fights: </strong> ${profile.getFightsTotal()}
		</p>
		<p>
			<strong> Won Fights: </strong> ${profile.getFightsWon()}
		</p>
		<div id="holder"></div>        
		<table>
            <tbody>
                <tr>
                    <th scope="row">Won</th>
                    <td>${profile.getFightsWon()}</td>
                </tr>
                <tr>
                    <th scope="row">Loose</th>
                    <td>${profile.getFightsTotal() - profile.getFightsWon()}</td>
                </tr>
            </tbody>
        </table>
        
	</div>
	<div class="inventory">
		<h3>Inventory</h3>
		
		
	</div>
</body>
</html>