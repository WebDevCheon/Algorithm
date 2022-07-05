public class 투포인터 {

	private static void test_init(int[] arr) {
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 2;
		arr[5] = 5;
		arr[6] = 3;
		arr[7] = 1;
		arr[8] = 1;
		arr[9] = 2;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		test_init(arr);
		int start = 0;
		int end = 0;
		int m = 5;
		
		int sum = 0;
		
		while (true) {
            if (sum >= m)
                sum -= arr[start++];
            else if (end == arr.length)
                break;
            else
                sum += arr[end++];

            if (sum == m)
            	System.out.println(start + " " + end);
		}
	}
}
