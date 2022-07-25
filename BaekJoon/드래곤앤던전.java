package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 드래곤앤던전 {

	private static ArrayList<info> rooms = new ArrayList<info>();
	
	static class info {
		long t;
		long a;
		long h;
		public info(long t,long a,long h) {
			this.t = t;
			this.a = a;
			this.h = h;
		}
	}
	
	private static boolean calc(long maxHP,long atk) {
		long startHP = maxHP;
		
		for(int i = 0;i < rooms.size();i++) {
			info dungeon = rooms.get(i);
			long t = dungeon.t;
			long a = dungeon.a;
			long h = dungeon.h;
			
			if(t == 1) {
				long k = h / atk;	// 용사가 몬스터를 공격해야하는 횟수
				
				if(h % atk == 0)
					k--;		// 이전 단계에 접근하기 위해서
				if(k < 0)			// 몬스터를 없앰
					break;
				maxHP -= k * a;
				if(maxHP <= 0)
					return false;
			} else {				
				atk += a;
				maxHP += h;
				if(maxHP >= startHP)
					maxHP = startHP;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long atk = Long.parseLong(st.nextToken());
		
		for(int i = 0;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			long t = Long.parseLong(st.nextToken());
			long a = Long.parseLong(st.nextToken());
			long h = Long.parseLong(st.nextToken());
			rooms.add(new info(t,a,h));
		}
		
		long ans = 1000000000000L * n;

		long left = 1;
		long right = 1000000000000L * n;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			if(calc(mid,atk)) {
				if(ans > mid)
					ans = mid;
				right = mid - 1;
			} else
				left = mid + 1;
		}
		System.out.println(ans);
	}
}
