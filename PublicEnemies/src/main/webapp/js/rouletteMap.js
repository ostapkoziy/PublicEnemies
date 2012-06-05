$(document).ready(function()
{
	function state_change(data)
	{
		// alert(data.state+":"+data.selected);
	}
	$('img#rouletteTable').mapster({
		onStateChange : state_change,
		fillColor : '0a7a0a',
		fillOpacity : 0.7,
		mapKey : "group",
		noHrefIsMask : false,
		singleSelect : false,
		render_select : {
			fillColor : '00ff00',
			fillOpacity : 0.5 },
		areas : [ 
		    {
				key : '1',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '2',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '3',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '4',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			},
			{
				key : '5',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			},
			{
				key : '6',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '7',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '8',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '9',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '10',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '11',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '12',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '13',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '14',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '15',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '16',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '17',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '18',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '19',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '20',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '21',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '22',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '23',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '24',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '25',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '26',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '27',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '28',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '29',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '30',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '31',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '32',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '33',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '34',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '35',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '36',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : 'any RED',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : 'any BLACK',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : 'any ODD',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : 'any EVEN',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '1st12',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '2nd12',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '3rd12',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '1 to 18',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '19 to 36',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '2 to 1 1',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '2 to 1 2',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '2 to 1 3',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}, 
			{
				key : '0',
				stroke : true,
				strokeColor : '00ff00',
				strokeWidth : 1,
				fill : true 
			}
				
		]

	});

});
