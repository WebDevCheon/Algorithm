package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 로또의최고순위와최저순위 {
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int equalNum = 0;
        int n = 6;
        List<Integer> chkList = new ArrayList<Integer>();
        
        for(int i = 0;i < n;i++) {
            if(lottos[i] == 0) {
                chkList.add(i);
                continue;
            }
            for(int j = 0;j < n;j++) {
            	if(lottos[i] == win_nums[j])
            		equalNum++;
            }
        }
        int First = equalNum + chkList.size();
        int Last =  equalNum;
        int[] ans = new int[2];
        
        int f = 7 - First;
        if(f >= 6)
            ans[0] = 6;
        else
            ans[0] = f;
        
        int l = 7 - Last;
        if(l >= 6)
            ans[1] = 6;
        else
            ans[1] = l;
        
        for(int i = 0;i < 2;i++)
        	System.out.print(ans[i] + " ");
        return ans;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 6;
		int[] lottos = new int[n];
		int[] win_nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			lottos[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++)
			win_nums[i] = Integer.parseInt(st.nextToken());
		solution(lottos,win_nums);
	}	
}
