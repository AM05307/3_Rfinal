package gosuic.controller.property;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import gosuic.entity.PropertyVo;
import gosuic.service.property.ChangeAddress;
import gosuic.service.property.PropertyService;

@Controller
public class PropertyController {

	@Autowired
	private PropertyService propertyservice;
	@Autowired
	private ChangeAddress changeaddress;

	// 전체 출력하기
	@RequestMapping("/list.sp")
	public ModelAndView all_list(Model model, HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		System.out.println("넘어온 주소:" + request.getParameter("searchaddr"));
		String addr = request.getParameter("searchaddr");
		model.addAttribute("all_list_apt", propertyservice.listApt(addr));
		model.addAttribute("all_list_offi", propertyservice.listOffi(addr));
		model.addAttribute("all_list_yeunda", propertyservice.listYeunda(addr));

		if (addr == "") {
			System.out.println("주소입력하고 눌러야해요");
			mav.setViewName("redirect:/addwindow.sp");
		} else {
			model.addAttribute("all_list", propertyservice.listApt(addr));
			mav.setViewName("forward:/list2.sp");
		}
		return mav;
	}

	@RequestMapping("/property.sp")
	public ModelAndView Property(HttpSession session, Model model, HttpServletRequest request)
			throws SAXException, IOException, ParserConfigurationException {

		PropertyVo pv = new PropertyVo();
		pv.setSigungu(request.getParameter("sigungu"));
		pv.setBunji(request.getParameter("bunji"));
		pv.setDanji(request.getParameter("danji"));
		pv.setMyunjuk(request.getParameter("myunjuk"));
		pv.setFloor(request.getParameter("floor"));
		pv.setPrice(request.getParameter("price"));
		pv.setC_type(request.getParameter("c_type"));
		String addr1 = pv.getSigungu() + " " + pv.getBunji();
		String addr2 = pv.getSigungu() + " " + pv.getBunji() + " " + pv.getDanji();
		model.addAttribute("detail_suic", propertyservice.detailpropertysuic(pv));
		model.addAttribute("detail_sil", propertyservice.detailpropertysil(pv));
		model.addAttribute("detail_jw", propertyservice.detailpropertyjw(pv));
		model.addAttribute("geocode", changeaddress.geocodeMain(addr1, addr2));
		System.out.println("좌표:" + changeaddress.geocodeMain(addr1, addr2));

		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("userEmail") == null) {
			mav.setViewName("redirect:/index.sp");
		} else {

			mav.setViewName("forward:/detail.sp");
		}
		return mav;
	}

}
