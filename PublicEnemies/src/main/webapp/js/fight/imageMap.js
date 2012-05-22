$(document).ready(function() {

	function state_change(data) {
		//alert(data.state+":"+data.selected);
	}
	$('img#doll_block').mapster({
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
				key: 'leg',
				stroke: true,
				strokeColor: '00ff00',
				strokeWidth:1,
				fill: true
			},
			{
				key: 'hand',
				stroke: true,
				strokeColor: '00ff00',
				strokeWidth:1,
				fill: true
			}
		]

	});
	$('img#doll_hit').mapster({
		onStateChange: state_change,
		fillColor: 'ff0000',
		fillOpacity: 0.7,
		mapKey: "group",
		noHrefIsMask: false,
		singleSelect: true,
		render_select: {
			fillColor: 'ff0000',
			fillOpacity: 0.5

		},
		areas: [
			{
				key: 'head',
				stroke: true,
				strokeColor: 'bb0000',
				strokeWidth:1,
				fill: true
			},
			{
				key: 'torso',
				stroke: true,
				strokeColor: 'bb0000',
				strokeWidth:1,
				fill: true
			},
			{
				key: 'leg',
				stroke: true,
				strokeColor: 'bb0000',
				strokeWidth:1,
				fill: true
			},
			{
				key: 'hand',
				stroke: true,
				strokeColor: 'bb0000',
				strokeWidth:1,
				fill: true
			}
		]

	});

	var block = null;
	var hit = null;
	
	$("area.hit").click(function(){
		hit = this.title;
		$("#hitInput").val(hit);
	});
	$("area.block").click(function(){
		block = this.title;
		$("#blockInput").val(block);
	});
	
});

