package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 표편집 {
	
	static class erase {
		int idx;
		
		public erase(int idx) {
			this.idx = idx;
		}
	}
	
	public static String solution(int n, int k, String[] cmd) {
		Stack<erase> stk = new Stack<erase>();
		int cntidx = k;
		int size = n;
		
		for(int i = 0;i < cmd.length;i++) {
			String cmdIdx = cmd[i];
			StringTokenizer st = new StringTokenizer(cmdIdx);
			String control = st.nextToken();
			System.out.print(cntidx + " ");
			if(control.equals("D")) {
				int move = Integer.parseInt(st.nextToken());
				cntidx += move;
			} else if(control.equals("U")) {
				int move = Integer.parseInt(st.nextToken());
				cntidx -= move;
			} else if(control.equals("C")) {
				stk.push(new erase(cntidx));
				if(cntidx == size - 1)
					cntidx--;
				size--;
			} else if(control.equals("Z")) {
				if(stk.isEmpty())
					continue;
				erase poped_stk = stk.pop();
				int idx = poped_stk.idx;
				if(idx <= cntidx) {
					size++;
					cntidx++;
				} else if(idx > cntidx) 
					size++;
			}
		}
		String ans = "";
		for(int i = 0;i < n;i++)
			ans += "O";
		StringBuilder sb = null;
		while(!stk.isEmpty()) {
			erase e = stk.pop();
			sb = new StringBuilder(ans);
			System.out.println(e.idx);
			sb.setCharAt(e.idx,'X');
			ans = sb.toString();
		}
		ans = sb.toString();
		return ans;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String[] cmd = new String[9];
		for(int i = 0;i < cmd.length;i++) {
			st = new StringTokenizer(br.readLine());
			String control = st.nextToken();
			switch(control) {
				case "D" :
					int Dmove = Integer.parseInt(st.nextToken());
					cmd[i] = control + " " + Dmove;
					break;
				case "C" :
					cmd[i] = control;
					break;
				case "U" :
					int Umove = Integer.parseInt(st.nextToken());
					cmd[i] = control + " " + Umove;
					break;
				case "Z" :
					cmd[i] = control;
					break;
				default :
					break;
			}
		}
		System.out.println(solution(n,k,cmd));
	}
}
