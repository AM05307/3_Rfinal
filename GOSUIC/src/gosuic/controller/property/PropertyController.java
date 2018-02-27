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

import gosuic.service.property.ChangeAddress;
import gosuic.service.property.PropertyService;


@Controller
public class PropertyController {

	@Autowired
	private PropertyService propertyservice;
	@Autowired
	private ChangeAddress changeaddress;
	
	private String tName = null;

	// ��ü ����ϱ�
	@RequestMapping("/list.sp")
	public ModelAndView all_list(Model model, HttpSession session,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		System.out.println("�Ѿ�� �ּ�:"+request.getParameter("searchaddr"));
		String addr = request.getParameter("searchaddr");
		model.addAttribute("all_list_apt", propertyservice.listApt(addr));
		model.addAttribute("all_list_offi", propertyservice.listOffi(addr));
		model.addAttribute("all_list_yeunda", propertyservice.listYeunda(addr));

		if (addr == "") {
			System.out.println("�ּ��Է��ϰ� �������ؿ�");
			mav.setViewName("redirect:/addwindow.sp");
		} else {
			model.addAttribute("all_list", propertyservice.listApt(addr));
			mav.setViewName("forward:/list2.sp");
		}
		return mav;
	}

	@RequestMapping("/property.sp")
	public ModelAndView Property(HttpSession session, Model model,HttpServletRequest request) throws SAXException, IOException, ParserConfigurationException {
		System.out.println("�Ź��� ���");
		System.out.println("�Ѿ�°�"+request.getParameter("sigungu")+request.getParameter("bunji")+request.getParameter("danji")+request.getParameter("myunjuk")+request.getParameter("floor")+request.getParameter("c_type"));
		String c_type = request.getParameter("c_type");
		System.out.println(c_type);
		if(String.valueOf(c_type).equals("����Ʈ")){
			tName = "apt";
		}else if(String.valueOf(c_type).equals("���ǽ���")){
			tName = "offi";
			
		}else if(String.valueOf(c_type).equals("�����ټ���")){
			tName = "yeun_da";
		}
		System.out.println("��Ʈ�ѷ� tname���"+tName);
		String sigungu = request.getParameter("sigungu");
		String bunji = request.getParameter("bunji");
		String danji = request.getParameter("danji");
		String myunjuk =request.getParameter("myunjuk");
		String floor =request.getParameter("floor");
		String price = request.getParameter("price");
		String addr1 = sigungu+" "+bunji;
		String addr2 = sigungu+" "+bunji+" "+danji;
		model.addAttribute("detail_suic", propertyservice.detailpropertysuic(sigungu,bunji,danji,myunjuk,floor,price,tName));
		model.addAttribute("detail_sil", propertyservice.detailpropertysil(sigungu,bunji,danji,myunjuk,floor,tName));
		model.addAttribute("detail_jw", propertyservice.detailpropertyjw(sigungu,bunji,danji,myunjuk,floor,tName));
		model.addAttribute("geocode", changeaddress.geocodeMain(addr1,addr2));
		System.out.println("��ǥ:"+changeaddress.geocodeMain(addr1,addr2));

		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("userEmail") == null) {
			mav.setViewName("redirect:/index.sp");
		} else {
			
			mav.setViewName("forward:/detail.sp");
		}
		return mav;
	}
}
