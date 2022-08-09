package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class LCA {

	private static ArrayList<Integer>[] rel;
	private static boolean[] visited;
	private static int[] parent;
	private static int root = 1;
	
	private static void make_parent(int v,int before) {
		if(visited[v])
			return;
		visited[v] = true;
		if(v != root)
			parent[v] = before;
		
		for(int i = 0;i < rel[v].size();i++) {
			int next = rel[v].get(i);
			make_parent(next,v);
		}
	}
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		parent = new int[n + 1];
		rel = new ArrayList[n + 1];
		for(int i = 1;i <= n;i++)
			rel[i] = new ArrayList<Integer>();
		
		for(int i = 0;i < n - 1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			rel[v1].add(v2);
			rel[v2].add(v1);
		}
		make_parent(root,-1);
		int m = Integer.parseInt(br.readLine());
		for(int i = 0;i < m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			Set<Integer> parentSet = new HashSet<Integer>();
			while(v1 >= root) {
				parentSet.add(v1);
				v1 = parent[v1];
			}
			while(v2 >= root) {
				if(parentSet.contains(v2)) {
					bw.write(v2 + "\n");
					break;
				}
				v2 = parent[v2];
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
