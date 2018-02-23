package view;

import java.util.ArrayList;
import java.util.List;

public class test01 {

	public static void main(String[] args) {
		String str = "12,540";
		String[] res = str.split(",");
		List<String> al = new ArrayList<>(); 
		
		for(String r : res) {
			al.add(r);
		}
		
		String str2=al.get(0)+al.get(1);
		int a= Integer.parseInt(str2);
		System.out.println(a);

	}

}
