package gosuic.dao.property;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gosuic.entity.PropertyVo;


@Repository
public class RentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	// 해당 매물의 월세값
	public List<PropertyVo> getJw(PropertyVo pv, String tName) {
		System.out.println("getjw로 넘어온값:"+pv+tName);
		List<PropertyVo> listjw =null;
		
		listjw = getJdbcTemplate().query(
				"SELECT * FROM "+tName+"_jw where sigungu ='"+pv.getSigungu()+"' and bunji='"+pv.getBunji()+"' and danji='"+pv.getDanji()+"' and myunjuk='"+pv.getMyunjuk()+"' ",
				new  RowMapper<PropertyVo>(){

					@Override
					public PropertyVo mapRow(ResultSet res, int num) throws SQLException {

						PropertyVo jw = new PropertyVo();
						
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

	public List<PropertyVo> getJwforRent(PropertyVo pv,String tName) {
		System.out.println("getjw로 넘어온값:"+pv+tName);
		String query ="SELECT * FROM "+tName+"_jw where sigungu ='"+pv.getSigungu()+"' and bunji='"+pv.getBunji()+"' and danji='"+pv.getDanji()+"' and myunjuk='"+pv.getMyunjuk()+"' and junwol = '월세'";
		List<PropertyVo> listjw =null;
		
		listjw = getJdbcTemplate().query(query,	new  RowMapper<PropertyVo>(){

					@Override
					public PropertyVo mapRow(ResultSet res, int num) throws SQLException {

						PropertyVo jw = new PropertyVo();
						
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
		System.out.println("출력월세:"+listjw);
	return listjw;
	}

	public List<PropertyVo> getMaxDeposit(PropertyVo pv, String tName) {
		System.out.println("getjw로 넘어온값:"+pv+tName);
		String query ="SELECT * FROM "+tName+"_jw where sigungu ='"+pv.getSigungu()+"' and bunji='"+pv.getBunji()+"' and danji='"+pv.getDanji()+"' and myunjuk='"+pv.getMyunjuk()+"' and junwol = '전세'";
		List<PropertyVo> listjw =null;
		
		listjw = getJdbcTemplate().query(query,	new  RowMapper<PropertyVo>(){

					@Override
					public PropertyVo mapRow(ResultSet res, int num) throws SQLException {

						PropertyVo jw = new PropertyVo();
						
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
		System.out.println("출력전세:"+listjw);
	return listjw;
	}
	

	
}
