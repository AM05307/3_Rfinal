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

	//매물 목록 출력
	public List<AptInfo> listApt(){
		return propertyDao.listApt();
	}

}
