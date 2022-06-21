package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 영어끝말잇기 {
	
	private static Set<String> set = new HashSet<String>();
	
	public static int[] solution(int n, String[] words) {
		int cnt = 1;
		int now = 1;
		boolean isEnd = false;
		int[] ans = new int[2];
		
		if(words[0].length() <= 1) {
			ans[0] = 1;
			ans[1] = 1;
			return ans;
		}
		set.add(words[0]);
		now++;
		for(int i = 1;i < words.length;i++) {
			if(!set.contains(words[i]) && words[i].length() > 1 && (words[i - 1].charAt(words[i - 1].length() - 1) == words[i].charAt(0)))
				set.add(words[i]);
			else {
				isEnd = true;
				break;
			}
			
			now++;
			if(now == n + 1) {
				now %= n;
				cnt++;
			}
		}
		
		if(!isEnd)
			return ans;
		else {
			ans[0] = now;
			ans[1] = cnt;
			return ans;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String[] words = new String[k];
		for(int i = 0;i < k;i++)
			words[i] = br.readLine();
		System.out.println(solution(n,words));
	}
}
