<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.playdata.member.model.MemberDto,com.playdata.util.PageMove"%>
<%
String root = request.getContextPath();

MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
if(memberDto != null) {
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h3><%=memberDto.getName() %>님 메일목록.</h3>
10. 안녕하세요 홍길동<br>
9.  제출하세요.. 관리자<br>
</center>
</body>
</html>
<%
} else {
	PageMove.redirect(request, response, "/login/login.jsp");
}
%>





