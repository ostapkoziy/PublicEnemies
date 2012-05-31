<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="css/roulette.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Public Enemies Roulette</title>
<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.imagemapster.js"></script>
<script type="text/javascript" src="js/jquery.maphilight.min.js"></script>
<script type="text/javascript" src="js/jquery.metadata.min.js"></script>

<script type="text/javascript" src="js/roulette/hilight.js"></script>
<script type="text/javascript" src="js/roulette/roulette.js"></script>

</head>
<body>
	<div class="panel" id="topPanel">
		<h2><c:out value="${rouletteGameInfo.getChips()} chips" /></h2>
		<p><b><c:out value="${rouletteGameInfo.msg}" /></b>
	</div>

	<div class="panel" id="leftPanel">leftPanel<p>Bet on table:<div id="betOnTable">0</div><p>Current BET:<h2 id="showBet">0</h2></div>
	<div class="panel" id="rightPanel">RightPanel<p>HISTORY<p><c:out value="${rouletteGameInfo.history}" /></div>
	<div class="panel" id="centerPanel">
<img id="rouletteTable" src="img/roulette/table.png" usemap="rouletteNumbers" border="0" width="800" height="362" alt="" />
<map id="rouletteNumbers" name="rouletteNumbers">
<area class="RouletteTable" shape="rect" coords="61,0,113,63" alt="3" title="3"	/>
<area class="RouletteTable" shape="rect" coords="114,0,163,62" alt="6" title="6"    />
<area class="RouletteTable" shape="rect" coords="167,0,215,62" alt="9" title="9"    />
<area class="RouletteTable" shape="rect" coords="219,0,267,62" alt="12" title="12"    />
<area class="RouletteTable" shape="rect" coords="273,0,321,62" alt="15" title="15"    />
<area class="RouletteTable" shape="rect" coords="322,0,370,62" alt="18" title="18"    />
<area class="RouletteTable" shape="rect" coords="374,0,422,62" alt="21" title="21"    />
<area class="RouletteTable" shape="rect" coords="425,0,473,62" alt="24" title="24"    />
<area class="RouletteTable" shape="rect" coords="479,1,527,63" alt="27" title="27"    />
<area class="RouletteTable" shape="rect" coords="529,1,577,63" alt="30" title="30"    />
<area class="RouletteTable" shape="rect" coords="580,1,628,63" alt="33" title="33"    />
<area class="RouletteTable" shape="rect" coords="631,1,679,63" alt="36" title="36"    />
<area class="RouletteTable" shape="rect" coords="63,65,112,123" alt="2" title="2"    />
<area class="RouletteTable" shape="rect" coords="115,65,163,123" alt="5" title="5"    />
<area class="RouletteTable" shape="rect" coords="166,66,215,124" alt="8" title="8"    />
<area class="RouletteTable" shape="rect" coords="219,66,267,124" alt="11" title="11"    />
<area class="RouletteTable" shape="rect" coords="272,65,320,123" alt="14" title="14"    />
<area class="RouletteTable" shape="rect" coords="323,65,371,123" alt="17" title="17"    />
<area class="RouletteTable" shape="rect" coords="372,65,422,124" alt="20" title="20"    />
<area class="RouletteTable" shape="rect" coords="424,65,474,123" alt="23" title="23"    />
<area class="RouletteTable" shape="rect" coords="477,65,527,123" alt="26" title="26"    />
<area class="RouletteTable" shape="rect" coords="528,66,578,124" alt="29" title="29"    />
<area class="RouletteTable" shape="rect" coords="579,66,629,124" alt="32" title="32"    />
<area class="RouletteTable" shape="rect" coords="632,66,682,124" alt="35" title="35"    />
<area class="RouletteTable" shape="rect" coords="63,126,112,184" alt="1" title="1"    />
<area class="RouletteTable" shape="rect" coords="114,126,162,184" alt="4" title="4"    />
<area class="RouletteTable" shape="rect" coords="167,127,216,185" alt="7" title="7"    />
<area class="RouletteTable" shape="rect" coords="218,126,266,184" alt="10" title="10"    />
<area class="RouletteTable" shape="rect" coords="272,126,320,184" alt="13" title="13"    />
<area class="RouletteTable" shape="rect" coords="322,127,370,185" alt="16" title="16"    />
<area class="RouletteTable" shape="rect" coords="373,126,423,184" alt="19" title="19"    />
<area class="RouletteTable" shape="rect" coords="425,126,475,184" alt="22" title="22"    />
<area class="RouletteTable" shape="rect" coords="477,126,527,184" alt="25" title="25"    />
<area class="RouletteTable" shape="rect" coords="528,126,576,184" alt="28" title="28"    />
<area class="RouletteTable" shape="rect" coords="579,126,629,184" alt="31" title="31"    />
<area class="RouletteTable" shape="rect" coords="632,126,681,184" alt="34" title="34"    />
<area class="RouletteTable" shape="rect" coords="63,188,267,226" alt="37" title="1st12"    />
<area class="RouletteTable" shape="rect" coords="271,188,475,226" alt="38" title="2nd12"    />
<area class="RouletteTable" shape="rect" coords="477,188,681,226" alt="39" title="3rd12"    />
<area class="RouletteTable" shape="rect" coords="167,229,269,275" alt="40" title="any ODD"    />
<area class="RouletteTable" shape="rect" coords="270,228,372,274" alt="41" title="Any RED"    />
<area class="RouletteTable" shape="rect" coords="374,228,476,274" alt="42" title="Any BLACK"    />
<area class="RouletteTable" shape="rect" coords="478,228,578,274" alt="43" title="Any EVEN"    />
<area class="RouletteTable" shape="rect" coords="63,229,164,275" alt="44" title="1 to 18"    />
<area class="RouletteTable" shape="rect" coords="580,229,681,275" alt="45" title="19 to 36"    />
<area class="RouletteTable" shape="rect" coords="683,127,725,185" alt="46" title="2 to 1 1"    />
<area class="RouletteTable" shape="rect" coords="683,66,725,123" alt="47" title="2 to 1 2"    />
<area class="RouletteTable" shape="rect" coords="683,1,725,63" alt="48" title="2 to 1 3"    />
<area class="RouletteTable" shape="poly" coords="60,140,59,49,29,50,2,94,32,140," alt="0" title="0"   />

</map>	</div>
	<div class="panel" id="bottomPanel">
	<form method="post" action="rouletteGame.html" onsubmit="form_send()">
		<b>Your BET:</b>
		<input class="bet" type="radio" name="betVal" value="10"><b>10</b>
		<input class="bet" type="radio" name="betVal" value="25" checked="checked"><b>25</b>
		<input class="bet" type="radio" name="betVal" value="50"><b>50</b><p>
		
		<img class="chips" id="10" alt="10" src="img/roulette/Chip_10.png" width="80" height="80">
		<img class="chips" id="25" alt="25" src="img/roulette/Chip_25.png" width="80" height="80">
		<img class="chips" id="50" alt="50" src="img/roulette/Chip_50.png" width="80" height="80">
		
		<b>(to send):</b> <input id="userBetNumbers" type="text" name="userBetNumbers" readonly="readonly">
		<input id ="btn_test" type="button" value="test">
		<input id ="submit" type="submit" value="DEAL">
		<input id="clearBet" type="button" value="Clear bet">
	</form>
	</div>
	<form method="post" action="rouletteRedirectController.html">
		<input id="exit" type="submit" value="Leave roulette table">
	</form>
	
</body>
</html>
