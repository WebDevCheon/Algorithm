package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 단축키지정 {
	
	private static boolean[] visited = new boolean[26];
	private static List<String> ans = new ArrayList<String>();
	
	private static boolean firstAlpha(List<String> list) {
		int idx = -1;
		
		for(int i = 0;i < list.size();i++) {
			String str = list.get(i);
			
			if((str.charAt(0) >= 'A' && str.charAt(0) <= 'Z' && !visited[str.charAt(0) - 'A']) || (str.charAt(0) >= 'a' && str.charAt(0) <= 'z' && !visited[str.charAt(0) - 'a'])) {
				StringBuilder sb = new StringBuilder(str);
				sb.insert(0,'[');
				sb.insert(2,']');
				list.set(i, sb.toString());
				
				if(str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') {
					visited[str.charAt(0) - 'A'] = true;
					idx = str.charAt(0) - 'A';
				} else if(str.charAt(0) >= 'a' && str.charAt(0) <= 'z') {
					visited[str.charAt(0) - 'a'] = true;
					idx = str.charAt(0) - 'a';
				}
				break;
			}
		}
		return (idx == -1) ? false : true;
	}
	
	private static void secondAlpha(List<String> list) {
		for(int i = 0;i < list.size();i++) {
			String str = list.get(i);
			StringBuilder sb = new StringBuilder(str);
			boolean escape = false;
			
			for(int j = 0;j < str.length();j++) {
				if((str.charAt(j) >= 'A' && str.charAt(j) <= 'Z' && !visited[str.charAt(j) - 'A']) || (str.charAt(j) >= 'a' && str.charAt(j) <= 'z' && !visited[str.charAt(j) - 'a'])) {
					if(str.charAt(j) >= 'A' && str.charAt(j) <= 'Z')
						visited[str.charAt(j) - 'A'] = true;
					else if(str.charAt(j) >= 'a' && str.charAt(j) <= 'z')
						visited[str.charAt(j) - 'a'] = true;
					sb.insert(j,'[');
					sb.insert(j + 2,']');
					escape = true;
					break;
				}
			}
			if(escape) {
				list.set(i, sb.toString());
				break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<String> list = new ArrayList<String>();
			while(st.hasMoreTokens())
				list.add(st.nextToken());
			boolean check = firstAlpha(list);
			if(!check)
				secondAlpha(list);
			
			String str = "";
			for(int j = 0;j < list.size();j++) {
				str += list.get(j);
				str += " ";
			}
			ans.add(str);
		}
		
		for(String str : ans) {
			System.out.println(str);
		}
	}
}
