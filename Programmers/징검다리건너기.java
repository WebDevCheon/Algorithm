package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 징검다리건너기 {

	private static boolean canGo(int mid,int[] stones,int k) {
		int[] clones = stones.clone();
		
		for(int i = 0;i < clones.length;i++)
			clones[i] -= mid;
		
		for(int i = 0;i <= clones.length - k;i++) {
			int cnt = 0;
			for(int j = i;j < i + k;j++) {
				if(clones[j] < 0)
					cnt++;
				else {
					i += (j - i);
					break;
				}
			}
			if(cnt == k)
				return false;
		}
		return true;
	}
	
	public static int solution(int[] stones, int k) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i = 0;i < stones.length;i++) {
			if(max < stones[i])
				max = stones[i];
			if(min > stones[i])
				min = stones[i];
		}
		int left = min;
		int right = max;
		int ans = 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			if(canGo(mid,stones,k)) {
				if(ans < mid)
					ans = mid;
				left = mid + 1;
			} else
				right = mid - 1;
		}
		return ans;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] stones = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			stones[i] = Integer.parseInt(st.nextToken());
		System.out.println(solution(stones,k));
	}
}
