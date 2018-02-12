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

	// �Ź� ��� ���
	public List<AptInfo> listApt(String addr) {
		System.out.println("���񽺰�ü listApt() �޼ҵ�");
		List<AptInfo> res = null;
		res = propertyDao.listApt(addr);
		return res;
	}

	public List<AptInfo> detailproperty(String sigungu,String bunji,String danji, String myunjuk) {
		
		List<AptInfo> res = null;
		res = propertyDao.detailproperty(sigungu,bunji,danji,myunjuk);
		return res;
	}

}
