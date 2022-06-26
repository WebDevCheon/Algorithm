package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueens {
	
	private static int n;
	private static int[] a;	
	private static int ans;
	
	private static boolean check(int now) {
		for(int i = 0;i < now;i++) {
			if(a[i] == a[now])
				return false;
			else if(Math.abs(a[i] - a[now]) == Math.abs(i - now))
				return false;
		}
		return true;
	}
	
	private static void dfs(int idx) {
		if(idx == n) {
			ans++;
			return;
		}
		
		for(int i = 0;i < n;i++) {
			if(idx == 0) {
				a[idx] = i;
				dfs(idx + 1);
			} else {
				a[idx] = i;
				if(!check(idx))
					continue;
				dfs(idx + 1);
			}
		}
	}
	
	public static int solution(int input) {
		n = input;
		a = new int[n];
		dfs(0);
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		dfs(0);
		
	}
}
