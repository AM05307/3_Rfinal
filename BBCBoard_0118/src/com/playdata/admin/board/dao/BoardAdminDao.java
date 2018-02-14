package com.playdata.admin.board.dao;

import java.util.List;

import com.playdata.admin.board.model.BoardListDto;
//dao는 db의 crud호출 
public interface BoardAdminDao {
	List<BoardListDto> boardMenu();
	
}
