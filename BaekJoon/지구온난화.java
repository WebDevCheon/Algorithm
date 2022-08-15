package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 지구온난화 {

	private static char[][] map;
	private static int n;
	private static int m;
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static List<pos> eraseList = new ArrayList<pos>();
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	static class pos {
		int x;
		int y;
		public pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			for(int j = 0;j < str.length();j++)
				map[i][j] = str.charAt(j);
		}
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				int cnt = 0;
				for(int k = 0;k < dx.length;k++) {
					int nx = j + dx[k];
					int ny = i + dy[k];

					if(!isRange(ny, nx) || map[ny][nx] == '.')
						cnt++;
				}
				if(cnt >= 3)
					eraseList.add(new pos(j,i));
			}
		}
		for(int i = 0;i < eraseList.size();i++) {
			pos p = eraseList.get(i);
			map[p.y][p.x] = '.'; 
		}
		
		int startY = Integer.MAX_VALUE;
		int startX = Integer.MAX_VALUE;
		int endY = Integer.MIN_VALUE;
		int endX = Integer.MIN_VALUE;
		
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				if(map[i][j] == 'X') {
					startY = Math.min(i, startY);
					startX = Math.min(j, startX);
					endY = Math.max(i, endY);
					endX = Math.max(j, endX);
				}
			}
		}
		
		for(int i = startY;i <= endY;i++) {
			for(int j = startX;j <= endX;j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}
}
