package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 로봇시뮬레이션 {

	private static int[][] map;
	private static int n;
	private static int m;
	private static pos[] posArr;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	
	static class pos {
		int x;
		int y;
		int dir;
		
		public pos(int x,int y,int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		boolean crash = false;
		posArr = new pos[a + 1];
		
		for(int i = 1;i < a + 1;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = (n - 1) - (Integer.parseInt(st.nextToken()) - 1);
			char chdir = st.nextToken().charAt(0);
			
			int dir = -1;
			
			if(chdir == 'E')
				dir = 0;
			else if(chdir == 'S')
				dir = 1;
			else if(chdir == 'W')
				dir = 2;
			else
				dir = 3;
			
			posArr[i] = new pos(x,y,dir);
			map[y][x] = i;
		}
		
		for(int i = 0;i < b;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			char chdir = st.nextToken().charAt(0);
			int len = Integer.parseInt(st.nextToken());
			
			int x = posArr[num].x;
			int y = posArr[num].y;
			int dir = posArr[num].dir;
			boolean chDir = false;
			
			if(chdir == 'L') {
				for(int k = 0;k < len;k++) {
					dir--;
					if(dir < 0)
						dir = dx.length - 1;
				}
				chDir = true;
			} else if(chdir == 'R') {
				for(int k = 0;k < len;k++) {
					dir++;
					if(dir == 4)
						dir = 0;
				}
				chDir = true;
			}
			
			if(chDir) {
				pos p = posArr[num];
				p.dir = dir;
				continue;
			}
			
			int nx = x;
			int ny = y;
			int cnt = 0;
			
			while(cnt < len) {
				nx += dx[dir];
				ny += dy[dir];

				if(!isRange(ny,nx)) {
					bw.write("Robot " + num + " crashes into the wall");
					crash = true;
					break;
				} else if(map[ny][nx] > 0) {
					bw.write("Robot " + num + " crashes into robot " + map[ny][nx]);
					crash = true;
					break;
				}
				cnt++;
			}
			if(crash)
				break;
			map[y][x] = 0;
			map[ny][nx] = num;
		
			pos p = posArr[num];
			
			p.y = ny;
			p.x = nx;
			p.dir = dir;
			
		}
		if(!crash)
			bw.write("OK");
		bw.flush();
	}
}
