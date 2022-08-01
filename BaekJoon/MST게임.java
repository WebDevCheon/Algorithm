package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MST게임 {

	private static int n;
	private static int m;
	private static int k;
	private static ArrayList<Edge> edgeList = new ArrayList<Edge>();
	private static int[] parent;
	
	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		int dist;
		
		public Edge(int v1,int v2,int dist) {
			this.v1 = v1;
			this.v2 = v2;
			this.dist = dist;
		}
		
		public int compareTo(Edge otherEdge) {
			return (this.dist - otherEdge.dist);
		}
	}
	
	private static int find_parent(int[] parent,int v) {
		if(parent[v] == v)
			return v;
		return find_parent(parent,parent[v]);
	}
	
	private static void union_find(int[] parent,int v1,int v2) {
		int p1 = find_parent(parent,v1);		// v1의 부모
		int p2 = find_parent(parent,v2);		// v2의 부모
		
		if(p1 < p2)
			parent[p1] = p2;
		else
			parent[p2] = p1;
	}
	
	private static boolean check() {
		for(int i = 1;i < n;i++) {
			if(find_parent(parent,i) != find_parent(parent,i + 1))
				return false;
		}
		return true;
	}
	
	private static int kruskal(PriorityQueue<Edge> pq) {
		parent = new int[n + 1];
		for(int i = 1;i < n + 1;i++)
			parent[i] = i;
		int len = pq.size();
		int ans = 0;
		
		for(int i = 0;i < len;i++) {
			Edge edge = pq.poll();
			int v1 = edge.v1;
			int v2 = edge.v2;
			int dist = edge.dist;
			
			if(find_parent(parent,v1) != find_parent(parent,v2)) {
				ans += dist;
				union_find(parent,v1,v2);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for(int i = 1;i <= m;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(v1,v2,i));
		}
		int idx = 0;
		
		while(k-- > 0) {
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			for(int i = idx;i < edgeList.size();i++) {
				Edge edge = edgeList.get(i);
				pq.add(new Edge(edge.v1,edge.v2,edge.dist));
			}
			
			int ans = kruskal(pq);
			if(check()) {
				System.out.print(ans + " ");
			} else {
				for(int i = 0;i <= k;i++)
					System.out.print(0 + " ");
				break;
			}
			idx++;
		}
	}
}
