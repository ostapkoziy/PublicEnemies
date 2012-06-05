<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit profile</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/proffession.js"></script>
<link rel="stylesheet" href="css/profile.css" type="text/css">

<script type="text/javascript">
$(document).ready(function(){
	$("#profession_input").val("1");
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
									<p>Nickname:</p>
									<input type="text" name="nickName" value="${profile.getNickName()}"><br />
									<font color="red">${status.errorMessage}</font>
									<br />
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
									<p>Gender:</p>
									<select id="gender_select">
										<option id="male">male</option>
										<option id="female">female</option>
									</select>
									<input id="gender_input"  type="text" name="sex" value="${profile.isSex()}"><br />
									<font color="red">${status.errorMessage}</font>
									<br />
								<p>Proffesion:</p>
								<select id="profession_select">
										<option id="1">Butcher</option>
										<option id="2">Gangster</option>
										<option id="3">Criminal</option>
									</select>
									<!-- *********EDIT BY ALEXANDER******************** -->
									<div id="proffessionAvatar">
										<div id="profImg" style="width: 200px;height: 250px; background: url('img/avatars/butcher.png');"></div>
									</div>
									<!--*********************** -->
									<input id="profession_input"  type="text" name="profession" value="${profile.getCharacterProfession().getProfessionName()}"><br />
									<font color="red">${status.errorMessage}</font>
									<br />
								<button type="submit" class="button">Save</button>
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
		 $(this).css("outline", "5px solid #ccc");
		 src = "img/avatars/" + this.title + ".png";
		 $("input#avatar_input").val(src);
		 selected_name = this.title;
		 $("img.image_select").each(function(indx, element){
			if(element.title != selected_name){
				$(element).css("outline", "0px solid #ccc");
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
		var profession = $("#profession_select option:selected").attr("id");
		$("input#profession_input").val(profession);
	});
</script>	 
</body>
</html>