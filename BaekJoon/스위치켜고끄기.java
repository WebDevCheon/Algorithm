package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int mw = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			switch (mw) {
				case 1:
					for (int j = num; j <= n; j += num)
						arr[j] = 1 - arr[j];
					break;
				case 2:
					int diff = 1;
					while (num - diff >= 1 && num + diff <= n && arr[num - diff] == arr[num + diff])
						diff++;
					int start = num - (diff - 1);
					int end = num + (diff - 1);
					for (int j = start; j <= end; j++)
						arr[j] = 1 - arr[j];
			}
		}
		
		for(int i = 1;i <= n;i++) {
			if(i % 20 == 0) {
				System.out.print(arr[i]);
				System.out.println();
				continue;
			}
			System.out.print(arr[i] + " ");
		}
	}
}
