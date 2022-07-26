package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 홀수홀릭호석 {
	
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;
	private static String str;
	
	private static void dfs(String str,int odd) {
		if(str.length() == 1) {
			min = Math.min(odd,min);
			max = Math.max(odd,max);
			return;
		} else if(str.length() == 2) {
			int n = Integer.valueOf(String.valueOf(str.charAt(0))) + Integer.valueOf(String.valueOf(str.charAt(1)));
			String newStr = String.valueOf(n);
			for(int i = 0;i < newStr.length();i++) {
				if(Integer.valueOf(String.valueOf(newStr.charAt(i))) % 2 != 0)
					odd++;
			}
			dfs(String.valueOf(n),odd);
		} else { 
			for(int i = 0;i < str.length();i++) {
				for(int j = i + 1;j < str.length();j++) {
					for(int k = j + 1;k < str.length();k++) {
						String s1 = str.substring(0,j);
						String s2 = str.substring(j,k);
						String s3 = str.substring(k);
						int n1 = Integer.valueOf(s1);
						int n2 = Integer.valueOf(s2);
						int n3 = Integer.valueOf(s3);
						int tmpOdd = odd;
						
						String newStr = String.valueOf(n1 + n2 + n3);
						for(int a = 0;a < newStr.length();a++) {
							int num = Integer.valueOf(String.valueOf(newStr.charAt(a)));
							if(num % 2 != 0 && num != 0)
								tmpOdd++;
						}
						dfs(newStr,tmpOdd);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		int odd = 0;
		for(int i = 0;i < str.length();i++) {
			if(Integer.valueOf(String.valueOf(str.charAt(i))) % 2 != 0)
				odd++;
		}
		dfs(str,odd);
		System.out.println(min + " " + max);
	}
}
