	$(function() {
		$("#goback").click(function(){
			location.href = "/stt";
		});
	});
	
	function pageEvent(pageNum){
		$("#now_page").val(pageNum);
		$("#stt_list_form").submit();
	}