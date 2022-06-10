package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최고의집합 {
	
	public static int[] solution(int n, int s) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		if(s / n == 0) {
			int[] ans = new int[1];
			ans[0] = -1;
			return ans;
		}		
		
		int[] ans = new int[n];
		Arrays.fill(ans,1);
		int idx = 0;
		
		while(n > 0) {
			ans[idx++] = s / n;
			s -= s / n;
			n--;
		}
		return ans;
    	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		solution(n,s);
	}
}
