	$(function() {
		
		
		if($("#dateSort").val()=='dateAsc'){
			$("#date_sort").attr("class", "btn_down");
		} else {
			$("#date_sort").attr("class", "btn_up");
		}
		
		var date = getFormatDate(new Date());
		var today = new Date();
		var oldday = getFormatDate(new Date(today - (3600000*24*30)));
		$("#startDate").attr("max",date);
		$("#endDate").attr("max",date);
		
		$("#searChSort").click(function(){
			alert($("#startDate").val());
			alert($("#endDate").val());
			//$("#mst_list_form").submit();
		});
		
		if($("#startDate").val() == '' || $("#startDate").val() == null) {
			$("#startDate").val(oldday);
			$("#endDate").val(date);
		}
		
		$("#startDate").change(function(){
			var sd = $("#startDate").val();
			$("#endDate").attr("min",sd);
			var youd = sd.split('-');
			var youds = new Date(youd[0],youd[1] - 1,youd[2]);
			alert(getFormatDate(youds));
			youds.setDate(youds.getDate()+1);
			var maxday = getFormatDate(youds);
			$("#endDate").attr("max",maxday);
			if(today < youds){
				$("#endDate").attr("max",date);
			} else {
				$("#endDate").attr("max",maxday);
			}
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
	
	function dateSort(){
		$(".sort_class").val("");
		if($("#date_sort").attr("class") == "btn_up") {
			//alert("up");
			$("#dateSort").val("dateAsc");
		} else {
			//alert("down");
			$("#dateSort").val("dateDesc");
		}
		$("#mst_list_form").submit();
	}
	
	function pageEvent(pageNum){
		$("#now_page").val(pageNum);
		$("#mst_list_form").submit();
	}
	
	
	
