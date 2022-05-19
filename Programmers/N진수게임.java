package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N진수게임 {

	public static String solution(int n,int t,int m,int p) {
		List<String> list = new ArrayList<String>();
		list.add("0");
		int num = 1;
		
		while(true) {
			Stack<String> stk = new Stack<String>();
			int tmp = num;
			while(tmp > 0) {
				if(tmp % n >= 10)
					stk.push(String.valueOf((char)(55 + tmp % n)));
				else
					stk.push(String.valueOf(tmp % n));
				tmp /= n;
			}
			while(!stk.isEmpty()) {
				String input = stk.pop();
				list.add(input);
			}
			num++;
			if(list.size() >= t * m)
				break;
		}
		List<String> anslist = new ArrayList<String>();
		for(int i = 0;i < list.size();i++) {
			int pidx = i % m;
			pidx++;
			if(pidx == p) {
				anslist.add(list.get(i));
			}
		}
		String ans = "";
		for(int i = 0;i < anslist.size();i++) {
			ans += anslist.get(i);
			if(ans.length() == t)
				break;
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(solution(16,16,2,2));
	}
}
