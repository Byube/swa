<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<title>운영관리자 계정관리</title>


<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">

<!-- Main css -->
<link rel="stylesheet" href="resources/css/style.css">
<link
	href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700"
	rel="stylesheet">
</head>
<body>

	<!-- Blog Section -->
	<section>
		<div class="container">
			<div class="row">

				<div class="col-md-offset-1 col-md-10 col-sm-12">
					<div class="sub_tit">
						<!--<h3>상수도 STT 모니터링 계정관리</h3>-->
						<h2>운영관리자 계정 삭제 및 권한 관리</h2>
					</div>
                    <div class="admin_box">
                        <div class="admin_ico"><img src="resources/image/ico_admin.png" class="ico_admin"></div>
                        <h3>시스템관리자</h3>
                        <p>admin</p>
                        <span><button id="create-user" class="btn_add">운영자 추가</button></span>
                    </div>
					<!--운영자 추가 입력폼-->
					<div class="dialog" id="dialog-form" title="Create new user" style="display: none;">
						<section id="contact">
						     <div class="container">
						          <div class="row">
						               <div class="col-md-offset-1 col-md-10 col-sm-12">
						                     <div class="alert alert-danger" id="noid" style="display: none;">중복된 아이디 입니다.</div>
						                      <div class="alert alert-success" id="okid" style="display: none;">사용해도 가능한 아이디 입니다.</div>
						
						                    <form action="/stt/addUser" method="post" id="adduser">
						                    	<fieldset>
						                         <div class="col-md-6 col-sm-6">
						                              <input type="text" class="form-control" placeholder="Name" id="STT_NAME" name="STT_NAME">
						                         </div>
						                         <div class="col-md-6 col-sm-6">
						                              <input type="text" class="form-control" placeholder="ID" id="STT_ID" name="STT_ID">
						                         </div>
						                         <div class="col-md-6 col-sm-6">
						                              <input type="text" class="form-control" placeholder="센터명" id="STT_CENTER" name="STT_CENTER">
						                         </div>
						                         <div class="col-md-3 col-sm-4">
						                              <input type="button" class="form-control" value="아이디 중복 체크" id="checkId">
						                         </div>
						                         <div class="col-md-3 col-sm-4">
						                              <input type="submit" class="form-control" value="저장" id="submit">
						                         </div>
						                         </fieldset>
						                    </form>
						               </div>
						          </div>
						     </div>
						</section>
					</div>
                    <!--사용자 리스트-->
                    <div class="user_box">
                        <ul class="user_box_list user_box_head">
                            <li class="ico_user"></li>
                            <li class="stt_name">이름</li>
                            <li class="stt_id">ID</li>
                            <li class="stt_level">Level</li>
                            <li class="stt_date">날짜</li>
                           	<li class="stt_btn">관리자 권한 관리</li>
                            <li class="stt_btn">비밀번호 초기화</li>
                            <li class="stt_btn">운영자 삭제</li>
                        </ul>
                        <c:forEach items="${SwaUser }" var="user" varStatus="cnt">
                        <ul class="user_box_list">
                            <li class="ico_user"><img src="resources/image/ico_user.png"></li>
                            <li class="stt_name" title="${user.STT_NAME }">${user.STT_NAME }</li>
                            <li class="stt_id" title="${user.STT_ID }">${user.STT_ID }</li>
                            <li class="stt_level" title="${user.STT_LEVEL }">${user.STT_LEVEL }</li>
                            <li class="stt_date" title="${user.STT_DATE }">${user.STT_DATE }</li>
                            <c:choose>
									<c:when test="${user.STT_LEVEL eq 1}">
                            <li>
                                <a href="javascript:;" title="관리자 권한" class="btn_user" id="stt_give" onclick="levelChange('${user.STT_SEQ }','add')" > 관리자 권한 부여 </a>
                            </li>
                           			</c:when>
									<c:otherwise>
                            <li>
                                <a href="javascript:;" title="관리자 권한" class="btn_user" id="stt_give" onclick="levelChange('${user.STT_SEQ }','del')" > 관리자 권한 회수 </a>
                            </li>
                           			 </c:otherwise>
							</c:choose>
                            <li>
                                <a href="javascript:;" title="운영자 삭제" class="btn_user" onclick="resetPw('${user.STT_SEQ }')" > 비밀번호 초기화 </a>
                            </li>
                            <li>
                                <a href="javascript:;" title="운영자 삭제" class="btn_user" onclick="deleteUser('${user.STT_SEQ }')" > 운영자 삭제 </a>
                            </li>
                        </ul>
                        </c:forEach>
                    </div>
				</div>
			</div>
		</div>
	</section>
	<!-- SCRIPTS -->

	<script src="resources/js/jquery.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/custom.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="resources/js/createUser.js"></script>

</body>
</html>