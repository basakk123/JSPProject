<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!-- 
	JSTL(JSP Standard Tag Library) 이란?
	JSP 파일에서 if, for, switch 등과 같은 자바 코드를 대체하기 위한 표준 태그
-->
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
</head>
<body>
<center>
<h1>게시글 목록</h1>
<h3>${userName }님 환영합니다.</h3>
<a href="logout.do">LOG-OUT</a>
<hr>
<table border="1" cellpadding="0" cellspacing="0" width="800">
<tr>
	<th bgcolor="orange" width="100">번호</th>
	<th bgcolor="orange" width="400">제목</th>
	<th bgcolor="orange" width="100">작성자</th>
	<th bgcolor="orange" width="100">등록일</th>
	<th bgcolor="orange" width="100">조회수</th>
</tr>

<c:forEach var="board" items="${boardList}">
<tr>
	<td>${board.seq}</td>
	<td><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
	<td>${board.writer}</td>
	<td>${board.regDate}</td>
	<td>${board.cnt}</td>
</tr>
</c:forEach>
</table>

<a href="insertBoard.html">글 등록 화면으로 이동</a>
</center>
</body>
</html>











