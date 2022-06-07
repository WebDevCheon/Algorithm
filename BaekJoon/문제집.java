package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 문제집 {
	
	private static ArrayList<Integer>[] rel;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		rel = new ArrayList[n + 1];
		for(int i = 1;i < n + 1;i++)
			rel[i] = new ArrayList<Integer>();
		int[] inDegree = new int[n + 1];
		
		for(int i = 1;i < m + 1;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			inDegree[v2]++;
			rel[v1].add(v2);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Queue<Integer> ans = new LinkedList<Integer>();
		
		for(int i = 1;i < n + 1;i++) {
			if(inDegree[i] == 0)
				pq.add(i);
		}
		
		while(!pq.isEmpty()) {
			int p = pq.poll();

			for(int i = 0;i < rel[p].size();i++) {
				int next = rel[p].get(i);
				inDegree[next]--;
				if(inDegree[next] == 0)
					pq.add(next);
			}
			ans.add(p);
		}
		while(!ans.isEmpty())
			System.out.print(ans.poll() + " ");
	}
}
