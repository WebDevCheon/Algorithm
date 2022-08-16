package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 도로와신호등 {

	private static int n;
	private static int l;
	private static Map<Integer,sinho> map = new HashMap<Integer,sinho>();
	private static Map<Integer,Integer> distRedMap = new HashMap<Integer,Integer>();
	private static Map<Integer,Integer> distGreenMap = new HashMap<Integer,Integer>();
	
	static class sinho {
		int dist;
		int r;
		int g;
		boolean red = true;
		boolean green = false;
		
		public sinho(int dist,int r,int g) {
			this.dist = dist;
			this.r = r;
			this.g = g;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		int[] red = new int[n];
		int[] green = new int[n];
		
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			map.put(l, new sinho(l,r,g));
			distRedMap.put(l, r);
			distGreenMap.put(l, g);
			red[i] = r;
			green[i] = g;
		}
		int ans = 0;
		int now = 0;
		
		while(now < l) {
			if(map.get(now) == null) {
				now++;
				ans++;
			} else {
				if(map.get(now).red)
					ans++;
				else if(map.get(now).green) {
					now++;
					ans++;
				}
			}
			Set<Integer> keySet = map.keySet();
			Iterator<Integer> itr = keySet.iterator();
			
			while(itr.hasNext()) {
				sinho s = map.get(itr.next());
				if(s.red) {
					s.r--;
					if(s.r == 0) {
						s.r = distRedMap.get(s.dist);
						s.green = true;
						s.red = false;
					}
				} else if(s.green) {
					s.g--;
					if(s.g == 0) {
						s.g = distGreenMap.get(s.dist);
						s.red = true;
						s.green = false;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}
