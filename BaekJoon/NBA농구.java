package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class NBA농구 {

	private static int a;
	private static int b;
	private static int aTime;
	private static int bTime;
	private static int before;
	
	private static void print() {
		if(aTime / 60 < 10)
			System.out.print("0" + aTime / 60 + ":");
		else
			System.out.print(aTime / 60 + ":");
		
		if(aTime % 60 < 10)
			System.out.println("0" + aTime % 60);
		else
			System.out.println(aTime % 60);
		
		if(bTime / 60 < 10)
			System.out.print("0" + bTime / 60 + ":");
		else
			System.out.print(bTime / 60 + ":");
			
		if(bTime % 60 < 10)
			System.out.println("0" + bTime % 60);
		else
			System.out.println(bTime % 60);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken());
			String[] num = st.nextToken().split(":");
			int hour = Integer.valueOf(num[0]);
			int minute = Integer.valueOf(num[1]);
			int time = hour * 60 + minute;
			
			if(team == 1) {
				a++;
				if(a == b)
					bTime += (time - before);
				else if(a == b + 1)
					before = time;
			} else if(team == 2) {
				b++;
				if(a == b)
					aTime += (time - before);
				else if(a + 1 == b)
					before = time;
			}
		}
			
		if(a > b)
			aTime += (60 * 48 - before);
		else if(a < b)
			bTime += (60 * 48 - before);
		print();
	}
}
