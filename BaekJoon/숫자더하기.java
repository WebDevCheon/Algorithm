package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 숫자더하기 {
	
	private static long ans;
	private static List<Integer> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n == 0)
				break;
			ans = Integer.MAX_VALUE;
			list = new ArrayList<Integer>();
			for(int i = 0;i < n;i++)
				list.add(Integer.parseInt(st.nextToken()));
			Collections.sort(list);
			String str1 = "";
			String str2 = "";
			
			int idx = 0;
			if(list.contains(0)) {
				for(int i = 0;i < list.size();i++) {
					if(list.get(i) > 0) {
						str1 += list.remove(i);
						break;
					}
				}
				for(int i = 0;i < list.size();i++) {
					if(list.get(i) > 0) {
						str2 += list.remove(i);
						break;
					}
				}
			}
			while(!list.isEmpty()) {
				if(idx % 2 == 0)
					str1 += list.remove(0);
				else
					str2 += list.remove(0);
				idx++;
			}
			long n1 = Long.valueOf(str1);
			long n2 = Long.valueOf(str2);
			ans = Math.min(n1 + n2,ans);
			bw.write(ans + "\n");
		}
		bw.flush();
	}
}
