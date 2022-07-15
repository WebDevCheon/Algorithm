package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 구간합구하기4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i <= n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 1;i < n + 1;i++)
			arr[i] += arr[i - 1];
		
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			System.out.println(arr[dest] - arr[start - 1]);
		}
	}
}
