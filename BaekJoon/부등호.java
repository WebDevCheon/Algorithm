package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부등호 {
	
	private static int n;
	private static int[] a;
	private static char[] b;
	private static long max = Long.MIN_VALUE;
	private static long min = Long.MAX_VALUE;
	private static boolean[] visited;
	private static String maxStr;
	private static String minStr;
	
	private static void dfs(int idx) {
		if(idx == n + 1) {
			String str = "";
			for(int i = 0;i <= n;i++)
				str += a[i];
			long num = Long.parseLong(str);
			
			if(max < num) {
				maxStr = str;
				max = num;
			}
			if(min > num) {
				minStr = str;
				min = num;
			}
			return;
		}
		
		for(int i = 0;i <= 9;i++) {
			if(visited[i])
				continue;
			
			if(idx == 0) {
				a[idx] = i;
				visited[i] = true;
				dfs(idx + 1);
				visited[i] = false;
			} else {
				if(b[idx - 1] == '>') {
					a[idx] = i;
					if(a[idx - 1] <= a[idx])
						continue;
					visited[i] = true;
					dfs(idx + 1);
					visited[i] = false;
				} else if(b[idx - 1] == '<') {
					a[idx] = i;
					if(a[idx - 1] >= a[idx])
						continue;
					visited[i] = true;
					dfs(idx + 1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n + 1];
		b = new char[n];
		visited = new boolean[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			b[i] = st.nextToken().charAt(0);
		dfs(0);
		System.out.println(maxStr);
		System.out.println(minStr);
	}
}
