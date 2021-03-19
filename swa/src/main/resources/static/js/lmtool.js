	$(function() {
				
	});
	
	function checkUrl(urlKey){
		sendUrl(urlKey);
	}
	
	function sendUrl(urlKey){
		var userId = $("#userId").val();
		var menuKey = $("menuKey").val();
		
		var embedUrl = 	"http://98.28.5.83:8000/lmtool/"
						+ urlKey;
						
		var url = 	embedUrl 
					+ "?" 
					+ "userId=" + userId 
					+ "&menuKey=" + menuKey;
		
		console.log("url : " + url);	
		$(".ob").attr("data",url);		
		$(".eb").attr("src",embedUrl);
	}
	function searchlog(){
		var searchlogUrl = "http://127.0.0.1:8080/searchlog";
		$(".ob").attr("data",searchlogUrl);		
		$(".eb").attr("src",searchlogUrl);
	}
	
	