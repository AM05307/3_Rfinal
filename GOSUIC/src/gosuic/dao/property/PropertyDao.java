package gosuic.dao.property;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gosuic.entity.AptInfo;

@Repository 
public class PropertyDao {
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	//매물목록 출력
	public List<AptInfo> listApt(){
		System.out.println("propertydao listapt()메소드");
		List<AptInfo> list = getJdbcTemplate().query("SELECT * FROM apartment where sigungu like '%서초동%'", new RowMapper<AptInfo>() {
			
			@Override
			public AptInfo mapRow(ResultSet rs, int num) throws SQLException {;
				
					AptInfo ob = new AptInfo();
					
					ob.setSigungu(rs.getString("sigungu"));
					ob.setBunji(rs.getString("bunji"));
					ob.setBonbeon(rs.getString("bonbeon"));
					ob.setBubeon(rs.getString("bubeon"));
					ob.setDanji(rs.getString("danji"));
					ob.setJunwol(rs.getString("junwol"));
					ob.setMyunjuk(rs.getString("myunjuk"));
					ob.setContract_year_month(rs.getString("contract_year_month"));
					ob.setContract_day(rs.getString("contract_day"));
					ob.setPrice(rs.getString("price"));
					ob.setDeposit(rs.getString("deposit"));
					ob.setRent(rs.getString("rent"));
					ob.setFloor(rs.getString("floor"));
					ob.setGunchook_year(rs.getString("gunchook_year"));
					ob.setDoromyung(rs.getString("doromyung"));
					//ob.setHit(rs.getString("hit"));
					
					return ob;
			}
		});
		return list;
	}
	
	
	}

