package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CountCircleGroups {
	
	private static int[] parent;
	private static int n;
	private static int ans;
	
	static class pos {
		int x;
		int y;
		int r;
		public pos(int x,int y,int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
	
	private static int find_parent(int[] parent,int v) {
		if(parent[v] == v)
			return v;
		return find_parent(parent,parent[v]);
	}
	
	private static void union_find(int[] parent,int a,int b) {
		int a_parent = find_parent(parent,a);
		int b_parent = find_parent(parent,b);
		
		if(a_parent < b_parent)
			parent[a_parent] = b_parent;
		else
			parent[b_parent] = a_parent;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			n = Integer.parseInt(br.readLine());
			ans = n;
			parent = new int[n];
			for(int i = 0;i < n;i++)
				parent[i] = i;
			List<pos> posList = new ArrayList<pos>();
			
			for(int i = 0;i < n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				posList.add(new pos(x,y,r));
			}
			
			for(int i = 0;i < n;i++) {
				pos a = posList.get(i);
				for(int j = i + 1;j < n;j++) {
					pos b = posList.get(j);
					int diffX = Math.abs(b.y - a.y) * Math.abs(b.y - a.y);
					int diffY = Math.abs(b.x - a.x) * Math.abs(b.x - a.x);
					int R = (a.r + b.r) * (a.r + b.r);
					
					if(diffX + diffY <= R && find_parent(parent,i) != find_parent(parent,j)) {
						ans--;
						union_find(parent,i,j);
					}
				}
			}
			bw.write(ans + "\n");
		}
		bw.flush();
	}	
}
