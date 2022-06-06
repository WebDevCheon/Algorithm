import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class topologysort {
	
	private static ArrayList<Integer>[] rel;
	private static int n;
	private static int[] inDegree;
	private static int[] result;
	
	private static void topologySort() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1;i <= n;i++) {
			if(inDegree[i] == 0)
				q.add(i);
		}
		
		int idx = 1;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int j = 0; j < rel[x].size();j++) {
				if(--inDegree[rel[x].get(j)] == 0)
					q.add(rel[x].get(j));
			}
			result[idx++] = x;
		}
		for(int i = 1;i <= n;i++)
			System.out.print(result[i] + " ");
	}
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		inDegree = new int[n + 1];
		rel = new ArrayList[n + 1];
		result = new int[n + 1];
		for(int i = 1;i < n + 1;i++)
			rel[i] = new ArrayList<Integer>();
		// 방향 그래프 연결
		rel[1].add(2);
		inDegree[2]++;
		rel[1].add(5);
		inDegree[5]++;
		rel[2].add(3);
		inDegree[3]++;
		rel[3].add(4);
		inDegree[4]++;
		rel[4].add(6);
		inDegree[6]++;
		rel[5].add(6);
		inDegree[6]++;
		rel[6].add(7);
		inDegree[7]++;
		//
		topologySort();
	}
}
