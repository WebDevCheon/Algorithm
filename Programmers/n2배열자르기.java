package Programmers;

public class n2배열자르기 {
	
	
	public static int[] solution(int n,long left,long right) {
		long len = right - left + 1;
		int[] answer = new int[(int)len];
		int idx = 0;
		
		for(long i = left;i <= right;i++) {
			long k = i / n;
			long l = i % n;
			long num;
			
			if(k >= l)
				num = k;
			else
				num = l;
			num++;
			answer[idx++] = (int)num;
		}
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		int[] ans = solution(4,7,14);
		for(int i = 0;i < 8;i++)
			System.out.print(ans[i] + " ");
		
	}
}
