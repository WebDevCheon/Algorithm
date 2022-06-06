import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dijkstra {
	
    public static int n;
    public static int m;
    public static int start;
    private static ArrayList<ArrayList<node>> graph = new ArrayList<ArrayList<node>>();
    private static int[] d = new int[100001];
    
    static class node implements Comparable<node> {
    	int distance;
    	int idx;
    	
    	public node(int idx, int distance) {
    		this.idx = idx;
    		this.distance = distance;
    	}
    	
    	public int compareTo(node othernode) {
    		if(this.distance < othernode.distance)
    			return -1;
    		return 1;
    	}
    }
    
    private static void dijkstra(int start) {
    	PriorityQueue<node> pq = new PriorityQueue<node>();
    	d[start] = 0;
    	pq.offer(new node(start,0));
    	
    	while(!pq.isEmpty()) {
    		node Node = pq.poll();
    		
    		int now = Node.idx;
    		int dist = Node.distance;
    			
    		if(d[now] < dist)
    			continue;
    		
    		for(int i = 0;i < graph.get(now).size();i++) {
    			int cost = d[now] + graph.get(now).get(i).distance;
    			if(cost < d[graph.get(now).get(i).idx]) {
    				d[graph.get(now).get(i).idx] = cost;
    				pq.offer(new node(graph.get(now).get(i).idx,cost));
    			}
    		}
    	}
    }
    
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	start = Integer.parseInt(br.readLine());
    	for(int i = 0;i <= n;i++)
    		graph.add(new ArrayList<node>());
    	
    	for(int i = 0;i < m;i++) {
    		st = new StringTokenizer(br.readLine());
    		int v1 = Integer.parseInt(st.nextToken());
    		int v2 = Integer.parseInt(st.nextToken());
    		int p = Integer.parseInt(st.nextToken());
    		graph.get(v1).add(new node(v2,p));
    		// 양방향 그래프일때,  graph.get(v2).add(new node(v1,p));
    	}
    	Arrays.fill(d,Integer.MAX_VALUE);
    }
    
    
    public static void main(String[] args) throws Exception {
        input();
        dijkstra(start);
        for(int i = 1;i < n + 1;i++) {
        	if(d[i] != Integer.MAX_VALUE)
        		System.out.println(d[i] + " ");
        	else
        		System.out.println("INF");
        }
    }
}
