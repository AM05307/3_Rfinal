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

	// 매물목록 출력
	public List<AptInfo> listApt(String addr) {
		System.out.println("propertydao listapt()메소드");
		
		List<AptInfo> list= null;
		String[] address = addr.split(" ");
		
		System.out.println(address.length);
		
		if(address.length==3) {
			String addr1 = address[0];
			String addr2 = address[1];
			String addr3 = address[2];
			list = getJdbcTemplate().query(
					"SELECT * FROM apartment where sigungu like '%" + addr1 + "%" + addr2 + "%" + addr3 + "%'",
					new RowMapper<AptInfo>() {

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
							// ob.setHit(rs.getString("hit"));

							return ob;
						}
					});
			}else if(address.length==2){
				String addr1 = address[0];
				String addr2 = address[1];
				list = getJdbcTemplate().query(
						"SELECT * FROM apartment where sigungu like '%" + addr1 + "%" + addr2 + "%'",
						new RowMapper<AptInfo>() {

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
								// ob.setHit(rs.getString("hit"));

								return ob;
							}
						});
				}else if(address.length==1){
					System.out.println(addr);
					list = getJdbcTemplate().query(
							"SELECT * FROM apartment where sigungu like '%" + addr + "%'",
							new RowMapper<AptInfo>() {

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
									// ob.setHit(rs.getString("hit"));

									return ob;
								}
							});
					}
		
			return list;
		}

	public List<AptInfo> detailproperty(String sigungu,String bunji,String danji,String myunjuk) {
		List<AptInfo> detail =null;
		
		detail = getJdbcTemplate().query(
				"SELECT * FROM apartment where sigungu ='"+sigungu+"' and bunji='"+bunji+"' and danji='"+danji+"' and myunjuk='"+myunjuk+"' ",
				new RowMapper<AptInfo>() {

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
						// ob.setHit(rs.getString("hit"));

						return ob;
					}
				});

	return detail;
	}
	

}
