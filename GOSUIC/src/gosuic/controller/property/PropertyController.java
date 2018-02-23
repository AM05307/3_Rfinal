package gosuic.controller.property;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import gosuic.service.property.ChangeAddress;
import gosuic.service.property.PropertyService;


@Controller
public class PropertyController {

	@Autowired
	private PropertyService propertyservice;
	@Autowired
	private ChangeAddress changeaddress;

	// ��ü ����ϱ�
	@RequestMapping("/list.sp")
	public ModelAndView all_list(Model model, HttpSession session,HttpServletRequest request) {
		System.out.println("�Ѿ�� �ּ�:"+request.getParameter("searchaddr"));
		String addr = request.getParameter("searchaddr");
		model.addAttribute("all_list", propertyservice.listApt(addr));
		
		
		/*ArrayList<String> al = new ArrayList<>();
		String str = propertyservice.listApt(addr).get(0).getSigungu();
		String[] words = str.split("\\s"); // whitespace
		for (String w : words) {
		    al.add(w);
		}
		if (al.size() == 4) {
			request.setAttribute("addr", al.get(2)+" "+al.get(3));
		}else {
			request.setAttribute("addr", al.get(1)+" "+al.get(2));
		}
		*/
		System.out.println(model.toString());
		System.out.println("�Ź���� ���");
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("userEmail") == null) {
			System.out.println("�̷α��� �α��ο��");
			mav.setViewName("redirect:/index.sp");
		} else {
			mav.setViewName("forward:/list2.sp");
			//mav.setViewName("forward:/list2.sp?dong=" + vo.getDong());
		}
		return mav;
	}

	@RequestMapping("/property.sp")
	public ModelAndView Property(HttpSession session, Model model,HttpServletRequest request) throws SAXException, IOException, ParserConfigurationException {
		System.out.println("�Ź��� ���");
		System.out.println("�Ѿ�°�"+request.getParameter("sigungu")+request.getParameter("bunji")+request.getParameter("danji")+request.getParameter("myunjuk")+request.getParameter("floor"));
		String sigungu = request.getParameter("sigungu");
		String bunji = request.getParameter("bunji");
		String danji = request.getParameter("danji");
		String myunjuk =request.getParameter("myunjuk");
		String floor =request.getParameter("floor");
		String price = request.getParameter("price");
		String addr1 = sigungu+" "+bunji;
		String addr2 = sigungu+" "+bunji+" "+danji;
		model.addAttribute("detail_suic", propertyservice.detailpropertysuic(sigungu,bunji,danji,myunjuk,floor,price));
		model.addAttribute("detail_sil", propertyservice.detailpropertysil(sigungu,bunji,danji,myunjuk,floor));
		model.addAttribute("detail_jw", propertyservice.detailpropertyjw(sigungu,bunji,danji,myunjuk,floor));
		model.addAttribute("geocode", changeaddress.geocode(addr1,addr2));
		System.out.println("��ǥ:"+changeaddress.geocode(addr1,addr2));
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("userEmail") == null) {
			mav.setViewName("redirect:/index.sp");
		} else {
			
			mav.setViewName("forward:/detail.sp");
		}
		return mav;
	}
}
