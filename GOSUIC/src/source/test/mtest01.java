package source.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import gosuic.service.property.ChangeAddress;



public class mtest01 {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		ChangeAddress ca = new ChangeAddress();
		List<Double> list = new ArrayList<Double>();
		
		list=ca.geocode("서울특별시 서초구 서초동 1337-3");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		double a=1;
		double b=3;
		double c = a/b;
		System.out.println(c);
	}

}
