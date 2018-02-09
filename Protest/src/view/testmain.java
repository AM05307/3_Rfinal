package view;

import java.util.List;

import dao.AptDaoImpl;
import entity.SimVo;

public class testmain {

	public static void main(String[] args) {
		AptDaoImpl adi2 = new AptDaoImpl();
	
		List<SimVo> rs = adi2.select();
		for(SimVo sv : rs) {
			//System.out.println(sv);
			System.out.println(String.valueOf(sv));
		}

	}

}
