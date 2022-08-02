package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
	
	private static ArrayList<Integer>[] rel;
	private static int[] ans;
	private static boolean[] visited;
	private static int n;
	
	private static void dfs(int v,int parent) {
		if(visited[v])
			return;
		visited[v] = true;
		if(v != -1)
			ans[v] = parent;
		
		for(int i = 0;i < rel[v].size();i++) {
			int next = rel[v].get(i);
			dfs(next,v);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ans = new int[n + 1];
		visited = new boolean[n + 1];
		rel = new ArrayList[n + 1];
		for(int i = 1;i <= n;i++)
			rel[i] = new ArrayList<Integer>();
		
		for(int i = 0;i < n - 1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			rel[v1].add(v2);
			rel[v2].add(v1);
		}
		dfs(1,-1);
		for(int i = 2;i <= n;i++)
			System.out.println(ans[i]);
	}
}
