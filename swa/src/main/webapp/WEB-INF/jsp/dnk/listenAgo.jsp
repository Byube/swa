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

	<link rel="stylesheet" href="resources/tui-grid/tui-grid.css" />
  <!--   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> -->
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/logtable.css">
    <link rel="stylesheet" href="resources/css/player.css" />

</head>
<body>

<!-- PRE LOADER -->

<div class="preloader">
     <div class="sk-spinner sk-spinner-wordpress">
          <span class="sk-inner-circle"></span>
     </div>
</div>


	<div class="con">
	 <form id="mst_list_form" method="post" action="/stt/listenAgo">
	     <div class="liten_tb">
            <div class="con_sel liten">
                <div class="date_search">
                    <input type="date" class="date" title="날짜 검색창" id="startDate" name="startDate" min="${dateMin }" onclick="checkDate()" value="${startDate }">
                </div>
                <div class="date_search">
                    <input type="date" class="date" title="날짜 검색창" id="endDate" name="endDate"   value="${endDate }">
                </div>
        
                <div class="search_btn">
                    <input type="text" placeholder="내선번호" title="검색창" id="mem_num" name="STT_MEM_NUM" value="${mem_num }">
                    <input type="text" placeholder="고객번호" title="검색창" id="user_num" name="STT_USER_NUM" value="${user_num }">
                    <input type="text" class="keyword" placeholder="키워드입력" title="검색창" id="key_word" name="key_word" value="${key_word }">
                    <input
                        style="height: 40px; padding: 0 30px; background: #0071bc; color: #fff; border: none; border-radius: 5px;"
                        type="button" class="btn_search" value="조회" title="조회 버튼" id="searChSort">
                </div>

            </div>
		    <!-- 테이블 -->
			<table class="tb_1" summary="게시판 테이블">
				<caption style="font-size: 0">게시판</caption>
				<colgroup>
					<col width="10%">
					<col width="30%">
					<col width="20%">
					<col />
				</colgroup>
				<thead>
					<tr>
						<th title="순">순</th>
						<th title="시간">시간</th>
						<th title="내선번호">내선번호</th>
						<th title="센터">고객전화</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${agolist }" var="ago" varStatus="cnt">
					<tr id="test" onclick="getText('${ago.STT_CALL1}','${ago.STT_CALL2}','${ago.STT_CALL3}','${ago.STT_USER_NUM}','${ago.STT_MEM_NUM}','${ago.STT_CALL }','${ago.STT_DTM }')">
						<th title="${cnt.count }">${cnt.count }</th>
						<td title="${ago.STT_DTM }">${ago.STT_DTM }</td>
						<td title="${ago.STT_MEM_NUM}">${ago.STT_MEM_NUM}</td>
						<td title="${ago.STT_USER_NUM}">${ago.STT_USER_NUM}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<!-- 테이블 -->
		<div class="liten_tb">
			<div class="audio_tb">
                <p style="margin:0;">
                    <audio id="audio" preload="metadata"></audio>
                    <div class="audio-wrap">
                      <img id="btn_play" src="resources/image/baseline_play_arrow_black_18dp.png" width="28" height="28" style="margin: 10px;">
                      <span id="audiocur" class="audio-timeNow">0:00</span>
                      <span id="audiomax" class="audio-timeAll">0:00</span>
                      <div class="flc-vr" style="margin-left: 20px; margin-right: 10px;">
                        <a id="btn_half" style="font-size: 12px; cursor: pointer;">.5x</a>
                        <a id="btn_double" style="font-size: 12px; cursor: pointer;">2x</a>
                      </div>
                      <input id="progress" class="audio-progressbar" type="range" min="0" max="100" step="1" />
                      <div class="audio-volume">
                        <input class="audio-volumebar" type="range" />
                        <img src="resources/image/baseline_volume_up_black_18dp.png" width="28" height="28" />
                      </div>
                    </div>

                    <div class="audio_txt" id="grid"></div>
                    <script src="resources/js/player.js"></script>
                    <script src="resources/tui-grid/tui-grid.js"></script>
                </p>
            </div>
		</div>
		<!-- 페이지 -->
		<input type="hidden" id="now_page" name="now_page" value="${nowPage }">
		<input type="hidden" id="dateMin" name="dateMin" value="${dateMin }">
		
	 </form>
		<div class="paging_box">
		 	 ${pageTag} 
		</div>
	</div>


<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/custom.js"></script>
<script src="resources/js/listenAgo.js"></script>
<script src="resources/js/player.js"></script>
<script src="resources/tui-grid/tui-grid.js"></script>
</body>
</html>