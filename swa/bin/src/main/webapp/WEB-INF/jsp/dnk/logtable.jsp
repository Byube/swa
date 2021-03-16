<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그조회</title>
<link rel="stylesheet" href="resources/css/logtable.css">
</head>
<body>

	<div class="con">
		<div class="con_sel">
			<div class="date_search">
				<input type="date" class="date" title="날짜 검색창">
			</div>
			<div class="date_search">
				<input type="date" class="date" title="날짜 검색창">
			</div>

			<select class="sel_01">
				<option value="0" title="전체">전체</option>
				<option value="1" title="box1">box1</option>
				<option value="2" title="box2">box2</option>
				<option value="3" title="box3">box3</option>
				<option value="4" title="box4">box4</option>
				<option value="5" title="box5">box5</option>
			</select> <select class="sel_02">
				<option value="0" title="전체">전체</option>
				<option value="1" title="box1">box1</option>
				<option value="2" title="box2">box2</option>
				<option value="3" title="box3">box3</option>
				<option value="4" title="box4">box4</option>
				<option value="5" title="box5">box5</option>
			</select>

			<div class="search_btn">
				<input
					style="height: 40px; padding: 0 30px; background: #0071bc; color: #fff; border: none; border-radius: 5px;"
					type="button" class="search" value="조회" title="조회 버튼">
			</div>
		</div>
		<!-- 테이블 -->
		<div class="table">
			<table class="tb_1" summary="게시판 테이블">
				<caption style="font-size: 0">게시판</caption>
				<colgroup>
					<col width="20%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="50%">
				</colgroup>

				<thead>
					<tr>
						<th title="작업일시">작업일시
							<div class="updown">
								<a href="javascript:;" class="btn_up" title="오름차순"></a> 
								<a href="javascript:;" class="btn_down" title="내림차순" style="display: none"></a>
							</div>
						</th>
						<th title="센터">센터</th>
						<th title="관리자">관리자</th>
						<th title="변경메뉴">변경메뉴</th>
						<th title="작업내용">작업내용</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th title="일시">2020-11-18 21:21:05</th>
						<td title="센터">전체</td>
						<td title="관리자">관리자1</td>
						<td title="업무매뉴얼">업무매뉴얼</td>
						<td title="작업내용">실업 제목 등록</td>
					</tr>
					<tr>
						<th title="일시">2020-11-18 21:21:05</th>
						<td title="센터">전체</td>
						<td title="관리자">관리자1</td>
						<td title="업무매뉴얼">업무매뉴얼</td>
						<td title="작업내용">실업 제목 등록</td>
					</tr>
					<tr>
						<th title="일시">2020-11-18 21:21:05</th>
						<td title="센터">전체</td>
						<td title="관리자">관리자1</td>
						<td title="업무매뉴얼">업무매뉴얼</td>
						<td title="작업내용">실업 제목 등록</td>
					</tr>
					<tr>
						<th title="일시">2020-11-18 21:21:05</th>
						<td title="센터">전체</td>
						<td title="관리자">관리자1</td>
						<td title="업무매뉴얼">업무매뉴얼</td>
						<td title="작업내용">실업 제목 등록</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- 페이지 -->
		<div class="paging_box">
			<form class="paging">
				<input type="hidden" value="1"> <a href="javascript;"
					title="FIRST" class="pre01">FIRST</a> <a href="javascript:;"
					title="PREV" class="pre02">PREV</a> <strong>1</strong> <a
					href="javascript:" title="2" class="txt"> 2 </a> <a
					href="javascript:" title="NEXT" class="next">NEXT</a> <a
					href="javascript:" title="LAST" class="next_end">LAST</a>
			</form>
		</div>
	</div>


</body>
</html>