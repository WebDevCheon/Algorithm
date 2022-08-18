package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이차원배열의합 {

	private static int[][] map;
	private static int[][] tmp;
	private static int n;
	private static int m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		for(int i = 1;i < n + 1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j < m + 1;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());	
			int x1 = Integer.parseInt(st.nextToken());	
			int y2 = Integer.parseInt(st.nextToken());	
			int x2 = Integer.parseInt(st.nextToken());	

			for(int i = y1;i <= y2;i++) {
				int sum = 0;
				for(int j = x1;j <= x2;j++) {
					if(j == x1)
						sum = map[i][j];
					else
						sum += map[i][j];
				}
				list.add(sum);
			}
			
			int ans = 0;
			for(int i = 0;i < list.size();i++)
				ans += list.get(i);
			bw.write(ans + "\n");
		}
		bw.flush();
	}
}
