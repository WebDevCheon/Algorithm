package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티 {

	private static int n;
	private static int m;
	private static int x;
	private static ArrayList<ArrayList<Node>> rel = new ArrayList<ArrayList<Node>>();
	private static int[] d;
	private static int ans = Integer.MIN_VALUE;
	private static int MAX = 1000000000;
	
	static class Node implements Comparable<Node> {
		int num;
		int dist;
		public Node(int num,int dist) {
			this.num = num; this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			if(this.dist < o.dist)
				return -1;
			return 1;
		}
	}
	
	private static int dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		d[start] = 0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int num = node.num;
			int dist = node.dist;
			
			if(d[num] < dist)
				continue;
			
			for(int i = 0;i < rel.get(num).size();i++) {
				int cost = d[num] + rel.get(num).get(i).dist;
				if(cost < d[rel.get(num).get(i).num]) {
					d[rel.get(num).get(i).num] = cost;
					pq.add(new Node(rel.get(num).get(i).num,cost));
				}
			}
		}
		return d[x];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		for(int i = 0;i <= n;i++)
			rel.add(new ArrayList<Node>());
		
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			rel.get(v1).add(new Node(v2,t));
		}
		
		d = new int[n + 1];
		int[] to = new int[n + 1];
		Arrays.fill(d,MAX);
		dijkstra(x);
		for(int i = 1;i <= n;i++)
			to[i] = d[i];
		
		for(int i = 1;i <= n;i++) { 
			d = new int[n + 1];
			Arrays.fill(d,MAX);
			ans = Math.max(ans,dijkstra(i) + to[i]);
		}
		System.out.println(ans);
	}
}
