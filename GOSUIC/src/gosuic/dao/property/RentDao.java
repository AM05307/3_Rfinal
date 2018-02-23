package gosuic.dao.property;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gosuic.entity.AptVo;


@Repository
public class RentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	// 해당 매물의 월세값
	public List<AptVo> getJw(String sigungu,String bunji,String danji,String myunjuk, String floor) {
		System.out.println("getjw로 넘어온값:"+sigungu+bunji+danji+myunjuk+floor);
		List<AptVo> listjw =null;
		
		listjw = getJdbcTemplate().query(
				"SELECT * FROM apt_jw where sigungu ='"+sigungu+"' and bunji='"+bunji+"' and danji='"+danji+"' and myunjuk='"+myunjuk+"' ",
				new  RowMapper<AptVo>(){

					@Override
					public AptVo mapRow(ResultSet res, int num) throws SQLException {

						AptVo jw = new AptVo();
						
						jw.setSigungu(res.getString("sigungu"));
						jw.setBunji(res.getString("bunji"));
						jw.setBonbeon(res.getString("bonbeon"));
						jw.setBubeon(res.getString("bubeon"));
						jw.setDanji(res.getString("danji"));
						jw.setJunwol(res.getString("junwol"));
						jw.setMyunjuk(res.getString("myunjuk"));
						jw.setContract_year_month(res.getString("contract_year_month"));
						jw.setContract_day(res.getString("contract_day"));
						//ob.setPrice(res.getString("price"));
						jw.setDeposit(res.getString("deposit"));
						jw.setRent(res.getInt("rent"));
						jw.setFloor(res.getString("floor"));
						jw.setGunchook_year(res.getString("gunchook_year"));
						jw.setDoromyung(res.getString("doromyung"));
						jw.setC_type(res.getString("c_type"));
						jw.setHit(res.getInt("hit"));
						//ob.setSuic(2.4);

						return jw;
					}
				});
		System.out.println("출력전월:"+listjw);
	return listjw;
	}

	public List<AptVo> getJwforRent(String sigungu, String bunji, String danji, String myunjuk, String floor) {
		System.out.println("getjw로 넘어온값:"+sigungu+bunji+danji+myunjuk+floor);
		List<AptVo> listjw =null;
		
		listjw = getJdbcTemplate().query(
				"SELECT * FROM apt_jw where sigungu ='"+sigungu+"' and bunji='"+bunji+"' and danji='"+danji+"' and myunjuk='"+myunjuk+"' and rent > 0",
				new  RowMapper<AptVo>(){

					@Override
					public AptVo mapRow(ResultSet res, int num) throws SQLException {

						AptVo jw = new AptVo();
						
						jw.setSigungu(res.getString("sigungu"));
						jw.setBunji(res.getString("bunji"));
						jw.setBonbeon(res.getString("bonbeon"));
						jw.setBubeon(res.getString("bubeon"));
						jw.setDanji(res.getString("danji"));
						jw.setJunwol(res.getString("junwol"));
						jw.setMyunjuk(res.getString("myunjuk"));
						jw.setContract_year_month(res.getString("contract_year_month"));
						jw.setContract_day(res.getString("contract_day"));
						//ob.setPrice(res.getString("price"));
						jw.setDeposit(res.getString("deposit"));
						jw.setRent(res.getInt("rent"));
						jw.setFloor(res.getString("floor"));
						jw.setGunchook_year(res.getString("gunchook_year"));
						jw.setDoromyung(res.getString("doromyung"));
						jw.setC_type(res.getString("c_type"));
						jw.setHit(res.getInt("hit"));
						//ob.setSuic(2.4);

						return jw;
					}
				});
		System.out.println("출력전월:"+listjw);
	return listjw;
	}
	

	
}
