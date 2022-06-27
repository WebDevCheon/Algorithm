package Programmers;

import java.util.ArrayList;

public class 수식최대화 {
	
	private static char[] a = new char[3];
	private static boolean[] visited = new boolean[3];
	private static Long ans = Long.MIN_VALUE;
	private static ArrayList<Character> opList = new ArrayList<Character>();
	private static ArrayList<Long> numList = new ArrayList<Long>();
	
	private static void calculate(String exp) {			// 숫자와 연산자를 모두 넣어준다
		long sum = 0;
		ArrayList<Character> op = new ArrayList<Character>(opList);
		ArrayList<Long> num = new ArrayList<Long>(numList);
		
		while(num.size() > 1) {
			if(op.contains(a[0])) {
				int idx = op.indexOf(a[0]);
				long n1 = num.get(idx);
				long n2 = num.get(idx + 1);
				if(a[0] == '+')
					num.set(idx,n1 + n2);
				else if(a[0] == '-')
					num.set(idx,n1 - n2);
				else if(a[0] == '*')
					num.set(idx,n1 * n2);
				num.remove(idx + 1);
				op.remove(idx);
			} else if(op.contains(a[1])) {
				int idx = op.indexOf(a[1]);
				long n1 = num.get(idx);
				long n2 = num.get(idx + 1);
				if(a[1] == '+')
					num.set(idx,n1 + n2);
				else if(a[1] == '-')
					num.set(idx,n1 - n2);
				else if(a[1] == '*')
					num.set(idx,n1 * n2);
				num.remove(idx + 1);
				op.remove(idx);
			} else {
				int idx = op.indexOf(a[2]);
				long n1 = num.get(idx);
				long n2 = num.get(idx + 1);
				if(a[2] == '+')
					num.set(idx,n1 + n2);
				else if(a[2] == '-')
					num.set(idx,n1 - n2);
				else if(a[2] == '*')
					num.set(idx,n1 * n2);
				num.remove(idx + 1);
				op.remove(idx);
			}
		}
		sum = num.remove(0);
		ans = Math.max(Math.abs(sum),ans);
		return;
	}
	
	private static void dfs(int idx,String exp) {
		if(idx == 3) {
			calculate(exp);
			return;
		}
		
		for(int i = 0;i < 3;i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			if(i == 0)
				a[idx] = '+';
			else if(i == 1)
				a[idx] = '-';
			else
				a[idx] = '*';
			dfs(idx + 1,exp);
			visited[i] = false;
		}
	}
	
	private static void init(String exp) {
		String str = "";
		for(int i = 0;i < exp.length();i++) {
			if(exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*') {
				opList.add(exp.charAt(i));
				numList.add(Long.valueOf(str));
				str = "";
			} else
				str += exp.charAt(i);
		}
		numList.add(Long.valueOf(str));
	}
	
	public static long solution(String exp) {
		init(exp);
		dfs(0,exp);
		return ans;
	}
}
