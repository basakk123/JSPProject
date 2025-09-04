package com.multicampus.web;

import java.util.HashMap;
import java.util.Map;

import com.multicampus.web.board.DeleteBoardController;
import com.multicampus.web.board.GetBoardController;
import com.multicampus.web.board.GetBoardListController;
import com.multicampus.web.board.InsertBoardController;
import com.multicampus.web.board.UpdateBoardController;
import com.multicampus.web.user.LoginController;
import com.multicampus.web.user.LogoutController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		// 모든 Controller 객체들을 Map에 등록한다.
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/getBoardList.do", new GetBoardListController());
	}

	public Controller getController(String path) {
		// path에 해당하는 Controller 객체를 리턴한다.
		return mappings.get(path);
	}

}
