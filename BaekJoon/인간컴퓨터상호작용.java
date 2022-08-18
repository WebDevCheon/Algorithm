package 백준문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 인간컴퓨터상호작용 {

	private static int[][] cnt;
	private static String str;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		str = br.readLine();
		cnt = new int[26][str.length() + 1];
		for(int i = 1;i <= str.length();i++) {
			for(int j = 'a';j <= 'z';j++) {
				if(str.charAt(i - 1) == (char)j)
					cnt[j - 'a'][i] = cnt[j - 'a'][i - 1] + 1;
				else
					cnt[j - 'a'][i] = cnt[j - 'a'][i - 1];
			}
		}
		
		int q = Integer.parseInt(br.readLine());
		while(q-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char alpha = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(cnt[alpha - 'a'][b + 1] - cnt[alpha - 'a'][a] + "\n");
		}
		bw.flush();
	}
}
