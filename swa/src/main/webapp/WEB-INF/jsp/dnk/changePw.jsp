<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<title>비밀번호 변경</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">

<!-- Main css -->
<link rel="stylesheet" href="resources/css/style.css">
<!-- <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet"> -->

</head>
<body>

<!-- Contact Section -->

<section id="contact">
     <div class="container">
          <div class="row">

               <div class="col-md-offset-1 col-md-10 col-sm-12">
                    <div class="section-title">
                         <h3>비밀번호 변경</h3>
                         <h2>비밀 번호는 영문, 숫자, 특수문자를 혼합하여 입력 하시길 바랍니다.</h2>
                    </div>
                         <div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
                         <br>
                         <div class="alert alert-danger" id="alert-danger">비밀번호가 일치 하지 않습니다.</div>
                         <div class="alert alert-warning" id="alert-warning">비밀번호 규격 확인 바랍니다.</div>
                    <form action="/stt/changePws" method="post" id="changegogo">
                         <div class="col-md-6 col-sm-6">
                              <input type="password" class="form-control" placeholder="비밀번호" id="stt_pw" name="STT_PW">
                         </div>
                         <div class="col-md-6 col-sm-6">
                              <input type="password" class="form-control" placeholder="비밀번호확인" id="stt_pw2" name="STT_PW2">
                         </div>
                         <div class="col-md-3 col-sm-4">
                              <input type="submit" id="submit" class="form-control" value="저장" onclick="gochange()">
                         </div>
                         <input type="hidden" id="seq" name="STT_SEQ" value="${seq }">
                    </form>
               </div>

          </div>
     </div>
</section>


<!-- SCRIPTS -->

<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/custom.js"></script>
<script src="resources/js/changePw.js"></script>

</body>
</html>