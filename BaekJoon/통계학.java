package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 통계학 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int[] arr = new int[n];
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int maxCnt = 0;
		for(int i = 0;i < n;i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			map.put(num,map.getOrDefault(arr[i], 0) + 1);
			maxCnt = Math.max(map.get(arr[i]),maxCnt);
			sum += arr[i];
		}
		
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = map.keySet();
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			int num = itr.next();
			int cnt = map.get(num);
			maxCnt = Math.max(cnt,maxCnt);
		}
		itr = set.iterator();
		while(itr.hasNext()) {
			int num = itr.next();
			if(maxCnt == map.get(num))
				list.add(num);
		}
		
		Collections.sort(list);
		int maxAns = 0;
		if(list.size() == 1)
			maxAns = list.get(0);
		else
			maxAns = list.get(1);
		Arrays.sort(arr);
		
		System.out.println((int)Math.round(sum / (double)n));
		System.out.println(arr[n / 2]);
		System.out.println(maxAns);	
		System.out.println(arr[n - 1] - arr[0]);
	}
}
