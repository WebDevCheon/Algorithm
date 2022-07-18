package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 배 {
	
	private static int[] crain;
	private static int n;
	private static ArrayList<Integer> weightList;
	private static int m;
	private static boolean[] visited;
	private static int maxCrain;
	private static int maxBox;
	
	private static int lower_bound(int w) {
		int left = 0;
		int right = crain.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(crain[mid] < w)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return left;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		crain = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i < n;i++) {
			crain[i] = Integer.parseInt(st.nextToken());
			maxCrain = Math.max(crain[i],maxCrain);
		}
		m = Integer.parseInt(br.readLine());
		weightList = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i < m;i++) {
			weightList.add(Integer.parseInt(st.nextToken()));
			maxBox = Math.max(weightList.get(i),maxBox);
		}
		
		Arrays.sort(crain);
		Collections.sort(weightList);
		
		if(maxCrain < maxBox) {
			System.out.println(-1);
			System.exit(0);
		}
		int ans = 0;

		while(true) {
			if(m == 0)
				break;
			visited = new boolean[n];		
			for(int i = weightList.size() - 1;i >= 0;i--) {
				int w = weightList.get(i);
				int idx = lower_bound(w);
				boolean check = false;		
				
				for(int j = idx;j < n;j++) {
					if(!visited[j]) {
						visited[j] = true;
						m--;
						check = true;
						break;
					}
				}
				if(check)
					weightList.remove(i);
			}
			ans++;
		}
		System.out.println(ans);
	}
}
