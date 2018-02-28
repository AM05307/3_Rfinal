<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<head>
<!-- 렌더링 모드 설정 (구 버전의 웹 브라우저에서 관용모드로 렌더링 되게 함)  -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- 페이지 이름  -->
<title>고수익 | 게시판</title>

<!--페이지 설명 시작  -->
<!--meta태그 : data에 대한 정보를 나타내는 태그 -->
<!-- 이 페이지에 관한 설명 -->
<meta name="description" content="GOSUIC is site about real-estate">
<!-- 페이지 작성자-->
<meta name="author" content="TEAM 3">
<!-- 페이지 관련 키워드 -->
<meta name="keyword" content="investment, real-estate, house, building">
<!-- 모바일에서 사용하는 태그. 꽉차게 보여주자 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--페이지 설명 끝 -->

<!-- 구글 폰트 api -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	rel='stylesheet' type='text/css'>

<!--css 링크  -->
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

</head>
<body>
	<!--페이지 맨 위 한 줄 -->
	<div class="header-connect">
		<div class="container">
			<div class="row">
				<div class="col-md-5 col-sm-8  col-xs-12">
					<div class="header-half header-call">
						<!--  왼쪽 상단 헤더 -->
						<p>
							<span>고수익</span> <span>부동산 매물 검색 사이트</span>
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
					src="img/gosuic_logo3_small.png" alt=""></a>
				<div class="collapse navbar-collapse yamm" id="navigation">
					<div class="button navbar-right">
					
				
					
						<!-- 로그인, 회원가입 버튼  -->

						<%-- <c:if test="${userEmail eq null}"> --%>
						<button class="navbar-btn nav-button wow bounceInRight login"
							onclick=" location.href='/GOSUIC/loginform.sp' "
							data-wow-delay="0.45s">로그인</button>
						<button class="navbar-btn nav-button wow fadeInRight"
							onclick=" location.href='/GOSUIC/joinform.sp' "
							data-wow-delay="0.48s">회원가입</button>
						<%--     </c:if> --%>

						<%--     <c:if test="${userEmail  ne null}"> --%>
						<label for="email"><%=session.getAttribute("userEmail")%>
						</label>
						<%-- </c:if> --%>
					</div>
					<!--class="button navbar-right" end  -->

					<!-- 메뉴바 -->
					<ul class="main-nav nav navbar-nav navbar-right">
						<li><a href="/GOSUIC/mainform.sp">Home <b class="caret"></b></a></li>
						<li class="wow fadeInDown" data-wow-delay="0.2s"><a class=""
							href="/GOSUIC/list.sp">매물</a></li>
						<li class="wow fadeInDown" data-wow-delay="0.3s"><a class=""
							href="/GOSUIC/property.sp">매물상세</a></li>
						<li class="wow fadeInDown" data-wow-delay="0.4s"><a class=""
							href="">부동산 정보</a></li>
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a class=""
							href="">게시판</a></li>

					</ul>
					<!-- class="main-nav nav navbar-nav navbar-right" end   -->
				</div>
				<!--class="collapse navbar-collapse yamm"  end  -->
			</div>
			<!--class="navbar-header" end  -->


		</div>
		<!-- class="container" end -->
	</nav>
	<!--class="navbar navbar-default " end  -->

<!-- 페이지 제목 표시되는 부분   -->
<div class="page-head">
		<div class="container">
			<div class="row">
				<div class="page-head-content">
					<h1 class="page-title">게시판</h1>
				</div>
			</div>
		</div>
	</div>


</body>
<%@ include file="/common/header.jsp"%>

매번 바뀌는 부분..
<br>

<%=request.getAttribute("root")%>
<%System.out.println(request.getAttribute("root"));%>
<%-- <a href="${root}/user?act=mvmemberlist">회원목록</a> --%>
<%@ include file="/common/footer.jsp"%>
<!-- Footer area-->
<div class="footer-area">

	<div class=" footer">
		<div class="container">
			<div class="row">

				<div class="col-md-3 col-sm-6 wow fadeInRight animated">
					<div class="single-footer">
						<h4>회사소개</h4>
						<div class="footer-title-line"></div>

						<img src="img/gosuic_logo3_small.png" alt=""
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
							<li><a href="#">MY부동산</a></li>
							<li><a href="submit-property.html">부동산정보</a></li>
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
	<!--class="footer-area" end 밑에 한줄 더 있음-->

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
<!-- 밑에 한줄 부분 end
                 -->
<!-- Footer area end -->
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



