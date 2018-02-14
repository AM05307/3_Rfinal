<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header_board.jsp" %>
<c:if test="${article != null}">
<!-- title -->
<script>
control = "/reboard";

function moveReply() {
	document.getElementById("bcode").value = "${bcode}";
	document.getElementById("pg").value = "1";
	document.getElementById("key").value = "";
	document.getElementById("word").value = "";
	document.getElementById("seq").value = "${article.seq}";
	
	document.getElementById("commonForm").action = "${root}/reboard/reply.playdata";
	document.getElementById("commonForm").submit();
}
//전부 ajax 
$(document).ready(function() {
	
	$.ajax({
		type : "POST",
		url : "${root}/memo/list.playdata",
		dataType : "json",
		data : {seq : "${article.seq}"},
		success : function(data) {
			makelist(data);
		}
	});
	
	$("#memoBtn").click(function() {
		var mct = $("#mcontent").val();
		$("#mcontent").val('');
		if(mct.length != 0) {
			$.ajax({
				type : "POST",
				url : "${root}/memo/write.playdata",
				dataType : "json",
				data : {seq : "${article.seq}", mcontent: mct},
				success : function(data) {
					makelist(data);
				},
				error : function (e) {
					alert("에러발생!!!");
				}
			});
		}
	});
	/*
	$(document).on('click','label', 
		function(event) {
			var mseq = event.target.parentNode.parentNode.id;
			alert(mseq);
			//alert("수정 : " + $(this).parent().attr("data-seq"));
	});
	*/
	$(document).on('click','#memolist>tr #modBtn', 
		function(event) {
			var mseq = $(this).parent().attr("data-seq");
			$("#view" + mseq).attr("style", "display: none;");
			$("#mod" + mseq).attr("style", "display: ;");
	});
	
	$(document).on('click','#memolist>tr #modifyBtn', 
			function(event) {
				var mseq = $(this).parent().attr("data-seq");
				$.ajax({
					type : "POST",
					url : "${root}/memo/modify.playdata",
					dataType : "json",
					data : {seq : "${article.seq}", mseq : mseq, mcontent : $("#mcontent" + mseq).val()},
					success : function(data) {
						makelist(data);
					}
				});
		});
	
	$(document).on('click','#memolist>tr #cancelBtn', 
			function(event) {
				var mseq = $(this).parent().attr("data-seq");
				$("#view" + mseq).attr("style", "display: ;");
				$("#mod" + mseq).attr("style", "display: none;");
		});
		
	$(document).on('click','#memolist>tr #delBtn', 
		function(event) {
			//alert("삭제 : " + $(this).parent().attr("data-seq"));
			$.ajax({
				type : "POST",
				url : "${root}/memo/delete.playdata",
				dataType : "json",
				data : {seq : "${article.seq}", mseq : $(this).parent().attr("data-seq")},
				success : function(data) {
					makelist(data);
				}
			});
	});
});

function makelist(data) {
	$("#memolist").empty();
	
	var len = data.memolist.length;
	var output = '';
	for(var i=0;i<len;i++) {
		var memo = data.memolist[i];
		output += '<tr id="view' + memo.mseq + '">';
		output += '	<td width="7%">' + decodeURIComponent(memo.name) + '</td>';
		output += '	<td>' + decodeURIComponent(memo.mcontent).replace('<', '&lt;') + '</td>';
		output += '	<td width="10%">' + memo.mtime + '</td>';
		output += '	<td width="10%" data-seq="' + memo.mseq + '">';
		if('${userInfo.id}' == memo.id) {
			output += '<label id="modBtn">수정</label>';
			output += '<label id="delBtn">삭제</label>';
		}
		output += '	</td>';   
		output += '</tr>';
		output += '<tr id="mod' + memo.mseq + '" style="display: none;">';
		output += '	<td colspan="3" data-seq="' + memo.mseq + '">';
		output += '	<textarea id="mcontent' + memo.mseq + '" rows="4" cols="110">' + decodeURIComponent(memo.mcontent) + '</textarea>';
		output += '	<button id="modifyBtn">수정</button>';
		output += '	<button id="cancelBtn">취소</button>';
		output += '	</td>';
		output += '</tr>';
	}
	$("#memolist").html(output);
}
</script>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td><img src="${root}/img/board/m_icon_board.gif" width="9"
			height="9" border="0" align="absmiddle" style="margin-top: -2px">
		<b>자유게시판</b> &nbsp;<font style="font-size: 8pt">|</font>&nbsp; 자유로운 글을
		올리는 공간입니다<br>
		</td>
		<td align="right"></td>
	</tr>
	<tr>
		<td colspan="2" height="19"></td>
	</tr>
</table>

<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<form name="bbsForm" id="bbsbbs" method="post"><input
		type="hidden" name="" value="">
	<tr>
		<td valign="bottom" nowrap>
		
			<a href="javascript:moveWrite('${bcode}');"><img
			src="${root}/img/board/btn_write_01.gif" width="64" height="22"
			border="0" align="absmiddle" alt="글쓰기"></a> 
			<a href="javascript:moveReply();"><img
			src="${root}/img/board/btn_reply.gif" width="40" height="22"
			border="0" align="absmiddle" alt="답글"></a>
