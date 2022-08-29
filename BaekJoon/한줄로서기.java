package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한줄로서기 {

	private static int n;
	private static int[] arr;
	private static int[] a;			
	private static boolean[] visited;

	private static void dfs(int idx) {
		if (idx == n + 1) {
			boolean flag = true;
			for (int i = 1; i <= n; i++) {
				int cnt = 0;
				for (int j = 1; j < i; j++) {
					if (a[j] > a[i])
						cnt++;
				}
				if (cnt != arr[a[i]]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				for (int i = 1; i <= n; i++)
					System.out.print(a[i] + " ");
				System.exit(0);
			}
			return;
		}

		for (int i = 1; i < n + 1; i++) {
			if (visited[i])
				continue;
			a[idx] = i;
			visited[i] = true;
			dfs(idx + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		a = new int[n + 1];
		visited = new boolean[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		dfs(1);
	}
}
