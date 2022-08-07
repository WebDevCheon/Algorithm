package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값 {
	
	private static boolean check(Stack<Character> stk,String str) {
		for(int i = 0;i < str.length();i++) {
			if(stk.isEmpty()) {
				char ch = str.charAt(i);
				if(ch == ')' || ch == ']')
					return false;
				stk.push(ch);
			} else {
				char ch = str.charAt(i);
				if(stk.peek() == '(' && ch == ']')
					return false;
				else if(stk.peek() == '[' && ch == ')')
					return false;
				else if(stk.peek() == '(' && ch == ')')
					stk.pop();
				else if(stk.peek() == '[' && ch == ']')
					stk.pop();
				else
					stk.push(ch);
			}
		}
		if(!stk.isEmpty())
			return false;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stk = new Stack<Character>();
		for(int i = 0;i < str.length();i++)
			stk.push(str.charAt(i));
		Stack<Character> backup = (Stack<Character>)stk.clone();
		stk = new Stack<Character>();
		
		if(!check(stk,str))
			System.out.println(0);
		else {
			stk = backup;
			int ans = 0;
			int value = 1;
			
			for(int i = 0;i < str.length();i++) {
				char ch = str.charAt(i);
				
				if(ch == '(')
					value *= 2;
				else if(ch == '[')
					value *= 3;
				else if(ch == ')') {
					if(str.charAt(i - 1) == '(')
						ans += value;
					value /= 2;
				} else if(ch == ']') {
					if(str.charAt(i - 1) == '[')
						ans += value;
					value /= 3;
				}
			}
			System.out.println(ans);
		}
	}
}
