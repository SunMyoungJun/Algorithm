window.onload = function() {

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
			
			var BlueDiv = document.querySelector('#bluediv');
			var divE1 = document.createElement('div');
			divE1.setAttribute('class','circle');
			divE1.appendChild(document.createTextNode(num));
			
			BlueDiv.appendChild(divE1);
		}
		
		
		
		
		
		
		
		
		
	}

}