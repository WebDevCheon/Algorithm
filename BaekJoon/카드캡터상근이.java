package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 카드캡터상근이 {

	private static int n;
	private static List<Integer> s = new ArrayList<Integer>();
	private static List<Integer> g = new ArrayList<Integer>();
	private static List<Integer> cardList = new ArrayList<Integer>();
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[2 * n + 1];
		for (int i = 0; i < n; i++) {
			int c = Integer.parseInt(br.readLine());
			visited[c] = true;
			s.add(c);
		}

		for (int i = 1; i <= 2 * n; i++) {
			if (!visited[i])
				g.add(i);
		}
		visited = null;
		Collections.sort(s);
		Collections.sort(g);

		boolean sTurn = true;

		while (!s.isEmpty() && !g.isEmpty()) {
			
			if (sTurn) {
				if (cardList.isEmpty()) {
					cardList.add(s.remove(0));
				} else {
					int num = cardList.get(cardList.size() - 1);
					int pCard = 0;
					int idx = -1;
					for (int i = 0; i < s.size(); i++) {
						if (s.get(i) > num) {
							pCard = s.get(i);
							idx = i;
							break;
						}
					}
					if (pCard == 0)
						cardList.clear();
					else
						cardList.add(s.remove(idx));
				}
			} else {
				if (cardList.isEmpty()) {
					cardList.add(g.remove(0));
				} else {
					int num = cardList.get(cardList.size() - 1);
					int pCard = 0;
					int idx = -1;
					for (int i = 0; i < g.size(); i++) {
						if (g.get(i) > num) {
							pCard = g.get(i);
							idx = i;
							break;
						}
					}
					if (pCard == 0)
						cardList.clear();
					else
						cardList.add(g.remove(idx));
				}
			}
			if(sTurn)
				sTurn = false;
			else
				sTurn = true;
		}
		int sPoint = 0;
		int gPoint = 0;
		if(s.size() == 0)
			sPoint += g.size();
		else
			gPoint += s.size();
		
		System.out.println(sPoint);		
		System.out.println(gPoint);		
	}
}
