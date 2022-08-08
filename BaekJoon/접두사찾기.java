package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 접두사찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<String>[] set = new HashSet[27];
		for(int i = 0;i < 27;i++)
			set[i] = new HashSet<String>();
		for(int i = 0;i < n;i++) {
			String str = br.readLine();
			int idx = str.charAt(0) - 'a';
			set[idx].add(str);
		}
		int ans = 0;
		for(int i = 0;i < m;i++) {
			String str = br.readLine();
			int idx = str.charAt(0) - 'a';
			for(String savedStr : set[idx]) {
				if(savedStr.indexOf(str) == 0) {
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
