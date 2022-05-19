package Programmers;

import java.util.Arrays;

public class K¹øÂ°¼ö {
	
	public static int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] ans = new int[n];
        int tmp = 0;
        while(tmp < n) {
            int startIdx = commands[tmp][0] - 1;
            int endIdx = commands[tmp][1] - 1;
            int ansIdx = commands[tmp][2] - 1;
            int[] tmparr = new int[endIdx-startIdx+1];
            for(int i = startIdx,j = 0;i <= endIdx;i++,j++)
                tmparr[j] = array[i];
            Arrays.sort(tmparr);
            ans[tmp++] = tmparr[ansIdx];
        }
        return ans;
    }
	
	public static void main(String[] args) throws Exception {
		int[] array = new int[] {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		int[] ans = solution(array,commands);
		for(int i = 0;i < ans.length;i++)
			System.out.print(ans[i] + " ");
	}
}
