package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 순위검색 {

	private static Map<String, ArrayList<Integer>> pointByStr = new HashMap<String, ArrayList<Integer>>();

	private static void dfs(int idx, String str, String[] splits) {
		if (idx == 4) {
			if(splits == null)
				pointByStr.put(str, new ArrayList<Integer>()); 
			else {
				int point = Integer.parseInt(splits[splits.length - 1]);
				ArrayList<Integer> points = pointByStr.get(str);
				points.add(point);
			}
			return;
		}

		if (splits == null) {
			if (idx == 0) {
				dfs(idx + 1, str + "cpp",null);
				dfs(idx + 1, str + "java",null);
				dfs(idx + 1, str + "python",null);
				dfs(idx + 1, str + "-",null);
			} else if (idx == 1) {
				dfs(idx + 1, str + "backend",null);
				dfs(idx + 1, str + "frontend",null);
				dfs(idx + 1, str + "-",null);
			} else if (idx == 2) {
				dfs(idx + 1, str + "junior",null);
				dfs(idx + 1, str + "senior",null);
				dfs(idx + 1, str + "-",null);
			} else {
				dfs(idx + 1, str + "chicken",null);
				dfs(idx + 1, str + "pizza",null);
				dfs(idx + 1, str + "-",null);
			}
		} else {
			dfs(idx + 1,str + splits[idx],splits);
			dfs(idx + 1,str + "-",splits);
		}
	}
	
	private static int lower_bound(ArrayList<Integer> pointList,int point) {
		int left = 0;
		int right = pointList.size() - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(pointList.get(mid) < point)
				left = mid + 1;
			else
				right = mid - 1;
		}
		if(left >= pointList.size())
			return 0;
		else {
			return (pointList.size() - left);
		}
	}

	public static int[] solution(String[] infoArr, String[] queryArr) {
		int[] ans = new int[queryArr.length];
		dfs(0, "", null);
		for (int i = 0; i < infoArr.length; i++) {
			String[] splits = infoArr[i].split(" ");
			dfs(0, "", splits);
		}
		
		Set<String> set = pointByStr.keySet();
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			String str = itr.next();
			Collections.sort(pointByStr.get(str));
		}
		
		for(int i = 0;i < queryArr.length;i++) {
			String[] splits = queryArr[i].split(" and ");
			String language = splits[0];
			String backOrFront = splits[1];
			String junOrSen = splits[2];
			String[] tmpSplits = splits[3].split(" ");
			String food = tmpSplits[0];
			int point = Integer.valueOf(tmpSplits[1]);
			ArrayList<Integer> pointList = pointByStr.get(language + backOrFront + junOrSen + food);	
			int selectNumber = lower_bound(pointList,point);
			ans[i] = selectNumber;
		}
		return ans;
	}
}
