package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 팰린드롬수 {		// 2분

	private static boolean check(String input) {
		int left = 0;
		int right = input.length() - 1;
		while(left <= right) {
			if(input.charAt(left) != input.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if(str.equals("0"))
				break;
			if(check(str))
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
