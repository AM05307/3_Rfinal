package com.playdata.board.dao;

import java.util.List;

import com.playdata.board.model.MemoDto;

public interface MemoDao {

	void writeMemo(MemoDto memoDto);
	List<MemoDto> listMemo(int seq);
	void modifyMemo(MemoDto memoDto);
	void deleteMemo(int mseq);
	
}
