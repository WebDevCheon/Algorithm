package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 방번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < str.length(); i++)
			q.add(Integer.valueOf(String.valueOf(str.charAt(i))));
		int ans = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			boolean[] visited = new boolean[10];
			
			for (int i = 0; i < size; i++) {
				int k = q.poll();
				if (k == 6 || k == 9) {
					if (!visited[6])
						visited[6] = true;
					else if (!visited[9])
						visited[9] = true;
					else
						q.add(k);
				} else {
					if (!visited[k])
						visited[k] = true;
					else
						q.add(k);
				}
			}
			ans++;
		}
		System.out.println(ans);
	}
}
