package Programmers;

class 최소직사각형 {
    public int solution(int[][] sizes) {
        int bigMax = 0;
        int smallMax = 0;
        int[] big = new int[sizes.length];
        int[] small = new int[sizes.length];
        
        for(int i = 0;i < sizes.length;i++) {
            big[i] = sizes[i][0] > sizes[i][1] ? sizes[i][0] : sizes[i][1];
            small[i] = sizes[i][0] > sizes[i][1] ? sizes[i][1] : sizes[i][0];
            bigMax = Math.max(big[i],bigMax);
            smallMax = Math.max(small[i],smallMax);
        }
        return bigMax * smallMax;
    }
}