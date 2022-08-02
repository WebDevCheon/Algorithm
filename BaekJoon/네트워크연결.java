package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 네트워크연결 {

	private static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	private static int n;
	private static int m;
	
	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		int dist;
		
		public Edge(int v1,int v2,int dist) {
			this.v1 = v1;
			this.v2 = v2;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return (this.dist - o.dist); 
		}
	}
	
	private static int find_parent(int[] parent,int v) {
		if(parent[v] == v)
			return v;
		return find_parent(parent,parent[v]);
	}
	
	private static void union_find(int[] parent,int v1,int v2) {
		int a_parent = find_parent(parent,v1);
		int b_parent = find_parent(parent,v2);
		
		if(a_parent < b_parent)
			parent[a_parent] = b_parent;
		else
			parent[b_parent] = a_parent;
	}
	
	private static int kruskal() {
		int[] parent = new int[n + 1];
		for(int i = 1;i <= n;i++)
			parent[i] = i;
		int sum = 0;
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int v1 = edge.v1;
			int v2 = edge.v2;
			int dist = edge.dist;
			
			if(find_parent(parent,v1) != find_parent(parent,v2)) {
				sum += dist;
				union_find(parent,v1,v2);
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		for(int i = 0;i < m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			pq.add(new Edge(v1,v2,dist));
		}
		System.out.println(kruskal());
	}
}
