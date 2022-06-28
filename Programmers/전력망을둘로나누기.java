package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 전력망을둘로나누기 {
	
	private static ArrayList<Integer>[] rel;
	private static int nodes;
	private static int ans = Integer.MAX_VALUE;
	private static boolean[] visited;
	
	private static void dfs(int v,int v2) {
		if(visited[v] || v == v2)
			return;
		visited[v] = true;
		nodes++;
		
		for(int i = 0;i < rel[v].size();i++) {
			int next = rel[v].get(i);
			dfs(next,v2);
		}
	}
	
	public static int solution(int n, int[][] wires) {
		rel = new ArrayList[n + 1];
		for(int i = 0;i < n + 1;i++)
			rel[i] = new ArrayList<Integer>();
		
		for(int i = 0;i < wires.length;i++) {
			int v1 = wires[i][0];
			int v2 = wires[i][1];
			rel[v1].add(v2);
			rel[v2].add(v1);
		}

		for(int i = 0;i < wires.length;i++) {
			int v1 = wires[i][0];
			int v2 = wires[i][1];
			visited = new boolean[n + 1];
			nodes = 0;
			dfs(v1,v2);
			int n1 = nodes;
			nodes = 0;
			dfs(v2,v1);
			int n2 = nodes;
			ans = Math.min(Math.abs(n1 - n2),ans);
		}
		return ans;
    }
}
