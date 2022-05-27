package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로 {

	private static int[][] map;
	private static int n;
	private static int l;
	private static int ans;
	private static boolean isEscape;
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
	
	private static void simulRow(int y, int x,int sy,int sx,boolean down) {
		if(x == n - 1) {
			ans++;
			isEscape = true;
			return;
		}
		if(map[y][x + 1] == map[y][x])
			simulRow(y,x + 1,sy,sx,false);
		if(isEscape)
			return;
		
		// 높을때
		int cnt = 0;
		for(int i = x;i <= x + l;i++) {
			if(down)
				break;
			if(!isRange(y,i))
				break;
			if(i == x + l && map[y][x] + 1 == map[y][i]) {
				simulRow(y,i,sy,sx,false);
				break;
			}
			if(map[y][x] == map[y][i])
				cnt++;
			else
				break;
		}
		if(isEscape)
			return;
		
		// 낮을때
		cnt = 0;
		for(int i = x + 1;i <= x + l;i++) {
			if(!isRange(y,i))
				break;
			if(map[y][x] - 1 == map[y][i])
				cnt++;
			else
				break;
		}
		if(cnt == l)
			simulRow(y,x + l,sy,sx,true);
	}

	private static void simulCol(int y, int x,int sy,int sx,boolean down) {
		if(y == n - 1) {
			ans++;
			isEscape = true;
			return;
		}
		// 같을때
		if(map[y + 1][x] == map[y][x])
			simulCol(y + 1,x,sy,sx,false);
		if(isEscape)
			return;
		
		// 높을때
		int cnt = 0;
		for(int i = y;i <= y + l;i++) {
			if(down)
				break;
			if(!isRange(i,x))
				break;
			if(i == y + l && map[y][x] + 1 == map[i][x]) {
				simulCol(i,x,sy,sx,false);
				break;
			}
			if(map[y][x] == map[i][x])
				cnt++;
			else
				break;
		}
		if(isEscape)
			return;
		
		// 낮을때
		cnt = 0;
		for(int i = y + 1;i <= y + l;i++) {
			if(!isRange(i,x))
				break;
			if(map[y][x] - 1 == map[i][x])
				cnt++;
			else
				break;
		}
		if(cnt == l)
			simulCol(y + l,x,sy,sx,true);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0;i < n;i++) {
			isEscape = false;
			simulCol(0,i,0,i,false);
		}
		for(int i = 0;i < n;i++) {
			isEscape = false;
			simulRow(i,0,i,0,false);
		}
		System.out.println(ans);
	}
}
