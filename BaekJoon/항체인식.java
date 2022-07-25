package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 항체인식 {

	private static int[][] before;
	private static int[][] after;
	private static boolean[][] visited;
	private static int n;
	private static int m;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	private static void dfs(int y,int x,int num,int startNum) {
		if(visited[y][x])
			return;
		visited[y][x] = true;
		before[y][x] = num;
		
		for(int i = 0;i < dx.length;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isRange(ny,nx) || before[ny][nx] != startNum)
				continue;
			dfs(ny,nx,num,startNum);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		before = new int[n][m];
		after = new int[n][m];
		visited = new boolean[n][m];
		boolean escape = false;
		
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < m;j++)
				before[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < m;j++)
				after[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				if(!visited[i][j] && before[i][j] != after[i][j]) {
					dfs(i,j,after[i][j],before[i][j]);
					escape = true;
					break;
				}
			}
			if(escape)
				break;
		}

		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				if(before[i][j] != after[i][j]) {
					System.out.println("NO");
					System.exit(0);
				}
			}
		}
		System.out.println("YES");
	}
}
