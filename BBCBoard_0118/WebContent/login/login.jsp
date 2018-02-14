<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String saveid = "";
String checkid = "";

Cookie cookie[] = request.getCookies();
if(cookie != null) {
	int len = cookie.length;
	for(int i=0;i<len;i++) {
		if("nid_sid".equals(cookie[i].getName())) {
			saveid = cookie[i].getValue();
			checkid = " checked=\"checked\"";
			break;
		}
	}
}
%>  
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	$("#loginBtn").click(function() {
		if($("#id").val() == "") {
			alert("아이디 입력~~~~");
			return;
		} else if($("#pass").val() == "") {
			alert("비밀번호 입력~~~~");
			return;
		} else {
			document.loginform.action = "${root}/user/login.playdata";
			document.loginform.submit();
		}
	});
});


function movejoin() {
	document.location.href = "${root}/user?act=mvjoin";
}
</script>

<form name="loginform" method="post" action="">
<div align="center">
     <div align="center" style="width:400px; border:1px solid #cccccc; padding:20px; margin-top:30px">
        <h4>로그인</h4>
        <hr />
        
        <div class="form-inline" style="margin-bottom:5px; text-align: right">
        <input id="idsv" name="idsv" type="checkbox" class="form-control" value="saveid"<%=checkid %>/>
        <label style="width:80px">아이디저장</label>
        </div>
        
        <div class="form-inline" style="margin-bottom:5px">
        <label style="width:80px">아이디</label>
        <input id="id" name="id" type="text" class="form-control" value="<%=saveid %>" placeholder="아이디를 입력하세요."/>
        </div>
        
        <div class="form-inline" style="margin-bottom:5px">
        <label style="width:80px">비밀번호</label>
        <input id="pass" name="pass" type="password" class="form-control" placeholder="비밀번호를 입력하세요."/>
        </div>
        
        <hr />
        
        <div align="center">
        <input type="button" id="loginBtn" class="btn btn-success" value="로그인"/>
        <input type="button" class="btn btn-primary" value="회원가입"  onclick="javascript:movejoin();"/>
        </div>
    </div>
</div>
</form>
</body>
</html>
<%@ include file="/common/footer.jsp" %>