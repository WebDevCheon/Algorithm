package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 대회장소준비 {

	private static int[] dx = {1,1,0,-1,-1,-1,0,1};
	private static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	private static boolean isRange(int y,int x,int n,int m) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][m];
			Set<Integer> set = new HashSet<Integer>();
			int ans = 0;
			
			for(int i = 0;i < n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j < m;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < m;j++) {
					int id = map[i][j];
					if(set.contains(id) || id == -1)
						continue;
					for(int k = 0;k < dx.length;k++) {
						int nx = j + dx[k];
						int ny = i + dy[k];
						
						if(!isRange(ny,nx,n,m))
							continue;
						if(map[ny][nx] == id) {
							set.add(id);
							ans++;
							break;
						}
					}
				}
			}
			bw.write(ans + "\n");
		}
		bw.flush();
	}
}
