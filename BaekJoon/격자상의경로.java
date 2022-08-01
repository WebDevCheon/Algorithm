package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 격자상의경로 {			

	private static int[][] dp;
	private static int n;
	private static int m;
	private static int[] dx = {1,0};
	private static int[] dy = {0,1};
	private static int ty = -1;
	private static int tx = -1;
	
	private static boolean isRange_before(int y,int x) {
		return (x >= 0 && x <= tx && y >= 0 && y <= ty);
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	private static int dp_before(int y,int x,int ty,int tx) {
		if(ty == y && tx == x)
			return 1;
		
		if(dp[y][x] > 0)
			return dp[y][x];
		
		int sum = 0;
		
		for(int i = 0;i < dx.length;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!isRange_before(ny,nx))
				continue;
			sum += dp_before(ny,nx,ty,tx);
		}
		return dp[y][x] = sum;
	}
	
	private static int dp(int y,int x,int ty,int tx) {
		if(ty == y && tx == x)
			return 1;
		
		if(dp[y][x] > 0)
			return dp[y][x];
		
		int sum = 0;
		
		for(int i = 0;i < dx.length;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!isRange(ny,nx))
				continue;
			sum += dp(ny,nx,ty,tx);
		}
		return dp[y][x] = sum;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dp = new int[n][m];
		int k = Integer.parseInt(st.nextToken()) - 1;
		if(k != -1) {
			ty = k / m;
			tx = k % m;
			int sumA = dp_before(0,0,ty,tx);
			dp = new int[n][m];
			int sumB = dp(ty,tx,n - 1,m - 1);
			System.out.println(sumA * sumB);
		} else {
			ty = n - 1;
			tx = m - 1;
			System.out.println(dp(0,0,ty,tx));
		}
	}
}
