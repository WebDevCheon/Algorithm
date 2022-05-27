package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N으로표현 {

	private static ArrayList<Integer>[] dp = new ArrayList[9];
	private static int n;					// 5
	private static int number;				// 12
	private static boolean[] visited = new boolean[32001];
	private static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		number = Integer.parseInt(st.nextToken());
		for(int i = 1;i <= 8;i++)
			dp[i] = new ArrayList<Integer>();
		for(int i = 1;i <= 8;i++) {
			String str = "";
			for(int j = 0;j < i;j++)
				str += '1';
			int k = Integer.valueOf(str);
			if(k * n > 32000)
				continue;
			visited[k * n] = true;
			dp[i].add(k * n);
		}

		for(int i = 2;i <= 8;i++) {
			for(int j = 1;j < i;j++) {
				for(int k = 0;k < dp[j].size();k++) {
					int num = dp[j].get(k);
					for(int g = 0;g < dp[i-j].size();g++) {
						int tmp = dp[i-j].get(g);
						//for(int l = 0;l < 4;l++) {
							int data = num + tmp;
							if(map.get(data) == null)
								map.put(data,i);
							dp[i].add(data);
							
							if(number == data) {
								System.out.println(i);
								System.exit(0);
							}
							
							data = num * tmp;
							if(map.get(data) == null)
								map.put(data,i);
							dp[i].add(data);
							
							if(number == data) {
								System.out.println(i);
								System.exit(0);
							}
							
							data = num - tmp;
							if(map.get(data) == null)
								map.put(data,i);
							dp[i].add(data);
							
							if(number == data) {
								System.out.println(i);
								System.exit(0);
							}
							
							
							data = tmp - num;
							if(map.get(data) == null)
								map.put(data,i);
							dp[i].add(data);
							
							if(number == data) {
								System.out.println(i);
								System.exit(0);
							}
							
							if(tmp != 0) {
							data = num / tmp;
							if(map.get(data) == null)
								map.put(data,i);
							dp[i].add(data);
							
							if(number == data) {
								System.out.println(i);
								System.exit(0);
							}
							}
							
							if(num != 0) {
							data = tmp / num;
							if(visited[data])
								continue;
							visited[data] = true;
							dp[i].add(data);
							
							if(number == data) {
								System.out.println(i);
								System.exit(0);
							}
							}
							/*
							if(l == 0) {		// 더하기
								int data = num + tmp;
								if(data > 32000 || visited[data])
									continue;
								visited[data] = true;
								dp[i].add(data);
								if(number == data) {
									System.out.println(i);
									System.exit(0);
								}
							} else if(l == 1) {	// 곱하기
								int data = num * tmp;
								if(data > 32000 || visited[data])
									continue;
								visited[data] = true;
								dp[i].add(data);
								if(number == data) {
									System.out.println(i);
									System.exit(0);
								}
								if(number == data) {
									System.out.println(i);
									System.exit(0);
								}
							} else if(l == 2) {	// 빼기
								int data = num - tmp;
								if(data < 0 || visited[data])
									continue;
								visited[data] = true;
								dp[i].add(data);
								if(number == data) {
									System.out.println(i);
									System.exit(0);
								}
							} else {			// 나누기
								if(tmp == 0)
									continue;
								int data = num / tmp;
								if(visited[data])
									continue;
								visited[data] = true;
								dp[i].add(data);
								if(number == data) {
									System.out.println(i);
									System.exit(0);
								}
							}
							*/
						//}
					}
				}
			}
		}
		System.out.println(-1);
	}
}
