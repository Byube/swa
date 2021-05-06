	$(function() {
		
		$("#goback").click(function(){
			location.href = "/stt/stt";
		});
		
		if($("#dateSort").val()=='dateAsc'){
			$("#date_sort").attr("class", "btn_up");
		} else {
			$("#date_sort").attr("class", "btn_down");
		}
		
		var date = getFormatDate(new Date());
		$("#startDate").attr("max",date);
		$("#endDate").attr("max",date);		
		
		
		$("#searChSort").click(function(){
			$("#stt_list_form").attr("action", "/stt/searchlog");
			$("#stt_list_form").submit();
		});
		
		$("#allSearch").click(function(){
			window.location.href = "/stt/searchlog";
		});
		
		$("#excel").click(function(){
			$('.preloader').fadeIn(1000);
			$("#stt_list_form").attr("action", "/stt/excel/download");
			$("#stt_list_form").submit();
		//	window.location.href = "/stt/excel/download";
		});
		
		if($("#startDate").val() == '' || $("#startDate").val() == null) {
			$("#startDate").val($("#minda").val());
			$("#endDate").val(date);
		}
		
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
		$("#stt_list_form").attr("action", "/stt/searchlog");
		$("#now_page").val(pageNum);
		$("#stt_list_form").submit();
	}
	
	function dateSort(){
		$("#stt_list_form").attr("action", "/stt/searchlog");
		$(".sort_class").val("");
		if($("#date_sort").attr("class") == "btn_down") {
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
	