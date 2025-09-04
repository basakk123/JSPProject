package com.multicampus.web.board;

import java.util.List;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;
import com.multicampus.web.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 기능 처리");
		
		// 1. 사용자 입력 정보 추출
		String condition = request.getParameter("condition");
		String keyword = request.getParameter("keyword");
		
		// Null Check
		if(condition == null) condition = "title";
		if(keyword == null) keyword = "";
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setCondition(condition);
		vo.setKeyword(keyword);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.getBoardList(vo);
		
		// 3. 검색 결과를 request에 저장하고 JSP 화면으로 이동한다.
		request.setAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}

}
