package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 거리두기확인하기 {

	private static int n = 5;
	private static boolean[][] visited;
	private static char[][] map = new char[5][5];
	private static boolean flag;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	
	static class pos {
		int x;
		int y;
		
		public pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
	
	/*
	private static void dfs(int y,int x,int starty,int startx) {
		if(visited[y][x])
			return;
		visited[y][x] = true;
		for(int i = 0;i < dx.length;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int manhatan = Math.abs(startx - nx) + Math.abs(starty - ny);
			if(!isRange(ny,nx) || map[ny][nx] == 'X' || manhatan > 2)
				continue;
			if(!(starty == ny && startx == nx) && manhatan <= 2 && map[ny][nx] == 'P') {
				flag = true;
				break;
			}
			dfs(ny,nx,starty,startx);
		}
	}
	*/
	
	private static boolean dfs(int y,int x,int starty,int startx) {
		if(visited[y][x])
			return false;
		boolean ans = false;
		visited[y][x] = true;
		for(int i = 0;i < dx.length;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int manhatan = Math.abs(startx - nx) + Math.abs(starty - ny);
			if(!isRange(ny,nx) || map[ny][nx] == 'X' || manhatan > 2)
				continue;
			if(!(starty == ny && startx == nx) && manhatan <= 2 && map[ny][nx] == 'P')
				return true;
			ans = dfs(ny,nx,starty,startx);
			if(ans)
				break;
		}
		return ans;
	}
	
	public static int[] solution(String[][] places) {
		int[] ans = new int[n];
		for(int a = 0;a < n;a++) {          // 방 1개씩 검사
            List<pos> list = new ArrayList<pos>();
			for(int i = 0;i < n;i++) {      // 방 1,2,3,4,5를 하나씩 배치
				String str = places[a][i];
				for(int j = 0;j < n;j++) {
					map[i][j] = str.charAt(j);
                    if(map[i][j] == 'P')
                        list.add(new pos(j,i));
                }
			}
			visited = new boolean[n][n];
			flag = false;
            for(int i = 0;i < list.size();i++) {
            	pos p = list.get(i);
            	flag = dfs(p.y,p.x,p.y,p.x);
            	if(flag)
            		break;
            }
			if(flag)
				ans[a] = 0;
			else
				ans[a] = 1;
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] places = new String[n][n];
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j < n;j++)
				places[i][j] = st.nextToken();
		}
		int[] ans = solution(places); 
		for(int i = 0;i < n;i++)
			System.out.print(ans[i] + " ");
	}
}
