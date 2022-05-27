package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H인덱스 {

	private static int solution(int[] citations) {
		int n = citations.length;
		int max = 0;
		for(int i = 0;i <= 10000;i++) {
			int high = 0;
			int low = 0;
			for(int j = 0;j < n;j++) {
				if(i <= citations[j]) {
					high++;
				}
				if(i > citations[j])
					low++;
			}
			if(high >= i && high + low == n)
				max = Math.max(i,max);
		}
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cits = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			cits[i] = Integer.parseInt(st.nextToken());
		System.out.println(solution(cits));
	}
}
