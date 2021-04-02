<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과거녹취 청취</title>
<link rel="stylesheet" href="resources/css/logtable.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="resources/js/listenAgo.js"></script>

</head>
<body>

	<div class="con">
	 <form id="stt_list_form" method="post" action="/searchlog">
		<div class="con_sel">
			<div class="date_search">
				<input type="date" class="date" title="날짜 검색창" id="startDate" name="startDate" min="${dateMin }" onclick="checkDate()" value="${startDate }">
			</div>
			<div class="date_search">
				<input type="date" class="date" title="날짜 검색창" id="endDate" name="endDate"  onclick="haveMin('${dateMin }')" value="${endDate }">
			</div>

		<%-- 	<select class="sel_01" name="STT_ID">
				<option value="${sttuser }" title="전체">ID</option>
			<c:forEach items="${mlist }" var="clist" varStatus="cnt">
				<option value="${clist.STT_ID }" title="box1" id="stt_center">${clist.STT_ID }</option>
			</c:forEach>
			</select> 
			<select class="sel_02" name="STT_MENU">
				<option value="${sttmenu }" title="전체">접근메뉴</option>
			<c:forEach items="${menu }" var="m" varStatus="cnt">	
				<option value="${m.STT_MENU }" title="box1">${m.STT_MENU }</option>
			</c:forEach>
			</select>
 --%>
			<div class="search_btn">
				<input
					style="height: 40px; padding: 0 30px; background: #f3e86f; color: #020202; border: none; border-radius: 5px;"
					type="text" placeholder="키워드입력" class="search" title="검색창">
			</div>
			<div class="search_btn">
				<input
					style="height: 40px; padding: 0 30px; background: #0071bc; color: #fff; border: none; border-radius: 5px;"
					type="button" class="search" value="조회" title="조회 버튼" id="searChSort">
			</div>
			
		</div>
		<!-- 테이블 -->
		<div class="table">
			<table class="tb_1" summary="게시판 테이블">
				<caption style="font-size: 0">게시판</caption>
				<colgroup>
					<col width="10%">
					<col width="15%">
					<col width="15%">
					<col width="60%">
				</colgroup>
				<thead>
					<tr>
						<th title="순">순</th>
						<th title="센터">고객전화</th>
						<th title="내선번호">내선번호</th>
						<th title="시간">시간</th>
					</tr>
				</thead>
				<tbody>
					<tr id="test" onclick="golisten(this)">
						<th title="1">1</th>
						<td title="010-5555-5555">010-5555-5555</td>
						<td title="1234">1234</td>
						<td title="2021-04-01">2021-04-01 09:22:55</td>
					</tr>
					<tr id="test2" onclick="golisten(this)">
						<th title="1">1</th>
						<td title="010-5555-5555">010-5555-5555</td>
						<td title="1234">1234</td>
						<td title="2021-04-01">2021-04-01 09:22:55</td>
					</tr>
				<%-- <c:forEach items="${loglist }" var="log" varStatus="cnt">
					<tr>
						<th title="${log.STT_DATE }">${log.STT_DATE }</th>
						<td title="${log.STT_CENTER }">${log.STT_CENTER }</td>
						<td title="${log.STT_USER }">${log.STT_USER }</td>
						<td title="${log.STT_IP }">${log.STT_IP }</td>
					</tr>
				</c:forEach> --%>
				</tbody>
			</table>
		</div>
		<!-- 페이지 -->
		<input type="hidden" id="now_page" name="now_page" value="${nowPage }">
		<input type="hidden" id="dateSort" name="dateSort" class="sort_class" value="${dateSort }">
	 </form>
		<div class="paging_box">
			 <form class="paging">
				<input type="hidden" value="1"> 
				<a href="javascript;" title="FIRST" class="pre01">FIRST</a>
				<a href="javascript:;" title="PREV" class="pre02">PREV</a> 
							<strong>1</strong> 
				<a href="javascript:" title="2" class="txt"> 2 </a> 
				<a href="javascript:" title="NEXT" class="next">NEXT</a> 
				<a href="javascript:" title="LAST" class="next_end">LAST</a>
			</form> 
		<%-- 	 ${pageTag} --%>
		</div>
	</div>


</body>
</html>