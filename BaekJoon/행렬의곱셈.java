package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬의곱셈 {

	private static int n;
	private static int m;
	private static int k;
	private static int[][] matrix1;
	private static int[][] matrix2;
	private static int[][] matrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix1 = new int[n][m];
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < m;j++)
				matrix1[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		matrix2 = new int[m][k];
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < k;j++)
				matrix2[i][j] = Integer.parseInt(st.nextToken());
		}
		matrix = new int[n][k];

		for(int i = 0;i < n;i++) {
			for(int j = 0;j < k;j++) {
				for(int a = 0;a < m;a++)
					matrix[i][j] += (matrix1[i][a] * matrix2[a][j]);
			}
		}
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < k;j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
}
