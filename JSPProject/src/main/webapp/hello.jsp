<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<!-- HTML 주석 -->
<%-- JST 주석 --%>
<% Date currentDate = new Date(); %>
<h1>현재시간 : <%= currentDate.toString() %></h1>
<h1><%= request.getParameter("id") %>님 환영합니다.^^</h1>
</center>
</body>
</html>
<%!
	String global = "global";
%>