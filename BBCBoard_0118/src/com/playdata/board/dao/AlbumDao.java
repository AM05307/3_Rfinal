package com.playdata.board.dao;

import java.util.List;
import java.util.Map;

import com.playdata.board.model.AlbumDto;

public interface AlbumDao {

	int writeArticle(AlbumDto albumDto);
	AlbumDto viewArticle(int seq);
	List<AlbumDto> listArticle(Map<String, String> map);
	void modifyArticle(AlbumDto albumDto);
	void deleteArticle(int seq);
	
}
