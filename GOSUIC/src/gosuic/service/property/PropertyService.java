package gosuic.service.property;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tomcat.util.net.SSLHostConfigCertificate.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gosuic.dao.property.PropertyDao;
import gosuic.dao.property.RentDao;
import gosuic.entity.AptVo;
import gosuic.entity.SuicInfoVo;


@Service
public class PropertyService {

	@Autowired
	private PropertyDao propertyDao;
	@Autowired
	private RentDao rentDao;
	
	// 매물 목록 출력
	public List<AptVo> listApt(String addr) {
		System.out.println("서비스객체 listApt() 메소드");
		List<AptVo> res = null;
		res = propertyDao.listApt(addr);
		return res;
	}

	public List<AptVo> detailpropertysil(String sigungu, String bunji, String danji, String myunjuk, String floor) {

		List<AptVo> res = null;
		res = propertyDao.detailpropertysil(sigungu, bunji, danji, myunjuk, floor);
		return res;
	}
	
	public List<AptVo> detailpropertyjw(String sigungu, String bunji, String danji, String myunjuk, String floor) {

		List<AptVo> res=null;
		res = rentDao.getJw(sigungu, bunji, danji, myunjuk, floor);
		System.out.println("detailpropertyjw에서 찍어보는 res"+res);
		return res;
	}


	public List<AptVo> detailpropertyjwforRent(String sigungu, String bunji, String danji, String myunjuk, String floor) {

		List<AptVo> res=null;
		res = rentDao.getJwforRent(sigungu, bunji, danji, myunjuk, floor);
		System.out.println("detailpropertyjw에서 찍어보는 res"+res);
		return res;
	}


	public int getMaxRent(String sigungu, String bunji, String danji, String myunjuk, String floor) {
		System.out.println("넘어온값??"+sigungu+bunji+danji+myunjuk+floor);
		int res = 0;
		
		List<AptVo> jw=null;
		List<Integer> rentlist = new ArrayList<>();
		jw = detailpropertyjw(sigungu, bunji, danji, myunjuk, floor);
		System.out.println("maxrent의 rent"+jw);
		
		if (jw.isEmpty()== false) {
			if(jw.size()>1) {
				for (int i = 0; i < jw.size(); i++) {
					rentlist.add(jw.get(i).getRent());
				}
				if(rentlist.isEmpty()==false) {
					Collections.sort(rentlist);
					res = rentlist.get(0);
					}
			}else {
				res =jw.get(0).getRent();
			}
		}
		return res;
	}
		
