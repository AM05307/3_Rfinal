package com.playdata.board.service;

import java.util.List;
import java.util.Map;

import com.playdata.board.model.ReboardDto;

public interface ReboardService {

	int writeArticle(ReboardDto reboardDto);
	int replyArticle(ReboardDto reboardDto);
	ReboardDto viewArticle(int seq);
	List<ReboardDto> listArticle(Map<String, String> map);
	void modifyArticle(ReboardDto reboardDto);
	void deleteArticle(int seq);
	
}
