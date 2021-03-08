$(document).ready(function() {
	$("#every").css("width","250px").css("height","500px").css("border","3px solid");
	$("#result").css("width","220px").css("height","20px").css("border","1px solid").css("margin-bottom","20px");
	$("#numberarray").css("width","220px").css("height","250px").css("border","3px solid red");
	
	$(".btn").css("width","40px").css("height","40px").css("margin","2px 5px 5px 0px");
	
	var arr1 = [];
	var cnt=0,num1=0,num2=0,giho=0;
	var resultsik='';
	$(document).on('click','.btn',function() {
		var a = $(this).val();
		$("#result").append('<div class = "input">'+a+'</div>');
		$(".input").css("display","inline");
		if(a =='+') {
			giho ='+';
			resultsik += '+';

		}
		else if(a =='-') {
			giho ='-';
			resultsik += '-';

		}
		else if(a =='*') {
			giho ='*';
			resultsik += '*';


		}
		else if(a =='/') {
			giho ='/';
			resultsik += '/';


		}
		
		else if(a =='CE') {
			$(".input").remove();
		}
		else if(a =='=') {
			resultsik += '=';
			cnt=0;
			if(giho =='+') {
				num1 = parseInt(num1)+parseInt(num2);
			}
			else if(giho =='-') {
				num1 = parseInt(num1) - parseInt(num2);
			}
			else if(giho =='*') {
				num1 = parseInt(num1) * parseInt(num2);
			}
			else if(giho =='/') {
				num1 = parseInt(num1) / parseInt(num2);
			}

			$("#result").append('<div class = "input">'+num1+'</div>');
			console.log(num1);
			resultsik += num1;

			$("#resulting").append('<div>'+resultsik +'</div>');
			resultsik='';
			$(".input").remove();
			$("#result").append('<div class = "input">'+num1+'</div>');
		}
		else {
			if(cnt ==0) {
				cnt++;
				num1 = a;
				console.log(num1);
				resultsik += num1;
			}
			else if(cnt==1) {
				num2 =a;
				console.log(num2);
				resultsik += num2;
			}
		}
	});
	
});