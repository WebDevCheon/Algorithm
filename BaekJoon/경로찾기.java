package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 경로찾기 {

	private static int[][] ans;
	private static boolean[] visited;
	private static ArrayList<Integer>[] rel;
	private static int n;
	
	private static void dfs(int v,int start,int cnt) {
		if(cnt >= 2 && v == start) {
			ans[start][start] = 1;
			return;
		}
		if(visited[v])
			return;
		visited[v] = true;
		
		if(start != v)
			ans[start][v] = 1;
		
		for(int i = 0;i < rel[v].size();i++) {
			int next = rel[v].get(i);
			dfs(next,start,cnt + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ans = new int[n + 1][n + 1];
		rel = new ArrayList[n + 1];
		for(int i = 1;i <= n;i++)
			rel[i] = new ArrayList<Integer>();
		
		for(int i = 1;i < n + 1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1;j < n + 1;j++) {
				int k = Integer.parseInt(st.nextToken());
				if(k == 1)
					rel[i].add(j);
			}
		}
		
		for(int i = 1;i < n + 1;i++) {
			visited = new boolean[n + 1];
			dfs(i,i,0);
		}
		
		for(int i = 1;i < n + 1;i++) {
			for(int j = 1;j < n + 1;j++)
				System.out.print(ans[i][j] + " ");
			System.out.println();
		}
	}	
}
