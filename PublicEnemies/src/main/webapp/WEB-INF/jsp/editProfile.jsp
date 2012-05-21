<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit profile</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<style type="text/css">
body {
	background-image: url(img/bg_city.png);
	color: white;
	font-family: 'impact';
	font-size: 14pt;
}

h2 {
	color: black;
	font-family: 'impact';
	font-size: 20pt;
}

button {
	font-family: 'impact';
	font-size: 20px;
	width: 140px;
	height: 64px;
}

table.sample {
	margin-top: 100px;
	background-color: #444D48;
	opacity: .6;
	filter: alpha(opacity = 60);
	-moz-opacity: .6;
	border-width: 3px;
	border-spacing: 5px;
	border-style: outset;
	border-color: white;
	border-collapse: separate;
}

table.sample th {
	border-width: 0px;
	padding: 3px;
	border-style: none;
	border-color: gray;
	-moz-border-radius:;
}

table.sample td {
	border-width: 0px;
	padding: 3px;
	border-style: none;
	border-color: gray;
	-moz-border-radius:;
}

A:link {
	text-decoration: underline;
	color: white;
	font-size: 20pt;
}

A:visited {
	text-decoration: underline;
	color: white;
	font-size: 20pt;
}

A:active {
	text-decoration: underline;
	color: white;
	font-size: 20pt;
}

A:hover {
	text-decoration: underline;
	color: white;
	font-size: 20pt;
}

a {
	color: black;
	font-family: 'impact';
	font-size: 20pt;
}

img.image_select{
    border: 2px solid #ccc;
    float: left;
    margin: 10px;
    margin-left : 20px;
    -webkit-transition: margin 0.5s ease-out;
    -moz-transition: margin 0.5s ease-out;
    -o-transition: margin 0.5s ease-out;
}

img.image_select:hover {
    margin-top: 2px;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("input#avatar_input").hide();
	$("input#gender_input").hide();
	$("input#profession_input").hide();

});
</script>
</head>
<body>
	<table align="center">
		<tr>
			<td align="center"><img src="img/gamelogo.png"></img></td>
		</tr>
		<tr>
			<td align="center">
				<table class="sample" width="400px">
					<tr>
						<td align="center">
							<form action="editProfile.html" method="post">
								<spring:bind path="profileToEdit.nickName"> 
									<p>Nickname:</p>
									<input type="text" name="nickName" value="${profile.getNickName()}"><br />
									<font color="red">${status.errorMessage}</font>
									<br />
								</spring:bind>
								<spring:bind path="profileToEdit.avatar">
									<p>Avatar:</p>
									<div>
										<img class="image_select" title="angelina" width="40" src="img/avatars/angelina.png"></img>
										<img class="image_select" title="gangster" width="40" src="img/avatars/gangster.png"></img>
										<img class="image_select" title="godfather" width="40" src="img/avatars/godfather.png"></img>
										<img class="image_select" title="tommy" width="40" src="img/avatars/tommy.png"></img>
										<img class="image_select" title="mafia" width="40" src="img/avatars/mafia.png"></img>
									</div>
									<br/>
									<br/>
									<input id="avatar_input" type="text" name="avatar" value="${profile.getAvatar()}"><br />
									<font color="red">${status.errorMessage}</font>
									<br />
								</spring:bind>
								<spring:bind path="profileToEdit.sex">
									<p>Gender:</p>
									<select id="gender_select">
										<option id="male">male</option>
										<option id="female">female</option>
									</select>
									<input id="gender_input"  type="text" name="sex" value="${profile.isSex()}"><br />
									<font color="red">${status.errorMessage}</font>
									<br />
								</spring:bind>
								<spring:bind path="profileToSave.proffesion">									
								<p>Proffesion:</p>
								<select id="profession_select">
										<option>Butcher</option>
										<option>Gangster</option>
										<option>Criminal</option>
										<option>Thief</option>
										<option>Assassin</option>
										<option>Professor</option>
									</select>
									<input id="profession_input"  type="text" name="profession" value="${profile.getProfession()}"><br />
									<font color="red">${status.errorMessage}</font>
									<br />
								</spring:bind>
								<button type="submit" class="button">Save profile!</button>
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
<script type="text/javascript">
	var selected_name;
	var src;
	$("img.image_select").click(function(){
		 $(this).css("border", "5px solid #ccc");
		 src = "img/avatars/" + this.title + ".png";
		 $("input#avatar_input").val(src);
		 selected_name = this.title;
		 $("img.image_select").each(function(indx, element){
			if(element.title != selected_name){
				$(element).css("border", "2px solid #ccc");
			}
		});
	});
	
	$("#gender_select").click(function(){
		var sex = $("#gender_select option:selected").val();
		if(sex == "male"){
			sex = true;
		}else{
			sex = false;
		}
		$("input#gender_input").val(sex);
	});
	$("#profession_select").click(function(){
		var profession = $("#profession_select option:selected").val();
		$("input#profession_input").val(profession);
	});
</script>	 
</body>
</html>