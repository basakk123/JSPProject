<%@page import="com.multicampus.biz.user.UserDAO"%>
<%@page import="com.multicampus.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 1. 사용자 입력정보 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 2. DB 연동 처리
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO dao = new UserDAO();
	UserVO user = dao.getUser(vo);
	
	// 3. 화면 이동
	if(user != null) {
		// 로그인 성공 시, 세션에 userId 정보를 저장하고 글 목록 화면으로 이동
		session.setMaxInactiveInterval(60 * 60 * 3);
		
		session.setAttribute("userId", user.getId());
		session.setAttribute("userName", user.getName());
		session.setAttribute("userRole", user.getRole());
		
		response.sendRedirect("getBoardList.jsp");
	} else {
		// 로그인 실패 시, 로그인 화면으로 되돌아간다.
		response.sendRedirect("login.html");
	}
%>