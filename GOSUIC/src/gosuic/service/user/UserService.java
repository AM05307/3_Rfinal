package gosuic.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gosuic.dao.user.UserDao;
import gosuic.entity.PropertyVo;
import gosuic.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	// 회원가입정보 
	public  boolean insertUser(UserVo user) {
		return userDao.insertUser(user);
	}
	
	//로그인
	public boolean login(UserVo vo) {
		return userDao.login(vo);
	}
	// 아이디 중복체크
	public int checkID(String userEmail) {
		return userDao.checkId(userEmail);
	}

	public int checkPw(String userPw) {
		return userDao.checkPw(userPw);
	}

	public List<UserVo> myPage(String email) {
		System.out.println("서비스객체 myPage() 메소드");
		List<UserVo> res = null;
		res = userDao.myPage(email);
		return res;
	}

	//관심매물등록
	public int insertat_Property(String userEmail, PropertyVo pv) {
		int res=0;
		String str=null;
		str = userDao.findat_Property(userEmail,pv);
		System.out.println("서비스에서str출력"+str);
		if (str.equals("0")) {
			res=userDao.insertat_Property(userEmail,pv);
		}
		return res;
	}

	public List<PropertyVo> getAt_property(String email) {
		System.out.println("겟엣프로퍼티이멜:"+email);
		List<PropertyVo> pv = null;
		pv = userDao.getAt_property(email);
		return pv;
	}

	public int deleteat_Property(String userEmail, PropertyVo pv) {
		int res=0;
		String str=null;
		str = userDao.findat_Property(userEmail,pv);
		System.out.println("서비스에서str출력"+str);
		if (str.equals("1")) {
			res=userDao.deleteat_Property(userEmail,pv);
		}
		return res;
	}

}
