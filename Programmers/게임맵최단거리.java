package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게임맵최단거리 {

    private static int[][] map = new int[5][5];
    private static int[][] dist = new int[5][5];
    private static boolean[][] visited = new boolean[5][5];
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static int n = 5;
    
    static class pos {
        int x;
        int y;
        
        public pos(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static void init(int[][] input) {
        for(int i = 0;i < n;i++)
            for(int j = 0;j < n;j++)
                map[i][j] = input[i][j];
    }
    
    private static boolean isRange(int y,int x){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
    
    private static int bfs(int y,int x) {
        Queue<pos> q = new LinkedList<pos>();
        q.add(new pos(x,y));
        visited[y][x] = true;
        
        while(!q.isEmpty()){
            pos p = q.poll();
            for(int i = 0;i < dx.length;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(!isRange(ny,nx) || visited[ny][nx] || map[ny][nx] == 0)
                    continue;
                visited[ny][nx] = true;
                dist[ny][nx] = dist[p.y][p.x] + 1;
                q.add(new pos(nx,ny));
            }
        }
        return (dist[n-1][n-1] + 1);
    }
    
    public static int solution(int[][] input) {
        init(input);
        int ans = (bfs(0,0) == 1) ? -1 : dist[n-1][n-1] + 1;
        return ans;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j < n;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		solution(map);
	}
}
