package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 경쟁적전염 {
	
	private static int[][] map;
	private static ArrayList<pos>[] posList;
	private static int n;
	private static int k;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static int s;
	private static int y;
	private static int x;
	
	static class pos {
		int x;
		int y;
		int num;
		public pos(int x,int y,int num) {
			this.x = x; this.y = y; this.num = num;
		}
	}
	
	private static void init(BufferedReader br,int n,int k) throws Exception {
		map = new int[n][n];
		posList = new ArrayList[k + 1];
		for(int i = 0;i < k + 1;i++)
			posList[i] = new ArrayList<pos>();
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j < n;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n;j++) {
				if(map[i][j] > 0)
					posList[map[i][j]].add(new pos(j,i,map[i][j]));
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken()) - 1;
		x = Integer.parseInt(st.nextToken()) - 1;
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		init(br,n,k);
		
		while(s-- > 0) {
			if(map[y][x] > 0) {
				System.out.println(map[y][x]);
				System.exit(0);
			}
			
			for(ArrayList<pos> list : posList) {
				if(list.size() == 0)
					continue;
				ArrayList<pos> tmpList = new ArrayList<pos>();
				
				for(int i = 0;i < list.size();i++) {
					for(int j = 0;j < dx.length;j++) {
						pos p = list.get(i);
					
						int nx = p.x + dx[j];
						int ny = p.y + dy[j];
					
						if(!isRange(ny,nx) || map[ny][nx] > 0)
							continue;
						map[ny][nx] = p.num;
						tmpList.add(new pos(nx,ny,map[ny][nx]));
					}
				}
				list.addAll(tmpList);
			}
		}
		System.out.println(map[y][x]);
	}
}
