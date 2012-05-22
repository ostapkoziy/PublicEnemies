<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="css/roulette.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<script type="text/javascript" src="js/roulette/roulette.js"></script>



</head>
<body>
	
	<div class="panel" id="topPanel">
		<b><c:out value="${rouletteGameInfo.getChips()}$" /></b>
		<p><b><c:out value="${rouletteGameInfo.msg}" /></b>
	</div>

	<div class="panel" id="leftPanel">leftPanel</div>
	<div class="panel" id="rightPanel">RightPanle</div>
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
<area class="RouletteTable" shape="rect" coords="63,188,163,228" alt="red1" title="red1"    />
<area class="RouletteTable" shape="rect" coords="165,188,265,228" alt="black1" title="black1"    />
<area class="RouletteTable" shape="rect" coords="270,188,369,228" alt="red2" title="red2"    />
<area class="RouletteTable" shape="rect" coords="372,188,472,228" alt="black2" title="black2"    />
<area class="RouletteTable" shape="rect" coords="476,188,576,228" alt="red3" title="red3"    />
<area class="RouletteTable" shape="rect" coords="579,188,679,228" alt="black3" title="black3"    />
<area class="RouletteTable" shape="rect" coords="62,233,162,273" alt="odd1" title="odd1"    />
<area class="RouletteTable" shape="rect" coords="269,232,369,272" alt="odd2" title="odd2"    />
<area class="RouletteTable" shape="rect" coords="476,232,576,272" alt="odd3" title="odd3"    />
<area class="RouletteTable" shape="rect" coords="166,232,266,272" alt="even1" title="even1"    />
<area class="RouletteTable" shape="rect" coords="372,232,472,272" alt="even2" title="even2"    />
<area class="RouletteTable" shape="rect" coords="579,231,679,271" alt="even3" title="even3"    />
<area class="RouletteTable" shape="rect" coords="61,275,266,315" alt="1st12" title="1st12"    />
<area class="RouletteTable" shape="rect" coords="269,275,473,315" alt="2nd12" title="2nd12"    />
<area class="RouletteTable" shape="rect" coords="477,275,680,315" alt="3rd12" title="3rd12"    />
<area class="RouletteTable" shape="rect" coords="61,317,163,357" alt="1to18" title="1to18"    />
<area class="RouletteTable" shape="rect" coords="165,317,267,357" alt="anyOdd" title="anyOdd"    />
<area class="RouletteTable" shape="rect" coords="269,317,371,357" alt="anyRed" title="anyRed"    />
<area class="RouletteTable" shape="rect" coords="374,317,473,357" alt="anyBlack" title="anyBlack"    />
<area class="RouletteTable" shape="rect" coords="477,317,577,357" alt="anyEven" title="anyEven"    />
<area class="RouletteTable" shape="rect" coords="580,317,680,357" alt="19to36" title="19to36"    />
<area class="RouletteTable" shape="rect" coords="683,1,717,62" alt="oddRow3" title="oddRow3"    />
<area class="RouletteTable" shape="rect" coords="683,63,717,123" alt="oddRow2" title="oddRow2"    />
<area class="RouletteTable" shape="rect" coords="683,124,717,184" alt="oddRow1" title="oddRow1"    />
<area class="RouletteTable" shape="rect" coords="720,1,754,61" alt="evenRow3" title="evenRow3"    />
<area class="RouletteTable" shape="rect" coords="719,64,753,124" alt="evenRow2" title="evenRow2"    />
<area class="RouletteTable" shape="rect" coords="719,124,753,184" alt="evenRow1" title="evenRow1"    />
<area class="RouletteTable" shape="rect" coords="757,0,795,61" alt="2to1Row3" title="2to1Row3"    />
<area class="RouletteTable" shape="rect" coords="757,64,795,124" alt="2to1Row2" title="2to1Row2"    />
<area class="RouletteTable" shape="rect" coords="758,126,795,185" alt="2to1Row1" title="2to1Row1"    />
<area class="RouletteTable" shape="poly" coords="59,184,59,94,29,95,1,140,30,184," alt="zero" title="zero"   />
<area class="RouletteTable" shape="poly" coords="59,92,59,0,32,1,1,48,29,92," alt="doubleZero" title="doubleZero"   />
<area class="RouletteTable" shape="rect" coords="798,360,800,362" alt="Image Map" title="Image Map" />

</map>	</div>
	<div class="panel" id="bottomPanel">
	<form method="post" action="rouletteGame.html" onsubmit="form_send()">
		<b>Your BET:</b>
		<input class="bet" type="radio" name="betVal" value="10"><b>10</b>
		<input class="bet" type="radio" name="betVal" value="25" checked="checked"><b>25</b>
		<input class="bet" type="radio" name="betVal" value="50"><b>50</b><p>
		<b>(to send):</b> <input id="userBetNumbers" type="text" name="userBetNumbers" readonly="readonly">
		<input id ="btn_test" type="button" value="test">
		<input id ="submit" type="submit" value="DEAL">
		<input id="clearBet" type="button" value="Clear bet">
		<div id="showBet">0</div>
	</form>
	</div>
	
</body>
</html>