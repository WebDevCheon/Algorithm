package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 회사문화1 {

	private static ArrayList<Integer>[] rel;
	private static int n;
	private static int[] w;
	private static int[] ans;
	
	private static void dfs(int v,int c) {
		ans[v] += c;
		
		for(int i = 0;i < rel[v].size();i++) {
			int next = rel[v].get(i);
			dfs(next,c + w[next]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		w = new int[n + 1];
		ans = new int[n + 1];
		int m = Integer.parseInt(st.nextToken());
		rel = new ArrayList[n + 1];
		for(int i = 1;i < n + 1;i++)
			rel[i] = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i < n + 1;i++) {
			if(i == 1) {
				st.nextToken();
				continue;
			}
			int up = Integer.parseInt(st.nextToken());
			rel[up].add(i);
		}
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			w[a] += c;
		}
		dfs(1,0);
		for(int i = 1;i <= n;i++)
			System.out.print(ans[i] + " ");
	}
}
