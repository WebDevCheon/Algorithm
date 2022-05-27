package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리를지나는트럭 {

	 public static int solution(int bridge_length, int weight, int[] truck_weights) {
	        int ans = 0;
	        int len = bridge_length;
	        int w = weight;
	        int[] w_truck = truck_weights;
	        int idx = 0;
	        Queue<Integer> q = new LinkedList<Integer>();
	        int now_w = 0;
	        for(int i = 0;i < len;i++)
	        	q.add(0);
	        
	        while(!q.isEmpty()) {
	        	ans++;
	        	/*					 시간이 지남에 따라 알아보는 출력
	        	Queue<Integer> tmp = new LinkedList<Integer>();
	        	System.out.print(ans + "초 : ");
	        	while(!q.isEmpty()) {
	        		int k = q.poll();
	        		System.out.print(k + " ");
	        		tmp.add(k);
	        	}
	        	System.out.println();
	        	q = tmp;
	        	*/
	        	int what = q.poll();
	        	if(idx >= w_truck.length)
	        		continue;
	        	
	        	if(what > 0) {
	        		now_w -= what;					// 빼고
	        		if(now_w + w_truck[idx] <= w) {		// 1.넣고
	        			now_w += w_truck[idx];
	        			q.add(w_truck[idx++]);
	        		} else
	        			q.add(0);						
	        	} else {
	        		if(now_w + w_truck[idx] <= w) {			// 2.넣고
	        			now_w += w_truck[idx];
	        			q.add(w_truck[idx++]);
	        		} else
	        			q.add(0);
	        	}
	        }
	        return ans;
	 }
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int bridge_length = Integer.parseInt(br.readLine());
		int weight = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		int trucks = 0;
		while(st.hasMoreElements()) {
			trucks++;
			list.add(Integer.parseInt(st.nextToken()));
		}
		int[] truck_weights = new int[trucks];
		for(int i = 0;i < list.size();i++)
			truck_weights[i] = list.get(i);
		int ans = solution(bridge_length,weight,truck_weights);
		System.out.println(ans);
	}
}
