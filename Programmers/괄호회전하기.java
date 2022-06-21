package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호회전하기 {

	private static boolean isRight(String s) {
		Stack<Character> stk = new Stack<Character>();
		
		for(int i = 0;i < s.length();i++) {
			char ch = s.charAt(i);
			if(!stk.isEmpty()) {
				if(stk.peek() == '{' && ch == '}') {
					stk.pop();
				} else if(stk.peek() == '[' && ch == ']') {
					stk.pop();
				} else if(stk.peek() == '(' && ch == ')') {
					stk.pop();
				} else
					stk.push(ch);
			} else
				stk.push(ch);
		}
		return (stk.isEmpty()) ? true : false;
	}
	
	public static int solution(String s) {
		int ans = 0;
		StringBuilder sb = new StringBuilder(s);
		if(isRight(sb.toString()))
			ans++;
		
		for(int i = 1;i <= s.length() - 1;i++) {
			sb.append(sb.charAt(0));
			sb.deleteCharAt(0);
			if(isRight(sb.toString()))
				ans++;
		}
		return ans;
    }
}
