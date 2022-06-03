package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 블록이동하기 {

	private static int[][] map;
	private static int n;
	private static boolean[][][][] visited;
	
	static class pos {
		int x;
		int y;
		
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Robot {
		pos left;
		pos right;
		int cnt;
		int dir;

		public Robot(pos left, pos right, int cnt, int dir) {
			this.left = left;
			this.right = right;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
	
	private static boolean check(Robot robot) {
		if ((robot.left.x == n - 1 && robot.left.y == n - 1) || (robot.right.x == n - 1 && robot.right.y == n - 1))
			return true;
		return false;
	}
	
	private static boolean isRange(int y, int x) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}

	private static int bfs() {
		Queue<Robot> q = new LinkedList<Robot>();
		pos left = new pos(0, 0);
		pos right = new pos(1, 0);
		q.add(new Robot(left, right, 0, 0));

		while (!q.isEmpty()) {
			Robot robot = q.poll();
			
			if(check(robot))
				return robot.cnt;
			
			if(visited[robot.right.y][robot.right.x][robot.left.y][robot.left.x])
				continue;
			visited[robot.right.y][robot.right.x][robot.left.y][robot.left.x] = true;
			
			int lx = robot.left.x;
			int ly = robot.left.y;
			int rx = robot.right.x;
			int ry = robot.right.y;
			
			if (robot.dir == 0) {		// 가로
				if (isRange(ry, rx + 1) && map[ry][rx + 1] == 0) {
					pos moved_left = new pos(rx, ry);
					pos moved_right = new pos(rx + 1, ry);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 0));
				}
				
				if(isRange(ly,lx - 1) && map[ly][lx - 1] == 0) {
					pos moved_left = new pos(lx - 1, ly);
					pos moved_right = new pos(lx, ry);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 0));
				}
				
				if (isRange(ry + 1, rx) && map[ry + 1][rx] == 0 && map[ry + 1][rx - 1] == 0) {
					pos moved_left = new pos(rx - 1, ry + 1);
					pos moved_right = new pos(rx, ry + 1);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 0));
				}
				
				if(isRange(ry - 1,rx) && map[ry - 1][rx] == 0 && map[ry - 1][rx - 1] == 0) {
					pos moved_left = new pos(rx - 1, ry - 1);
					pos moved_right = new pos(rx, ry - 1);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 0));
				}
				
				// 오른쪽 축
				if (isRange(ry + 1, rx) && isRange(ry + 1, rx - 1) && map[ry + 1][rx - 1] == 0
						&& map[ry + 1][rx] == 0) {
					pos moved_left = new pos(rx, ry);
					pos moved_right = new pos(rx, ry + 1);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 1));
				}
				
				if (isRange(ry - 1, rx) && isRange(ry - 1, rx - 1) && map[ry - 1][rx] == 0
						&& map[ry - 1][rx - 1] == 0) {
					pos moved_left = new pos(rx, ry - 1);
					pos moved_right = new pos(rx, ry);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 1));
				}
				
				// 왼쪽 축
				if (isRange(ry - 1, rx) && isRange(ry - 1, rx - 1) && map[ry - 1][rx] == 0
						&& map[ry - 1][rx - 1] == 0) {
					pos moved_left = new pos(rx - 1, ry - 1);
					pos moved_right = new pos(rx - 1, ry);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 1));
				}
				
				if (isRange(ry + 1, rx) && isRange(ry + 1, rx - 1) && map[ry + 1][rx] == 0
						&& map[ry + 1][rx - 1] == 0) {
					pos moved_left = new pos(rx - 1, ry);
					pos moved_right = new pos(rx - 1, ry + 1);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 1));
				}
				
			} else {			// 세로
				if (isRange(ry + 1, rx) && map[ry + 1][rx] == 0) {
					pos moved_left = new pos(rx, ry);
					pos moved_right = new pos(rx, ry + 1);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 1));
				}
				
				if (isRange(ly - 1, lx) && map[ly - 1][lx] == 0) {
					pos moved_left = new pos(lx, ly - 1);
					pos moved_right = new pos(lx,ly);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 1));
				}
				
				if (isRange(ry - 1,rx + 1) && isRange(ry, rx + 1) && map[ry - 1][rx + 1] == 0 && map[ry][rx + 1] == 0) {
					pos moved_left = new pos(rx + 1, ry - 1);
					pos moved_right = new pos(rx + 1, ry);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 1));
				}
				
				if (isRange(ry,rx - 1) && isRange(ry, rx - 1) && map[ry][rx - 1] == 0 && map[ry - 1][rx - 1] == 0) {
					pos moved_left = new pos(rx - 1, ry - 1);
					pos moved_right = new pos(rx - 1, ry);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 1));
				}
				
				// 오른쪽 축
				if (isRange(ry - 1, rx - 1) && isRange(ry, rx - 1) && map[ry - 1][rx - 1] == 0
						&& map[ry][rx - 1] == 0) {
					pos moved_left = new pos(rx - 1, ry);
					pos moved_right = new pos(rx, ry);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 0));
				}

				if (isRange(ry - 1, rx + 1) && isRange(ry, rx + 1) && map[ry - 1][rx + 1] == 0
						&& map[ry][rx + 1] == 0) {
					pos moved_left = new pos(rx, ry);
					pos moved_right = new pos(rx + 1, ry);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 0));
				}
				
				// 왼쪽 축
				if (isRange(ry, rx + 1) && isRange(ry - 1, rx + 1) && map[ry][rx + 1] == 0
						&& map[ry - 1][rx + 1] == 0) {
					pos moved_left = new pos(rx, ry - 1);
					pos moved_right = new pos(rx + 1, ry - 1);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 0));
				}

				if (isRange(ry - 1, rx - 1) && isRange(ry, rx - 1) && map[ry - 1][rx - 1] == 0
						&& map[ry][rx - 1] == 0) {
					pos moved_left = new pos(rx - 1, ry - 1);
					pos moved_right = new pos(rx, ry - 1);
					q.add(new Robot(moved_left, moved_right, robot.cnt + 1, 0));
				}
			}
		}
		return 0;
	}
	
	public static int solution(int[][] board) {
		n = board.length;
		map = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				map[i][j] = board[i][j];
		visited = new boolean[n][n][n][n];
		int ans = bfs();
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(map));
	}
}
