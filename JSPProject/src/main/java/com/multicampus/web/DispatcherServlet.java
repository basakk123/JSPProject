package com.multicampus.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

	public DispatcherServlet(){
		System.out.println("===> DispatcherServlet 생성");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("PATH : " + path);
		
		// 2. HandlerMapping을 통해 요청을 처리할 Controller를 검색한다.
		HandlerMapping mapper = new HandlerMapping();
		Controller ctrl = mapper.getController(path);
		
		// 3. 검색한 Controller를 실행한다.
		String view = ctrl.handleRequest(request, response);
		
		// 4. Controller가 리턴해준 화면으로 이동한다.
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}
