package Programmers;

public class 2개이하로다른비트 {

	public static long[] solution(long[] arr) {
		long[] ans = new long[arr.length];
		
		for(int i = 0;i < arr.length;i++) {
			long n = arr[i];
			if(n % 2 == 0) {
				ans[i] = n + 1;
			} else {
				String binary1 = Long.toBinaryString(n);
				String binary2 = Long.toBinaryString(n + 1);
				if(binary1.length() < binary2.length()) {
					while(binary1.length() < binary2.length())
						binary1 = "0" + binary1;
				} else if(binary1.length() > binary2.length()) {
					while(binary1.length() > binary2.length())
						binary2 = "0" + binary2;
				}
				int k = 0;
				for(int j = 0;j < binary1.length();j++) {
					if(binary1.charAt(j) != binary2.charAt(j))
						k++;
				}
				if(k <= 2)
					ans[i] = n + 1;
				else {
					StringBuilder sb = new StringBuilder(binary2);
					for(int j = binary2.length() - 1;j >= 0;j--) {
						if(binary2.charAt(j) == '0') {
							sb.setCharAt(j,'1');
							k--;
							if(k == 2)
								break;
						}
					}
					long sum = 0;
					int idx = 0;
					for(int j = sb.length() - 1;j >= 0;j--) {
						if(sb.charAt(j) == '1')
							sum += Math.pow(2,idx);
						idx++;
					}
					ans[i] = sum;
				}
			}
		}
		return ans;
	}
}
