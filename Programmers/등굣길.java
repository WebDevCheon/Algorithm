package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 등굣길 {			
	
	private static int[][] dp;
	private static int[][] map;
	private static int n;
	private static int m;
	private static int[] dx = {1,0};
	private static int[] dy = {0,1};
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	private static int getDp(int y,int x) {
		if(dp[y][x] > 0)
			return dp[y][x];
		
		if(y == n - 1 && x == m - 1)
			return 1;
		
		for(int i = 0;i < dx.length;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!isRange(ny,nx) || map[ny][nx] == 1)
				continue;
			dp[y][x] += getDp(ny,nx) % 1000000007;
		}
		return dp[y][x] % 1000000007;
	}
	
	public static int solution(int minput,int ninput,int[][] puddles) {
		n = ninput;
		m = minput;
		map = new int[n][m];
		dp = new int[n][m];
		int sx = 0;
		int sy = 0;
		for(int i = 0;i < puddles.length;i++) {
			int x = puddles[i][0] - 1;
			int y = puddles[i][1] - 1;
			map[y][x] = 1;
		}
		int ans = getDp(sy,sx);
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] puddles = new int[1][2];
		puddles[0][0] = 2;
		puddles[0][1] = 2;
		System.out.println(solution(4,3,puddles));
	}
}
