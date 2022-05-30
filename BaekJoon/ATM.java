package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ATM {

	private static int[] arr;
	private static ArrayList<Integer> time = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1;i < n + 1;i++) {
			int num = Integer.parseInt(st.nextToken());
			time.add(num);
			arr[i] = num;
		}
		Collections.sort(time);
		for(int i = 1;i < time.size() + 1;i++)
			arr[i] = time.get(i - 1);
		int ans = 0;
		for(int i = 1;i < time.size() + 1;i++) {
			arr[i] += arr[i - 1];
			ans += arr[i];
		}
		System.out.println(ans);
	}
}
