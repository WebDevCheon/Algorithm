package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 배열돌리기2 {

	private static int[][] map;
	private static int n;
	private static int m;
	private static int r;	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < m;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int nx = 0;
		int ny = 0;
		int sz = 0;
		int idx = 0;
		
		while(true) {
			int nz = (n - sz) * (m - sz);
			if(nz == 0 || (n - sz == 1) || (m - sz == 1))
				break;
			int len = 2 * (n - sz) + 2 * (m - sz) - 4;

			int k;
			if(len > 0)
				k = r % len;
			else
				k = r % 4;
				
			for(int cnt = 0; cnt < k; cnt++) {
				int tmp = map[ny][nx];
				
				for(int j = nx;j < (m - idx - 1);j++)
					map[ny][j] = map[ny][j + 1];
				for(int i = ny;i < (n - idx - 1);i++)
					map[i][m - idx - 1] = map[i + 1][m - idx - 1];
				for(int j = (m - idx - 1);j > nx;j--)
					map[n - idx - 1][j] = map[n - idx - 1][j - 1];
				for(int i = n - idx - 1;i > ny + 1;i--)
					map[i][nx] = map[i - 1][nx];
				
				map[ny + 1][nx] = tmp;
			}
			ny++;
			nx++;
			sz += 2;
			idx++;
		}
		
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++)
				bw.write(map[i][j] + " ");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
