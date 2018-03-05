<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<% if(session.getAttribute("userEmail") == null) {%>
<script type="text/javascript">
alert("�α����� �̿��ϼ���!!");
</script>
<%} %>

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
<title>����� | Home</title>
<meta name="description" content="GARO is a real-estate template">
<meta name="author" content="Kimarotec">
<meta name="keyword"
	content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
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
						<!--  ���� ��� ��� -->
						<p>
							<span>�����</span> <span>�ε��� �Ź� �˻� ����Ʈ</span>
						</p>
					</div>
				</div>
				<div
					class="col-md-2 col-md-offset-5  col-sm-3 col-sm-offset-1  col-xs-12">
					<div class="header-half header-social">
						<!--  ������ ��� ���-->
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
				<!--���� ��� �ΰ�  -->
				<a class="navbar-brand" href="index.html"><img
					src="assets/img/mainpage/gosuic_logo3_small.png" alt=""></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse yamm" id="navigation">
				<div class="button navbar-right">
					<!-- �α���, ȸ������ ��ư  -->
					
					<button class="navbar-btn nav-button wow bounceInRight login"
						onclick=" location.href='/GOSUIC/loginform.sp' "
						data-wow-delay="0.45s">�α���</button>
					<button class="navbar-btn nav-button wow fadeInRight"
						onclick=" location.href='/GOSUIC/joinform.sp'" data-wow-delay="0.48s">ȸ������</button>
				</div>

				<!-- �޴��� -->
				<ul class="main-nav nav navbar-nav navbar-right">
					<li><a href="index.html">Home <b class="caret"></b></a></li>
					<!-- /TestMVC03/list.sp -->
					<!--   <li class="wow fadeInDown" data-wow-delay="0.2s"><a class="" href="/GOSUIC/list.sp">�Ź�</a></li>-->

					<li class="wow fadeInDown" data-wow-delay="0.2s"><a class=""
						href="/GOSUIC/list3.sp">�Ź�</a></li>
					<li class="wow fadeInDown" data-wow-delay="0.3s"><a class=""
						href="/GOSUIC/property.sp">�Ź���</a></li>
					<li class="wow fadeInDown" data-wow-delay="0.4s"><a class=""
						href="">�ε��� ����</a></li>
					<li class="wow fadeInDown" data-wow-delay="0.5s"><a class=""
						href="">�Խ���</a></li>
					<c:if test="${userEmail  ne null}">
						<li class="wow fadeInDown" data-wow-delay="0.6s"><a class=""
						href="/GOSUIC/mypage.sp">MyPage</a></li>
					</c:if>
				
				</ul>
				<!--�޴��� �޴��Է�END-->
				<!--"main-nav nav navbar-nav navbar-right" END  -->

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!-- End of nav bar ��� �޴��� END-->

        <div class="content-area error-page" style="background-color: #FCFCFC; padding-bottom: 55px;">
            <div class="container">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
                        <h2 class="error-title">500</h2>
                        <p>Sorry, the page you requested may have been moved or deleted</p>
                        <a href="index.html" class="btn btn-default">Home</a>
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
							<h4>ȸ��Ұ�</h4>
							<div class="footer-title-line"></div>

							<img src="assets/img/mainpage/gosuic_logo3_small.png" alt=""
								class="wow pulse" data-wow-delay="1s">
							<p>
								�ε��� �Ź� �˻� ����Ʈ<br> ������ �ε��� �Ź� ������ �����մϴ�
							</p>
							<ul class="footer-adress">
								<li><i class="pe-7s-map-marker strong"> </i>����� ���ʱ�</li>
								<li><i class="pe-7s-mail strong"> </i> email@highprofit.com</li>
								<li><i class="pe-7s-call strong"> </i> 02-3333-3333</li>
							</ul>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 wow fadeInRight animated">
						<div class="single-footer">
							<h4>�޴�</h4>
							<div class="footer-title-line"></div>
							<ul class="footer-menu">
								<li><a href="/GOSUIC/list.sp">�Ź�</a></li>
								<li><a href="/GOSUIC/property.sp">MY�ε���</a></li>
								<li><a href="submit-property.jsp">�ε�������</a></li>
								<li><a href="contact.html">�Խ���</a></li>
							</ul>
						</div>
					</div>
					<!-- class="col-md-3 col-sm-6 wow fadeInRight animated" end -->
					<div class="col-md-3 col-sm-6 wow fadeInRight animated">
						<div class="single-footer">
							<h4>��������</h4>
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
											<a href="single.html">�������� ����1</a>
										</h6>
										<p style="line-height: 17px; padding: 8px 2px;">���� ����1 ...</p>
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
											<a href="single.html">�������� ������2</a>
										</h6>
										<p style="line-height: 17px; padding: 8px 2px;">���� ����2...</p>
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
											<a href="single.html">�������� ������ 3</a>
										</h6>
										<p style="line-height: 17px; padding: 8px 2px;">���� ����3...</p>
									</div>
								</li>


							</ul>
						</div>
					</div>
					<div class="col-md-3 col-sm-6 wow fadeInRight animated">
						<div class="single-footer news-letter">
							<h4>�ȳ�</h4>
							<div class="footer-title-line"></div>
							<ul class="footer-menu">
								<li><a href="single.html">�̿���</a></li>
								<li><a href="#">��������ó����ħ</a></li>
								<li><a href="#">�̸��Ϲ��ܼ����ź�</a></li>
								<li><a href="#">å���Ѱ�� ��������</a></li>
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

</body>

</html>
