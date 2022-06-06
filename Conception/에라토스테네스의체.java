
public class 에라토스테네스의체 {
	
	private static boolean isPrime(long n) {		// 소수 판별법 -> 빠른 알고리즘
		if(n == 1)
			return false;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}
}
