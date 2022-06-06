import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class kruskal {

	static class Node implements Comparable<Node> {
		int v1;
		int v2;
		int dist;
		public Node(int v1,int v2,int dist) {
			this.v1 = v1;
			this.v2 = v2;
			this.dist = dist;
		}
		public int compareTo(Node other) {
			return (this.dist - other.dist);
		}
	}
	
	private static void union(int[] parent,int v1,int v2) {
		int a_parent = find(parent,v1);
		int b_parent = find(parent,v2);
		
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
		int[] parent = new int[n];
		for(int i = 0;i < n;i++)
			parent[i] = i;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for(int i = 0;i < costs.length;i++) {
			int v1 = costs[i][0];
			int v2 = costs[i][1];
			int dist = costs[i][2];
			pq.add(new Node(v1,v2,dist));
		}
		int sum = 0;
		
		for(int i = 0;i < costs.length;i++) {
			Node node = pq.poll();
			if(find(parent,node.v1) != find(parent,node.v2)) {
				sum += node.dist;
				union(parent,node.v1,node.v2);
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 4;
		int[][] costs = new int[5][3];
		for(int i = 0;i < 5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			costs[i][0] = v1; costs[i][1] = v2; costs[i][2] = dist;
		}
		System.out.println(kruskal(n,costs));
	}
}
