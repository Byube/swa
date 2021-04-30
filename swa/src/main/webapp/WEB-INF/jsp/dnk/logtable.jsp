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
</head>
<body>

<!-- PRE LOADER -->

<div class="preloader">
     <div class="sk-spinner sk-spinner-wordpress">
          <span class="sk-inner-circle"></span>
     </div>
</div>
<div class="con">
	 <form id="stt_list_form" method="post" action="/stt/searchlog">
		<div class="con_sel">
			<div class="date_search">
				<input type="date" class="date" title="날짜 검색창" id="startDate" name="startDate" min="${dateMin }" onclick="checkDate()" value="${startDate }">
			</div>
			<div class="date_search">
				<input type="date" class="date" title="날짜 검색창" id="endDate" name="endDate"  onclick="haveMin('${dateMin }')" value="${endDate }">
			</div>

			<select class="sel_01" name="STT_ID">
			<option title="ID" value="${sttuser }">ID</option>
			<option value="all" title="전체">전체</option>
			<c:forEach items="${mlist }" var="clist" varStatus="cnt">
				<option value="${clist.STT_ID }" title="${clist.STT_ID }" id="stt_center" >${clist.STT_ID }</option>
			</c:forEach>
			</select> 
			<select class="sel_02" name="STT_MENU">
				<option value="${sttmenu }" title="접근메뉴">접근메뉴</option>
				<option value="all" title="전체">전체</option>
			<c:forEach items="${menu }" var="m" varStatus="cnt">	
				<option value="${m.STT_MENU }" title="${m.STT_MENU }">${m.STT_MENU }</option>
			</c:forEach>
			</select>

			<div class="search_btn">
				<input
					style="height: 40px; padding: 0 30px; background: #0071bc; color: #fff; border: none; border-radius: 5px;"
					type="button" class="search" value="조회" title="조회 버튼" id="searChSort">
			</div>
			<div class="search_btn">
				<input
					style="height: 40px; padding: 0 30px; background: #0071bc; color: #fff; border: none; border-radius: 5px;"
					type="button" class="search" value="초기화" title="조회 버튼" id="allSearch">
			</div>
			<div class="search_btn">
				<a href="javascript:;" class="btn_excel" title="엑셀다운로드" id="excel">엑셀다운로드</a>
			</div>
		</div>
		<!-- 테이블 -->
		<div class="table">
			<table class="tb_1" summary="게시판 테이블">
				<caption style="font-size: 0">게시판</caption>
				<colgroup>
					<col width="15%">
					<col width="10%">
					<col width="10%">
					<col width="15%">
					<col width="10%">
					<col />
				</colgroup>
				<thead>
					<tr>
						<th title="작업일시">작업일시
							<div class="updown">
								<a href="javascript:;" id="date_sort"  onclick="dateSort()"></a> 
								<!-- <a href="javascript:;" class="btn_down" title="내림차순" onclick="dateSort('dateDown')" style="display: none"></a> -->
							</div>
						</th>
						<th title="센터">센터</th>
						<th title="관리자">관리자</th>
						<th title="ip">ip</th>
						<th title="변경메뉴">접근메뉴</th>
						<th title="작업내용">작업내용</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${loglist }" var="log" varStatus="cnt">
					<tr>
						<th title="${log.STT_DATE }">${log.STT_DATE }</th>
						<td title="${log.STT_CENTER }">${log.STT_CENTER }</td>
						<td title="${log.STT_USER }">${log.STT_USER }</td>
						<td title="${log.STT_IP }">${log.STT_IP }</td>
						<td title="${log.STT_MENU }">${log.STT_MENU }</td>
						<td title="${log.STT_CONTENTS }">${log.STT_CONTENTS }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- 페이지 -->
		<input type="hidden" id="now_page" name="now_page" value="${nowPage }">
		<input type="hidden" id="dateSort" name="dateSort" class="sort_class" value="${dateSort }">
		<input type="hidden" id="minda" value="${dateMin }">
	 </form>
		<div class="paging_box">
			 ${pageTag}
		</div>
	</div>

	
	
<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/custom.js"></script>
<script src="resources/js/logtable.js" type="text/javascript" ></script>

</body>
</html>