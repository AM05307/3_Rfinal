package gosuic.service.property;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tomcat.util.net.SSLHostConfigCertificate.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gosuic.dao.property.PropertyDao;
import gosuic.dao.property.RentDao;
import gosuic.entity.PropertyVo;
import gosuic.entity.SuicInfoVo;
import gosuic.entity.ProfitVo;


@Service
public class PropertyService {

	@Autowired
	private PropertyDao propertyDao;
	@Autowired
	private RentDao rentDao;
	
	// 매물 목록 출력
	public List<PropertyVo> listApt(String addr) {
		System.out.println("서비스객체 listApt() 메소드");
		List<PropertyVo> res = null;
		res = propertyDao.listApt(addr);
		return res;
	}

	public List<PropertyVo> listOffi(String addr) {
		System.out.println("서비스객체 listApt() 메소드");
		List<PropertyVo> res = null;
		res = propertyDao.listOffi(addr);
		return res;
	}
	
	public List<PropertyVo> listYeunda(String addr) {
		System.out.println("서비스객체 listApt() 메소드");
		List<PropertyVo> res = null;
		res = propertyDao.listYeunda(addr);
		return res;
	}
	
	public List<PropertyVo> detailpropertysil(String sigungu, String bunji, String danji, String myunjuk, String floor,String tName) {

		List<PropertyVo> res = null;
		res = propertyDao.detailpropertysil(sigungu, bunji, danji, myunjuk, floor,tName);
		return res;
	}
	
	public List<PropertyVo> detailpropertyjw(String sigungu, String bunji, String danji, String myunjuk, String floor,String tName) {

		List<PropertyVo> res=null;
		res = rentDao.getJw(sigungu, bunji, danji, myunjuk, floor,tName);
		System.out.println("detailpropertyjw에서 찍어보는 res"+res);
		return res;
	}

	
	
	
	public List<PropertyVo> detailpropertyjwforRent(String sigungu, String bunji, String danji, String myunjuk, String floor,String tName) {

		List<PropertyVo> res=null;
		res = rentDao.getJwforRent(sigungu, bunji, danji, myunjuk, floor,tName);
		System.out.println("detailpropertyjw에서 찍어보는 res"+res);
		return res;
	}


	public String getMaxDeposit(String sigungu, String bunji, String danji, String myunjuk, String floor,String tName) {
		System.out.println("넘어온값??"+sigungu+bunji+danji+myunjuk+floor);
		String result = null;
		
		List<PropertyVo> jw=null;
		List<String> depositlist = new ArrayList<>();
		jw = rentDao.getMaxDeposit(sigungu, bunji, danji, myunjuk, floor,tName);
		System.out.println("getMaxDeposit의 jw"+jw);
		
		if (jw.isEmpty()== false) {
			if(jw.size()>1) {
				for (int i = 0; i < jw.size(); i++) {
					depositlist.add(jw.get(i).getDeposit());
				}
				if(depositlist.isEmpty()==false) {
					Collections.sort(depositlist);
					result = depositlist.get(jw.size()-1);
					}
			}else {
				result = jw.get(0).getDeposit();
			}
		}
		return result;
	}
		
		public ProfitVo getprofit(String sigungu, String bunji, String danji, String myunjuk, String floor, String price,String tName) {
			ProfitVo suicvo = new ProfitVo();
			
			if(String.valueOf(tName).equals("아파트")){
				tName = "apt";
			}else if(String.valueOf(tName).equals("오피스텔")){
				tName = "offi";
				
			}else if(String.valueOf(tName).equals("연립다세대")){
				tName = "yeun_da";
			}
			System.out.println("겟프로핏으로넘어온값??"+sigungu+bunji+danji+myunjuk+floor+price+tName);
			
			double nprice ;
				nprice = typeChange(price);
			double rent = 0;
			double deposit=0;
			double result=0;
			
			double maxprofit=0;
			double minprofit=0;
			double sumprofit=0;
			double avgprofit=0;
			
			List<Double> suic = new ArrayList<>();
			List<PropertyVo> jw=null;
					
			jw = detailpropertyjwforRent(sigungu, bunji, danji, myunjuk, floor,tName);
			
			System.out.println("getprofit의 jw"+jw);
			
			if (jw.isEmpty()== false) {
				if(jw.size()>1) {
					for (int i = 0; i < jw.size(); i++) {
						System.out.println("전월데이타수:"+jw.size());
						rent = (double)jw.get(i).getRent();
						deposit = (double)typeChange(jw.get(i).getDeposit());
						
						result = rent*12 / (nprice-deposit);
						result = Math.round(result*10000);
						result = result/100;
						suic.add(result);	
						System.out.println("계산결과:"+result);
						sumprofit = sumprofit+result;
					}
					if(suic.isEmpty()==false) {
						Collections.sort(suic);
						minprofit = suic.get(0);	
						maxprofit = suic.get(suic.size()-1);
						avgprofit = sumprofit/suic.size();
						avgprofit = Math.round(avgprofit*100);
						avgprofit = avgprofit/100;
					}
				}else {
					rent = (double)jw.get(0).getRent();
					deposit = (double)typeChange(jw.get(0).getDeposit());
					result = rent*12 / (nprice-deposit);
					result = Math.round(result*10000)/100;
					
					maxprofit = result;
					minprofit = result;
					avgprofit = result;
				}				
			}		
		
			
			System.out.println("최대:"+maxprofit);
			System.out.println("최소:"+minprofit);
			System.out.println(suicvo);
			suicvo.setMinProfit(minprofit);
			suicvo.setMaxProfit(maxprofit);
			suicvo.setAvgProfit(avgprofit);
		//System.out.println("profit?"+result);
		return suicvo;
	}
	
