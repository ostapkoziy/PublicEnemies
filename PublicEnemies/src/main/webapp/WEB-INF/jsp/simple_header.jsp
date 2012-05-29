<div style="margin-top: 0px;">
	<table style="width: 100%; height: 100%;">
		<tr>
			<td width="100" align="left"><a href="userStartPage.html"><img src="img/gamelogo_small.png"
				width="100px"></img></a></td>
			<td width="40" valign="middle" align="right"><img
				src="img/stats/coin.png" width="40px" title="Money"></img></td>
			<td width="20" valign="middle" align="left">
				${profileInfo.getMoney()}</td>
			<td width="80" valign="middle" align="right"><img
				src="img/stats/exp.png" width="40px" title="Experience"></img></td>
			<td width="20" valign="middle" align="left">
				${profileInfo.getExperience()}</td>
			<td width="80" valign="middle" align="right"><img
				src="img/stats/strength.png" width="40px" title="Strength"></img></td>
			<td width="20" valign="middle" align="left">
				${profileInfo.getStrength()}</td>
			<td width="80" valign="middle" align="right"><img
				src="img/stats/agility.png" width="40px" title="Agility"></img></td>
			<td width="20" valign="middle" align="left">
				${profileInfo.getAgility()}</td>
			<td width="80" valign="middle" align="right"><img
				src="img/stats/inteligence.png" width="40px" title="Inteligence"></img>
			</td>
			<td width="20" valign="middle" align="left">
				${profileInfo.getIntellect()}</td>
			<td width="100" align="right"><a href="profile.html"> <img
					src="${profileInfo.getAvatar()}"
					title="${profileInfo.getNickName()}'s profile" border="0"
					width="40px"></img>
			</a></td>
			<td width="30" align="center"><a href="logout.html">Logout</a> <br />
			</td>
		</tr>
	</table>
</div>