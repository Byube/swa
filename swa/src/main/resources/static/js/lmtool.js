	$(function() {
		var check = $("#check").val();	
		var seq = $("#seq").val();
		if(check == '1234'){
			alert("비밀번호를 변경 해 주시길 바랍니다.");
			window.location.href = "/stt/changePw?seq=" + seq;
		}			
	});
	
	function checkUrl(urlKey){
		sendUrl(urlKey);
	}
	
	function sendUrl(urlKey){
		var userId = $("#userId").val();
		var menuKey = $("#menuKey").val();
		var embedUrl = 	"https://98.28.5.83:8000/lmtool/"
						+ urlKey;
						
		var url = 	embedUrl 
					+ "?" 
					+ "userId=" + userId 
					+ "&menuKey=" + menuKey;
		
	//	console.log("url : " + url);	
		$(".ob").attr("data",url);		
		$(".eb").attr("src",embedUrl);
	}
	function searchlog(myUrl){
		var ui = $("#userId").val();
		
	//	var searchlogUrl = "https://98.28.5.83:8000/stt/" + myUrl
	//					+ "?userId=" + ui;
	
		var searchlogUrl = "http://127.0.0.1:8880/stt/" + myUrl
						+ "?userId=" + ui;
						
		$(".ob").attr("data",searchlogUrl);		
		$(".eb").attr("src",searchlogUrl);
	}
	
	function changepw(){
		var seq = $("#seq").val();
		if(confirm("비밀번호를 변경 페이지로 이동 하시겠습니까?")) {
 			window.location.href = "/stt/changePw?seq=" + seq;
 			} else {
 			return;
		}
	}
	
	
	