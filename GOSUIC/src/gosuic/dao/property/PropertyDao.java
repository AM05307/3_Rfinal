package gosuic.dao.property;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gosuic.entity.PropertyVo;
import gosuic.service.property.PropertyService;

@Repository
public class PropertyDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	private PropertyService propertyservice;

	private double suic =0.0;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	// 아파트 매물목록 출력
	public List<PropertyVo> listApt(String addr) {
		System.out.println("propertydao listapt()메소드");
		
		List<PropertyVo> list= null;
		String[] address = addr.split(" ");
		
		System.out.println(address.length);
		
		if(address.length==3) {
			String addr1 = address[0];
			String addr2 = address[1];
			String addr3 = address[2];
			list = getJdbcTemplate().query(
					"SELECT * FROM apt_sil where sigungu like '%" + addr1 + "%" + addr2 + "%" + addr3 + "%'",
					new RowMapper<PropertyVo>() {

						@Override
						public PropertyVo mapRow(ResultSet rs, int num) throws SQLException {

							PropertyVo ob = new PropertyVo();

							ob.setSigungu(rs.getString("sigungu"));
							ob.setBunji(rs.getString("bunji"));
							ob.setBonbeon(rs.getString("bonbeon"));
							ob.setBubeon(rs.getString("bubeon"));
							ob.setDanji(rs.getString("danji"));
							//ob.setJunwol(rs.getString("junwol"));
							ob.setMyunjuk(rs.getString("myunjuk"));
							ob.setContract_year_month(rs.getString("contract_year_month"));
							ob.setContract_day(rs.getString("contract_day"));
							ob.setPrice(rs.getString("price"));
							//ob.setDeposit(rs.getString("deposit"));
							//ob.setRent(rs.getString("rent"));
							ob.setFloor(rs.getString("floor"));
							ob.setGunchook_year(rs.getString("gunchook_year"));
							ob.setDoromyung(rs.getString("doromyung"));
							ob.setC_type(rs.getString("c_type"));
							ob.setHit(rs.getInt("hit"));
							//int rent= propertyservice.getMaxRent(rs.getString("sigungu"),rs.getString("bunji"),rs.getString("danji"),rs.getString("myunjuk"),rs.getString("floor"));
							suic= (propertyservice.getprofit(ob)).getMaxProfit();
							ob.setSuic(suic);

							return ob;
						}
					});
			}else if(address.length==2){
				String addr1 = address[0];
				String addr2 = address[1];
				list = getJdbcTemplate().query(
						"SELECT * FROM apt_sil where sigungu like '%" + addr1 + "%" + addr2 + "%'",
						new RowMapper<PropertyVo>() {

							@Override
							public PropertyVo mapRow(ResultSet rs, int num) throws SQLException {

								PropertyVo ob = new PropertyVo();

								ob.setSigungu(rs.getString("sigungu"));
								ob.setBunji(rs.getString("bunji"));
								ob.setBonbeon(rs.getString("bonbeon"));
								ob.setBubeon(rs.getString("bubeon"));
								ob.setDanji(rs.getString("danji"));
								//ob.setJunwol(rs.getString("junwol"));
								ob.setMyunjuk(rs.getString("myunjuk"));
								ob.setContract_year_month(rs.getString("contract_year_month"));
								ob.setContract_day(rs.getString("contract_day"));
								ob.setPrice(rs.getString("price"));
								//ob.setDeposit(rs.getString("deposit"));
								//ob.setRent(rs.getString("rent"));
								ob.setFloor(rs.getString("floor"));
								ob.setGunchook_year(rs.getString("gunchook_year"));
								ob.setDoromyung(rs.getString("doromyung"));
								ob.setC_type(rs.getString("c_type"));
								ob.setHit(rs.getInt("hit"));
								//int rent= propertyservice.getMaxRent(rs.getString("sigungu"),rs.getString("bunji"),rs.getString("danji"),rs.getString("myunjuk"),rs.getString("floor"));
								suic= (propertyservice.getprofit(ob)).getMaxProfit();
								ob.setSuic(suic);

								return ob;
							}
						});
				}else if(address.length==1){
					System.out.println(addr);
					list = getJdbcTemplate().query(
							"SELECT * FROM apt_sil where sigungu like '%" + addr + "%'",
							new RowMapper<PropertyVo>() {

								@Override
								public PropertyVo mapRow(ResultSet rs, int num) throws SQLException {

									PropertyVo ob = new PropertyVo();

									ob.setSigungu(rs.getString("sigungu"));
									ob.setBunji(rs.getString("bunji"));
									ob.setBonbeon(rs.getString("bonbeon"));
									ob.setBubeon(rs.getString("bubeon"));
									ob.setDanji(rs.getString("danji"));
									//ob.setJunwol(rs.getString("junwol"));
									ob.setMyunjuk(rs.getString("myunjuk"));
									ob.setContract_year_month(rs.getString("contract_year_month"));
									ob.setContract_day(rs.getString("contract_day"));
									ob.setPrice(rs.getString("price"));
									//ob.setDeposit(rs.getString("deposit"));
									//ob.setRent(rs.getString("rent"));
									ob.setFloor(rs.getString("floor"));
									ob.setGunchook_year(rs.getString("gunchook_year"));
									ob.setDoromyung(rs.getString("doromyung"));
									ob.setC_type(rs.getString("c_type"));
									ob.setHit(rs.getInt("hit"));
									
									//rent= propertyservice.getMaxRent(rs.getString("sigungu"),rs.getString("bunji"),rs.getString("danji"),rs.getString("myunjuk"),rs.getString("floor"));
									suic= (propertyservice.getprofit(ob)).getMaxProfit();
									
									ob.setSuic(suic);
									
									return ob;
								}
							});
					}
			System.out.println("출력해보기:"+list);
			return list;
		}

	// 오피스텔 매물목록 출력
		public List<PropertyVo> listOffi(String addr) {
			System.out.println("propertydao listoffi()메소드");
			
			List<PropertyVo> list= null;
			String[] address = addr.split(" ");
			
			System.out.println(address.length);
			
			if(address.length==3) {
				String addr1 = address[0];
				String addr2 = address[1];
				String addr3 = address[2];
				list = getJdbcTemplate().query(
						"SELECT * FROM offi_sil where sigungu like '%" + addr1 + "%" + addr2 + "%" + addr3 + "%'",
						new RowMapper<PropertyVo>() {

							@Override
							public PropertyVo mapRow(ResultSet rs, int num) throws SQLException {

								PropertyVo ob = new PropertyVo();

								ob.setSigungu(rs.getString("sigungu"));
								ob.setBunji(rs.getString("bunji"));
								ob.setBonbeon(rs.getString("bonbeon"));
								ob.setBubeon(rs.getString("bubeon"));
								ob.setDanji(rs.getString("danji"));
								//ob.setJunwol(rs.getString("junwol"));
								ob.setMyunjuk(rs.getString("myunjuk"));
								ob.setContract_year_month(rs.getString("contract_year_month"));
								ob.setContract_day(rs.getString("contract_day"));
								ob.setPrice(rs.getString("price"));
								//ob.setDeposit(rs.getString("deposit"));
								//ob.setRent(rs.getString("rent"));
								ob.setFloor(rs.getString("floor"));
								ob.setGunchook_year(rs.getString("gunchook_year"));
								ob.setDoromyung(rs.getString("doromyung"));
								ob.setC_type(rs.getString("c_type"));
								ob.setHit(rs.getInt("hit"));
								//int rent= propertyservice.getMaxRent(rs.getString("sigungu"),rs.getString("bunji"),rs.getString("danji"),rs.getString("myunjuk"),rs.getString("floor"));
								suic= (propertyservice.getprofit(ob)).getMaxProfit();
								ob.setSuic(suic);

								return ob;
							}
						});
				}else if(address.length==2){
					String addr1 = address[0];
					String addr2 = address[1];
					list = getJdbcTemplate().query(
							"SELECT * FROM offi_sil where sigungu like '%" + addr1 + "%" + addr2 + "%'",
							new RowMapper<PropertyVo>() {

								@Override
								public PropertyVo mapRow(ResultSet rs, int num) throws SQLException {

									PropertyVo ob = new PropertyVo();

									ob.setSigungu(rs.getString("sigungu"));
									ob.setBunji(rs.getString("bunji"));
									ob.setBonbeon(rs.getString("bonbeon"));
									ob.setBubeon(rs.getString("bubeon"));
									ob.setDanji(rs.getString("danji"));
									//ob.setJunwol(rs.getString("junwol"));
									ob.setMyunjuk(rs.getString("myunjuk"));
									ob.setContract_year_month(rs.getString("contract_year_month"));
									ob.setContract_day(rs.getString("contract_day"));
									ob.setPrice(rs.getString("price"));
									//ob.setDeposit(rs.getString("deposit"));
									//ob.setRent(rs.getString("rent"));
									ob.setFloor(rs.getString("floor"));
									ob.setGunchook_year(rs.getString("gunchook_year"));
									ob.setDoromyung(rs.getString("doromyung"));
									ob.setC_type(rs.getString("c_type"));
									ob.setHit(rs.getInt("hit"));
									//int rent= propertyservice.getMaxRent(rs.getString("sigungu"),rs.getString("bunji"),rs.getString("danji"),rs.getString("myunjuk"),rs.getString("floor"));
									suic= (propertyservice.getprofit(ob)).getMaxProfit();
									ob.setSuic(suic);

									return ob;
								}
							});
					}else if(address.length==1){
						System.out.println(addr);
						list = getJdbcTemplate().query(
								"SELECT * FROM offi_sil where sigungu like '%" + addr + "%'",
								new RowMapper<PropertyVo>() {

									@Override
									public PropertyVo mapRow(ResultSet rs, int num) throws SQLException {

										PropertyVo ob = new PropertyVo();

										ob.setSigungu(rs.getString("sigungu"));
										ob.setBunji(rs.getString("bunji"));
										ob.setBonbeon(rs.getString("bonbeon"));
										ob.setBubeon(rs.getString("bubeon"));
										ob.setDanji(rs.getString("danji"));
										//ob.setJunwol(rs.getString("junwol"));
										ob.setMyunjuk(rs.getString("myunjuk"));
										ob.setContract_year_month(rs.getString("contract_year_month"));
										ob.setContract_day(rs.getString("contract_day"));
										ob.setPrice(rs.getString("price"));
										//ob.setDeposit(rs.getString("deposit"));
										//ob.setRent(rs.getString("rent"));
										ob.setFloor(rs.getString("floor"));
										ob.setGunchook_year(rs.getString("gunchook_year"));
										ob.setDoromyung(rs.getString("doromyung"));
										ob.setC_type(rs.getString("c_type"));
										ob.setHit(rs.getInt("hit"));
										
										//rent= propertyservice.getMaxRent(rs.getString("sigungu"),rs.getString("bunji"),rs.getString("danji"),rs.getString("myunjuk"),rs.getString("floor"));
										suic= (propertyservice.getprofit(ob)).getMaxProfit();
										
										ob.setSuic(suic);
										
										return ob;
									}
								});
						}
				System.out.println("출력해보기:"+list);
				return list;
			}
		
		// 연립다세대 매물목록 출력
		public List<PropertyVo> listYeunda(String addr) {
			System.out.println("propertydao listYeunda()메소드");
			
			List<PropertyVo> list= null;
			String[] address = addr.split(" ");
			
			System.out.println(address.length);
			
			if(address.length==3) {
				String addr1 = address[0];
				String addr2 = address[1];
				String addr3 = address[2];
				list = getJdbcTemplate().query(
						"SELECT * FROM Yeun_da_sil where sigungu like '%" + addr1 + "%" + addr2 + "%" + addr3 + "%'",
						new RowMapper<PropertyVo>() {

							@Override
							public PropertyVo mapRow(ResultSet rs, int num) throws SQLException {

								PropertyVo ob = new PropertyVo();

								ob.setSigungu(rs.getString("sigungu"));
								ob.setBunji(rs.getString("bunji"));
								ob.setBonbeon(rs.getString("bonbeon"));
								ob.setBubeon(rs.getString("bubeon"));
								ob.setDanji(rs.getString("danji"));
								//ob.setJunwol(rs.getString("junwol"));
								ob.setMyunjuk(rs.getString("myunjuk"));
								ob.setContract_year_month(rs.getString("contract_year_month"));
								ob.setContract_day(rs.getString("contract_day"));
								ob.setPrice(rs.getString("price"));
								//ob.setDeposit(rs.getString("deposit"));
								//ob.setRent(rs.getString("rent"));
								ob.setFloor(rs.getString("floor"));
								ob.setGunchook_year(rs.getString("gunchook_year"));
								ob.setDoromyung(rs.getString("doromyung"));
								ob.setC_type(rs.getString("c_type"));
								ob.setHit(rs.getInt("hit"));
								//int rent= propertyservice.getMaxRent(rs.getString("sigungu"),rs.getString("bunji"),rs.getString("danji"),rs.getString("myunjuk"),rs.getString("floor"));
								suic= (propertyservice.getprofit(ob)).getMaxProfit();
								ob.setSuic(suic);

								return ob;
							}
						});
				}else if(address.length==2){
					String addr1 = address[0];
					String addr2 = address[1];
					list = getJdbcTemplate().query(
							"SELECT * FROM Yeun_da_sil where sigungu like '%" + addr1 + "%" + addr2 + "%'",
							new RowMapper<PropertyVo>() {

								@Override
								public PropertyVo mapRow(ResultSet rs, int num) throws SQLException {

									PropertyVo ob = new PropertyVo();

									ob.setSigungu(rs.getString("sigungu"));
									ob.setBunji(rs.getString("bunji"));
									ob.setBonbeon(rs.getString("bonbeon"));
									ob.setBubeon(rs.getString("bubeon"));
									ob.setDanji(rs.getString("danji"));
									//ob.setJunwol(rs.getString("junwol"));
									ob.setMyunjuk(rs.getString("myunjuk"));
									ob.setContract_year_month(rs.getString("contract_year_month"));
									ob.setContract_day(rs.getString("contract_day"));
									ob.setPrice(rs.getString("price"));
									//ob.setDeposit(rs.getString("deposit"));
									//ob.setRent(rs.getString("rent"));
									ob.setFloor(rs.getString("floor"));
									ob.setGunchook_year(rs.getString("gunchook_year"));
									ob.setDoromyung(rs.getString("doromyung"));
									ob.setC_type(rs.getString("c_type"));
									ob.setHit(rs.getInt("hit"));
									//int rent= propertyservice.getMaxRent(rs.getString("sigungu"),rs.getString("bunji"),rs.getString("danji"),rs.getString("myunjuk"),rs.getString("floor"));
									suic= (propertyservice.getprofit(ob)).getMaxProfit();
									ob.setSuic(suic);

									return ob;
								}
							});
					}else if(address.length==1){
						System.out.println(addr);
						list = getJdbcTemplate().query(
								"SELECT * FROM Yeun_da_sil where sigungu like '%" + addr + "%'",
								new RowMapper<PropertyVo>() {

									@Override
									public PropertyVo mapRow(ResultSet rs, int num) throws SQLException {

										PropertyVo ob = new PropertyVo();

										ob.setSigungu(rs.getString("sigungu"));
										ob.setBunji(rs.getString("bunji"));
										ob.setBonbeon(rs.getString("bonbeon"));
										ob.setBubeon(rs.getString("bubeon"));
										ob.setDanji(rs.getString("danji"));
										//ob.setJunwol(rs.getString("junwol"));
										ob.setMyunjuk(rs.getString("myunjuk"));
										ob.setContract_year_month(rs.getString("contract_year_month"));
										ob.setContract_day(rs.getString("contract_day"));
										ob.setPrice(rs.getString("price"));
										//ob.setDeposit(rs.getString("deposit"));
										//ob.setRent(rs.getString("rent"));
										ob.setFloor(rs.getString("floor"));
										ob.setGunchook_year(rs.getString("gunchook_year"));
										ob.setDoromyung(rs.getString("doromyung"));
										ob.setC_type(rs.getString("c_type"));
										ob.setHit(rs.getInt("hit"));
										
										//rent= propertyservice.getMaxRent(rs.getString("sigungu"),rs.getString("bunji"),rs.getString("danji"),rs.getString("myunjuk"),rs.getString("floor"));
										suic= (propertyservice.getprofit(ob)).getMaxProfit();
										
										ob.setSuic(suic);
										
										return ob;
									}
								});
						}
				System.out.println("출력해보기:"+list);
				return list;
			}
	
	
	public List<PropertyVo> detailpropertysil(PropertyVo pv,String tName) {
		List<PropertyVo> detail =null;
		
		detail = getJdbcTemplate().query(
				"SELECT * FROM "+tName+"_sil where sigungu ='"+pv.getSigungu()+"' and bunji='"+pv.getBunji()+"' and danji='"+pv.getDanji()+"' and myunjuk='"+pv.getMyunjuk()+"' and floor='"+pv.getFloor()+"' ",
				new RowMapper<PropertyVo>() {

					@Override
					public PropertyVo mapRow(ResultSet rs, int num) throws SQLException {

						PropertyVo ob = new PropertyVo();
					
						ob.setSigungu(rs.getString("sigungu"));
						ob.setBunji(rs.getString("bunji"));
						ob.setBonbeon(rs.getString("bonbeon"));
						ob.setBubeon(rs.getString("bubeon"));
						ob.setDanji(rs.getString("danji"));
						//ob.setJunwol(rs.getString("junwol"));
						ob.setMyunjuk(rs.getString("myunjuk"));
						ob.setContract_year_month(rs.getString("contract_year_month"));
						ob.setContract_day(rs.getString("contract_day"));
						ob.setPrice(rs.getString("price"));
						//ob.setDeposit(rs.getString("deposit"));
						//ob.setRent(rs.getString("rent"));
						ob.setFloor(rs.getString("floor"));
						ob.setGunchook_year(rs.getString("gunchook_year"));
						ob.setDoromyung(rs.getString("doromyung"));
						ob.setC_type(rs.getString("c_type"));
						ob.setHit(rs.getInt("hit"));
						//ob.setSuic(2.4);

						return ob;
					}
				});
		System.out.println("출력디테일:"+detail);
	return detail;
	}
	
	public int pricetypeExchange(String price) {
		
		return 0;
	}

	
	
}
