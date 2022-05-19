package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 기능개발 {

	private static int n;
	private static List<Integer> p = new ArrayList<Integer>();
	private static List<Integer> s = new ArrayList<Integer>();
	private static int[] progresses;
	private static int[] speeds;
	
	private static int[] solution(int[] p,int[] s) {
		int[] answer;
		List<Integer> list = new ArrayList<Integer>();
		int[] cost = new int[p.length];
		
		for(int i = 0;i < cost.length;i++) {
			int q = (100 - p[i]) / s[i];
			int t = (100 - p[i]) % s[i];
			
			if(t == 0)
				cost[i] = q;
			else if(t > 0)
				cost[i] = q + 1;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0;i < p.length;i++)
			q.add(cost[i]);
		int day = 1;
		
		while(!q.isEmpty()) {
			if(q.peek() <= day) {
				int ans = 0;
				while(!q.isEmpty() && q.peek() <= day) {
					q.poll();
					ans++;
				}
				list.add(ans);
			}
			day++;
		}
		answer = new int[list.size()];
		for(int i = 0;i < list.size();i++)
			answer[i] = list.get(i);
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreElements()) {
			p.add(Integer.parseInt(st.nextToken()));
			n++;
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			s.add(Integer.parseInt(st.nextToken()));
		progresses = new int[n];
		speeds = new int[n];
		for(int i = 0;i < n;i++) {
			progresses[i] = p.get(i);
			speeds[i] = s.get(i);
		}
		int[] ans = solution(progresses,speeds);
		for(int i = 0;i < ans.length;i++)
			System.out.print(ans[i] + " ");
	}
}
