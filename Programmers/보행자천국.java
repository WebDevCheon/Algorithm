package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보행자천국 {
	
	private static int MOD = 20170805;
	private static int[][][] dp;			
	private static int[][] map;
	private static boolean[][][] visited;
	private static int n;
	private static int m;
	private static int[] dx = {1, 0};
	private static int[] dy = {0, 1};
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	private static int dfs(int y,int x,int dir) {		
		if(y == n - 1 && x == m - 1)
			return 1;
		
		if(map[y][x] == 0) {
			if(visited[y][x][0])
				return dp[y][x][0];
			else if(visited[y][x][1])
				return dp[y][x][1];
			else
				visited[y][x][dir] = true;
		} else if(map[y][x] == 2) {
			if(!visited[y][x][dir])
				visited[y][x][dir] = true;
			else
				return dp[y][x][dir] % MOD;
		}
		
		if(map[y][x] == 0) {
			for(int i = 0;i < dx.length;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(!isRange(ny,nx) || map[ny][nx] == 1)
					continue;
				dp[y][x][dir] += (dfs(ny,nx,i) % MOD);
			}
		} else if(map[y][x] == 2) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(!isRange(ny,nx) || map[ny][nx] == 1)
				return 0;
			dp[y][x][dir] += (dfs(ny,nx,dir) % MOD);
		}
		return dp[y][x][dir] % MOD;
	}
	
	public static int solution(int row, int col, int[][] cityMap) {
		n = row;
		m = col;
		dp = new int[row][col][2];
		visited = new boolean[row][col][2];
		map = cityMap;
		dfs(0,0,0);
		return dp[0][0][0] % MOD;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] cityMap = new int[n][m];
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < m;j++)
				cityMap[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(n,m,cityMap));
	}
}
