package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순서쌍곱의합 {

	private static int[] arr;
	private static int n;
	private static long ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		long[] sum = new long[n];
		sum[0] = arr[0];
		for(int i = 1;i < n;i++)
			sum[i] = sum[i - 1] + arr[i];
		for(int i = 0;i <= n - 2;i++)
			ans += arr[i] * (sum[n - 1] - sum[i]);
		System.out.println(ans);
	}
}
