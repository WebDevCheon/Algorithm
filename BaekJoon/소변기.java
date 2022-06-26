package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 소변기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		String log = br.readLine();
		int time = 1;
		int idx = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int one = 0;
		int zero = 0;
		boolean used = false;
		
		while(time <= l + n) {
			if(time == l + n) {
				if(used)
					ans.add(time);
				time++;
				continue;
			}
			
			if(idx >= log.length()) {
				time++;
				continue;
			}
			
			if(log.charAt(idx) == '0') {
				one = 0;
				zero++;
			} else if(log.charAt(idx) == '1') {
				zero = 0;
				one++;
			}
			
			if(one == k)
				used = true;
			
			if(used && zero == l) {
				used = false;
				ans.add(time);
				one = 0;
				zero = 0;
			}
			time++;
			idx++;
		}
		
		if(ans.size() == 0)
			System.out.println("NIKAD");
		else {
			for(int i = 0;i < ans.size();i++)
				System.out.println(ans.get(i));
		}
	}
}
