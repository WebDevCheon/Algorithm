package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 등수구하기 {

	private static int ans = 1;
	private static int big = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());		
		int tae = Integer.parseInt(st.nextToken());		
		int p = Integer.parseInt(st.nextToken());		
		int[] point = new int[n];
		if(n > 0)
			st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			point[i] = Integer.parseInt(st.nextToken());
		for(int i = 0;i < n;i++) {
			if(tae > point[i])
				break;
			else if(tae == point[i]) {
				big++;
			} else if(tae < point[i]) {
				ans++;
				big++;
			}
		}
		if(p >= ans && p >= big)
			bw.write(ans + "\n");
		else
			bw.write(-1 + "\n");
		bw.flush();
		br.close();
		bw.close();
	}	
}
