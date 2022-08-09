package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 트리나라관광가이드 {

	private static int[] parent;
	private static boolean[] visited;
	private static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;		
		
		for(int i = 0;i < n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i],max);
		}
		parent = new int[max + 1];
		visited = new boolean[max + 1];
		
		for(int i = 0;i < n;i++) {
			int v = arr[i];
			
			if(i == 0) {
				visited[v] = true;
				parent[v] = -1;
			} else {
				if(!visited[v]) {
					visited[v] = true;
					parent[v] = arr[i - 1];
				}
			}
		}
		bw.write(max + 1 + "\n");
		for(int i = 0;i <= max;i++)
			bw.write(parent[i] + " ");
		bw.flush();
		br.close();
		bw.close();
	}
}
