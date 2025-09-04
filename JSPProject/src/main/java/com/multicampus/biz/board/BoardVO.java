package com.multicampus.biz.board;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// TO(Transfer Object) : 매개변수를 하나의 타입으로 합치기 위한 클래스
@Getter
@Setter
@ToString
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	// 검색 관련 변수
	private String condition;
	private String keyword;
}
