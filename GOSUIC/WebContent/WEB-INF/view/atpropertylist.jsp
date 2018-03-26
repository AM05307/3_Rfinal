<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	if (session.getAttribute("userEmail") == null) {
%>
<script type="text/javascript">
	alert("로그인후 이용하세요!!");
</script>
<%
	}
%>

<%
	if (request.getParameter("searchaddr") == "") {
%>
<script type="text/javascript">
	alert("입력후 이용하세요!!");
</script>
<%
	}
%>

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
<title>고수익 | 매물목록</title>
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

<link rel="stylesheet" href="assets/css/button.css">
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
						<!--  왼쪽 상단 헤더 -->
						<p>
							<span>고수익</span> <span>부동산 수익률 조회 사이트</span>
						</p>
					</div>
				</div>
				<div
					class="col-md-2 col-md-offset-5  col-sm-3 col-sm-offset-1  col-xs-12">
					<div class="header-half header-social">
						<!--  오른쪽 상단 헤더-->
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
				<!--왼쪽 상단 로고  -->
				<a class="navbar-brand" href="/GOSUIC/mainform.sp"><img
					src="assets/img/mainpage/gosuic_logo3_small.png" alt=""></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse yamm" id="navigation">
				<div class="button navbar-right">

					<!-- 로그인, 회원가입 버튼  -->

					<c:if test="${userEmail eq null}">
						<button class="navbar-btn nav-button wow bounceInRight login"
							onclick=" location.href='/GOSUIC/loginform.sp' "
							data-wow-delay="0.45s">로그인</button>
						<button class="navbar-btn nav-button wow fadeInRight"
							onclick=" location.href='/GOSUIC/joinform.sp' "
							data-wow-delay="0.48s">회원가입</button>
					</c:if>

					<c:if test="${userEmail  ne null}">
						<!-- 로그인한 아이디 표시  -->
						<label for="email"><%=session.getAttribute("userEmail")%>&nbsp;&nbsp;&nbsp;&nbsp;</label>
						<!--로그아웃 버튼 -->
						<button class="navbar-btn nav-button"
							onclick=" location.href='/GOSUIC/UserLogout.sp'">로그아웃</button>
					</c:if>
				</div>

				<ul class="main-nav nav navbar-nav navbar-right">
					<li><a href="/GOSUIC/mainform.sp">Home <b class="caret"></b></a>

					</li>
					<li class="wow fadeInDown" data-wow-delay="0.2s"><a class=""
						href="/GOSUIC/list.sp">매물</a></li>
					<li class="wow fadeInDown" data-wow-delay="0.3s"><a class=""
						href="/GOSUIC/property.sp">매물상세</a></li>
					<li class="wow fadeInDown" data-wow-delay="0.4s"><a class=""
						href="">부동산 정보</a></li>
					<li class="wow fadeInDown" data-wow-delay="0.5s"><a class=""
						href="">회사소개</a></li>
					<c:if test="${userEmail  ne null}">
						<li class="wow fadeInDown" data-wow-delay="0.6s"><a class=""
							href="/GOSUIC/mypage.sp">MyPage</a></li>
					</c:if>
				</ul>
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
					<h1 class="page-title">매물</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- End page header -->

	<!-- property area -->
	<div class="properties-area recent-property"
		style="background-color: #FFF;">
		<div class="container">
			<div class="row">

				<div class="col-md-2 p0 padding-top-40">
					<!--왼쪽 검색바  -->
					<div class="blog-asside-right pr0">
						<div
							class="panel panel-default sidebar-menu wow fadeInRight animated">
							<div class="panel-heading">
								<h3 class="panel-title">광고</h3>
							</div>
						
						</div>


					</div>
				</div>
				<!-- 왼쪽 검색바 end  -->

				<div class="col-md-10  pr0 padding-top-40 properties-page">
					<div class="col-md-10 clear">
						<div class="col-xs-10 page-subheader sorting pl0">
							

						</div>

						<!-- <div class="col-xs-2 layout-switcher">
                            <a class="layout-list" href="javascript:void(0);"> <i class="fa fa-th-list"></i>  </a>
                            <a class="layout-grid active" href="javascript:void(0);"> <i class="fa fa-th"></i> </a>
                        </div>-->
						<!--/ .layout-switcher-->
					</div>

					<!--  매물목록 -->
					<div class="col-md-10">
						<table border="0">
							<tr>
								<th width=33%><label>&nbsp;주소&nbsp;</label></th>
								<th width=15%><label>번지</label></th>
								<th width=20%><label>&nbsp;단지명&nbsp;</label></th>
								<!--<th width=18%><label>&nbsp;전용<br>면적(㎡)&nbsp;</label></th>-->
								<!--<th width=15%><label>&nbsp;층&nbsp;</label></th>-->
								<th><label>&nbsp;매매가&nbsp;</label></th>
								<!--  <th>&nbsp;보증금&nbsp;</th>-->
								<!-- <th>&nbsp;평균<br>월세&nbsp;</th>-->
								<!-- <th>&nbsp;건축년도&nbsp;</th>-->
								<!-- <th>&nbsp;도로명&nbsp;</th>>-->
								<th><label>&nbsp;최대수익률&nbsp;</label></th>
								<th width=5%><label>&nbsp;상세<br>정보&nbsp;
								</label></th>
							</tr>

							<c:if test="${!empty all_list_apt}">

								<c:forEach items="${all_list_apt}" var="ob">
									<tr>
										<form action="/GOSUIC/property.sp" method="post">
											<td><input type="hidden" name="sigungu"
												font-size="0.5em;" readonly value="${ob.sigungu}">${ob.sigungu}</td>
											<td><input type="hidden" name="bunji" font-size="1em;"
												readonly value="${ob.bunji}"> ${ob.bunji}</td>
											<td><input type="hidden" name="danji" font-size="1em;"
												readonly value="${ob.danji}"> ${ob.danji}</td> <input
												type="hidden" name="myunjuk" font-size="1em;" readonly
												value="${ob.myunjuk}"> <input type="hidden"
												name="floor" font-size="1em;" readonly value="${ob.floor}">
											<td><input type="hidden" name="price" font-size="1em;"
												readonly value="${ob.price}">${ob.price}</td>
											<!--  <td><input type="text"  name="deposit" readonly value="${ob.deposit}"></td> -->
											<!-- <td><input type="text"  name="rent" font-size="1em;" readonly value="${ob.rent}"></td> -->
											<td><input type="hidden" name="rent" font-size="1em;"
												readonly value="${ob.suic}"> ${ob.suic}%</td> <input
												type="hidden" name="c_type" font-size="1em;" readonly
												value="${ob.c_type}">
											<td><button
													class="navbar-btn nav-button wow fadeInRight" type="submit"
													data-wow-delay="0.25s">+</button></td>
										</form>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${!empty my_at_propery}">

								<c:forEach items="${my_at_propery}" var="mp">
									<tr>
										<form action="/GOSUIC/property.sp" method="post">
											<td><input type="hidden" name="sigungu"
												font-size="0.5em;" readonly value="${mp.sigungu}">${mp.sigungu}</td>
											<td><input type="hidden" name="bunji" font-size="1em;"
												readonly value="${mp.bunji}"> ${mp.bunji}</td>
											<td><input type="hidden" name="danji" font-size="1em;"
												readonly value="${mp.danji}"> ${mp.danji}</td> <input
												type="hidden" name="myunjuk" font-size="1em;" readonly
												value="${mp.myunjuk}"> <input type="hidden"
												name="floor" font-size="1em;" readonly value="${mp.floor}">
											<td><input type="hidden" name="price" font-size="1em;"
												readonly value="${mp.price}">${mp.price}</td>
											<!--  <td><input type="text"  name="deposit" readonly value="${ob.deposit}"></td> -->
											<!-- <td><input type="text"  name="rent" font-size="1em;" readonly value="${ob.rent}"></td> -->
											<td><input type="hidden" name="rent" font-size="1em;"
												readonly value="${mp.suic}"> ${mp.suic}%</td> <input
												type="hidden" name="c_type" font-size="1em;" readonly
												value="${mp.c_type}">
											<td><button
													class="navbar-btn nav-button wow fadeInRight" type="submit"
													data-wow-delay="0.25s">+</button></td>
										</form>
									</tr>
								</c:forEach>
							</c:if>
						</table>

					</div>

					<div class="col-md-12">
						<div class="pull-right">
							
						</div>
					</div>
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
								<b>부동산 수익률 조회 사이트</b><br> 전국 부동산 매물의 수익률 정보 제공
							</p>
							<ul class="footer-adress">
								<li><i class="pe-7s-map-marker strong"> </i>서울시 서초구</li>
								<li><i class="pe-7s-mail strong"> </i>k4eva1123@gmail.com</li>
								
							</ul>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 wow fadeInRight animated">
						<div class="single-footer">
							<h4>메뉴</h4>
							<div class="footer-title-line"></div>
							<ul class="footer-menu">
								<li><a href="properties.html">매물</a></li>
								<li><a href="/GOSUIC/property.sp">부동산정보</a></li>
								<li><a href="mypage.sp">MyPage</a></li>
								<li><a href="contact.html">회사소개</a></li>
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

	<div class="to-topandend">
		<a href="#"><button class="btn btn-default" title="맨 위로 가기">
				<i class="fa fa-arrow-up"></i> TOP
			</button></a>
	</div>

</body>
</html>


