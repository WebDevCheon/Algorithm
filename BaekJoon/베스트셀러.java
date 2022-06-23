package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 베스트셀러 {		
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i = 0;i < n;i++) {
			String book = br.readLine();
			map.put(book,map.getOrDefault(book,0) + 1);
		}
		Set<String> keySet = map.keySet();
		Iterator<String> itr = keySet.iterator();
		int max = Integer.MIN_VALUE;
		String ans = "";
		
		while(itr.hasNext()) {
			String book = itr.next();
			int cnt = map.get(book);
			if(max < cnt) {
				max = cnt;
				ans = book;
			} else if(max == cnt) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(book);
				list.add(ans);
				Collections.sort(list);
				ans = list.remove(0);
			}
		}
		System.out.println(ans);
	}
}
