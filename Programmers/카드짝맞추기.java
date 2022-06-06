package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 카드짝맞추기 {
	
	private static int[][] map = new int[4][4];
	private static int[] pick;
	private static int n = 4;
	private static int ans = Integer.MAX_VALUE;
	private static boolean[] visited;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static ArrayList<pos>[] posList = new ArrayList[8];
	private static int tmp = Integer.MAX_VALUE;
	
	static class pos {
		int x;
		int y;
		int dist;
		
		public pos(int x,int y,int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
	
	private static pos findCtrl(int y,int x,int dir,pos pickPos,int[][] board) {
		int nx = x;
		int ny = y;
		
		while(true) {
			nx += dx[dir];
			ny += dy[dir];
			
			if(!isRange(ny,nx))
				return new pos(nx - dx[dir],ny - dy[dir], -1);
			
			if((ny == pickPos.y && nx == pickPos.x) || board[ny][nx] > 0)
				return new pos(nx,ny,-1);
		}
	}
	
	private static pos findChar(int y,int x,pos pickPos,int[][] board) {
		if(y == pickPos.y && x == pickPos.x)
			return new pos(x,y,0);
		boolean[][] visited = new boolean[n][n];
		Queue<pos> q = new LinkedList<pos>();
		q.add(new pos(x,y,0));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			
			if(p.y == pickPos.y && p.x == pickPos.x)
				return p;
			
			for(int i = 0;i < 8;i++) {
				if(i >= 4) {
					int dir =  i % 4;
					pos ctrlPos = findCtrl(p.y,p.x,dir,pickPos,board);
					if(visited[ctrlPos.y][ctrlPos.x])
						continue;
					visited[ctrlPos.y][ctrlPos.x] = true;
					q.add(new pos(ctrlPos.x,ctrlPos.y,p.dist + 1));
				} else {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if(!isRange(ny,nx) || visited[ny][nx])
						continue;
					visited[ny][nx] = true;
					q.add(new pos(nx,ny,p.dist + 1));
				}
			}
		}
		return null;
	}
	
	private static pos[] pick_bfs;
	
	private static void pick_dfs(int idx,int cnt,int sy,int sx,int[][] board) {
		if(idx == cnt) {
			int s = 0;
			int k = 0;
			
			while(s < cnt) {
				pos p1 = findChar(sy,sx,pick_bfs[s],board);
				k += p1.dist;
				board[p1.y][p1.x] = 0;
				pos p2 = findChar(p1.y,p1.x,pick_bfs[s + 1],board);
				k += p2.dist;
				board[p2.y][p2.x] = 0;
				sy = p2.y;
				sx = p2.x;
				s += 2;
			}
			tmp = Math.min(k,tmp);
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < n;j++)
					board[i][j] = map[i][j];
			}
			return;
		}
		
		if(idx / 2 == 0) {
			pick_bfs[idx] = posList[pick[idx / 2]].get(0);
			pick_bfs[idx + 1] = posList[pick[idx / 2]].get(1);
			pick_dfs(idx + 2,cnt,sy,sx,board);
			pick_bfs[idx] = posList[pick[idx / 2]].get(1);
			pick_bfs[idx + 1] = posList[pick[idx / 2]].get(0);
			pick_dfs(idx + 2,cnt,sy,sx,board);
		} else if(idx / 2 == 1) {
			pick_bfs[idx] = posList[pick[idx / 2]].get(0);
			pick_bfs[idx + 1] = posList[pick[idx / 2]].get(1);
			pick_dfs(idx + 2,cnt,sy,sx,board);
			pick_bfs[idx] = posList[pick[idx / 2]].get(1);
			pick_bfs[idx + 1] = posList[pick[idx / 2]].get(0);
			pick_dfs(idx + 2,cnt,sy,sx,board);
		} else if(idx / 2 == 2) {
			pick_bfs[idx] = posList[pick[idx / 2]].get(0);
			pick_bfs[idx + 1] = posList[pick[idx / 2]].get(1);
			pick_dfs(idx + 2,cnt,sy,sx,board);
			pick_bfs[idx] = posList[pick[idx / 2]].get(1);
			pick_bfs[idx + 1] = posList[pick[idx / 2]].get(0);
			pick_dfs(idx + 2,cnt,sy,sx,board);
		} else if(idx / 2 == 3) {
			pick_bfs[idx] = posList[pick[idx / 2]].get(0);
			pick_bfs[idx + 1] = posList[pick[idx / 2]].get(1);
			pick_dfs(idx + 2,cnt,sy,sx,board);
			pick_bfs[idx] = posList[pick[idx / 2]].get(1);
			pick_bfs[idx + 1] = posList[pick[idx / 2]].get(0);
			pick_dfs(idx + 2,cnt,sy,sx,board);
		} else if(idx / 2 == 4) {
			pick_bfs[idx] = posList[pick[idx / 2]].get(0);
			pick_bfs[idx + 1] = posList[pick[idx / 2]].get(1);
			pick_dfs(idx + 2,cnt,sy,sx,board);
			pick_bfs[idx] = posList[pick[idx / 2]].get(1);
			pick_bfs[idx + 1] = posList[pick[idx / 2]].get(0);
			pick_dfs(idx + 2,cnt,sy,sx,board);
		} else if(idx / 2 == 5) {
			pick_bfs[idx] = posList[pick[idx / 2]].get(0);
			pick_bfs[idx + 1] = posList[pick[idx / 2]].get(1);
			pick_dfs(idx + 2,cnt,sy,sx,board);
			pick_bfs[idx] = posList[pick[idx / 2]].get(1);
			pick_bfs[idx + 1] = posList[pick[idx / 2]].get(0);
			pick_dfs(idx + 2,cnt,sy,sx,board);
		}
	}
	
	private static int bfs(int y,int x,int cnt,int[][] board) {	
		int sy = y;
		int sx = x;
		pick_bfs = new pos[pick.length * 2];
		pick_dfs(0,pick.length * 2,sy,sx,board);
		return tmp;
	}
	
	private static void dfs(int idx,int cnt,int r,int c) {
		if(idx == cnt) {
			int[][] board = new int[n][n];
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < n;j++)
					board[i][j] = map[i][j];
			}
			bfs(r,c,cnt,board);
			ans = Math.min(tmp + cnt * 2,ans);
			return;
		}
		
		for(int i = 1;i <= cnt;i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			pick[idx] = i;
			dfs(idx + 1,cnt,r,c);
			visited[i] = false;
		}
	}

	public static int solution(int[][] board, int r, int c) {
		int cnt = 0;
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0;i < 8;i++)
			posList[i] = new ArrayList<pos>();
		
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n;j++) {
				map[i][j] = board[i][j];
				
				if(map[i][j] > 0)
					posList[map[i][j]].add(new pos(j,i,-1));
				
				if(board[i][j] > 0 && !set.contains(board[i][j])) {
					cnt++;
					set.add(board[i][j]);
				}
			}
		}
		pick = new int[cnt];
		visited = new boolean[cnt + 1];
		dfs(0,cnt,r,c);
		return ans;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] board = new int[n][n];
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < n;j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(board,r,c));
	}
}
