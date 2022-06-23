package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 숫자게임 {
	
	private static int upper_bound(ArrayList<Integer> bList,int data) {
		int left = 0;
		int right = bList.size() - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(bList.get(mid) <= data)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return left;
	}
	
	public static int solution(int[] A, int[] B) {	
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        ArrayList<Integer> bList = new ArrayList<Integer>();
        int n = A.length;
        for(int i = 0;i < n;i++)
        	bList.add(B[i]);
        
        for(int i = 0;i < n;i++) {
        	int idx = upper_bound(bList,A[i]);
        	if(idx == bList.size())
        		bList.remove(0);
        	else {
        		bList.remove(idx);
        		answer++;
        	}
        }
        return answer;
    }
}
