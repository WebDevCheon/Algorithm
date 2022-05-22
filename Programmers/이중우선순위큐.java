package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {

	public static int[] solution(String[] operations) {
		PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
		int n = operations.length;
		
		for (int i = 0; i < n; i++) {
			String str = operations[i];
			String[] split = str.split(" ");
			String op = split[0];
			String num = split[1];
			int input = Integer.valueOf(num);

			switch (op) {
			case "I":
				minPQ.add(input);
				maxPQ.add(input);
				break;
			case "D":
				if(minPQ.size() == 0)
					continue;
				if(input == -1) {
					int k = minPQ.poll();
					maxPQ.remove(Integer.valueOf(k));
				} else {
					int k = maxPQ.poll();
					minPQ.remove(Integer.valueOf(k));
				}
				break;
			}
		}
		
		int[] ans = new int[2];
		
		if(minPQ.isEmpty()) {
			ans[0] = 0;
			ans[1] = 0;
		} else {
			ans[0] = maxPQ.poll();
			ans[1] = minPQ.poll();
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] operations = new String[n];
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = "";
			str += st.nextToken() + " ";
			str += st.nextToken();
			operations[i] = str;
		}
		int[] ans = solution(operations);
		System.out.println(ans[0] + " " + ans[1]);
	}
}
