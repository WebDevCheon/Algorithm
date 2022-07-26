package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 페그솔리테어 {
	
	private static char[][] map;
	private static int n = 5;
	private static int m = 9;
	private static int[] dx = {1,0,-1,0};
	private static int[] dy = {0,1,0,-1};
	private static int ansPin;
	private static int ansMove;
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	private static void dfs(int remainPin,int move,char[][] copyMap) {
		if(ansPin >= remainPin) {			
			if(ansPin == remainPin) {
				if(ansMove > move)
					ansMove = move;
			} else {
				ansPin = remainPin;
				ansMove = move;
			}
		}
		
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				if(copyMap[i][j] == 'o') {
					for(int k = 0;k < dx.length;k++) {
						int nx = j + dx[k];
						int ny = i + dy[k];
						
						if(!isRange(ny,nx) || copyMap[ny][nx] == '#')
							continue;
						
						if(copyMap[ny][nx] == 'o') {
							int nnx = nx + dx[k];
							int nny = ny + dy[k];
							
							if(!isRange(nny,nnx) || copyMap[nny][nnx] != '.')
								continue;
							
							char[][] newCopyMap = new char[n][m];
							for(int a = 0;a < n;a++) {
								for(int b = 0;b < m;b++) {
									if(a == i && b == j)
										newCopyMap[a][b] = '.';
									else if(a == ny && b == nx)
										newCopyMap[a][b] = '.';
									else if(a == nny && b == nnx)
										newCopyMap[a][b] = 'o';
									else
										newCopyMap[a][b] = copyMap[a][b];
								}
							}
							dfs(remainPin - 1,move + 1,newCopyMap);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			ansPin = Integer.MAX_VALUE;
			ansMove = Integer.MAX_VALUE;
			int remainPin = 0;
			map = new char[n][m];
			
			for(int i = 0;i < n;i++) {
				String str = br.readLine();
				for(int j = 0;j < m;j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'o')
						remainPin++;
				}
			}
			dfs(remainPin,0,map);
			bw.write(ansPin + " " + ansMove + "\n");
			if(testcase > 0)
				br.readLine();
		}
		bw.flush();
	}
}
