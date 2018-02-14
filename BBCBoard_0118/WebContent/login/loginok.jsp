<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${userInfo != null}">

<script type="text/javascript">
function memberout() {
	if(confirm("정말로 탈퇴???")) {
		document.location.href = "${root}/user/memberout.playdata";
	}
}
</script>

<b>${userInfo.name}(<a>${userInfo.id}</a>)</b>님 안녕하세요.<br>
<a href="">내정보수정</a>
<a href="javascript:memberout();">탈퇴</a>
<c:if test="${userInfo.id == '11111'}">
<a href="">관리자페이지</a>
</c:if>
<a href="${root}/user/logout.playdata">로그아웃</a>
</c:if>







