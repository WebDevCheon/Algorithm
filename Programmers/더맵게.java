package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ���ʰ� {		// 16�� �ҿ�
	
	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0;i < scoville.length;i++)
			pq.add(scoville[i]);
		int ans = 0;
		int min = pq.peek();
		boolean flag = false;
		
		while(pq.size() > 1) {		// �ڵ� ��¦ ������ -> while(pq.peek() <= K)�� �ϰ� �ٷ� �Ʒ� if(pq.size() == 1) return; �� ������
			int v1 = 0;
			int v2 = 0;
			
			if(!pq.isEmpty())
				v1 = pq.poll();
			if(!pq.isEmpty())
				v2 = pq.poll();
			int result = v1 + v2 * 2;
			pq.add(result);
			min = pq.peek();
			ans++;
			
			if(min >= K) {
				flag = true;
				break;
			}
		}
		
		if(flag)
			return ans;
		else
			return -1;
    }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] scoville = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			scoville[i] = Integer.parseInt(st.nextToken());
		System.out.println(solution(scoville,K));
	}
}
