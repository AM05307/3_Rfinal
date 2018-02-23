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

	public List<AptVo> detailproperty(String sigungu, String bunji, String danji, String myunjuk, String floor) {

		List<AptVo> res = null;
		res = propertyDao.detailproperty(sigungu, bunji, danji, myunjuk, floor);
		return res;
	}
	
	public List<AptVo> rentInfo(String sigungu, String bunji, String danji, String myunjuk, String floor) {

		List<AptVo> res=null;
		res = rentDao.getJw(sigungu, bunji, danji, myunjuk, floor);
		System.out.println("info에서 찍어보는 res"+res);
		return res;
	}




	public int getMaxRent(String sigungu, String bunji, String danji, String myunjuk, String floor) {
		System.out.println("넘어온값??"+sigungu+bunji+danji+myunjuk+floor);
		int res = 0;
		
		List<AptVo> jw=null;
		List<Integer> rentlist = new ArrayList<>();
		jw = rentInfo(sigungu, bunji, danji, myunjuk, floor);
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
			
			
			jw = rentInfo(sigungu, bunji, danji, myunjuk, floor);
			
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
	
	public int depositofMaxRent(String sigungu, String bunji, String danji, String myunjuk, String floor, int rent) {
		int res=0;
		
		
		
		
		
		return res;
	}

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
}
