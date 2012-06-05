	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="css/roulette.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Public Enemies Roulette</title>
<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<!-- <script type="text/javascript" src="js/jquery.maphilight.min.js"></script> -->
<!-- <script type="text/javascript" src="js/rouletteMap.js"></script> -->
<!-- <script type="text/javascript" src="js/jquery.imagemapster.js"></script> -->
<!-- <script type="text/javascript" src="js/jquery.metadata.min.js"></script> -->

<!-- <script type="text/javascript" src="js/roulette/hilight.js"></script> -->
<script type="text/javascript" src="js/roulette/roulette.js"></script>

</head>
<body>
<!-- <a href="#" id="maplink1">Hover to highlight the first section</a> -->
	<div id="background"><img src="img/roulette/roulette_foreground.jpg"></div>
	
	<div class="panel" style="height: 120px; margin: 5px">
		<div style="float: left; font-size: 16pt; color:white; font-family:fantasy; ">
			<img width="80" height="80" style="border-radius:10px;" src="${rouletteGameInfo.getUserAvatar()}">
			<c:out value="${rouletteGameInfo.getUserNickname()}"/>
		</div>
		
		<div class="panel" style="width:300px; float: right;">
			<form method="post" action="rouletteRedirectController.html">
				<input id="exit_button" type="submit" value="Leave roulette table">
			</form>
			<div id="betOnTableWrapper">Bet on table: <div style="display: inline;color:lime" id="betOnTable">0</div></div> 
		</div>

		<div style="padding-top: 20px; margin-left: 670px">
			<div id="chipsAmount"><c:out value="${rouletteGameInfo.getChips()} chips" /></div>
			<div id="message"></div>
			<div style=" font-size: 20pt; color:white; font-family:fantasy; font-smooth:large; ">Current BET: 
			<div style="display: inline; color:lime ;" id="showBet">0</div>
			</div>
		</div>
	</div>

	<div class="panel" id="rightPanel">
		<div align="center" style="width: 120px;">
			<img class="chips" id="10" alt="10" src="img/roulette/Chip_10.png" width="80" height="80" style="padding-bottom: 10px">
			<img class="chips" id="25" alt="25"	src="img/roulette/Chip_25.png" width="80" height="80" style="padding-bottom: 10px">
			<img class="chips" id="50" alt="50" src="img/roulette/Chip_50.png" width="80" height="80" style="padding-bottom: 30px">
		</div>
		<input id="clearBet" type="button" value="Clear bets">
	</div>
	


	<div class="panel" id="tableWrapper">
		
		<img id="img_roulette" src="img/roulette/roulette_static.png" width="140" height="140" 
			style="position:absolute; left: 50px; top: 200px;" >
		
		<img id="rouletteTable" class="map" src="img/roulette/table.png" usemap="#rouletteNumbers" border="0" width="730" height="280" 
			style="margin-left:150px; margin-top: 60px; margin-right: 50px;"/>
		<input id="DEAL_button" type="button" value="DEAL!">
		<map class= "tabs" id="rouletteNumbers" name="rouletteNumbers">
			<area href="#" class="RouletteTable" shape="rect" coords="61,0,113,63" alt="3" title="3" group='3'/>
			<area href="#" class="RouletteTable" shape="rect" coords="114,0,163,62" alt="6" title="6" group='6'/>
			<area href="#" class="RouletteTable" shape="rect" coords="167,0,215,62" alt="9" title="9" group='9'/>
			<area href="#" class="RouletteTable" shape="rect" coords="219,0,267,62" alt="12" title="12" group="12" />
			<area href="#" class="RouletteTable" shape="rect" coords="273,0,321,62" alt="15" title="15" group="15" />
			<area href="#" class="RouletteTable" shape="rect" coords="322,0,370,62" alt="18" title="18" group="18" />
			<area href="#" class="RouletteTable" shape="rect" coords="374,0,422,62" alt="21" title="21" group="21" />
			<area href="#" class="RouletteTable" shape="rect" coords="425,0,473,62" alt="24" title="24" group="24" />
			<area href="#" class="RouletteTable" shape="rect" coords="479,1,527,63" alt="27" title="27" group="27" />
			<area href="#" class="RouletteTable" shape="rect" coords="529,1,577,63" alt="30" title="30" group="30" />
			<area href="#" class="RouletteTable" shape="rect" coords="580,1,628,63" alt="33" title="33" group="33" />
			<area href="#" class="RouletteTable" shape="rect" coords="631,1,679,63" alt="36" title="36" group="36" />
			<area href="#" class="RouletteTable" shape="rect" coords="63,65,112,123" alt="2" title="2" group="2" />
			<area href="#" class="RouletteTable" shape="rect" coords="115,65,163,123" alt="5" title="5" group="5" />
			<area href="#" class="RouletteTable" shape="rect" coords="166,66,215,124" alt="8" title="8" group="8" />
			<area href="#" class="RouletteTable" shape="rect" coords="219,66,267,124" alt="11" title="11" group="11" />
			<area href="#" class="RouletteTable" shape="rect" coords="272,65,320,123" alt="14" title="14" group="14" />
			<area href="#" class="RouletteTable" shape="rect" coords="323,65,371,123" alt="17" title="17" group="17" />
			<area href="#" class="RouletteTable" shape="rect" coords="372,65,422,124" alt="20" title="20" group="20" />
			<area href="#" class="RouletteTable" shape="rect" coords="424,65,474,123" alt="23" title="23" group="23" />
			<area href="#" class="RouletteTable" shape="rect" coords="477,65,527,123" alt="26" title="26" group="26" />
			<area href="#" class="RouletteTable" shape="rect" coords="528,66,578,124" alt="29" title="29" group="29" />
			<area href="#" class="RouletteTable" shape="rect" coords="579,66,629,124" alt="32" title="32" group="32" />
			<area href="#" class="RouletteTable" shape="rect" coords="632,66,682,124" alt="35" title="35" group="35" />
			<area href="#" class="RouletteTable" shape="rect" coords="63,126,112,184" alt="1" title="1" group="1" />
			<area href="#" class="RouletteTable" shape="rect" coords="114,126,162,184" alt="4" title="4" group="4" />
			<area href="#" class="RouletteTable" shape="rect" coords="167,127,216,185" alt="7" title="7" group="7" />
			<area href="#" class="RouletteTable" shape="rect" coords="218,126,266,184" alt="10" title="10" group="10" />
			<area href="#" class="RouletteTable" shape="rect" coords="272,126,320,184" alt="13" title="13" group="13" />
			<area href="#" class="RouletteTable" shape="rect" coords="322,127,370,185" alt="16" title="16" group="16" />
			<area href="#" class="RouletteTable" shape="rect" coords="373,126,423,184" alt="19" title="19" group="19" />
			<area href="#" class="RouletteTable" shape="rect" coords="425,126,475,184" alt="22" title="22" group="22" />
			<area href="#" class="RouletteTable" shape="rect" coords="477,126,527,184" alt="25" title="25" group="25" />
			<area href="#" class="RouletteTable" shape="rect" coords="528,126,576,184" alt="28" title="28" group="28" />
			<area href="#" class="RouletteTable" shape="rect" coords="579,126,629,184" alt="31" title="31" group="31" />
			<area href="#" class="RouletteTable" shape="rect" coords="632,126,681,184" alt="34" title="34" group="34" />
			<area href="#" class="RouletteTable" shape="rect" coords="63,188,267,226" alt="37" title="1st12" group="1st12" />
			<area href="#" class="RouletteTable" shape="rect" coords="271,188,475,226" alt="38" title="2nd12" group="2nd12" />
			<area href="#" class="RouletteTable" shape="rect" coords="477,188,681,226" alt="39" title="3rd12" group="3rd12" />
			<area href="#" class="RouletteTable" shape="rect" coords="167,229,269,275" alt="40" title="ODD" group=" ODD" />
			<area href="#" class="RouletteTable" shape="rect" coords="270,228,372,274" alt="41" title="RED" group="any RED" />
			<area href="#" class="RouletteTable" shape="rect" coords="374,228,476,274" alt="42" title="BLACK" group="any BLACK" />
			<area href="#" class="RouletteTable" shape="rect" coords="478,228,578,274" alt="43" title="EVEN" group="any EVEN" />
			<area href="#" class="RouletteTable" shape="rect" coords="63,229,164,275" alt="44" title="1to18" group="1 to 18" />
			<area href="#" class="RouletteTable" shape="rect" coords="580,229,681,275" alt="45" title="19to36" group="19 to 36" />
			<area href="#" class="RouletteTable" shape="rect" coords="683,127,725,185" alt="46" title="2to1 1" group="2 to 1 1" />
			<area href="#" class="RouletteTable" shape="rect" coords="683,66,725,123" alt="47" title="2to1 2" group="2 to 1 2" />
			<area href="#" class="RouletteTable" shape="rect" coords="683,1,725,63" alt="48" title="2to1 3" group="2 to 1 3" />
			<area href="#" class="RouletteTable" shape="poly" coords="60,140,59,49,29,50,2,94,32,140," alt="0" title="0" group="0" />
		</map>
	</div>
	<div class="panel" id="history"></div>

</body>
</html>
