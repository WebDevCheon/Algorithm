package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범빌딩 {

	private static char[][][] map;
	private static int f;
	private static int r;
	private static int c;
	private static int[] dx = { 1, 0, -1, 0, 0, 0 };
	private static int[] dy = { 0, 1, 0, -1, 0, 0 };
	private static int[] dz = { 0, 0, 0, 0, 1, -1 };
	private static pos start;
	private static pos end;

	static class pos {
		int x;
		int y;
		int z;
		int dist;

		public pos(int x, int y, int z, int dist) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.dist = dist;
		}
	}

	private static boolean isRange(int z, int y, int x) {
		return (x >= 0 && x < c && y >= 0 && y < r && z >= 0 && z < f);
	}

	private static int bfs(int z, int y, int x) {
		Queue<pos> q = new LinkedList<pos>();
		boolean[][][] visited = new boolean[f][r][c];
		q.add(new pos(x, y, z, 0));
		visited[z][y][x] = true;
		int ans = -1;

		while (!q.isEmpty()) {
			pos p = q.poll();

			if (p.z == end.z && p.y == end.y && p.x == end.x) {
				ans = p.dist;
				return ans;
			}

			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nz = p.z + dz[i];

				if (!isRange(nz, ny, nx) || map[nz][ny][nx] == '#' || visited[nz][ny][nx])
					continue;
				visited[nz][ny][nx] = true;
				q.add(new pos(nx, ny, nz, p.dist + 1));
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			f = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(f == 0 && r == 0 && c == 0)
				break;
			map = new char[f][r][c];
			int Floor = 0;
			
			while (Floor < f) {
				for (int i = 0; i < r; i++) {
					String str = br.readLine();
					for (int j = 0; j < c; j++) {
						map[Floor][i][j] = str.charAt(j);
						if (map[Floor][i][j] == 'S')
							start = new pos(j, i, Floor, 0);		
						else if (map[Floor][i][j] == 'E')
							end = new pos(j, i, Floor, 0);
					}
				}
				br.readLine();
				Floor++;
			}
			
			int ans = bfs(start.z, start.y, start.x);
			
			if (ans == -1)
				System.out.println("Trapped!");
			else
				System.out.println("Escaped in " + ans + " minute(s).");
		}
		
	}
}
