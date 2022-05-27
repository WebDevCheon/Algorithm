package Programmers;

public class 다트게임 {
	
	static class b {
		int front;
		int idx;
		public b(int front,int idx) {
			this.front = front;
			this.idx = idx;
		}
	}
	
	public static int solution(String dartResult) {
		int cnt = 0;
		int bonusCnt = 0;
		for(int i = 0;i < dartResult.length();i++) {
			if(dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T')
				cnt++;
			else if(dartResult.charAt(i) == '*' || dartResult.charAt(i) == '#')
				bonusCnt++;
		}
		int[] point = new int[cnt];
		char[] area = new char[cnt];
		b[] bonus = new b[bonusCnt];
		String num = "";
		int idx = 0;
		int bonusIdx = 0;
		for(int i = 0;i < dartResult.length();i++) {
			if(dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T') {
				point[idx] = Integer.valueOf(num);
				area[idx] = dartResult.charAt(i);
				num = "";
				idx++;
			} else if(dartResult.charAt(i) == '*' || dartResult.charAt(i) == '#') {
				bonus[bonusIdx] = new b(idx,i);
				bonusIdx++;
			} else
				num += dartResult.charAt(i);
		}
		bonusIdx = 0;
		
		for(int i = 0;i < cnt;i++) {
			if(area[i] == 'D')
				point[i] = point[i] * point[i];
			else if(area[i] == 'T' )
				point[i] = point[i] * point[i] * point[i];
			
			if(bonusCnt > bonusIdx && bonus[bonusIdx].front - 1 == i) {				// 1S2D*3T
				if(dartResult.charAt(bonus[bonusIdx].idx) == '*') {
					if(i > 0) {
						point[i] = point[i] * 2;
						point[i - 1] = point[i - 1] * 2;
					} else {
						point[0] = point[0] * 2;
					}
				} else if(dartResult.charAt(bonus[bonusIdx].idx) == '#') {
					point[i] = -1 * point[i];
				}
				bonusIdx++;
			}
		}
		int ans = 0;
		for(int i = 0;i < cnt;i++)
			ans += point[i];
		return ans;
    }
	
	public static void main(String[] args) throws Exception {
		System.out.println(solution("1S2D*3T"));
	}
}
