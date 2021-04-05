	$(function() {
		$("#goback").click(function(){
			location.href = "/stt";
		});
		
		if($("#dateSort").val()=='dateAsc'){
			$("#date_sort").attr("class", "btn_down");
		} else {
			$("#date_sort").attr("class", "btn_up");
		}
		
		var date = getFormatDate(new Date());
		$("#startDate").attr("max",date);
		$("#endDate").attr("max",date);		
		
		
		$("#searChSort").click(function(){
		//	var sMin = $("#startDate").val();
		//	if(sMin != '' || sMin != "" || sMin != null){
				$("#stt_list_form").submit();
		//	}
		});
		
		$("#allSearch").click(function(){
			window.location.href = "/searchlog";
		});
		
		$("#excel").click(function(){
			window.location.href = "/excel/download";
		});
		
	});
	
	function getFormatDate(date){
		var year = date.getFullYear();
		
		var month = (1+date.getMonth());
		
		month = month >= 10 ? month : '0' +month;
		
		var day = date.getDate();
		
		day = day >= 10 ? day : '0' + day;
		
		return year + '-' + month + '-' + day;
	}
	
	function pageEvent(pageNum){
		$("#now_page").val(pageNum);
		$("#stt_list_form").submit();
	}
	
	function dateSort(){
		$(".sort_class").val("");
		if($("#date_sort").attr("class") == "btn_up") {
			//alert("up");
			$("#dateSort").val("dateAsc");
		} else {
			//alert("down");
			$("#dateSort").val("dateDesc");
		}
		$("#stt_list_form").submit();
	}
	
	function haveMin(endMin){
		var sMin = $("#startDate").val();
		if(sMin == '' || sMin == "" || sMin == null){
			$("#endDate").attr("min",endMin);
		} else {
			$("#endDate").attr("min",sMin);
		}
	}
	
	function checkDate(){
		
	}