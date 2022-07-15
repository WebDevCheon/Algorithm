package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 통나무옮기기 {

	private static char[][] map;
	private static int n;
	private static boolean[][][] visited;			// 가운데를 중심으로 0은 가로, 1은 세로
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static tong target = new tong(null,null,null,0);		// 통나무
	
	static class tong {
		pos t1;
		pos t2;
		pos t3;
		int cnt;
		
		public tong(pos t1,pos t2,pos t3,int cnt) {
			this.t1 = t1;
			this.t2 = t2;
			this.t3 = t3;
			this.cnt = cnt;
		}
	}
	
	static class pos {
		int x;
		int y;
		
		public pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	private static int bfs(tong t) {
		Queue<tong> q = new LinkedList<tong>();	
		pos t1 = t.t1;
		pos t2 = t.t2;
		pos t3 = t.t3;
		if(t1.y + 1 == t2.y)		// 0은 가로, 1은 세로
			visited[1][t2.y][t2.x] = true; 
		else
			visited[0][t2.y][t2.x] = true; 
		q.add(t);
		
		while(!q.isEmpty()) {
			tong p = q.poll();
			
			if(isDestination(p))
				return p.cnt;
			
			t1 = p.t1;
			t2 = p.t2;
			t3 = p.t3;
			
			for(int i = 0;i < dx.length;i++) {
				int nx1 = t1.x + dx[i]; int ny1 = t1.y + dy[i];
				int nx2 = t2.x + dx[i]; int ny2 = t2.y + dy[i];
				int nx3 = t3.x + dx[i]; int ny3 = t3.y + dy[i];
				
				if(!isRange(ny1,nx1) || !isRange(ny2,nx2) || !isRange(ny3,nx3))
					continue;
				else if(map[ny1][nx1] == '1' || map[ny2][nx2] == '1' || map[ny3][nx3] == '1')
					continue;
				
				if(ny1 + 1 == ny2) {
					if(isVisited(new tong(new pos(nx1,ny1), new pos(nx2,ny2), new pos(nx3,ny3),p.cnt + 1),1))
						continue;
					visited[1][ny2][nx2] = true;
				} else if(nx1 + 1 == nx2) {
					if(isVisited(new tong(new pos(nx1,ny1), new pos(nx2,ny2), new pos(nx3,ny3),p.cnt + 1),0))
						continue;
					visited[0][ny2][nx2] = true; 
				}
				q.add(new tong(new pos(nx1,ny1), new pos(nx2,ny2), new pos(nx3,ny3), p.cnt + 1));
			}
			
			int pattern = -1;
			
			if(t1.y + 1 == t2.y) {						// B
				int x1 = t1.x - 1;						// B
				int x2 = t3.x + 1;						// B
				
				if(!isRange(t1.y,x1) || !isRange(t3.y,x2))
					continue;
				boolean escape = false;
				for(int i = t1.y;i <= t3.y;i++) {
					for(int j = x1;j <= x2;j++) {
						if(map[i][j] == '1')
							escape = true;
					}
				}
				if(escape)
					continue;
				t1 = new pos(t2.x - 1,t2.y);
				t3 = new pos(t2.x + 1,t2.y);
				pattern = 0;
			} else if(t1.x + 1 == t2.x) {		// BBB
				
				int y1 = t1.y - 1;
				int y2 = t3.y + 1;
				
				if(!isRange(y1,t1.x) || !isRange(y2,t3.x))
					continue;
				
				boolean escape = false;
				
				for(int i = y1;i <= y2;i++) {
					for(int j = t1.x;j <= t3.x;j++) {
						if(map[i][j] == '1')
							escape = true;
					}
				}
				if(escape)
					continue;
				t1 = new pos(t2.x,t2.y - 1);
				t3 = new pos(t2.x,t2.y + 1);
				pattern = 1;
			}
			
			if(isVisited(new tong(t1,t2,t3,p.cnt + 1),pattern))
				continue;
			visited[pattern][t2.y][t2.x] = true; 
			q.add(new tong(t1,t2,t3,p.cnt + 1));
		}
		return 0;
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
	
	private static boolean isDestination(tong t) {
		if(t.t1.y == target.t1.y && t.t1.x == target.t1.x && t.t2.y == target.t2.y && t.t2.x == target.t2.x && t.t3.y == target.t3.y &&
				t.t3.x == target.t3.x)
			return true;
		return false;
	}
	
	private static boolean isVisited(tong t,int pattern) {
		pos t2 = t.t2;
		
		if(visited[pattern][t2.y][t2.x])
			return true;
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visited = new boolean[2][n][n];
		pos t1 = null;
		pos t2 = null;
		pos t3 = null;
		tong t = new tong(t1,t2,t3,0);
		
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			for(int j = 0;j < str.length();j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'B') {
					if(t1 == null) {
						t1 = new pos(j,i);
					} else if(t2 == null) {
						t2 = new pos(j,i);
					} else if(t3 == null) {
						t3 = new pos(j,i);
						t = new tong(t1,t2,t3,0);
					}
				} else if(map[i][j] == 'E') {
					if(target.t1 == null) {
						target.t1 = new pos(j,i);
					} else if(target.t2 == null) {
						target.t2 = new pos(j,i);
					} else if(target.t3 == null) {
						target.t3 = new pos(j,i);
					}
				}
			}
		}
		int ans = bfs(t);
		System.out.println(ans);
	}
}
