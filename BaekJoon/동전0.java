package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 동전0 {
	
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static int n;
	private static int k;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for(int i = 0;i < n;i++)
			list.add(Integer.parseInt(br.readLine()));
		int ans = 0;
		
		while(k > 0) {
			int coin = 0;
			for(int i = list.size() - 1;i >= 0;i--) {
				if(k >= list.get(i)) {
					coin = list.get(i);
					break;
				}
			}
			ans += k / coin;
			k %= coin;
		}
		System.out.println(ans);
	}
}
