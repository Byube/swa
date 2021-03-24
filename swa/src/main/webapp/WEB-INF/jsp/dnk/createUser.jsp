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
	<section id="blog">
		<div class="container">
			<div class="row">

				<div class="col-md-offset-1 col-md-10 col-sm-12">
					<div class="section-title">
						<h3>상수도 STT 모니터링 계정관리</h3>
						<h2>운영관리자 계정 삭제 및 권한 관리</h2>
					</div>

					<div class="blog-post-thumb">
						<div class="blog-post-format">
							<span>
								<a href="#"><img src="resources/image/author-image1.jpg" class="img-responsive img-circle"> 관리자 </a>
							</span>
							<span>
								<i class="fa fa-date"></i> Admin
							</span> 
							<span>
								<i class="fa fa-date"></i> 시스템관리자
							</span> 
						</div>
						
					</div>

					<div class="blog-post-thumb">
						<c:forEach items="${SwaUser }" var="user" varStatus="cnt">
							<div class="blog-post-format">
								<span>
									<a href="#"><img src="resources/image/author-image2.jpg" class="img-responsive img-circle">${user.STT_NAME }</a>
								</span>
								<span>
									<i class="fa fa-date"></i> ${user.STT_ID }
								</span> 
								<span>
									<i class="fa fa-date"></i> ${user.STT_LEVEL }
								</span> 
								<span>
									<i class="fa fa-date"></i> ${user.STT_DATE }
								</span> 
								<c:choose>
									<c:when test="${user.STT_LEVEL eq 1}">
										<span>
											<a href="javascript:;" title="관리자 권한" class="btn_user" id="stt_give" onclick="levelChange('${user.STT_SEQ }','add')" > 관리자 권한 부여 </a>
										</span>
									</c:when>
									<c:otherwise>
										<span>
											<a href="javascript:;" title="관리자 권한" class="btn_user" id="stt_give" onclick="levelChange('${user.STT_SEQ }','del')" > 관리자 권한 회수 </a>
										</span>
									</c:otherwise>
								</c:choose>
								
								<span>
									<a href="javascript:;" title="운영자 삭제" class="btn_user" onclick="resetPw('${user.STT_SEQ }')" > 비밀번호 초기화 </a>
								</span>
								<span>
									<a href="javascript:;" title="운영자 삭제" class="btn_user" onclick="deleteUser('${user.STT_SEQ }')" > 운영자 삭제 </a>
								</span>
								
							<!-- 	<span>
									<a href="#" class="btn_user" id="stt_gback" style="display: none;"> 관리자 권한 회수 </a>
								</span> -->
							</div>
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