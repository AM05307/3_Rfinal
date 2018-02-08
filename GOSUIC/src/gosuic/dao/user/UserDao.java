package gosuic.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import gosuic.vo.UserVo;

@Repository 
public class UserDao {
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
		
	//회원가입
	public boolean insertUser(UserVo user) {
		int n = getJdbcTemplate().update("insert into userinfo values(?,?,?,?,?,?)" ,
				new Object[] {user.getUserEmail(),user.getUserID(),user.getPassword1(),user.getUserName(),user.getUserBirthday(),user.getUserGender()});
		return (n>0) ? true : false;
	}
	
	//로그인
	public boolean login(String userEmail, String password1) {
		System.out.println("록인dao들어옴");
		System.out.println("다오의 " + userEmail);
		
		String str= getJdbcTemplate().queryForObject("select useremail from userinfo where useremail=? and userpassword=?",
				new Object[] {userEmail,password1}, String.class);
		System.out.println("str을 찍어보자" +str);
		if(str !=null && str != "") { 
				return true;	
		}else
			return false;

	}
	// 아이디중복 체크
	public int checkId(String userEmail) {
		try {
		System.out.println("아이디 중복체크 다오 : " + userEmail );
		String check = getJdbcTemplate().queryForObject("select userID from userinfo where useremail=?", new Object[] {userEmail},String.class);
		System.out.println( "======== "+check);
		
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
		
	}

	}

