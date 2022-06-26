package Programmers;

import java.util.ArrayList;

public class 하노이의탑 {
	
	private static int[][] ans;
	private static ArrayList<Info> infos = new ArrayList<Info>();
	
	static class Info {
		int from;
		int to;
		public Info(int from,int to) {
			this.from = from;
			this.to = to;
		}
	}
	
	private static void hanoi(int n,int from,int mid,int to) {
		if(n == 1) {
			infos.add(new Info(from,to));
			return;
		}
		hanoi(n - 1,from,to,mid);
		infos.add(new Info(from,to));
		hanoi(n - 1,mid,from,to);
	}
	
	public static int[][] solution(int n) {
		hanoi(n,1,2,3);
		ans = new int[infos.size()][2];
		for(int i = 0;i < ans.length;i++) {
			ans[i][0] = infos.get(i).from;
			ans[i][1] = infos.get(i).to;
		}
		return ans;
    }
	
	public static void main(String[] args) throws Exception {
		solution(4);
	}
}
