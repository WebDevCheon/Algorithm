package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 가장먼노드 {
	
	private static ArrayList<Integer>[] edge;
	private static boolean[] visited;
	private static int n;
	private static int max;
	private static int[] dist;
	
	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		visited[v] = true;
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int i = 0;i < edge[p].size();i++) {
				int next = edge[p].get(i);
				if(!visited[next]) {
					dist[next] = dist[p] + 1;
					max = Math.max(dist[next],max);
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		dist = new int[n + 1];
		int tmp = m;
		edge = new ArrayList[n + 1];
		for(int i = 1;i < n + 1;i++)
			edge[i] = new ArrayList<Integer>();
		while(tmp-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edge[a].add(b);
			edge[b].add(a);
		}
		bfs(1);
		int ans = 0;
		for(int i = 1;i <= n;i++) {
			if(max == dist[i])
				ans++;
		}
		System.out.println(ans);
	}
}
