package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 게임을만든동준이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] level = new int[n];
		for(int i = 0;i < n;i++)
			level[i] = Integer.parseInt(br.readLine());
		int p = level[level.length - 1];
		int ans = 0;
		
		for(int i = level.length - 2;i >= 0;i--) {
			if(p > level[i]) {
				p = level[i];
				continue;
			}
			ans += (level[i] - (p - 1));
			p = p - 1;
		}
		System.out.println(ans);
	}
}
