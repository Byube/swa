<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그조회</title>
<link rel="stylesheet" href="resources/css/logtable.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="resources/js/memList.js"></script>

</head>
<body>

	<div class="con">
	 <form id="stt_list_form" method="post" action="/searchlog">
		<div class="con_sel">
			<%-- <div class="date_search">
				<input type="date" class="date" title="날짜 검색창" id="startDate" name="startDate" min="${dateMin }" onclick="checkDate()" value="${startDate }">
			</div>
			<div class="date_search">
				<input type="date" class="date" title="날짜 검색창" id="endDate" name="endDate"  onclick="haveMin('${dateMin }')" value="${endDate }">
			</div> --%>

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
		<!-- 	<div class="search_btn">
				<input
					style="height: 40px; padding: 0 30px; background: #0071bc; color: #fff; border: none; border-radius: 5px;"
					type="button" class="search" value="조회" title="조회 버튼" id="searChSort">
			</div>
			<div class="search_btn">
				<input
					style="height: 40px; padding: 0 30px; background: #0071bc; color: #fff; border: none; border-radius: 5px;"
					type="button" class="search" value="전체" title="전체" id="allSearch">
			</div>
			<div class="search_btn"><a href="/insertSwaMem">
				<input
					style="height: 40px; padding: 0 30px; background: #0071bc; color: #fff; border: none; border-radius: 5px;"
					type="button" class="search" value="상담사 추가" title="상담사 추가" id="insertSwaMem"></a>
			</div> -->
		</div>
		<!-- 테이블 -->
		<div class="table">
			<table class="tb_1" summary="게시판 테이블">
				<caption style="font-size: 0">게시판</caption>
				<colgroup>
					<col width="5%">
					<col width="15%">
					<col width="20%">
					<col width="10%">
					<col width="20%">
					<col width="15%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th title="순">순</th>
						<th title="센터">센터</th>
						<th title="내선번호">내선번호</th>
						<th title="ID">ID</th>
						<th title="이름">이름</th>
						<th title="수정">수정</th>
						<th title="삭제">삭제</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th title="1">1</th>
						<td title="강서구">강서구</td>
						<td title="1234">1234</td>
						<td title="1234">test111</td>
						<td title="마돈나">마돈나</td>
						<td title="수정버튼">수정버튼</td>
						<td title="삭제버튼">삭제버튼</td>
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