package com.playdata.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playdata.board.dao.ReboardDao;
import com.playdata.board.model.ReboardDto;
import com.playdata.common.dao.CommonDao;
import com.playdata.util.BoardConstance;

@Service
public class ReboardServiceImpl implements ReboardService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int writeArticle(ReboardDto reboardDto) {
		ReboardDao reboardDao = sqlSession.getMapper(ReboardDao.class);
		
	
		return reboardDao.writeArticle(reboardDto);
	}

	@Override
	@Transactional
	public int replyArticle(ReboardDto reboardDto) {
		ReboardDao reboardDao = sqlSession.getMapper(ReboardDao.class);
		reboardDao.updateStep(reboardDto);
		reboardDao.replyArticle(reboardDto);
		reboardDao.updateReply(reboardDto.getPseq());
		return 1;
	}

	@Override
	public ReboardDto viewArticle(int seq) {
		CommonDao commonDao = sqlSession.getMapper(CommonDao.class);
		commonDao.updateHit(seq);
		ReboardDao reboardDao = sqlSession.getMapper(ReboardDao.class);
		return reboardDao.viewArticle(seq);
	}

	@Override
	public List<ReboardDto> listArticle(Map<String, String> map) {
		ReboardDao reboardDao = sqlSession.getMapper(ReboardDao.class);
		
		//ReboardDao reboardDao = sqlSession.selectOne("com.playdata.board.dao.ReboardDao.listArticle",map);
		
		System.out.println(ReboardDao.class);
		int pg = Integer.parseInt(map.get("pg"));
		int end = BoardConstance.BOARD_LIST_SIZE * pg;
		int start = end - BoardConstance.BOARD_LIST_SIZE;
		
		map.put("start", start + "");
		map.put("end", end + "");
		return reboardDao.listArticle(map);
	}

	@Override
	public void modifyArticle(ReboardDto reboardDto) {

	}

	@Override
	public void deleteArticle(int seq) {
		
	}

}
