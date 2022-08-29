package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 친구비 {

	private static int[] parent;
	private static int n;
	private static int m;
	private static int k;
	private static int[] money;
	private static int ans;
	
	private static int findParent(int v) {
		if(parent[v] == v)
			return v;
		return findParent(parent[v]);
	}
	
	private static void union_find(int a,int b) {		
		int a_parent = findParent(a);
		int b_parent = findParent(b);
		
		if(money[a_parent] > money[b_parent])
			parent[a_parent] = parent[b_parent];
		else if(money[a_parent] <= money[b_parent])
			parent[b_parent] = parent[a_parent];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		money = new int[n + 1];
		parent = new int[n + 1];
		for(int i = 1;i < n + 1;i++) {
			money[i] = Integer.parseInt(st.nextToken());
			parent[i] = i;
		}
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			union_find(v1,v2);
		}
		for(int i = 1;i <= n;i++) {
			if(parent[i] == i) {
				ans += money[i];
				k -= money[i];
			}
			if(k < 0) {
				System.out.println("Oh no");
				System.exit(0);
			}
		}
		System.out.println(ans);
	}
}
