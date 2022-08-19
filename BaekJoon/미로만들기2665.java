package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 미로만들기2665 {

	private static int[][] map;
	private static int n;
	private static boolean[][][] visited;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	
	static class pos implements Comparable<pos> {
		int x;
		int y;
		int cnt;
		
		public pos(int x,int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(pos otherPos) {
			return this.cnt - otherPos.cnt;
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
	
	private static int bfs() {
		PriorityQueue<pos> pq = new PriorityQueue<pos>();
		pq.add(new pos(0,0,0));
		visited[0][0][0] = true;
		
		while(!pq.isEmpty()) {
			pos p = pq.poll();
			
			if(p.y == n - 1 && p.x == n - 1)
				return p.cnt;
			else if(p.cnt >= n * n)
				continue;
			
			for(int i = 0;i < dx.length;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nCnt = p.cnt;
			
				if(!isRange(ny,nx) || visited[ny][nx][nCnt])
					continue;
				
				if(map[ny][nx] == 0) {
					visited[ny][nx][p.cnt + 1] = true;
					pq.add(new pos(nx,ny,p.cnt + 1));
				} else {
					visited[ny][nx][p.cnt] = true;
					pq.add(new pos(nx,ny,p.cnt));
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n][n * n + 1];
		
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			for(int j = 0;j < n;j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}
}
