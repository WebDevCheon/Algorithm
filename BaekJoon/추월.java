package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 추월 {

	private static int n;
	private static int ans;
	private static String[] in;
	private static String[] out;
	private static Map<String,Integer> idxOut = new HashMap<String,Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new String[n];
		out = new String[n];
		for (int i = 0; i < n; i++)
			in[i] = br.readLine();
		for (int i = 0; i < n; i++) {
			out[i] = br.readLine();
			idxOut.put(out[i],i);
		}

		for (int i = n - 1; i >= 1; i--) {
			Set<String> front = new HashSet<String>();
			for(int j = i - 1;j >= 0;j--)
				front.add(in[j]);
			String name = in[i];
			int outIdx = idxOut.get(name);
			boolean isExist = false;
			for(int j = outIdx + 1;j < n;j++) {
				if(front.contains(out[j])) {
					isExist = true;
					break;
				}
			}
			if(isExist)
				ans++;
		}
		System.out.println(ans);
	}
}
