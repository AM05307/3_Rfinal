package com.playdata.common.service;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playdata.common.dao.CommonDao;
import com.playdata.util.BoardConstance;
import com.playdata.util.PageNavigation;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private SqlSession sqlSession;  // 여기서 다오를 원래 불러야 함 / 지금 여기는 DAO 안부름 
	
	@Override
	public int getNextSeq() {
		CommonDao commonDao = sqlSession.getMapper(CommonDao.class);
		return commonDao.getNextSeq();
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) {  //MAP으로 받은걸 여기에줌
		CommonDao commonDao = sqlSession.getMapper(CommonDao.class);  //commaondao를 다 받아서 심음 
		
		int pg = Integer.parseInt(map.get("pg"));
		PageNavigation navigation = new PageNavigation(); //  이 클래스가 
		int pgSize = BoardConstance.PAGE_SIZE;
		navigation.setPageNo(pg);
		int newArticleCount = commonDao.getNewArticleCount(Integer.parseInt(map.get("bcode")));
		navigation.setNewArticleCount(newArticleCount);
		int totalArticleCount = commonDao.getTotalArticleCount(map);
		navigation.setTotalArticleCount(totalArticleCount);
		int totalPageCount = (totalArticleCount - 1) / Integer.parseInt(map.get("listsize")) + 1;
		navigation.setTotalPageCount(totalPageCount);
		navigation.setNowFirst(pg <= pgSize);
		navigation.setNowEnd(pg > (totalPageCount - 1) / pgSize * pgSize);
		return navigation;
	}

}







