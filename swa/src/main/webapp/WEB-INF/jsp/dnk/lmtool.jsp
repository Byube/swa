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

<title>LM Tool</title>


<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">

<!-- Main css -->
<link rel="stylesheet" href="resources/css/style.css">
<link
	href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700"
	rel="stylesheet">

<c:if test="${empty level}">
	<c:redirect url="/logout"></c:redirect>
</c:if>
</head>
<body>
	
	<!-- Navigation section  -->
	<input type="hidden" id="userId" value="${userId }">
	<input type="hidden" id="menuKey" value="${menuKey }">
	<input type="hidden" id="check" value="${check }">
	<input type="hidden" id="seq" value="${seq }">>
		<div class="navbar navbar-default navbar-static-top" role="navigation">
		     <div class="container">
		
		          <div class="navbar-header">
		               <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		                    <span class="icon icon-bar"></span>
		                    <span class="icon icon-bar"></span>
		                    <span class="icon icon-bar"></span>
		               </button>
		               <a href="/logout" class="navbar-brand"><i class="fa fa-magnet"></i></a>
		          </div>
		          <div class="collapse navbar-collapse">
		               <ul class="nav navbar-nav navbar-right">
		              	<c:choose>
		              		<c:when test="${level eq 0}">
		                    <li><a href="javascript:;" id="edit" onclick="checkUrl('edit')">음성전사</a></li>
		                    <li><a href="javascript:;" id="lmdb" onclick="checkUrl('lmdb')">LM DB 관리</a></li>
		                    <li><a href="javascript:;" onclick="searchlog('player')">음성재생</a></li>
		                    <li><a href="javascript:;" id="oov" onclick="checkUrl('oov')">무결성 확인</a></li>
		                    <li><a href="javascript:;" id="build" onclick="checkUrl('build')">음성인식 모델 빌드</a></li>
		                    <li><a href="javascript:;" id="testset-checkrate" onclick="checkUrl('testset-checkrate')">인식률 확인</a></li>
		                    <li><a href="javascript:;" id="upgrade" onclick="checkUrl('upgrade')">음성인식 모델 배포</a></li>
		                    <li><a href="javascript:;" id="monitoring/stt.html" onclick="checkUrl('monitoring/stt.html')">파일 STT</a></li>
		                    <li><a href="javascript:;" id="monitoring/call.html" onclick="checkUrl('monitoring/call.html')">STT 운영 모니터링</a></li>
		                    <li><a href="javascript:;" id="status" onclick="checkUrl('status')">리소스 모니터링</a></li>
		                    
		                    <c:if test="${User_Id eq 'admin' }">
		                    <li><a href="javascript:;" onclick="searchlog('listenAgo')">과거녹취 청취</a></li>
		                    <li><a href="javascript:;" onclick="searchlog('createUser')">운영관리자 관리</a></li>
		                    <li><a href="javascript:;" onclick="searchlog('searchlog')">로그테이블</a></li>
		                    <li><a href="javascript:;" onclick="searchlog('swaMem')">상담사리스트</a></li>
		                    <li><a href="javascript:;" onclick="searchlog('test')">테스트</a></li>
		                    </c:if>
		                    </c:when>
		                    <c:otherwise>
		                    <li><a href="javascript:;" id="edit" onclick="checkUrl('edit')">음성전사</a></li>
		                    <li><a href="javascript:;" id="lmdb" onclick="checkUrl('lmdb')">LM DB 관리</a></li>
		                    <li><a href="javascript:;" onclick="searchlog('player')">음성재생</a></li>
		                    </c:otherwise>
		               </c:choose>
		               </ul>
		          </div>
		
		  	</div>
		</div>
	
	
	<div class="container">
	<object class="ob" type="text/html" 
			width="100%" height="800">
		<embed class="eb" width="100%" height="800"></embed>
		Error: Embedded data could not be displayed.
	</object>
	</div>


<!-- SCRIPTS -->

	<script src="resources/js/jquery.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/custom.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="resources/js/lmtool.js"></script>

</body>
</html>