package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 외벽점검 {

	private static int n;
	private static boolean[] d_visited;
	private static int[] dist;
	private static int[] weak;
	private static int[] dist_arr;
	private static int ans = Integer.MAX_VALUE;

	private static void check() {
		int w = weak.length / 2;

		for (int i = 0; i < w; i++) {
			int start = i; 	// 시작점
			int idx = 0; 	// dist_arr의 인덱스
			boolean isEscape = false;
			
			for (int j = i; j < i + w; j++) {
				if (weak[j] > weak[start] + dist_arr[idx]) {
					start = j;
					idx++;
				}

				if (idx == dist.length) {
					isEscape = true;
					break;
				}
			}
			if (!isEscape)
				ans = Math.min(idx + 1, ans);
		}
	}

	private static void dfs(int idx) {
		if (idx == dist_arr.length) {
			check();
			return;
		}

		for (int i = 0; i < dist.length; i++) {
			if (d_visited[i])
				continue;
			d_visited[i] = true;
			dist_arr[idx] = dist[i];
			dfs(idx + 1); 
			d_visited[i] = false;
		}
	}

	public static int solution(int nInput, int[] inputWeak, int[] inputDist) {
		n = nInput;
		int w = inputWeak.length;
		int d = inputDist.length;
		dist = inputDist;
		weak = new int[2 * inputWeak.length];
		for (int i = 0; i < inputWeak.length; i++)
			weak[i] = inputWeak[i];
		for (int i = 0; i < inputWeak.length; i++)
			weak[i + w] = inputWeak[i] + n;

		dist_arr = new int[d];
		d_visited = new boolean[d];
		dfs(0);
		if (ans == Integer.MAX_VALUE)
			return -1;
		else
			return ans;
	}
}
