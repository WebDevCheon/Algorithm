package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기 {
	
	private static int n;
	private static int m;
	private static int k;
	private static int start;
	private static int d[];
	private static int MAX = 1000000000;
	private static ArrayList<Node>[] graph;
	
	static class Node implements Comparable<Node> {
		int idx;
		int dist;
		
		public Node(int idx,int dist) {
			this.idx = idx;
			this.dist = dist;
		}
		
		public int compareTo(Node otherNode) {
			return this.dist - otherNode.dist;
		}
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		d[start] = 0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int idx = node.idx;
			int dist = node.dist;
			
			if(dist > d[idx])
				continue;
			
			for(int i = 0;i < graph[idx].size();i++) {
				int nextDist = graph[idx].get(i).dist;
				if(nextDist + d[idx] < d[graph[idx].get(i).idx]) {
					d[graph[idx].get(i).idx] = nextDist + d[idx];
					pq.add(new Node(graph[idx].get(i).idx, nextDist + d[idx]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		d = new int[n + 1];
		graph = new ArrayList[n + 1];
		for(int i = 0;i <= n;i++)
			graph[i] = new ArrayList<Node>();
		Arrays.fill(d, MAX);
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph[v1].add(new Node(v2,1));
		}
		
		dijkstra();
		
		int cnt = 0;
		for(int i = 1;i <= n;i++) {
			if(i == start)
				continue;
			if(d[i] == k) {
				cnt++;
				bw.write(i + "\n");
			}
		}
		if(cnt == 0)
			bw.write(-1 + "\n");
		bw.flush();
	}
}