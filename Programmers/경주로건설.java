package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경주로건설 {
	
	private static int ans = Integer.MAX_VALUE;
	private static int[][] map;
	private static int n;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static boolean[][] visited;
	private static int[][] dp;
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
	
	private static void dfs(int y,int x,int dir,int price) {
		if(dp[y][x] < price)
			return;
		
		visited[y][x] = true;

		if(y == n - 1 && x == n - 1) {
			ans = Math.min(price,ans);
			return;
		}
		
		for(int i = 0;i < dx.length;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!isRange(ny,nx) || map[ny][nx] == 1)
				continue;
			if(dir != -1 && dir != i && !visited[ny][nx]) {
				dfs(ny,nx,i,price + 600);
				visited[ny][nx] = false;
			} else if(dir == i && !visited[ny][nx]) {
				dfs(ny,nx,i,price + 100);
				visited[ny][nx] = false;
			} else if(dir == -1) {
				dfs(ny,nx,i,price + 100);
				visited[ny][nx] = false;
			}
		}
		dp[y][x] = Math.min(dp[y][x],price);
	}
	
	public static int solution(int[][] board) {
		map = board;
		n = map.length;
		visited = new boolean[n][n];
		dp = new int[n][n];
		for(int i = 0;i < n;i++)
			for(int j = 0;j < n;j++)
				dp[i][j] = Integer.MAX_VALUE;
		dfs(0,0,-1,0);
		return ans;
    }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j < n;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(board));
	}
}
