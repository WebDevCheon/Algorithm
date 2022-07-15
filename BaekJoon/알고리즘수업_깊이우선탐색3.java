package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 알고리즘수업_깊이우선탐색3 {

	private static int n;
	private static int m;
	private static int start;
	private static ArrayList<Integer>[] rel;
	private static boolean[] visited;
	private static int[] depth;
	
	private static void dfs(int v,int cnt) {
		if(visited[v])
			return;
		visited[v] = true;
		depth[v] = cnt;
		
		for(int i = 0;i < rel[v].size();i++) {
			int next = rel[v].get(i);
			dfs(next,cnt + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		rel = new ArrayList[n + 1];
		depth = new int[n + 1];
		Arrays.fill(depth,-1);
		for(int i = 1;i < n + 1;i++)
			rel[i] = new ArrayList<Integer>();
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			rel[v1].add(v2);
			rel[v2].add(v1);
		}
		
		for(int i = 1;i <= n;i++)
			Collections.sort(rel[i]);
		
		dfs(start,0);
		for(int i = 1;i < n + 1;i++)
			System.out.println(depth[i]);
	}
}
