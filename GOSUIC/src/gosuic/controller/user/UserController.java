package gosuic.controller.user;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import gosuic.entity.PropertyVo;
import gosuic.service.user.UserService;
import gosuic.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	// ȸ������
	@RequestMapping(value = "/insertUser.sp", method = RequestMethod.POST)
	public String insertUser(UserVo user) {
		System.out.println("ȸ������");
		System.out.println(user.toString());
		if (userService.insertUser(user) == true) {
			return "/loginform.sp";
		}
		return "/WEB-INF/view/joinform.jsp";
	}
	
	// �α���
	@RequestMapping(value = "/UserLogin.sp", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,HttpSession session,UserVo vo) throws IOException{
		System.out.println(vo.getUserEmail() + " ��Ʈ�ѷ��� ���� ��Ʈ�ѷ� ���");
		//String userEmail = request.getParameter("userEmail");
		
		//response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();

        ModelAndView mav = new ModelAndView();
        if(userService.login(vo)){
            session.setAttribute("userEmail", vo.getUserEmail());
            mav.addObject("CheckEmail", "success");
            mav.setViewName("redirect:/mainform.sp");
            System.out.println("�α��� �����߾�� ");
        }
        else{
        	System.out.println("�α��� �����߾��");
        	//out.println("<script>alert('Ȯ����');");
        	mav.addObject("CheckEmail", "fail");
        	mav.setViewName("redirect:/loginform.sp");
        }
        return mav;
    }    
	
	// ���̵� �ߺ�üũ
		@ResponseBody
		@RequestMapping(value="/CheckId.sp",method =RequestMethod.POST)
		public String checkId(HttpServletRequest request, Model model) {
			String userEmail= request.getParameter("userEmail");
			System.out.println("checkid cont" + userEmail);
			int row = userService.checkID(userEmail);
			System.out.println("��Ʈ�ѷ�" + row +":" + userEmail);
			
			return String.valueOf(row);
			
		}
		
		// �о����� �ߺ�üũ
		@ResponseBody
		@RequestMapping(value="/CheckPw.sp",method =RequestMethod.POST)
		public String checkPw(HttpServletRequest request, Model model) {
			String userPw= request.getParameter("userPassword");
			System.out.println("checkpw cont" + userPw);
			int row = userService.checkPw(userPw);
			System.out.println("��Ʈ�ѷ�" + row +":" + userPw);
			
			return String.valueOf(row);			
		}
		
		// �α׾ƿ�
		@RequestMapping("/UserLogout.sp")
	    public String logout(HttpSession session){
			System.out.println("�α׾ƿ�");
			session.invalidate();
			return "/WEB-INF/view/main.jsp";
		}
	

		// ���ɸŹ� ���
		@ResponseBody
		@RequestMapping(value = "/insertat_property.sp", method = RequestMethod.POST)
		public String insertat_Property(HttpSession session,HttpServletRequest request, Model model) {
			PropertyVo pv = new PropertyVo();
			System.out.println("���ɸŹ����");
			String userEmail= (String)session.getAttribute("userEmail");

			pv.setSigungu(request.getParameter("sigungu"));
			pv.setBunji(request.getParameter("bunji"));
			pv.setDanji(request.getParameter("danji"));
			pv.setMyunjuk(request.getParameter("myunjuk"));
			pv.setC_type(request.getParameter("c_type"));
			pv.setFloor(request.getParameter("floor"));
			pv.setGunchook_year(request.getParameter("gunchook_year"));
			
			System.out.println(pv);
			
			int row = userService.insertat_Property(userEmail,pv);			
			System.out.println("�ΰ�:"+row);
			return String.valueOf(row);
		}

}
