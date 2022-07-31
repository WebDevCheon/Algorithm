package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기타리스트 {
	
	private static int n;
	private static int s;
	private static int m;
	private static int[] v;
	private static int[][] dp;
	
	private static int dfs(int idx,int sum) {	
		if(sum > m || sum < 0)
			return -1;
		
		if(idx == n)
			return sum;
		
		if(dp[idx][sum] > -2)
			return dp[idx][sum];
		
		return dp[idx][sum] = Math.max(dp[idx][sum],Math.max(dfs(idx + 1,sum + v[idx]),dfs(idx + 1,sum - v[idx])));
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		v = new int[n];
		dp = new int[n][m + 1];
		for(int[] arr : dp)
			Arrays.fill(arr,-2);
		for(int i = 0;i < n;i++)
			v[i] = Integer.parseInt(st.nextToken());
		System.out.println(dfs(0,s));
	}
}
