package com.playdata.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.playdata.board.model.MemoDto;
import com.playdata.board.service.MemoService;
import com.playdata.member.model.MemberDto;
import com.playdata.util.StringEncoder;

@Controller
@RequestMapping("/memo")
public class MemoController {

	@Autowired
	private MemoService memoService;
	
	@RequestMapping("/write.playdata")
	public @ResponseBody String write(MemoDto memoDto, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		memoDto.setId(memberDto.getId());
		memoDto.setName(memberDto.getName());
		memoService.writeMemo(memoDto);
		JSONObject json = getMemoList(memoDto.getSeq());
		return json.toJSONString();
	}
	
	@RequestMapping("/list.playdata")
	public @ResponseBody String list(@RequestParam("seq") int seq) {
		JSONObject json = getMemoList(seq);
		return json.toJSONString();
	}
	
	@RequestMapping("/delete.playdata")
	public @ResponseBody String delete(@RequestParam("seq") int seq, @RequestParam("mseq") int mseq) {
		memoService.deleteMemo(mseq);
		JSONObject json = getMemoList(seq);
		return json.toJSONString();
	}
	
	@RequestMapping("/modify.playdata")
	public @ResponseBody String modify(MemoDto memoDto) {
		memoService.modifyMemo(memoDto);
		JSONObject json = getMemoList(memoDto.getSeq());
		return json.toJSONString();
	}
	
	private JSONObject getMemoList(int seq) {
		List<MemoDto> list = memoService.listMemo(seq);
		JSONObject json = new JSONObject();
		JSONArray jarray = new JSONArray();
		for(MemoDto memo : list) {
			JSONObject js = new JSONObject();
			js.put("mseq", memo.getMseq());
			js.put("seq", memo.getSeq());
			js.put("id", memo.getId());
			js.put("name", StringEncoder.urlUtf(memo.getName()).replaceAll("\\+", "%20"));
			js.put("mcontent", StringEncoder.urlUtf(memo.getMcontent()).replaceAll("\\+", "%20"));
			js.put("mtime", memo.getMtime());			
			jarray.add(js);
		}		
		json.put("memolist", jarray);		
		return json;
	}
}












