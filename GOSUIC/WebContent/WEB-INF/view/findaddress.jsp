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
<title>고수익 | Home</title>
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
				<a class="navbar-brand" href="index.html"><img
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



				<!-- 메뉴바 -->
				<ul class="main-nav nav navbar-nav navbar-right">
					<li><a href="/GOSUIC/mainform.sp">Home <b class="caret"></b></a>

					</li>
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
					<!--   NAVBAR 의  드롭다운 다운 메뉴 코드 -->
					<!-- <li class="dropdown yamm-fw" data-wow-delay="0.6s">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="200">Template <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <div class="yamm-content">
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <h5>Home pages</h5>
                                                <ul>
                                                    <li>
                                                        <a href="index.html">Home Style 1</a>
                                                    </li>
                                                    <li>
                                                        <a href="index-2.html">Home Style 2</a>
                                                    </li>
                                                    <li>
                                                        <a href="index-3.html">Home Style 3</a>
                                                    </li>
                                                    <li>
                                                        <a href="index-4.html">Home Style 4</a>
                                                    </li>
                                                    <li>
                                                        <a href="index-5.html">Home Style 5</a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-3">
                                                <h5>Pages and blog</h5>
                                                <ul>
                                                    <li><a href="blog.html">Blog listing</a>  </li>
                                                    <li><a href="single.html">Blog Post (full)</a>  </li>
                                                    <li><a href="single-right.html">Blog Post (Right)</a>  </li>
                                                    <li><a href="single-left.html">Blog Post (left)</a>  </li>
                                                    <li><a href="contact.html">Contact style (1)</a> </li>
                                                    <li><a href="contact-3.html">Contact style (2)</a> </li>
                                                    <li><a href="contact_3.html">Contact style (3)</a> </li>
                                                    <li><a href="faq.html">FAQ page</a> </li>
                                                    <li><a href="404.html">404 page</a>  </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-3">
                                                <h5>Property</h5>
                                                <ul>
                                                    <li><a href="property-1.html">Property pages style (1)</a> </li>
                                                    <li><a href="property-2.html">Property pages style (2)</a> </li>
                                                    <li><a href="property-3.html">Property pages style (3)</a> </li>
                                                </ul>

                                                <h5>Properties list</h5>
                                                <ul>
                                                    <li><a href="/GOSUIC/list.sp">Properties list style (1)</a> </li>
                                                    <li><a href="properties-2.html">Properties list style (2)</a> </li>
                                                    <li><a href="properties-3.html">Properties list style (3)</a> </li>
                                                </ul>
                                            </div>
                                            <div class="col-sm-3">
                                                <h5>Property process</h5>
                                                <ul>
                                                    <li><a href="submit-property.jsp">Submit - step 1</a> </li>
                                                    <li><a href="submit-property.jsp">Submit - step 2</a> </li>
                                                    <li><a href="submit-property.jsp">Submit - step 3</a> </li>
                                                </ul>
                                                <h5>User account</h5>
                                                <ul>
                                                    <li><a href="register.html">Register / login</a>   </li>
                                                    <li><a href="user-/GOSUIC/list.sp">Your properties</a>  </li>
                                                    <li><a href="submit-property.jsp">Submit property</a>  </li>
                                                    <li><a href="change-password.html">Change password</a> </li>
                                                    <li><a href="user-profile.html">Your profile</a>  </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                ///.yamm-content -->
					<!-- </li> -->
					<!-- </ul> -->
					<!-- </li> -->

					<!-- 고객문의 메뉴(우선 진행안함) -->
					<!-- <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="contact.html">Contact</a></li> -->
				</ul>
				<!--메뉴바 메뉴입력END-->
				<!--"main-nav nav navbar-nav navbar-right" END  -->

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!-- End of nav bar 상단 메뉴바 END-->



	<!--슬라이드 화면 시작   -->
	<div class="slider-area">
		<div class="slider">
			<div id="bg-slider" class="owl-carousel owl-theme">

				<div class="item">
					<img src="assets/img/mainpage/slide1/skyline001.jpg" alt="슬라이드화면1">
				</div>
				<div class="item">
					<img src="assets/img/mainpage/slide1/skyline002.jpg" alt="슬라이드화면2">
				</div>
				<div class="item">
					<img src="assets/img/mainpage/slide1/skyline003.jpg" alt="슬라이드화면3">
				</div>

			</div>
		</div>
		<div class="slider-content">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-12">
					<div class="search">
						<br> 주소를 검색하세요. <br>
						<hr>
					</div>

					<div>
						<!-- 검색버튼  -->
						
						<button class="btn search1-btn" type="submit" onclick="DaumPostcode()">
							주소 검색<i class="fa fa-search"></i>
						</button>
						
					</div>
					
					
					<br>
					<form action = "list.sp" method ="post">
					<div class="search-form wow pulse">
					<input type="text" name="searchaddr" id="sample4_roadAddress" placeholder="읍/면/동 단위로 검색">
					</div>
					<br>
					<button class="btn search1-btn" type="submit" >
							매물 검색<i class="fa fa-search"></i>
					</button>
					</form>
					<!-- 검색창구분  end -->

					<!-- 검색창 end -->
				</div>
				<!-- class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-12" end -->
			</div>
			<!-- class="row" end  -->
		</div>
		<!--  class="slider-content" end-->
	</div>
	<!--  슬라이드 화면 end = class="slider-area" end -->





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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function DaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                //document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = data.sido+' '+data.sigungu+' '+data.bname;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).embed();
    }
    
    $(document).ready(function(){
  	  var Search = /^[가-힣\s]+$/;
  	  $("form").submit(function(){
  		  if ( !Search.test($.trim($("#sample4_roadAddress").val())))
  			{
  				alert("주소를 입력후 클릭해주세요.");
  				$("#sample4_roadAddress").focus();
  				return false;

  			}
  	  });
    });
</script>
</body>

</html>
