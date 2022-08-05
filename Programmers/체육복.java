package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 체육복 {	// 그리디 알고리즘으로 다시 풀어보기

	private static int ans;

	private static void dfs(int idx, int k, int tmp, Set<Integer> reserve,Set<Integer> lost) {	
		if (idx == k + 1) {
			ans = Math.max(ans, tmp);
			return;
		}

		Set<Integer> newSet = new HashSet<Integer>(reserve);
		
		if(lost.contains(idx)) {			
			if(reserve.contains(idx))
				dfs(idx + 1,k,tmp + 1,newSet,lost);
			else {
				int num = idx - 1;
				if(!lost.contains(num) && reserve.contains(num)) {
					newSet.remove(num);
					dfs(idx + 1,k,tmp + 1,newSet,lost);
					newSet.add(num);
				} else if(lost.contains(num))
					dfs(idx + 1,k,tmp,newSet,lost);
				  else if(!lost.contains(num) && !reserve.contains(num))
					dfs(idx + 1,k,tmp,newSet,lost);
				num = idx + 1;
				if(!lost.contains(num) && reserve.contains(num)) {
					newSet.remove(num);
					dfs(idx + 1,k,tmp + 1,newSet,lost);
					newSet.add(num);
				} else if(lost.contains(num))
					dfs(idx + 1,k,tmp,newSet,lost);
				else if(!lost.contains(num) && !reserve.contains(num))
					dfs(idx + 1,k,tmp,newSet,lost);
			}
		} else	
			dfs(idx + 1,k, tmp + 1,newSet,lost);
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		Set<Integer> reserveSet = new HashSet<Integer>();
		Set<Integer> lostSet = new HashSet<Integer>();
		for (int i = 0; i < lost.length; i++)
			lostSet.add(lost[i]);
		for (int i = 0; i < reserve.length; i++)
			reserveSet.add(reserve[i]);
		dfs(1, n, 0, reserveSet,lostSet);
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] lost = new int[a];
		int[] reserve = new int[b];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++)
			lost[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++)
			reserve[i] = Integer.parseInt(st.nextToken());
		System.out.println(solution(n, lost, reserve));
	}
}
