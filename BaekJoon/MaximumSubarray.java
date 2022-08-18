package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSubarray {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1;i < n + 1;i++)
				arr[i] = Integer.parseInt(st.nextToken());
			int[] sum = new int[n + 1];
			for(int i = 1;i < n + 1;i++)
				sum[i] = arr[i] + sum[i - 1];
			int ans = Integer.MIN_VALUE;
			
			for(int i = 1;i <= n;i++) {
				for(int j = i;j <= n;j++)
					ans = Math.max(sum[j] - sum[i - 1], ans);
			}
			System.out.println(ans);
		}
		
	}
}
