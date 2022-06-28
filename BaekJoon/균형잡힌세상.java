package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class 균형잡힌세상 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		
		while(!(str = br.readLine()).equals(".")) {
			Stack<Character> stk = new Stack<Character>();
			boolean isFinished = false;
			
			for(int i = 0;i < str.length();i++) {
				if(str.charAt(i) == '[' || str.charAt(i) == '(')
					stk.push(str.charAt(i));
				else if(str.charAt(i) == ']') {
					if(stk.isEmpty()) {
						isFinished = true;
						break;
					} else {
						if(stk.peek() == '[')
							stk.pop();
						else {
							isFinished = true;
							break;
						}
					}
				} else if(str.charAt(i) == ')') {
					if(stk.isEmpty()) {
						isFinished = true;
						break;
					} else {
						if(stk.peek() == '(')
							stk.pop();
						else {
							isFinished = true;
							break;
						}
					}
				}
			}
			
			if(!stk.isEmpty() || isFinished)	
				bw.write("no\n");
			else if(!isFinished)
				bw.write("yes\n");
		}
		bw.flush();
	}
}
