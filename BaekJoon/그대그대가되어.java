package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그대그대가되어 {		

	private static ArrayList<Integer>[] rel;
	private static boolean[] visited;
	
	static class pos {
		int num;
		int cnt;
		public pos(int num,int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	private static int bfs(int start,int dest) {
		Queue<pos> q = new LinkedList<pos>();
		q.add(new pos(start,0));
		visited[start] = true;
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			
			if(p.num == dest)
				return p.cnt;
			
			for(int i = 0;i < rel[p.num].size();i++) {
				int next = rel[p.num].get(i);
				if(visited[next])
					continue;
				visited[next] = true;
				q.add(new pos(next,p.cnt + 1));
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		rel = new ArrayList[n + 1];
		for(int i = 1;i <= n;i++)
			rel[i] = new ArrayList<Integer>();
		visited = new boolean[n + 1];
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			rel[v1].add(v2);
			rel[v2].add(v1);
		}
		int ans = bfs(a,b);
		System.out.println(ans);
	}
}
