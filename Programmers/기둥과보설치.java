package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 기둥과보설치 {
	
	private boolean[][] gi;		
	private boolean[][] bo;	
	private int n;
    	private int count;
    
	public boolean canDelete(int y,int x,int k) {    
        		for(int i = 0; i <= n; i++) { 
            			for(int j = 0; j <= n; j++) { 
                			if(gi[i][j] && checkGi(i, j))  
					return false; 
                			else if(bo[i][j] && checkBo(i, j)) 
					return false; 
            			}
        		}
        		return true;
    	}
    
   	private boolean checkGi(int y,int x) {
		if(y == 0) 
			return true;
		else if(y > 0 && gi[y - 1][x])
			return true;
		else if((x > 0 && bo[y][x - 1]) || bo[y][x])
			return true;
		return false;
	}
	
	private boolean checkBo(int y,int x) {
		if((y > 0 && gi[y - 1][x]) || (y > 0 && gi[y - 1][x + 1]))
			return true;
		else if((x > 0 && (bo[y][x - 1]) && bo[y][x + 1]))
			return true;
		return false;
	}
    
	public int[][] solution(int inputN, int[][] build_frame) {
		n = inputN;
		gi = new boolean[n + 1][n + 1];
		bo = new boolean[n + 1][n + 1];
		
		for(int i = 0;i < build_frame.length;i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int what = build_frame[i][2];
			int deleteOrMake = build_frame[i][3];
			
			if(deleteOrMake > 0) {  // 설치		
				if(what == 0) {	
					if(checkGi(y,x)) {
						gi[y][x] = true;	
						count++;
					}
				} else {
					if(checkBo(y,x)) {
						bo[y][x] = true;
						count++;
					}
				}
			} else {         // 삭제
				if(what == 0) {
					gi[y][x] = false;
					if(!canDelete(y,x,deleteOrMake))
						gi[y][x] = true;
					else
						count--;
				} else {		
					bo[y][x] = false;
					if(!canDelete(y,x,deleteOrMake))
						bo[y][x] = true;
					else
						count--;
				}
			}
		}
		
		int[][] ans = new int[count][3];
		int idx = 0;
		
		for(int j = 0;j <= n;j++) {
			for(int i = 0;i <= n;i++) {
				if(gi[i][j]) {          // 기둥
					ans[idx][0] = j;
					ans[idx][1] = i;
					ans[idx++][2] = 0;
				}
				if(bo[i][j]) {          // 보
					ans[idx][0] = j;
					ans[idx][1] = i;
					ans[idx++][2] = 1;
				}
			}
		}
		return ans;
    	}
}