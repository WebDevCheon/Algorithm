package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N개의최소공배수 {
	
	private static int[] k = new int[101];
    
    private static void check(int n) {
        int[] arr = new int[101];
        List<Integer> list = new ArrayList<Integer>();
        while(n > 1) {
            for(int i = 2;i <= n;i++) {
                if(n % i == 0) {
                    n /= i;
                    arr[i]++;
                    if(!list.contains(i))
                        list.add(i);
                    break;
                }
            }
        }
        for(int i = 0;i < list.size();i++) {
            int tmp = list.get(i);
            k[tmp] = Math.max(arr[tmp],k[tmp]);
        }
    }
    
    public static int solution(int[] arr) {
        for(int i = 0;i < arr.length;i++) {
            check(arr[i]);
        }
        int ans = 1;
        for(int i = 1;i < 101;i++) {
        	if(k[i] > 0)
        		ans *= Math.pow(i,k[i]);
        }
        return ans;
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < arr.length;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		solution(arr);
		
	}
}
