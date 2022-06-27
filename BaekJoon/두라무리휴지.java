package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 두라무리휴지 {				

	private static boolean check(String str1,String str2,int len) {
		int[] alpha1 = new int[26];
		int[] alpha2 = new int[26];
		
		if(str1.charAt(0) != str2.charAt(0) || str1.charAt(str1.length() - 1) != str2.charAt(str2.length() - 1))
			return false;
		
		for(int i = 0;i < len;i++) {
			alpha1[str1.charAt(i) - 'a']++;
			alpha2[str2.charAt(i) - 'a']++;
		}
		
		for(int i = 0;i < alpha1.length;i++) {
			if(alpha1[i] != alpha2[i])
				return false;
		}
		
		Queue<Character> q1 = new LinkedList<Character>();
		Queue<Character> q2 = new LinkedList<Character>();
		
		for(int i = 0;i < len;i++) {
			if(str1.charAt(i) != 'a' && str1.charAt(i) != 'e' && str1.charAt(i) != 'i' && str1.charAt(i) != 'o' && str1.charAt(i) != 'u') {
				q1.add(str1.charAt(i));
			}
		}
		
		for(int i = 0;i < len;i++) {
			if(str2.charAt(i) != 'a' && str2.charAt(i) != 'e' && str2.charAt(i) != 'i' && str2.charAt(i) != 'o' && str2.charAt(i) != 'u') {
				q2.add(str2.charAt(i));
			}
		}
		
		String tmp1 = "";
		String tmp2 = "";
		while(!q1.isEmpty())
			tmp1 += q1.poll();
		while(!q2.isEmpty())
			tmp2 += q2.poll();
		
		if(!tmp1.equals(tmp2))
			return false;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String str1 = br.readLine();
		String str2 = br.readLine();
		if(check(str1,str2,len))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
