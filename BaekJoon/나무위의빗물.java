package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 나무위의빗물 {

	private static int n;
	private static int water;
	private static ArrayList<Integer>[] rel;
	private static int root = 1;
	private static int leafSize;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		water = Integer.parseInt(st.nextToken());
		rel = new ArrayList[n + 1];
		for(int i = 1;i <= n;i++)
			rel[i] = new ArrayList<Integer>();
		for(int i = 0;i < n - 1;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			rel[v1].add(v2);
			rel[v2].add(v1);
		}
		for(int i = 2;i <= n;i++) {
			if(rel[i].size() == 1)
				leafSize++;
		}
		System.out.printf("%.10f", water / (double)leafSize);
	}
}
