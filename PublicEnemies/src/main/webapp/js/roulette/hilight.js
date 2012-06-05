$(document).ready(function() {
	
	$(function() {
		   //using the jquery map highlight plugin:
		   //http://davidlynch.org/js/maphilight/docs/
		  
		   //initialize highlight
		   $('.map').maphilight({strokeColor:'808080',strokeWidth:0,fillColor:'00ffff'});


		   //hover effect
		   $('#maplink1').mouseover(function(e) {
		      $('#map1').mouseover();
		   }).mouseout(function(e) {
		      $('#map1').mouseout();
		   }).click(function(e) { e.preventDefault(); });
		               
		        
		   // initialize tabbing
		   $(".tabs area:eq(0)").each(function(){
		       $(this).addClass("current");
		   });
		   $(".tab-content").each(function(){
		       $(this).children(":not(:first)").hide();    
		   });
		            
		            
		   //map clicks
		   $(".tabs area").click(function(){
		              
		   //This block is what creates highlighting by trigger the "alwaysOn", 
		   var data = $(this).data('maphilight') || {};
		   data.alwaysOn = !data.alwaysOn;
		   $(this).data('maphilight', data).trigger('alwaysOn.maphilight');
		   //there is also "neverOn" in the docs, but not sure how to get it to work
		              
		          
		   if ($(this).hasClass("current") == false)
		   {
		       var thisTarget = $(this).attr("href");
		                                               
		       $(this).parents(".tabs").find('area.current').removeClass('current');
		                    
		       $(this).addClass('current');
		                    
		       $(this).parents(".tabs").nextAll(".tab-content").children(":visible").fadeOut(1, function() {
		           $(thisTarget).fadeIn("fast");
		       });

		   }
		   return false; 
		  });
	});
});