<c:if test="${userInfo.id == article.id}">
			<a href="javascript:moveModify('');"><img
			src="${root}/img/board/btn_modify.gif"
			border="0" align="absmiddle" alt="글수정"></a> 
			<a href="javascript:deleteArticle('');"><img
			src="${root}/img/board/btn_delete.gif"
			border="0" align="absmiddle" alt="글삭제"></a>
</c:if>			
		</td>
		<td valign="bottom" width="100%" style="padding-left: 4px"></td>
		<td align="right" nowrap valign="bottom">
			<a href="javascript:listArticle('${bcode}', '1', '', '');">최신목록</a> <font color="#c5c5c5">|</font>
			<a href="javascript:listArticle('${bcode}', '${pg}', '${key}', '${word}');">목록</a> <font color="#c5c5c5">|</font>

		<a href="javascript:goBbsRead();"><img
			src="${root}/img/board/icon_up.gif" border="0" align="absmiddle"
			hspace="3">윗글</a> <font color="#c5c5c5">|</font> <a
			href="javascript:goBbsRead();">아랫글<img
			src="${root}/img/board/icon_down.gif" border="0" align="absmiddle"
			hspace="3"></a></td>
	</tr>
	<tr>
		<td colspan="3" height="5" style="padding: 0px"></td>
	</tr>
</table>

<table border="0" cellpadding="5" cellspacing="0" width="100%">
	<tr>
		<td class="bg_board_title_02" colspan="2" height="2"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
	<tr height="28">
		<td class="bg_board_title" colspan="2" style="padding-left: 14px">
		<b><font class="text"> ${article.subject} </font></b></td>
	</tr>
	<tr>
		<td class="bg_board_title_02" colspan="2" height="1"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
	<tr height="26">
		<td width="100%" style="padding-left: 14px"><font class="stext">번호
		:</font> <font class="text_commentnum">${article.seq}</font> &nbsp; <font
			class="stext">글쓴이 :</font> <a href="javascript:;"
			onClick="showSideView();" class="link_board_02">${article.name}</a><br>
		</td>
		<td style="padding-right: 14px" nowrap class="stext">조회 : <font
			class="text_commentnum">${article.hit}</font> &nbsp; 스크랩 : <font
			class="text_commentnum">0</font> &nbsp; 날짜 : <font
			class="text_commentnum">${article.logtime}</font></td>
	</tr>
	<tr>
		<td class="bg_board_title_02" colspan="2" height="1"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
</table>

<table border="0" cellpadding="15" cellspacing="0" width="100%">
	<tr valign="top">
		<td bgcolor="#ffffff" width="100%" class="text"
			style="padding-bottom: 8px; line-height: 1.3" id="clix_content">



		<P>${article.content}</P>



		</td>
		<td nowrap valign="top" align="right" style="padding-left: 0px">

		</td>
	</tr>
</table>

<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td class="bg_board_title_02" height="1"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
</table>

<!-- 하단 페이징 -->
<table cellpadding="0" cellspacing="0" border="0" width="100%">
	<tr>
		<td colspan="3" height="5" style="padding: 0px"></td>
	</tr>
	<tr valign="top">
		<td nowrap><a href="javascript:moveWrite('${bcode}');"><img
			src="${root}/img/board/btn_write_01.gif" width="64" height="22"
			border="0" align="absmiddle" alt="글쓰기"></a> <a
			href="javascript:moveReply();"><img
			src="${root}/img/board/btn_reply.gif" width="40" height="22"
			border="0" align="absmiddle" alt="답글"></a></td>
		<td style="padding-left: 4px" width="100%"><a href=""
			target="new"><img src="${root}/img/board/btn_print.gif"
			width="30" height="18" border="0" align="absmiddle" alt="인쇄"></a></td>

		<td align="right" nowrap>
			<a href="javascript:listArticle('${bcode}', '1', '', '');">최신목록</a>
		<font color="#c5c5c5">|</font> <a href="javascript:listArticle('${bcode}', '${pg}', '${key}', '${word}');">목록</a>
		<font color="#c5c5c5">|</font> <a href="javascript:goBbsRead();"><img
			src="${root}/img/board/icon_up.gif" border="0" align="absmiddle"
			hspace="3">윗글</a> <font color="#c5c5c5">|</font> <a
			href="javascript:goBbsRead();">아랫글<img
			src="${root}/img/board/icon_down.gif" border="0" align="absmiddle"
			hspace="3"></a></td>
	</tr>
</table>
<br>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td class="bg_board_title_02" height="1"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
</table>
<table border="0" cellpadding="5" cellspacing="0" width="100%">
	<tr height="10">
		<td class="bg_board_title" align="center" style="padding-left: 14px">
		<textarea class="inp_02" id="mcontent" name="mcontent" rows="5" cols="110"></textarea>
		<img id="memoBtn" src="${root}/img/board/memo_btn.jpg">
		</td>
	</tr>
	<tr>
		<td class="bg_board_title_02" height="1"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
</table>
<table border="0" cellpadding="5" cellspacing="0" width="100%">	
	<tbody id="memolist"></tbody>
</table>
<br><br>
</c:if>
<c:if test="${article == null}">
<script>
alert("글이 삭제되었거나 존재하지 않는 글입니다.");
listArticle('${bcode}', '${pg}', '${key}', '${word}');
</script>
</c:if>
<%@ include file="/common/footer.jsp" %>
