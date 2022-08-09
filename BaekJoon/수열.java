package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int maxUp = Integer.MIN_VALUE;
		int maxDown = Integer.MIN_VALUE;
		
		boolean[] visited = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for(int i = 0;i < n;i++) {
			if(visited[i])
				continue;
			int cnt = 0;
			
			for(int j = i;j < n - 1;j++) {
				if(arr[j] <= arr[j + 1])
					cnt++;
				else
					break;
				visited[j] = true;
			}
			maxUp = Math.max(cnt + 1,maxUp);
		}
		
		visited = new boolean[n];
		
		for(int i = 0;i < n;i++) {
			if(visited[i])
				continue;
			int cnt = 0;
			
			for(int j = i;j < n - 1;j++) {
				if(arr[j] >= arr[j + 1])
					cnt++;
				else
					break;
				visited[j] = true;
			}
			maxDown = Math.max(cnt + 1,maxDown);
		}
		System.out.println(Math.max(maxUp,maxDown));
	}
}
