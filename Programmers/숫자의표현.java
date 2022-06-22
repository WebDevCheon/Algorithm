package Programmers;

public class 숫자의표현 {
	
	public static int solution(int n) {
        int ans = 0;
        
        for(int i = 1;i <= n;i++) {
            int sum = i;
            boolean flag = false;
            for(int j = i + 1;j <= n;j++){
                sum += j;
                if(sum > n)
                    break;
                if(sum == n) {
                    flag = true;
                    break;
                }
            }
            if(flag)
            	ans++;
        }
        return ans + 1;
    }

}
