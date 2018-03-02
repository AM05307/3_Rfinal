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
	
	public List<PropertyVo> detailpropertysil(PropertyVo pv) {

		List<PropertyVo> res = null;
		res = propertyDao.detailpropertysil(pv, gettName(pv));
		return res;
	}
	
	public List<PropertyVo> detailpropertyjw(PropertyVo pv) {

		List<PropertyVo> res=null;
		res = rentDao.getJw(pv,gettName(pv));
		System.out.println("detailpropertyjw에서 찍어보는 res"+res);
		return res;
	}

	
	
	
	public List<PropertyVo> detailpropertyjwforRent(PropertyVo pv,String tName) {

		List<PropertyVo> res=null;
		res = rentDao.getJwforRent(pv,tName);
		System.out.println("detailpropertyjw에서 찍어보는 res"+res);
		return res;
	}


	public String getMaxDeposit(PropertyVo pv) {
		System.out.println("넘어온값??"+pv);
		String result = null;
		
		List<PropertyVo> jw=null;
		List<String> depositlist = new ArrayList<>();
		jw = rentDao.getMaxDeposit(pv,gettName(pv));
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
		
		public ProfitVo getprofit(PropertyVo pv) {
			ProfitVo suicvo = new ProfitVo();
			
			double nprice ;
				nprice = typeChange(pv.getPrice());
			double rent = 0;
			double deposit=0;
			double result=0;
			
			double maxprofit=0;
			double minprofit=0;
			double sumprofit=0;
			double avgprofit=0;
			
			List<Double> suic = new ArrayList<>();
			List<PropertyVo> jw=null;
					
			jw = detailpropertyjwforRent(pv,gettName(pv));
			
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
		
		return suicvo;
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

	
	public SuicInfoVo detailpropertysuic(PropertyVo pv) {
		
		SuicInfoVo suicInfo = new SuicInfoVo();
		ProfitVo suic = new ProfitVo();
		String maxDeposit = null;
		
		double nprice ;
		nprice = typeChange(pv.getPrice());
		
		int maxPrice =0;
		int minPrice =0;
		int sumPrice=0;
		double avgPrice=0;
				
		List<PropertyVo> jw=null;
		List<PropertyVo> sil=null;
	
		List<Integer> pricelist = new ArrayList<>();
		
		sil= detailpropertysil(pv);
		
		System.out.println("getprofit의 jw"+jw);
		System.out.println("getprofit의 sil"+sil);
		
		if (sil.isEmpty()== false) {
			if(sil.size()>1) {
				for (int i = 0; i < sil.size(); i++) {
					pricelist.add(typeChange(sil.get(i).getPrice()));
					sumPrice = sumPrice +typeChange(sil.get(i).getPrice());
				}
				
				if(pricelist.isEmpty()==false) {
					Collections.sort(pricelist);
					maxPrice = pricelist.get(0);
					minPrice = pricelist.get(sil.size()-1);
				}
				avgPrice = sumPrice/sil.size();
			}else {
				maxPrice = typeChange(sil.get(0).getPrice());
				minPrice = typeChange(sil.get(0).getPrice());
				sumPrice = sumPrice +typeChange(sil.get(0).getPrice());
				avgPrice = sumPrice/1;			
			}
			
		}
		
		suic = getprofit(pv);
		maxDeposit = getMaxDeposit(pv);
		
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
	
	public String gettName(PropertyVo vo) {
		String tName=null;
		
		if(String.valueOf(vo.getC_type()).equals("아파트")){
			tName = "apt";
		}else if(String.valueOf(vo.getC_type()).equals("오피스텔")){
			tName = "offi";
			
		}else if(String.valueOf(vo.getC_type()).equals("연립다세대")){
			tName = "yeun_da";
		}
		
		return tName; 
	}

	public List<PropertyVo> userAt_list(PropertyVo pv) {
		System.out.println("서비스객체 listApt() 메소드");
		List<PropertyVo> res = null;
		System.out.println(pv+gettName(pv));
		res = propertyDao.userAt_list(pv,gettName(pv));
		return res;
	}
}
