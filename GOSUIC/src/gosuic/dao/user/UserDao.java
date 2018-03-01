package gosuic.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gosuic.entity.PropertyVo;
import gosuic.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	// 회원가입
	public boolean insertUser(UserVo user) {
		int n = getJdbcTemplate().update("insert into userinfo values(?,?,?,?,?,?)",
				new Object[] { user.getUserEmail(), user.getUserID(), user.getPassword1(), user.getUserName(),
						user.getUserBirthday(), user.getUserGender() });
		return (n > 0) ? true : false;
	}

	// 로그인
	public boolean login(UserVo vo) {
		System.out.println("록인dao들어옴");
		System.out.println("다오의 " + vo.getUserEmail());
		try {
			String str = getJdbcTemplate().queryForObject(
					"select useremail from userinfo where useremail=? and userpassword=?",
					new Object[] { vo.getUserEmail(), vo.getPassword1() }, String.class);
			System.out.println("str을 찍어보자" + str);

		} catch (EmptyResultDataAccessException e) {
			System.out.println("결과없음");
			return false;
		}
		return true;
	}

	// 아이디중복 체크
	public int checkId(String userEmail) {
		try {
			System.out.println("아이디 중복체크 다오 : " + userEmail);
			String check = getJdbcTemplate().queryForObject("select userID from userinfo where useremail=?",
					new Object[] { userEmail }, String.class);
			System.out.println("======== " + check);

		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;

	}

	//구현중!
	public int checkPw(String userPw) {
		try {
			System.out.println("패스워드체크 다오 : " + userPw);
			String check = getJdbcTemplate().queryForObject("select userPw from userinfo where userID=? and userPw=?",
					new Object[] { userPw }, String.class);
			System.out.println("======== " + check);

		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;

	}

	public List<UserVo> myPage(String email) {
		List<UserVo> userInfo = null;

		userInfo = getJdbcTemplate().query("SELECT * FROM userinfo where useremail ='" + email + "' ", new RowMapper<UserVo>() {

					@Override
					public UserVo mapRow(ResultSet rs, int num) throws SQLException {

						UserVo uv = new UserVo();

						uv.setUserEmail(rs.getString("useremail"));
						uv.setUserID(rs.getString("userid"));
						uv.setUserName(rs.getString("username"));
						uv.setUserBirthday(rs.getString("userbirth"));
						uv.setUserGender(rs.getString("userGender"));
						uv.setPassword1(rs.getString("userpassword"));

						return uv;
					}
				});
		
		System.out.println("출력디테일:" + userInfo.get(0));
		return userInfo;
	}
	
	//관심매물 등록
	public int insertat_Property(String userEmail, PropertyVo pv) {
		int res = getJdbcTemplate().update("insert into at_property values(?,?,?,?,?,?,?,?)",
				new Object[] { userEmail, pv.getSigungu(), pv.getBunji(), pv.getDanji(), pv.getMyunjuk(),
						pv.getFloor(), pv.getC_type(),pv.getGunchook_year() });
		return res;
	}

	public String findat_Property(String userEmail, PropertyVo pv) {

		String cnt = null;
		try {
		cnt = getJdbcTemplate().queryForObject("select count(*) from at_property where useremail=? and sigungu=? and bunji=? and danji=? and myunjuk=? and floor=? and c_type=? and gunchook_year=?",
				new Object[] { userEmail, pv.getSigungu(), pv.getBunji(), pv.getDanji(), pv.getMyunjuk(),
						pv.getFloor(), pv.getC_type(),pv.getGunchook_year() }, String.class);
		System.out.println(cnt);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			
		}
		return cnt;

	}

	public List<PropertyVo> getAt_property(String email) {
		List<PropertyVo> myproperty = null;

		myproperty = getJdbcTemplate().query("SELECT * FROM at_property where useremail ='" + email + "' ", new RowMapper<PropertyVo>() {

					@Override
					public PropertyVo mapRow(ResultSet rs, int num) throws SQLException {

						PropertyVo pv = new PropertyVo();

						pv.setSigungu(rs.getString("sigungu"));
						pv.setBunji(rs.getString("bunji"));
						pv.setDanji(rs.getString("danji"));
						pv.setMyunjuk(rs.getString("myunjuk"));
						pv.setFloor(rs.getString("floor"));
						pv.setC_type(rs.getString("c_type"));
						pv.setGunchook_year(rs.getString("gunchook_year"));
						
						return pv;
					}
				});
		
		System.out.println("관심매물:" +myproperty);
		return myproperty;
	}

	public int deleteat_Property(String userEmail, PropertyVo pv) {
		int res = getJdbcTemplate().update("delete from at_property where userEmail=? and sigungu=? and bunji=? and danji=? and myunjuk=? and floor=? and c_type=? and gunchook_year=?",
				new Object[] { userEmail, pv.getSigungu(), pv.getBunji(), pv.getDanji(), pv.getMyunjuk(),
						pv.getFloor(), pv.getC_type(),pv.getGunchook_year() });
		return res;
	}

}
