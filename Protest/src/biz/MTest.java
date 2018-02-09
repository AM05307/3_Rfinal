package biz;

import java.util.ArrayList;
import java.util.List;

public class MTest {
public static void main(String[] args) {
	List<String> list = new ArrayList<>();
	
	list.add("kim");
	list.add("lee");
	
	if (list.size()!=3) {
		list.add("kang");
	}
	System.out.println(list.toString());
	
}
}
