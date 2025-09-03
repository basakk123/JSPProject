<%@page import="com.multicampus.biz.board.BoardDAO"%>
<%@page import="com.multicampus.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	// 1. 사용자 입력정보 추출
	String seq = request.getParameter("seq");	
	
	// 2. DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO dao = new BoardDAO();
	BoardVO board = dao.getBoard(vo);
	
	// 3. 검색 결과를 이용한 응답 화면 구성
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>
</head>
<body>
<center>
<h1>게시글 상세</h1>
<a href="Logout_proc.jsp">LOG-OUT</a>
<hr>
<form action="updateBoard_proc.jsp" method="get">
<input type="hidden" name="seq" value="<%= board.getSeq() %>"/>
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td><td align="left">
		<input type="text" name="title" value="<%= board.getTitle()%>"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td align="left"><%= board.getWriter() %></td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td align="left"><textarea name="content" cols="40" rows="10"><%= board.getContent() %></textarea></td>
	</tr>
		<tr>
		<td bgcolor="orange">등록일</td>
		<td align="left"><%= board.getRegDate() %></td>
	</tr>
		<tr>
		<td bgcolor="orange">조회수</td>
		<td align="left"><%= board.getCnt() %></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value=" 글수정 "/></td>
	</tr>
</table>
</form>
<hr>

<a href ="insertBoard.html">글등록</a>&nbsp;&nbsp;&nbsp;
<a href ="deleteBoard_proc.jsp?seq=<%= board.getSeq() %>">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href ="getBoardList.jsp">글목록</a>&nbsp;&nbsp;&nbsp;

</center>
</body>
</html>