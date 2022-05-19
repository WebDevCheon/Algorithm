package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
	
	private static PriorityQueue<disk> pq = new PriorityQueue<disk>();
	
	static class disk implements Comparable<disk> {
		int start;
		int cost;
		
		public disk(int start,int cost) {
			this.start = start; 
			this.cost = cost;
		}
		
		public int compareTo(disk otherDisk) {
			if(this.start < otherDisk.start)
				return -1;
			else if(this.start > otherDisk.start)
				return 1;
			else {
				if(this.cost < otherDisk.cost)
					return -1;
				else if(this.cost > otherDisk.cost)
					return 1;
				else
					 return 0;
			}
		}
	}
	
	public static int solution(int[][] jobs) {
		int n = jobs.length;
		
		for(int i = 0;i < n;i++) {
			int start = jobs[i][0];
			int cost = jobs[i][1];
			pq.add(new disk(start,cost));
		}
		
		int ans = 0;
		int time = 0;
		disk d = pq.poll();
		time += (d.start + d.cost);
		ans += d.cost;
		
		while(!pq.isEmpty()) {
			ArrayList<disk> tmpList = new ArrayList<disk>();
			
			while(!pq.isEmpty()) {
				disk tmpDisk = pq.poll();
				if(tmpDisk.start <= time)
					tmpList.add(tmpDisk);
				else {
					pq.add(tmpDisk);
					break;
				}
			}
			
			if(tmpList.size() == 0) {
				d = pq.poll();
				time = d.start;
				ans += d.cost;
				time += d.cost;
			} else {
				Collections.sort(tmpList,new Comparator<disk>() {
					public int compare(disk d1,disk d2) {
						return d1.cost - d2.cost;
					}
				});
				disk selDisk = tmpList.remove(0);
				ans += (time - selDisk.start + selDisk.cost);
				time += selDisk.cost;
				pq.addAll(tmpList);
			}
		}
		return ans / n;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] jobs = new int[3][2];
		jobs[0][0] = 0;
		jobs[0][1] = 3;
		jobs[1][0] = 1;
		jobs[1][1] = 9;
		jobs[2][0] = 2;
		jobs[2][1] = 6;
		System.out.println("answer : " + solution(jobs));
	}	
}
