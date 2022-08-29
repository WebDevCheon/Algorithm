package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 가장가까운공통조상 {

	private static ArrayList<Integer>[] rel;
	private static boolean[] visited;
	private static int ans;
	
	private static void dfs(int v) {
		if(visited[v]) {
			ans = v;
			return;
		}
		visited[v] = true;
		
		for(int i = 0;i < rel[v].size();i++) {
			int next = rel[v].get(i);
			dfs(next);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			int m = Integer.parseInt(br.readLine());
			rel = new ArrayList[m + 1];
			visited = new boolean[m + 1];
			ans = -1;
			rel = new ArrayList[m + 1];
			for(int i = 1;i < m + 1;i++)
				rel[i] = new ArrayList<Integer>();
			for(int i = 0;i < m - 1;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				rel[v2].add(v1);
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			dfs(v1);
			dfs(v2);
			bw.write(ans + "\n");
		}
		bw.flush();
	}
}
