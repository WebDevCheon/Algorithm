package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class 후보추천하기 {
	
	static class info implements Comparable<info> {
		int idx;
		int num;
		int vote;
		
		public info(int idx,int num,int vote) {
			this.idx = idx;
			this.num = num;
			this.vote = vote;
		}

		@Override
		public int compareTo(info otherInfo) {
			if(this.vote < otherInfo.vote)
				return -1;
			else if(this.vote > otherInfo.vote)
				return 1;
			else {
				if(this.idx < otherInfo.idx)
					return -1;
				return 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<info> pq = new PriorityQueue<info>();
		Set<Integer> set = new HashSet<Integer>();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = 0;
		
		for(int i = 0;i < m;i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(set.contains(num)) {
				PriorityQueue<info> tmp = new PriorityQueue<info>();
				info target = null;
				while(true) {
					info inf = pq.poll();
					if(inf.num == num) {
						target = inf;
						break;
					}
					tmp.add(inf);
				}
				target.vote = target.vote + 1;
				tmp.add(target);
				while(!pq.isEmpty())
					tmp.add(pq.poll());
				pq = tmp;
				continue;
			}
			
			set.add(num);
			if(pq.size() < n) {
				pq.add(new info(idx++,num,1));
			} else if(pq.size() == n) {
				info inf = pq.poll();
				set.remove(inf.num);
				pq.add(new info(idx++,num,1));
			}
		}
		
		ArrayList<Integer> ansList = new ArrayList<Integer>();
		while(!pq.isEmpty())
			ansList.add(pq.poll().num);
		Collections.sort(ansList);
		for(int ans : ansList)
			bw.write(ans + " ");
		
		bw.flush();
		br.close();
		bw.close();
	}
}
