$(document).ready(function() {
	

	
	$("#everydiv").css('width','600px').css('height','300px').css('border','2px solid');
	$("#bluediv").css("width","80%").css("height","200px").css("margin-left","9%").css("background","#6799FF")
				 .css("display","flex").css("align-items","center").css("justify-content","center");
	
	var number =new Array(46);
	for(var i=0;i<46;i++) {
		number[i] = 0;
	}
	var cnt=0;

	var time;
	time = setInterval(makenumber,1000);


	function makenumber() {
		var num = parseInt(Math.random()*45) + 1;
		if(number[num] ==0){
			number[num] = 1;
			cnt++;
			
			
			if(cnt ==6) {
				clearInterval(time);
			}

			$("#bluediv").append('<div class = "circle">'+num+'</div>');
			
			$('.circle').css("width","50px").css("height","50px").css("background","yellow").css("border-radius","30px")
			.css("float","left").css("display","flex").css("align-items","center").css("justify-content","center")
			.css("margin-right","10px");
			
		}
	}

});