package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 소용돌이예쁘게출력하기 {
	
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,-1,0,1};
	private static int max;
	
	private static boolean isRange(int y,int x,int r1,int c1,int r2,int c2) {
		if(y >= r1 && y <= r2 && x >= c1 && x <= c2)
			return true;
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int[][] ans = new int[r2 - r1 + 1][c2 - c1 + 1];
		int all = 10001 * 10001;
		int sy = 10000 / 2;
		int sx = 10000 / 2;
		int dir = 0;
		int num = 2;
		int len = 1;
		int nx = sx;
		int ny = sy;
		boolean escape = false;
		r1 = sy + r1;
		c1 = sx + c1;
		r2 = sy + r2;
		c2 = sx + c2;
		
		if(isRange(sy,sx,r1,c1,r2,c2))
			ans[ny - r1][nx - c1] = 1;
		all--;
		
		while(true) {
			int cnt = len;
			
			while(cnt-- > 0) {
				nx += dx[dir];
				ny += dy[dir];
			
				if(isRange(ny,nx,r1,c1,r2,c2)) {
					ans[ny - r1][nx - c1] = num;
					max = Math.max(max,num);
				}
				num++;	
				all--;
				if(all == 0) {
					escape = true;
					break;
				}
			}
			if(escape)
				break;
			
			dir = (dir + 1) % dx.length;
			cnt = len;
			
			while(cnt-- > 0) {
				nx += dx[dir];
				ny += dy[dir];
				if(isRange(ny,nx,r1,c1,r2,c2)) {
					ans[ny - r1][nx - c1] = num;
					max = Math.max(max,num);
				}
				num++;
				all--;
				if(all == 0) {
					escape = true;
					break;
				}
			}

			dir = (dir + 1) % dx.length;
			len++;
			if(escape)
				break;
		}
		
		int maxLen = (int)Math.log10(max);
		
		for(int i = 0;i < ans.length;i++) {
			for(int j = 0;j < ans[0].length;j++) {
				int length = maxLen - (int)Math.log10(ans[i][j]);
				for(int k = 0;k < length;k++)
					System.out.print(" ");
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}
