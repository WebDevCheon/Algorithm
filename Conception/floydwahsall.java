public class floydwashall {

	static class Graph {
	    private int n;           //노드들의 수
	    private int dist[][];    //노드들간의 가중치 저장할 변수
	 
	    public Graph(int n){
	        this.n = n;
	        dist = new int[n+1][n+1];
	    }
	    
	    public void input(int i,int j,int w){
	    	dist[i][j] = w;
	    	dist[j][i] = w;
	    }
	    
	    public void floyd() {
	    	int[][] dist = new int[n + 1][n + 1];
	    	
	    	for(int i = 1;i <= n;i++) {
	    		for(int j = 1;j <= n;j++) {
	    			if(i == j) {
	    				dist[i][j] = 0;
	    				continue;
	    			}
	    			dist[i][j] = 1000000000;
	    		}
	    	}
	    	
	    	for(int k = 1;k < n + 1;k++) {
	    		for(int i = 1;i < n + 1;i++) {
	    			for(int j = 1;j < n + 1;j++) {
	    				if(dist[i][j] > dist[i][k] + dist[k][j])
	    					dist[i][j] = dist[i][k] + dist[k][j];
	    			}
	    		}
	    	}
	    	
	    	for(int i = 1;i <= n;i++) {
	    		for(int j = 1;j <= n;j++)
	    			System.out.print(dist[i][j] + " ");
	    		System.out.println();
	    	}
	    }
	}


	public static void main(String[] args) throws Exception {
		Graph g = new Graph(8);
        g.input(1, 2, 3);
        g.input(1, 5, 4);
        g.input(1, 4, 4);
        g.input(2, 3, 2);
        g.input(3, 4, 1);
        g.input(4, 5, 2);
        g.input(5, 6, 4);
        g.input(4, 7, 6);
        g.input(7, 6, 3);
        g.input(3, 8, 3);
        g.input(6, 8, 2);
        g.floyd();
	}
}
