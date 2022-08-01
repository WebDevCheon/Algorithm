package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 지뢰찾기2140 {

	private static int[][] map;
	private static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };
	private static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	private static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		n = Integer.parseInt(br.readLine());
		if (n == 1 || n == 2) {
			System.out.println(0);
			System.exit(0);
		}
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				if (str.charAt(j) != '#')
					map[i][j] = Integer.valueOf(String.valueOf(str.charAt(j)));
				else
					map[i][j] = -1;
			}
		}
		
		for (int i = 1; i <= n - 2; i++) {
			for (int j = 1; j <= n - 2; j++) {
				if (i == 1 || j == 1) {
					if (map[i - 1][j - 1] == 1)
						map[i][j] = 5;
					else {
						map[i][j] = -1;
						continue;
					}
					for (int k = 0; k < dx.length; k++) {
						int nx = j + dx[k];
						int ny = i + dy[k];
						if (map[ny][nx] == -1 || map[ny][nx] == 5)
							continue;
						map[ny][nx]--;
					}
				} else if(i == n - 2) {
					if (map[i + 1][j - 1] == 1)
						map[i][j] = 5;
					else {
						map[i][j] = -1;
						continue;
					}
					for (int k = 0; k < dx.length; k++) {
						int nx = j + dx[k];
						int ny = i + dy[k];
						if (map[ny][nx] == -1 || map[ny][nx] == 5)
							continue;
						map[ny][nx]--;
					}
				} else if(j == n - 2) {
					if (map[i - 1][j + 1] == 1)
						map[i][j] = 5;
					else {
						map[i][j] = -1;
						continue;
					}
					for (int k = 0; k < dx.length; k++) {
						int nx = j + dx[k];
						int ny = i + dy[k];
						if (map[ny][nx] == -1 || map[ny][nx] == 5)
							continue;
						map[ny][nx]--;
					}
				} else
					map[i][j] = 5;
				ans++;
			}
		}
		System.out.println(ans);
	}
}
