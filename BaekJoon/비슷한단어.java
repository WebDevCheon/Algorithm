package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 비슷한단어 {

	private static int n;
	private static String str;
	private static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		for(int i = 1;i < n;i++) {
			String input = br.readLine();
			if(Math.abs(input.length() - str.length()) >= 2)
				continue;
			List<Character> list = new ArrayList<Character>();
			for(int j = 0;j < input.length();j++)
				list.add(input.charAt(j));
			
			for(int j = 0;j < str.length();j++) {
				int idx = list.indexOf(str.charAt(j));
				if(idx != -1)
					list.remove(idx);
			}
			
			if(str.length() == input.length() + 1) {
				if(list.size() == 0)
					ans++;
			} else if(str.length() == input.length()) {
				if(list.size() <= 1)
					ans++;
			} else if(str.length() == input.length() - 1) {
				if(list.size() <= 1)
					ans++;
			}
		}
		bw.write(ans + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
