package gosuic.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gosuic.dao.user.UserDao;
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

}
