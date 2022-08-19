package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적인해킹 {

	private static int n;
	private static ArrayList<Integer>[] rel;
	private static int max;
	private static int[] cnt;
	private static boolean[] visited;
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			
			for(int i = 0;i < rel[v].size();i++) {
				int next = rel[v].get(i);
				if(visited[next])
					continue;
				visited[next] = true;
				cnt[next]++;
				q.add(next);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		rel = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		cnt = new int[n + 1];
		for(int i = 1;i <= n;i++)
			rel[i] = new ArrayList<Integer>();
		int m = Integer.parseInt(st.nextToken());
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			rel[v1].add(v2);
		}
		
		for(int i = 1;i <= n;i++) {
			visited = new boolean[n + 1];
			bfs(i);
		}
		
		for(int i = 1;i <= n;i++)
			max = Math.max(cnt[i], max);
		for(int i = 1; i <= n;i++) {
			if(max == cnt[i])
				bw.write(i + " ");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
