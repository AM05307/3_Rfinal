package com.playdata.board.service;

import java.util.List;
import java.util.Map;

import com.playdata.board.model.AlbumDto;

public interface AlbumService {

	int writeArticle(AlbumDto albumDto);
	AlbumDto viewArticle(int seq);
	List<AlbumDto> listArticle(Map<String, String> map);
	void modifyArticle(AlbumDto albumDto);
	void deleteArticle(int seq);
	
}
