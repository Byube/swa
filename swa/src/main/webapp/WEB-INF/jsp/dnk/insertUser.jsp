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

<title>운영자 계정 생성</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">

<!-- Main css -->
<link rel="stylesheet" href="resources/css/style.css">
<link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,700" rel="stylesheet">

</head>
<body>

<!-- Contact Section -->

<section id="contact">
     <div class="container">
          <div class="row">

               <div class="col-md-offset-1 col-md-10 col-sm-12">
                    <div class="section-title">
                         <h3>운영자 계정 생성</h3>
                         <h2>상수도 STT LM툴 확인 운영자 계정 생성</h2>
                    </div>

                    <form action="/addUser" method="post">
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
                              <input type="submit" class="form-control" value="저장">
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
<script src="resources/js/insertUser.js"></script>

</body>
</html>