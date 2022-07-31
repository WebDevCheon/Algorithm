package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BABBA {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int[] a = new int[46];
		int[] b = new int[46];
		a[0] = 1;
		
		for(int i = 1;i <= 45;i++) {
			a[i] += b[i - 1];
			b[i] += (a[i - 1] + b[i - 1]);
		}
		System.out.println(a[k] + " " + b[k]);
	}
}
