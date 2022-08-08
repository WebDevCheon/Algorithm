package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 상근이의여행 {

	private static ArrayList<Integer>[] rel;
	private static boolean[] visited;
	private static int n;
	private static int k;
	private static int ans;
	
	private static void dfs(int v) {
		if(visited[v])
			return;
		visited[v] = true;
		n--;
		k++;
		if(n == 0) {
			ans = Math.min(k,ans);
			return;
		}
		
		for(int i = 0;i < rel[v].size();i++) {
			int next = rel[v].get(i);
			dfs(next);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = Integer.MAX_VALUE;
			n = Integer.parseInt(st.nextToken());
			k = 0;
			rel = new ArrayList[n + 1];
			visited = new boolean[n + 1];
			for(int i = 1;i <= n;i++)
				rel[i] = new ArrayList<Integer>();
			int m = Integer.parseInt(st.nextToken());
			
			for(int i = 0;i < m;i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				rel[v1].add(v2);
				rel[v2].add(v1);
			}
			dfs(1);
			System.out.println(ans - 1);
		}
		
	}
}
