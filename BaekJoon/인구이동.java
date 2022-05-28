package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 인구이동 {
	
	private static int[][] map;
	private static ArrayList<ArrayList<pos>> posList = new ArrayList<ArrayList<pos>>();
	private static int n;
	private static int l;
	private static int r;
	private static boolean[][] visited;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static boolean isMoved;
	
	static class pos {
		int x;
		int y;
		public pos(int x,int y) {
			this.x = x; this.y = y;
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
	
	private static void dfs(int y,int x,ArrayList<pos> list) {
		if(visited[y][x])
			return;
		visited[y][x] = true;
		list.add(new pos(x,y));
		
		for(int i = 0;i < dx.length;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!isRange(ny,nx))
				continue;
			int diff = Math.abs(map[y][x] - map[ny][nx]);
			if(diff < l || diff > r)
				continue;
			isMoved = true;
			dfs(ny,nx,list);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < n;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int day = 0;
		
		while(true) {
			isMoved = false;
			visited = new boolean[n][n];
			posList = new ArrayList<ArrayList<pos>>();
			
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < n;j++) {
					if(!visited[i][j]) {
						ArrayList<pos> list = new ArrayList<pos>();
						dfs(i,j,list);
						posList.add(list);
					}
				}
			}
			if(!isMoved)
				break;
			for(int i = 0;i < posList.size();i++) {
				int size = posList.get(i).size();
				int sum = 0;
				for(int j = 0;j < posList.get(i).size();j++) {
					pos p = posList.get(i).get(j);
					sum += map[p.y][p.x];
				}
				for(int j = 0;j < posList.get(i).size();j++) {
					pos p = posList.get(i).get(j);
					map[p.y][p.x] = sum / size; 
				}
			}
			day++;
		}
		System.out.println(day);
	}
}
