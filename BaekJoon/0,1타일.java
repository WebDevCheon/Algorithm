package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 공1타일 {

	private static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		dp[0] = 1;
		
		for(int i = 1;i <= n;i++) {
			if(i >= 2)
				dp[i] += (dp[i - 2] % 15746);
			dp[i] += (dp[i - 1] % 15746);
		}
		System.out.println(dp[n] % 15746);
	}
}
