	$(function() {
		var check = $("#check").val();	
		if(check == '1234'){
			alert("비밀번호를 변경 하세요");
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
		
		console.log("url : " + url);	
		$(".ob").attr("data",url);		
		$(".eb").attr("src",embedUrl);
	}
	function searchlog(myUrl){
		var searchlogUrl = "http://127.0.0.1:8080/" + myUrl;
		$(".ob").attr("data",searchlogUrl);		
		$(".eb").attr("src",searchlogUrl);
	}
	
	
	