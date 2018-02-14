package com.playdata.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.playdata.board.model.ReboardDto;
import com.playdata.board.service.ReboardService;
import com.playdata.common.service.CommonService;
import com.playdata.member.model.MemberDto;
import com.playdata.util.BoardConstance;
import com.playdata.util.PageNavigation;

@Controller
@RequestMapping("/reboard")  //여기 1 
public class ReboardController {

	@Autowired
	private ReboardService reboardService;

	@Autowired
	private CommonService commonService; // 

	@RequestMapping("/list.playdata")  //여기 2          //KEY, VALUE 
	public ModelAndView list(@RequestParam Map<String, String> map, HttpServletRequest request) {
		System.out.println("[com.playdata.board.controller] ");
		ModelAndView mav = new ModelAndView();
		List<ReboardDto> list = reboardService.listArticle(map);  //리스트 목록을 받아옴 
		map.put("listsize", BoardConstance.BOARD_LIST_SIZE + ""); // MAP에 사이즈를 추가 
		//*** 여기서 어떤값이 들어가는지 알아오기 
		
		
		PageNavigation navigation = commonService.makePageNavigation(map);  // PageNavigation에 map 을 주면 
		navigation.setRoot(request.getContextPath());
		navigation.setBcode(Integer.parseInt(map.get("bcode")));
		navigation.setKey(map.get("key"));
		navigation.setWord(map.get("word"));
		navigation.setNavigator();
		mav.addObject("articlelist", list);  //MAV 에 LIST를 담음 
		mav.addObject("navigator", navigation);
		mav.addObject("querystring", map);   //이거를 줘야 모든 페이지에 bcode가 따라감 
		mav.setViewName("/WEB-INF/reboard/list");  //여기 4  프리픽스 JSP 
		return mav;
	}

	//** 어떤경우에 이 메소드를 실행하고 
	@RequestMapping(value = "/write.playdata", method = RequestMethod.GET)
	public ModelAndView write(@RequestParam Map<String, String> map) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("querystring", map);
		mav.setViewName("/WEB-INF/reboard/write"); //write.jsp로 가라 
		return mav;
	}
	//** 어떤경우에 이 메소드를 실행하는지 알아오기  
	@RequestMapping(value = "/write.playdata", method = RequestMethod.POST)
	public ModelAndView write(ReboardDto reboardDto, @RequestParam Map<String, String> map, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if (memberDto != null) {
			int seq = commonService.getNextSeq();
			reboardDto.setSeq(seq);
			reboardDto.setId(memberDto.getId());
			reboardDto.setName(memberDto.getName());
			reboardDto.setEmail("aaa@aaa.com");  //멤버에 이메일 있으면 여기에 이메일 주기 
			reboardDto.setRef(seq);
			int cnt = reboardService.writeArticle(reboardDto);
			mav.addObject("querystring", map);//url 뒤에 옴
			mav.addObject("seq", seq); // 앞에 시퀀스 
			mav.setViewName("/WEB-INF/reboard/writeOk");
		} else {
			mav.setViewName("/login/login");
		}
		return mav;
	}

	@RequestMapping(value = "/view.playdata", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam Map<String, String> map, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if (memberDto != null) {
			int seq = Integer.parseInt(map.get("seq"));
			ReboardDto reboardDto = reboardService.viewArticle(seq);
			mav.addObject("querystring", map);
			mav.addObject("article", reboardDto);
			mav.setViewName("/WEB-INF/reboard/view");   
		} else {
			mav.setViewName("/login/login");
		}
		return mav;
	}

	@RequestMapping(value = "/reply.playdata", method = RequestMethod.GET)
	public ModelAndView reply(@RequestParam Map<String, String> map, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if (memberDto != null) {
			int seq = Integer.parseInt(map.get("seq"));
			ReboardDto reboardDto = reboardService.viewArticle(seq);

			mav.addObject("querystring", map);
			mav.addObject("article", reboardDto);
			mav.setViewName("/WEB-INF/reboard/reply");
		} else {
			mav.setViewName("/login/login");
		}
		return mav;
	}

	@RequestMapping(value = "/reply.playdata", method = RequestMethod.POST)
	public ModelAndView reply(ReboardDto reboardDto, @RequestParam Map<String, String> map, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if (memberDto != null) {
			int seq = commonService.getNextSeq();
			reboardDto.setSeq(seq);
			reboardDto.setId(memberDto.getId());
			reboardDto.setName(memberDto.getName());
			reboardDto.setEmail("abc@com.test");
			int cnt = reboardService.replyArticle(reboardDto);
			mav.addObject("querystring", map);
			mav.addObject("seq", seq);
			mav.setViewName("/WEB-INF/reboard/writeOk");
		} else {
			mav.setViewName("/login/login");
		}
		return mav;
	}

}
