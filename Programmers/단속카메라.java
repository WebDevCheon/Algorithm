package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 단속카메라 {
	
	static class car implements Comparable<car> {
		int in;
		int out;
		
		public car(int in,int out) {
			this.in = in;
			this.out = out;
		}
		
		public int compareTo(car otherCar) {
			return (this.out - otherCar.out);
		}
	}
	
	public static int solution(int[][] routes) {	
		int answer = 1;
		car[] cars = new car[routes.length];
		for(int i = 0;i < routes.length;i++)
			cars[i] = new car(routes[i][0],routes[i][1]);
		Arrays.sort(cars);
		int location = cars[0].out;
		
		for(int i = 1;i < cars.length;i++) {
			if(location < cars[i].in) {
				answer++;
				location = cars[i].out;
			}
		}
		return answer;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] routes = new int[n][2];
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			routes[i][0] = Integer.parseInt(st.nextToken());
			routes[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(routes));
	}
}
