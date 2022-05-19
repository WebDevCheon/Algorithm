package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 구명보트 {

	private static int[] weight;
	private static ArrayList<Integer> wlist = new ArrayList<Integer>();
	
	public static int solution(int[] people,int limit) {
		int ans = 0;
		for(int i = 0;i < people.length;i++)
			wlist.add(people[i]);
		Collections.sort(wlist);
		for(int i = 0;i < wlist.size();i++) {
			for(int j = wlist.size()-1; j > i;j--) {
				
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int limit = Integer.parseInt(br.readLine());
		weight = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			weight[i] = Integer.parseInt(st.nextToken());
		System.out.println(solution(weight,limit));
	}
}
