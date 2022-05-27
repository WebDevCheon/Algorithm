package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 가장큰수 {
	
	private static ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++) 
			list.add(st.nextToken());
		Collections.sort(list,new Comparator<String>() {
			public int compare(String s1,String s2) {
				if(Integer.valueOf(s1 + s2) > Integer.valueOf(s2 + s1))
					return -1;
				else if(Integer.valueOf(s1 + s2) < Integer.valueOf(s2 + s1))
					return 1;
				else
					return 0;
			}
		});
		String ans = "";
		for(int i = 0;i < list.size();i++)
			ans += list.get(i);
		
	}
}
