package com.playdata.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.playdata.member.model.MemberDto;

import com.playdata.member.model.service.MemberService;


@Controller
@RequestMapping("/user")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/join.playdata", method=RequestMethod.GET)
	public String join() {
		return "redirect:/join/member.jsp";  //아무것도 없이 submit할때 
	}
	
	@RequestMapping(value="/join.playdata", method=RequestMethod.POST)
	public ModelAndView join(MemberDto memberDto) {
		ModelAndView mav = new ModelAndView();
		int cnt = memberService.registerMember(memberDto);
		String viewName = "/index";
		if(cnt != 0) {
			mav.addObject("registerinfo", memberDto);
			viewName = "/WEB-INF/join/registerok";
		}
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/login.playdata", method=RequestMethod.GET)
	public String login() {
		return "redirect:/login/login.jsp";
	}
	
	@RequestMapping(value="/login.playdata", method=RequestMethod.POST)  //value값을 id로 다 받음 	//id pw을 가지고 세션에 
	public String login(@RequestParam(value="id", required=true) String id,
			@RequestParam(value="pass", required=true) String pass, HttpServletRequest request, HttpSession session) {
		String url = request.getHeader("referer");
		System.out.println(">>>>>>>>>>>>>" + url);
		MemberDto memberDto = memberService.login(id, pass);
		session.setAttribute("userInfo", memberDto); //세션에 멤버 정보(id,pw)를 담고 읻오 이동 / / db에서 불러온 값을 session에 넣음 브라우저마다 요청할떄 session생성, 나갈때 없어짐 
		if(url.contains("login.jsp"))
			url = "/index.jsp";
		return "redirect:" + url;
	}
	
	@RequestMapping("/logout.playdata")
	public String logout(HttpSession session) {
		session.removeAttribute("userInfo");  //세션을 삭제함 
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/memberout.playdata")
	public String memberout(HttpSession session) {
		String id = ((MemberDto) session.getAttribute("userInfo")).getId();
		memberService.deleteMember(id);    //db에서 회원을 지움 
		session.removeAttribute("userInfo");
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/idcheck.playdata")
	public @ResponseBody String idCheck(@RequestParam("sid") String sid) {
		int cnt = memberService.idCheck(sid);  //db에 있는지 없는지 비료 
		JSONObject json = new JSONObject(); // 집어넣고 
		json.put("idcount", cnt); //비교 
		json.put("sid", sid);
		return json.toJSONString();//{idcount : 0, sid : java2} << json
	}
	
}















