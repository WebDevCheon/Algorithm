package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
	
	static class print {
		int prior;

		public print(int prior) {
			this.prior = prior;
		}
	}
	
	public static int solution(int[] priorities,int location) {
		ArrayList<Integer> priorList = new ArrayList<Integer>();
		Queue<print> q = new LinkedList<print>();
		print target = null;
		for(int i = 0;i < priorities.length;i++) {
			int prior = priorities[i];
			print p = new print(prior);
			if(location == i)
				target = p;
			q.add(p);
			priorList.add(prior);
		}
		Collections.sort(priorList,Collections.reverseOrder());
		
		int ans = 1;

		while(true) {
			print p = q.poll();
			
			if(p.prior == priorList.get(0)) {
				if(p == target)
					break;
				else {
					priorList.remove(0);
					ans++;
				}
			} else {
				q.add(p);
			}
		}
		return ans;
	}
}
