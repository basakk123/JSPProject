package com.multicampus.web;

import java.io.IOException;
import java.util.List;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		
		// 2. 요청 path에 따라 분기처리한다.
		if(path.equals("/login.do")) {
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
				
				response.sendRedirect("getBoardList.do");
			} else {
				// 로그인 실패 시, 로그인 화면으로 되돌아간다.
				response.sendRedirect("login.html");
			}
			
		} else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 기능 처리");
			
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.sendRedirect("login.html");
			
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 기능 처리");
			
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
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String title = request.getParameter("title");
			String seq = request.getParameter("seq");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			vo.setContent(content);
			
			BoardDAO dao = new BoardDAO();
			dao.updateBoard(vo);
			
			// 3. 화면 이동
			// 글 수정 성공 후, 글 목록 화면으로 이동
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO dao = new BoardDAO();
			dao.deleteBoard(vo);
			
			// 3. 화면 이동
			// 글 삭제 성공 후, 글 목록 화면으로 이동
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String seq = request.getParameter("seq");	
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO dao = new BoardDAO();
			BoardVO board = dao.getBoard(vo);
			
			// 3. 검색 결과를 request에 저장하고 JSP 화면으로 이동한다.
			request.setAttribute("board", board);
			RequestDispatcher rd = request.getRequestDispatcher("getBoard.jsp");
			rd.forward(request, response);
			
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("글 목록 검색 기능 처리");
			
			// 1. DB 연동 처리
			BoardDAO dao = new BoardDAO();
			List<BoardVO> boardList = dao.getBoardList();
			
			// 2. 검색 결과를 request에 저장하고 JSP 화면으로 이동한다.
			request.setAttribute("boardList", boardList);
			RequestDispatcher rd = request.getRequestDispatcher("getBoardList.jsp");
			rd.forward(request, response);
		}
	}
}
