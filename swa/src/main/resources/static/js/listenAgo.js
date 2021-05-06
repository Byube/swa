	$(function() {
		
		var date = getFormatDate(new Date());
		var today = new Date();
		var oldday = getFormatDate(new Date(today - (3600000*24*30)));
		var checkCal = false;
		$("#startDate").attr("max",date);
		$("#endDate").attr("max",date);
		
		if($("#startDate").val() == '' || $("#startDate").val() == null) {
			$("#startDate").val(oldday);
			$("#endDate").val(date);
		}
		
		$("#startDate").change(function(){
			var sd = $("#startDate").val();
			$("#endDate").attr("min",sd);
			var youd = sd.split('-');
			var youds = new Date(youd[0],youd[1] - 1,youd[2]);
		//	console.log("test  >>>>>>>  " + getFormatDate(youds));
			youds.setDate(youds.getDate() + 30);
			var maxday = getFormatDate(youds);
		//	console.log("test  >>>>>>>  " + maxday);
			$("#endDate").attr("max",maxday);
			if(today < youds){
				$("#endDate").attr("max",date);
				$("#endDate").val(date);
			} else {
				$("#endDate").attr("max",maxday);
				$("#endDate").val(maxday);
			}
			checkCal = true;
		});
		
		$("#endDate").change(function(){
			var md = $("#dateMin").val();
			var mind = md.split('-');
			var mins = new Date(mind[0], mind[1] - 1, mind[2]);
			var ismin = getFormatDate(mins);
	//		alert(mins);
			if(!checkCal){
				var ed = $("#endDate").val();
				$("#startDate").attr("max",ed);
				var youd = ed.split('-');
				var youds = new Date(youd[0],youd[1] - 1,youd[2]);
				youds.setDate(youds.getDate() - 30);
				if(mins > youds){
					$("#startDate").attr("min",ismin);
				} else {
					var minday = getFormatDate(youds);
				//	alert("test  >>>>>>>  " + minday);
					$("#startDate").attr("min",minday);
				}
			}
		});
		
		$("#mem_num").keyup(function(){
			var mnum = $("#mem_num").val();
			var check1 = /[a-z]/ig;
			var eng = check1.test(mnum);
			var check2 = /[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi;
			var spe = check2.test(mnum);
			var check3 = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
			var han = check3.test(mnum);
			if(han){
				$("#mem_num").val("");
			} 
			if(eng){
				$("#mem_num").val("");
			} 
			if(spe){
				$("#mem_num").val("");
			}
			if(mnum.search(/\s/) != -1){
				$("#mem_num").val("");
			}
		});
		
		$("#user_num").keyup(function(){
			var unum = $("#user_num").val();
			var check1 = /[a-z]/ig;
			var eng = check1.test(unum);
			var check2 = /[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi;
			var spe = check2.test(unum);
			var check3 = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
			var han = check3.test(unum);
			if(han){
				$("#user_num").val("");
			} 
			if(eng){
				$("#user_num").val("");
			} 
			if(spe){
				$("#user_num").val("");
			}
			if(unum.search(/\s/) != -1){
				$("#user_num").val("");
			}
		});
		
		$("#searChSort").click(function(){
			$('.preloader').fadeIn(1000);
			$("#mst_list_form").submit();
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
		$('.preloader').fadeIn(1000);
		$("#now_page").val(pageNum);
		$("#mst_list_form").submit();
	}
	
	
	
