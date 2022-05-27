package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 가장큰정사각형찾기 {
	
	public static void main(String[] args) throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("12");
		list.add("10");
		list.add("02");
		list.add("1");
		list.add("01");
		list.add("2");
		Collections.sort(list,new Comparator<String>() {
			public int compare(String i1,String i2) {
				if(Integer.valueOf(i1) > Integer.valueOf(i2))
					return 1;
				else if(Integer.valueOf(i1) < Integer.valueOf(i2))
					return -1;
				else
					return 0;
			}
		});
		for(int i = 0;i < list.size();i++)
			System.out.print(list.get(i) + " ");
	}
}
