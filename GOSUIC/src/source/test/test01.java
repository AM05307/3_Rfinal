package source.test;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class test01 {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		  String myQuery = URLEncoder.encode("서울 마포구 창전동", "UTF-8");
		  //String addr ="서울 마포구 창전동";
		  String xml = "https://maps.googleapis.com/maps/api/geocode/xml?key=AIzaSyBVeJgwJ7WIQrwvBk2FW9bcxPHD473XimM&address=" + myQuery ;
		  
		/*  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		  DocumentBuilder builder = factory.newDocumentBuilder();
		  Document document = builder.parse(xml);
		  
		  NodeList nList = document.getElementsByTagName("result");
		  //System.out.println(nList);
		  Node node = nList.item(0);
		  //if(node.getNodeName().equals("location"))
			  System.out.println(node.getNodeName());
			  System.out.println("test"+node.getChildNodes());
		 // System.out.println(nList);
		  //Element elem = (Element) nList.item(0);
		 // System.out.println(elem);
		  //System.out.println(elem.getElementsByTagName("lng").item(0).getTextContent());
		 // System.out.println(elem.getElementsByTagName("lat").item(0).getTextContent()+" "+elem.getElementsByTagName("lng").item(0).getTextContent());
		 }
	*/
		   try {
			   
			   //File fXmlFile = new File("c:\\file.xml");
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
			         System.out.println("lat : " + getTagValue("lat", eElement));
			         System.out.println("lng : " + getTagValue("lng", eElement));
			        // System.out.println("Nick Name : " + getTagValue("nickname", eElement));
			         //System.out.println("Salary : " + getTagValue("salary", eElement));
			  
			         List<Double> li = new ArrayList<Double>();
			         li.add(Double.valueOf(getTagValue("lat", eElement)));
			         li.add(Double.valueOf(getTagValue("lng", eElement)));
			         System.out.println(li.get(1));
			         System.out.println(li.get(0));
			      }
			   }
			    } catch (Exception e) {
			   e.printStackTrace();
			    }
			   }
			  
			   private static String getTagValue(String sTag, Element eElement) {
			  NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
			  
			         Node nValue = (Node) nlList.item(0);
			  
			  return nValue.getNodeValue();
			   }
	
}
