package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 2016IOI {
	
	private static char[][] flag;
	private static int[] a;
	private static int n;
	private static int m;
	private static int[][] color;
	private static int ans = Integer.MAX_VALUE;
	
	private static void check() {
		int white = a[0];			
		int red = a[2];	
		
		int tmp = 0;

		for(int i = 0;i <= white;i++)
			tmp += color[1][i] + color[2][i];
		for(int i = white + 1;i <= red - 1;i++)
			tmp += color[0][i] + color[2][i];
		for(int i = red;i < n;i++)
			tmp += color[0][i] + color[1][i];
		ans = Math.min(tmp,ans);
	}
	
	private static void dfs(int idx,int start) {
		if(idx == 3) {
			check();
			return;
		}
		
		for(int i = start;i < n;i++) {
			a[idx] = i;
			dfs(idx + 1,i + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		flag = new char[n][m];
		color = new int[3][n];
		a = new int[3];
		
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			for(int j = 0;j < m;j++)
				flag[i][j] = str.charAt(j);
		}
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				if(flag[i][j] == 'W')
					color[0][i]++;
				else if(flag[i][j] == 'B')
					color[1][i]++;
				else
					color[2][i]++;
			}
		}
		dfs(0,0);
		System.out.println(ans);
	}
}
