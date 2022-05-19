package Programmers;

import java.util.Stack;

public class 괄호변환 {
	
	private static boolean isCorrect(String s) {
		Stack<Character> stk = new Stack<Character>();
		for(int i = 0;i < s.length();i++) {
			if(s.charAt(i) == '(')
				stk.push(s.charAt(i));
			else if(s.charAt(i) == ')' && stk.isEmpty())
				return false;
			else
				stk.pop();
		}
		return true;
	}
	
	public static String solution(String s) {			// 올바른 문자열을 반환해주는 메소드
		if(s.length() == 0)
			return s;
		StringBuilder sb = new StringBuilder(s);
		int a = 0;
		int b = 0;
		int index = -1;
		
		for(int i = 0;i < sb.length();i++) {
			if(sb.charAt(i) == '(')
				a++;
			else
				b++;
			if(a == b) {
				index = i;
				break;
			}
		}
		
		String u = sb.substring(0,index + 1);
		String v = sb.substring(index + 1);
		if(isCorrect(u))
			return u + solution(v);
		String ans = "";
		ans += "(";
		ans += solution(v);
		ans += ")";
		StringBuilder usb = new StringBuilder(u);
		usb = usb.deleteCharAt(0);
		usb = usb.deleteCharAt(usb.length() - 1);
		for(int i = 0;i < usb.length();i++) {
			if(usb.charAt(i) == '(')
				usb.setCharAt(i,')');
			else
				usb.setCharAt(i,'(');
		}
		String newU = usb.toString();
		ans += newU;
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(solution("()))((()"));
	}
}