	/*public List<AptVo> sortRent(String sigungu, String bunji, String danji, String myunjuk, String floor) {
		System.out.println("넘어온값??"+sigungu+bunji+danji+myunjuk+floor);
		int maxRent = 0;
		AptVo jwtemp1 ;
		AptVo jwtemp2 ;
		List<AptVo> jw=null;
		List<Integer> list = new ArrayList<>();
		jw = rentInfo(sigungu, bunji, danji, myunjuk, floor);
		System.out.println("maxrent의 rent"+jw);
		
		int i =0;
		int j =0;
		if (jw.isEmpty()== false) {
			if(jw.size()>1) {
				for (i= 0 ; i < jw.size()-1; i++) {
					for(j = i+1; j<jw.size(); j++) {
						
						jwtemp1=jw.get(i);
						jwtemp2=jw.get(j);
												
						if(jwtemp1.getRent()<jwtemp2.getRent()) {
							jw.set(i, jwtemp2);
							jw.set(j, jwtemp1);
						}
					}
				}
			}
				maxRent = jw.get(0).getRent();
			}else {
				maxRent=jw.get(0).getRent();
			}
		
		
		return jw;
	}*/
	


	public int typeChange(String deposit){
		System.out.println("넘어온 가격:"+deposit);
		int res;
		String depositarray[]=null;
		List<String> temp = new ArrayList<>();
		String dep;
		depositarray=deposit.split(",");
		
		for(String str : depositarray) {
			temp.add(str);
		}
		
		if(temp.size()==2) {
		dep=temp.get(0)+temp.get(1);
		res= Integer.parseInt(dep);
		}else if(temp.size()==3){
			dep=temp.get(0)+temp.get(1)+temp.get(2);
			res= Integer.parseInt(dep);
		}else {
			dep=temp.get(0);
			res= Integer.parseInt(dep);
		}
		
		System.out.println("형변환후:"+res);	
		return res;
	}

	
	public SuicInfoVo detailpropertysuic(String sigungu, String bunji, String danji, String myunjuk, String floor, String price,String tName) {
		System.out.println("detailpropertysuic넘어온값??"+sigungu+bunji+danji+myunjuk+floor+price+tName);
		
		SuicInfoVo suicInfo = new SuicInfoVo();
		ProfitVo suic = new ProfitVo();
		String maxDeposit = null;
		
		double nprice ;
		nprice = typeChange(price);
		
		int maxPrice =0;
		int minPrice =0;
		int sumPrice=0;
		double avgPrice=0;
				
		List<PropertyVo> jw=null;
		List<PropertyVo> sil=null;
	
		List<Integer> pricelist = new ArrayList<>();
		
		sil= detailpropertysil(sigungu, bunji, danji, myunjuk, floor,tName);
		
		System.out.println("getprofit의 jw"+jw);
		System.out.println("getprofit의 sil"+sil);
		
		if (sil.isEmpty()== false) {
			if(sil.size()>1) {
				for (int i = 0; i < sil.size(); i++) {
					pricelist.add(typeChange(sil.get(i).getPrice()));
					System.out.println("11"+typeChange(sil.get(i).getPrice()));
					sumPrice = sumPrice +typeChange(sil.get(i).getPrice());
					System.out.println("12"+sumPrice);
				}
				
				if(pricelist.isEmpty()==false) {
					Collections.sort(pricelist);
					maxPrice = pricelist.get(0);
					System.out.println("13"+pricelist.get(0));
					minPrice = pricelist.get(sil.size()-1);
					System.out.println("14"+pricelist.get(sil.size()-1));
				}
				avgPrice = sumPrice/sil.size();
				System.out.println("15"+avgPrice);
			}else {
				maxPrice = typeChange(sil.get(0).getPrice());
				System.out.println("16"+maxPrice);
				minPrice = typeChange(sil.get(0).getPrice());
				System.out.println("17"+minPrice);
				sumPrice = sumPrice +typeChange(sil.get(0).getPrice());
				System.out.println("18"+sumPrice);
				avgPrice = sumPrice/1;
				System.out.println("19"+avgPrice);				
			}
			
		}
		
		suic = getprofit(sigungu, bunji, danji, myunjuk, floor, price, tName);
		maxDeposit = getMaxDeposit(sigungu, bunji, danji, myunjuk, floor, tName);
		
		try {
		suicInfo.setMaxPrice(maxPrice);
		suicInfo.setMinPrice(minPrice);
		suicInfo.setAvgPrice(avgPrice);
		suicInfo.setMaxRate(suic.getMaxProfit());
		suicInfo.setMinRate(suic.getMinProfit());
		suicInfo.setAvgRate(suic.getAvgProfit());
		suicInfo.setMaxDeposit(maxDeposit);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("suic인포"+suicInfo);
		
		return suicInfo;
	}
}
