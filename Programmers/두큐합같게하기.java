package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 두큐합같게하기 {
	
	public static int solution(int[] queue1, int[] queue2) {
		LinkedList<Integer> q1 = new LinkedList<Integer>();
		LinkedList<Integer> q2 = new LinkedList<Integer>();
		long sum1 = 0;
		long sum2 = 0;
		long target = 0;
		int maxNum = Integer.MIN_VALUE;
		for(int i = 0;i < queue1.length;i++) {
			q1.add(queue1[i]);
			q2.add(queue2[i]);
			sum1 += queue1[i];
			sum2 += queue2[i];
			maxNum = Math.max(queue1[i],maxNum);
			maxNum = Math.max(queue2[i],maxNum);
		}
		target = sum1 + sum2;
		if(target % 2 == 1)
			return -1;
		target /= 2;
		if(maxNum > target)
			return -1;
		int ans = 0;
		boolean flag = false;
		
		while(sum1 != target) {
			if(sum1 > target) {
				int num = q1.poll();
				q2.add(num);
				sum1 -= num;
				sum2 += num;
			} else if(sum1 < target) {
				int num = q2.poll();
				q1.add(num);
				sum2 -= num;
				sum1 += num;
			}
			if(ans >= 2 * (q1.size() + q2.size())) {
				flag = true;
				break;
			}
			ans++;
		}
		if(flag)
			return -1;
		return ans;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			arr1[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			arr2[i] = Integer.parseInt(st.nextToken());
		System.out.println(solution(arr1,arr2));
	}
}
