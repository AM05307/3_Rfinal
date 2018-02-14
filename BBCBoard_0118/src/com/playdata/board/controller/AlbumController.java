package com.playdata.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.playdata.board.model.AlbumDto;
import com.playdata.board.service.AlbumService;
import com.playdata.common.service.CommonService;
import com.playdata.member.model.MemberDto;
import com.playdata.util.BoardConstance;
import com.playdata.util.PageNavigation;

@Controller
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private AlbumService albumService;  //dao 호출 
	
	private String upFolder; // 업로드할 경로를 생성자에 심었

	public AlbumController() {
		this.upFolder = "C:\\JSPRINGBOARD\\BBCBoard\\WebContent\\upload";
	}

	@RequestMapping("/list.playdata")
	public ModelAndView list(@RequestParam Map<String, String> map, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<AlbumDto> list = albumService.listArticle(map);
		map.put("listsize", BoardConstance.ALBUM_LIST_SIZE + "");
		PageNavigation navigation = commonService.makePageNavigation(map);
		navigation.setRoot(request.getContextPath());
		navigation.setBcode(Integer.parseInt(map.get("bcode")));
		navigation.setKey(map.get("key"));
		navigation.setWord(map.get("word"));
		navigation.setNavigator();
		mav.addObject("articlelist", list);
		mav.addObject("navigator", navigation);
		mav.addObject("querystring", map);
		mav.setViewName("/WEB-INF/album/list");
		return mav;
	}
	//글쓰기로 감 /주소줄에 ㄴ넘어오는 것만 
	//http://localhost:8787/BBCBoard/album/write.playdata?bcode=10&pg=1&key=&word=&seq=
	@RequestMapping(value="/write.playdata", method=RequestMethod.GET)
	public ModelAndView write(@RequestParam Map<String, String> map) { //5개의 변수를 map하나로 받았음
		//bcode=10&pg=1&key=&word=&seq=ㅐ
	/*	map.put("bcode", "10");
		map.put("pg",	"1");
		map.put("key", null);
		map.put("word", null);
		map.put("seq", null);*/
		ModelAndView mav = new ModelAndView();
		mav.addObject("querystring", map);
		mav.setViewName("/WEB-INF/album/write");
		return mav;
	}
	
	//파일에 있는 내용을 다 같이 가져옴 
	// session의 userinfo 
	@RequestMapping(value="/write.playdata", method=RequestMethod.POST)
	public ModelAndView write(AlbumDto albumDto, 
			@RequestParam Map<String, String> map,
			HttpSession session) throws IllegalStateException, IOException {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = commonService.getNextSeq();
			albumDto.setSeq(seq);
			albumDto.setId(memberDto.getId());
			albumDto.setName(memberDto.getName());
		
			
			DateFormat df = new SimpleDateFormat("yyMMdd"); //1 날짜 형식 지정 
			String saveFolder = df.format(new Date());//20180103   경로지정8  //2오늘 날짜로 매핑 
			String uploadPath = upFolder + File.separator + saveFolder;  //File.separator  = 경로 / 가 하나 생김 saveFolder를 오늘 날짜로 폴더 생성 
			File folder = new File(uploadPath); //uploadPath = 오늘날짜 폴더 //여기까지 오늘날짜 폴더 지정 
		
			if(!folder.exists())
				folder.mkdirs() ; //폴더 생서 ㅇ
			albumDto.setSaveFolder(saveFolder);  //dto를 통해서 파일을 db에 저장 
			
			List<MultipartFile> list = albumDto.getUpfile();
			for (MultipartFile multipartFile : list) {
				if(!multipartFile.isEmpty()) {
					String ofile = multipartFile.getOriginalFilename();
					albumDto.setOriginPicture(ofile);
					String savePicture = UUID.randomUUID().toString() + ofile.substring(ofile.lastIndexOf("."));//12312312.jpg
					albumDto.setSavePicture(savePicture);  //setSavePicture까지 자름. 이 파일을 write article로 저장  
					multipartFile.transferTo(new File(uploadPath, savePicture));
				}
			}			
			
			int cnt = albumService.writeArticle(albumDto);
			mav.addObject("querystring", map);  //이거 반드시 줘야함  항상 querystring을 가져감 
			mav.addObject("seq", seq);
			mav.setViewName("/WEB-INF/album/writeOk");
		} else {
			mav.setViewName("/login/login");
		}
		return mav;
	}
	
}
