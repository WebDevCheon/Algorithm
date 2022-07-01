package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리 {

	private static int n;
	private static int m;
	private static int[][] map;
	private static int[][] dist;
	private static int ty;
	private static int tx;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};

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
	
	private static void bfs(int y,int x) {
		Queue<pos> q = new LinkedList<pos>();
		boolean[][] visited = new boolean[n][m];
		visited[y][x] = true;
		q.add(new pos(x,y));
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			
			for(int i = 0;i < dx.length;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(!isRange(ny,nx) || visited[ny][nx] || map[ny][nx] == 0)
					continue;
				
				q.add(new pos(nx,ny));
				visited[ny][nx] = true;
				dist[ny][nx] = dist[p.y][p.x] + 1;
			}
		}
	}
	
	private static void check(ArrayList<pos> isLand) {
		for(pos land : isLand) {
			if(dist[land.y][land.x] == 0)
				dist[land.y][land.x] = -1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];
		ArrayList<pos> isLand = new ArrayList<pos>();
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					ty = i; 
					tx = j;
				} else if(map[i][j] == 1)
					isLand.add(new pos(j,i));
			}
		}
		bfs(ty,tx);
		check(isLand);
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++)
				System.out.print(dist[i][j] + " ");
			System.out.println();
		}
	}
}