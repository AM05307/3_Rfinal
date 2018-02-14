<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();

String id = request.getParameter("id");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>아이디 확인</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript">
function idcheck() {
	var id = document.idckform.id.value;
	//alert(id.length);
	if(id == "") {
		alert("검색할 아이디 입력~~~");
		return;
	} else if(id.length <4 || id.length > 16) {
		alert("아이디는 4자이상 16자 이하입니다.");
		return;
	} else {
		document.idckform.action = "<%=root%>/user";
		document.idckform.submit();
	}
}

function useid(uid) {
	opener.document.memberform.id.value = uid;
	self.close();
}
</script>
</head>
 
<body>
<form name="idckform" method="get" action="" onsubmit="return false;">
<input type="hidden" id="act" name="act" value="idcheck">
<div class="container" align="center">
	<div align="center" style="width:500px; border:1px solid #cccccc; padding:20px; margin-top:30px">
		<h4>아이디 중복검사</h4>
		<hr />
		<div class="form-inline" style="margin-bottom:5px">
			<label style="width:80px">아이디</label>
			<input id="id" name="id" type="text" class="form-control" placeholder="아이디를 입력하세요." onkeypress="javascript:if(event.keyCode == 13) {idcheck();}"/>
			<input type="button" class="btn btn-success" value="중복확인" onclick="javascript:idcheck();" />
		</div>
		<hr />
<%
if(id == null) {//검색한적이 없다면.
%>
		<div align="center">
			검색할 아이디를 정확히 입력하세요.
		</div>
<%
} else {//검색한적이 있다면..
	int idcount = Integer.parseInt(request.getParameter("idcount"));
	if(idcount == 0) {
%>		
		<div align="center">
			<b><%=id%></b>는 사용할수 있습니다.
			<input type="button" class="btn btn-success" value="사용" onclick="javascript:useid('<%=id%>');" />
		</div>
<%
	} else {
%>		
		<div align="center">
			<b><%=id%></b>는 사용할수 없습니다.<br>
			다른 아이디를 검색 하세요.
		</div>
<%
	}
}
%>		
	</div>
</div>
</form>
</body>
</html>