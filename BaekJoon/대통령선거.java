package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 대통령선거 {

	static class candidate {
		int num;
		int p;
		public candidate(int num,int p) {
			this.num = num;
			this.p = p;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());		// 후보자
			int v = Integer.parseInt(st.nextToken());		// 유권자
			
			int c1 = -1;
			int c2 = -1;
			ArrayList<Integer>[] list = new ArrayList[v];		// 유권자의 선호도
			
			for(int i = 0;i < v;i++)
				list[i] = new ArrayList<Integer>();
			
			for(int i = 0;i < v;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j < c;j++)
					list[i].add(Integer.parseInt(st.nextToken()));		// 유권자에 따라서 선호도 순으로 저장 : 0 ~ v-1번 유권자
			}
			
			if(c == 1) {
				System.out.println(1 + " " + 1);
				continue;
			}
			
			ArrayList<candidate> candi = new ArrayList<candidate>();		// 후보자의 투표수

			for(int i = 1;i < c + 1;i++)
				candi.add(new candidate(i,0));		// 1번~c번 후보자를 리스트에 저장 대신,Index 0번 : 1번 후보자,Index 1번 : 2번 후보자.....
			
			for(int i = 1;i < 3;i++) {
				if(i == 1) {
					
					for(int j = 0;j < v;j++)
						candi.get(list[j].get(0) - 1).p++;
					
					Collections.sort(candi,new Comparator<candidate>() {
						public int compare(candidate c1,candidate c2) {
							if(c1.p > c2.p)
								return -1;
							else if(c1.p < c2.p)
								return 1;
							else
								return 0;
						}
					});
					
					if(candi.get(0).p > v / 2) {
						System.out.println(candi.get(0).num + " " + i);
						break;
					}
 				} else {
 					c1 = candi.get(0).num;
 					c2 = candi.get(1).num;
 					int vote1 = 0;
 					int vote2 = 0;
 					
 					for(int j = 0;j < v;j++) {
 						ArrayList<Integer> voteArr = list[j];
 						for(int k = 0;k < voteArr.size();k++) {
 							int num = voteArr.get(k);
 							
 							if(num == c1) {
 								vote1++;
 								break;
 							} else if(num == c2) {
 								vote2++;
 								break;
 							}
 						}
 					}
 					if(vote1 > vote2)
 						System.out.println(c1 + " " + i);
 					else if(vote2 > vote1)
 						System.out.println(c2 + " " + i);
 				}
			}
			
			
		}
		
	}
}
