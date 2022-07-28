package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 인내의도미노장인호석 {

	private static int[][] map;
	private static int[][] tmp;
	private static int n;
	private static int m;
	private static int r;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static int ans;
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	private static void attack(int y,int x,int destY,int destX,int dir) {
		if(!isRange(y,x))
			return;
		else if(map[y][x] == -1) {
			if(y == destY && x == destX)
				return;
			else {
				attack(y + dy[dir],x + dx[dir],destY,destX,dir);
				return;
			}
		}

		int nx = x + dx[dir] * (map[y][x] - 1);
		int ny = y + dy[dir] * (map[y][x] - 1);
		ans++;
		map[y][x] = -1;
		
		if(dir == 0) {
			if(nx > destX)
				destX = nx;
		} else if(dir == 1) {
			if(ny > destY)
				destY = ny;
		} else if(dir == 2) {
			if(nx < destX)
				destX = nx;
		} else {
			if(ny < destY)
				destY = ny;
		}
		
		if(destY == y && destX == x)
			return;
		
		if(dir == 0)
			attack(y,x + 1,destY,destX,dir);
		else if(dir == 1)
			attack(y + 1,x,destY,destX,dir);
		else if(dir == 2)
			attack(y,x - 1,destY,destX,dir);
		else
			attack(y - 1,x,destY,destX,dir);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		tmp = new int[n][m];
		
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < m;j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				tmp[i][j] = num;
			}
		}
		
		for(int i = 0;i < r;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			char dir = st.nextToken().charAt(0);
			if(dir == 'E')
				dir = 0;
			else if(dir == 'S')
				dir = 1;
			else if(dir == 'W')
				dir = 2;
			else
				dir = 3;
			int destX = x + dx[dir] * (map[y][x] - 1);
			int destY = y + dy[dir] * (map[y][x] - 1);
			if(map[y][x] != -1)
				attack(y,x,destY,destX,dir);
			
			st = new StringTokenizer(br.readLine());
			int defendY = Integer.parseInt(st.nextToken()) - 1;
			int defendX = Integer.parseInt(st.nextToken()) - 1;
			if(map[defendY][defendX] == -1)
				map[defendY][defendX] = tmp[defendY][defendX];
		}
		
		System.out.println(ans);
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				if(map[i][j] == -1)
					System.out.print("F ");
				else
					System.out.print("S ");
			}
			System.out.println();
		}
	}
}
