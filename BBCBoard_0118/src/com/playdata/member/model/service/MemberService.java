package com.playdata.member.model.service;

import java.util.List;
import com.playdata.member.model.MemberDto;

public interface MemberService {
	
	int idCheck(String id);

	int registerMember(MemberDto memberDetailDto);
	void deleteMember(String id);
	
	MemberDto login(String id, String pass);
	
	List<MemberDto> listMember(String key, String word);
	
	

}
