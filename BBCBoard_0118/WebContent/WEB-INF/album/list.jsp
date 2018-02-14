<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header_board.jsp" %>
<!-- title start -->
<script>
control = "/album";

function searchArticle() {
	document.getElementById("searchForm").action = "${root}/album/list.playdata";
	document.getElementById("searchForm").submit();
}

function myArticle(myid) {
	$("#commonForm #bcode").val("${bcode}");
	$("#commonForm #pg").val("1");
	$("#commonForm #key").val("id");
	$("#commonForm #word").val(myid);
	document.getElementById("commonForm").action = "${root}/album/list.playdata";
	document.getElementById("commonForm").submit();
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
<!-- title end -->

<!-- bbs start -->
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr valign="bottom">
		<td nowrap><a href="javascript:moveWrite('${bcode}');"><img
			src="${root}/img/board/btn_write_01.gif" width="64" height="22"
			border="0" align="absmiddle" alt="글쓰기"></a></td>

		<td width="100%" style="padding-left: 6px" valign="bottom">새글 <b><font
			class="text_acc_02">${navigator.newArticleCount}</font></b> / 전체 <font
			class="text_acc_02">${navigator.totalArticleCount}</font></td>
		<td width="300" nowrap>
		<div align="right"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" height="5" style="padding: 0px"></td>
	</tr>
</table>

<table width="100%" cellpadding="5" cellspacing="0" border="0">
	<tr>
		<td class="bg_board_title_02" height="2" colspan="4"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
	<tr align="center">
<c:forEach varStatus="i" var="article" items="${articlelist}">
		<td width="25%">		
		<table width="95%">
			<tr>
				<td colspan="2" align="right">조회수 : ${article.hit}</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<a href="javascript:viewArticle('${bcode}', '${pg}', '${key}', '${word}', '${article.seq}');">
					<img src="${root}/upload/${article.saveFolder}/${article.savePicture}" width="150">
					</a>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="left">
					<a href="javascript:viewArticle('${bcode}', '${pg}', '${key}', '${word}', '${article.seq}');">
					<b>${article.seq}. ${article.subject}</b>
					</a>
				</td>
			</tr>
			<tr>
				<td align="left">${article.name}</td>
				<td align="right">${article.logtime}</td>
			</tr>
		</table>		
		</td>
	<c:if test="${i.index % 4 == 3}">
		</tr>
		<tr align="center">
	</c:if>
</c:forEach>	
	</tr>
	
	<tr>
		<td class="bg_board_title_02" height="1" colspan="4"
			style="overflow: hidden; padding: 0px"></td>
	</tr>

	<tr>
		<td class="bg_board_title_02" height="1" colspan="4"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
</table>
<!-- bbs end -->

<!-- 하단 페이징 -->
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td colspan="3" height="5"></td>
	</tr>
	<tr valign="top">
		<td nowrap><a href="javascript:moveWrite('${bcode}');"><img
			src="${root}/img/board/btn_write_01.gif" width="64" height="22"
			border="0" align="absmiddle" alt="글쓰기"></a></td>
		<td width="100%" align="center">
		<!--PAGE-->${navigator.navigator}</td>
		<td nowrap class="stext">
		<b>${navigator.pageNo}</b> / ${navigator.totalPageCount}
		pages</td>
	</tr>
</table>
<br>
<!-- 하단 페이징 -->

<!-- 검색 영역-->
<form id="searchForm" name="searchForm" method="get" action=""
	style="margin: 0px">
<input type="hidden" id="act" name="act" value="listarticle">
<input type="hidden" id="bcode" name="bcode" value="${bcode}">
<input type="hidden" id="pg" name="pg" value="1">
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td colspan="3" height="10"></td>
	</tr>
	<tr>
		<td width="50%"></td>
		<td nowrap>
			<select id="key" name="key" class="inp">
				<option value="subject">글제목
				<option value="name">글쓴이
				<option value="seq">글번호
			</select> 
			<span id="sear1"> 
			<input type="text" id="word" name="word" size="22"
			class="inp" style="margin-top: -19px;"> 
			</span> 
			<a href="javascript:searchArticle();"><img
			src="${root}/img/board/sbtn_s.gif" width="32" height="18"
			border="0" align="absmiddle" alt="검색"></a> 
<c:if test="${userInfo != null}">	
			<a href="javascript:myArticle('${userInfo.id}')"><img
			src="${root}/img/board/sbtn_mytext.gif" width="82" height="20"
			align="absmiddle" alt="내가 쓴 글 보기"></a>
</c:if>				
			<br>
		</td>
		<td width="50%" align="right"><a href="#"><img
			src="${root}/img/board/sbtn_top.gif" width="24" height="11"
			align="absmiddle" alt="TOP"></a><br>
		</td>
	</tr>
</table>
</form>
<br>
<br>
<%@ include file="/common/footer.jsp" %>

