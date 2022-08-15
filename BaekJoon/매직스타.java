package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 매직스타 {

	private static char[][] map;
	private static boolean[] visited = new boolean[26];
	private static int n = 5;
	private static int m = 9;
	private static ArrayList<pos> list = new ArrayList<pos>();
	
	static class pos {
		int x;
		int y;
		public pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void print() {
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
		System.exit(0);
	}
	
	private static void dfs(int idx) {
		if(idx == list.size()) {
			if(check())
				print();
			return;
		}
		
		for(int i = 0;i < 12;i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			pos p = list.get(idx);
			map[p.y][p.x] = (char)('A' + i);
			dfs(idx + 1);
			visited[i] = false;
		}
	}
	
	private static boolean check() {
		int sum1 = (int)(map[0][4] - 'A' + 1) + (int)(map[1][3] - 'A' + 1) + (int)(map[2][2] - 'A' + 1) + (int)(map[3][1] - 'A' + 1);
		int sum2 = (int)(map[3][1] - 'A' + 1) + (int)(map[3][3] - 'A' + 1) + (int)(map[3][5] - 'A' + 1) + (int)(map[3][7] - 'A' + 1);
		int sum3 = (int)(map[0][4] - 'A' + 1) + (int)(map[1][5] - 'A' + 1) + (int)(map[2][6] - 'A' + 1) + (int)(map[3][7] - 'A' + 1);
		int sum4 = (int)(map[1][1] - 'A' + 1) + (int)(map[2][2] - 'A' + 1) + (int)(map[3][3] - 'A' + 1) + (int)(map[4][4] - 'A' + 1);
		int sum5 = (int)(map[4][4] - 'A' + 1) + (int)(map[3][5] - 'A' + 1) + (int)(map[2][6] - 'A' + 1) + (int)(map[1][7] - 'A' + 1);
		int sum6 = (int)(map[1][1] - 'A' + 1) + (int)(map[1][3] - 'A' + 1) + (int)(map[1][5] - 'A' + 1) + (int)(map[1][7] - 'A' + 1);
		
		if(sum1 == 26 && sum1 == sum2 && sum2 == sum3 && sum3 == sum4 && sum4 == sum5 && sum5 == sum6)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[n][m];
		
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			for(int j = 0;j < m;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'x')
					list.add(new pos(j,i));
				else if(map[i][j] != '.')
					visited[map[i][j] - 'A'] = true;
			}
		}
		dfs(0);
	}
}
