package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 124나라 {
	
	public static String solution(int n) {
		Stack<Integer> stk = new Stack<Integer>();
		String ans = "";
		
		while(n > 0) {
			int num = n % 3;
			if(num == 0) {
				n /= 3;
				n--;
				stk.push(4);
			} else {
				n /= 3;
				stk.push(num);
			}
		}
		while(!stk.isEmpty())
			ans += stk.pop();
		return ans;
    	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(solution(n));
	}
}
