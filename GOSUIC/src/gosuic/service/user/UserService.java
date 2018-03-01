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
	
	// ȸ���������� 
	public  boolean insertUser(UserVo user) {
		return userDao.insertUser(user);
	}
	
	//�α���
	public boolean login(UserVo vo) {
		return userDao.login(vo);
	}
	// ���̵� �ߺ�üũ
	public int checkID(String userEmail) {
		return userDao.checkId(userEmail);
	}

	public int checkPw(String userPw) {
		return userDao.checkPw(userPw);
	}

	public List<UserVo> myPage(String email) {
		System.out.println("���񽺰�ü myPage() �޼ҵ�");
		List<UserVo> res = null;
		res = userDao.myPage(email);
		return res;
	}

	//���ɸŹ����
	public int insertat_Property(String userEmail, PropertyVo pv) {
		int res=0;
		String str=null;
		str = userDao.findat_Property(userEmail,pv);
		System.out.println("���񽺿���str���"+str);
		if (str.equals("0")) {
			res=userDao.insertat_Property(userEmail,pv);
		}
		return res;
	}

	public List<PropertyVo> getAt_property(String email) {
		System.out.println("�ٿ�������Ƽ�̸�:"+email);
		List<PropertyVo> pv = null;
		pv = userDao.getAt_property(email);
		return pv;
	}

	public int deleteat_Property(String userEmail, PropertyVo pv) {
		int res=0;
		String str=null;
		str = userDao.findat_Property(userEmail,pv);
		System.out.println("���񽺿���str���"+str);
		if (str.equals("1")) {
			res=userDao.deleteat_Property(userEmail,pv);
		}
		return res;
	}

}
