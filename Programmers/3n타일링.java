package Programmers;

public class 3n타일링 {

	public long solution(int n) {
        if(n % 2 == 1)
            return 0;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        for(int i = 2;i <= n;i += 2) {
        	for(int j = i - 2;j >= 0;j-=2) {
        		if(j == i - 2)
        			dp[i] += (dp[j] * 3 % 1000000007); 
        		else if(j == 0)
        			dp[i] += 2;
        		else
        			dp[i] += (dp[j] * 2 % 1000000007);
        	}
        }
        return dp[n] % 1000000007;
    }
}
