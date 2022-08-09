package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 팰린드롬만들기 {

	private static String str;
	private static int[] cnt = new int[26];
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		int len = str.length();
		for(int i = 0; i < str.length();i++)
			cnt[str.charAt(i) - 'A']++;
		String ans = "";
		
		if(len % 2 == 0) {
			for(int i = 0;i < cnt.length;i++) {
				if(cnt[i] % 2 == 1) {
					System.out.println("I'm Sorry Hansoo");
					System.exit(0);
				}
			}
			for(int i = cnt.length - 1;i >= 0;i--) {
				while(cnt[i] > 0) {
					ans = ((char)('A' + i) + ans);
					ans = (ans + (char)('A' + i));
					cnt[i] -= 2;
				}
			}
			System.out.println(ans);
		} else {
			int odd = 0;
			int oddIdx = 0;
			
			for(int i = 0;i < cnt.length;i++) {
				if(cnt[i] > 0 && cnt[i] % 2 == 1) {
					odd++;
					oddIdx = i;
				}
			}
			if(odd > 1)
				System.out.println("I'm Sorry Hansoo");
			else {
				if(odd == 1) {			
					cnt[oddIdx]--;
					ans += (char)(oddIdx + 'A');
				}
				for(int i = cnt.length - 1; i >= 0;i--) {
					while(cnt[i] > 0) {
						ans = ((char)('A' + i) + ans);
						ans = (ans + (char)('A' + i));
						cnt[i] -= 2;
					}
				}
				System.out.println(ans);
			}
		}
	}
}
