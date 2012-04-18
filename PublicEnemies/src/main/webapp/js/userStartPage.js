$(document).ready(function() {

	function state_change(data) {
		//alert(data.state+":"+data.selected);
	}
	$('img#player1').mapster({
		onStateChange: state_change,
		fillColor: '0a7a0a',
		fillOpacity: 0.7,
		mapKey: "group",
		noHrefIsMask: false,
		singleSelect: true,
		render_select: {
			fillColor: '00ff00',
			fillOpacity: 0.5
		},
		areas: [
			{
				key: 'head',
				stroke: true,
				strokeColor: '00ff00',
				strokeWidth:1,
				fill: true
			},
			{
				key: 'torso',
				stroke: true,
				strokeColor: '00ff00',
				strokeWidth:1,
				fill: true
			},
			{
				key: 'right_hand',
				stroke: true,
				strokeColor: '00ff00',
				strokeWidth:1,
				fill: true
			}
		]

	});
});