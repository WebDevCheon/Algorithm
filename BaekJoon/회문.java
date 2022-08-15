package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 회문 {
	
	private static int n;
	
	private static int check(String str) {		
		int left = 0;							
		int right = str.length() - 1;			
		int cnt = 0;
		boolean l = false;		// left부분을 1회 삭제
		boolean r = false;		// right부분을 1회 삭제
		boolean lEnd = false;
		boolean rEnd = false;
		
		while(left <= right) {
			if(str.charAt(left) != str.charAt(right)) {
				if(cnt == 1) {
					lEnd = true;
					break;
				} else if(str.charAt(left) == str.charAt(right - 1)) {
					right--;
					cnt++;
				} else {
					lEnd = true;
					break;
				}
			}
			left++;
			right--;
		}
		
		if(!lEnd && cnt == 1)
			l = true;
		
		left = 0;
		right = str.length() - 1;
		cnt = 0;
		
		while(left <= right) {
			if(str.charAt(left) != str.charAt(right)) {
				if(cnt == 1) {
					rEnd = true;
					break;
				} else if(str.charAt(left + 1) == str.charAt(right)) {
					left++;
					cnt++;
				}  else {
					rEnd = true;
					break;
				}
			}
			left++;
			right--;
		}
		
		if(!rEnd && cnt == 1)
			r = true;
		
		if(lEnd && rEnd)		// 두 경우 모두 일반 문자열
			return 2;
		else if(l || r)		// 두 경우중 하나 이상이 유사 회문
			return 1;
		else			// 두 경우 모두 회문
			return 0;
	}		
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			bw.write(check(str) + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
