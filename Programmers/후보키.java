package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 후보키 {

	private static int[] a;
	private static String[][] relation;
	private static ArrayList<HashSet<Integer>> setList = new ArrayList<HashSet<Integer>>();
	private static int ans;
	
	private static void dfs(int idx,int n,int m,int start) {		// n : 뽑을 속성의 개수 , m : 총 속성의 개수
		if(idx == n) {		
			Set<String> set = new HashSet<String>();	
			for(int i = 0;i < relation.length;i++) {
				String str = "";
				for(int j = 0;j < a.length;j++)
					str += relation[i][a[j]];
				set.add(str);
			}
			if(set.size() < relation.length)
				return;
			HashSet<Integer> newSet = new HashSet<Integer>();
			for(int i = 0;i < a.length;i++)
				newSet.add(a[i]);
			for(int i = 0;i < setList.size();i++) {
				if(newSet.containsAll(setList.get(i)))
					return;
			}
			setList.add(newSet);
			ans++;
			return;
		}
		
		for(int i = start;i < m;i++) {
			a[idx] = i;
			dfs(idx + 1,n,m,i + 1);
		}
	}
	
	public static int solution(String[][] input) {		
		relation = input;
		int m = relation[0].length;		
		
		for(int i = 1;i <= m;i++) {
			a = new int[i];
			dfs(0,i,m,0);
		}
		return ans;
	}
}
