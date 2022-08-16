package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 222-풀링 {

	private static int[][] map;
	private static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int N = n;

		while (N > 2) {
			int[][] tmp = new int[N / 2][N / 2];
			int x = 0;
			int y = 0;
			
			for (int i = 0; i < N; i += 2) {
				for (int j = 0; j < N; j += 2) {

					ArrayList<Integer> list = new ArrayList<Integer>();
					for (int k = i; k < i + 2; k++) {
						for (int t = j; t < j + 2; t++)
							list.add(map[k][t]);
					}
					Collections.sort(list);
					int k = list.get(2);
					tmp[y][x] = k;
					x++;
				}
				y++;
				x = 0;
			}
			map = new int[N / 2][N / 2];
			for (int i = 0; i < N / 2; i++)
				for (int j = 0; j < N / 2; j++)
					map[i][j] = tmp[i][j];
			N /= 2;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i < N;i++)
			for(int j = 0;j < N;j++)
				list.add(map[i][j]);
		Collections.sort(list);
		System.out.println(list.get(list.size() - 2));
	}
}
