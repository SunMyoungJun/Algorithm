
$(function() {
	
	$(".common").on("keyup", function() {  //공통 유효성 검사(띄워쓰기)
		var temp = $(this).val();
		
		for(var i=0;i<temp.length;i++) {
			if(temp.charAt(i) ==' ') {
				alert("띄워쓰기는 입력하실 수 없습니다.")
				break;
			}
		}
	});
	
	$(".btn").on("click",function() {   //공통 유효성 검사(null)
		
		$(".common").each(function(index,item) {
			if($(this).val() == '') {
				alert("값을 입력하세요");
			}
			
			console.log($(this).val());

		});
		
		$.ajax ({
			url : 'userlist.xml',
			type : 'GET',
			datatype : 'xml',
			success : function(response) {
				checkid(response);
			}		
		});
	});
	
	function checkid(response) {
		var tf =0;
		var inputid = $('#ids').val(); 
		$(response).find('id').each(function(index,item) {
			if($(this).text() == inputid) {
				alert("이미 가입된 아이디 입니다.");
				tf =1;
				return;
			}
		});
		
		if(tf==0) {
			location.href = "sign.html";
		}
	}
	
	
	
	
	
});
