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

<title>LM툴 로그인</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">

<!-- Main css -->
<link rel="stylesheet" href="resources/css/style.css">
<link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">

</head>
<body>

<!-- PRE LOADER -->

<div class="preloader">
     <div class="sk-spinner sk-spinner-wordpress">
          <span class="sk-inner-circle"></span>
     </div>
</div>


<!-- Contact Section -->

<section id="contact">
     <div class="container">
          <div class="row">

               <div class="col-md-offset-1 col-md-10 col-sm-12">
                    <div class="section-title">
                         <h3>음성인식 LM 확인 툴</h3>
                         <h2>실시간 음성 확인부터 전사 및 음성인식 엔진모니터링</h2>
                    </div>
										
                    <form action="/stt/stt_login" method="post">
                         <div class="col-md-6 col-sm-6">
                              <input type="text" class="form-control" id="user_id" name="STT_ID" placeholder="ID">
                         </div>
                        
                         <div class="col-md-6 col-sm-6">
                              <input type="password" class="form-control" id="user_pw" name="STT_PW" placeholder="PassWord">
                         </div>
                        
                         <div class="col-md-3 col-sm-4">
                              <input type="submit" class="form-control" value="Login">
                         </div>
                    </form>
               </div>

          </div>
     </div>
</section>




<!-- SCRIPTS -->

<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/custom.js"></script>


</body>
</html> 