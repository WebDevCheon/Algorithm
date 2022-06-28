package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 모두의마블 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			list.add(Integer.parseInt(st.nextToken()));
		
		int maxidx = 0;
		int tmp = Integer.MIN_VALUE;
		
		for(int i = 0;i < list.size();i++) {
			if(tmp < list.get(i)) {
				tmp = list.get(i);
				maxidx = i;
			}
		}
		
		long max = 0;
		
		while(list.size() > 1) {
			if(maxidx > 0) {
				max += (list.get(maxidx) + list.get(maxidx - 1));
				list.remove(maxidx - 1);
				maxidx--;
			} else if(maxidx < list.size() - 1) {
				max += (list.get(maxidx) + list.get(maxidx + 1));
				list.remove(maxidx + 1);
			}
		}
		System.out.println(max);
	}
}
