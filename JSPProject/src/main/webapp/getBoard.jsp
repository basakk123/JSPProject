<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
	EL(Expression Language) 이란?
	JSP 내장객체(request, session)에 등록된 데이터에 접근하기 위한 표현 언어
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>
</head>
<body>
<center>
<h1>게시글 상세</h1>
<a href="logout.do">LOG-OUT</a>
<hr>
<form action="updateBoard.do" method="get">
<input type="hidden" name="seq" value="${board.seq }"/>
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td><td align="left">
		<input type="text" name="title" value="${board.title }"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td align="left">${board.writer }</td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td align="left"><textarea name="content" cols="40" rows="10">${board.content }</textarea></td>
	</tr>
	<tr>
		<td bgcolor="orange">등록일</td>
		<td align="left">${board.regDate }</td>
	</tr>	
	<tr>
		<td bgcolor="orange">조회수</td>
		<td align="left">${board.cnt }</td>
	</tr>	
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value=" 글수정 "/></td>
	</tr>
</table>
</form>
<hr>

<a href="insertBoard.html">글등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글목록</a>&nbsp;&nbsp;&nbsp;

</center>
</body>
</html>





