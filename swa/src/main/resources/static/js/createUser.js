	swal({
		title:"타이틀",
		text:"나용",
		icon:"info"
	})
	
	$(function() {
		
		$("#noid").hide();
		$("#okid").hide();
		$("#submit").attr("disabled","disabled");
		
		$( "#create-user" ).button().on( "click", function() {
			
			
			alert("초기 비밀번호는 1234로 자동 생성 됩니다.");
    		$(".dialog").fadeIn('slow');
    	});
		
		//한글입력 방지
		$("#STT_ID").keyup(function(){
			if(!(event.keyCode >=37 && event.keyCode<=40)) {
                var inputVal = $(this).val();
                var check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
            	 if(check.test(inputVal)){
                	$(this).val("");
              	}
             }
		});
		
		$("#STT_NAME").keyup(function(){
			$("#noid").hide();
			$("#okid").hide();
			$("#submit").attr("disabled","disabled");
		});
		$("#STT_ID").keyup(function(){
			$("#noid").hide();
			$("#okid").hide();
			$("#submit").attr("disabled","disabled");
		});
		$("#STT_CENTER").keyup(function(){
			$("#noid").hide();
			$("#okid").hide();
			$("#submit").attr("disabled","disabled");
		});
		
		//중복체크 하면서 id 특수기호 입력 등 체크 
		$("#checkId").click(function(){
			var sName = $("#STT_NAME").val();
			var sId = $("#STT_ID").val();
			var sCenter = $("#STT_CENTER").val();
			var num = sId.search(/[0-9]/g);
 			var eng = sId.search(/[a-z]/ig);
 			var spe = sId.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
			if(sName != "" || sId != "" || sCenter != ""){
				if(sName.search(/\s/) != -1 || sId.search(/\s/) != -1 || sCenter.search(/\s/) != -1){
					alert("공백은 입력 불가 입니다.");
					$("#STT_NAME").val("");
					$("#STT_ID").val("");
					$("#STT_CENTER").val("");
					$("#STT_NAME").focus();
				} else {
					if (spe > 0){
					alert("아이디는 영문 또는 영문 + 숫자 로만 가능 합니다.");
					$("#STT_ID").val("");
					$("#STT_ID").focus();
					} else {
						$.ajax({
							type : "GET",
							url : "/stt/checkIdok?id="+sId,
							dataType : "text",
							success : function(data) {
								//alert(data);
								if(data == "true"){
									$("#okid").show();
									$("#noid").hide();
									$("#submit").removeAttr("disabled");
								} else {
									$("#noid").show();
									$("#okid").hide();
								}
							},error : function(data) {
								alert("error bookMarks");
							}
					});
					}
				}
			} else {
				$("#submit").attr("disabled","disabled");
			}
			
		});
		$("#submit").click(function(){
			$(".dialog").fadeOut('slow');
		});
		
	});
	
	function levelChange(seq,code){
		window.location.href = "/stt/levelChange?STT_SEQ=" + seq
								+ "&code=" + code;
	}
	
	function deleteUser(seq){
		if(confirm("해당 운영자를 정말 삭제 하시겠습니까?")) {
 			 window.location.href = "/stt/deleteUser?STT_SEQ=" + seq;
 			} else {
 			return;
		}
	}
	
	function resetPw(seq){
		if(confirm("해당 운영자 비밀번호를 초기화 하시겠습니까?")) {
 			 window.location.href = "/stt/resetPw?STT_SEQ=" + seq;
 			} else {
 			return;
		}
	}