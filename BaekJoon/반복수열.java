package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 반복수열 {
	
	private static Set<Integer> set = new HashSet<Integer>();
	private static Map<Integer,Integer> idxByNum = new HashMap<Integer,Integer>();
	private static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int k = -1;
		list.add(A);
		set.add(A);
		int idx = 0;
		idxByNum.put(A,idx);
		
		while(true) {
			int num = list.get(idx);
			int sum = 0;
			
			while(num > 0) {
				sum += Math.pow(num % 10,P);
				num /= 10;
			}
			if(set.contains(sum)) {
				k = sum;
				break;
			}
			idx++;
			idxByNum.put(sum,idx);
			set.add(sum);
			list.add(sum);
		}
		idx = idxByNum.get(k);
		System.out.println(idx);
	}
}
