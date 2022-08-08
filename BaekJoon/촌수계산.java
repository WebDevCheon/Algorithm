package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 촌수계산 {

	private static int n;
	private static ArrayList<Integer>[] rel;
	private static boolean[] visited;
	private static int a;
	private static int b;
	private static boolean flag;
	
	private static int dfs(int v) {
		if(visited[v])
			return 0;
		visited[v] = true;
		
		if(v == b) {
			flag = true;
			return 0;
		}
		
		int sum = 0;
		
		for(int i = 0;i < rel[v].size();i++) {
			int next = rel[v].get(i);
			sum = dfs(next) + 1;
			if(flag)
				break;
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		rel = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for(int i = 1;i <= n;i++)
			rel[i] = new ArrayList<Integer>();
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			rel[a].add(b);
			rel[b].add(a);
		}
		int ans = dfs(a);
		
		if(flag)
			System.out.println(ans);
		else
			System.out.println(-1);
	}
}
