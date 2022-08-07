package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에라토스테네스의체 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[n + 1];
		
		int idx = 1;
		
		for(int i = 2;i <= n;i++) {
			for(int j = i;j <= n;j += i) {
				if(!visited[j]) {
					if(idx == k) {
						System.out.println(j);
						System.exit(0);
					}
					visited[j] = true;
					idx++;
				}
			}
		}
	}
}
