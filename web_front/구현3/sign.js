$(function() {
	
	$('#login').on("click",function() {
		var id = $('#id').val();
				 
		var pw = $("#pw").val();
		
		
		$.ajax({
			url : "userlist.xml",
			type : "GET",
			datatype : "xml",
			success : function(response) {
				check(response);
			}
			
		});
		
		
	});
	
	
	
	function check(response) {
		var tf =0;
		$(response).find('person').each(function(index,item) {	
			if(id.value == $(this).find('id').text()) {
				if(pw.value == $(this).find('pw').text()) {
					alert("로그인 성공!!");
					tf =1;
					return;
				}
				else {
					tf =1;
					alert("비밀번호가 틀렸습니다.");
					return;
				}
			}
			
		});
		if(tf ==0) {
			alert("등록된 아이디가 없습니다.");

		}

	}
});

