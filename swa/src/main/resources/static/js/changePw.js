	$(function(){
		var seq = $("#seq").val();
		$("#alert-success").hide();
		$("#alert-danger").hide();
		$("#alert-warning").hide();
		$("#submit").attr("disabled","disabled");
		$("input").keyup(function(){
			var pwd1 = $("#stt_pw").val();
			var pwd2 =	$("#stt_pw2").val();
			var num = pwd1.search(/[0-9]/g);
 			var eng = pwd1.search(/[a-z]/ig);
 			var spe = pwd1.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
			if(pwd1 != "" || pwd2 != ""){
				if(pwd1 == pwd2){
					if(pwd1.search(/\s/) != -1){
						$("#alert-success").hide();
						$("#alert-danger").hide();
						$("#alert-warning").text("공백을 제거하고 다시 입력 바랍니다.");
						$("#alert-warning").show();
					} else {
						if(pwd1.length < 9 || pwd1.length > 20) {
							$("#alert-success").hide();
							$("#alert-warning").text("비밀번호는 최소 9자리 최대 20자리 이내로 설정 바랍니다.");
							$("#alert-warning").show();
							$("#alert-danger").hide();
						} else if(num < 0 || eng < 0 || spe < 0){
							$("#alert-success").hide();
							$("#alert-warning").text("비밀번호는 영문, 숫자, 특수문자를 혼합하여 설정 바랍니다.");
							$("#alert-warning").show();
							$("#alert-danger").hide();
						} else {
							$("#alert-success").show();
							$("#alert-danger").hide();
							$("#alert-warning").hide();
							$("#submit").removeAttr("disabled");
						}
					}
				} else {
					$("#alert-success").hide();
					$("#alert-danger").show();
					$("#alert-warning").hide();
					$("#submit").attr("disabled","disabled");
				}
			}
		});
		
		
		
		
	});