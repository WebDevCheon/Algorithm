package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 야근지수 {
	
	static class Data implements Comparable<Data> {
		long num;
		
		public Data(long num) {
			this.num = num;
		}
		
		public int compareTo(Data otherData) {
			return (int)(otherData.num - this.num);
		}
	}
	
	public static long solution(int n, int[] works) {
		PriorityQueue<Data> pq = new PriorityQueue<Data>();		
		for(int i = 0;i < works.length;i++)
			pq.add(new Data(works[i]));
		while(n-- > 0) {
			long num = pq.poll().num;
			Data data = null;
			if(num != 0)
				data = new Data(num - 1);
			else
				data = new Data(0);
			pq.add(data);
		}		
		long ans = 0;
		
		while(!pq.isEmpty()) {
			long num = pq.poll().num;
			if(num != 0)
				ans += Math.pow(num,2);
		}
		return ans;
    }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] works = new int[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < k;i++)
			works[i] = Integer.parseInt(st.nextToken());
		System.out.println(solution(n,works));
	}
}
