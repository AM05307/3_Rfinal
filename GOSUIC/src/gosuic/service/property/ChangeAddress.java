package gosuic.service.property;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Service
public class ChangeAddress {

	public List<Double>  geocodeMain(String addr, String addr2) throws SAXException, IOException, ParserConfigurationException {
		List<Double> geocode = new ArrayList<Double>();
		geocode=geocode(addr);
		
		if (geocode.isEmpty()) {
			geocode=geocode(addr2);
		}
		
		return geocode;
		
	}
	
	public List<Double> geocode(String addr) throws SAXException, IOException, ParserConfigurationException {
		System.out.println("ChangeAddress클래스");
		System.out.println("넘어온 addr"+addr);
		List<Double> geocode = new ArrayList<Double>();
		
		String myQuery = URLEncoder.encode(addr, "UTF-8");
		String xml = "https://maps.googleapis.com/maps/api/geocode/xml?key=AIzaSyBVeJgwJ7WIQrwvBk2FW9bcxPHD473XimM&address="
				+ myQuery;

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xml);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("location");
			System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					//System.out.println("lat : " + getTagValue("lat", eElement));
					//System.out.println("lng : " + getTagValue("lng", eElement));
					
					geocode.add(Double.valueOf(getTagValue("lat", eElement)));
					geocode.add(Double.valueOf(getTagValue("lng", eElement)));
					System.out.println(geocode.get(0));
					System.out.println(geocode.get(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return geocode;
	}

	
	
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}

}
