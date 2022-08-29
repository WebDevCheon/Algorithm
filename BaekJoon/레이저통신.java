package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 레이저통신 {

	private static char[][] map;
	private static int[][] visited;
	private static int n;
	private static int m;
	private static pos start;
	private static pos dest;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static int ans = Integer.MAX_VALUE;
	
	static class pos {
		int x;
		int y;
		int cnt;
		int dir;
		
		public pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	private static int bfs(pos start) {
		Queue<pos> q = new LinkedList<pos>();
		for(int i = 0;i < dx.length;i++) {
			pos p = new pos(start.x,start.y);
			p.dir = i;
			q.add(p);
		}
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			if(p.x == dest.x && p.y == dest.y)
				ans = Math.min(p.cnt, ans);
			
			for(int i = 0;i < dx.length;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(!isRange(ny,nx) || map[ny][nx] == '*')
					continue;
				int ncnt = p.cnt;
				
				if(i != p.dir)
					ncnt++;
				if(visited[ny][nx] < ncnt)
					continue;
				visited[ny][nx] = ncnt;
				pos nextPos = new pos(nx,ny);
				nextPos.dir = i;
				nextPos.cnt = ncnt;
				q.add(nextPos);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new int[n][m];
		for(int i = 0;i < n;i++)
			for(int j = 0;j < m;j++)
				visited[i][j] = Integer.MAX_VALUE;
		
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			for(int j = 0;j < m;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'C') {
					if(start == null)
						start = new pos(j,i);
					else if(dest == null)
						dest = new pos(j,i);
				}					
			}
		}
		System.out.println(bfs(start));
	}
}
