package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 단어변환 {
	
	private static int n;
	private static int ans = Integer.MAX_VALUE;
	private static boolean[] visited;
	
	private static void dfs(String begin,String target,String[] words,int cnt) {
		if(begin.equals(target)) {
			ans = Math.min(ans,cnt);
			return;
		}
		
		for(int i = 0;i < words.length;i++) {
			if(visited[i])
				continue;
			int len = 0;
			for(int j = 0;j < words[i].length();j++) {
				if(begin.charAt(j) == words[i].charAt(j))
					len++;
			}
			int diff = begin.length() - len;
			if(diff == 1) {
				visited[i] = true;
				dfs(words[i],target,words,cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String begin = br.readLine();
		String target = br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = 0;
		List<String> list = new ArrayList<String>();
		while(st.hasMoreElements())
			list.add(st.nextToken());
		n = list.size();
		visited = new boolean[n];
		String[] words = new String[n];
		for(int i = 0;i < list.size();i++)
			words[i] = list.get(i);
		dfs(begin,target,words,0);
		System.out.println(ans);
	}
}
