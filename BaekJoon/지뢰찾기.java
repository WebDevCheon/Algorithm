package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 지뢰찾기 {

	private static int n;
	private static int m;
	private static int[] dx = {1,1,0,-1,-1,-1,0,1};
	private static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n == 0 && m == 0)
				break;
			char[][] map = new char[n][m];
			String[][] ans = new String[n][m];
			for(int i = 0;i < n;i++) {
				String str = br.readLine();
				for(int j = 0;j < m;j++)
					map[i][j] = str.charAt(j);
			}
			
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < m;j++) {
					if(map[i][j] == '*') {
						ans[i][j] = "*";
						continue;
					}
					int cnt = 0;
					for(int k = 0;k < dx.length;k++) {
						int nx = j + dx[k];
						int ny = i + dy[k];
						
						if(!isRange(ny,nx))
							continue;
						if(map[ny][nx] == '*')
							cnt++;
					}
					ans[i][j] = String.valueOf(cnt);
				}
			}
			
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < m;j++)
					bw.write(ans[i][j]);
				bw.write("\n");
			}
		}
		bw.flush();
	}
}
