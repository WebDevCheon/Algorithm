package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 단체사진찍기 {

	private static String[] arr = new String[8];
	private static String[] charac = {"A","C","F","J","M","N","R","T"};
	private static boolean[] visited = new boolean[30];
	private static int ans;
	private static List<check> list = new ArrayList<check>();
	
	static class check {
		String first;
		String second;
		String what;
		int cnt;
		
		public check(String first,String second,String what,int cnt) {
			this.first = first;
			this.second = second;
			this.what = what;
			this.cnt = cnt;
		}
	}
	
	private static boolean CanStand() {
		int fidx = 0;
		int sidx = 0;
		boolean check = false;

		for(int i = 0;i < list.size();i++) {
			String first = list.get(i).first;
			String second = list.get(i).second;
			String what = list.get(i).what;
			int cnt = list.get(i).cnt;
			
			for(int j = 0;j < 8;j++) {
				if(first.equals(arr[j]))
					fidx = j;
				else if(second.equals(arr[j]))
					sidx = j;
			}
			int dist = Math.abs(fidx - sidx);
			
			if(what.equals("=")) {
				if(dist - 1 == cnt)
					continue;
				else {
					check = true;
					break;
				}
			} else if(what.equals(">")) {
				if(dist - 1 > cnt)
					continue;
				else {
					check = true;
					break;
				}
			} else if(what.equals("<")) {
				if(dist - 1 < cnt)
					continue;
				else {
					check = true;
					break;
				}
			}
		}
		if(!check)				// check == false;
			return true;
		return false;			// check == true;
	}

	private static void standing(int idx) {
		if(idx == 8) {
			if(CanStand())
				ans++;
			return;
		}
		
		for(int i = 0;i < 8;i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			arr[idx] = charac[i];
			standing(idx + 1);
			visited[i] = false;
		}
	}
	
	public static int solution(int n,String[] data) {
		for(int i = 0;i < n;i++) {
			String first = String.valueOf(data[i].charAt(0));
			String second = String.valueOf(data[i].charAt(2));
			String what = String.valueOf(data[i].charAt(3));
			int cnt = Integer.valueOf(String.valueOf(data[i].charAt(4)));
			list.add(new check(first,second,what,cnt));
		}
		standing(0);
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] data = new String[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			data[i] = st.nextToken();
		int ans = solution(n,data);
		System.out.println(ans);
	}
}

