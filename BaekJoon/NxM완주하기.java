package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NxM완주하기 {

	private static char[][] map;
	private static int n;
	private static int m;
	private static boolean[][] visited;
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static int space;
	private static int ans;

	private static boolean isRange(int y, int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}

	private static void dfs(int y, int x, int dir, int cnt, int tmp) {
		if (cnt > 1000000)
			return;
		if (tmp == space) {
			ans = Math.min(cnt, ans);
			return;
		}

		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (!isRange(ny, nx) || map[ny][nx] == '*' || visited[ny][nx]) {
			for (int i = 0; i < dx.length; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (isRange(ny, nx) && map[ny][nx] == '.' && !visited[ny][nx]) {
					visited[ny][nx] = true;
					dfs(ny, nx, i, cnt + 1, tmp + 1);
					visited[ny][nx] = false;
				}
			}
		} else {
			visited[ny][nx] = true;
			dfs(ny, nx, dir, cnt, tmp + 1);
			visited[ny][nx] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		int round = 1;

		while ((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			space = 0;
			ans = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j] == '.')
						space++;
				}
			}
			visited = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					for (int k = 0; k < dx.length; k++) {
						if (map[i][j] == '.') {
							visited[i][j] = true;
							dfs(i, j, k, 1, 1);
							visited[i][j] = false;
						}
					}
				}
			}
			
			if (space == 1) {
				bw.write("Case " + round + ": " + 0 + "\n");
			} else {
				if (ans != Integer.MAX_VALUE)
					bw.write("Case " + round + ": " + ans + "\n");
				else
					bw.write("Case " + round + ": " + -1 + "\n");
			}
			bw.flush();
			round++;

		}
	}
}