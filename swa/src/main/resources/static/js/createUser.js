	$(function() {
				
	});
	
	function levelChange(seq,code){
		window.location.href = "/levelChange?STT_SEQ=" + seq
								+ "&code=" + code;
	}
	
	function deleteUser(seq){
		if(confirm("해당 운영자를 정말 삭제 하실꺼에요?")) {
 			 window.location.href = "/deleteUser?STT_SEQ=" + seq;
 			} else {
 			return;
		}
	}
	
	function resetPw(seq){
		if(confirm("해당 운영자 비밀번호를 초기화 하시나요?")) {
 			 window.location.href = "/resetPw?STT_SEQ=" + seq;
 			} else {
 			return;
		}
	}