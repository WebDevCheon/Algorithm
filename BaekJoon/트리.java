package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리 {
	
	private static ArrayList<Integer>[] rel;
	private static int n;
	private static int ans;
	private static boolean[] visited;
	
	private static void dfs(int v,int removed) {
		if(v == removed)
			return;
		
		if(rel[v].size() == 0) {
			ans++;
			return;
		}
		
		for(int i = 0;i < rel[v].size();i++) {
			int next = rel[v].get(i);
			if(!visited[next]) {
				visited[next] = true;
				dfs(next,removed);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		rel = new ArrayList[n];
		for(int i = 0;i < n;i++)
			rel[i] = new ArrayList<Integer>();
		for(int i = 0;i < n;i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1)
				continue;
			rel[parent].add(i);
		}
		int removed = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		dfs(0,removed);
		System.out.println(ans);
	}
}
