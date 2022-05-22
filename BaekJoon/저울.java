package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 저울 {
	
	private static int n;
	private static int m;
	private static ArrayList<Integer>[] rel;
	private static int[] ans;
	private static boolean[][] visited;
	private static boolean[] canGo;
	
	private static void dfs(int v,int start) {
		if(canGo[v])
			return;
		canGo[v] = true;
		
		for(int i = 0;i < rel[v].size();i++) {
			int next = rel[v].get(i);
			if(!visited[start][next]) {
				ans[start]--;
				ans[next]--;
				visited[start][next] = true;
			}
			dfs(next,start);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		ans = new int[n + 1];
		rel = new ArrayList[n + 1];
		for(int i = 1;i < n + 1;i++)
			rel[i] = new ArrayList<Integer>();
		for(int i = 1;i < n + 1;i++)
			ans[i] = n - 1;
		
		for(int i = 0;i < m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			rel[v1].add(v2);
		}
		visited = new boolean[n + 1][n + 1];
		for(int i = 1;i <= n;i++) {
			canGo = new boolean[n + 1];
			dfs(i,i);
		}
		for(int i = 1;i <= n;i++)
			System.out.println(ans[i]);
	}
}
