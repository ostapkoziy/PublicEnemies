<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/smoothness/jquery-ui-1.8.18.custom.css"
	rel="stylesheet" />
	<script type="text/javascript" src="js/jquery.metadata.min.js"></script>
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="js/jquery.maphilight.min.js"></script>
	<title>Start page</title>
	<script>$(function() {
        $('.map').maphilight();
        fillColor: '008800';
        
    });</script>
</head>

<style type="text/css">
body {
	background-image: url(img/bg_city.png);
	color: white;
	font-family: 'impact';
	font-size: 14pt;
}
h1 {
	color: red;
}
table {
	width: 100%;
	height: 100%;
	background-color: black;
<!--	opacity: .88;
	filter: alpha(opacity =   88);
	-moz-opacity: .88; -->
}
A:link {text-decoration: underline; color: white}
A:visited {text-decoration: none}
A:hover {text-decoration: underline; color: red;}
</style>

<body>
	<table align="center">
		<tr>
			<td style="background-color:black; width: 100%;">
				<!--  up bar with stats, gamelogo, avatar -->
				<table>
					<tr>
						<td width="100" align="left">
							<img src="img/gamelogo_small.png" width="100px"></img>
						</td>
						<td width="40" valign="middle" align="right">
							<img src="img/stats/coin.png" width="40px" title="Money"></img>
						</td>
						<td width="20" valign="middle" align="left">
							${profileInfo.getMoney()}
						</td>
						<td width="80" valign="middle" align="right">
							<img src="img/stats/exp.png" width="40px" title="Experience"></img>
						</td>
						<td width="20" valign="middle" align="left">
							${profileInfo.getExperience()}
						</td>
						<td width="80" valign="middle" align="right">
							<img src="img/stats/strength.png" width="40px" title="Strength"></img>
						</td>
						<td width="20" valign="middle" align="left">
							${profileInfo.getStrength()}
						</td>
						<td width="80" valign="middle" align="right">
							<img src="img/stats/agility.png" width="40px" title="Agility"></img>
						</td>
						<td width="20" valign="middle" align="left">
							${profileInfo.getAgility()}
						</td>
						<td width="80" valign="middle" align="right">
							<img src="img/stats/inteligence.png" width="40px" title="Inteligence"></img>
						</td>
						<td width="20" valign="middle" align="left">
							${profileInfo.getIntellect()}
						</td>
						<td width="100" align="right">
							<a href="editProfile.html">
							<img src="img/avatars/angelina.png" title="${profileInfo.getNickName()}'s profile" border="0" width="40px"></img>
							</a>
						</td>
						<td width="30" align="center">
							<a href="logout.html">Logout</a> <br />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<table align="center" height="500" border="2">
				<tr>
					<td align="center">
						<img class="map" id="player1" src="img/bw_back.png" class="map" usemap="#table1">
						<map name="table1" id="map_fight">
							<area href="newJoinGame.html" data-maphilight='{"strokeColor":"888811","strokeWidth":1,"fillColor":"888811","fillOpacity":0.5}' id="player1" title="fight" shape="poly" coords="675,99,726,78,725,37,744,26,773,31,772,48,886,0,1145,0,1191,13,1194,530,1157,536,1128,544,1095,534,1076,533,1064,520,1048,515,1033,515,1008,513,1003,446,997,360,990,264,984,196,981,174,977,141,933,134,875,125,832,117,812,113,796,105,775,112,773,102,750,101,746,109,712,106">
							<area href="#" data-maphilight='{"strokeColor":"888811","strokeWidth":0,"fillColor":"888811","fillOpacity":0.5}' id="player1" title="club" shape="poly" coords=" 775,116,818,114,984,142,985,215,998,356,1008,517,970,516,948,523,937,526,927,537,889,541,881,545,878,555,864,556,867,541,854,543,785,544,785,457,782,351,775,116">
							<area href="#" data-maphilight='{"strokeColor":"888811","strokeWidth":0,"fillColor":"888811","fillOpacity":0.5}' id="player1" title="shop" shape="poly" coords="529,74,673,99,771,119,780,226,785,399,786,458,788,487,788,540,770,531,760,526,740,518,717,515,674,515,634,515,595,520,584,522,563,545,536,544,514,550,514,505,512,400,509,284,508,152,506,103,521,90,520,73">
							<area href="#" data-maphilight='{"strokeColor":"888811","strokeWidth":0,"fillColor":"888811","fillOpacity":0.5}' id="player1" title="hideout" shape="poly" coords="523,73,523,87,512,101,507,108,509,184,509,259,510,347,512,385,513,429,514,474,513,510,513,551,483,556,464,560,451,564,443,576,443,560,412,553,371,546,351,528,311,524,266,525,228,526,207,527,182,542,170,551,161,551,161,493,162,423,164,357,169,259,174,154,175,79,172,24,183,15,329,40,504,67">
							<area href="#" data-maphilight='{"strokeColor":"888811","strokeWidth":0,"fillColor":"888811","fillOpacity":0.5}' id="player1" title="car" shape="poly" coords="48,585,56,586,65,568,85,557,169,550,203,530,275,524,338,526,350,527,370,544,409,551,442,559,444,571,459,562,488,556,517,553,563,546,588,523,647,516,724,516,753,520,781,540,827,542,866,543,865,555,884,541,916,536,927,534,941,521,981,515,1023,513,1054,516,1074,526,1077,533,1096,535,1119,540,1134,540,1163,534,1194,532,1193,664,845,663,845,629,858,629,922,625,999,617,1035,613,1079,573,1080,559,1070,571,1013,573,979,574,970,575,960,584,938,573,912,575,893,577,869,577,854,582,835,589,814,591,806,601,799,607,789,609,780,610,770,607,765,603,761,601,757,599,755,598,700,600,629,604,597,606,591,610,588,616,580,616,565,618,561,620,553,619,547,617,541,613,533,605,528,600,508,602,488,602,471,602,453,602,438,598,424,594,411,590,403,590,399,594,400,600,396,605,389,606,384,610,379,611,373,612,365,612,359,610,349,605,343,601,342,598,288,600,180,606,170,606,170,613,160,617,155,620,148,621,141,621,133,621,126,618,121,616,116,613,111,609,108,605,105,605,100,607,96,611,92,614,83,612,75,608,69,606,63,600,56,596,54,593">
						</map>
					</td>
				</tr>
			</table>
		</tr>
	</table>
</body>
</html>