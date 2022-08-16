package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 미로만들기 {
	
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static int dir = 1;
	private static List<pos> list = new ArrayList<pos>();
	private static int sx = 52;
	private static int sy = 52;
	
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
		String str = br.readLine();
		int minX = sx;
		int minY = sy;
		int maxX = sx;
		int maxY = sy;
		list.add(new pos(sx,sy));
		
		for(int i = 0;i < str.length();i++) {
			if(str.charAt(i) == 'L') {
				dir--;
				if(dir < 0)
					dir = dx.length - 1;
			} else if(str.charAt(i) == 'R') {
				dir = (dir + 1) % dx.length;
			} else {
				sx += dx[dir];
				sy += dy[dir];
				minX = Math.min(sx,minX);
				minY = Math.min(sy,minY);
				maxX = Math.max(sx,maxX);
				maxY = Math.max(sy,maxY);
				list.add(new pos(sx,sy));		// '.' 부분
			}
		}
		
		int ax = minX;
		int ay = minY;
		int bx = maxX;
		int by = maxY;
		
		int sizeY = by - ay;
		int sizeX = bx - ax;
		char[][] ans = new char[sizeY + 1][sizeX + 1];
		
		for(int i = ay;i <= by;i++) {
			for(int j = ax;j <= bx;j++) {
				for(int k = 0;k < list.size();k++) {
					pos p = list.get(k);
					if(p.y == i && p.x == j)
						ans[i - ay][j - ax] = '.';
				}
			}
		}
		
		for(int i = 0;i < ans.length;i++) {
			for(int j = 0;j < ans[0].length;j++) {
				if(ans[i][j] == '.')
					System.out.print('.');
				else
					System.out.print('#');
			}
			System.out.println();
		}
	}
}
