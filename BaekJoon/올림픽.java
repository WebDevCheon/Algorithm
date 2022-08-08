package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 올림픽 {
	
	static class nara implements Comparable<nara> {
		int num;
		int a;
		int b;
		int c;
		int ans;
		
		public nara(int num,int a,int b,int c) {
			this.num = num;
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(nara otherNara) {
			if(this.a > otherNara.a)
				return -1;
			else if(this.a < otherNara.a)
				return 1;
			else {
				if(this.b > otherNara.b)
					return -1;
				else if(this.b < otherNara.b)
					return 1;
				else {
					if(this.c > otherNara.c)
						return -1;
					else if(this.c < otherNara.c)
						return 1;
					return 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][3];
		int k = Integer.parseInt(st.nextToken());
		List<nara> list = new ArrayList<nara>();
		for(int i = 1;i <= n;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			arr[i][0] = Integer.parseInt(st.nextToken());		// 금
			arr[i][1] = Integer.parseInt(st.nextToken());		// 은
			arr[i][2] = Integer.parseInt(st.nextToken());		// 동
			list.add(new nara(num,arr[i][0],arr[i][1],arr[i][2]));
		}
		Collections.sort(list);
		int q = 1;
		list.get(0).ans = 1;
		
		for(int i = 1;i < list.size();i++) {
			nara na = list.get(i);
			nara before = list.get(i - 1);
			
			if(na.a < before.a) {
				na.ans = before.ans + q;
				q = 1;
			} else {
				if(na.b < before.b) {
					na.ans = before.ans + q;
					q = 1;
				} else {
					if(na.c < before.c) {
						na.ans = before.ans + q;
						q = 1;
					} else {
						na.ans = before.ans;
						q++;
					}
				}
			}
		}
		
		for(int i = 0;i < list.size();i++) {
			if(list.get(i).num == k) {
				System.out.println(list.get(i).ans);
				System.exit(0);
			}
		}
	}
}
