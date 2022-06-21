package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GPS {

	private static ArrayList<Integer>[] rel;
	private static int[] gps_log;
	private static int ans = Integer.MAX_VALUE;
	private static int[][] dp;		
	private static boolean[][] visited;
	
	private static int dfs(int v,int t,int k) {		
		if(visited[v][t])
			return dp[v][t];
		visited[v][t] = true;

		if(t == k) {
            if(gps_log[t] == v) {       
            	return 0;
            } else
            	return 1;
		}
		
		for(int i = 0;i < rel[v].size();i++) {		
			int next = rel[v].get(i);
            
			if(gps_log[t + 1] != next)
				dp[v][t] = Math.min(dfs(next,t + 1,k) + 1,dp[v][t]);
			else
				dp[v][t] = Math.min(dfs(next,t + 1, k),dp[v][t]);
		}
		if(gps_log[t + 1] == v)			
			dp[v][t] = Math.min(dfs(v,t + 1,k),dp[v][t]);
		return dp[v][t];
	}
	
	public static int solution(int n, int m, int[][] edge_list, int k, int[] log) {
		rel = new ArrayList[n + 1];
		for(int i = 1;i < n + 1;i++)
			rel[i] = new ArrayList<Integer>();
		for(int i = 0;i < m;i++) {
			int v1 = edge_list[i][0];
			int v2 = edge_list[i][1];
			rel[v1].add(v2);
			rel[v2].add(v1);
		}
		gps_log = new int[k + 1];
		for(int i = 1;i < k + 1;i++)
			gps_log[i] = log[i - 1];
		dp = new int[n + 1][k + 1];
		visited = new boolean[n + 1][k + 1];
		for(int i = 1;i <= n;i++)
			Arrays.fill(dp[i],Integer.MAX_VALUE);
		dfs(gps_log[1],1,k);
        
        if(ans != Integer.MAX_VALUE)
		    return ans;
        else
            return -1;
    }	



}
