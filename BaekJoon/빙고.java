package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 빙고 {

	private static int ans;
	private static int[][] bingo = new int[5][5];
	private static int n = 5;
	private static boolean[] rowCheck = new boolean[5];
	private static boolean[] colCheck = new boolean[5];
	private static boolean[] diagCheck = new boolean[2];
	private static Map<Integer, pos> map = new HashMap<Integer, pos>();

	static class pos {
		int x;
		int y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int checkRow() {
		int tmp = 0;
		
		for (int i = 0; i < n; i++) {
			if (rowCheck[i])
				continue;
			int cnt = 0;
			
			for (int j = 0; j < n; j++) {
				if (bingo[i][j] == -1)
					cnt++;
			}
			if (cnt == 5) {
				rowCheck[i] = true;
				tmp++;
			}
		}
		return tmp;
	}

	private static int checkCol() {
		int tmp = 0;
		
		for (int i = 0; i < n; i++) {
			if (colCheck[i])
				continue;
			int cnt = 0;
			
			for (int j = 0; j < n; j++) {
				if (bingo[j][i] == -1)
					cnt++;
			}
			if (cnt == 5) {
				colCheck[i] = true;
				tmp++;
			}
		}
		return tmp;
	}

	private static int checkDiag() {
		int tmp = 0;
		int y = 0;
		int x = 0;
		int cnt = 0;

		if (!diagCheck[0]) {
			for (int i = 0; i < n; i++) {
				if(bingo[y++][x++] == -1)
					cnt++;
				
				if (cnt == 5) {
					diagCheck[0] = true;
					tmp++;
				}
			}
		}
		
		y = 0;
		x = n - 1;
		cnt = 0;
		
		if(!diagCheck[1]) {
			for(int i = 0;i < n;i++) {
				if(bingo[y++][x--] == -1)
					cnt++;
				
				if(cnt == 5) {
					diagCheck[1] = true;
					tmp++;
				}
			}
		}
		return tmp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
				map.put(bingo[i][j], new pos(j, i));
			}
		}
		
		int[] num = new int[26];
		int idx = 1;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				num[idx++] = Integer.valueOf(st.nextToken());
			}
		}

		for (int i = 1; i <= n * n; i++) {
			pos p = map.get(num[i]);
			bingo[p.y][p.x] = -1;
			
			ans += checkRow();
			ans += checkCol();
			ans += checkDiag();
			if (ans >= 3) {
				System.out.println(i);
				System.exit(0);
			}
		}
	}
}
