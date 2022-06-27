package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class 문자열압축 {

	public static int solution(String s) {		
		ArrayList<Integer> ansList = new ArrayList<Integer>();
		
		for(int size = 1;size < s.length();size++) {
			ArrayList<String> strList = new ArrayList<String>();
			
			for(int i = 0;i < s.length();i += size) {
				String str = "";
				for(int j = i;j < i + size;j++) {
					if(j == s.length())
						break;
					str += s.charAt(j);
				}
				strList.add(str);
			}
			
			String tmp = "";
			for(int i = 0;i < strList.size();i++) {
				String str = strList.get(i);
				int cnt = 1;
				
				for(int j = i + 1;j < strList.size();j++) {
					if(strList.get(i).equals(strList.get(j)))
						cnt++;
					else
						break;
				}
				if(cnt > 1) {			
					tmp += cnt;
					tmp += str;
					i += (cnt - 1);
				} else
					tmp += str;
			}
			ansList.add(tmp.length());
		}
		Collections.sort(ansList);
		return ansList.get(0);
	}
}