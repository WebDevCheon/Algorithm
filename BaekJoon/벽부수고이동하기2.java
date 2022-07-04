package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기2 {		

	private static char[][] map;
	private static boolean[][][] visited;
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
		
		public pos(int x,int y,int dist,int wall) {
			this.x = x; this.y = y; this.dist = dist; this.wall = wall;
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	private static void bfs(int y,int x) {
		Queue<pos> q = new LinkedList<pos>();
		q.add(new pos(x,y,0,0));
		visited[y][x][0] = true;
		
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
					if(p.wall == k || visited[ny][nx][p.wall + 1])
						continue;
					visited[ny][nx][p.wall + 1] = true;
					q.add(new pos(nx,ny,p.dist + 1,p.wall + 1));
				} else {
					if(visited[ny][nx][p.wall])
						continue;
					visited[ny][nx][p.wall] = true;
					q.add(new pos(nx,ny,p.dist + 1,p.wall));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			for(int j = 0;j < m;j++)
				map[i][j] = str.charAt(j);
		}
		visited = new boolean[n][m][k + 1];
		bfs(0,0);
		System.out.println(ans);
	}	
}
