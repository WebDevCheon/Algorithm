package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기 {

	private static int lower_bound(int[] arr,int k,int m) {
		int left = 0;
		int right = arr.length - 1;
		int tmp = k + m;		
		
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] < tmp)
				left = mid + 1;
			else
				right = mid - 1;
		}
		if(left >= arr.length)
			return -1;
		return arr[left] - k;
	}
	
	// 투포인터 방식
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = Integer.MAX_VALUE;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for(int i = 0;i < n;i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);

		for(int i = 0,j = 0;i < n;i++) {
			while(j < arr.length && arr[j] - arr[i] < m)
				j++;
			if(j >= arr.length)
				break;
			if(arr[j] - arr[i] >= m)
				ans = Math.min(arr[j] - arr[i], ans);
		}
		System.out.println(ans);
	}
	
	// lower_bound 방식
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = Integer.MAX_VALUE;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for(int i = 0;i < n;i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		for(int i = 0;i < n;i++) {
			int tmp = lower_bound(arr,arr[i],m);
			if(tmp == -1)
				break;
			else if(tmp < m)
				continue;
			ans = Math.min(tmp,ans);
		}
		System.out.println(ans);
	}
}
