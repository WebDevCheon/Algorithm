package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ZOAC {

	private static String str;
	private static boolean[] visited;
	
	private static void dfs(int left,int right) {			
		if(left > right)
			return;
		
		int idx = left;
		char ch = str.charAt(idx);
		
		for(int i = left;i <= right;i++) {
			if(!visited[i] && ch > str.charAt(i)) {
				idx = i;
				ch = str.charAt(i);
			}
		}
		visited[idx] = true;
		
		for(int i = 0;i < str.length();i++) {
			if(visited[i])
				System.out.print(str.charAt(i));
		}
		System.out.println();
		dfs(idx + 1,right);
		dfs(left,idx - 1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		visited = new boolean[str.length()];
		dfs(0,str.length() - 1);
	}
}
