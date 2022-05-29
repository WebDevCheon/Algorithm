package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {		
	
	private static int sx;
	private static int sy;
	private static int size = 2;
	private static int eat;
	private static int[][] map;
	private static int[][] dist;
	private static int n;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static boolean[][] visited;
	
	static class pos implements Comparable<pos> {
		int x;
		int y;
		
		public pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(pos otherFish) {
			if(dist[this.y][this.x] < dist[otherFish.y][otherFish.x])
				return -1;
			else if(dist[this.y][this.x] > dist[otherFish.y][otherFish.x])
				return 1;
			else {
				if(this.y < otherFish.y)
					return -1;
				else if(this.y > otherFish.y)
					return 1;
				else {
					if(this.x < otherFish.x)
						return -1;
					else if(this.x > otherFish.x)
						return 1;
					else
						return 0;
				}
			}
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
	
	private static int bfs(int y,int x) {
		Queue<pos> q = new LinkedList<pos>();
		q.add(new pos(x,y));
		visited[y][x] = true;
		ArrayList<pos> eatenFish = new ArrayList<pos>();
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			
			for(int i = 0;i < dx.length;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(!isRange(ny,nx) || map[ny][nx] > size || visited[ny][nx])
					continue;
				visited[ny][nx] = true;
				dist[ny][nx] = dist[p.y][p.x] + 1;
				q.add(new pos(nx,ny));
				if(map[ny][nx] > 0 && map[ny][nx] < size)
					eatenFish.add(new pos(nx,ny));
			}
		}
		if(eatenFish.size() == 0)
			return 0;
		Collections.sort(eatenFish);
		pos fish = eatenFish.get(0);
		map[fish.y][fish.x] = 0;
		map[sy][sx] = 0;
		sy = fish.y;
		sx = fish.x;
		eat++;
		if(eat == size) {
			size++;
			eat = 0;
		}
		return dist[sy][sx];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j < n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sx = j;
					sy = i;
				}
			}
		}
		
		int ans = 0;
		while(true) {
			visited = new boolean[n][n];
			dist = new int[n][n];
			int time = bfs(sy,sx);
			if(time == 0)
				break;
			ans += time;
		}
		System.out.println(ans);
	}
}
