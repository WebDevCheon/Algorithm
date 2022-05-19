package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GPS {

	private static int n;
	private static int m;
	private static ArrayList<Integer>[] edge_list;
	private static int k;
	private static int[] gps_log;
	private static int ans = Integer.MAX_VALUE;
	
	private static void insertEdge(int a,int b) {
		edge_list[a].add(b); edge_list[b].add(a);
	}
	
	private static void dfs(int time,int cnt) {
		if(time == k) {
			ans = Math.min(cnt,ans);
			return;
		}
		
		int now = gps_log[time];
		boolean flag = false;
		List<Integer> nextlist = new ArrayList<Integer>();
		for(int i = 0;i < edge_list[now].size();i++) {
			int next = edge_list[now].get(i);
			nextlist.add(next);
			if(next == gps_log[time + 1] || now == gps_log[time + 1]) {
				flag = true;
				break;
			}
		}
		if(flag)
			dfs(time + 1,cnt);
		else {			// gps 오류난 곳 처리
			if(time + 1 == k)
				return;
			for(int i = 0;i < nextlist.size();i++) {
				int next = nextlist.get(i);
				for(int j = 0;j < edge_list[next].size();j++) {
					int tmpnext = edge_list[next].get(j);
					if(tmpnext == gps_log[time + 1])
						dfs(time + 1,cnt + 1);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		edge_list = new ArrayList[n + 1];
		gps_log = new int[k + 1];
		for(int i = 1;i < n + 1;i++)
			edge_list[i] = new ArrayList<Integer>();
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			insertEdge(a,b);
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i < k + 1;i++) {
			gps_log[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1,0);
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}
