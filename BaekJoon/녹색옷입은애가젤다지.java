package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지 {

	private static int[][] map;
	private static int n;
	private static int[] dist;
	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static ArrayList<info> infoList;
	private static ArrayList<Node>[] nodeList;

	static class Node implements Comparable<Node> {
		int v;
		int dist;

		public Node(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node otherNode) {
			if (this.dist < otherNode.dist)
				return -1;
			return 1;
		}
	}

	static class info {
		int from;
		int to;
		int dist;

		public info(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
	}

	private static boolean isRange(int y, int x) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
	
	private static void getDistNode(int y, int x) {			
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < dx.length; k++) {
					int nx = j + dx[k];
					int ny = i + dy[k];
					if (!isRange(ny, nx))
						continue;
					infoList.add(new info(i * n + j, ny * n + nx, map[ny][nx]));
				}
			}
		}
		nodeList = new ArrayList[n * n];
		for (int i = 0; i < nodeList.length; i++)
			nodeList[i] = new ArrayList<Node>();

		for (int i = 0; i < infoList.size(); i++) {
			int from = infoList.get(i).from;
			int to = infoList.get(i).to;
			int dist = infoList.get(i).dist;
			nodeList[from].add(new Node(to, dist));
		}
	}
	
	private static void dijkstra(int start, int dest) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, map[0][0]));
		dist[start] = map[0][0];

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.v;

			if (dist[now] < node.dist) 		
				continue;

			for (int i = 0; i < nodeList[now].size(); i++) {
				int d = nodeList[now].get(i).dist;

				if (d + dist[now] < dist[nodeList[now].get(i).v]) {
					pq.add(new Node(nodeList[now].get(i).v, d + dist[now]));
					dist[nodeList[node.v].get(i).v] = d + dist[now];
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 1;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			map = new int[n][n];
			dist = new int[n * n];
			infoList = new ArrayList<info>();
			Arrays.fill(dist, Integer.MAX_VALUE);
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			nodeList = new ArrayList[n * n];
			for (int i = 0; i < nodeList.length; i++)
				nodeList[i] = new ArrayList<Node>();
			getDistNode(0, 0);
			dijkstra(0, n * n - 1);
			System.out.println("Problem " + (idx++) + ": " + dist[(n - 1) * n + (n - 1)]);
		}
	}
}
