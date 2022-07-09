package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 배열돌리기 {
	
	private static int[][] map;
	private static int n;
	private static int m;
	private static int[][] tmp;
	private static int[][] ans;
	
	private static int[][] func(int num) {
		if(num == 1) {
			tmp = new int[n][m];
			for(int i = 0;i < n / 2;i++) {
				for(int j = 0;j < m;j++) {
					tmp[i][j] = map[n - 1 - i][j];
					tmp[n - 1 - i][j] = map[i][j];
				}
			}
		} else if(num == 2) {
			tmp = new int[n][m];
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < m / 2;j++) {
					tmp[i][j] = map[i][m - 1 - j];
					tmp[i][m - 1 - j] = map[i][j];
				}
			}
		} else if(num == 3) {
			tmp = new int[m][n];
			for(int i = 0;i < m;i++)
				for(int j = 0;j < n;j++)
					tmp[i][j] = map[n - 1 - j][i];
		} else if(num == 4) {
			tmp = new int[m][n];
			for(int i = 0;i < m;i++)
				for(int j = 0;j < n;j++)
					tmp[i][j] = map[j][m - 1 - i];
		} else if(num == 5) {
			tmp = new int[n][m];
			int sx = 0; int sy = 0;
			for(int i = sy;i < sy + n / 2;i++)
				for(int j = sx;j < sx + m / 2;j++)
					tmp[i][j + m / 2] = map[i][j];
			
			sx = m / 2; sy = 0;
			for(int i = sy;i < sy + n / 2;i++)
				for(int j = sx;j < sx + m / 2;j++)
					tmp[i + n / 2][j] = map[i][j];
			
			sx = m / 2; sy = n / 2;
			for(int i = sy;i < sy + n / 2;i++)
				for(int j = sx;j < sx + m / 2;j++)
					tmp[i][j - m / 2] = map[i][j];
			
			sx = 0; sy = n / 2;
			for(int i = sy;i < sy + n / 2;i++)
				for(int j = sx;j < sx + m / 2;j++)
					tmp[i - n / 2][j] = map[i][j];
		} else if(num == 6) {
			tmp = new int[n][m];
			int sx = 0; int sy = 0;
			for(int i = sy;i < sy + n / 2;i++)
				for(int j = sx;j < sx + m / 2;j++)
					tmp[i + n / 2][j] = map[i][j];
			
			sx = m / 2; sy = 0;
			for(int i = sy;i < sy + n / 2;i++)
				for(int j = sx;j < sx + m / 2;j++)
					tmp[i][j - m / 2] = map[i][j];
			
			sx = m / 2; sy = n / 2;
			for(int i = sy;i < sy + n / 2;i++)
				for(int j = sx;j < sx + m / 2;j++)
					tmp[i - n / 2][j] = map[i][j];
			
			sx = 0; sy = n / 2;
			for(int i = sy;i < sy + n / 2;i++)
				for(int j = sx;j < sx + m / 2;j++)
					tmp[i][j + m / 2] = map[i][j];
		}
		return tmp;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		List<Integer> opList = new ArrayList<Integer>();
		
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < m;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		while(k-- > 0) {
			opList.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0;i < opList.size();i++) {
			map = func(opList.get(i));
			n = map.length;
			m = map[0].length;
		}
		
		for(int i = 0;i < map.length;i++) {
			for(int j = 0;j < map[0].length;j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}
}
