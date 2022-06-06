import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class union_find {

	private static void union(int[] parent,int v1,int v2) {
		int a_parent = find(parent,v1);
		int b_parent = find(parent,v2);
		
		if(a_parent < b_parent)				// 값이 더 큰쪽으로 집합을 병합
			parent[a_parent] = b_parent;
		else
			parent[b_parent] = a_parent;
	}
	
	private static int find(int[] parent,int v) {		// 집합의 부모를 찾기
		if(parent[v] == v)
			return v;
		return find(parent,parent[v]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] parent = new int[n];
		for(int i = 0;i < n;i++)
			parent[i] = i;
		int m = Integer.parseInt(br.readLine());
		for(int i = 0;i < m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			parent[c] = p;
		}
	}
}
