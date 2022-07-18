package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 모노톤길 {

	private static ArrayList<pos> list;
	private static pos[] ans;
	private static LinkedList<pos>[] tmpPos;
	
	static class pos implements Comparable<pos> {
		int x;
		int y;
		public pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(pos otherPos) {
			if(this.x < otherPos.x)
				return -1;
			else if(this.x > otherPos.x)
				return 1;
			else {
				if(this.y < otherPos.y) {
					return -1;
				}
				return 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int maxX = Integer.MIN_VALUE;
			ans = new pos[n + 1];
			list = new ArrayList<pos>();
			
			for(int i = 0;i < n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				maxX = Math.max(x,maxX);
				list.add(new pos(x,y));
			}
			Collections.sort(list);
			tmpPos = new LinkedList[maxX + 1];
			for(int i = 0;i < maxX + 1;i++)
				tmpPos[i] = new LinkedList<pos>();
			for(int i = 0;i < list.size();i++)
				tmpPos[list.get(i).x].add(list.get(i));
			pos now = new pos(0,0);
			int cnt = 1;
			
			for(int i = 0;i < maxX + 1;i++) {
				if(tmpPos[i].size() == 0)
					continue;
				if(now.y == tmpPos[i].getFirst().y) {
					while(!tmpPos[i].isEmpty()) {
						pos p = tmpPos[i].pollFirst();
						ans[cnt++] = p;
						now = p;
					}
				} else if(now.y == tmpPos[i].getLast().y) {
					while(!tmpPos[i].isEmpty()) {
						pos p = tmpPos[i].pollLast();
						ans[cnt++] = p;
						now = p;
					}
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int i = 0;i < k;i++) {
				int num = Integer.parseInt(st.nextToken());
				pos p = ans[num];
				bw.write(p.x + " " + p.y + "\n");
			}
		}
		bw.flush();
	}
}
