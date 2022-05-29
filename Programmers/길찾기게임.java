package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 길찾기게임 {
	
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int num;
		Node left;
		Node right;
		
		public Node(int x,int y,int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
		
		public int compareTo(Node otherNode) {
			if(this.y > otherNode.y)
				return -1;
			else if(this.y < otherNode.y)
				return 1;
			else {
				if(this.x < otherNode.x)
					return -1;
				else if(this.x > otherNode.x)
					return 1;
				return 0;
			}
		}
	}
	
	private static void PreOrder(Node curNode,ArrayList<Integer> list) {		// 루트 - L - R
		if(curNode == null)
			return;
		list.add(curNode.num);
		PreOrder(curNode.left,list);
		PreOrder(curNode.right,list);
	}
	
	private static void AfterOrder(Node curNode,ArrayList<Integer> list) {		// L - R - 루트
		if(curNode == null)
			return;
		AfterOrder(curNode.left,list);
		AfterOrder(curNode.right,list);
		list.add(curNode.num);
	}
	
	public static int[][] solution(int[][] nodeinfo) {
		int[][] answer = new int[2][nodeinfo.length];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		for(int i = 0;i < nodeinfo.length;i++) {
			Node node = new Node(nodeinfo[i][0],nodeinfo[i][1],i + 1);
			pq.add(node);
		}
		
		Node root = pq.poll();
		
		while(!pq.isEmpty()) {
			Node cur = root;
			Node next = pq.poll();
			
			while(true) {
				if(cur.x > next.x && cur.left == null) {
					cur.left = next;
					break;
				} else if(cur.x < next.x && cur.right == null) {
					cur.right = next;
					break;
				} else if(cur.x > next.x && cur.left != null)
					cur = cur.left;
				else if(cur.x < next.x && cur.right != null)
					cur = cur.right;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		PreOrder(root,list);			// 전위 순위
		for(int i = 0;i < list.size();i++)
			answer[0][i] = list.get(i);
		list = new ArrayList<Integer>();
		AfterOrder(root,list);		// 후위 순위
		for(int i = 0;i < list.size();i++)
			answer[1][i] = list.get(i);
		return answer;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// testcase
		int[][] nodeinfo = new int[9][2];
		for(int i = 0;i < 9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j < 2;j++)
				nodeinfo[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(nodeinfo));
	}
}
