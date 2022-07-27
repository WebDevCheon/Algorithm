package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇 {

	private static char[][] map;
	private static int n;
	private static int m;
	private static int sy;
	private static int sx;
	private static int[] dir = new int[4];
	private static int[] dx = {0,0,0,-1,1};
	private static int[] dy = {0,-1,1,0,0};
	private static boolean[][] visited;
	private static int ansy;
	private static int ansx;
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	private static void dfs(int y,int x,int idx) {
		visited[y][x] = true;
		ansy = y;
		ansx = x;
		
		int nx = x;
		int ny = y;
		int cnt = 0;
		boolean escape = false;
		
		while(true) {
			if(++cnt == 5) {
				escape = true;
				break;
			}
			nx = x;
			ny = y;
			nx += dx[dir[idx]];
			ny += dy[dir[idx]];
			
			if(!isRange(ny,nx) || map[ny][nx] == 'x' || visited[ny][nx]) {
				idx = (++idx) % dir.length;
				continue;
			}
			break;
		}
		if(escape)
			return;
		dfs(ny,nx,idx);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		int k = Integer.parseInt(br.readLine());
		for(int i = 0;i < k;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 'x';
		}
		st = new StringTokenizer(br.readLine());
		sy = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < dir.length;i++)
			dir[i] = Integer.parseInt(st.nextToken());
		dfs(sy,sx,0);
		System.out.println(ansy + " " + ansx);
	}
}
