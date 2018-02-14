<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

매번 바뀌는 부분..<br>

<%=request.getAttribute("root") %>
<a href="${root}/user?act=mvmemberlist">회원목록</a>
<%@ include file="/common/footer.jsp" %>




