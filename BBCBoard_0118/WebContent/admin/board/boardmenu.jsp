<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/> 
<c:if test="${boardmenu != null}">
<table>
<c:set var="ccode" value="0"/>
<c:forEach var="board" items="${boardmenu}">
	<c:if test="${ccode != board.ccode}">
		<c:set var="ccode" value="${board.ccode}"/>
<tr>
	<td>${board.cname}</td>
</tr>
	</c:if>
<tr>
	<td>&nbsp;&nbsp;&nbsp;
	<a href="${root}/${board.controller}/list.playdata?bcode=${board.bcode}&pg=1&key=&word="> <!--심어서 감. 밑에서 값을 받아서 던짐   -->
	${board.bname}
	</a>
	</td>
</tr>
</c:forEach>
<tr>
	<td>
	<a href="${root}/memo/list.playdata?seq=1">한줄메모</a>
	</td> 
</tr>
</table>
</c:if>
<c:if test="${boardmenu == null}">
	<c:redirect url="/boardadmin/boardmenu.playdata"/>
</c:if>