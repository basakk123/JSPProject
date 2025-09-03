<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 화면 이동
	session.setAttribute("name", "채규태");
	//RequestDispatcher rd = request.getRequestDispatcher("b.jsp");
	//rd.forward(request, response);
	response.sendRedirect("b.jsp");
%>