package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class k진수에서소수구하기 {

	private static boolean isPrime(long n) {
		if(n == 1)
			return false;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
	public static long solution(int n,int k) {
		List<Long> list = new ArrayList<Long>();
		Stack<Long> stk = new Stack<Long>();
		long ans = 0;
		while(n > 0) {
			stk.push((long)n % k);
			n /= k;
		}
		String str = "";
		while(!stk.isEmpty())
			str += stk.pop();
		str = str.replace("0",".");
		String tmp = "";
		for(int i = 0;i < str.length();i++) {
			if(str.charAt(i) == '.' && tmp.length() > 0) {
				list.add(Long.valueOf(tmp));
				tmp = "";
			} else if(str.charAt(i) != '.')
				tmp += str.charAt(i);
		}
		if(tmp.length() > 0)
			list.add(Long.valueOf(tmp));
		for(int i = 0;i < list.size();i++) {
			if(isPrime(list.get(i)))
				ans++;
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(solution(1000000,2));
	}
}
