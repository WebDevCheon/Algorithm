package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ����Ʈ {	
	
	public static int solution(int[] people,int limit) {			// �ִ��� limit�� �����ϰ� 2���� ����ֱ�
		ArrayList<Integer> wList = new ArrayList<Integer>();
		for(int i = 0;i < people.length;i++)
			wList.add(people[i]);
		Collections.sort(wList);
			
		boolean[] used = new boolean[wList.size()];
		int ans = 0;
		int left = 0;
		int right = wList.size() - 1;
		
		while(left < right) {
			if(wList.get(left) + wList.get(right) <= limit) {
				used[left] = used[right] = true;
				ans++;
				left++;
				right--;
			} else
				right--;
		}
		
		for(int i = 0;i < used.length;i++) {
			if(!used[i])
				ans++;
		}
		return ans;
	}
}
