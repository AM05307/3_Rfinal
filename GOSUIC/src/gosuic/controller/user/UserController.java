package gosuic.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import gosuic.service.user.UserService;
import gosuic.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	// 회원가입
	@RequestMapping(value = "/insertUser.sp", method = RequestMethod.POST)
	public String insertUser(UserVo user) {
		System.out.println("회원가입");
		System.out.println(user.toString());
		if (userService.insertUser(user) == true) {
			return "/loginform.sp";
		}
		return "/WEB-INF/view/joinform.jsp";
	}
	
	// 로그인
	@RequestMapping(value = "/UserLogin.sp", method = RequestMethod.POST)
    public ModelAndView login(HttpSession session,String userEmail, String password1){
		System.out.println(userEmail + " 컨트롤러의 록인 컨트롤러 들옴");
		
        ModelAndView mav = new ModelAndView();
        if(userService.login(userEmail, password1)){
            session.setAttribute("userEmail", userEmail);
            mav.setViewName("redirect:/mainform.sp");
        }
        else{
            mav.setViewName("redirect:/loginform.sp");
        }
        return mav;
    }    
	
	// 아이디 중복체크
		@ResponseBody
		@RequestMapping(value="/CheckId.sp",method =RequestMethod.POST)
		public String checkId(HttpServletRequest request, Model model) {
			String userEmail= request.getParameter("userEmail");
			System.out.println("checkid cont" + userEmail);
			int row = userService.checkID(userEmail);
			System.out.println("컨트롤러" + row +":" + userEmail);
			
			return String.valueOf(row);
			
		}
		
		// 로그아웃
		@RequestMapping("/UserLogout.sp")
	    public String logout(HttpSession session){
			System.out.println("로그아웃");
			session.invalidate();
		
			return "/WEB-INF/view/index.jsp";
		}
	


}
