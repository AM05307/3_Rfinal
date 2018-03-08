<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>고수익 | 로그인</title>
<meta name="description" content="GARO is a real-estate template">
<meta name="author" content="Kimarotec">
<meta name="keyword"
	content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	rel='stylesheet' type='text/css'>

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">

<link rel="stylesheet" href="assets/css/normalize.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/fontello.css">
<link href="assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css"
	rel="stylesheet">
<link href="assets/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
<link href="assets/css/animate.css" rel="stylesheet" media="screen">
<link rel="stylesheet" href="assets/css/bootstrap-select.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/icheck.min_all.css">
<link rel="stylesheet" href="assets/css/price-range.css">
<link rel="stylesheet" href="assets/css/owl.carousel.css">
<link rel="stylesheet" href="assets/css/owl.theme.css">
<link rel="stylesheet" href="assets/css/owl.transitions.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/responsive.css">
<!--새로 추가한 css  -->
<link rel="stylesheet" href="assets/css/main.css">
</head>
<body>

	<div id="preloader">
		<div id="status">&nbsp;</div>
	</div>
	<!-- Body content -->


	<div class="header-connect">
		<div class="container">
			<div class="row">
				<div class="col-md-5 col-sm-8  col-xs-12">
					<div class="header-half header-call">
						<!--왼쪽 상단 헤더  -->
						<p>
							<span>고수익</span> <span>부동산 매물 검색 사이트</span>
						</p>
					</div>
				</div>
				<div
					class="col-md-2 col-md-offset-5  col-sm-3 col-sm-offset-1  col-xs-12">
					<div class="header-half header-social">
						<!--오른쪽 상단 칸   -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--End top header -->

	<nav class="navbar navbar-default ">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navigation">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- 왼쪽 상단 로고 -->
				<a class="navbar-brand" href="/GOSUIC/mainform.sp"><img
					src="assets/img/mainpage/gosuic_logo3_small.png" alt=""></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse yamm" id="navigation">
				<div class="button navbar-right">

					<!-- 로그인, 회원가입 버튼  -->
					<button class="navbar-btn nav-button wow bounceInRight login"
						onclick=" location.href='/GOSUIC/loginform.sp' "
						data-wow-delay="0.45s">로그인</button>
					<button class="navbar-btn nav-button wow fadeInRight"
						onclick=" location.href='/GOSUIC/joinform.sp'"
						data-wow-delay="0.48s">회원가입</button>

				</div>
				<!-- 메뉴바 -->
				<ul class="main-nav nav navbar-nav navbar-right">
					<li><a href="index.sp">Home <b class="caret"></b></a></li>
					<!-- /TestMVC03/list.sp -->
					<!--   <li class="wow fadeInDown" data-wow-delay="0.2s"><a class="" href="/GOSUIC/list.sp">매물</a></li>-->

					<li class="wow fadeInDown" data-wow-delay="0.2s"><a class=""
						href="/GOSUIC/list.sp">매물</a></li>
					<li class="wow fadeInDown" data-wow-delay="0.3s"><a class=""
						href="/GOSUIC/property.sp">매물상세</a></li>
					<li class="wow fadeInDown" data-wow-delay="0.4s"><a class=""
						href="">부동산 정보</a></li>
					<li class="wow fadeInDown" data-wow-delay="0.5s"><a class=""
						href="">게시판</a></li>

				</ul>
				<!--메뉴바 메뉴입력END-->
				<!--"main-nav nav navbar-nav navbar-right" END  -->


			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!-- End of nav bar -->

	<div class="page-head">
		<div class="container">
			<div class="row">
				<div class="page-head-content">
					<h1 class="page-title">로그인</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- End page header -->


	<!-- register-area -->
	<div class="register-area"
		style="background-color: rgb(249, 249, 249);">
		<div class="container">


			<div class="col-md-6">
				<div class="box-for overflow">
					
					<form action="/GOSUIC/UserLogin.sp" method="post">
						<div class="col-md-12 col-xs-12 login-blocks">
							<h2>로그인</h2>
						
							<div class="form-group">
								<label for="email">이메일 주소</label> <input type="text"
									class="form-control" name="userEmail">
							</div>
							<div class="form-group">
								<label for="password">비밀번호</label> <input type="password"
									class="form-control" name="password1">
								</div>
							</div>
						
						<!-- 로그인 실패시 문구 -->
							<c:if test="${param.CheckEmail == 'fail'}">
                                <span style="color: red; font: bold;">
                                 <c:out value="아이디, 비밀번호를 확인하세요" />
                                 </span>
                           </c:if>
							
							<div class="text-center">
								<button type="submit" id="login" class="btn btn-default">로그인</button>
							</div>
							
						</form>
																
						<br> <br> <br> <br>
						<!-- 로그인 칸 밑 공백 -->
					</div>

				</div>
			</div>

		</div>


	<!-- Footer area-->
	<div class="footer-area">

		<div class=" footer">
			<div class="container">
				<div class="row">

					<div class="col-md-3 col-sm-6 wow fadeInRight animated">
						<div class="single-footer">
							<h4>회사소개</h4>
							<div class="footer-title-line"></div>

							<img src="assets/img/mainpage/gosuic_logo3_small.png" alt=""
								class="wow pulse" data-wow-delay="1s">
							<p>
								부동산 매물 검색 사이트<br> 전국의 부동산 매물 정보를 제공합니다
							</p>
							<ul class="footer-adress">
								<li><i class="pe-7s-map-marker strong"> </i>서울시 서초구</li>
								<li><i class="pe-7s-mail strong"> </i> email@highprofit.com</li>
								<li><i class="pe-7s-call strong"> </i> 02-3333-3333</li>
							</ul>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 wow fadeInRight animated">
						<div class="single-footer">
							<h4>메뉴</h4>
							<div class="footer-title-line"></div>
							<ul class="footer-menu">
								<li><a href="properties.html">매물</a></li>
								<li><a href="#">부동산정보</a></li>
								<li><a href="mypage.sp">MyPage</a></li>
								<li><a href="contact.html">게시판</a></li>
							</ul>
						</div>
					</div>
					<!-- class="col-md-3 col-sm-6 wow fadeInRight animated" end -->
					<div class="col-md-3 col-sm-6 wow fadeInRight animated">
						<div class="single-footer">
							<h4>공지사항</h4>
							<div class="footer-title-line"></div>
							<ul class="footer-blog">
								<li>
									<div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
										<a href="single.html"> <img
											src="assets/img/demo/small-proerty-2.jpg">
										</a> <span class="blg-date">2018-01-3</span>

									</div>
									<div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
										<h6>
											<a href="single.html">공지사항 제목1</a>
										</h6>
										<p style="line-height: 17px; padding: 8px 2px;">공지 내용1 ...</p>
									</div>
								</li>

								<li>
									<div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
										<a href="single.html"> <img
											src="assets/img/demo/small-proerty-2.jpg">
										</a> <span class="blg-date">2018-01-02</span>

									</div>
									<div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
										<h6>
											<a href="single.html">공지사항 소제목2</a>
										</h6>
										<p style="line-height: 17px; padding: 8px 2px;">공지 내용2...</p>
									</div>
								</li>

								<li>
									<div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
										<a href="single.html"> <img
											src="assets/img/demo/small-proerty-2.jpg">
										</a> <span class="blg-date">2018-01-01</span>

									</div>
									<div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
										<h6>
											<a href="single.html">공지사항 소제목 3</a>
										</h6>
										<p style="line-height: 17px; padding: 8px 2px;">공지 내용3...</p>
									</div>
								</li>


							</ul>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 wow fadeInRight animated">
						<div class="single-footer news-letter">
							<h4>안내</h4>
							<div class="footer-title-line"></div>
							<ul class="footer-menu">
								<li><a href="single.html">이용약관</a></li>
								<li><a href="#">개인정보처리방침</a></li>
								<li><a href="#">이메일무단수집거부</a></li>
								<li><a href="#">책임한계와 법적고지</a></li>
							</ul>
						</div>
					</div>

				</div>
				<!--  class="row" end -->

			</div>
			<!-- class="container"  end  -->
		</div>
		<!--class="footer-area" end   -->

		<div class="footer-copy text-center">
			<div class="container">
				<div class="row">
					<div class="pull-left">
						<span> (C) <a href="http://www.KimaroTec.com">KimaroTheme</a>
							, All rights reserved 2016
						</span>
					</div>

				</div>
			</div>
		</div>

	</div>
	<!--"footer-area" end   -->

	<script src="assets/js/modernizr-2.6.2.min.js"></script>

	<script src="assets/js/jquery-1.10.2.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/bootstrap-select.min.js"></script>
	<script src="assets/js/bootstrap-hover-dropdown.js"></script>

	<script src="assets/js/easypiechart.min.js"></script>
	<script src="assets/js/jquery.easypiechart.min.js"></script>

	<script src="assets/js/owl.carousel.min.js"></script>
	<script src="assets/js/wow.js"></script>

	<script src="assets/js/icheck.min.js"></script>
	<script src="assets/js/price-range.js"></script>

	<script src="assets/js/main.js"></script>
	
	<script type="text/javascript">
	/*  
	 $(document).ready(function(){
		  $('#login').on('click',function(){
			  $.ajax({
				  type:'POST',
				  url:'/GOSUIC/UserLogin.sp',
				  data:{
					  "userEmail":$('#userEmail').val(),
					  "password1":$('#password1').val()
				  },
					success:function(data){
						if($.trim(data)!=0){
							alert("아이디, 비밀번호를 확인해주세요");
						}else{
							alert("로그인 성공.");
						}
						}
			  });
		  });
	  });
	   */
	   
	</script>
	
</body>
</html>
