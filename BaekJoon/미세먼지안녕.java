package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지안녕 {			
	private static int[][] map;
	private static int n;
	private static int m;
	private static int t;
	private static int[][] spreadMap;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static pos up;
	private static pos down;
	
	static class pos {
		int x;
		int y;
		public pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean canSpread(int y,int x) {
		if((x < 0 || x >= m || y < 0 || y >= n) || map[y][x] == -1)
			return false;
		return true;
	}
	
	private static void spread() {		// 미세 먼지 확산
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				if(map[i][j] > 0) {
					int s = map[i][j] / 5;
					int area = 0;
					
					for(int k = 0;k < dx.length;k++) {
						int nx = j + dx[k];
						int ny = i + dy[k];
						if(!canSpread(ny,nx))
							continue;
						spreadMap[ny][nx] += s;
						area++;
					}
					map[i][j] -= area * s;
				}
			}
		}
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++)
				map[i][j] += spreadMap[i][j];
		}
	}
	
	private static void move() {	// 미세 먼지 바람의 방향으로 이동
		// 위
		int sx = up.x;
		int sy = up.y - 1;

		while(sy != up.y || sx != up.x + 1) {
			if(sx == 0 && sy > 0) {
				map[sy][sx] = map[sy - 1][sx];
				sy--;
			} else if((sx >= 0 && sx < m - 1) && sy == 0) {
				map[sy][sx] = map[sy][sx + 1];
				sx++;
			} else if(sx == m - 1 && (sy >= 0 && sy < up.y)) {
				map[sy][sx] = map[sy + 1][sx];
				sy++;
			} else if((sx > 1 && sx <= m - 1) && (sy == up.y)) {
				map[sy][sx] = map[sy][sx - 1];
				sx--;
			}
		}
		map[sy][sx] = 0;
		
		// 아래
		sx = down.x;
		sy = down.y + 1;
		while(sy != down.y || sx != down.x + 1) {
			if(sx == 0 && (sy > down.y && sy < n - 1)) {
				map[sy][sx] = map[sy + 1][sx];
				sy++;
			} else if((sx >= 0 && sx < m - 1) && (sy == n - 1)) {
				map[sy][sx] = map[sy][sx + 1];
				sx++;
			} else if(sx == m - 1 && (sy > down.y && sy <= n - 1)) {
				map[sy][sx] = map[sy - 1][sx];
				sy--;
			} else if((sx > 1 && sx <= m - 1) && sy == down.y) {
				map[sy][sx] = map[sy][sx - 1];
				sx--;
			}
		}
		map[sy][sx] = 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		int start = 0;
		int ans = 0;
		up = null;
		down = null;

		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					if(up == null)
						up = new pos(j,i);
					else
						down = new pos(j,i);
				}
			}
		}
		
		while(start++ < t) {
			spreadMap = new int[n][m];
			spread();
			move();
		}
		
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				if(map[i][j] > 0)
					ans += map[i][j];
			}	
		}
		System.out.println(ans);
	}
}
