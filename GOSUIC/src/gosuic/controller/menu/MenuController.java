package gosuic.controller.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MenuController {

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

	// 로그인후 메인페이지
	@RequestMapping("/afterlogin.sp")
	public String afterlogin() {
		System.out.println("로그인후 메인");
		return "/WEB-INF/view/afterlogin.jsp";
	}

		@RequestMapping("/property.sp")
	public String Property() {
		System.out.println("[MenuController] Property() 상세 매물");
		return "/WEB-INF/view/property.jsp";
	}
}// class end
