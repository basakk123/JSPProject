<%@page import="com.multicampus.biz.board.BoardDAO"%>
<%@page import="com.multicampus.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	// 1. 사용자 입력정보 추출
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	// 2. DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setWriter(writer);
	vo.setContent(content);
	
	BoardDAO dao = new BoardDAO();
	dao.insertBoard(vo);
	
	// 3. 화면 이동
	// 글 등록 성공 후, 글 목록 화면으로 이동
	response.sendRedirect("getBoardList.jsp");
%>