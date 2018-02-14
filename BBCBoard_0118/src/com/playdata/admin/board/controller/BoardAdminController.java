package com.playdata.admin.board.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playdata.admin.board.model.BoardListDto;
import com.playdata.admin.board.service.BoardAdminService;

@Controller
@RequestMapping("/boardadmin")
public class BoardAdminController {

	@Autowired
	private BoardAdminService boardAdminService;
// 다오에서 쿼리 가지고 옴 
	@RequestMapping("/boardmenu.playdata")
	public String boardMenu(HttpServletRequest request) {
		List<BoardListDto> list = boardAdminService.boardMenu();
		System.out.println("갯수 : " + list.size());
		ServletContext context = request.getServletContext();
		context.setAttribute("boardmenu", list); //db에서 가지고 온걸 boardmenu로 줌
		return "redirect:/index.jsp";
	}

}
