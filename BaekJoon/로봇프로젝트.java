package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 로봇프로젝트 {

	static class ans implements Comparable<ans> {
		int l1;
		int l2;

		public ans(int l1, int l2) {
			this.l1 = l1;
			this.l2 = l2;
		}

		@Override
		public int compareTo(ans otherAns) {
			if (Math.abs(this.l1 - this.l2) >= Math.abs(otherAns.l1 - otherAns.l2))
				return -1;
			return 1;
		}
	}

	private static int lower_bound(List<Integer> list, int w, int start) {
		int left = 0;
		int right = list.size() - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (list.get(mid) < w)
				left = mid + 1;
			else
				right = mid - 1;
		}

		if (left >= list.size() || list.get(left) != w || left == start)
			return -1;
		else {
			return left;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		while ((str = br.readLine()) != null) {
			int x = Integer.parseInt(str) * 10000000;
			int n = Integer.parseInt(br.readLine());
			List<Integer> list = new ArrayList<Integer>();
			List<ans> ansList = new ArrayList<ans>();

			for (int i = 0; i < n; i++)
				list.add(Integer.parseInt(br.readLine()));

			Collections.sort(list);

			for (int i = 0; i < list.size(); i++) {
				int idx = lower_bound(list, x - list.get(i), i);

				if (idx != -1) {
					if (list.get(idx) >= list.get(i))
						ansList.add(new ans(list.get(i), list.get(idx)));
					else
						ansList.add(new ans(list.get(idx), list.get(i)));
				}
			}

			if (ansList.size() == 0) {
				System.out.println("danger");
			} else {
				Collections.sort(ansList);
				ans a = ansList.get(0);
				System.out.println("yes " + a.l1 + " " + a.l2);
			}
		}
	}
}
