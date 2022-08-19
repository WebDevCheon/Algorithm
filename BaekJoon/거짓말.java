package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class 거짓말 {

	private static int n;
	private static int m;
	private static Set<Integer> truthSet = new HashSet<Integer>();		// 진실을 아는 사람들
	private static ArrayList<Integer> party = new ArrayList<Integer>();		// 각각의 파티에 처음 데이터 요소
	private static Set<Integer> isTruth = new HashSet<Integer>();		// 진실을 아는 사람들의 최종 부모
	private static int[] parent;
	private static int ans;
	
	private static void union_find(int a,int b) {
		int a_parent = findParent(a);
		int b_parent = findParent(b);
		
		if(a_parent < b_parent)
			parent[a_parent] = b_parent;
		else
			parent[b_parent] = a_parent;
	}
	
	private static int findParent(int v) {
		if(parent[v] == v)
			return v;
		return findParent(parent[v]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		for(int i = 0;i < k;i++)
			truthSet.add(Integer.parseInt(st.nextToken()));
		party = new ArrayList<Integer>();
		parent = new int[n + 1];
		for(int i = 1;i <= n;i++)
			parent[i] = i;
		
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			party.add(start);
			for(int j = 0;j < k - 1;j++) {
				int next = Integer.parseInt(st.nextToken());
				union_find(start,next);
			}
		}
		
		Iterator<Integer> itr = truthSet.iterator();
		while(itr.hasNext()) {
			int vertex = itr.next();
			isTruth.add(findParent(vertex));
		}
		
		for(int i = 0;i < party.size();i++) {
			if(!isTruth.contains(findParent(party.get(i))))
				ans++;
		}
		System.out.println(ans);
	}
}
