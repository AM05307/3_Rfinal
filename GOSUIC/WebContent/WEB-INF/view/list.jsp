<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<% if(session.getAttribute("userEmail") == null) {%>
<script type="text/javascript">
alert("로그인후 이용하세요!!");
</script>
<%} %>

<% if(request.getParameter("searchaddr")=="") {%>
<script type="text/javascript">
alert("입력후 이용하세요!!");
</script>
<%} %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>고수익 | 매물목록</title>
        <meta name="description" content="GARO is a real-estate template">
        <meta name="author" content="Kimarotec">
        <meta name="keyword" content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel='stylesheet' type='text/css'>

        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link rel="icon" href="favicon.ico" type="image/x-icon">

        <link rel="stylesheet" href="assets/css/normalize.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/fontello.css">
        <link href="assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
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
            <span>고수익</span>
            <span>부동산 매물 검색 사이트</span>
          </p>
                        </div>
                    </div>
                    <div class="col-md-2 col-md-offset-5  col-sm-3 col-sm-offset-1  col-xs-12">
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
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                     <!--왼쪽 상단 로고  -->
        <a class="navbar-brand" href="/GOSUIC/mainform.sp"><img src="assets/img/mainpage/gosuic_logo3_small.png" alt=""></a>
      </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse yamm" id="navigation">
                    <div class="button navbar-right">
                    
                                <!-- 로그인, 회원가입 버튼  -->
                      
          <c:if test="${userEmail eq null}">
          <button class="navbar-btn nav-button wow bounceInRight login" onclick=" location.href='/GOSUIC/loginform.sp' " data-wow-delay="0.45s">로그인</button>
          <button class="navbar-btn nav-button wow fadeInRight" onclick=" location.href='/GOSUIC/joinform.sp' " data-wow-delay="0.48s">회원가입</button>
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
                      <li>
            <a href="/GOSUIC/mainform.sp">Home <b class="caret"></b></a>

          </li>
           <li class="wow fadeInDown" data-wow-delay="0.2s"><a class="" href="/GOSUIC/list.sp">매물</a></li>
          <li class="wow fadeInDown" data-wow-delay="0.3s"><a class="" href="/GOSUIC/property.sp">매물상세</a></li>
                    <li class="wow fadeInDown" data-wow-delay="0.4s"><a class="" href="">부동산 정보</a></li>
                    <li class="wow fadeInDown" data-wow-delay="0.5s"><a class="" href="">게시판</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
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
        <div class="properties-area recent-property" style="background-color: #FFF;">
            <div class="container">
                <div class="row">

                <div class="col-md-2 p0 padding-top-40">
                  <!--왼쪽 검색바  -->
                    <div class="blog-asside-right pr0">
                        <div class="panel panel-default sidebar-menu wow fadeInRight animated" >
                            <div class="panel-heading">
                                <h3 class="panel-title">검색</h3>
                            </div>
                            <div class="panel-body search-widget">
                                <form action="" class=" form-inline">
                                    <fieldset>
<div class="row">
                                          <!-- 시/도 검색 드롭다운 메뉴 -->
                                          <div class="form-group">
                                            <select id="ADDR1_SIDO" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="시/도">
                            <!-- 드롭다운 메뉴는 DB에서 불러옴  -->
                                                                    <option>시/도1</option>
                                                                    <option>시/도2</option>
                                                                    <option>시/도3</option>
                                                                    <option>시/도4</option>
                                                                    <option>시/도5</option>
                                                                    <option>시/도6</option>
                                                                </select>
                                          </div>
    </div>

  <div class="row">
                                              <div class="form-group">
                                                <select id="ADDR2_SIGUNGU" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="시/군/구">

                                                                        <option>시/군/구1</option>
                                                                        <option>시/군/구2</option>
                                                                        <option>시/군/구3</option>
                                                                        <option>시/군/구4</option>
                                                                        <option>시/군/구5</option>
                                                                        <option>시/군/구6</option>
                                                                    </select>
                                              </div>
</div>
  <div class="row">
                                              <div class="form-group">
                                                <select id="ADDR3_EUBMYUNDONG" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="읍/면/동">

                                                                        <option>읍/면/동1</option>
                                                                        <option>읍/면/동2</option>
                                                                        <option>읍/면/동3</option>
                                                                        <option>읍/면/동4</option>
                                                                        <option>읍/면/동5</option>
                                                                        <option>읍/면/동6</option>
                                                                    </select>
                                              </div>

