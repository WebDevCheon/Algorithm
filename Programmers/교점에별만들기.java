package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 교점에별만들기 {

	private static List<pos> list = new ArrayList<pos>();
	private static int maxrow = Integer.MIN_VALUE;
	private static int maxcol = Integer.MIN_VALUE;
	private static int minrow = Integer.MAX_VALUE;
	private static int mincol = Integer.MAX_VALUE;
	
	static class pos {
		double x;
		double y;
		
		public pos(double x,double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static String[] solution(int[][] line) {
		int n = line.length;
		
		for(int i = 0;i < n;i++) {
			int A = line[i][0];
			int B = line[i][1];
			int E = line[i][2];
			for(int j = i + 1;j < n;j++) {
				int C = line[j][0];
				int D = line[j][1];
				int F = line[j][2];
				
				if(A*D - B*C == 0)	// 두 직선이 안 만나는 경우
					continue;
				double dx1 = (B*F - E*D);
				double dx2 = (A*D - B*C);
				
				double x = dx1 / (double)dx2;
				
				if(x - (int)x > 0 || x - (int)x < 0)	// double형이라면
					continue;
				if(dx1 == 0)
					x = 0.0;
				
				double dy1 = (E*C - A*F);
				double dy2 = (A*D - B*C);
				
				double y = dy1 / (double)dy2;
				
				if(y - (int)y > 0 || y - (int)y < 0)	// double형이라면
					continue;
				if(dy1 == 0)
					y = 0.0;
				
				maxrow = (int)Math.max(y,maxrow);
				maxcol = (int)Math.max(x,maxcol);
				minrow = (int)Math.min(y,minrow);
				mincol = (int)Math.min(x,mincol);
				list.add(new pos(x,y));
			}
		}
		int newrow = maxrow - minrow;
		int newcol = maxcol - mincol;
		
		String[][] map = new String[newrow][newcol];
		for(int i = 0;i < newrow;i++) {
			for(int j = 0;j < newcol;j++)
				map[i][j] = ".";
		}
		
		for(int i = 0;i < list.size();i++) {
			pos p = list.get(i);
			int x = (int)p.x;
			int y = (int)p.y;
			p.x = x - mincol;
			p.y = y - minrow;
			map[(int)p.y][(int)p.x] = "*";
		}
		for(int i = 0;i < newrow;i++) {
			for(int j = 0;j < newcol;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] line = new int[5][3];
		int row = line.length;
		int col = line[0].length;
		for(int i = 0;i < row;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j < col;j++)
				line[i][j] = Integer.parseInt(st.nextToken());
		}
		solution(line);
	}
}
