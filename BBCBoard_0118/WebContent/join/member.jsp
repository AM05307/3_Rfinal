<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
var idflag = false;

$(document).ready(function() { //btn을 눌러서 function이 호출되었을때 
	$("#registerBtn").click(function() {
		if($("#name").val() == "") {
			alert("이름을 입력하세요!!!!");
			return;
		} else if(!idflag) {
			alert("아이디를 확인하세요!!!!");
			return;
		} else if($("#pass").val() == "") {
			alert("비밀번호를 입력하세요!!!!");
			return;
		} else if($("#pass").val() != $("#passok").val()) {
			alert("비밀번호를 확인하세요!!!!");
			return;
		} else {
			document.memberform.action = "${root}/user/join.playdata";  // #이 비어있지 않다면 join.playdata 로 이동 (#=id) 
			document.memberform.submit();
		}
	});
});

var idckresult;

function idcheck() {
	var output = '아이디는 4자이상 16자이하입니다.';
	var sid = $("#id").val();
	if(sid.length > 4 && sid.length < 16) {
		$.ajax({
			type: 'GET',
			dataType: 'json',
			url: '${root}/user/idcheck.playdata',
			data: {'sid' : sid},
			success: function(data) {//data >> {idcount : 0, sid : java2}
				//alert(data.idcount + "   " + data.sid);
				if(data.idcount == '0') {
					idflag = true;
					output = '<font color="blue"><b>' + data.sid + "</b>는 사용가능합니다.</font>";
				} else {
					idflag = false;
					output = '<font color="red"><b>' + data.sid + "</b>는 사용중입니다.</font>";
				}
				$("#idckresult").empty();
				$("#idckresult").append(output);
			},
			error: function(e) {
				alert("에러발생 : " + e);
			}
		});
	} else {
		idflag = false;
		$("#idckresult").empty();
		$("#idckresult").append(output);
	}
}


function openidck() {  //하위로 체크창으로 열어서  id 체크 
	window.open("${root}/user?act=mvidck", "idck", "width=600,height=350,top=200,left=200,location=no,status=no,titlebar=no,toolbar=no,resizable=no,scrollbars=no");
}


</script>
</head>
 
<body>
	<form name="memberform" method="post" action="">
    <div align="center">
        <div align="left" style="width:650px; border:1px solid #cccccc; padding:20px">
            <h3>회원가입</h3>
            <hr />
        
            <div class=form-inline style="margin-bottom:5px">
                <label style="width:150px">이름</label>
                <input id="name" name="name" type="text" class="form-control"/>
            </div>
            
            <div class=form-inline style="margin-bottom:5px">
                <label style="width:150px">아이디</label>
                <input id="id" name="id" type="text" class="form-control" onkeyup="javascript:idcheck();"/>
                <div id="idckresult"></div>
            </div>
    
            <div class=form-inline style="margin-bottom:5px">
                <label style="width:150px">비밀번호</label>
                <input id="pass" name="pass" type="password" class="form-control"/>
                <div style="margin-bottom:5px"></div>
                <label style="width:154px"></label>
                <input id="passok" name="passok" type="password" class="form-control" style="margin-right:5px"/>확인을 위해 한번 더 입력해 주세요.
            </div>               
            
            <hr />            
            <div align="center">
            <input type="button" id="registerBtn" class="btn btn-success" value="회원가입"/>
            </div>
        </div>
    </div>
    </form>
<%@ include file="/common/footer.jsp" %>