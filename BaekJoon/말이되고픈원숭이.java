package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이 {

	private static int[][] map;
	private static boolean[][][] visited;
	private static int n;
	private static int m;
	private static int k;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static int[] hx = {2,1,-1,-2,-2,-1,1,2};
	private static int[] hy = {1,2,2,1,-1,-2,-2,-1};
	private static int ans = Integer.MAX_VALUE;
	
	static class pos {
		int x;
		int y;
		int move;
		int cnt;
		
		public pos(int x,int y,int move,int cnt) {
			this.x = x;
			this.y = y;
			this.move = move;
			this.cnt = cnt;
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	private static void bfs() {
		Queue<pos> q = new LinkedList<pos>();
		visited[0][0][0] = true;
		q.add(new pos(0,0,0,0));
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			
			if(p.y == n - 1 && p.x == m - 1) {
				ans = p.move;
				break;
			}
			
			for(int i = 0;i < dx.length;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(!isRange(ny,nx) || map[ny][nx] == 1 || visited[ny][nx][p.cnt])
					continue;
				q.add(new pos(nx,ny,p.move + 1,p.cnt));
				visited[ny][nx][p.cnt] = true; 
			}
			
			if(p.cnt == k)
				continue;
			
			for(int i = 0;i < hx.length;i++) {
				int nx = p.x + hx[i];
				int ny = p.y + hy[i];
				
				if(!isRange(ny,nx) || map[ny][nx] == 1 || visited[ny][nx][p.cnt + 1])
					continue;
				q.add(new pos(nx,ny,p.move + 1,p.cnt + 1));
				visited[ny][nx][p.cnt + 1] = true;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m][31];
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < m;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		bfs();
		if(ans != Integer.MAX_VALUE)
			System.out.println(ans);
		else
			System.out.println(-1);
	}
}
