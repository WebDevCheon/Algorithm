package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 네트워크 {

	private static int[][] computer;
	private static int n;
	private static boolean[] visited;
	private static int ans;
	
	private static void dfs(int v) {
		if(visited[v])
			return;
		visited[v] = true;
		
		for(int i = 0;i < n;i++) {
			if(i == v)
				continue;
			if(!visited[i] && computer[v][i] == 1)
				dfs(i);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		computer = new int[n][n];
		visited = new boolean[n];
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j < n;j++) {
				computer[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0;i < n;i++) {
			if(!visited[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
}
