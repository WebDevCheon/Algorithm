package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 평범한배낭 {

	private static int n;
	private static int k;
	private static int[] w;
	private static int[] v;
	private static int[][] dp;
	private static int ans;
	
	static class bag implements Comparable<bag> {
		int w;
		int v;
		public bag(int w,int v) {
			this.w = w;
			this.v = v;
		}
		
		@Override
		public int compareTo(bag otherBag) {
			if(this.w < otherBag.w)
				return -1;
			else if(this.w > otherBag.w)
				return 1;
			else {
				if(this.v < otherBag.v)
					return -1;
				else if(this.v > otherBag.v)
					return 1;
				return 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		List<bag> bagList = new ArrayList<bag>();
		dp = new int[n + 1][k + 1];
		w = new int[n + 1];
		v = new int[n + 1];
		
		for(int i = 1;i < n + 1;i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			bagList.add(new bag(weight,value));
		}
		
		Collections.sort(bagList);
		for(int i = 0;i < bagList.size();i++) {
			w[i + 1] = bagList.get(i).w;
			v[i + 1] = bagList.get(i).v;
		}
		
		for(int i = 1;i <= n;i++) {
			for(int j = 0;j <= k;j++) {
				if(j < w[i])
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j - w[i]] + v[i], dp[i - 1][j]);
			}
		}
		
		for(int i = 1;i <= n;i++) {
			for(int j = 0;j <= k;j++)
				ans = Math.max(dp[i][j],ans);
		}
		System.out.println(ans);
	}
}
