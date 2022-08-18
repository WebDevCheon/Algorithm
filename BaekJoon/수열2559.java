package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열2559 {

	private static int[] arr;
	private static int n;
	private static int k;
	private static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for(int i = 0;i <= n - k;i++) {
			int sum = 0;
			for(int j = i;j < i + k;j++)
				sum += arr[j];
			ans = Math.max(sum, ans);
		}
		System.out.println(ans);
	}
}
