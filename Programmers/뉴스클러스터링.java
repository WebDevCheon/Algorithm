package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 뉴스클러스터링 {
	private static ArrayList<String> list1 = new ArrayList<String>();
	private static ArrayList<String> list2 = new ArrayList<String>();
	private static HashMap<String,Integer> strCnt1 = new HashMap<String,Integer>();
	private static HashMap<String,Integer> strCnt2 = new HashMap<String,Integer>();
	
	private static boolean isBigAlpha(char ch) {
		if(ch >= 65 && ch <= 90)
			return true;
		return false;
	}
	
	private static boolean isSmallAlpha(char ch) {
		if(ch >= 97 && ch <= 122)
			return true;
		return false;
	}
	
	private static void listInit(String str1,String str2) {
		for(int i = 0;i < str1.length() - 1;i++) {
			String str = "";
			char ch1 = str1.charAt(i);
			char ch2 = str1.charAt(i + 1);
			if(!(isBigAlpha(ch1) || isSmallAlpha(ch1)) || !(isBigAlpha(ch2) || isSmallAlpha(ch2)))
				continue;
			if(isBigAlpha(ch1))
				ch1 += 32;
			if(isBigAlpha(ch2))
				ch2 += 32;
			str += String.valueOf(ch1) + String.valueOf(ch2);
			if(strCnt1.get(str) == null)
				strCnt1.put(str,1);
			else
				strCnt1.replace(str,strCnt1.get(str) + 1);
			list1.add(str);
		}
		
		for(int i = 0;i < str2.length() - 1;i++) {
			String str = "";
			char ch1 = str2.charAt(i);
			char ch2 = str2.charAt(i + 1);
			if(!(isBigAlpha(ch1) || isSmallAlpha(ch1)) || !(isBigAlpha(ch2) || isSmallAlpha(ch2)))
				continue;
			if(isBigAlpha(ch1))
				ch1 += 32;
			if(isBigAlpha(ch2))
				ch2 += 32;
			str += String.valueOf(ch1) + String.valueOf(ch2);
			if(strCnt2.get(str) == null)
				strCnt2.put(str,1);
			else
				strCnt2.replace(str,strCnt2.get(str) + 1);
			list2.add(str);
		}
	}
	
	public static int solution(String str1,String str2) {
		listInit(str1,str2);
		/*
		for(int i = 0;i < list1.size();i++)
			System.out.print(list1.get(i) + " ");
		System.exit(0);
		for(int i = 0;i < list2.size();i++)
			System.out.print(list2.get(i) + " ");
		System.exit(0);
		*/
		List<String> a = new ArrayList<String>();		// 교집합
		List<String> b = new ArrayList<String>();		// 합집합
		
		HashMap<String,Boolean> visited = new HashMap<String,Boolean>();

		for(int i = 0;i < list1.size();i++) {
			if(visited.get(list1.get(i)) != null)
				continue;
			for(int j = 0;j < list2.size();j++) {
				if(list1.get(i).equals(list2.get(j))) {
					int minCnt = (strCnt1.get(list1.get(i)) >= strCnt2.get(list2.get(j))) ? strCnt2.get(list2.get(j)) : strCnt1.get(list1.get(i));
					visited.put(list1.get(i),true);
					for(int k = 0;k < minCnt;k++)
						a.add(list1.get(i));
					break;
				}
			}
		}
		/*
		for(int i = 0;i < a.size();i++)
			System.out.print(a.get(i) + " ");
		System.exit(0);
		*/
		visited = new HashMap<String,Boolean>();
		
		for(int i = 0;i < list1.size();i++) {
			if(visited.get(list1.get(i)) != null)
				continue;
			boolean flag = false;
			for(int j = 0;j < list2.size();j++) {
				if(list1.get(i).equals(list2.get(j))) {
					int maxCnt = (strCnt1.get(list1.get(i)) >= strCnt2.get(list2.get(j))) ? strCnt1.get(list1.get(i)) : strCnt2.get(list2.get(j));
					for(int k = 0;k < maxCnt;k++)
						b.add(list1.get(i));
					visited.put(list1.get(i),true);
					flag = true;
					break;
				}
			}
			if(!flag)
				b.add(list1.get(i));			// 한개만 넣어주기
		}
		
		for(int i = 0;i < list2.size();i++) {
			if(visited.get(list2.get(i)) == null)
				b.add(list2.get(i));
		}
		if(a.size() == 0 && b.size() == 0)
			return 65536;
		double jakar = a.size() / (double)b.size();
		jakar = 65536 * jakar;
		int ans = (int)jakar;
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str1 = st.nextToken(); String str2 = st.nextToken() + " " + st.nextToken();
		int ans = solution(str1,str2);
		System.out.println(ans);
	}
}
