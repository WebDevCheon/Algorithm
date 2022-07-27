package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
	
	private static int[][] map;
	private static boolean[][] visited;
	private static int n;
	private static int m;
	private static List<pos> tomatoList = new ArrayList<pos>();
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static int ans;
	
	static class pos {
		int x;
		int y;
		int cnt;
		public pos(int x,int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	private static void bfs() {
		Queue<pos> q = new LinkedList<pos>();
		for(int i = 0;i < tomatoList.size();i++) {
			pos p = tomatoList.get(i);
			visited[p.y][p.x] = true;
			q.add(new pos(p.x,p.y,p.cnt));
		}
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			ans = Math.max(p.cnt,ans);
			
			for(int i = 0;i < dx.length;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(!isRange(ny,nx) || visited[ny][nx] || map[ny][nx] == -1)
					continue;
				visited[ny][nx] = true;
				q.add(new pos(nx,ny,p.cnt + 1));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					tomatoList.add(new pos(j,i,0));
			}
		}
		bfs();
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				if(!visited[i][j] && map[i][j] != -1) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		System.out.println(ans);
	}
}
