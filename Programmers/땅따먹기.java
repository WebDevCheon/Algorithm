package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 땅따먹기 {
	private static int[][] dp;				// dp[i][j] : i행 j열일때,최대합
	
	private static void init(int[][] land) {
		for(int i = 0;i < land[0].length;i++)
			dp[0][i] = land[0][i];
	}
	
	public static int solution(int[][] land) {
		init(land);
		int row = land.length;
		int col = land[0].length;
		
		for(int i = 1;i < row;i++) {
			for(int j = 0;j < col;j++) {
				if(j == 0) {
					int max = Integer.MIN_VALUE;
					for(int k = 1;k < col;k++)
						max = Math.max(max,dp[i-1][k]);
					dp[i][j] = max + land[i][j];
				}
				else if(j == col - 1) {
					int max = Integer.MIN_VALUE;
					for(int k = 0;k < col - 1;k++)
						max = Math.max(max,dp[i-1][k]);
					dp[i][j] = max + land[i][j];
				}
				else {
					int max = Integer.MIN_VALUE;
					for(int k = 0; k < col;k++) {
						if(k != j)
							max = Math.max(max,dp[i-1][k]);
					}
					dp[i][j] = max + land[i][j];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0;i < col;i++)
			max = Math.max(max,dp[row-1][i]);
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n][4];
		int[][] land = new int[n][4];
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j < 4;j++)
				land[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(land));
	}
}
