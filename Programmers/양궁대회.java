package Programmers;

public class 양궁대회 {
	
	private static int[] ryan = new int[11];
	private static int[] apeach;
	private static int diff = Integer.MIN_VALUE;
	private static int[] ans = new int[11];
	
	private static void dfs(int idx,int arrow) {
		if(idx == 11) {
			int ryanPoint = 0;
			int apeachPoint = 0;
			
			for(int i = 0;i < 11;i++) {
				if(apeach[i] >= ryan[i] && apeach[i] > 0) {
					apeachPoint += i;
				} else if(ryan[i] > 0)
					ryanPoint += i;
			}
			int resultDiff = Math.abs(ryanPoint - apeachPoint);
			
			if(resultDiff > diff && ryanPoint > apeachPoint) {
				ans = ryan.clone();
				diff = resultDiff;
			} else if(resultDiff == diff && ryanPoint > apeachPoint) {
				for(int i = 0;i <= 10;i++) {
					if(ryan[i] > 0 && ans[i] > 0) {
						if(ryan[i] > ans[i]) {
							ans = ryan.clone();
							break;
						}
					} else if(ryan[i] > 0 && ans[i] == 0) {
						ans = ryan.clone();
						break;
					} else if(ryan[i] == 0 && ans[i] > 0)
						break;
				}
			}
			return;
		}
		
		for(int i = 0;i <= arrow;i++) {
			if(arrow == 0) {
				ryan[idx] = 0;
				dfs(idx + 1,0);
			} else if(arrow - i >= 0) {
				ryan[idx] = i;
				dfs(idx + 1,arrow - i);
			}
		}
	}
	
	public static int[] solution(int arrow,int[] input) {
		apeach = new int[11];
		for(int i = 0;i < 11;i++)
			apeach[i] = input[10 - i];
		dfs(0,arrow);
		
		if(diff == Integer.MIN_VALUE) {
			int[] ans = new int[1];
			ans[0] = -1;
			return ans;
		} else {
			int[] answer = new int[11];
			for(int i = 0;i < 11;i++)
				answer[i] = ans[10 - i];
			return answer;
		}
	}
}
