package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무한이진트리 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int left = 0;
		int right = 0;

		while(a != 1 || b != 1) {
			if(a > b) {
				a -= b;
				left++;
			} else {
				b -= a;
				right++;
			}
		}
		System.out.println(left + " " + right);
	}
}
