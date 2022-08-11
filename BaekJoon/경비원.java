package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 경비원 {
	
	private static List<info> list = new ArrayList<info>();
	private static info sang;
	private static int n;
	private static int m;
	private static int ans;
	
	static class info {
		int loc;
		int dist;
		
		public info(int loc,int dist) {
			this.loc = loc;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		for(int i = 0;i < k;i++) {
			st = new StringTokenizer(br.readLine());
			int loc = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			list.add(new info(loc,dist));
		}
		st = new StringTokenizer(br.readLine());
		sang = new info(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		
		for(int i = 0;i < list.size();i++) {
			info inf = list.get(i);
			
			if(sang.loc == 1 || sang.loc == 2) {
				if(sang.loc == inf.loc) {
					ans += Math.abs(sang.dist - inf.dist);
				} else if(inf.loc == 3 - sang.loc) {
					ans += Math.min(sang.dist + inf.dist,m - sang.dist + m - inf.dist) + n;
				} else {
					if(sang.loc == 1 && inf.loc == 3) {
						ans += sang.dist + inf.dist;
					} else if(sang.loc == 1 && inf.loc == 4) {
						ans += (m - sang.dist) + inf.dist;
					} else if(sang.loc == 2 && inf.loc == 3) {
						ans += sang.dist + (n - inf.dist);
					} else
						ans += (m - sang.dist) + (n - inf.dist);
				}
			} else {
				if(sang.loc == inf.loc) {
					ans += Math.abs(sang.dist - inf.dist);
				} else if(7 - sang.loc == inf.loc) {
					ans += Math.min(sang.dist + inf.dist,n - sang.dist + n - inf.dist) + m;
				} else {
					if(sang.loc == 3 && inf.loc == 1) {
						ans += sang.dist + inf.dist;
					} else if(sang.loc == 3 && inf.loc == 2) {
						ans += (n - sang.dist) + inf.dist;
					} else if(sang.loc == 4 && inf.loc == 1) {
						ans += sang.dist + (m - inf.dist);
					} else
						ans += (n - sang.dist) + (m - inf.dist);
				}
			}
		}
		System.out.println(ans);
	}
}