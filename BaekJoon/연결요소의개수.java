package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수 {

	private static int ans;
	private static int n;
	private static ArrayList<Integer>[] rel;
	private static boolean[] visited;
	
	private static void dfs(int v) {
		if(visited[v])
			return;
		visited[v] = true;
		
		for(int next : rel[v]) 
			dfs(next);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		rel = new ArrayList[n + 1];
		for(int i = 1;i <= n;i++)
			rel[i] = new ArrayList<Integer>();
		visited = new boolean[n + 1];
		int m = Integer.parseInt(st.nextToken());
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			rel[v1].add(v2);
			rel[v2].add(v1);
		}
		for(int i = 1;i <= n;i++) {
			if(!visited[i]) {
				ans++;
				dfs(i);
			}
		}
		System.out.println(ans);
	}
}
