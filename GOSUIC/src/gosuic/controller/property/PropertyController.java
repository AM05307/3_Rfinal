package gosuic.controller.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gosuic.service.property.PropertyService;

@Controller
public class PropertyController {

	@Autowired
	private PropertyService propertyservice;
	
	// ��ü ����ϱ�
		@RequestMapping("/list.sp")
		public String all_list(Model model) {
			model.addAttribute("all_list", propertyservice.listApt());
			System.out.println("�Ź���� ���");
			return "/WEB-INF/view/list.jsp";
		}


}
