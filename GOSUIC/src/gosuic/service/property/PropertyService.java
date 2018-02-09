package gosuic.service.property;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gosuic.dao.property.PropertyDao;
import gosuic.entity.AptInfo;

@Service
public class PropertyService {

	@Autowired
	private PropertyDao propertyDao;

	// 매물 목록 출력
	public List<AptInfo> listApt() {
		System.out.println("서비스객체 listApt() 메소드");
		List<AptInfo> res = null;
		res = propertyDao.listApt();
		return res;
	}

}
