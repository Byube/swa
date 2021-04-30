<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내선번호관리</title>
<link rel="stylesheet" href="resources/css/logtable.css">


</head>
<body>

<div class="con">
	 <form id="swa_list" method="post" action="/stt/searchlog">
		<div class="con_sel">
		</div>
		<!-- 테이블 -->
		<a href="javascript:;" class="btn_pup" title="멤버추가" onclick="insertMem()">+</a>
		<div class="table">
			<table class="tb_1" summary="게시판 테이블">
				<caption style="font-size: 0">게시판</caption>
				<colgroup>
					<col width="5%">
					<col width="20%">
					<col width="10%">
					<col width="15%">
					<col />
					<col width="20%">
					<col width="7%">
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
				<c:forEach items="${swalist }" var="swa" varStatus="cnt">
					<tr lang="${swa.SWA_SEQ }">
						<th title="${cnt.count }" id="${swa.SWA_SEQ }">${cnt.count }</th>
						<td title="${swa.SWA_CENTER }" id="ucenter${swa.SWA_SEQ }">${swa.SWA_CENTER }</td>
						<td title="${swa.SWA_INNUM }" id="uinnum${swa.SWA_SEQ }">${swa.SWA_INNUM }</td>
						<td title="${swa.SWA_ID }" id="uid${swa.SWA_SEQ }">${swa.SWA_ID }</td>
						<td title="${swa.SWA_NAME }" id="uname${swa.SWA_SEQ }">${swa.SWA_NAME }</td>
						<td title="수정버튼">
						    <a href="javascript:;" class="btn_modify" title="수정" onclick="upDate(${swa.SWA_SEQ })" >수정</a>
						    <a href="javascript:;" class="btn_modify ok" title="확인" id="yesGoup" style="display: none;">확인</a>
						    <a href="javascript:;" class="btn_modify cancel" title="취소" id="noCancel" style="display: none;">취소</a>
						</td>
						<td title="삭제버튼"><a href="javascript:;" class="btn_del" title="삭제" onclick="deleteSwaMem(${swa.SWA_SEQ })">삭제</a></td>
					</tr>
			
				</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- 페이지 -->
		<input type="hidden" id="now_page" name="now_page" value="${nowPage }">
	 </form>
		<div class="paging_box">
			 ${pageTag} 
		</div>
		
		<!-- 팝업-멤버추가 -->
		<div class="pup_wrap" style="display: none;">
            <div class="pup_head">
                <h3 id="swa_title">멤버추가</h3>
                <a href="javascript:;" class="btn_close" title="닫기" onclick="closeMem()">닫기</a>
            </div>
            <div class="pup_cont">
            <form action="/stt/insertSwaMem" id="insertMem" method="post">
                <table class="pup_tb" summary="멤버추가 리스트">
                    <caption>팝업 멤버추가 리스트</caption>
                    <colgroup>
                        <col width="20%">
                        <col width="20%">
                        <col width="20%">
                        <col />
                    </colgroup>
                    <thead>
                        <tr>
                            <th>센터</th>
                            <th>내선번호</th>
                            <th>ID</th>
                            <th>이름</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><input type="text" title="센터입력란"  placeholder="센터명" id="SWA_CENTER" name="SWA_CENTER"/></td>
                            <td><input type="number" title="내선번호입력란"  placeholder="내선번호" id="SWA_INNUM" name="SWA_INNUM"/></td>
                            <td><input type="text" title="ID입력란"  placeholder="ID" id="SWA_ID" name="SWA_ID"/></td>
                            <td><input type="text" title="이름입력란"  placeholder="이름" id="SWA_NAME" name="SWA_NAME"/></td>
                        </tr>
                    </tbody>
                </table>
                <input type="hidden" id="swa_seq" name="SWA_SEQ">
            </form>
            </div>
              <p id="okid" style="color: green; display: none;">아이디를 사용하셔도 됩니다.</p>
              <p id="noid" style="color: red; display: none;">해당 아이디는 이미 사용중 입니다.</p>
            <div class="pup_foot">
                <a href="javascript:;" class="btn_check" title="ID중복확인" id="buone" onclick="checkid()">ID중복확인</a>
            	<a href="javascript:;" class="btn_update" title="수정" id="buth" style="display: none;" onclick="updapego()">수정</a>
                <a href="javascript:;" class="btn_save" title="저장" id="butwo" onclick="goinsert()">저장</a>
            </div>
		</div>
	</div>

<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/custom.js"></script>
<script src="resources/js/memList.js"></script>

</body>
</html>