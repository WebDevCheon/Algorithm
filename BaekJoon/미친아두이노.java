package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 미친아두이노 {

	private static ArrayList<pos>[][] map;
	private static int n;
	private static int m;
	private static pos robot;
	private static List<pos> enemyRobotList = new ArrayList<pos>();
	private static int[] dx = {-2,-1,0,1,-1,0,1,-1,0,1};
	private static int[] dy = {-2,1,1,1,0,0,0,-1,-1,-1};
	
	static class pos {
		int x;
		int y;
		public pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean isRange(int y,int x) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new ArrayList[n][m];
		for(int i = 0;i < n;i++)
			for(int j = 0;j < m;j++)
				map[i][j] = new ArrayList<pos>();
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			for(int j = 0;j < str.length();j++) {
				char ch = str.charAt(j);
				if(ch == 'I') {
					robot = new pos(j,i);
					map[i][j].add(robot);
				} else if(ch == 'R') {
					pos enemy = new pos(j,i);
					enemyRobotList.add(enemy);
					map[i][j].add(enemy);
				}
			}
		}
		
		String dirStr = br.readLine();
		
		for(int i = 0;i < dirStr.length();i++) {
			ArrayList<pos>[][] newMap = new ArrayList[n][m];
			for(int j = 0;j < n;j++)
				for(int k = 0;k < m;k++)
					newMap[j][k] = new ArrayList<pos>();
			
			int dir = Integer.valueOf(String.valueOf(dirStr.charAt(i)));
			robot.x += dx[dir];
			robot.y += dy[dir];
			
			if(dir != 5 && !map[robot.y][robot.x].isEmpty()) {
				bw.write("kraj " + (i + 1));
				bw.flush();
				System.exit(0);
			}
			newMap[robot.y][robot.x].add(robot); 
			
			for(int j = 0;j < enemyRobotList.size();j++) {
				pos enemy = enemyRobotList.get(j);
				int sum = Integer.MAX_VALUE;
				int idx = -1;
				
				for(int k = 1;k < dx.length;k++) {
					int nx = enemy.x + dx[k];
					int ny = enemy.y + dy[k];
					if(!isRange(ny,nx))
						continue;
					if((ny == robot.y && nx == robot.x)) {
						bw.write("kraj " + (i + 1));
						bw.flush();
						System.exit(0);
					}
					int tmp = Math.abs(robot.y - ny) + Math.abs(robot.x - nx);
					if(tmp < sum) {
						sum = tmp;
						idx = k;
					}
				}
				enemy.x += dx[idx];
				enemy.y += dy[idx];
				newMap[enemy.y][enemy.x].add(enemy);
			}
			
			for(int j = 0;j < n;j++) {
				for(int k = 0;k < m;k++) {
					if(newMap[j][k].size() >= 2) {
						for(int l = 0;l < newMap[j][k].size();l++) {
							pos p = newMap[j][k].get(l);
							enemyRobotList.remove(p);
						}
						newMap[j][k].clear();
					}
				}
			}
			map = newMap;
		}
		
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				if(map[i][j].isEmpty())
					bw.write(".");
				else if(robot.y == i && robot.x == j)
					bw.write("I");
				else
					bw.write("R");
			}
			bw.newLine();
		}
		bw.flush();
	}
}
