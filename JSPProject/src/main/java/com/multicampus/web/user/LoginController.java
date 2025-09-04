package com.multicampus.web.user;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;
import com.multicampus.web.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 기능 처리");
		
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
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60 * 60 * 3);
			
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
			session.setAttribute("userRole", user.getRole());
			
			return "getBoardList.do";
		} else {
			// 로그인 실패 시, 로그인 화면으로 되돌아간다.
			return "login.html";
		}
	}

}
