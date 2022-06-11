package Programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 오픈채팅방 {
	
	static class rec {
		String msg;
		String uid;
		
		public rec(String msg,String uid) {
			this.msg = msg;
			this.uid = uid;
		}
	}
	
	public static String[] solution(String[] record) {
		Map<String,String> nickById = new HashMap<String,String>();
		Queue<rec> q = new LinkedList<rec>();
		
		for(int i = 0; i < record.length;i++) {
			String[] input = record[i].split(" ");
			switch(input[0]) {
				case "Enter" :
					String id = input[1];
					String nickname = input[2];
					nickById.put(id,nickname);
					q.add(new rec("Enter",id));
					break;
				case "Leave" :
					id = input[1];
					q.add(new rec("Leave",id));
					break;
				default :
					id = input[1];
					nickname = input[2];
					nickById.put(id,nickname);
			}
		}
		String[] ans = new String[q.size()];
		int idx = 0;
		while(!q.isEmpty()) {
			rec req = q.poll();
			String msg = req.msg;
			String uid = req.uid;
			if(msg.equals("Enter"))
				ans[idx++] = nickById.get(uid) + "님이 들어왔습니다.";
			else
				ans[idx++] = nickById.get(uid) + "님이 나갔습니다.";
		}
		return ans;
	}
}
