package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 섬연결하기 {
	
	static class Node implements Comparable<Node> {
		int v1;
		int v2;
		int dist;
		
		public Node(int v1,int v2,int dist) {
			this.v1 = v1; this.v2 = v2; this.dist = dist;
		}
		
		public int compareTo(Node otherNode) {
			return (this.dist - otherNode.dist);
		}
	}
	
	private static void union(int[] parent,int a,int b) {
		int a_parent = find(parent,a);
		int b_parent = find(parent,b);
		
		if(a_parent < b_parent)
			parent[a_parent] = b_parent;
		else
			parent[b_parent] = a_parent;
		
	}
	
	private static int find(int[] parent,int v) {
		if(parent[v] == v)
			return v;
		return find(parent,parent[v]);
	}
	
	private static int kruskal(int n,int[][] costs) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		int[] parent = new int[n];
		for(int i = 0;i < n;i++)
			parent[i] = i;
		for(int i = 0;i < costs.length;i++) {
			int v1 = costs[i][0];
			int v2 = costs[i][1];
			int dist = costs[i][2];
			pq.add(new Node(v1,v2,dist));
		}
		
		int ans = 0;
		for(int i = 0;i < costs.length;i++) {
			Node node = pq.poll();
			if(find(parent,node.v1) != find(parent,node.v2)) {
				ans += node.dist;
				union(parent,node.v1,node.v2);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] costs = new int[5][3];
		for(int i = 0;i < 5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			costs[i][0] = v1; costs[i][1] = v2; costs[i][2] = cost;
		}
		System.out.println(kruskal(n,costs));
	}
}
