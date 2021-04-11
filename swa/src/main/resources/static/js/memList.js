	$(function() {
		//한글입력 방지
		$("#SWA_ID").keyup(function(){
			if(!(event.keyCode >=37 && event.keyCode<=40)) {
                var inputVal = $(this).val();
                var check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
            	 if(check.test(inputVal)){
                	$(this).val("");
              	}
             }
		});
		
		
	});
	var check = false;
	
	//중복체크 하면서 id 특수기호 입력 등 체크 
	function checkid(){
		var sName = $("#SWA_NAME").val();
		var sId = $("#SWA_ID").val();
		var sCenter = $("#SWA_CENTER").val();
		var sinNM = $("#SWA_INMUM").val();
		var num = sId.search(/[0-9]/g);
	 	var eng = sId.search(/[a-z]/ig);
	 	var spe = sId.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		if(sName != "" || sId != "" || sCenter != "" || sinNM != ""){
			if(sName.search(/\s/) != -1 || sId.search(/\s/) != -1 || sCenter.search(/\s/) != -1){
				alert("공백은 입력 불가 입니다.");
				$("#SWA_NAME").val("");
				$("#SWA_ID").val("");
				$("#SWA_CENTER").val("");
				$("#SWA_INMUM").val("");
				$("#SWA_CENTER").focus();
			} else {
				if (spe > 0){
				alert("아이디는 영문 또는 영문 + 숫자 로만 가능 합니다.");
				$("#SWA_ID").val("");
				$("#SWA_ID").focus();
				} else {
					$.ajax({
						type : "GET",
						url : "/stt/checksIdok?id="+sId,
						dataType : "text",
						success : function(data) {
							if(data == "true"){
								$("#okid").show();
								$("#noid").hide();
								check = true;
							} else {
								$("#noid").show();
								$("#okid").hide();
								check = false;
							}
						},error : function(data) {
							alert("error bookMarks");
						}
				});
				}
			}
		} else {
			check = false;
		}
			
	}
	
	function goinsert(){
		$("#insertMem").attr("action","/stt/insertSwaMem");
		var checkaction = $("#butwo").text();
		if(checkaction == "취소"){
			closeMem();
		} else {
			if(check){
				$("#insertMem").submit();
				$(".pup_wrap").hide();
				check = false;
			} else {
				alert("아이디 중복체크 하세요");
			}
		}
	}
	
	function updapego(){
		if(check){
			$("#insertMem").submit();
			$(".pup_wrap").hide();
			check = false;
		} else {
			alert("아이디 중복체크 하세요");
		}
	}
	
	function insertMem(){
		$("#SWA_CENTER").val("");
		$("#SWA_INMUM").val("");
		$("#SWA_ID").val("");
		$("#SWA_NAME").val("");
		$("#insertMem").attr("action","/stt/insertSwaMem");
		$(".pup_wrap").show();
	}
	
	function closeMem(){
		$("#swa_title").text("멤버추가");
		$("#buth").hide();
		$("#butwo").text("저장");
		$("#insertMem").attr("action","");
		$(".pup_wrap").hide();
	}
	function pageEvent(pageNum){
		$("#now_page").val(pageNum);
		$("#swa_list").submit();
	}
	function upDate(c){
		$("#insertMem").attr("action","/stt/updateSwaMem");
		var ucenter = $("#ucenter" + c).text();
		var uinnum = $("#uinnum" + c).text();
		var uid = $("#uid" + c).text();
		var uname = $("#uname" + c).text();
		
		$("#swa_seq").val(c);
		$("#SWA_CENTER").val(ucenter);
		$("#SWA_INNUM").val(uinnum);
		$("#SWA_ID").val(uid);
		$("#SWA_NAME").val(uname);
		
		$("#swa_title").text("수정");
		$("#buth").show();
		$("#butwo").text("취소");
		$(".pup_wrap").show();
	}
	
	function deleteSwaMem(c){
		var uname = $("#uname" + c).text();
		if(confirm("최종 " + uname + "님의 계정 삭제 여부 확인 바랍니다.")) {
 			 window.location.href = "/stt/deleteSwaMem?SWA_SEQ=" + c;
 			} else {
 			return;
		}
	}
	
	