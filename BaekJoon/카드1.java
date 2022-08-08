package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1;i <= n;i++)
			q.add(i);
		int idx = 0;
		while(q.size() != 1) {
			if(idx % 2 == 0)
				System.out.print(q.poll() + " ");
			else
				q.add(q.poll());
			idx++;
		}
		System.out.println(q.poll());
	}
}
