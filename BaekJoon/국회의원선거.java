package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 국회의원선거 {
	
	private static int n;
	private static int dasom;
	private static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dasom = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 1;i < n;i++)
			pq.add(Integer.parseInt(br.readLine()));
		while(!pq.isEmpty()) {
			int vote = pq.poll();
			if(dasom > vote)
				break;
			ans++;
			dasom++;
			vote--;
			pq.add(vote);
		}
		System.out.println(ans);
	}
}
