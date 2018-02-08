package gosuic.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

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
	public String listPage() {
		System.out.println("매물 리스트 화면으로");
		return "/WEB-INF/view/list.jsp";
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

}// class end
