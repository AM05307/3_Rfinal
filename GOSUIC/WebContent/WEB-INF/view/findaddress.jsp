<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
<title>����� | Home</title>
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
					src="assets/img/mainpage/gologosample.png" alt=""></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse yamm" id="navigation">
				<div class="button navbar-right">

					<!-- �α���, ȸ������ ��ư  -->

					<c:if test="${userEmail eq null}">
						<button class="navbar-btn nav-button wow bounceInRight login"
							onclick=" location.href='/GOSUIC/loginform.sp' "
							data-wow-delay="0.45s">�α���</button>
						<button class="navbar-btn nav-button wow fadeInRight"
							onclick=" location.href='/GOSUIC/joinform.sp' "
							data-wow-delay="0.48s">ȸ������</button>
					</c:if>

					<c:if test="${userEmail  ne null}">
						<!-- �α����� ���̵� ǥ��  -->
						<label for="email"><%=session.getAttribute("userEmail")%>&nbsp;&nbsp;&nbsp;&nbsp;</label>
						<!--�α׾ƿ� ��ư -->
						<button class="navbar-btn nav-button"
							onclick=" location.href='/GOSUIC/UserLogout.sp'">�α׾ƿ�</button>
					</c:if>
				</div>



				<!-- �޴��� -->
				<ul class="main-nav nav navbar-nav navbar-right">
					<li><a href="/GOSUIC/mainform.sp">Home <b class="caret"></b></a>

					</li>
					<!-- /TestMVC03/list.sp -->
					<!--   <li class="wow fadeInDown" data-wow-delay="0.2s"><a class="" href="/GOSUIC/list.sp">�Ź�</a></li>-->

					<li class="wow fadeInDown" data-wow-delay="0.2s"><a class=""
						href="/GOSUIC/list.sp">�Ź�</a></li>
					<li class="wow fadeInDown" data-wow-delay="0.3s"><a class=""
						href="/GOSUIC/property.sp">�Ź���</a></li>
					<li class="wow fadeInDown" data-wow-delay="0.4s"><a class=""
						href="">�ε��� ����</a></li>
					<li class="wow fadeInDown" data-wow-delay="0.5s"><a class=""
						href="">�Խ���</a></li>
					<!--   NAVBAR ��  ��Ӵٿ� �ٿ� �޴� �ڵ� -->
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

					<!-- ������ �޴�(�켱 �������) -->
					<!-- <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="contact.html">Contact</a></li> -->
				</ul>
				<!--�޴��� �޴��Է�END-->
				<!--"main-nav nav navbar-nav navbar-right" END  -->

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!-- End of nav bar ��� �޴��� END-->



	<!--�����̵� ȭ�� ����   -->
	<div class="slider-area">
		<div class="slider">
			<div id="bg-slider" class="owl-carousel owl-theme">

				<div class="item">
					<img src="assets/img/mainpage/slide1/skyline001.jpg" alt="�����̵�ȭ��1">
				</div>
				<div class="item">
					<img src="assets/img/mainpage/slide1/skyline002.jpg" alt="�����̵�ȭ��2">
				</div>
				<div class="item">
					<img src="assets/img/mainpage/slide1/skyline003.jpg" alt="�����̵�ȭ��3">
				</div>

			</div>
		</div>
		<div class="slider-content">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-12">
					<div class="search">
						<br> �ּҸ� �˻��ϼ���. <br>
						<hr>
					</div>

					<div>
						<!-- �˻���ư  -->
						
						<button class="btn search1-btn" type="submit" onclick="DaumPostcode()">
							�ּ� �˻�<i class="fa fa-search"></i>
						</button>
						
					</div>
					<br>
					<form action = "property.sp" method ="post">
					<div class="search-form wow pulse">
					<input type="text" name="search" id="sample4_roadAddress" placeholder="��/��/��/�� �ּ�">
					</div>
					<br>
					<button class="btn search1-btn" type="submit" >
							�Ź� �˻�<i class="fa fa-search"></i>
					</button>
					</form>
					<!-- �˻�â����  end -->

					<!-- �˻�â end -->
				</div>
				<!-- class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-12" end -->
			</div>
			<!-- class="row" end  -->
		</div>
		<!--  class="slider-content" end-->
	</div>
	<!--  �����̵� ȭ�� end = class="slider-area" end -->





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
    //�� ���������� ���θ� �ּ� ǥ�� ��Ŀ� ���� ���ɿ� ����, �������� �����͸� �����Ͽ� �ùٸ� �ּҸ� �����ϴ� ����� �����մϴ�.
    function DaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ�.

                // ���θ� �ּ��� ���� ��Ģ�� ���� �ּҸ� �����Ѵ�.
                // �������� ������ ���� ���� ��쿣 ����('')���� �����Ƿ�, �̸� �����Ͽ� �б� �Ѵ�.
                var fullRoadAddr = data.roadAddress; // ���θ� �ּ� ����
                var extraRoadAddr = ''; // ���θ� ������ �ּ� ����

                // ���������� ���� ��� �߰��Ѵ�. (�������� ����)
                // �������� ��� ������ ���ڰ� "��/��/��"�� ������.
                if(data.bname !== '' && /[��|��|��]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // �ǹ����� �ְ�, ���������� ��� �߰��Ѵ�.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // ���θ�, ���� ������ �ּҰ� ���� ���, ��ȣ���� �߰��� ���� ���ڿ��� �����.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // ���θ�, ���� �ּ��� ������ ���� �ش� ������ �ּҸ� �߰��Ѵ�.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // �����ȣ�� �ּ� ������ �ش� �ʵ忡 �ִ´�.
                document.getElementById('sample4_postcode').value = data.zonecode; //5�ڸ� �������ȣ ���
                document.getElementById('sample4_roadAddress').value = data.sido + data.sigungu + data.bname;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // ����ڰ� '���� ����'�� Ŭ���� ���, ���� �ּҶ�� ǥ�ø� ���ش�.
                if(data.autoRoadAddress) {
                    //����Ǵ� ���θ� �ּҿ� ������ �ּҸ� �߰��Ѵ�.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(���� ���θ� �ּ� : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(���� ���� �ּ� : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).embed();
    }
</script>
</body>

</html>
