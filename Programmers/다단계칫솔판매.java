package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 다단계칫솔판매 {

	private static Map<String,String> childToParent = new HashMap<String,String>();
	private static Map<String,Integer> nowToNum = new HashMap<String,Integer>();
	private static int[] ans;
	private static String[] enroll;
	private static int e;
	private static String[] referral;
	private static String[] seller;
	private static int n;
	private static int[] amount;
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		e = enroll.length;
		n = seller.length;
		ans = new int[e];
		
		for(int i = 0;i < e;i++)
			childToParent.put(enroll[i],referral[i]);
		for(int i = 0;i < e;i++)
			nowToNum.put(enroll[i],i);
		
		for(int i = 0;i < n;i++) {
			String now = seller[i];
			int p = amount[i] * 100;
			
			while(!now.equals("-")) {
				int profitsForParent = p / 10;
				int nowProfit = p - profitsForParent;		// 현재의 이익
				
				ans[nowToNum.get(now)] += nowProfit;
				
				now = childToParent.get(now);
				p /= 10;
				if(p < 1)
					break;
			}
		}
		return ans;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		e = Integer.parseInt(br.readLine());
		enroll = new String[e];
		referral = new String[e];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < e;i++)
			enroll[i] = st.nextToken();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < e;i++)
			referral[i] = st.nextToken();
		n = Integer.parseInt(br.readLine());
		seller = new String[n];
		amount = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			seller[i] = st.nextToken();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			amount[i] = Integer.parseInt(st.nextToken());
		int[] ans = solution(enroll,referral,seller,amount);
		for(int i = 0;i < e;i++)
			System.out.print(ans[i] + " ");
	}
}
