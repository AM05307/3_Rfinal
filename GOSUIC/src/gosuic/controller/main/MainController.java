package gosuic.controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gosuic.service.property.PropertyService;
import gosuic.service.user.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService userservice;

	// 회원가입 입력페이지로
	@RequestMapping("/joinform.sp")
	public String insertpage() {
		System.out.println("회원가입 페이지 이동됨");
		return "/WEB-INF/view/joinform.jsp";
	}

	// 로그인 페이지로
	@RequestMapping("/loginform.sp")
	public String loginForm() {
		System.out.println("로그인폼으로");
		return "/WEB-INF/view/loginform.jsp";
	}

	// 메인 페이지로
	@RequestMapping("/mainform.sp")
	public String mainForm() {
		System.out.println("메인 화면으로");
		return "/WEB-INF/view/main.jsp";
	}

	// 매물 리스트 페이지로
	@RequestMapping("/list2.sp")
	public String listPage(HttpServletRequest request) {
		System.out.println("매물 리스트 화면으로");
		return "/WEB-INF/view/list.jsp";
	}
	
	//로그인전 매물 리스트페이지
	@RequestMapping("/list3.sp")
	public ModelAndView BeforeloginlistPage(HttpSession session, Model model) {
		System.out.println("리스트 검색창 제어");
		System.out.println(session.getAttribute("userEmail"));
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("userEmail") != null) {
			mav.setViewName("redirect:/list.sp");
		} else {
			mav.setViewName("redirect:/index.sp");
		}
		return mav;
	}
	
	
	// 상세매물 페이지로
		@RequestMapping("/detail.sp")
		public String detailProperty() {
			System.out.println("인덱스 화면으로");
			return "/WEB-INF/view/property.jsp";
		}

	// 인덱스 페이지로
	@RequestMapping("/index.sp")
	public String indexPage() {
		System.out.println("인덱스 화면으로");
		return "/WEB-INF/view/index.jsp";
	}

	// 로그인후 메인페이지
	@RequestMapping("/afterlogin.sp")
	public String afterlogin() {
		System.out.println("로그인후 메인");
		return "/WEB-INF/view/afterlogin.jsp";
	}

	// 주소 검색버튼 제어
	@RequestMapping("/findaddress.sp")
	public ModelAndView Findaddress(HttpSession session, Model model) {
		System.out.println("주소 검색창 제어");
		System.out.println(session.getAttribute("userEmail"));
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("userEmail") != null) {
			mav.setViewName("redirect:/addwindow.sp");
		} else {
			mav.setViewName("redirect:/index.sp");
		}
		return mav;
	}
	
	//주소 검색창 이동
	@RequestMapping("/addwindow.sp")
	public String addwindow() {
		System.out.println("주소 검색창 출력");
		return "/WEB-INF/view/findaddress.jsp";
	}
	
	// My page
		@RequestMapping("/mypage.sp")
		public ModelAndView all_list(Model model, HttpSession session,HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			System.out.println("넘어온 이메일:"+session.getAttribute("userEmail"));
			String email = (String)session.getAttribute("userEmail");
			model.addAttribute("userInfo", userservice.myPage(email));
			model.addAttribute("at_property", userservice.getAt_property(email));
			
			mav.setViewName("forward:/WEB-INF/view/mypage.jsp");
			
			System.out.println("뷰넘어가기전");
			return mav;
		}
	
}// class end
