package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE {

	private static int n;
	private static ArrayList<Integer>[] rel;
	private static boolean[] visited;
	private static boolean flag;
	
	private static void dfs(int v,int cnt) {
		if(cnt >= 4) {
			flag = true;
			return;
		}
		
		for(int i = 0;i < rel[v].size();i++) {
			int next = rel[v].get(i);
			if(!visited[next]) {
				visited[next] = true;
				dfs(next,cnt + 1);
				visited[next] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		rel = new ArrayList[n];
		visited = new boolean[n];
		for(int i = 0;i < n;i++)
			rel[i] = new ArrayList<Integer>();
		int m = Integer.parseInt(st.nextToken());
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			rel[a].add(b);
			rel[b].add(a);
		}
		for(int i = 0;i < n;i++) {
			visited[i] = true;
			dfs(i,0);
			visited[i] = false;
			if(flag)
				break;
		}
		if(flag)
			System.out.println(1);
		else
			System.out.println(0);
	}
}
