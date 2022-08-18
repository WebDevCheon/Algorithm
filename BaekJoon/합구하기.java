package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합구하기 {

	private static int n;
	private static int[] arr;
	private static int[] sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		sum = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1;i < n + 1;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		for(int i = 1;i <= n;i++)
			sum[i] = sum[i - 1] + arr[i];			
		while(m-- > 0) {
			 st = new StringTokenizer(br.readLine());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 System.out.println(sum[b] - sum[a - 1]);
		}
	}
}
