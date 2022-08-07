package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> ansList = new ArrayList<Integer>();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1;i <= n;i++)
			q.add(i);
		
		while(!q.isEmpty()) {
			int tmp = 1;
			while(tmp < k) {
				q.add(q.poll());
				tmp++;
			}
			ansList.add(q.poll());
		}
		System.out.print("<");
		for(int i = 0;i < ansList.size();i++) {
			if(i < ansList.size() - 1)
				System.out.print(ansList.get(i) + ", ");
			else
				System.out.print(ansList.get(i));
		}
		System.out.print(">");
	}
}
