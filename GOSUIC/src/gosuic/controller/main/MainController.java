package gosuic.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	// ȸ������ �Է���������
	@RequestMapping("/joinform.sp")
	public String insertpage() {
		System.out.println("ȸ������ ������ �̵���");
		return "/WEB-INF/view/joinform.jsp";
	}

	// �α��� ��������
	@RequestMapping("/loginform.sp")
	public String loginForm() {
		System.out.println("�α���������");
		return "/WEB-INF/view/loginform.jsp";
	}

	// ���� ��������
	@RequestMapping("/mainform.sp")
	public String mainForm() {
		System.out.println("���� ȭ������");
		return "/WEB-INF/view/main.jsp";
	}

	// �Ź� ����Ʈ ��������
	@RequestMapping("/list2.sp")
	public String listPage() {
		System.out.println("�Ź� ����Ʈ ȭ������");
		return "/WEB-INF/view/list.jsp";
	}
	
	// �󼼸Ź� ��������
		@RequestMapping("/detail.sp")
		public String detailProperty() {
			System.out.println("�ε��� ȭ������");
			return "/WEB-INF/view/property.jsp";
		}

	// �ε��� ��������
	@RequestMapping("/index.sp")
	public String indexPage() {
		System.out.println("�ε��� ȭ������");
		return "/WEB-INF/view/index.jsp";
	}

	// �α����� ����������
	@RequestMapping("/afterlogin.sp")
	public String afterlogin() {
		System.out.println("�α����� ����");
		return "/WEB-INF/view/afterlogin.jsp";
	}

}// class end
