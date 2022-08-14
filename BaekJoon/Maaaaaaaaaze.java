package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maaaaaaaaaze {

	private static int n = 5;
	private static boolean[][][] visited; // z,y,x
	private static int[] dx = { 1, 0, -1, 0, 0, 0 };
	private static int[] dy = { 0, 1, 0, -1, 0, 0 };
	private static int[] dz = { 0, 0, 0, 0, 1, -1 };
	private static int[][][] map;
	private static int[][][] decisionMap;
	private static int[] high;
	private static boolean[] high_visited;
	private static int[] a;
	private static int ans = Integer.MAX_VALUE;

	static class pos {
		int x;
		int y;
		int z;
		int cnt;

		public pos(int x, int y, int z, int cnt) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.cnt = cnt;
		}
	}
	
	private static boolean isRange(int z, int y, int x) {
		return (x >= 0 && x < n && y >= 0 && y < n && z >= 0 && z < n) ? true : false;
	}
	
	private static void make_high(int idx) {
		if(idx == n) {
			for(int i = 0;i < n;i++)
				decisionMap[i] = map[high[i]];			// 정해진 블록
			int[][][] tmp = new int[n][n][n];
			for (int i = 0; i < n; i++) {
				int[][] tmpMap = rotate(decisionMap[i], a[i]);
				tmp[i] = tmpMap;
			}
			ans = Math.min(bfs(tmp), ans);
			return;
		}
		
		for(int i = 0;i < n;i++) {
			if(high_visited[i])
				continue;
			high[idx] = i;
			high_visited[i] = true;
			make_high(idx + 1);
			high_visited[i] = false;
		}
	}
	
	private static void next_permutation(int idx) {
		if (idx == n) {
			make_high(0);			// 블록 마음대로 쌓기
			return;
		}

		for (int i = 0; i < 4; i++) {
			a[idx] = i;
			next_permutation(idx + 1);
		}
	}

	private static int[][] rotate(int[][] arr, int rot) {
		int[][] tmp = new int[n][n];
		
		if(rot == 0) {
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					tmp[i][j] = arr[i][j];
		} else if (rot == 1) { // 270
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					tmp[i][j] = arr[j][n - 1 - i];

		} else if (rot == 2) { // 180
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					tmp[i][j] = arr[n - 1 - i][n - 1 - j];

		} else if (rot == 3) { // 90
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					tmp[i][j] = arr[n - 1 - j][i];
		}
		return tmp;
	}

	private static int bfs(int[][][] map) {
		Queue<pos> q = new LinkedList<pos>();
		if(map[0][0][0] == 0)
			return Integer.MAX_VALUE;
		q.add(new pos(0, 0, 0, 0));
		visited = new boolean[n][n][n];
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			pos p = q.poll();
			
			if (p.x == n - 1 && p.y == n - 1 && p.z == n - 1)
				return p.cnt;

			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nz = p.z + dz[i];

				if (!isRange(nz, ny, nx) || visited[nz][ny][nx] || map[nz][ny][nx] == 0)
					continue;
				visited[nz][ny][nx] = true;
				q.add(new pos(nx, ny, nz, p.cnt + 1));
			}
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		map = new int[n][n][n];
		decisionMap = new int[n][n][n];
		high = new int[n];		// 순열로 판의 높이 정해주기
		high_visited = new boolean[n]; // 순열로 판의 높이 정할때 visited 배열
		a = new int[n];		// 각 높이의 판마다 90도 ~ 270도 회전 정해주는 배열
		for (int z = 0; z < n; z++) {
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					map[z][i][j] = Integer.parseInt(st.nextToken());
			}
		}
		next_permutation(0);
		if (ans != Integer.MAX_VALUE)
			bw.write(ans + "\n");
		else
			bw.write(-1 + "\n");
		bw.flush();
	}
}
