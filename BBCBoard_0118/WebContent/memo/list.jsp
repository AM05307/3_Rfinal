<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" import="com.playdata.board.model.MemoDto,java.util.List"%>
<%
List<MemoDto> list = (List<MemoDto>) request.getAttribute("memolist");
%>
<memolist>
<%
for(MemoDto memoDto : list) {
%>
	<memo>
		<mseq><%=memoDto.getMseq()%></mseq>
		<seq><%=memoDto.getSeq()%></seq>
		<id><%=memoDto.getId()%></id>
		<name><%=memoDto.getName()%></name>
		<mcontent><%=memoDto.getMcontent().replace("<", "&lt;").replace(">", "&gt;")%></mcontent>
		<mtime><%=memoDto.getMtime()%></mtime>
	</memo>
<%
}
%>
</memolist>