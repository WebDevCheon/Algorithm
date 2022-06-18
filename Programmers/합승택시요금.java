package Programmers;

public class 합승택시요금 {
	
	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int[][] dist = new int[n + 1][n + 1];

        for(int i = 1;i <= n;i++) {
        	for(int j = 1;j <= n;j++) {
        		if(i == j) {
        			dist[i][j] = 0;
        			continue;
        		}
        		dist[i][j] = 50000000;
        	}
        }
        
        for(int i = 0;i < fares.length;i++) {
            int v1 = fares[i][0];
            int v2 = fares[i][1];
            int d = fares[i][2];
            dist[v1][v2] = dist[v2][v1] = d;
        }
        
        for(int k = 1;k <= n;k++) {
        	for(int i = 1;i <= n;i++) {
        		for(int j = 1;j <= n;j++) {
        			if(dist[i][j] > dist[i][k] + dist[k][j])
        				dist[i][j] = dist[i][k] + dist[k][j];
        		}
        	}
        }
        int max = Integer.MAX_VALUE;

        for(int i = 1;i <= n;i++) {
        	int sum = dist[s][i] + dist[i][a] + dist[i][b];
        	max = Math.min(max,sum);
        }
        return max;
    }
}
