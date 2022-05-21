package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 소문난칠공주 {
	
	private static char[][] map = new char[5][5];
	private static boolean[][] toGo = new boolean[5][5];
	private static boolean[][] chk;
	private static int cnt;
	private static int n = 5;
	private static int ans;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static pos[] pick = new pos[7];
	
	static class pos {
		int x;
		int y;
		public pos(int x,int y) {
			this.x = x;this.y = y;
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
	
	private static void dfs(int y,int x) {
		if(chk[y][x])
			return;
		chk[y][x] = true;
		cnt++;
		
		for(int i = 0;i < dx.length;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isRange(ny,nx))
				continue;
			if(toGo[ny][nx])
				dfs(ny,nx);
		}
	}
	
	private static void pick(int idx,int start,int Y) {
		if(Y >= 4)
			return;
		if(idx == 7) {
			toGo = new boolean[n][n];
			int S = 0;
			for(int i = 0;i < pick.length;i++) {
				pos p = pick[i];
				if(map[p.y][p.x] == 'S')
					S++;
				toGo[p.y][p.x] = true;
			}
			if(S < 4)
				return;
			cnt = 0;
			pos sPos = pick[0];
			chk = new boolean[n][n];
			dfs(sPos.y,sPos.x);
			if(cnt == 7)
				ans++;
			return;
		}
		
		for(int i = start;i < n * n;i++) {
			int row = i / n;
			int col = i % n;
			pick[idx] = new pos(col,row);
			if(map[row][col] == 'Y')
				pick(idx + 1,i + 1,Y + 1);
			else
				pick(idx + 1,i + 1,Y);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			for(int j = 0;j < n;j++)
				map[i][j] = str.charAt(j);
		}
		pick(0,0,0);
		System.out.println(ans);
	}
}
