import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 표편집 {

	static class Node {
		int num;
		Node prev;
		Node next;
		boolean isDelete;

		public Node(int num, Node prev, Node next) {
			this.num = num;
			this.prev = prev;
			this.next = next;
		}
	}

	public static String solution(int n, int k, String[] cmd) {
		boolean[] ansArr = new boolean[n];
		Node pointer = null;
		Node root = new Node(0, null, null);
		Node curNode = root;

		for (int i = 1; i < n; i++) {
			Node node = new Node(i, null, null);
			curNode.next = node;
			node.prev = curNode;
			curNode = node;
			if (curNode.num == k)
				pointer = curNode;
		}

		// for문 이후 curNode는 마지막 노드를 가리킴
		Stack<Node> stk = new Stack<Node>();

		for (int i = 0; i < cmd.length; i++) {
			StringTokenizer st = new StringTokenizer(cmd[i]);
			switch (st.nextToken()) {
				case "D":
					int move = Integer.parseInt(st.nextToken());
					while (move-- > 0)
						pointer = pointer.next;
					break;
				case "U":
					move = Integer.parseInt(st.nextToken());
					while (move-- > 0)
						pointer = pointer.prev;
					break;
				case "C":
					ansArr[pointer.num] = true;
					
					if (pointer.next != null) {			// 마지막이 아닐때
						if (pointer.prev != null)
							pointer.prev.next = pointer.next;
						if (pointer.next != null)
							pointer.next.prev = pointer.prev;
						stk.push(pointer);
						pointer = pointer.next;
					} else {							// 마지막을 가리킬때
						if (pointer.prev != null) {
							pointer.prev.next = null;
							stk.push(pointer);
							pointer = pointer.prev;
						}
					}	
					break;
			case "Z":
				Node backNode = stk.pop();
				ansArr[backNode.num] = false;
				if (backNode.prev != null)
					backNode.prev.next = backNode;
				if (backNode.next != null)
					backNode.next.prev = backNode;
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (ansArr[i])
				sb.append("X");
			else
				sb.append("O");
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* Test 
		int n = 8;
		int k = 2;
		int m = Integer.parseInt(br.readLine());
		String[] cmd = new String[m];
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			cmd[i] = str;
		}
		System.out.println(solution(n, k, cmd));
		*/
	}
}
