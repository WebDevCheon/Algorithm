package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {

	private static int[][] map;
	private static int dir;
	private static int nowX;
	private static int nowY;
	private static int n;
	private static int m;
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { -1, 0, 1, 0 };
	private static int ans;
	private static boolean[][] isClean;
	private static boolean End;

	private static boolean isRange(int y, int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}

	private static void simulation(int y, int x, int dir) {
		if (!isClean[y][x]) { // 후진을 하게 되면 청소를 했던 구역도 다시 해야하므로,반드시 한번 청소 했던 구역은 체크해놓기
			isClean[y][x] = true;
			ans++;
		}

		int cnt = 0;
		int nextMove = -1;

		while (cnt < 4) { 	// 청소하고나서 왼쪽으로 회전해서 빈 공간이 존재한다면 한칸 전진해서 1로 돌아감
			if (dir == 0)
				nextMove = 3;
			else if (dir == 1)
				nextMove = 0;
			else if (dir == 2)
				nextMove = 1;
			else
				nextMove = 2;

			int nx = x + dx[nextMove];
			int ny = y + dy[nextMove];

			if (!isRange(ny, nx) || map[ny][nx] == 1 || isClean[ny][nx]) {
				dir = nextMove;
				cnt++;
				continue;
			}
			simulation(ny, nx, nextMove);
			if (End)
				return;
			dir = nextMove;
			cnt++;
		}

		// 2-a번 연속으로 4번 실행
		nextMove = -1;

		if (dir == 0)
			nextMove = 2;
		else if (dir == 1)
			nextMove = 3;
		else if (dir == 2)
			nextMove = 0;
		else
			nextMove = 1;

		int nx = x + dx[nextMove];
		int ny = y + dy[nextMove];

		if (!isRange(ny, nx) || map[ny][nx] == 1) {
			End = true;
			return;
		}
		simulation(ny, nx, dir);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		isClean = new boolean[n][m];
		st = new StringTokenizer(br.readLine());
		nowY = Integer.parseInt(st.nextToken());
		nowX = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		simulation(nowY, nowX, dir);
		System.out.println(ans);
	}
}
