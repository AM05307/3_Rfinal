<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>고수익 | Home page</title>
<meta name="description" content="GARO is a real-estate template">
<meta name="author" content="Kimarotec">
<meta name="keyword"
	content="html5, css, bootstrap, property, real-estate theme , bootstrap template, Pingendo conference event aquamarine free template bootstrap 4 ">
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

<!--지도 링크  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

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
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
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
			<li><a href="/GOSUIC/mainform.sp">Home <b class="caret"></b></a></li>

			<li class="wow fadeInDown" data-wow-delay="0.2s"><a class=""
				href="/GOSUIC/list.sp">매물</a></li>
			<li class="wow fadeInDown" data-wow-delay="0.3s"><a class=""
				href="property-1.html">매물상세</a></li>
			<li class="wow fadeInDown" data-wow-delay="0.4s"><a class=""
				href="">부동산 정보</a></li>
			<li class="wow fadeInDown" data-wow-delay="0.5s"><a class=""
				href="">게시판</a></li>


		</ul>
	</div>
</nav>
<!-- End of nav bar 상단 메뉴바 END-->

</div>
<!-- 상단 END-->

<div class="page-head">
	<div class="page-head-content">
		<h1 class="page-title">상세 매물 정보</h1>
	</div>
</div>
</head>
<!-- End page header -->
<!-- Body content -->
<body onload="initialize()" class="text-left">



	<!-- property area -->
	<div class="content-area single-property"
		style="background-color: #FCFCFC;">
		&nbsp;
		<div class="container">

			<div class="clearfix padding-top-40">

				<div class="col-md-9 single-property-content prp-style-1 ">


					<div class="single-property-wrapper">
						<!--매물 이름, 가격  -->
						<div class="single-property-header">
							<br>
							<h1 class="property-title pull-left">${detail_sil.get(0).sigungu} ${detail_sil.get(0).bunji}</h1>
							<span class="property-price pull-right">조회수 117</span>

						</div>
						<!--매물 이름, 가격end   -->
						<!-- .property-meta -->

						<div class="section additional-details">

							<h4 class="s-property-title">매물 정보</h4>
								<c:if test="${!empty detail_sil}">

							<ul class="additional-details-list clearfix">
								<!--  <li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">도로명 주소</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"><input type="text" name="contract_year_month"
														font-size="1em;" readonly value="${detail_sil.get(0).doromyung}"></span>
								</li>-->

								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">단지명</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${detail_sil.get(0).danji}</span>
								</li>
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">전용면적</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${detail_sil.get(0).myunjuk}㎡</span>
								</li>

								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">층</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${detail_sil.get(0).floor} 층</span>
								</li>
								
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">건축년도</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${detail_sil.get(0).gunchook_year} 년도</span>
								</li>
								
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">관심매물</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">
									<input value="등록하기" type="submit">
									</span>
								</li>
							</ul>
							<br>
							</c:if>
							
						</div>
						<!-- End description area  -->

						<div class="section additional-details">

							<h4 class="s-property-title">수익률 정보</h4>
							<c:if test="${!empty detail_suic}">
							<ul class="additional-details-list clearfix">
							
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">최고수익률</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${detail_suic.maxRate}(%)</span>
								</li>
 								
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">최저수익률</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${detail_suic.minRate}(%)</span>
								</li>
							
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">평균매매가</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${detail_suic.avgPrice}</span>
								</li>

								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">최고매매가</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${detail_suic.maxPrice}(만원)</span>
								</li>
								
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">최저매매가</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${detail_suic.minPrice}(만원)</span>
								</li>
								
							</ul>		
						</c:if>
						</div>
						<!-- End additional-details area  -->
						<div class="section additional-details">

							<h4 class="s-property-title">비용 정보</h4>
								<!--<c:if test="${!empty detail_suic}">-->
							<ul class="additional-details-list clearfix">
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">취득세율</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry">--  (%)</span>
								</li>

								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">예상 취등록세</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> --(만원)</span>
								</li>
								
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">중계수수료율</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> --  (%)</span>
								</li>
								
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">예상 중계 수수료</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> --(만원)</span>
								</li>
 								
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">예상 대리등기비용</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> --(만원)</span>
								</li>

							</ul>		
						<!--</c:if>-->
						</div>
						<!-- 부대비용 정보 end  -->

							<div class="section additional-details">

							<h4 class="s-property-title">상세 거래 내역</h4>
								<c:if test="${!empty detail_sil}">

									<c:forEach items="${detail_sil}" var="sil">
										<ul class="additional-details-list clearfix">
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">계약일</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${sil.contract_year_month}</span>
								</li>

								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">계약시기(10일간격)</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${sil.contract_day}</span>
								</li>

								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">거래형태</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> 매매</span>
								</li>
								
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">거래금액</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${sil.price} (만원)</span>
								</li>
								
								
							</ul>
							<br>
							</c:forEach>
							</c:if>
							
						</div>
						<!-- 상세 거래 내역 end  -->
						<c:if test="${!empty detail_jw}">
						<div class="section additional-details">

							<h4 class="s-property-title">전월세 내역</h4>
								

									<c:forEach items="${detail_jw}" var="jw">
										<ul class="additional-details-list clearfix">
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">계약일</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${jw.contract_year_month}</span>
								</li>

								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">계약시기(10일간격)</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${jw.contract_day}</span>
								</li>
							
								
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">거래형태</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${jw.junwol}</span>
								</li>
								
								
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">보증금</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${jw.deposit} (만원)</span>
								</li>
								
								<c:if test="${jw.rent != 0}">
								<li><span class="col-xs-6 col-sm-4 col-md-4 add-d-title">월세</span>
									<span class="col-xs-6 col-sm-8 col-md-8 add-d-entry"> ${jw.rent} (만원)</span>
								</li>
								</c:if>
								
								
							</ul>
							<br>
							</c:forEach>
							
							
						</div>
						</c:if>
						<!-- 전월세 내역 end  -->
						
						<c:if test="${!empty geocode}">
						<div class="section property-features">

							<h4 class="s-property-title">위치 정보</h4>
							<!--//////////////////////////////////////////////지도시작///////////////////////////////////////////////////  -->

							<script type="text/javascript">
								window.onload = function() {
									initialize();
								}
							</script>


							<div class="form-group">
								<input id="address" type="tel" class="form-control"
									name="address" id="address" value=""
									placeholder="주소를 '시/군/동/상점명' 자세히 입력해주세요"> <input
									type="button" value="지도출력하기" onclick="codeAddress()">
								<!-- <div class="board_write_content-footer"
  									style="text-align: center">
  									<a href="template_list.html"
  										class="btn btn-outline-light btn-lg m-2"> 지도 출력하기</a>
  								</div> -->
								<div class="form-group" id="map" ></div>
							</div>

							<!-- JavaScript dependencies -->
							<script src="https://code.jquery.com/jquery-3.2.1.min.js"
								crossorigin="anonymous"
								integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="></script>
							<script
								src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
								crossorigin="anonymous"
								integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"></script>
							<script
								src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
								crossorigin="anonymous"
								integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"></script>
							<!-- Script: Smooth scrolling between anchors in a same page -->
							<script src="js/smooth-scroll.js"></script>
							<script src="js/notice.js"></script>
							<!-- Script: Make my navbar transparent when the document is scrolled to top -->
							<script src="js/navbar-ontop.js"></script>
							<!-- Script: Animated entrance -->
							<script src="js/animate-in.js"></script>
							<script src="js/board_write.js"></script>
							
							<script async defer
								src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDZEvRrjLrP0xN51w1ljXwQovC5Fz8BT-k&callback=initMap"></script>
							<script type="text/javascript">
								var geocoder;
								var map;
								function initialize() {
									geocoder = new google.maps.Geocoder();
									var latlng = new google.maps.LatLng(
											${geocode.get(0)}, ${geocode.get(1)});
									var mapOptions = {
										zoom : 17,
										center : latlng
									}
									map = new google.maps.Map(document
											.getElementById('map'), mapOptions);
									 
									var marker = new google.maps.Marker({
								          position: latlng,
								          map: map,
								          title: 'Hello!'
								        });
								}

								function codeAddress() {
									var address = document
											.getElementById('address').value;
									geocoder
											.geocode(
													{
														'address' : address
													},
													function(results, status) {
														if (status == 'OK') {
															map
																	.setCenter(results[0].geometry.location);
															var marker = new google.maps.Marker(
																	{
																		map : map,
																		draggable : true,
																		animation : google.maps.Animation.DROP,
																		position : results[0].geometry.location
																	});
														} else {
															alert('Geocode was not successful for the following reason: '
																	+ status);
														}
													});
								}
							</script>

							<!-- Script: Smooth scrolling between anchors in a same page -->
							<script src="js/smooth-scroll.js"></script>
							<script async defer
								src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDZEvRrjLrP0xN51w1ljXwQovC5Fz8BT-k&callback=initMap"></script>
							<!--/////////////////////////////////////////////지도끝////////////////////////////////////////////////////  -->

						</div>
						</c:if>
						<!-- End features area  -->
					</div>
					<!--  class="single-property-wrapper" end-->
				</div>
				<!--class="col-md-9 single-property-content prp-style-1 " end  -->


				<!--///////////////////// 오른쪽 사이드바 시작  -->
				<div class="col-md-3 p0">
					<aside class="sidebar sidebar-property blog-asside-right">
					<!--  오른쪽 사이드바 맨 위 회색 칸 -->
					<div class="dealer-widget"></div>

					<div
						class="panel panel-default sidebar-menu similar-property-wdg wow fadeInRight animated">
						<div class="panel-heading">
							<h3 class="panel-title">최근 본 매물</h3>
						</div>
						<div class="panel-body recent-property-widget">
							<ul>
								<li>
									<div class="col-md-3 col-sm-3 col-xs-3 blg-thumb p0">
										<a href="single.html"><img
											src="assets/img/demo/small-property-2.jpg"></a>
									</div>
									<div class="col-md-8 col-sm-8 col-xs-8 blg-entry">
										<h6>
											<a href="single.html">최근 본 매물1</a>
										</h6>
										<span class="property-price">11억</span>
									</div>
								</li>
								<li>
									<div class="col-md-3 col-sm-3  col-xs-3 blg-thumb p0">
										<a href="single.html"><img
											src="assets/img/demo/small-property-1.jpg"></a>
									</div>
									<div class="col-md-8 col-sm-8 col-xs-8 blg-entry">
										<h6>
											<a href="single.html">최근 본 매물2</a>
										</h6>
										<span class="property-price">12억</span>
									</div>
								</li>
								<li>
									<div class="col-md-3 col-sm-3 col-xs-3 blg-thumb p0">
										<a href="single.html"><img
											src="assets/img/demo/small-property-3.jpg"></a>
									</div>
									<div class="col-md-8 col-sm-8 col-xs-8 blg-entry">
										<h6>
											<a href="single.html">최근 본 매물3</a>
										</h6>
										<span class="property-price">13억</span>
									</div>
								</li>

							</ul>
						</div>
					</div>

					<!--  광고-->
					<div
						class="panel panel-default sidebar-menu wow fadeInRight animated">
						<div class="panel-heading">
							<h3 class="panel-title">광고</h3>
						</div>
						<div class="panel-body recent-property-widget">
							<img src="assets/img/ads.jpg">
						</div>
					</div>

					</aside>
				</div>
				<!--  class="col-md-3 p0"  end  -->

				<!-- /////////////////////////오른쪽 바 끝 /////////////////////////////// -->

			</div>
			<!--class="clearfix padding-top-40" end   -->

		</div>
		<!--class container end   -->
	</div>
	<!--class="content-area single-property" end  -->


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




	<script src="assets/js/vendor/modernizr-2.6.2.min.js"></script>
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
	<script type="text/javascript" src="assets/js/lightslider.min.js"></script>
	<script src="assets/js/main.js"></script>

	<script>
		$(document).ready(function() {

			$('#image-gallery').lightSlider({
				gallery : true,
				item : 1,
				thumbItem : 9,
				slideMargin : 0,
				speed : 500,
				auto : true,
				loop : true,
				onSliderLoad : function() {
					$('#image-gallery').removeClass('cS-hidden');
				}
			});
		});
	</script>

</body>
</html>
