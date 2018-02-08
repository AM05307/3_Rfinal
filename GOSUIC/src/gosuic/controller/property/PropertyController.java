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
	public ModelAndView all_list(Model model, HttpSession session) {
		model.addAttribute("all_list", propertyservice.listApt());
		System.out.println("매물목록 출력");
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("userEmail") == null) {
			mav.setViewName("redirect:/index.sp");
		} else {
			mav.setViewName("redirect:/list2.sp");
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
			System.out.println("주소:"+request.getAttribute("search"));
			mav.setViewName("redirect:/detail.sp");
		}
		return mav;
	}
}
