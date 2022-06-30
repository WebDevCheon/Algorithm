package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class 십자뒤집기 {

	private static Set<String> visited = new HashSet<String>();
	private static int n = 3;
	private static int m = 3;
	private static ArrayList<Integer>[] change = new ArrayList[9];
	private static int[] dx = {1,0,-1,0,0};
	private static int[] dy = {0,1,0,-1,0};
	
	static class data {
		String board;
		int cnt;
		public data(String board,int cnt) {
			this.board = board; this.cnt = cnt;
		}
	}
	
	private static void init() {
		for(int i = 0;i < 9;i++) {
			change[i] = new ArrayList<Integer>();
			int y = i / m;
			int x = i % m;
				
			for(int j = 0;j < dx.length;j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if(nx < 0 || nx >= m || ny < 0 || ny >= n)
					continue;
				int num = ny * n + nx;
				change[i].add(num);
			}
		}
	}
	
	private static int bfs(String board) {
		Queue<data> q = new LinkedList<data>();
		q.add(new data(board,0));
		visited.add(board);
		
		while(!q.isEmpty()) {
			data p = q.poll();
			if(p.board.equals("........."))
				return p.cnt;
			
			for(int i = 0;i < 9;i++) {
				StringBuilder sb = new StringBuilder(p.board);
				ArrayList<Integer> changeNums = change[i];
				
				for(int idx : changeNums) {
					if(sb.charAt(idx) == '*')
						sb.setCharAt(idx, '.');
					else
						sb.setCharAt(idx, '*');
				}
				if(visited.contains(sb.toString()))
					continue;
				visited.add(sb.toString());
				q.add(new data(sb.toString(),p.cnt + 1));
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k = Integer.parseInt(br.readLine());
		init();
		
		while(k-- > 0) {
			String tmp = "";
			visited = new HashSet<String>();
			for(int i = 0;i < n;i++) {
				String str = br.readLine();
				for(int j = 0;j < m;j++)
					tmp += str.charAt(j);
			}
			int ans = bfs(tmp);
			bw.write(ans + "\n");
		}
		bw.flush();
	}
}