</div>


                                    </fieldset>

                                    <!--지역 설정 드롭다운 메뉴 end  -->

                                    <fieldset class="padding-5">
                                        <div class="row">
                                          <div class="form-group">
                                            <input type="text" class="form-control" placeholder="최소가격(단위:만원)">
                                          </div>
                                        </div>
                                    </fieldset>

                                    <fieldset class="padding-5">
                                        <div class="row">
                                          <div class="form-group">
                                            <input type="text" class="form-control" placeholder="최대가격(단위:만원)">
                                          </div>
                                        </div>
                                    </fieldset>

                                    <fieldset class="padding-5">
                                        <div class="row">
                                            <div class="col-xs-6">
                                                <div class="checkbox">
                                                    <label> <input type="checkbox" checked>아파트</label>
                                                </div>
                                            </div>

                                            <div class="col-xs-6">
                                                <div class="checkbox">
                                                    <label> <input type="checkbox">연립</label>
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>

                                    <fieldset class="padding-5">
                                        <div class="row">
                                            <div class="col-xs-6">
                                                <div class="checkbox">
                                                    <label> <input type="checkbox" checked>다세대</label>
                                                </div>
                                            </div>
                                            <div class="col-xs-6">
                                                <div class="checkbox">
                                                    <label> <input type="checkbox" checked>단독</label>
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>

                                    <fieldset class="padding-5">
                                        <div class="row">
                                            <div class="col-xs-6">
                                                <div class="checkbox">
                                                    <label><input type="checkbox">다가구</label>
                                                </div>
                                            </div>

                                        </div>
                                    </fieldset>


                                    <fieldset >
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <input class="button btn largesearch-btn" value="검색" type="submit">
                                            </div>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                        </div>


                    </div>
                </div>
                <!-- 왼쪽 검색바 end  -->

                <div class="col-md-10  pr0 padding-top-40 properties-page">
                    <div class="col-md-10 clear">
                        <div class="col-xs-10 page-subheader sorting pl0">
                            <ul class="sort-by-list">
                              <li class="active">
                                 <a href="javascript:void(0);" class="order_by_date" data-orderby="property_date" data-order="ASC">
                                        최신순 <i class="fa fa-sort-amount-asc"></i>
                                    </a>

                                </li>
                                <li class="">
                                    <a href="javascript:void(0);" class="order_by_price" data-orderby="property_price" data-order="DESC">
                                        높은가격순 <i class="fa fa-sort-numeric-desc"></i>
                                    </a>
                                </li>
                                <li class="">
                                    <a href="javascript:void(0);" class="order_by_percent" data-orderby="property_price" data-order="DESC">
                                        수익률 높은순 <i class="fa fa-sort-numeric-desc"></i>
                                    </a>
                                </li>
                            </ul><!--/ .sort-by-list-->

                            <div class="items-per-page">
                                <label for="items_per_page"><b>페이지당 매물 수 :</b></label>
                                <div class="sel">
                                    <select id="items_per_page" name="per_page">
                                        <option value="10">10</option>
                                        <option selected="selected" value="20">20</option>
                                        <option value="30">30</option>

                                    </select>
                                </div><!--/ .sel-->
                            </div><!--/ .items-per-page-->
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
  <tr >
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
    <th width=5%><label>&nbsp;상세<br>정보&nbsp;</label></th>
</tr>

<c:if test="${!empty all_list}">

			<c:forEach items="${all_list}" var="ob">
				<tr>
				<form action="/GOSUIC/property.sp" method="post">
					<td><input type="hidden"  name="sigungu" font-size="0.5em;" readonly value="${ob.sigungu}">${ob.sigungu}</td>
					<td><input type="hidden"  name="bunji" font-size="1em;" readonly value="${ob.bunji}">${ob.bunji}</td>
					<td><input type="hidden"  name="danji" font-size="1em;" readonly value="${ob.danji}">${ob.danji}</td>
					<input type="hidden"  name="myunjuk" font-size="1em;" readonly value="${ob.myunjuk}">
					<input type="hidden"  name="floor" font-size="1em;" readonly value="${ob.floor}">
					<td><input type="hidden"  name="price" font-size="1em;" readonly value="${ob.price}">${ob.price}</td>
					<!--  <td><input type="text"  name="deposit" readonly value="${ob.deposit}"></td> --> 
					<!-- <td><input type="text"  name="rent" font-size="1em;" readonly value="${ob.rent}"></td> -->
					<td><input type="hidden"  name="rent" font-size="1em;" readonly value="${ob.suic}">${ob.suic}%</td>
					<td><button class="navbar-btn nav-button wow fadeInRight" type="submit" data-wow-delay="0.25s">+</button></td>
				</form>
				</tr>
			</c:forEach>
		</c:if>

    </table>

                    </div>

                    <div class="col-md-12">
                        <div class="pull-right">
                            <div class="pagination">
                                <ul>
                                    <li><a href="#">이전</a></li>
                                    <li><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">다음</a></li>
                                </ul>
                            </div>
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

                    <img src="assets/img/mainpage/gosuic_logo3_small.png" alt="" class="wow pulse" data-wow-delay="1s">
                    <p>부동산 매물 검색 사이트<br>
                    전국의 부동산 매물 정보를 제공합니다
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
                      <li><a href="properties.html">매물</a> </li>
                      <li><a href="#">MY부동산</a> </li>
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
                          <a href="single.html">
                                                      <img src="assets/img/demo/small-proerty-2.jpg">
                                                  </a>
                          <span class="blg-date">2018-01-3</span>

                        </div>
                        <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                          <h6> <a href="single.html">공지사항 제목1</a></h6>
                          <p style="line-height: 17px; padding: 8px 2px;">공지 내용1 ...</p>
                        </div>
                      </li>

                      <li>
                        <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                          <a href="single.html">
                                                      <img src="assets/img/demo/small-proerty-2.jpg">
                                                  </a>
                          <span class="blg-date">2018-01-02</span>

                        </div>
                        <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                          <h6> <a href="single.html">공지사항 소제목2</a></h6>
                          <p style="line-height: 17px; padding: 8px 2px;">공지 내용2...</p>
                        </div>
                      </li>

                      <li>
                        <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                          <a href="single.html">
                                                      <img src="assets/img/demo/small-proerty-2.jpg">
                                                  </a>
                          <span class="blg-date">2018-01-01</span>

                        </div>
                        <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                          <h6> <a href="single.html">공지사항 소제목 3</a></h6>
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
                                    <li><a href="#">개인정보처리방침</a> </li>
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
                  <span> (C) <a href="http://www.KimaroTec.com">KimaroTheme</a> , All rights reserved 2016  </span>
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
    </body>
</html>


