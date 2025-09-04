package com.multicampus.web.user;

import com.multicampus.web.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그아웃 기능 처리");
		
		HttpSession session = request.getSession();
		session.invalidate();

		return "login.html";
	}
}