		public double getprofit(String sigungu, String bunji, String danji, String myunjuk, String floor, String price) {
			System.out.println("겟프로핏으로넘어온값??"+sigungu+bunji+danji+myunjuk+floor+price);
			
			double nprice ;
			nprice = typeChange(price);
			
			double rentres = 0;
			double depres=0;
			
			double result=0;
			
			List<AptVo> jw=null;
			List<Double> rentlist = new ArrayList<>();
			List<Double> depositlist = new ArrayList<>();
			
			
			jw = detailpropertyjw(sigungu, bunji, danji, myunjuk, floor);
			
			System.out.println("getprofit의 jw"+jw);
			
			if (jw.isEmpty()== false) {
				if(jw.size()>1) {
					for (int i = 0; i < jw.size(); i++) {
						rentlist.add((double)jw.get(i).getRent());
						depositlist.add((double)typeChange(jw.get(i).getDeposit()));						
					}
					if(rentlist.isEmpty()==false) {
						Collections.sort(rentlist);
						rentres = rentlist.get(0);						
					}
					if(depositlist.isEmpty()==false) {
						Collections.sort(depositlist);
						depres = depositlist.get(0);						
					}
					
				}else {
					rentres =jw.get(0).getRent();
					depres = (double)typeChange(jw.get(0).getDeposit());
				}
				
			}
		
		
			result = Math.round((rentres*12/(nprice-depres))*10000);
			result = result/100;
			
		System.out.println("profit?"+result);
		return result;
	}
	
/*	public int getMaxRent0(String sigungu, String bunji, String danji, String myunjuk, String floor) {
		int res=0;
		List<AptVo> jw=null;
		jw=sortRent(sigungu, bunji, danji, myunjuk, floor);
		res=jw.get(0).getRent();
		
		return res;
	}*/
	
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

	
	public SuicInfoVo detailpropertysuic(String sigungu, String bunji, String danji, String myunjuk, String floor, String price) {
		System.out.println("detailpropertysuic넘어온값??"+sigungu+bunji+danji+myunjuk+floor+price);
		SuicInfoVo suicInfo = new SuicInfoVo();
		double maxRate;
		double minRate;
		
		double nprice ;
		nprice = typeChange(price);
		
		double maxRent = 0;
		double minRent = 0;
		double maxDeposit = 0; 
		double minDeposit=0;
		int maxPrice =0;
		int minPrice =0;
		int sumPrice=0;
		double avgPrice=0;
		
		
		List<AptVo> jw=null;
		List<AptVo> sil=null;
		List<Double> rentlist = new ArrayList<>();
		List<Double> depositlist = new ArrayList<>();
		List<Integer> pricelist = new ArrayList<>();
		
		
		jw = detailpropertyjwforRent(sigungu, bunji, danji, myunjuk, floor);
		sil= detailpropertysil(sigungu, bunji, danji, myunjuk, floor);
		
		System.out.println("getprofit의 jw"+jw);
		System.out.println("getprofit의 sil"+sil);
		
		if (jw.isEmpty()== false) {
			if(jw.size()>1) {
				for (int i = 0; i < jw.size(); i++) {
					rentlist.add((double)jw.get(i).getRent());
					System.out.println("1"+(double)jw.get(i).getRent());
					depositlist.add((double)typeChange(jw.get(i).getDeposit()));
					System.out.println("2"+(double)typeChange(jw.get(i).getDeposit()));
				}
				if(rentlist.isEmpty()==false) {
					Collections.sort(rentlist);
					maxRent = rentlist.get(0);
					System.out.println("3"+ rentlist.get(0));
					minRent = rentlist.get(jw.size()-1);
					System.out.println("4"+rentlist.get(jw.size()-1));
				}
				if(depositlist.isEmpty()==false) {
					Collections.sort(depositlist);
					maxDeposit = depositlist.get(0);
					System.out.println("5"+depositlist.get(0));
					minDeposit = depositlist.get(jw.size()-1);
					System.out.println("6"+depositlist.get(jw.size()-1));
				}
				
			}else {
				maxRent =jw.get(0).getRent();
				System.out.println("7"+jw.get(0).getRent());
				maxDeposit = (double)typeChange(jw.get(0).getDeposit());
				System.out.println("8"+(double)typeChange(jw.get(0).getDeposit()));
				minRent =jw.get(0).getRent();
				System.out.println("9"+jw.get(0).getRent());
				minDeposit = (double)typeChange(jw.get(0).getDeposit());
				System.out.println("10"+ (double)typeChange(jw.get(0).getDeposit()));
			}
			
		}
		

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
	
	
		maxRate = Math.round((maxRent*12/(nprice-maxDeposit))*10000);
		maxRate = maxRate/100;
		System.out.println("20"+maxRate);
		minRate = Math.round((minRent*12/(nprice-minDeposit))*10000);
		minRate = minRate/100;
		System.out.println("21"+minRate);
		
		try {
		suicInfo.setMaxPrice(maxPrice);
		suicInfo.setMinPrice(minPrice);
		suicInfo.setMaxRate(maxRate);
		suicInfo.setMinRate(minRate);
		suicInfo.setAvgPrice(avgPrice);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("suic인포"+suicInfo);
		
		return suicInfo;
	}
}
