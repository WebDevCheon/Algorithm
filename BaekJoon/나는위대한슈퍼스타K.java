package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 나는위대한슈퍼스타K {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		double[] d = new double[n];
		
		for(int i = 0;i < m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j < n;j++) {
				int num = Integer.parseInt(st.nextToken()) - 1;
				double value = Double.parseDouble(st.nextToken());
				d[num] = Math.max(value,d[num]);
			}
		}
		ArrayList<Double> list = new ArrayList<Double>();
		for(int i = 0;i < d.length;i++) {
			list.add(d[i]);
		}
		Collections.sort(list);
		double sum = 0;
		int t = 0;
		
		for(int i = list.size() - 1; i >= 0;i--) {
			sum += list.get(i);
			t++;
			if(t == k)
				break;
		}
		System.out.println(String.format("%.1f", sum));
	}
}
