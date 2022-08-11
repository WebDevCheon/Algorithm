package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LCS {
	
	private static int[][] ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String e = br.readLine();
		char[] sch = new char[s.length() + 1];
		char[] ech = new char[e.length() + 1];
		for(int i = 1;i < s.length() + 1;i++)
			sch[i] = s.charAt(i - 1);
		for(int i = 1;i < e.length() + 1;i++)
			ech[i] = e.charAt(i - 1);
		ans = new int[s.length() + 1][e.length() + 1];
		
		for(int i = 1;i <= s.length();i++) {
			for(int j = 1;j <= e.length();j++) {
				if(s.charAt(i - 1) == e.charAt(j - 1))
					ans[i][j] = ans[i - 1][j - 1] + 1;
				else
					ans[i][j] = Math.max(ans[i - 1][j],ans[i][j - 1]);
			}
		}
		System.out.println(ans[s.length()][e.length()]);
	}
}
