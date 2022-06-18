package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {

	private static int MAX = 1000000000;
	private static int[] d;
	private static ArrayList<ArrayList<Node>> rel = new ArrayList<ArrayList<Node>>();
	
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
	
	private static int dijkstra(int start,int dest) {
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
		return d[dest];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		for(int i = 0;i <= n;i++)
			rel.add(new ArrayList<Node>());
		
		for(int i = 0;i < m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			rel.get(v1).add(new Node(v2,d));
		}
		d = new int[n + 1];
		Arrays.fill(d,MAX);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		int ans = dijkstra(start,dest);
		System.out.println(ans);
	}
}
