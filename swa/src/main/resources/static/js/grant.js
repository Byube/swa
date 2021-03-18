	$(function() {
		/*$("#stt_give").click(function(){
			$("#stt_gback").css("display","block");
			$("#stt_give").css("display","none");
		});
		$("#stt_gback").click(function(){
			$("#stt_give").css("display","block");
			$("#stt_gback").css("display","none");
		});*/
		$("#stt_give").click(function(){
			if($("#stt_give").text()=='관리자 권한 부여'){
				$("#stt_give").text('관리자 권한 회수');
			} else {
				$("#stt_give").text('관리자 권한 부여');
			}
		});
	});