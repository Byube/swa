	$(function() {
		alert("운영자 초기 비밀번호는 1234로 자동 생성 됩니다.");
		$("#noid").hide();
		$("#okid").hide();
		$("#submit").attr("disabled","disabled");
		$("input").keyup(function(){
			var sName = $("#STT_NAME").val();
			var sId = $("#STT_ID").val();
			var sCenter = $("#STT_CENTER").val();
			
			if(sName != "" || sId != "" || sCenter != ""){
				if(sName.search(/\s/) != -1){
					
				} else {
					
				}
			} else {
				
			}
			
		});
		
		$("#checkId").click(function(){
			var sId = $("#STT_ID").val();
			//var num = sId.search(/[0-9]/g);
 			var eng = sId.search(/[a-z]/ig);
 			var spe = sId.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
			if(sId != ""){
				 if (eng < 0 || spe > 0){
					alert("아이디는 영문으로만 가능 합니다.");
				} else {
					$.ajax({
						type : "GET",
						url : "/checkIdok?id="+sId,
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
				
			} else {
				$("#submit").attr("disabled","disabled");
			}
			
		});
		
	});