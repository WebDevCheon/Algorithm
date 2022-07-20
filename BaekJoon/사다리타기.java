package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 사다리타기 {

	private static char[][] map;
	private static int n;
	private static int m;
	private static int row;
	private static String result;
	
	private static void dfs(int idx) {
		if(idx == m) {
			char[] arr = new char[m];
			
			for(int j = 0;j < m;j++) {
				int nowCol = j;
				char ch = (char)('A' + j);
				
				for(int i = 0;i < n;i++) {
					if(nowCol - 1 >= 0) {
						if(map[i][nowCol - 1] == '-')
							nowCol--;
						else if(map[i][nowCol] == '-')
							nowCol++;
					} else {
						if(map[i][nowCol] == '-')
							nowCol++;
					}
				}
				arr[nowCol] = ch;
				if(arr[nowCol] != result.charAt(nowCol))
					return;
			}
			String ans = "";
			for(int i = 0;i < m - 1;i++)
				ans += map[row][i];
			System.out.println(ans);
			System.exit(0);
		}
		
		if(idx < m - 1) {
			map[row][idx] = '*';
			dfs(idx + 1);
			if(idx == 0) {
				map[row][idx] = '-';
				dfs(idx + 1);
			}
			if(idx > 0 && map[row][idx - 1] != '-') {
				map[row][idx] = '-';
				dfs(idx + 1);
			}
		} else {
			map[row][idx] = '*';
			dfs(idx + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		m = k;
		map = new char[n][m];
		result = br.readLine();
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			for(int j = 0;j < m;j++) {
				if(j < m - 1)
					map[i][j] = str.charAt(j);
				else
					map[i][j] = '*';
				
				if(map[i][j] == '?')
					row = i;
			}
		}
		dfs(0);
		String ans = "";
		for(int i = 0;i < m - 1;i++)
			ans += "x";
		System.out.println(ans);
	}
}
