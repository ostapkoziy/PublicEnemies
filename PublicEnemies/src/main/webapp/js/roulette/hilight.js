$(document).ready(function() {
	
	$('img#rouletteTable').mapster({
//		onMouseover: state_change,
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
				key: "3",
				stroke: true,
				strokeColor: '00ff00',
				strokeWidth:1,
				fill: true
			}
		]

	});
});