package com.playdata.admin.board.service;

import java.util.List;

import com.playdata.admin.board.model.BoardListDto;
// 보드 메뉴의 전체를 보드메뉴 dto로 리턴 
public interface BoardAdminService {

	List<BoardListDto> boardMenu();
	
}
