package gosuic.controller.property;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gosuic.service.property.PropertyService;

@Controller
public class PropertyController {

	@Autowired
	private PropertyService propertyservice;

	// 전체 출력하기
	@RequestMapping("/list.sp")
	public ModelAndView all_list(Model model, HttpSession session,HttpServletRequest request) {
		model.addAttribute("all_list", propertyservice.listApt());
		System.out.println(model.toString());
		System.out.println("매물목록 출력");
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("userEmail") == null) {
			System.out.println("미로그인 로그인요망");
			mav.setViewName("redirect:/index.sp");
		} else {
			mav.setViewName("forward:/list2.sp");
			//mav.setViewName("forward:/list2.sp?dong=" + vo.getDong());
		}
		return mav;
	}

	@RequestMapping("/property.sp")
	public ModelAndView Property(HttpSession session, Model model,HttpServletRequest request) {
		System.out.println("매물상세 출력");
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("userEmail") == null) {
			mav.setViewName("redirect:/index.sp");
		} else {
			
			mav.setViewName("redirect:/detail.sp");
		}
		return mav;
	}
}
