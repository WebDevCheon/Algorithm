package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 스타트와링크 {

	private static int[][] s;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		s = new int[n + 1][n + 1];
		int ans = Integer.MAX_VALUE;
		for(int i = 1;i < n + 1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1;j < n + 1;j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0;i < (1 << n);i++) {
			int cnt = 0;
			ArrayList<Integer> teamA = new ArrayList<Integer>();
			ArrayList<Integer> teamB = new ArrayList<Integer>();
			for(int j = 0;j < n;j++) {
				if((i & (1 << j)) > 0) {
					cnt++;
					teamA.add(j + 1);
				} else
					teamB.add(j + 1);
			}
			
			if(cnt == n / 2) {
				int sumA = 0;
				
				for(int j = 0;j < teamA.size();j++) {
					for(int l = 0;l < teamA.size();l++) {
						if(j == l)
							continue;
						int a = teamA.get(j);
						int b = teamA.get(l);
						sumA += s[a][b];
					}
				}
				
				int sumB = 0;
				
				for(int j = 0;j < teamA.size();j++) {
					for(int l = 0;l < teamA.size();l++) {
						if(j == l)
							continue;
						int a = teamB.get(j);
						int b = teamB.get(l);
						sumB += s[a][b];
					}
				}
				
				ans = Math.min(Math.abs(sumA - sumB),ans);
			}
		}
		System.out.println(ans);
	}
}
