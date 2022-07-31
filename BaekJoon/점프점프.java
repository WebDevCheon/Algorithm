package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 점프점프 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
		for(int i = 1;i < n + 1;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.fill(dp,1000000000);
		dp[1] = 0;
		for(int i = 1;i <= n;i++) {
			for(int j = 1;j <= arr[i];j++) {
				if(i + j > n)
					break;
				dp[i + j] = Math.min((dp[i] + 1),dp[i + j]);
			}
		}
		if(dp[n] == 1000000000)
			System.out.println(-1);
		else
			System.out.println(dp[n]);
	}
}
