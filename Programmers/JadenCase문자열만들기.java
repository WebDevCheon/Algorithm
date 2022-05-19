package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class JadenCase문자열만들기 {
	
	public static String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        List<String> list = new ArrayList<String>();
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            str = str.toLowerCase();
            StringBuilder sb = new StringBuilder(str);
            if(sb.charAt(0) >= 97 && sb.charAt(0) <= 122)
            	sb.setCharAt(0,(char)(str.charAt(0) - 32));
            str = sb.toString();
            list.add(str);
        }
        String ans = list.get(0);
        for(int i = 1;i < list.size();i++)
        	ans += " " + list.get(i);
        System.out.println(ans.length());
        return ans;
    }
	
	public static void main(String[] args) throws Exception {
		System.out.println(solution("for               the"));
	}
}
