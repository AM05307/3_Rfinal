package com.playdata.common.service;

import java.util.Map;

import com.playdata.util.PageNavigation;

public interface CommonService {

	int getNextSeq();
	PageNavigation makePageNavigation(Map<String, String> map);
	
}
