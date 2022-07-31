package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 1,2,3 더하기3 {
	
	private static long[] dp = new long[1000001];
	
	private static long recur(int n) {
		if(dp[n] != 0)
			return dp[n];
		long sum = 0;
		
		for(int i = 1;i <= 3;i++) {
			if(n < i)
				continue;
			sum += (recur(n - i) % 1000000009);
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());
		long[] dp = new long[1000001];
		dp[0] = 1;
		for(int i = 1;i <= 1000000;i++) {
			for(int j = 1;j <= 3;j++) {
				if(i < j)
					continue;
				dp[i] += (dp[i - j] % 1000000009);
			}
		}
		
		while(testcase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp[n] % 1000000009 + "\n");
		}
		bw.flush();
	}
}
