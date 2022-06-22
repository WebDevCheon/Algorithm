package Programmers;

public class JadenCase문자열만들기 {

	public String solution(String s) {
		String[] splits = s.split(" ",-1);
		String ans = "";
        
		for (int i = 0; i < splits.length; i++) {
			String str = splits[i];
			if (str.length() == 0) {
				if (i < splits.length - 1)
					ans += " ";
			} else if (str.charAt(0) != ' ') {
				str = str.toLowerCase();
				StringBuilder sb = new StringBuilder(str);
				if (str.charAt(0) >= 97 && str.charAt(0) <= 122)
					sb.setCharAt(0, (char)(str.charAt(0) - 32));
				
				if (i < splits.length - 1)
					ans += sb.toString() + " ";
				else
					ans += sb.toString();
			}
		}
		return ans;
    }
}
