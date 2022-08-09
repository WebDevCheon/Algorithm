package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 우수마을 {
	
	private static int n;
	private static int[] p;
	private static ArrayList<Integer>[] rel;
	private static int[][] dp;		
	private static boolean[] visited;
	
	private static void dfs(int v) {
		dp[v][0] = 0;
		dp[v][1] += p[v];
		
		for(int i = 0;i < rel[v].size();i++) {
			int next = rel[v].get(i);
			if(!visited[next]) {
				visited[next] = true;
				dfs(next);
				dp[v][0] += Math.max(dp[next][0],dp[next][1]);
				dp[v][1] += dp[next][0];
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		rel = new ArrayList[n + 1];
		for(int i = 1;i <= n;i++)
			rel[i] = new ArrayList<Integer>();
		p = new int[n + 1];
		dp = new int[n + 1][2];
		visited = new boolean[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n;i++)
			p[i] = Integer.parseInt(st.nextToken());
		for(int i = 0;i < n - 1;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			rel[v1].add(v2);
			rel[v2].add(v1);
		}
		visited[1] = true;
		dfs(1);
		System.out.println(Math.max(dp[1][0],dp[1][1]));
	}
}
