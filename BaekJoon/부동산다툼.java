package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 부동산다툼 {

	private static int n;
	private static int q;
	private static ArrayList<Integer>[] rel;
	private static boolean[] visited;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		rel = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		arr = new int[q + 1];

		for (int i = 1; i < q + 1; i++)
			arr[i] = Integer.parseInt(br.readLine());
		for (int i = 1; i < n + 1; i++)
			rel[i] = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			int c1 = i * 2;
			int c2 = i * 2 + 1;
			if (c1 <= n)
				rel[i].add(c1);
			if (c2 <= n)
				rel[i].add(c2);
		}

		for (int i = 1; i < q + 1; i++) {
			int target = arr[i];
			int v = -1;
			boolean flag = false;

			while (target > 1) {
				if (visited[target]) {
					flag = true;
					v = target;
				}
				if (target % 2 == 1) {
					target--;
					target /= 2;
				} else
					target /= 2;
			}
			if (!flag) {
				visited[arr[i]] = true;
				bw.write(0 + "\n");
			} else 
				bw.write(v + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
