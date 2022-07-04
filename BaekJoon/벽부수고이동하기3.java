package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기3 {			
	
	private static char[][] map;
	private static boolean[][][][] visited;		
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static int n;
	private static int m;
	private static int k;
	private static int ans = -1;
	
	static class pos {
		int x;
		int y;
		int dist;
		int wall;
		int time;	// 0은 낮, 1은 밤
		
		public pos(int x,int y,int dist,int wall,int time) {
			this.x = x; this.y = y; this.dist = dist; this.wall = wall; this.time = time;
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	private static void bfs(int y,int x) {
		Queue<pos> q = new LinkedList<pos>();
		q.add(new pos(0,0,0,0,0));
		visited[y][x][0][0] = true;
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			
			if(p.y == n - 1 && p.x == m - 1) {
				ans = p.dist + 1;
				return;
			}
			
			for(int i = 0;i < dx.length;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(!isRange(ny,nx))
					continue;
				
				if(map[ny][nx] == '1') {
					if(p.time == 1 || p.wall == k || visited[ny][nx][p.wall + 1][1 - p.time])
						continue;
					visited[ny][nx][p.wall + 1][1 - p.time] = true;
					q.add(new pos(nx,ny,p.dist + 1,p.wall + 1,1 - p.time));
				} else {
					if(visited[ny][nx][p.wall][1 - p.time])
						continue;
					visited[ny][nx][p.wall][1 - p.time] = true;
					q.add(new pos(nx,ny,p.dist + 1,p.wall,1 - p.time));
				}
			}
			if(visited[p.y][p.x][p.wall][1 - p.time])
				continue;
			visited[p.y][p.x][p.wall][1 - p.time] = true;
			q.add(new pos(p.x,p.y,p.dist + 1,p.wall,1 - p.time));
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m][k + 1][2];
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			for(int j = 0;j < m;j++)
				map[i][j] = str.charAt(j);
		}
		bfs(0,0);
		System.out.println(ans);
	}
}
