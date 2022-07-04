package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 벽부수고이동하기4 {

	private static int[][] map;
	private static int[][] group;
	private static boolean[][] visited;
	private static int n;
	private static int m;
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static Map<Integer, Integer> cntByGrp = new HashMap<Integer, Integer>();
	private static int cnt;
	private static ArrayList<pos> list = new ArrayList<pos>();

	static class pos {
		int x;
		int y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static boolean isRange(int y, int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}

	private static void dfs(int y, int x, int grp) {
		if (visited[y][x])
			return;
		visited[y][x] = true;
		group[y][x] = grp;
		cnt++;

		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isRange(ny, nx))
				continue;
			if (map[ny][nx] == 0)
				dfs(ny, nx, grp);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		group = new int[n][m];
		int[][] ansMap = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
				if (map[i][j] == 1)
					list.add(new pos(j, i));
			}
		}

		int grp = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					cnt = 0;
					dfs(i, j, grp);
					cntByGrp.put(grp, cnt);
					grp++;
				}
			}
		}

		for (int i = 0; i < list.size(); i++) { 	
			int x = list.get(i).x;
			int y = list.get(i).y;
			
			int ans = 0;
			boolean[] grpVisited = new boolean[grp + 1];
			
			for (int k = 0; k < dx.length; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if (!isRange(ny, nx) || map[ny][nx] == 1 || grpVisited[group[ny][nx]])
					continue;
				grpVisited[group[ny][nx]] = true;
				ans += cntByGrp.get(group[ny][nx]);
			}
			ansMap[y][x] = (ans + 1) % 10;
		}
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++)
				bw.write(String.valueOf(ansMap[i][j]));
			bw.write("\n");
		}
		bw.flush();
	}
}
