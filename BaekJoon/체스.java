package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 체스 {

	private static char[][] map;
	private static boolean[][] visited;
	private static int n;
	private static int m;
	private static int[] kdx = {2,1,-1,-2,-2,-1,1,2};
	private static int[] kdy = {1,2,2,1,-1,-2,-2,-1};
	private static int[] qdx = {1,1,0,-1,-1,-1,0,1};
	private static int[] qdy = {0,1,1,1,0,-1,-1,-1};
	private static List<pos> queenList = new ArrayList<pos>();
	private static List<pos> knightList = new ArrayList<pos>();
	private static int ans;
	
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
	
	private static void init() {
		map = new char[n][m];
		visited = new boolean[n][m];
		for(int i = 0;i < n;i++)
			for(int j = 0;j < m;j++)
				map[i][j] = '.';
	}
	
	private static boolean isNotStartingPos(int y,int x,int sy,int sx) {
		return (sy != y || sx != x);
	}
	
	private static void checkQueen(int y,int x,int sy,int sx,int dir) {
		if(map[y][x] != '.' && isNotStartingPos(y,x,sy,sx))
			return;
		visited[y][x] = true;
		
		int nx = x + qdx[dir];
		int ny = y + qdy[dir];
		
		if(!isRange(ny,nx))
			return;
		checkQueen(ny,nx,sy,sx,dir);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		init();
		for(int i = 0;i < 3;i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int j = 0;j < k;j++) {
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				if(i == 0) {
					map[y][x] = 'Q';
					queenList.add(new pos(x,y));
				} else if(i == 1) {
					map[y][x] = 'K';
					knightList.add(new pos(x,y));
				} else {
					visited[y][x] = true;
					map[y][x] = 'P';
				}
			}
		}
		
		for(int i = 0;i < queenList.size();i++) {
			pos p = queenList.get(i);
			visited[p.y][p.x] = true;
			int dir = 0;
			while(dir < qdx.length)
				checkQueen(p.y,p.x,p.y,p.x,dir++);
		}
		for(int i = 0;i < knightList.size();i++) {
			pos p = knightList.get(i);
			visited[p.y][p.x] = true;
			for(int j = 0;j < kdx.length;j++) {
				int nx = p.x + kdx[j];
				int ny = p.y + kdy[j];
				if(!isRange(ny,nx))
					continue;
				visited[ny][nx] = true;
			}
		}
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				if(!visited[i][j])
					ans++;
			}
		}
		System.out.println(ans);
	}
}
