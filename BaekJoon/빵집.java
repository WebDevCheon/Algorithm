package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 빵집 {
	
	private static char[][] map;
	private static boolean[][] visited;
	private static int n;
	private static int m;
	private static int ans;
	private static int[] dx = {1,1,1};
	private static int[] dy = {-1,0,1};
	private static boolean isEnded;
	
	static class pos {
		int x;
		int y;
		public pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	private static void dfs(int y,int x) {
		if(x == m - 1) {
			ans++;
			isEnded = true;
			return;
		}
		visited[y][x] = true;
		
		for(int i = 0;i < dx.length;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isRange(ny,nx) || map[ny][nx] == 'x' || visited[ny][nx])
				continue;
			visited[ny][nx] = true;
			dfs(ny,nx);
			if(isEnded)
				return;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			for(int j = 0;j < m;j++)
				map[i][j] = str.charAt(j);
		}
		
		for(int i = 0;i < n;i++) {
			isEnded = false;
			dfs(i,0);
		}
		System.out.println(ans);
	}
}
