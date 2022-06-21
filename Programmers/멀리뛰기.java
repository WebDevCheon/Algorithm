package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 멀리뛰기 {
	
    private static int MOD = 1234567;
    private static int[] dp;
	
    public static long solution(int n) {
    	if(n == 1)
    		return 1;
    	dp = new int[n + 1];
    	dp[1] = 1;
    	dp[2] = 2;
    	for(int i = 3;i <= n;i++)
    		dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
    	return dp[n] % MOD;
    }
}
