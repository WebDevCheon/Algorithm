package Programmers;

public class 다음큰숫자 {
	
	private static int OneBigNum(int n) {
        int ans = 0;
        while(n > 0) {
            if(n % 2 == 1)
                ans++;
            n /= 2;
        }
        return ans;
    }
    
    public static int solution(int n) {
        int k = OneBigNum(n);
        int nextBigNum = -1;
        for(int i = n + 1;;i++) {
            if(OneBigNum(i) == k) {
                nextBigNum = i;
                break;
            }
        }
        return nextBigNum;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(15));
	}
}
