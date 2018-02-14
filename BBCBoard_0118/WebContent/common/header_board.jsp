<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>  <!-- 4~7 라인 : 임의변수 -->
<c:set var="bcode" value="${querystring.bcode}"/> <!--변수를 만들고 QuaryString값을 넣음  -->
<c:set var="pg" value="${querystring.pg}"/>
<c:set var="key" value="${querystring.key}"/>
<c:set var="word" value="${querystring.word}"/>
<link rel="stylesheet" href="${root}/css/skin_purple.css" type="text/css">
<script type="text/javascript" src="${root}/js/board.js"></script>

<form id="commonForm" name="commonForm" method="get" action=""> <!-- 내가 만든변수를 담고 숨겨서 name과 값을 전달. submit을 했을때  이 내용을 가ㄴ져감  -->
	<input type="hidden" id="bcode" name="bcode" value="${bcode}">
	<input type="hidden" id="pg" name="pg" value="${pg}">
	<input type="hidden" id="key" name="key" value="${key}">
	<input type="hidden" id="word" name="word" value="${word}">
	<input type="hidden" id="seq" name="seq" value="">
</form>